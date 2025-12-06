package ast.html;

import ast.core.ASTNode;
import java.util.ArrayList;
import java.util.List;

public class HtmlTagNode extends ASTNode {

    private String tagName;
    private List<HtmlAttributeNode> attributes = new ArrayList<>();

    public HtmlTagNode(String tagName,  int line) {
        super("Html Tag Node", line);
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
    public List<ASTNode> getChildren()
    {
        List<ASTNode> all = new ArrayList<>();
        all.addAll(attributes);
        all.addAll(children);

        return all;
    }

}
