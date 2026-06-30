package visitors;

import ast.core.*;
import ast.css.CssDocumentNode;
import ast.css.CssRuleNode;
import ast.css.CssSelectorNode;
import ast.html.HtmlAttributeNode;
import ast.html.HtmlDocumentNode;
import ast.html.HtmlTagNode;
import ast.jinja.*;
import ast.python.*;
import table.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class DefinitionVisitor implements ASTVisitor<Void> {

    private final SymbolTable symbolTable;
    private final LabelTable labelTable;

    private boolean inPythonFunction = false;

    private Scope lastFunctionScope = null;

    // Track function context for parser workaround (global statement breaks AST)
    private Stack<FunctionContext> functionStack = new Stack<>();

    private static class FunctionContext {
        String name;
        int startLine;
        int endLine;
        Scope scope;

        FunctionContext(String name, int startLine, Scope scope) {
            this.name = name;
            this.startLine = startLine;
            this.scope = scope;
            this.endLine = 0; // Will be set on exit
        }
    }

    public DefinitionVisitor(SymbolTable symbolTable, LabelTable labelTable) {
        this.symbolTable = symbolTable;
        this.labelTable = labelTable;
    }

    // Check if a line falls within current function context
    private boolean isInsideCurrentFunction(int line) {
        if (functionStack.isEmpty()) return false;
        FunctionContext ctx = functionStack.peek();
        if (ctx.endLine == 0) return line >= ctx.startLine;
        return line >= ctx.startLine && line <= ctx.endLine;
    }

    private Type inferType(ASTNode node) {
        if (node == null) return Type.UNKNOWN;

        if (node instanceof NumberLiteralNode) {
            return Type.INT;
        } else if (node instanceof StringLiteralNode) {
            return Type.STRING;
        } else if (node instanceof BooleanLiteralNode) {
            return Type.BOOL;
        } else if (node instanceof NullLiteralNode) {
            return Type.NULL;
        } else if (node instanceof ListNode) {
            return Type.LIST;
        } else if (node instanceof DictNode) {
            return Type.DICT;
        } else if (node instanceof IdentifierNode id) {
            Symbol sym = symbolTable.resolve(id.getName());
            return sym != null ? sym.getType() : Type.UNKNOWN;
        } else if (node instanceof BinaryExpressionNode bin) {
            String op = bin.getOperator();
            if (op.equals("+") || op.equals("-") || op.equals("*") || op.equals("/") ||
                    op.equals("//") || op.equals("%") || op.equals("**")) {
                Type left = inferType(bin.getLeft());
                Type right = inferType(bin.getRight());
                if (left == Type.STRING || right == Type.STRING) return Type.STRING;
                return Type.INT;
            } else if (op.equals("==") || op.equals("!=") || op.equals("<") || op.equals(">") ||
                    op.equals("<=") || op.equals(">=") || op.equals("is") || op.equals("in")) {
                return Type.BOOL;
            } else if (op.equals("and") || op.equals("or") || op.equals("&&") || op.equals("||")) {
                return Type.BOOL;
            } else if (op.equals(".")) {
                return Type.UNKNOWN;
            }
            return Type.UNKNOWN;
        } else if (node instanceof UnaryExpressionNode un) {
            String op = un.getOperator();
            if (op.equals("not") || op.equals("!")) return Type.BOOL;
            if (op.equals("-") || op.equals("+")) return Type.INT;
            return Type.UNKNOWN;
        } else if (node instanceof ComparisonNode) {
            return Type.BOOL;
        } else if (node instanceof LogicalExpressionNode) {
            return Type.BOOL;
        } else if (node instanceof CallExpressionNode call) {
            if (call.getCallee() instanceof IdentifierNode id) {
                String name = id.getName();
                if (name.equals("int") || name.equals("len") || name.equals("range")) return Type.INT;
                if (name.equals("float")) return Type.FLOAT;
                if (name.equals("str")) return Type.STRING;
                if (name.equals("bool")) return Type.BOOL;
                Symbol func = symbolTable.resolve(name);
                if (func instanceof FunctionSymbol f) return f.getType();
            } else if (call.getCallee() instanceof AttributeAccessNode attr) {
                // heuristic: `.get(...)` on a dict-like object (request.form, request.args, etc.)
                // returns the value type (a string for Flask form/args data) when a value is present
                if ("get".equals(attr.getAttribute())) {
                    return Type.STRING;
                }
            }
            return Type.UNKNOWN;
        }
        return Type.UNKNOWN;
    }

    private Type inferReturnType(ASTNode body) {
        if (body == null) return Type.UNKNOWN;
        Type found = Type.UNKNOWN;
        for (ASTNode child : body.getChildren()) {
            Type t = inferReturnTypeFromNode(child);
            if (t != Type.UNKNOWN) found = t;
        }
        return found;
    }

    private Type inferReturnTypeFromNode(ASTNode node) {
        if (node instanceof ReturnNode ret) {
            return inferType(ret.getExpression());
        } else if (node instanceof IfNode ifNode) {
            Type thenType = inferReturnType(ifNode.getThenBlock());
            Type elseType = ifNode.getElseBlock() != null ? inferReturnType(ifNode.getElseBlock()) : Type.UNKNOWN;
            for (ElifNode elif : ifNode.getElifBlocks()) {
                Type elifType = inferReturnType(elif.getBlock());
                if (elifType != Type.UNKNOWN) thenType = elifType;
            }
            return thenType != Type.UNKNOWN ? thenType : elseType;
        } else if (node instanceof BlockNode block) {
            return inferReturnType(block);
        }
        return Type.UNKNOWN;
    }

    @Override
    public Void visit(ProgramNode node) {
        Scope leakScope = null;

        for (ASTNode child : node.getChildren()) {
            if (child instanceof FunctionDefNode) {
                child.accept(this);
                leakScope = lastFunctionScope; // statements after this point leak into it
            } else if (leakScope != null) {
                // This node was misattached to ProgramNode by the parser bug.
                // Re-home it inside the previous function's scope.
                Scope saved = symbolTable.getCurrentScope();
                boolean wasInFunction = inPythonFunction;

                symbolTable.currentScope = leakScope;
                inPythonFunction = true;

                child.accept(this);

                symbolTable.currentScope = saved;
                inPythonFunction = wasInFunction;
            } else {
                child.accept(this);
            }
        }
        return null;
    }

    @Override
    public Void visit(BlockNode node) {
        if (!inPythonFunction) {
            symbolTable.enterScope("block_" + node.hashCode());
        }
        for (ASTNode stmt : node.getChildren()) {
            stmt.accept(this);
        }
        if (!inPythonFunction) {
            symbolTable.exitScope();
        }
        return null;
    }

    @Override
    public Void visit(StatementNode node) {
        return null;
    }

    @Override
    public Void visit(FunctionDefNode node) {
        Type returnType = inferReturnType(node.getBody());
        if (returnType == Type.UNKNOWN) returnType = Type.VOID;

        List<Type> paramTypes = new ArrayList<>();
        for (ParameterNode param : node.getParameters()) {
            paramTypes.add(Type.UNKNOWN);
        }

        FunctionSymbol functionSymbol = new FunctionSymbol(
                node.getName(),
                returnType,
                paramTypes,
                node.getLine(),
                node.getColumn(),
                symbolTable.getCurrentFileOrigin()
        );

        if (!symbolTable.define(functionSymbol)) {
            System.out.println("ERROR: Function:" + node.getName() + "already defined");
        }
        labelTable.generateLabel(functionSymbol);

        boolean wasInFunction = inPythonFunction;
        inPythonFunction = true;

        symbolTable.enterScope("function_" + node.getName());

        FunctionContext ctx = new FunctionContext(node.getName(), node.getLine(), symbolTable.getCurrentScope());
        functionStack.push(ctx);

        for (ParameterNode param : node.getParameters()) {
            Symbol paramSymbol = new Symbol(
                    param.getName(),
                    Type.UNKNOWN,
                    SymbolKind.PARAMETER,
                    param.getLine(),
                    param.getColumn(),
                    symbolTable.getCurrentFileOrigin()
            );
            if (!symbolTable.define(paramSymbol)) {
                System.out.println("Error: Duplicate paramSymbol " + paramSymbol.getName());
            }
        }

        if (node.getBody() != null) {
            node.getBody().accept(this);
        }

        ctx.endLine = estimateFunctionEndLine(node);

        lastFunctionScope = symbolTable.getCurrentScope(); // <-- ADD THIS LINE
        symbolTable.exitScope();
        functionStack.pop();

        inPythonFunction = wasInFunction;
        return null;
    }

    private int estimateFunctionEndLine(FunctionDefNode node) {
        if (node.getBody() == null) return node.getLine();
        int maxLine = node.getLine();
        for (ASTNode child : node.getBody().getChildren()) {
            maxLine = Math.max(maxLine, getMaxLine(child));
        }
        return maxLine;
    }

    private int getMaxLine(ASTNode node) {
        if (node == null) return 0;
        int max = node.getLine();
        for (ASTNode child : node.getChildren()) {
            max = Math.max(max, getMaxLine(child));
        }
        return max;
    }

    @Override
    public Void visit(ParameterNode node) {
        return null;
    }

    @Override
    public Void visit(DecoratorNode node) {
        return null;
    }

    @Override
    public Void visit(AssignmentNode node) {
        IdentifierNode id = node.getTarget();
        Type inferredType = node.getValue() != null ? inferType(node.getValue()) : Type.UNKNOWN;

        // Workaround for parser bug: global statement breaks AST block structure
        // If we're at global level but line is inside a function, force into function scope
        if (!inPythonFunction && isInsideCurrentFunction(node.getLine())) {
            Scope funcScope = functionStack.peek().scope;
            if (funcScope.resolveLocal(id.getName()) == null) {
                Symbol varSymbol = new Symbol(
                        id.getName(),
                        inferredType,
                        SymbolKind.VARIABLE,
                        id.getLine(),
                        id.getColumn(),
                        symbolTable.getCurrentFileOrigin()
                );
                funcScope.define(varSymbol);
            } else {
                Symbol existing = funcScope.resolveLocal(id.getName());
                if (existing != null && existing.getType() == Type.UNKNOWN && inferredType != Type.UNKNOWN) {
                    existing.setType(inferredType);
                }
            }
        } else {
            // Normal path
            if (!symbolTable.existsInCurrentScope(id.getName())) {
                Symbol varSymbol = new Symbol(
                        id.getName(),
                        inferredType,
                        SymbolKind.VARIABLE,
                        id.getLine(),
                        id.getColumn(),
                        symbolTable.getCurrentFileOrigin()
                );
                if (!symbolTable.define(varSymbol)) {
                    System.out.println("Error: Duplicate variable '" + varSymbol.getName() + "'");
                }
            } else {
                Symbol existing = symbolTable.resolveLocal(id.getName());
                if (existing != null && existing.getType() == Type.UNKNOWN && inferredType != Type.UNKNOWN) {
                    existing.setType(inferredType);
                }
            }
        }

        if (node.getValue() != null) {
            node.getValue().accept(this);
        }
        return null;
    }

    @Override
    public Void visit(IfNode node) {
        if (node.getCondition() != null) {
            node.getCondition().accept(this);
        }
        if (node.getThenBlock() != null) {
            node.getThenBlock().accept(this);
        }
        for (ElifNode elif : node.getElifBlocks()) {
            if (elif.getCondition() != null) {
                elif.getCondition().accept(this);
            }
            elif.getBlock().accept(this);
        }
        if (node.getElseBlock() != null) {
            node.getElseBlock().accept(this);
        }
        return null;
    }

    @Override
    public Void visit(ElifNode node) {
        node.getCondition().accept(this);
        node.getBlock().accept(this);
        return null;
    }

    @Override
    public Void visit(ElseNode node) {
        node.getBlock().accept(this);
        return null;
    }

    @Override
    public Void visit(WhileNode node) {
        if (node.getCondition() != null) {
            node.getCondition().accept(this);
        }
        if (!inPythonFunction) symbolTable.enterScope("while");
        if (node.getBody() != null) {
            node.getBody().accept(this);
        }
        if (!inPythonFunction) symbolTable.exitScope();
        return null;
    }

    @Override
    public Void visit(ForNode node) {
        if (!inPythonFunction) symbolTable.enterScope("for");

        Symbol loopVar = new Symbol(
                node.getVariable().getName(),
                Type.UNKNOWN,
                SymbolKind.VARIABLE,
                node.getVariable().getLine(),
                node.getVariable().getColumn(),
                symbolTable.getCurrentFileOrigin()
        );
        if (!symbolTable.define(loopVar)) {
            System.out.println("Error: Duplicate loopVar " + loopVar.getName());
        }
        labelTable.generateLabel(loopVar);

        if (node.getIterable() != null) {
            node.getIterable().accept(this);
        }
        if (node.getBody() != null) {
            node.getBody().accept(this);
        }
        if (!inPythonFunction) symbolTable.exitScope();
        return null;
    }

    @Override
    public Void visit(TryNode node) {
        if (!inPythonFunction) symbolTable.enterScope("try");
        node.getTryBlock().accept(this);
        if (!inPythonFunction) symbolTable.exitScope();

        for (ExceptNode e : node.getExceptBlocks()) {
            if (!inPythonFunction) symbolTable.enterScope("except");
            e.getBlock().accept(this);
            if (!inPythonFunction) symbolTable.exitScope();
        }

        if (node.getFinallyBlock() != null) {
            if (!inPythonFunction) symbolTable.enterScope("finally");
            node.getFinallyBlock().accept(this);
            if (!inPythonFunction) symbolTable.exitScope();
        }
        return null;
    }

    @Override
    public Void visit(ExceptNode node) {
        if (node.getExceptionType() != null) {
            node.getExceptionType().accept(this);
        }
        node.getBlock().accept(this);
        return null;
    }

    @Override
    public Void visit(FinallyNode node) {
        node.getBlock().accept(this);
        return null;
    }

    @Override
    public Void visit(BinaryExpressionNode node) {
        node.getLeft().accept(this);
        node.getRight().accept(this);
        return null;
    }

    @Override
    public Void visit(UnaryExpressionNode node) {
        return null;
    }

    @Override
    public Void visit(ComparisonNode node) {
        if (node.getLeft() != null) {
            node.getLeft().accept(this);
        }
        if (node.getRight() != null) {
            node.getRight().accept(this);
        }
        return null;
    }

    @Override
    public Void visit(LogicalExpressionNode node) {
        return null;
    }

    @Override
    public Void visit(CallExpressionNode node) {
        node.getCallee().accept(this);
        for (ExpressionNode arg : node.getArguments()) {
            arg.accept(this);
        }
        return null;
    }

    @Override
    public Void visit(IdentifierNode node) {
        return null;
    }

    @Override
    public Void visit(NumberLiteralNode node) {
        return null;
    }

    @Override
    public Void visit(StringLiteralNode node) {
        return null;
    }

    @Override
    public Void visit(BooleanLiteralNode node) {
        return null;
    }

    @Override
    public Void visit(NullLiteralNode node) {
        return null;
    }

    @Override
    public Void visit(GlobalNode node) {
        return null;
    }

    @Override
    public Void visit(ListNode node) {
        return null;
    }

    @Override
    public Void visit(DictNode node) {
        return null;
    }

    @Override
    public Void visit(KeyValueNode node) {
        return null;
    }

    @Override
    public Void visit(ReturnNode node) {
        return null;
    }

    @Override
    public Void visit(ExpressionNode node) {
        return null;
    }

    @Override
    public Void visit(BreakNode node) {
        return null;
    }

    @Override
    public Void visit(ContinueNode node) {
        return null;
    }

    @Override
    public Void visit(ArgumentListNode argumentListNode) {
        return null;
    }

    @Override
    public Void visit(HtmlDocumentNode node) {
        for (ASTNode child : node.getChildren()) {
            child.accept(this);
        }
        return null;
    }

    @Override
    public Void visit(JinjaBlockNode node) {
        String blockName = node.getType();
        if (blockName.equals("end") || blockName.equals("endblock")) {
            return null;
        }
        labelTable.generateBlockLabel(blockName);
        symbolTable.enterScope("jinja_" + blockName + "_" + node.getLine());
        for (ASTNode child : node.getChildren()) {
            child.accept(this);
        }
        symbolTable.exitScope();
        return null;
    }

    @Override
    public Void visit(JinjaIfNode node) {
        return null;
    }

    @Override
    public Void visit(JinjaExtendNode node) {
        return null;
    }

    @Override
    public Void visit(JinjaElseNode node) {
        return null;
    }

    @Override
    public Void visit(JinjaForNode node) {
        return null;
    }

    @Override
    public Void visit(CssDocumentNode node) {
        for (CssRuleNode rule : node.getRules()) {
            rule.accept(this);
            for (CssSelectorNode sel : rule.getSelectors()) {
                String selector = sel.getSelector().trim();
                String[] parts = selector.split("\\s+|>|\\+|~");
                for (String part : parts) {
                    if (part.isBlank()) continue;
                    Symbol symbol;
                    if (part.startsWith(".")) {
                        symbol = new Symbol(
                                part.substring(1),
                                Type.UNKNOWN,
                                SymbolKind.CSS_CLASS,
                                sel.getLine(),
                                sel.getColumn(),
                                symbolTable.getCurrentFileOrigin()
                        );
                    } else if (part.startsWith("#")) {
                        symbol = new Symbol(
                                part.substring(1),
                                Type.UNKNOWN,
                                SymbolKind.CSS_ID,
                                sel.getLine(),
                                sel.getColumn(),
                                symbolTable.getCurrentFileOrigin()
                        );
                    } else {
                        symbol = new Symbol(
                                part,
                                Type.UNKNOWN,
                                SymbolKind.CSS_TAG,
                                sel.getLine(),
                                sel.getColumn(),
                                symbolTable.getCurrentFileOrigin()
                        );
                    }
                    if (!symbolTable.existsInCurrentScope(symbol.getName())) {
                        symbolTable.define(symbol);
                    }
                }
            }
        }
        return null;
    }

    @Override
    public Void visit(HtmlTagNode node) {
        for (ASTNode child : node.getChildren()) {
            child.accept(this);
        }
        return null;
    }

    @Override
    public Void visit(HtmlAttributeNode node) {
        for (ASTNode child : node.getChildren()) {
            child.accept(this);
        }
        return null;
    }

    @Override
    public Void visit(TupleExpressionNode node) {
        return null;
    }

    public Void visit(MixedWebNode node) {
        for (ASTNode child : node.getChildren()) {
            child.accept(this);
        }
        return null;
    }

    @Override
    public Void visit(JinjaExpressionNode node) {
        if (node.getExpression() != null) {
            collectJinjaVariables(node.getExpression(), node.getLine(), node.getColumn());
        }
        return null;
    }

    @Override
    public Void visit(JinjaWithAssignmentNode node) {
        Type inferredType = Type.UNKNOWN;
        if (node.getValue() instanceof CallExpressionNode call
                && call.getCallee() instanceof IdentifierNode calleeId) {
            inferredType = inferJinjaFunctionType(calleeId.getName());
        }

        Symbol withVar = new Symbol(
                node.getName(),
                inferredType,
                SymbolKind.JINJA_VARIABLE,
                node.getLine(),
                node.getColumn(),
                symbolTable.getCurrentFileOrigin()
        );
        if (!symbolTable.existsInCurrentScope(withVar.getName())) {
            symbolTable.define(withVar);
        }
        if (node.getValue() != null) {
            node.getValue().accept(this);
        }
        return null;
    }

    @Override
    public Void visit(JinjaEndNode jinjaEndNode) {
        return null;
    }

    private void collectJinjaVariables(ASTNode expr, int line, int column) {
        if (expr == null) return;

        if (expr instanceof IdentifierNode id) {
            String fullName = id.getName();
            if (fullName.contains("(")) return;

            boolean isAttributeAccess = fullName.contains(".");
            String baseName = fullName.split("\\.")[0];

            if (!symbolTable.existsInCurrentScope(baseName)) {
                Symbol jinjaVarSymbol = new Symbol(
                        baseName,
                        isAttributeAccess ? Type.DICT : Type.UNKNOWN,
                        SymbolKind.JINJA_VARIABLE,
                        line, column,
                        symbolTable.getCurrentFileOrigin()
                );
                symbolTable.define(jinjaVarSymbol);
            } else {
                // upgrade an already-UNKNOWN var if we later see it used with attribute access
                Symbol existing = symbolTable.resolve(baseName);
                if (existing != null && existing.getType() == Type.UNKNOWN && isAttributeAccess) {
                    existing.setType(Type.DICT);
                }
            }
        } else if (expr instanceof BinaryExpressionNode bin) {
            if (bin.getOperator().equals(".")) {
                collectJinjaVariables(bin.getLeft(), line, column);
            } else if (bin.getOperator().equals("|")) {
                collectJinjaVariables(bin.getRight(), line, column);
            }
            collectJinjaVariables(bin.getLeft(), line, column);
            collectJinjaVariables(bin.getRight(), line, column);
        } else if (expr instanceof CallExpressionNode call) {
            if (call.getCallee() instanceof IdentifierNode funcId) {
                if (!symbolTable.existsInCurrentScope(funcId.getName())) {
                    Symbol jinjaFuncSymbol = new Symbol(
                            funcId.getName(),
                            inferJinjaFunctionType(funcId.getName()),   // <-- was Type.UNKNOWN
                            SymbolKind.JINJA_FUNCTION,
                            line, column,
                            symbolTable.getCurrentFileOrigin()
                    );
                    symbolTable.define(jinjaFuncSymbol);
                }
            }
            for (ExpressionNode arg : call.getArguments()) {
                collectJinjaVariables(arg, line, column);
            }
        } else {
            for (ASTNode child : expr.getChildren()) {
                collectJinjaVariables(child, line, column);
            }
        }
    }
    private Type inferJinjaFunctionType(String name) {
        return switch (name) {
            case "url_for" -> Type.STRING;
            case "get_flashed_messages" -> Type.LIST;
            case "format" -> Type.STRING;          // covers "%.2f"|format(...)
            case "len" -> Type.INT;
            case "str" -> Type.STRING;
            default -> Type.UNKNOWN;
        };
    }
}