package ast.jinja;

import ast.core.ASTNode;

public class JinjaDocumentNode extends ASTNode {
    public JinjaDocumentNode(int line) {
        super("Jinja Document Node", line);
    }
}
