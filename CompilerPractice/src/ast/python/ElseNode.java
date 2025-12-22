package ast.python;

import ast.core.ASTVisitor;
import ast.core.BlockNode;
import ast.core.IdentifierNode;
import ast.core.StatementNode;

public class ElseNode extends StatementNode {

    private final BlockNode block;

    public ElseNode(BlockNode block, int line, int column) {
        super(line, column);
        this.block = block;
        add(block);
    }

    public BlockNode getBlock() {
        return block;
    }

    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
