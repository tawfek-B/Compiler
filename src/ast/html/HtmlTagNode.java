package ast.html;

import ast.core.ASTNode;
import ast.core.ASTVisitor;
import ast.core.HtmlWithCssVisitor;

import java.util.List;

public class HtmlTagNode extends HtmlNode {
    private String tagName;
    private List<HtmlAttributeNode> attributes;

    public HtmlTagNode(String tagName, int line, int column) {
        super("Html Tag Node", line,  column);
        this.tagName = tagName;
        this.attributes = new java.util.ArrayList<>();
    }

    public void addAttribute(HtmlAttributeNode attribute) {
        attributes.add(attribute);
        add(attribute); // add to children
        attribute.setParent(this);
    }

    public List<HtmlAttributeNode> getAttributes() { return attributes; }

    public String getTagName() {
        return tagName;
    }

    public List<ASTNode> getChildren() {
        return super.getChildren(); // already includes attributes + body
    }

    @Override
    public String toString() {
        String node = "<" + tagName + ">\n\t";
        for (HtmlAttributeNode attribute : attributes) {
            node += "\n\t";
            node += (attribute.getName() + ": " + attribute.getValue());
        }
        return node;
    }

    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visit(this);
    }

    @Override
    public <T> T accept(HtmlWithCssVisitor<T> visitor) { return visitor.visit(this); }

}