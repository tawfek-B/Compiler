package ast.python;

import ast.core.*;

import java.util.List;

public class IfNode extends StatementNode {

    private final ExpressionNode condition;
    private final BlockNode thenBlock;
    private final List<ElifNode> elifBlocks;
    private final ElseNode elseBlock;

    public IfNode(
            ExpressionNode condition,
            BlockNode thenBlock,
            List<ElifNode> elifBlocks,
            ElseNode elseBlock,
            int line,
            int column
    ) {
        super(line, column);
        this.condition = condition;
        this.thenBlock = thenBlock;
        this.elifBlocks = elifBlocks;
        this.elseBlock = elseBlock;

        add(condition);
        add(thenBlock);
        elifBlocks.forEach(this::add);
        add(elseBlock);
    }


    public ExpressionNode getCondition(){
        return condition;

    }
    public BlockNode getThenBlock(){
        return thenBlock;

    }
    public List<ElifNode> getElifBlocks(){
        return elifBlocks;

    }
    public ElseNode getElseBlock(){
        return elseBlock;

    }

    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
