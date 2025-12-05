package ast.css;

import ast.core.AstNode;

public class CssSelectorNode extends AstNode {
    private String selector;
    public CssSelectorNode(String selector) {
        this.selector = selector;
    }
    public String getSelector() {
        return selector;
    }
}
