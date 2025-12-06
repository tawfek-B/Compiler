package ast.css;

import ast.core.ASTNode;

import java.util.ArrayList;
import java.util.List;

public class CssDocumentNode extends ASTNode {

    private List<ASTNode> rules = new ArrayList<>();

    public CssDocumentNode(int line) {
        super("CSS Document Node", line);
    }
    public void addRule(ASTNode rule) {
        rules.add(rule);
    }
}
