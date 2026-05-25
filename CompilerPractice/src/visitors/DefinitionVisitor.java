package visitors;

import ast.core.*;
import ast.css.CssDocumentNode;
import ast.css.CssRuleNode;
import ast.css.CssSelectorNode;
import ast.html.HtmlDocumentNode;
import ast.html.HtmlTagNode;
import ast.jinja.JinjaBlockNode;
import ast.jinja.JinjaExpressionNode;
import ast.python.*;
import table.*;


public class DefinitionVisitor implements ASTVisitor<Void> {

    private final SymbolTable symbolTable;
    private final LabelTable labelTable;

    public DefinitionVisitor(SymbolTable symbolTable, LabelTable labelTable) {
        this.symbolTable = symbolTable;
        this.labelTable = labelTable;
    }

    private Type inferType(ASTNode node) {
        if (node == null) return Type.UNKNOWN;

        if (node instanceof NumberLiteralNode n) {
            return n.getValue().contains(".") ? Type.FLOAT : Type.INT;
        }
        if (node instanceof StringLiteralNode) return Type.STRING;
        if (node instanceof BooleanLiteralNode) return Type.BOOLEAN;
        if (node instanceof ListNode) return Type.LIST;
        if (node instanceof DictNode) return Type.DICT;
        if (node instanceof CallExpressionNode) return Type.UNKNOWN; // to improve later
        if (node instanceof ListComprehensionNode) return Type.LIST;

        return Type.UNKNOWN;
    }

    // program

    @Override
    public Void visit(ProgramNode node) {
        for (ASTNode child : node.getChildren()) {
            child.accept(this);
        }
        return null;
    }

    // block

    @Override
    public Void visit(BlockNode node) {
        symbolTable.enterScope("block_" + node.getLine());
        for (ASTNode stmt : node.getChildren()) {
            stmt.accept(this);
        }
        symbolTable.exitScope();
        return null;
    }

    @Override
    public Void visit(StatementNode node) {
        return null;
    }

    @Override
    public Void visit(GlobalNode node) {
        for (IdentifierNode id : node.getNames()) {
            // Mark as global (you can add special handling later)
            System.out.println("Global declared: " + id.getName());
        }
        return null;
    }

    // functions

    @Override
    public Void visit(FunctionDefNode node) {

        FunctionSymbol functionSymbol = new FunctionSymbol(
                node.getName(),
                Type.FUNCTION,
                java.util.List.of(),
                node.getLine(),
                node.getColumn()
        );

        if(!symbolTable.define(functionSymbol)){
            System.out.println("ERROR: Function:"+ node.getName() + "already defined");
        }
        labelTable.generateLabel(functionSymbol);
        symbolTable.enterScope("function_"+ node.getName());

        for (ParameterNode param : node.getParameters()) {
            Symbol paramSymbol = new Symbol(
                    param.getName(),
                    Type.UNKNOWN,
                    SymbolKind.PARAMETER,
                    param.getLine(),
                    param.getColumn()
            );
            if (!symbolTable.define(paramSymbol)) {
                System.out.println("Error: Duplicate paramSymbol " + paramSymbol.getName());
            }
        }

        if (node.getBody() != null) {
            node.getBody().accept(this);
        }
        symbolTable.exitScope();
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

    // assignment

    @Override
    public Void visit(AssignmentNode node) {
        IdentifierNode id = node.getTarget();

        // Define variable if not already exists
        if (!symbolTable.existsInCurrentScope(id.getName())) {
            Type inferredType = inferType(node.getValue());

            Symbol varSymbol = new Symbol(
                    id.getName(),
                    inferredType,
                    SymbolKind.VARIABLE,
                    id.getLine(),
                    id.getColumn()
            );

            if (!symbolTable.define(varSymbol)) {
                System.out.println("Warning: Duplicate variable " + id.getName());
            }
        }

        if (node.getValue() != null) {
            node.getValue().accept(this);
        }

        return null;
    }


    // if statements

    @Override
    public Void visit(IfNode node) {

        if (node.getCondition() != null) {
            node.getCondition().accept(this);
        }
        if (node.getThenBlock() != null) {
            symbolTable.enterScope("if_" + node.getLine());
            node.getThenBlock().accept(this);
            symbolTable.exitScope();
        }


        for (ElifNode elif : node.getElifBlocks()) {
            if (elif.getCondition() != null) {
                elif.getCondition().accept(this);
            }
                symbolTable.enterScope("elif_" + node.getLine());
                elif.getBlock().accept(this);
                symbolTable.exitScope();

        }

        if (node.getElseBlock() != null) {
            symbolTable.enterScope("else_" + node.getLine());
            node.getElseBlock().accept(this);
            symbolTable.exitScope();
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

    // loops

    @Override
    public Void visit(WhileNode node) {

        if (node.getCondition() != null) {
            node.getCondition().accept(this);
        }

        symbolTable.enterScope("while_" + node.getLine());

        if (node.getBody() != null) {
            node.getBody().accept(this);
        }

        symbolTable.exitScope();

        return null;
    }

    @Override
    public Void visit(ForNode node) {

        symbolTable.enterScope("for_" + node.getLine());

        Type inferredType = inferType(node.getVariable());
        Symbol loopVar = new Symbol(
                node.getVariable().getName(),
                inferredType,
                SymbolKind.VARIABLE,
                node.getVariable().getLine(),
                node.getVariable().getColumn()
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

        symbolTable.exitScope();

        return null;
    }

    // try and except blocks

    @Override
    public Void visit(TryNode node) {


        symbolTable.enterScope("try_" + node.getLine());
        node.getTryBlock().accept(this);
        symbolTable.exitScope();

        for (ExceptNode e : node.getExceptBlocks()) {
            symbolTable.enterScope("except_" + node.getLine());
            e.getBlock().accept(this);
            symbolTable.exitScope();
        }

        if (node.getFinallyBlock() != null) {
            symbolTable.enterScope("finally_" + node.getLine());
            node.getFinallyBlock().accept(this);
            symbolTable.exitScope();
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

    // expressions

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

        String blockName = node.getName();

        if (blockName.equals("end") || blockName.equals("endblock")) {
            return null;
        }

        // Optional: label
        labelTable.generateBlockLabel(blockName);

        symbolTable.enterScope("jinja_" + blockName + "_" + node.getLine());

        for (ASTNode child : node.getChildren()) {
            child.accept(this);
        }

        symbolTable.exitScope();

        return null;
    }

    @Override
    public Void visit(CssDocumentNode node) {

        for (CssRuleNode rule : node.getRules()) {
            rule.accept(this);

            for (CssSelectorNode sel : rule.getSelectors()) {
                String selector = sel.getSelector().trim();

                // Split by combinators: space, >, +, ~
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
                                sel.getColumn()
                        );
                    } else if (part.startsWith("#")) {
                        symbol = new Symbol(
                                part.substring(1),
                                Type.UNKNOWN,
                                SymbolKind.CSS_ID,
                                sel.getLine(),
                                sel.getColumn()
                        );
                    } else {
                        symbol = new Symbol(
                                part,
                                Type.UNKNOWN,
                                SymbolKind.CSS_TAG,
                                sel.getLine(),
                                sel.getColumn()
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
        // Optional debug: System.out.println("Visiting HTML tag: " + node.getTagName());

//        Symbol tagSymbol = new Symbol(
//                node.getTagName(),
//                Type.UNKNOWN,
//                SymbolKind.HTML_TAG,
//                node.getLine(),
//                node.getColumn()
//        );
//
//        if (!symbolTable.define(tagSymbol)) {
//            System.out.println("Error: Duplicate tagSymbol " + tagSymbol.getName());
//        }
//
//        for (var attr : node.getAttributes()) {
//            Symbol attrSymbol = new Symbol(
//                    attr.getName(),
//                    Type.UNKNOWN,
//                    SymbolKind.HTML_ATTRIBUTE,
//                    attr.getLine(),
//                    attr.getColumn()
//            );
//
//            if (!symbolTable.define(attrSymbol)) {
//                System.out.println("Error: Duplicate attribute " + attr.getName());
//            }
//        }

        // IMPORTANT: Recurse into all children (attributes, content, CSS document, etc.)
        for (ASTNode child : node.getChildren()) {
            child.accept(this);
        }

        return null;
    }

    // 2. Visit Jinja Expression (e.g. {{ product.name }}, {{ url_for('...') }})
    @Override
    public Void visit(JinjaExpressionNode node) {
        // Recurse into the parsed expression to collect variables/functions
        if (node.getExpression() != null) {
            collectJinjaVariables(node.getExpression(), node.getLine(), node.getColumn());
        }
        return null;
    }

    private void collectJinjaVariables(ASTNode expr, int line, int column) {
        if (expr == null) return;

        if (expr instanceof IdentifierNode id) {

            String baseName = id.getName().split("\\.")[0];

            // ❌ ignore function calls
            if (id.getName().contains("(")) return;

            // ✅ FIX: define only if not exists in CURRENT scope
            if (!symbolTable.existsInCurrentScope(baseName)) {
                Symbol jinjaVarSymbol = new Symbol(
                        baseName,
                        Type.UNKNOWN,
                        SymbolKind.JINJA_VARIABLE,
                        line,
                        column
                );
                symbolTable.define(jinjaVarSymbol);
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
                            Type.UNKNOWN,
                            SymbolKind.JINJA_FUNCTION,
                            line,
                            column
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

}
