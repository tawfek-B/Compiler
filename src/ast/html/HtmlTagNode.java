package ast.html;

import ast.core.AstNode;
import java.util.ArrayList;
import java.util.List;

public class HtmlTagNode extends AstNode {

    private String tagName;
    private List<HtmlAttributeNode> attributes = new ArrayList<>();

    public HtmlTagNode(String tagName) {
        this.tagName = tagName;
    }
    public String getTagName() {
        return tagName;
    }
    public List<HtmlAttributeNode> getAttributes() {
        return attributes;
    }
    public void addAttribute(HtmlAttributeNode attribute) {
        attributes.add(attribute);
    }

    @Override
    public String toString() {
        return "HtmlTagNode: " + tagName;
    }

    @Override
    public List<AstNode> getChildren()
    {
        List<AstNode> all = new ArrayList<>();
        all.addAll(attributes);
        all.addAll(children);

        return all;
    }

}
