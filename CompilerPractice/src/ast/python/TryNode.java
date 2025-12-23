package ast.python;

import ast.core.ASTVisitor;
import ast.core.BlockNode;
import ast.core.HtmlWithCssVisitor;
import ast.core.StatementNode;

import java.util.List;

public class TryNode extends StatementNode {

    private final BlockNode tryBlock;
    private final List<ExceptNode> exceptBlocks;
    private final FinallyNode finallyBlock;

    public TryNode(
            BlockNode tryBlock,
            List<ExceptNode> exceptBlocks,
            FinallyNode finallyBlock,
            int line,
            int column
    ) {
        super(line, column);
        this.tryBlock = tryBlock;
        this.exceptBlocks = exceptBlocks;
        this.finallyBlock = finallyBlock;

        add(tryBlock);
        exceptBlocks.forEach(this::add);
        add(finallyBlock);
    }

    public BlockNode getTryBlock() {
        return tryBlock;
    }

    public List<ExceptNode> getExceptBlocks() {
        return exceptBlocks;
    }

    public FinallyNode getFinallyBlock() {
        return finallyBlock;
    }

    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visit(this);
    }

    @Override
    public <T> T accept(HtmlWithCssVisitor<T> visitor) {
        return null;
    }
}
