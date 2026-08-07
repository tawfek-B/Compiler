package generation;

import ast.core.*;
import ast.python.*;
import ast.html.HtmlAttributeNode;
import ast.html.HtmlDocumentNode;
import ast.html.HtmlTagNode;
import ast.css.CssDocumentNode;
import ast.jinja.*;

import java.util.List;

/**
 * This visitor only handles ast.core / ast.python node types. HTML, CSS and
 * Jinja node types are out of scope for this class (see HtmlJinjaEmitterVisitor)
 * and will throw if encountered, since a pure Python file's AST should never contain them.
 */
public class PythonEmitterVisitor implements ASTVisitor<String> {

    private static final String INDENT_UNIT = "    ";

    private int indentLevel = 0;

    private String indent() {
        return INDENT_UNIT.repeat(indentLevel);
    }

    public String emit(ASTNode root) {
        indentLevel = 0;
        String result = root.accept(this);
        return result == null ? "" : result;
    }

    private String joinExpressions(List<? extends ExpressionNode> exprs) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < exprs.size(); i++) {
            if (i > 0) sb.append(", ");
            sb.append(exprs.get(i).accept(this));
        }
        return sb.toString();
    }

    // ==================== Program / Block ====================

    @Override
    public String visit(ProgramNode node) {
        StringBuilder sb = new StringBuilder();
        for (ASTNode child : node.getChildren()) {
            String code = child.accept(this);
            if (code == null) continue;
            sb.append(code).append("\n");
            if (child instanceof FunctionDefNode) {
                sb.append("\n");
            }
        }
        return sb.toString();
    }

    @Override
    public String visit(BlockNode node) {
        indentLevel++;
        List<ASTNode> children = node.getChildren();
        StringBuilder sb = new StringBuilder();
        if (children.isEmpty()) {
            sb.append(indent()).append("pass");
        } else {
            boolean first = true;
            for (ASTNode child : children) {
                String code = child.accept(this);
                if (code == null) continue;
                if (!first) sb.append("\n");
                sb.append(indent()).append(code);
                first = false;
            }
        }
        indentLevel--;
        return sb.toString();
    }

    // ==================== Statement fallback dispatch ====================

    @Override
    public String visit(StatementNode node) {
        if (node instanceof FromImportNode fromImportNode) {
            return emitFromImport(fromImportNode);
        }
        if (node instanceof ImportNode importNode) {
            return emitImport(importNode);
        }
        if (node instanceof PassNode) {
            return "pass";
        }
        throw new UnsupportedOperationException(
                "PythonEmitterVisitor: unhandled StatementNode subtype " +
                        node.getClass().getSimpleName());
    }

    private String emitImport(ImportNode node) {
        if (node.getRawText() != null) return node.getRawText();
        return "import " + node.getModule().getName();
    }

    private String emitFromImport(FromImportNode node) {
        if (node.getRawText() != null) return node.getRawText();
        return "from " + node.getModule().getName() + " import " + node.getName().getName();
    }

    @Override
    public String visit(AssignmentNode node) {
        return node.getTarget().accept(this) + " = " + node.getValue().accept(this);
    }

    @Override
    public String visit(ReturnNode node) {
        ExpressionNode expr = node.getExpression();
        return expr == null ? "return" : "return " + expr.accept(this);
    }

    // ==================== Expression fallback dispatch ====================

    @Override
    public String visit(ExpressionNode node) {
        if (node instanceof NoneLiteralNode) {
            return "None";
        }
        if (node instanceof KeywordArgumentNode kw) {
            return kw.getKey() + "=" + kw.getValue().accept(this);
        }
        if (node instanceof ListComprehensionNode lc) {
            StringBuilder sb = new StringBuilder();
            sb.append("[").append(lc.getExpression().accept(this))
                    .append(" for ").append(lc.getVariable().accept(this))
                    .append(" in ").append(lc.getIterable().accept(this));
            if (lc.getCondition() != null) {
                sb.append(" if ").append(lc.getCondition().accept(this));
            }
            sb.append("]");
            return sb.toString();
        }
        if (node instanceof GeneratorExpressionNode ge) {
            StringBuilder sb = new StringBuilder();
            sb.append("(").append(ge.getResult().accept(this))
                    .append(" for ").append(ge.getVariable().accept(this))
                    .append(" in ").append(ge.getIterable().accept(this));
            if (ge.getCondition() != null) {
                sb.append(" if ").append(ge.getCondition().accept(this));
            }
            sb.append(")");
            return sb.toString();
        }
        if (node instanceof SubscriptionNode sub) {
            return sub.getObject().accept(this) + "[" + sub.getIndex().accept(this) + "]";
        }
        throw new UnsupportedOperationException(
                "PythonEmitterVisitor: unhandled ExpressionNode subtype " +
                        node.getClass().getSimpleName());
    }

    @Override
    public String visit(BinaryExpressionNode node) {
        return node.getLeft().accept(this) + " " + node.getOperator() + " " + node.getRight().accept(this);
    }

    @Override
    public String visit(UnaryExpressionNode node) {
        String operand = node.getOperand().accept(this);
        if ("not".equals(node.getOperator())) {
            return "not " + operand;
        }
        return node.getOperator() + operand;
    }

    @Override
    public String visit(CallExpressionNode node) {
        return node.getCallee().accept(this) + "(" + joinExpressions(node.getArguments()) + ")";
    }

    @Override
    public String visit(AttributeAccessNode node) {
        return node.getObject().accept(this) + "." + node.getAttribute();
    }

    // ==================== Identifiers & literals ====================

    @Override
    public String visit(IdentifierNode node) {
        return node.getName();
    }

    @Override
    public String visit(NumberLiteralNode node) {
        return node.getValue();
    }

    @Override
    public String visit(StringLiteralNode node) {
        return node.getValue();
    }

    @Override
    public String visit(BooleanLiteralNode node) {
        return node.getValue() ? "True" : "False";
    }

    @Override
    public String visit(NullLiteralNode node) {
        return "None";
    }

    // ==================== Statements ====================

    @Override
    public String visit(GlobalNode node) {
        return "global " + node.getName().accept(this);
    }

    @Override
    public String visit(FunctionDefNode node) {
        StringBuilder sb = new StringBuilder();
        List<DecoratorNode> decorators = node.getDecorators();
        for (DecoratorNode decorator : decorators) {
            sb.append(decorator.accept(this)).append("\n").append(indent());
        }
        sb.append("def ").append(node.getName()).append("(");
        List<ParameterNode> params = node.getParameters();
        for (int i = 0; i < params.size(); i++) {
            if (i > 0) sb.append(", ");
            sb.append(params.get(i).accept(this));
        }
        sb.append("):\n");
        sb.append(node.getBody().accept(this));
        return sb.toString();
    }

    @Override
    public String visit(ParameterNode parameterNode) {
        return parameterNode.getName();
    }

    @Override
    public String visit(DecoratorNode node) {
        return "@" + node.getExpression().accept(this);
    }

    @Override
    public String visit(IfNode node) {
        StringBuilder sb = new StringBuilder();
        sb.append("if ").append(node.getCondition().accept(this)).append(":\n");
        sb.append(node.getThenBlock().accept(this));
        for (ElifNode elif : node.getElifBlocks()) {
            sb.append("\n").append(indent()).append(elif.accept(this));
        }
        if (node.getElseBlock() != null) {
            sb.append("\n").append(indent()).append(node.getElseBlock().accept(this));
        }
        return sb.toString();
    }

    @Override
    public String visit(ElifNode node) {
        return "elif " + node.getCondition().accept(this) + ":\n" + node.getBlock().accept(this);
    }

    @Override
    public String visit(ElseNode node) {
        return "else:\n" + node.getBlock().accept(this);
    }

    @Override
    public String visit(WhileNode node) {
        return "while " + node.getCondition().accept(this) + ":\n" + node.getBody().accept(this);
    }

    @Override
    public String visit(ForNode node) {
        return "for " + node.getVariable().accept(this) + " in " +
                node.getIterable().accept(this) + ":\n" + node.getBody().accept(this);
    }

    @Override
    public String visit(TryNode node) {
        StringBuilder sb = new StringBuilder();
        sb.append("try:\n").append(node.getTryBlock().accept(this));
        for (ExceptNode except : node.getExceptBlocks()) {
            sb.append("\n").append(indent()).append(except.accept(this));
        }
        if (node.getFinallyBlock() != null) {
            sb.append("\n").append(indent()).append(node.getFinallyBlock().accept(this));
        }
        return sb.toString();
    }

    @Override
    public String visit(ExceptNode node) {
        StringBuilder sb = new StringBuilder("except");
        if (node.getExceptionType() != null) {
            sb.append(" ").append(node.getExceptionType().accept(this));
        }
        if (node.getAlias() != null) {
            sb.append(" as ").append(node.getAlias());
        }
        sb.append(":\n").append(node.getBlock().accept(this));
        return sb.toString();
    }

    @Override
    public String visit(FinallyNode node) {
        return "finally:\n" + node.getBlock().accept(this);
    }

    @Override
    public String visit(ListNode node) {
        return "[" + joinExpressions(node.getElements()) + "]";
    }

    @Override
    public String visit(DictNode node) {
        StringBuilder sb = new StringBuilder("{");
        List<KeyValueNode> entries = node.getEntries();
        for (int i = 0; i < entries.size(); i++) {
            if (i > 0) sb.append(", ");
            sb.append(entries.get(i).accept(this));
        }
        sb.append("}");
        return sb.toString();
    }

    @Override
    public String visit(KeyValueNode node) {
        return node.getKey().accept(this) + ": " + node.getValue().accept(this);
    }

    @Override
    public String visit(ComparisonNode node) {
        return node.getLeft().accept(this) + " " + node.getOperator() + " " + node.getRight().accept(this);
    }

    @Override
    public String visit(LogicalExpressionNode node) {
        return node.getLeft().accept(this) + " " + node.getOperator() + " " + node.getRight().accept(this);
    }

    @Override
    public String visit(BreakNode node) {
        return "break";
    }

    @Override
    public String visit(ContinueNode node) {
        return "continue";
    }

    @Override
    public String visit(ArgumentListNode argumentListNode) {
        return joinExpressions(argumentListNode.getArguments());
    }

    @Override
    public String visit(TupleExpressionNode node) {
        List<ExpressionNode> elements = node.getElements();
        String joined = joinExpressions(elements);
        if (elements.size() == 1) {
            joined = joined + ","; // single-element tuple needs the trailing comma
        }
        return "(" + joined + ")";
    }

    @Override
    public String visit(MixedWebNode mixedWebNode) {
        StringBuilder sb = new StringBuilder();
        for (ASTNode module : mixedWebNode.getPythonModules()) {
            String code = module.accept(this);
            if (code == null) continue;
            sb.append(code).append("\n\n");
        }
        return sb.toString();
    }


    private String unsupported(String nodeName) {
        throw new UnsupportedOperationException(
                "PythonEmitterVisitor does not handle " + nodeName +
                        " — use HtmlJinjaEmitterVisitor for template files.");
    }

    @Override
    public String visit(HtmlDocumentNode node) {
        return unsupported("HtmlDocumentNode");
    }

    @Override
    public String visit(JinjaExpressionNode node) {
        return unsupported("JinjaExpressionNode");
    }

    @Override
    public String visit(JinjaWithAssignmentNode node) {
        return unsupported("JinjaWithAssignmentNode");
    }

    @Override
    public String visit(JinjaEndNode node) {
        return unsupported("JinjaEndNode");
    }

    @Override
    public String visit(JinjaBlockNode node) {
        return unsupported("JinjaBlockNode");
    }

    @Override
    public String visit(JinjaIfNode node) {
        return unsupported("JinjaIfNode");
    }

    @Override
    public String visit(JinjaExtendNode node) {
        return unsupported("JinjaExtendNode");
    }

    @Override
    public String visit(JinjaElseNode node) {
        return unsupported("JinjaElseNode");
    }

    @Override
    public String visit(JinjaForNode node) {
        return unsupported("JinjaForNode");
    }

    @Override
    public String visit(CssDocumentNode node) {
        return unsupported("CssDocumentNode");
    }

    @Override
    public String visit(HtmlTagNode node) {
        return unsupported("HtmlTagNode");
    }

    @Override
    public String visit(HtmlAttributeNode node) {
        return unsupported("HtmlAttributeNode");
    }
}