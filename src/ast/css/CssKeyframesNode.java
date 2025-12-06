package ast.css;

import ast.core.ASTNode;

import java.util.ArrayList;
import java.util.List;


public class CssKeyframesNode extends ASTNode {
    private String name;
    private List<CssKeyframeBlockNode> blocks = new ArrayList<>();

    public CssKeyframesNode(String name, int line) {
        super("CSS Keyframes Node", line);
        this.name = name;
    }

    public void addBlock(CssKeyframeBlockNode block) {
        this.blocks.add(block);
    }

    @Override
    public List<ASTNode> getChildren() {
        List<ASTNode> children = new ArrayList<>();
        children.addAll(blocks);
        return children;
    }

    @Override
    public String toString() {
        return "CSS Keyframes Node: " + this.name;
    }

}
