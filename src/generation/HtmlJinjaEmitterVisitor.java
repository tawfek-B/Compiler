package generation;

import ast.core.*;
import ast.python.*;
import ast.html.*;
import ast.css.*;
import ast.jinja.*;

import java.util.List;
import java.util.Set;

public class HtmlJinjaEmitterVisitor implements HtmlWithCssVisitor<String> {

    private static final String INDENT_UNIT = "    ";

    private int indentLevel = 0;

    private String indent() {
        return INDENT_UNIT.repeat(indentLevel);
    }

    private static final Set<String> VOID_ELEMENTS = Set.of(
            "area", "base", "br", "col", "embed", "hr", "img", "input",
            "link", "meta", "param", "source", "track", "wbr"
    );

    /** Entry point reset state and emit source for the given root. */
    public String emit(ASTNode root) {
        indentLevel = 0;
        String result = root.accept(this);
        return result == null ? "" : result;
    }

    // ==================== Shared expression rendering ====================

    private String renderExpr(ASTNode node) {
        if (node == null) return "";

        if (node instanceof IdentifierNode n) return n.getName();
        if (node instanceof NumberLiteralNode n) return n.getValue();
//        if (node instanceof StringLiteralNode n) return n.getValue();
        if (node instanceof StringLiteralNode n) {
            String v = n.getValue();
            if (v != null && v.length() >= 2 &&
                    ((v.startsWith("\"") && v.endsWith("\"")) || (v.startsWith("'") && v.endsWith("'")))) {
                return v;
            }
            return "'" + v + "'";
        }
        if (node instanceof BooleanLiteralNode n) return n.getValue() ? "true" : "false";
        if (node instanceof NoneLiteralNode) return "none";
        if (node instanceof NullLiteralNode) return "none";

        if (node instanceof BinaryExpressionNode n) {
            return renderExpr(n.getLeft()) + " " + n.getOperator() + " " + renderExpr(n.getRight());
        }
        if (node instanceof UnaryExpressionNode n) {
            String operand = renderExpr(n.getOperand());
            return "not".equals(n.getOperator()) ? "not " + operand : n.getOperator() + operand;
        }
        if (node instanceof ComparisonNode n) {
            return renderExpr(n.getLeft()) + " " + n.getOperator() + " " + renderExpr(n.getRight());
        }
        if (node instanceof LogicalExpressionNode n) {
            return renderExpr(n.getLeft()) + " " + n.getOperator() + " " + renderExpr(n.getRight());
        }
        if (node instanceof AttributeAccessNode n) {
            return renderExpr(n.getObject()) + "." + n.getAttribute();
        }
        if (node instanceof SubscriptionNode n) {
            return renderExpr(n.getObject()) + "[" + renderExpr(n.getIndex()) + "]";
        }
        if (node instanceof CallExpressionNode n) {
            StringBuilder sb = new StringBuilder();
            sb.append(renderExpr(n.getCallee())).append("(");
            List<ExpressionNode> args = n.getArguments();
            for (int i = 0; i < args.size(); i++) {
                if (i > 0) sb.append(", ");
                sb.append(renderExpr(args.get(i)));
            }
            sb.append(")");
            return sb.toString();
        }
        if (node instanceof KeywordArgumentNode n) {
            return n.getKey() + "=" + renderExpr(n.getValue());
        }
        if (node instanceof ListNode n) {
            StringBuilder sb = new StringBuilder("[");
            List<ExpressionNode> els = n.getElements();
            for (int i = 0; i < els.size(); i++) {
                if (i > 0) sb.append(", ");
                sb.append(renderExpr(els.get(i)));
            }
            sb.append("]");
            return sb.toString();
        }
        if (node instanceof DictNode n) {
            StringBuilder sb = new StringBuilder("{");
            List<KeyValueNode> entries = n.getEntries();
            for (int i = 0; i < entries.size(); i++) {
                if (i > 0) sb.append(", ");
                sb.append(renderExpr(entries.get(i)));
            }
            sb.append("}");
            return sb.toString();
        }
        if (node instanceof KeyValueNode n) {
            return renderExpr(n.getKey()) + ": " + renderExpr(n.getValue());
        }
        if (node instanceof TupleExpressionNode n) {
            List<ExpressionNode> els = n.getElements();
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < els.size(); i++) {
                if (i > 0) sb.append(", ");
                sb.append(renderExpr(els.get(i)));
            }
            return sb.toString();
        }
        if (node instanceof JinjaWithAssignmentNode n) {
            return n.getName() + "=" + renderExpr(n.getValue());
        }

        throw new UnsupportedOperationException(
                "HtmlJinjaEmitterVisitor: unhandled expression node " + node.getClass().getSimpleName());
    }

    private String renderBody(List<ASTNode> body) {
        StringBuilder sb = new StringBuilder();
        for (ASTNode child : body) {
            String code = child.accept(this);
            if (code == null || code.isEmpty()) continue;
            boolean inline = (child instanceof HtmlTextNode) || (child instanceof JinjaExpressionNode);
            if (inline) {
                sb.append(indent()).append(code).append("\n");
            } else {
                sb.append(code).append("\n");
            }
        }
        return sb.toString();
    }
    // ==================== HTML ====================

    @Override
    public String visit(HtmlDocumentNode node) {
        StringBuilder sb = new StringBuilder();
        for (ASTNode child : node.getChildren()) {
            String code = child.accept(this);
            if (code == null) continue;
            sb.append(code).append("\n");
        }
        return sb.toString();
    }

    @Override
    public String visit(HtmlDoctypeNode node) {
        return node.getText();
    }

    @Override
    public String visit(HtmlTagNode node) {
        StringBuilder sb = new StringBuilder();
        sb.append(indent()).append("<").append(node.getTagName());

        for (HtmlAttributeNode attr : node.getAttributes()) {
            sb.append(" ").append(renderAttribute(attr));
        }

        List<ASTNode> body = node.getChildren().stream()
                .filter(c -> !(c instanceof HtmlAttributeNode))
                .toList();

        if (body.isEmpty()) {
            if (VOID_ELEMENTS.contains(node.getTagName())) {
                sb.append(" />");
            } else {
                sb.append("></").append(node.getTagName()).append(">");
            }
            return sb.toString();
        }

        sb.append(">");

        boolean allInline = body.stream().allMatch(c -> c instanceof HtmlTextNode || c instanceof JinjaExpressionNode);
        if (allInline) {
            for (ASTNode child : body) {
                String code = child.accept(this);
                if (code != null) sb.append(code);
            }
            sb.append("</").append(node.getTagName()).append(">");
            return sb.toString();
        }

        sb.append("\n");
        indentLevel++;
        for (ASTNode child : body) {
            String code = child.accept(this);
            if (code == null) continue;
            boolean needsOwnIndent = !(child instanceof HtmlTextNode) && !(child instanceof JinjaExpressionNode);
            if (needsOwnIndent) {
                sb.append(code).append("\n");
            } else {
                sb.append(indent()).append(code).append("\n");
            }
        }
        indentLevel--;
        sb.append(indent()).append("</").append(node.getTagName()).append(">");
        return sb.toString();
    }

    private String renderAttribute(HtmlAttributeNode attr) {
        List<ASTNode> children = attr.getChildren();
        if (!children.isEmpty()) {
            StringBuilder value = new StringBuilder();
            for (ASTNode child : children) {
                if (child instanceof HtmlTextNode text) {
                    value.append(text.getText());
                } else if (child instanceof JinjaExpressionNode expr) {
                    value.append("{{ ").append(renderExpr(expr.getExpression())).append(" }}");
                } else {
                    String code = child.accept(this);
                    if (code != null) value.append(code);
                }
            }
            return attr.getName() + "=\"" + value + "\"";
        }

        String value = attr.getValue();
        if (value == null || value.isEmpty()) {
            return attr.getName();
        }
        return attr.getName() + "=\"" + value + "\"";
    }

    @Override
    public String visit(HtmlAttributeNode node) {
        return renderAttribute(node);
    }

    @Override
    public String visit(HtmlTextNode node) {
        return node.getText();
    }

    @Override
    public String visit(HtmlCommentNode node) {
        String comment = node.getComment();
        if (comment != null && comment.trim().startsWith("<!--")) {
            return indent() + comment;
        }
        return indent() + "<!--" + comment + "-->";
    }

    @Override
    public String visit(CDataNode node) {
        return indent() + "<![CDATA[" + node.getData() + "]]>";
    }

    @Override
    public String visit(HtmlNode node) {
        throw new UnsupportedOperationException(
                "HtmlJinjaEmitterVisitor: unhandled bare HtmlNode (expected a concrete subtype)");
    }

    // ==================== CSS ====================

    @Override
    public String visit(CssDocumentNode node) {
        StringBuilder sb = new StringBuilder();
        List<CssRuleNode> rules = node.getRules();
        for (int i = 0; i < rules.size(); i++) {
            String code = rules.get(i).accept(this);
            if (code == null) continue;
            sb.append(code);
            if (i < rules.size() - 1) sb.append("\n\n");
        }
        return sb.toString();
    }

    @Override
    public String visit(CssRuleNode node) {
        StringBuilder sb = new StringBuilder();
        List<CssSelectorNode> selectors = node.getSelectors();
        for (int i = 0; i < selectors.size(); i++) {
            if (i > 0) sb.append(", ");
            sb.append(selectors.get(i).getSelector());
        }
        sb.append(" {\n");
        for (CssDeclarationNode decl : node.getDeclarations()) {
            sb.append(decl.accept(this)).append("\n");
        }
        sb.append("}");
        return sb.toString();
    }

    @Override
    public String visit(CssSelectorNode node) {
        return node.getSelector();
    }

    @Override
    public String visit(CssDeclarationNode node) {
        return "    " + node.getProperty() + ": " + node.getValue() +
                (node.isImportant() ? " !important" : "") + ";";
    }

    @Override
    public String visit(CssAtRuleNode node) {
        return "@" + node.getName() + " " + node.getValue() + ";";
    }


    @Override
    public String visit(CssMediaRuleNode node) {
        throw new UnsupportedOperationException(
                "HtmlJinjaEmitterVisitor: @media emission not implemented (not yet produced by the CSS builder)");
    }

    @Override
    public String visit(CssMediaQueryNode node) {
        throw new UnsupportedOperationException(
                "HtmlJinjaEmitterVisitor: @media query emission not implemented (not yet produced by the CSS builder)");
    }

    @Override
    public String visit(CssKeyframesNode node) {
        throw new UnsupportedOperationException(
                "HtmlJinjaEmitterVisitor: @keyframes emission not implemented (not yet produced by the CSS builder)");
    }

    @Override
    public String visit(CssKeyframeBlockNode node) {
        throw new UnsupportedOperationException(
                "HtmlJinjaEmitterVisitor: @keyframes block emission not implemented (not yet produced by the CSS builder)");
    }

    @Override
    public String visit(CssKeyframeSelectorNode node) {
        throw new UnsupportedOperationException(
                "HtmlJinjaEmitterVisitor: keyframe selector emission not implemented (no getter exists for its selector field)");
    }

    @Override
    public String visit(CssKeyframeDeclarationNode node) {
        throw new UnsupportedOperationException(
                "HtmlJinjaEmitterVisitor: keyframe declaration emission not implemented (not yet produced by the CSS builder)");
    }

    @Override
    public String visit(CssMarginRuleNode node) {
        throw new UnsupportedOperationException(
                "HtmlJinjaEmitterVisitor: CSS margin-rule emission not implemented (not yet produced by the CSS builder)");
    }

    @Override
    public String visit(CssNode node) {
        throw new UnsupportedOperationException(
                "HtmlJinjaEmitterVisitor: unhandled bare CssNode (expected a concrete subtype)");
    }

    // ==================== Jinja ====================

    @Override
    public String visit(JinjaExpressionNode node) {
        return "{{ " + renderExpr(node.getExpression()) + " }}";
    }

    @Override
    public String visit(JinjaBlockNode node) {
        List<ASTNode> rawBody = node.getBody();
        List<ASTNode> body = rawBody.stream()
                .filter(n -> !(n instanceof JinjaWithAssignmentNode))
                .toList();

        int splitIndex = node.getElseStartIndex();
        boolean hasElse = node.getElseBlock() != null && splitIndex >= 0 && splitIndex <= rawBody.size();

        int filteredSplitIndex = 0;
        if (hasElse) {
            for (int i = 0; i < splitIndex; i++) {
                if (!(rawBody.get(i) instanceof JinjaWithAssignmentNode)) filteredSplitIndex++;
            }
        }

        List<ASTNode> mainBody = hasElse ? body.subList(0, filteredSplitIndex) : body;
        List<ASTNode> elseBody = hasElse ? body.subList(filteredSplitIndex, body.size()) : List.of();

        String header;
        String closeTag;

        switch (node.getJinjaType()) {
            case IF -> {
                header = "if " + renderExpr(node.getCondition());
                closeTag = "endif";
            }
            case FOR -> {
                header = "for " + renderExpr(node.getLoopVariable()) + " in " + renderExpr(node.getIterable());
                closeTag = "endfor";
            }
            case WITH -> {
                StringBuilder assigns = new StringBuilder();
                List<JinjaWithAssignmentNode> assignments = node.getAssignments();
                for (int i = 0; i < assignments.size(); i++) {
                    if (i > 0) assigns.append(", ");
                    JinjaWithAssignmentNode a = assignments.get(i);
                    assigns.append(a.getName()).append("=").append(renderExpr(a.getValue()));
                }
                header = "with " + assigns;
                closeTag = "endwith";
            }
            case BLOCK -> {
                header = "block " + renderExpr(node.getBlockName());
                closeTag = "endblock";
            }
            default -> {
                header = renderExpr(node.getBlockName());
                closeTag = null;
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(indent()).append("{% ").append(header).append(" %}\n");

        indentLevel++;
        String mainText = renderBody(mainBody);
        sb.append(mainText);
        if (!mainText.isEmpty() && !mainText.endsWith("\n")) sb.append("\n");
        indentLevel--;

        if (hasElse) {
            sb.append(indent()).append("{% else %}\n");
            indentLevel++;
            String elseText = renderBody(elseBody);
            sb.append(elseText);
            if (!elseText.isEmpty() && !elseText.endsWith("\n")) sb.append("\n");
            indentLevel--;
        }

        if (closeTag != null) {
            sb.append(indent()).append("{% ").append(closeTag).append(" %}\n");
        }

        return sb.toString();
    }

    @Override
    public String visit(JinjaCommentNode node) {
        return indent() + node.getComment() + "\n";
    }

    @Override
    public String visit(JinjaRawHtmlNode node) {
        return indent() + "{% raw %}" + node.getHtml() + "{% endraw %}\n";
    }

    @Override
    public String visit(JinjaEndNode jinjaEndNode) {
        return indent() + "{% " + jinjaEndNode.getRaw() + " %}\n";
    }

    @Override
    public String visit(JinjaExtendNode jinjaExtendNode) {
        return indent() + "{% extends " + jinjaExtendNode.getPath() + " %}\n";
    }

    @Override
    public String visit(JinjaNode node) {
        if (node instanceof JinjaElseNode) {
            return indent() + "{% else %}\n";
        }
        throw new UnsupportedOperationException(
                "HtmlJinjaEmitterVisitor: unhandled bare JinjaNode " + node.getClass().getSimpleName());
    }

    @Override
    public String visit(JinjaDocumentNode node) {
        StringBuilder sb = new StringBuilder();
        for (ASTNode child : node.getChildren()) {
            String code = child.accept(this);
            if (code != null) sb.append(code);
        }
        return sb.toString();
    }

    @Override
    public String visit(JinjaForNode node) {
        throw new UnsupportedOperationException(
                "HtmlJinjaEmitterVisitor: JinjaForNode is not constructed by the current builder " +
                        "(for-loops are represented via JinjaBlockNode with BlockType.FOR)");
    }

    @Override
    public String visit(JinjaIfNode node) {
        throw new UnsupportedOperationException(
                "HtmlJinjaEmitterVisitor: JinjaIfNode is not constructed by the current builder " +
                        "(if-blocks are represented via JinjaBlockNode with BlockType.IF)");
    }

    @Override
    public String visit(JinjaVarNode node) {
        throw new UnsupportedOperationException(
                "HtmlJinjaEmitterVisitor: JinjaVarNode is not constructed by the current builder " +
                        "(variable expressions are represented via JinjaExpressionNode)");
    }


    @Override
    public String visit(ExpressionNode node) {
        return renderExpr(node);
    }

    @Override
    public String visit(BinaryExpressionNode node) {
        return renderExpr(node);
    }

    @Override
    public String visit(UnaryExpressionNode node) {
        return renderExpr(node);
    }

    @Override
    public String visit(CallExpressionNode node) {
        return renderExpr(node);
    }

    @Override
    public String visit(IdentifierNode node) {
        return renderExpr(node);
    }

    @Override
    public String visit(NumberLiteralNode node) {
        return renderExpr(node);
    }

    @Override
    public String visit(StringLiteralNode node) {
        return renderExpr(node);
    }

    @Override
    public String visit(BooleanLiteralNode node) {
        return renderExpr(node);
    }

    @Override
    public String visit(NullLiteralNode node) {
        return renderExpr(node);
    }

    private String unsupported(String nodeName) {
        throw new UnsupportedOperationException(
                "HtmlJinjaEmitterVisitor does not handle " + nodeName +
                        " -- use PythonEmitterVisitor for Python files.");
    }

    @Override
    public String visit(ProgramNode node) {
        return unsupported("ProgramNode");
    }

    @Override
    public String visit(BlockNode node) {
        return unsupported("BlockNode");
    }

    @Override
    public String visit(StatementNode node) {
        return unsupported("StatementNode");
    }

    @Override
    public String visit(AssignmentNode node) {
        return unsupported("AssignmentNode");
    }

    @Override
    public String visit(ReturnNode node) {
        return unsupported("ReturnNode");
    }

    @Override
    public String visit(MixedWebNode mixedWebNode) {
        StringBuilder sb = new StringBuilder();
        for (ASTNode child : mixedWebNode.getChildren()) {
            String code = child.accept(this);
            if (code != null) sb.append(code).append("\n");
        }
        return sb.toString();
    }
}