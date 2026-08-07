package visitors;

import ast.core.*;
import ast.html.*;
import ast.css.*;
import ast.jinja.*;
import ast.python.*;
import table.Symbol;
import table.SymbolTable;
import table.Type;
import table.SymbolKind;
import table.FunctionSymbol;
import table.Scope;

import java.util.*;

public class TypeCheckVisitor implements ASTVisitor<Void> {
    private final SymbolTable symbolTable;
    private final List<String> errors = new ArrayList<>();
    private boolean seenExtends = false;

    private int loopDepth = 0;
    private int functionDepth = 0;
    private Type currentFunctionReturnType = Type.VOID;

    private boolean inJinjaBlock = false;

    public TypeCheckVisitor(SymbolTable symbolTable) {
        this.symbolTable = symbolTable;
    }

    public List<String> getErrors() {
        return errors;
    }

    public boolean hasErrors() {
        return !errors.isEmpty();
    }

    private void addError(String message, int line, int column) {
        errors.add(String.format("Semantic Error at line %d, col %d: %s", line, column, message));
    }

    @Override
    public Void visit(AttributeAccessNode node) {

        node.getObject().accept(this);

        Type objectType = resolveType(node.getObject());

        if (objectType == Type.INT ||
                objectType == Type.FLOAT ||
                objectType == Type.BOOL ||
                objectType == Type.STRING) {

            addError(
                    "Type '" + objectType +
                            "' has no attribute '" +
                            node.getAttribute() + "'",
                    node.getLine(),
                    node.getColumn()
            );
        }

        return null;
    }

    // helper resolves the type of any expression on the fly
    private Type resolveType(ExpressionNode node) {
        if (node == null) return Type.UNKNOWN;

        if (node instanceof NumberLiteralNode) return Type.INT;
        if (node instanceof StringLiteralNode) return Type.STRING;
        if (node instanceof BooleanLiteralNode) return Type.BOOL;
        if (node instanceof NullLiteralNode) return Type.NULL;
        if (node instanceof ListNode) return Type.LIST;
        if (node instanceof DictNode) return Type.DICT;

        if (node instanceof IdentifierNode id) {
            Symbol sym = symbolTable.resolve(id.getName());
            return sym != null ? sym.getType() : Type.UNKNOWN;
        }

        if (node instanceof BinaryExpressionNode bin) {
            Type left = resolveType(bin.getLeft());
            Type right = resolveType(bin.getRight());
            String op = bin.getOperator();

            if (op.equals("+") || op.equals("-") || op.equals("*") || op.equals("/") || op.equals("//") || op.equals("%") || op.equals("**")) {
                if (left == Type.STRING || right == Type.STRING) return Type.STRING;
                if (left == Type.FLOAT || right == Type.FLOAT) return Type.FLOAT;
                return Type.INT;
            }
            if (op.equals("==") || op.equals("!=") || op.equals("<") || op.equals(">") ||
                    op.equals("<=") || op.equals(">=") || op.equals("is") || op.equals("in") ||
                    op.equals("and") || op.equals("or")) {
                return Type.BOOL;
            }
            return Type.UNKNOWN;
        }

        if (node instanceof UnaryExpressionNode un) {
            if (un.getOperator().equals("not") || un.getOperator().equals("!")) return Type.BOOL;
            return resolveType(un.getOperand());
        }

        if (node instanceof ComparisonNode || node instanceof LogicalExpressionNode) {
            return Type.BOOL;
        }

        if (node instanceof CallExpressionNode call) {
            if (call.getCallee() instanceof IdentifierNode id) {
                Symbol sym = symbolTable.resolve(id.getName());
                if (sym instanceof FunctionSymbol f) return f.getType();

                String name = id.getName();
                if (name.equals("int") || name.equals("len") || name.equals("range")) return Type.INT;
                if (name.equals("float")) return Type.FLOAT;
                if (name.equals("str")) return Type.STRING;
                if (name.equals("bool")) return Type.BOOL;
            }
            return Type.UNKNOWN;
        }

        return Type.UNKNOWN;
    }


    @Override
    public Void visit(IdentifierNode node) {
        Symbol symbol = symbolTable.resolve(node.getName());
        if (symbol == null) {
            if (!IGNORE_UNDEFINED.contains(node.getName())) {
                addError("Undefined variable '" + node.getName() + "'", node.getLine(), node.getColumn());
            }
        } else {
            Symbol occurrence = new Symbol(
                    node.getName(), symbol.getType(), SymbolKind.VARIABLE,
                    node.getLine(), node.getColumn(), symbol.getFileOrigin()
            );
            symbol.symbolOccurrences.symbols.add(occurrence);
        }
        return null;
    }

    @Override
    public Void visit(AssignmentNode node) {
        ExpressionNode target = node.getTarget();
        ExpressionNode value = node.getValue();

        if (value != null) value.accept(this);

        if (target instanceof IdentifierNode id) {
            Type rhsType = resolveType(value);
            Symbol sym = symbolTable.resolve(id.getName());
            if (sym != null) {
                Type lhsType = sym.getType();
                if (lhsType == Type.UNKNOWN && rhsType != Type.UNKNOWN) {
                    sym.setType(rhsType);
                } else if (lhsType != Type.UNKNOWN && rhsType != Type.UNKNOWN && lhsType != rhsType) {
                    // FULFILLS YOUR TODO: Check for type change errors
                    addError("Type mismatch: Variable '" + id.getName() + "' was defined as " + lhsType + " but is being assigned " + rhsType, node.getLine(), node.getColumn());
                }
            }
        } else {
            target.accept(this);
        }
        return null;
    }

    @Override
    public Void visit(IfNode node) {
        if (node.getCondition() != null) {
            node.getCondition().accept(this);
            Type condType = resolveType(node.getCondition());
            if (condType != Type.UNKNOWN && condType != Type.BOOL) {
                addError("If condition must evaluate to boolean, got " + condType, node.getLine(), node.getColumn());
            }
        }
        if (node.getThenBlock() != null) node.getThenBlock().accept(this);
        for (ElifNode elif : node.getElifBlocks()) if (elif != null) elif.accept(this);
        if (node.getElseBlock() != null) node.getElseBlock().accept(this);
        return null;
    }

    @Override
    public Void visit(ElifNode node) {
        if (node.getCondition() != null) {
            node.getCondition().accept(this);
            Type condType = resolveType(node.getCondition());
            if (condType != Type.UNKNOWN && condType != Type.BOOL) {
                addError("Elif condition must evaluate to boolean, got " + condType, node.getLine(), node.getColumn());
            }
        }
        if (node.getBlock() != null) node.getBlock().accept(this);
        return null;
    }

    @Override
    public Void visit(WhileNode node) {
        if (node.getCondition() != null) {
            node.getCondition().accept(this);
            Type condType = resolveType(node.getCondition());
            if (condType != Type.UNKNOWN && condType != Type.BOOL) {
                addError("While condition must evaluate to boolean, got " + condType, node.getLine(), node.getColumn());
            }
        }
        loopDepth++;
        if (node.getBody() != null) node.getBody().accept(this);
        loopDepth--;
        return null;
    }

    @Override
    public Void visit(ForNode node) {
        loopDepth++;
        if (node.getIterable() != null) node.getIterable().accept(this);
        if (node.getBody() != null) node.getBody().accept(this);
        loopDepth--;
        return null;
    }

    @Override
    public Void visit(BreakNode node) {
        if (loopDepth == 0) addError("'break' statement outside of loop", node.getLine(), node.getColumn());
        return null;
    }

    @Override
    public Void visit(ContinueNode node) {
        if (loopDepth == 0) addError("'continue' statement outside of loop", node.getLine(), node.getColumn());
        return null;
    }

    @Override
    public Void visit(FunctionDefNode node) {
        functionDepth++;
        Type prevReturnType = currentFunctionReturnType;
        Scope savedScope = symbolTable.getCurrentScope();

        Symbol funcSym = symbolTable.resolve(node.getName());
        if (funcSym instanceof FunctionSymbol f) {
            currentFunctionReturnType = f.getType();
        }

        // find and enter the actual scope created by DefinitionVisitor
        Scope funcScope = symbolTable.findScope("function_" + node.getName());
        if (funcScope != null) {
            symbolTable.currentScope = funcScope;
        } else {
            symbolTable.enterScope("function_" + node.getName());
        }

        if (node.getBody() != null) node.getBody().accept(this);

        symbolTable.currentScope = savedScope;
        currentFunctionReturnType = prevReturnType;
        functionDepth--;
        return null;
    }

    @Override
    public Void visit(ReturnNode node) {
        if (functionDepth == 0) {
            addError("'return' statement outside of function", node.getLine(), node.getColumn());
        } else if (node.getExpression() != null) {
            node.getExpression().accept(this);
            Type retType = resolveType(node.getExpression());
            if (currentFunctionReturnType != Type.UNKNOWN && currentFunctionReturnType != Type.VOID &&
                    retType != Type.UNKNOWN && retType != currentFunctionReturnType) {
                addError("Return type mismatch. Expected " + currentFunctionReturnType + ", got " + retType, node.getLine(), node.getColumn());
            }
        }
        return null;
    }

    @Override
    public Void visit(CallExpressionNode node) {

        if (node.getCallee() != null && !(node.getCallee() instanceof IdentifierNode)) {
            node.getCallee().accept(this);
        }

        if (node.getCallee() instanceof IdentifierNode id) {

            Symbol sym = symbolTable.resolve(id.getName());

            if (sym == null) {
                if (!IGNORE_UNDEFINED.contains(id.getName())) {
                    addError(
                            "Undefined function '" + id.getName() + "'",
                            node.getLine(),
                            node.getColumn()
                    );
                }
            }
            else if (sym.getKind() == SymbolKind.VARIABLE ||
                    sym.getKind() == SymbolKind.PARAMETER ||
                    sym.getKind() == SymbolKind.JINJA_VARIABLE) {

                addError(
                        "'" + id.getName() + "' is not callable",
                        node.getLine(),
                        node.getColumn()
                );
            }
            else if (sym.getKind() != SymbolKind.FUNCTION &&
                    sym.getKind() != SymbolKind.JINJA_FUNCTION) {

                addError(
                        "Undefined function '" + id.getName() + "'",
                        node.getLine(),
                        node.getColumn()
                );
            }
            else {
                if (sym instanceof FunctionSymbol f) {

                    int expectedArgs = f.getParamTypes().size();
                    int actualArgs = node.getArguments().size();

                    if (expectedArgs != actualArgs) {
                        addError(
                                "Function '" + id.getName() + "' expects " +
                                        expectedArgs +
                                        " arguments, but got " +
                                        actualArgs,
                                node.getLine(),
                                node.getColumn()
                        );
                    } else {
                        for (int i = 0; i < actualArgs; i++) {
                            ExpressionNode arg = node.getArguments().get(i);
                            arg.accept(this);

                            Type argType = resolveType(arg);
                            Type paramType = f.getParamTypes().get(i);

                            if (paramType != Type.UNKNOWN &&
                                    argType != Type.UNKNOWN &&
                                    paramType != argType) {

                                addError(
                                        "Type mismatch in argument " + (i + 1) +
                                                " of '" + id.getName() +
                                                "'. Expected " + paramType +
                                                ", got " + argType,
                                        arg.getLine(),
                                        arg.getColumn()
                                );
                            }
                        }
                    }
                }
            }

        } else {
            for (ExpressionNode arg : node.getArguments())
                arg.accept(this);
        }

        return null;
    }

    @Override
    public Void visit(BlockNode node) {
        for (ASTNode c : node.getChildren()) c.accept(this);
        return null;
    }

    @Override
    public Void visit(ProgramNode node) {
        String leakFuncName = null;
        Type leakReturnType = Type.UNKNOWN;

        for (ASTNode child : node.getChildren()) {
            if (child instanceof FunctionDefNode funcDef) {
                child.accept(this);
                leakFuncName = funcDef.getName();
                Symbol sym = symbolTable.resolve(leakFuncName);
                if (sym instanceof FunctionSymbol f) {
                    leakReturnType = f.getType();
                }
            } else if (leakFuncName != null && child.getColumn() > 0) {
                functionDepth++;
                Type prevReturnType = currentFunctionReturnType;
                currentFunctionReturnType = leakReturnType;

                Scope savedScope = symbolTable.getCurrentScope();
                Scope funcScope = symbolTable.findScope("function_" + leakFuncName);
                if (funcScope != null) {
                    symbolTable.currentScope = funcScope;
                }

                child.accept(this);

                symbolTable.currentScope = savedScope;
                currentFunctionReturnType = prevReturnType;
                functionDepth--;
            } else {
                child.accept(this);
                if (child.getColumn() == 0) {
                    leakFuncName = null;
                }
            }
        }
        return null;
    }

    @Override
    public Void visit(BinaryExpressionNode node) {
        if (node.getLeft() != null) node.getLeft().accept(this);
        if (node.getRight() != null) node.getRight().accept(this);

        String op = node.getOperator();
        if (ARITHMETIC_OPS.contains(op)) {
            Type leftType = resolveType(node.getLeft());
            Type rightType = resolveType(node.getRight());
            checkArithmeticTypes(op, leftType, rightType, node.getLine(), node.getColumn());
        }

        return null;
    }

    @Override
    public Void visit(UnaryExpressionNode node) {
        if (node.getOperand() != null) node.getOperand().accept(this);
        return null;
    }

    @Override
    public Void visit(ComparisonNode node) {
        if (node.getLeft() != null) node.getLeft().accept(this);
        if (node.getRight() != null) node.getRight().accept(this);
        return null;
    }

    @Override
    public Void visit(LogicalExpressionNode node) {
        if (node.getLeft() != null) node.getLeft().accept(this);
        if (node.getRight() != null) node.getRight().accept(this);
        return null;
    }

    @Override
    public Void visit(ElseNode node) {
        if (node.getBlock() != null) node.getBlock().accept(this);
        return null;
    }

    @Override
    public Void visit(TryNode node) {
        if (node.getTryBlock() != null) node.getTryBlock().accept(this);
        for (ExceptNode e : node.getExceptBlocks()) e.accept(this);
        if (node.getFinallyBlock() != null) node.getFinallyBlock().accept(this);
        return null;
    }

    @Override
    public Void visit(ExceptNode node) {
        if (node.getExceptionType() != null) node.getExceptionType().accept(this);
        if (node.getBlock() != null) node.getBlock().accept(this);
        return null;
    }

    @Override
    public Void visit(FinallyNode node) {
        if (node.getBlock() != null) node.getBlock().accept(this);
        return null;
    }

    @Override
    public Void visit(StatementNode node) {
        return null;
    }

    @Override
    public Void visit(ExpressionNode node) {
        return null;
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
    public Void visit(ArgumentListNode node) {
        return null;
    }

    @Override
    public Void visit(TupleExpressionNode node) {
        return null;
    }

    @Override
    public Void visit(HtmlDocumentNode node) {
        for (ASTNode child : node.getChildren()) child.accept(this);
        return null;
    }

    @Override
    public Void visit(HtmlTagNode node) {
        for (ASTNode child : node.getChildren()) child.accept(this);
        return null;
    }

    @Override
    public Void visit(HtmlAttributeNode node) {
        for (ASTNode child : node.getChildren()) child.accept(this);
        return null;
    }

// --- Jinja scope management ---

    @Override
    public Void visit(JinjaBlockNode node) {

        Scope savedScope = symbolTable.getCurrentScope();
        Scope jinjaScope = node.getResolvedScope();

        if (jinjaScope != null) {
            symbolTable.currentScope = jinjaScope;
        }

        switch (node.getJinjaType()) {

            // IF BLOCK
            case IF -> {

                if (node.getCondition() != null) {
                    checkJinjaExpression(
                            node.getCondition(),
                            node.getLine(),
                            node.getColumn()
                    );
                }

                for (ASTNode child : node.getChildren()) {
                    child.accept(this);
                }
            }

            // FOR BLOCK
            case FOR -> {

                if (node.getIterable() instanceof IdentifierNode id) {

                    Symbol sym = symbolTable.resolve(id.getName());

                    if (sym == null) {
                        addError(
                                "Jinja: Undefined iterable '" + id.getName() + "'",
                                node.getLine(),
                                node.getColumn()
                        );
                    }
                }

                if (node.getIterable() != null) {
                    node.getIterable().accept(this);
                }

                if (node.getLoopVariable() != null) {
                    node.getLoopVariable().accept(this);
                }

                for (ASTNode child : node.getChildren()) {
                    child.accept(this);
                }
            }

            case WITH -> {
                for (ASTNode child : node.getChildren()) {
                    child.accept(this);
                }
            }

            case BLOCK -> {

                boolean prev = inJinjaBlock;
                inJinjaBlock = true;


                for (ASTNode child : node.getChildren()) {
                    child.accept(this);
                }

                inJinjaBlock = prev;

                break;
            }
        }

        symbolTable.currentScope = savedScope;
        return null;
    }

    @Override
    public Void visit(JinjaExpressionNode node) {
        if (node.getExpression() != null) {
            checkJinjaExpression(node.getExpression(), node.getLine(), node.getColumn());
        }
        return null;
    }

    @Override
    public Void visit(JinjaWithAssignmentNode node) {
        if (node.getValue() != null) {
            checkJinjaExpression(node.getValue(), node.getLine(), node.getColumn());
        }

        if (node.getValue() instanceof CallExpressionNode call &&
                call.getCallee() instanceof IdentifierNode id) {

            if (!symbolTable.existsInCurrentScope(id.getName())) {
                symbolTable.define(
                        new Symbol(
                                id.getName(),
                                inferJinjaFunctionType(id.getName()),
                                SymbolKind.JINJA_FUNCTION,
                                node.getLine(),
                                node.getColumn(),
                                symbolTable.getCurrentFileOrigin()
                        )
                );
            }
        }
        return null;
    }

    @Override
    public Void visit(JinjaExtendNode node) {

        if (seenExtends) {

            addError(
                    "Template cannot extend multiple templates",
                    node.getLine(),
                    node.getColumn()
            );

        }

        seenExtends = true;

        return null;
    }

    @Override
    public Void visit(JinjaEndNode node) {
        return null;
    }

    @Override
    public Void visit(JinjaIfNode node) {
        return null;
    }

    @Override
    public Void visit(JinjaElseNode node) {
        return null;
    }

    @Override
    public Void visit(JinjaForNode node) {
        if (node.getIterable() != null) {

            if (node.getIterable() instanceof IdentifierNode id) {

                Symbol sym = symbolTable.resolve(id.getName());

                if (sym == null) {
                    addError(
                            "Jinja: Undefined iterable '" + id.getName() + "'",
                            node.getLine(),
                            node.getColumn()
                    );
                }
            }

            node.getIterable().accept(this);
        }

        String scopeName = symbolTable.getCurrentFileOrigin() + "_jinja_for_" + node.getLine();

        Scope saved = symbolTable.getCurrentScope();
        Scope loopScope = symbolTable.findScope(scopeName);

        if (loopScope != null) {
            symbolTable.currentScope = loopScope;
        }

        node.getBody().accept(this);

        symbolTable.currentScope = saved;

        return null;
    }

    @Override
    public Void visit(CssDocumentNode node) {
        return null;
    }

    @Override
    public Void visit(MixedWebNode node) {
        for (ASTNode child : node.getChildren()) child.accept(this);
        return null;
    }


    private void checkJinjaExpression(ASTNode expr, int line, int column) {
        if (expr == null) return;

        if (expr instanceof IdentifierNode id) {

            String name = id.getName();

            // ignore function calls like foo()
            if (name.contains("(")) return;

            String baseName = name.split("\\.")[0];

            if (JINJA_BUILTINS.contains(baseName)) return;

            if (IGNORE_UNDEFINED.contains(baseName)) return;

            Symbol sym = resolveJinjaSymbol(baseName);

            if (sym == null) {
                addError(
                        "Jinja: Undefined variable '" + baseName + "'",
                        line,
                        column
                );
            }

            return;
        }

        if (expr instanceof CallExpressionNode call) {

            if (call.getCallee() instanceof IdentifierNode funcId) {

                String fn = funcId.getName();

                if (fn.equals("super") && !inJinjaBlock) {
                    addError("super() can only be used inside a {% block %} tag", line, column);
                }

                if (fn.equals("url_for")) {
                    checkUrlFor(call);
                    return;
                }

                // builtin functions allowed
                if (IGNORE_UNDEFINED.contains(fn)) {
                    for (ExpressionNode arg : call.getArguments()) {
                        checkJinjaExpression(arg, line, column);
                    }
                    return;
                }

                Symbol sym = resolveJinjaSymbol(fn);

                if (sym != null && sym.getKind() != SymbolKind.JINJA_FUNCTION) {
                    addError(
                            "'" + sym.getName() + "' is not callable",
                            line,
                            column
                    );
                } else if (sym == null) {
                    addError(
                            "Jinja: Undefined function '" + fn + "'",
                            line,
                            column
                    );
                }
            }

            for (ExpressionNode arg : call.getArguments()) {
                checkJinjaExpression(arg, line, column);
            }

            return;
        }

        if (expr instanceof BinaryExpressionNode bin) {

            String op = bin.getOperator();

            if (op.equals(".")) {
                checkJinjaExpression(bin.getLeft(), line, column);
                return;
            }

            if (op.equals("|")) {

                checkJinjaExpression(bin.getLeft(), line, column);

                ASTNode filter = bin.getRight();

                if (filter instanceof IdentifierNode id) {

                    String filterName = id.getName();

                    if (!JINJA_FILTERS.contains(filterName)) {
                        addError(
                                "Jinja: Undefined filter '" + filterName + "'",
                                id.getLine(),
                                id.getColumn()
                        );
                    }

                } else if (filter instanceof CallExpressionNode call &&
                        call.getCallee() instanceof IdentifierNode id) {

                    String filterName = id.getName();

                    if (!JINJA_FILTERS.contains(filterName)) {
                        addError(
                                "Jinja: Undefined filter '" + filterName + "'",
                                id.getLine(),
                                id.getColumn()
                        );
                    }

                    for (ExpressionNode arg : call.getArguments()) {
                        checkJinjaExpression(arg, line, column);
                    }
                }

                return;
            }

            checkJinjaExpression(bin.getLeft(), line, column);
            checkJinjaExpression(bin.getRight(), line, column);

            return;
        }

        for (ASTNode child : expr.getChildren()) {
            checkJinjaExpression(child, line, column);
        }
    }

    private void checkUrlFor(CallExpressionNode call) {
        if (call.getArguments().isEmpty()) {
            addError("url_for() requires at least one argument (the endpoint name)",
                    call.getLine(), call.getColumn());
            return;
        }
        ExpressionNode firstArg = call.getArguments().get(0);
        if (firstArg instanceof StringLiteralNode str) {
            String endpoint = str.getValue().replace("'", "").replace("\"", "");
            Symbol sym = symbolTable.resolve(endpoint);
            if (sym == null || sym.getKind() != SymbolKind.FUNCTION) {
                addError("url_for(): endpoint '" + endpoint + "' is not a defined Flask route function",
                        call.getLine(), call.getColumn());
            }
        }
        for (int i = 1; i < call.getArguments().size(); i++) {
            checkJinjaExpression(call.getArguments().get(i), call.getLine(), call.getColumn());
        }
    }

    private void checkArithmeticTypes(String op, Type left, Type right, int line, int column) {
        if (left == Type.UNKNOWN || right == Type.UNKNOWN) return;

        if (left == right) return;

        boolean leftNumeric = left == Type.INT || left == Type.FLOAT || left == Type.BOOL;
        boolean rightNumeric = right == Type.INT || right == Type.FLOAT || right == Type.BOOL;
        if (leftNumeric && rightNumeric) return;
        if (op.equals("*") &&
                ((left == Type.STRING && right == Type.INT) ||
                        (left == Type.INT && right == Type.STRING))) {
            return;
        }

        addError(
                "Type mismatch: cannot apply operator '" + op + "' between " + left + " and " + right,
                line, column
        );
    }

    private Type inferJinjaFunctionType(String name) {
        return switch (name) {
            case "url_for" -> Type.STRING;
            case "get_flashed_messages" -> Type.LIST;
            case "format" -> Type.STRING;
            case "len" -> Type.INT;
            case "str" -> Type.STRING;
            default -> Type.UNKNOWN;
        };
    }

    private Symbol resolveJinjaSymbol(String name) {
        Symbol sym = symbolTable.resolve(name);
        if (sym == null) return null;
        if (sym.getKind() == SymbolKind.VARIABLE || sym.getKind() == SymbolKind.PARAMETER) {
            return null;
        }
        return sym;
    }

    private static final Set<String> IGNORE_UNDEFINED = new HashSet<>(Arrays.asList(
            "Flask", "render_template", "request", "redirect", "url_for", "flash",
            "next", "float", "int", "str", "bool", "len", "range", "print",
            "datetime", "app", "__name__", "jsonify", "session", "True", "False", "get_flashed_messages",
            "format", "super"
    ));

    private static final Set<String> JINJA_BUILTINS = new HashSet<>(Arrays.asList(
            "true", "false", "none", "loop", "self", "super",
            "cycler", "joiner", "namespace", "lipsum", "range", "dict"
    ));

    private static final Set<String> ARITHMETIC_OPS = Set.of("+", "-", "*", "/", "//", "%", "**");

    private static final Set<String> JINJA_FILTERS = new HashSet<>(Arrays.asList(
            "safe",
            "escape",
            "e",
            "capitalize",
            "lower",
            "upper",
            "title",
            "trim",
            "replace",
            "default",
            "length",
            "join",
            "sort",
            "reverse",
            "first",
            "last",
            "random",
            "round",
            "int",
            "float",
            "string",
            "list",
            "dict",
            "abs",
            "sum",
            "min",
            "max",
            "batch",
            "slice",
            "urlencode",
            "tojson",
            "format"
    ));
}