package generation;

import ast.core.*;
import ast.python.*;
import ast.html.*;
import ast.css.*;
import ast.jinja.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Serializes an AST (Python or HTML/Jinja) to a simple, consistent JSON
 * shape: { type, label, line, column, children }, recursively. Deliberately
 * not a per-node-type field schema
 * a "type + human-readable label + children"
 */
public class ASTJsonSerializer {

    public String serialize(ASTNode root) {
        return serialize(root, 0);
    }

    /** depth controls the starting indentation, so callers can nest this
     *  output inside their own JSON */
    public String serialize(ASTNode root, int depth) {
        StringBuilder sb = new StringBuilder();
        writeNode(root, sb, depth);
        return sb.toString();
    }

    private void indent(StringBuilder sb, int depth) {
        sb.append("  ".repeat(depth));
    }

    private void writeNode(ASTNode node, StringBuilder sb, int depth) {
        if (node == null) {
            sb.append("null");
            return;
        }

        sb.append("{\n");
        indent(sb, depth + 1);
        sb.append("\"type\": ").append(quote(node.getClass().getSimpleName())).append(",\n");
        indent(sb, depth + 1);
        sb.append("\"label\": ").append(quote(label(node))).append(",\n");
        indent(sb, depth + 1);
        sb.append("\"line\": ").append(node.getLine()).append(",\n");
        indent(sb, depth + 1);
        sb.append("\"column\": ").append(node.getColumn()).append(",\n");

        List<ASTNode> children = childrenOf(node);

        indent(sb, depth + 1);
        sb.append("\"children\": [");
        if (!children.isEmpty()) {
            sb.append("\n");
            for (int i = 0; i < children.size(); i++) {
                indent(sb, depth + 2);
                writeNode(children.get(i), sb, depth + 2);
                if (i < children.size() - 1) sb.append(",");
                sb.append("\n");
            }
            indent(sb, depth + 1);
        }
        sb.append("]\n");

        indent(sb, depth);
        sb.append("}");
    }

    private List<ASTNode> childrenOf(ASTNode node) {
        if (node instanceof CssDocumentNode css) {
            return new ArrayList<>(css.getRules());
        }
        return node.getChildren();
    }

    private String label(ASTNode node) {
        if (node instanceof IdentifierNode n) return "Identifier: " + n.getName();
        if (node instanceof StringLiteralNode n) return "String: " + n.getValue();
        if (node instanceof NumberLiteralNode n) return "Number: " + n.getValue();
        if (node instanceof BooleanLiteralNode n) return "Boolean: " + n.getValue();
        if (node instanceof NoneLiteralNode) return "None";
        if (node instanceof FunctionDefNode n) return "FunctionDef: " + n.getName();
        if (node instanceof ParameterNode n) return "Parameter: " + n.getName();
        if (node instanceof ComparisonNode n) return "Comparison: " + n.getOperator();
        if (node instanceof BinaryExpressionNode n) return "BinaryOp: " + n.getOperator();
        if (node instanceof LogicalExpressionNode n) return "LogicalOp: " + n.getOperator();
        if (node instanceof UnaryExpressionNode n) return "UnaryOp: " + n.getOperator();
        if (node instanceof AttributeAccessNode n) return "Attribute: ." + n.getAttribute();
        if (node instanceof GlobalNode n) return "Global: " + n.getName().getName();
        if (node instanceof HtmlTagNode n) return "<" + n.getTagName() + ">";
        if (node instanceof HtmlAttributeNode n) return "Attribute: " + n.getName();
        if (node instanceof HtmlTextNode) return "Text";
        if (node instanceof HtmlCommentNode) return "Comment";
        if (node instanceof HtmlDoctypeNode n) return "Doctype: " + n.getText();
        if (node instanceof JinjaBlockNode n) return "JinjaBlock: " + n.getJinjaType();
        if (node instanceof JinjaExpressionNode) return "JinjaExpression";
        if (node instanceof JinjaExtendNode n) return "Extends: " + n.getPath();
        if (node instanceof CssRuleNode) return "CssRule";
        if (node instanceof CssSelectorNode n) return "Selector: " + n.getSelector();
        if (node instanceof CssDeclarationNode n) return "Declaration: " + n.getProperty() + "=" + n.getValue();
        return node.getClass().getSimpleName();
    }

    private String quote(String s) {
        if (s == null) return "null";
        StringBuilder sb = new StringBuilder("\"");
        for (char c : s.toCharArray()) {
            switch (c) {
                case '"' -> sb.append("\\\"");
                case '\\' -> sb.append("\\\\");
                case '\n' -> sb.append("\\n");
                case '\t' -> sb.append("\\t");
                case '\r' -> sb.append("\\r");
                default -> {
                    if (c < 0x20) sb.append(String.format("\\u%04x", (int) c));
                    else sb.append(c);
                }
            }
        }
        sb.append("\"");
        return sb.toString();
    }
}