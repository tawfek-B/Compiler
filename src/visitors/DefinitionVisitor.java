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
import java.util.Map;
import java.util.HashMap;

public class DefinitionVisitor implements ASTVisitor<Void> {

    private final SymbolTable symbolTable;
    private final LabelTable labelTable;

    private boolean inPythonFunction = false;

    private Scope lastFunctionScope = null;

    // Track function context for parser workaround (global statement breaks AST)
    private Stack<FunctionContext> functionStack = new Stack<>();

    private final List<String> errors = new ArrayList<>();


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
            } else if (leakScope != null && child.getColumn() > 0) { // <-- FIX: Add column check
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

                // <-- FIX: Reset leakScope when we hit a global statement
                if (child.getColumn() == 0) {
                    leakScope = null; // End of leaked block
                }
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
            addError(
                    "Function '" + node.getName() + "()' already defined",
                    node.getLine(),
                    node.getColumn()
            );
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
                addError(
                        "Duplicate parameter '" + paramSymbol.getName() + "'",
                        paramSymbol.getLine(),
                        paramSymbol.getColumn()
                );
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
        ExpressionNode targetExpr = node.getTarget(); // Now an ExpressionNode
        Type inferredType = Type.UNKNOWN;

        if (node.getValue() != null) {
            node.getValue().accept(this);
            inferredType = inferType(node.getValue());
        }
        // ONLY define a new symbol in the table if the target is a simple Identifier (e.g., `x = 1`)
        if (targetExpr instanceof IdentifierNode id) {

            // Workaround for parser bug: global statement breaks AST block structure
            if (!inPythonFunction && isInsideCurrentFunction(node.getLine())) {
                Scope funcScope = functionStack.peek().scope;
                if (funcScope.resolveLocal(id.getName()) == null) {
                    Symbol varSymbol = new Symbol(
                            id.getName(), inferredType, SymbolKind.VARIABLE,
                            id.getLine(), id.getColumn(), symbolTable.getCurrentFileOrigin()
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
                            id.getName(), inferredType, SymbolKind.VARIABLE,
                            id.getLine(), id.getColumn(), symbolTable.getCurrentFileOrigin()
                    );
                    if (!symbolTable.define(varSymbol)) {
                        addError(
                                "Duplicate variable '" + varSymbol.getName() + "'",
                                varSymbol.getLine(),
                                varSymbol.getColumn()
                        );
                    }
                } else {
                    Symbol existing = symbolTable.resolveLocal(id.getName());
                    if (existing != null && existing.getType() == Type.UNKNOWN && inferredType != Type.UNKNOWN) {
                        existing.setType(inferredType);
                    }
                }
            }
        } else {
            // If it's an AttributeAccessNode (e.g., `self.x = 1`), we don't define a new variable.
            // Just visit the target expression so it gets recorded in the symbol occurrences.
            targetExpr.accept(this);
        }

        // Always visit the value being assigned
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
            addError(
                    "Duplicate loop variable '" + loopVar.getName() + "'",
                    loopVar.getLine(),
                    loopVar.getColumn()
            );
        }
        labelTable.generateLabel(loopVar);

        if (node.getIterable() != null) {
            node.getIterable().accept(this);
        }
        if (node.getIterable() instanceof IdentifierNode iterableId &&
                node.getVariable() instanceof IdentifierNode loopId &&
                iterableId.getName().equals(loopId.getName())) {

            addError(
                    "Loop iterable cannot have the same name as loop variable '" +
                            loopId.getName() + "'",
                    loopId.getLine(),
                    loopId.getColumn()
            );
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
        // Visit callee and arguments normally
        node.getCallee().accept(this);
        for (ExpressionNode arg : node.getArguments()) {
            arg.accept(this);
        }

        // --- NEW: TEMPLATE BRIDGE LOGIC ---
        if (node.getCallee() instanceof IdentifierNode id && id.getName().equals("render_template")) {
            // Flask's render_template signature: render_template("file.html", var1=val1, ...)
            if (!node.getArguments().isEmpty() && node.getArguments().get(0) instanceof StringLiteralNode templateNameNode) {

                // 1. Extract template name (strip quotes)
                String templateName = templateNameNode.getValue().replace("\"", "").replace("'", "");
                Map<String, Symbol> contextVars = new HashMap<>();

                // 2. Extract keyword arguments (the context variables)
                for (int i = 1; i < node.getArguments().size(); i++) {
                    ExpressionNode arg = node.getArguments().get(i);
                    if (arg instanceof KeywordArgumentNode kwarg) {
                        String varName = kwarg.getKey();

                        // Infer the type of the value being passed
                        Type varType = inferType(kwarg.getValue());

                        // If it's a variable reference, try to get its exact type from the Python SymbolTable
                        if (kwarg.getValue() instanceof IdentifierNode idVal) {
                            Symbol resolved = symbolTable.resolve(idVal.getName());
                            if (resolved != null && resolved.getType() != Type.UNKNOWN) {
                                varType = resolved.getType();
                            }
                        }

                        // Create a symbol representing this variable in the Jinja context
                        Symbol sym = new Symbol(
                                varName,
                                varType,
                                SymbolKind.JINJA_VARIABLE,
                                kwarg.getLine(),
                                kwarg.getColumn(),
                                symbolTable.getCurrentFileOrigin()
                        );
                        contextVars.put(varName, sym);
                    }
                }

                // 3. Register to the SymbolTable!
                symbolTable.registerTemplateContext(templateName, contextVars);
            }
        }
        // ----------------------------------

        return null;
    }

    @Override
    public Void visit(AttributeAccessNode node) {
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

        switch (node.getJinjaType()) {

            case BLOCK -> {
                IdentifierNode id = (IdentifierNode) node.getBlockName();

                Symbol block = new Symbol(
                        id.getName(),
                        Type.UNKNOWN,
                        SymbolKind.JINJA_BLOCK,
                        id.getLine(),
                        id.getColumn(),
                        symbolTable.getCurrentFileOrigin()
                );

                if (blockExistsInCurrentFile(id.getName())) {
                    addError(
                            "Duplicate block '" + id.getName() + "'",
                            id.getLine(),
                            id.getColumn()
                    );
                } else {
                    symbolTable.define(block);
                }

                for (ASTNode child : node.getChildren()) {
                    child.accept(this);
                }
            }

            case FOR -> {
                String scopeName = symbolTable.getCurrentFileOrigin() + "_jinja_for_" + node.getLine();
                symbolTable.enterScope(scopeName);
                node.setResolvedScope(symbolTable.getCurrentScope()); // <-- store direct reference

                defineJinjaLoopTarget(node.getCondition());
                checkJinjaLoopIterableCollision(node.getCondition(), node.getIterable());

                if (node.getIterable() != null) {
                    node.getIterable().accept(this);
                }
                for (ASTNode child : node.getChildren()) {
                    child.accept(this);
                }

                symbolTable.exitScope();
            }

            case WITH -> {
                String withScopeName = symbolTable.getCurrentFileOrigin() + "_jinja_with_" + node.getLine();
                symbolTable.enterScope(withScopeName);
                node.setResolvedScope(symbolTable.getCurrentScope()); // <-- store direct reference

                for (ASTNode child : node.getChildren()) {
                    child.accept(this);
                }

                symbolTable.exitScope();
            }

            case IF -> {
                for (ASTNode child : node.getChildren()) {
                    child.accept(this);
                }
            }
        }

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
        String scopeName = symbolTable.getCurrentFileOrigin() + "_jinja_for_" + node.getLine();

        symbolTable.enterScope(scopeName);

        // 1. Define loop variable ONLY (this is correct semantic declaration)
        if (node.getVariable() instanceof IdentifierNode id) {

            Symbol loopVar = new Symbol(
                    id.getName(),
                    Type.UNKNOWN,
                    SymbolKind.JINJA_VARIABLE,
                    node.getLine(),
                    node.getColumn(),
                    symbolTable.getCurrentFileOrigin()
            );

            if (!symbolTable.define(loopVar)) {
                addError(
                        "Duplicate loop variable '" + loopVar.getName() + "'",
                        node.getLine(),
                        node.getColumn()
                );
            }
        }

        // 2. Visit iterable (DO NOT define anything inside it)
        if (node.getIterable() != null) {
            node.getIterable().accept(this);
        }

        // 3. Visit loop body
        node.getBody().accept(this);

        symbolTable.exitScope();
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
            node.getExpression().accept(this);
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

        if (!symbolTable.define(withVar)) {
            addError(
                    "Duplicate with variable '" + withVar.getName() + "'",
                    node.getLine(),
                    node.getColumn()
            );
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

    private boolean blockExistsInCurrentFile(String name) {

        Symbol s = symbolTable.resolveLocal(name);

        return s != null &&
                s.getKind() == SymbolKind.JINJA_BLOCK &&
                s.getFileOrigin().equals(symbolTable.getCurrentFileOrigin());
    }

    // Collects the loop-target name(s) as plain strings, unpacking tuples like `for a, b in ...`
    private void collectJinjaLoopNames(ASTNode target, List<String> out) {
        if (target instanceof IdentifierNode id) {
            out.add(id.getName());
        } else if (target instanceof TupleExpressionNode tuple) {
            for (ExpressionNode el : tuple.getElements()) {
                collectJinjaLoopNames(el, out);
            }
        }
    }

    private void checkJinjaLoopIterableCollision(ASTNode target, ASTNode iterable) {
        if (target == null || !(iterable instanceof IdentifierNode iterableId)) return;

        List<String> loopNames = new ArrayList<>();
        collectJinjaLoopNames(target, loopNames);

        if (loopNames.contains(iterableId.getName())) {
            addError(
                    "Loop iterable cannot have the same name as loop variable '" +
                            iterableId.getName() + "'",
                    iterableId.getLine(),
                    iterableId.getColumn()
            );
        }
    }


    // Recursively defines loop variables from a Jinja for-loop target,
// unpacking tuples like `for category, message in messages`
    private void defineJinjaLoopTarget(ASTNode target) {
        if (target instanceof IdentifierNode id) {
            Symbol loopVar = new Symbol(
                    id.getName(),
                    Type.UNKNOWN,
                    SymbolKind.JINJA_VARIABLE,
                    id.getLine(),
                    id.getColumn(),
                    symbolTable.getCurrentFileOrigin()
            );
            if (!symbolTable.define(loopVar)) {
                addError(
                        "Duplicate loop variable '" + id.getName() + "'",
                        id.getLine(),
                        id.getColumn()
                );
            }
        } else if (target instanceof TupleExpressionNode tuple) {
            for (ExpressionNode el : tuple.getElements()) {
                defineJinjaLoopTarget(el);
            }
        }
    }

    public List<String> getErrors() {
        return errors;
    }

    public boolean hasErrors() {
        return !errors.isEmpty();
    }

    private void addError(String message, int line, int column) {
        errors.add(String.format(
                "Semantic Error at line %d, col %d: %s",
                line,
                column,
                message
        ));
    }
}