package ast.html;

import ast.HtmlWithCssVisitor;
import ast.core.ASTNode;
import java.util.List;

public class HtmlTagNode extends HtmlNode {
    private String tagName;
    private List<HtmlAttributeNode> attributes;

    public HtmlTagNode(String tagName, int line) {
        super("Html Tag Node", line);
        this.tagName = tagName;
        this.attributes = new java.util.ArrayList<>();
    }

    public void addAttribute(HtmlAttributeNode attribute) {
        attributes.add(attribute);
        add(attribute); // add to children
    }

    public List<ASTNode> getChildren() {
        return super.getChildren(); // already includes attributes + body
    }

    public <T> T accept(HtmlWithCssVisitor<T> visitor) {
        return visitor.visit(this);
    }
}