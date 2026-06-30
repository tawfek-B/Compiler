package ast.css;

import ast.core.ASTNode;
import ast.core.ASTVisitor;
import ast.core.HtmlWithCssVisitor;

import java.util.ArrayList;
import java.util.List;


public class CssKeyframesNode extends CssNode {
    private String name;
    private List<CssKeyframeBlockNode> blocks = new ArrayList<>();

    public CssKeyframesNode(String name, int line, int column) {
        super("CSS Keyframes Node", line, column);
        this.name = name;
    }

    public void addBlock(CssKeyframeBlockNode block) {
        this.blocks.add(block);
        block.setParent(this);
    }

    public List<ASTNode> getChildren() {
        List<ASTNode> children = new ArrayList<>();
        children.addAll(blocks);
        return children;
    }

    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return null;
    }

    @Override
    public <T> T accept(HtmlWithCssVisitor<T> visitor) { return visitor.visit(this); }

    @Override
    public String toString() {
        return "CSS Keyframes Node: " + this.name;
    }

}
