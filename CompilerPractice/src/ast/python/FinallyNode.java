package ast.python;

import ast.core.ASTVisitor;
import ast.core.BlockNode;
import ast.core.StatementNode;

public class FinallyNode extends StatementNode {

    private final BlockNode block;

    public FinallyNode(BlockNode block, int line, int column) {
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
