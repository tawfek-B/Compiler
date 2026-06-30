package ast.jinja;

import ast.core.ASTNode;
import ast.core.ASTVisitor;
import ast.core.ExpressionNode;
import ast.core.HtmlWithCssVisitor;

import java.util.List;

public class JinjaBlockNode extends ASTNode {

    public enum BlockType {
        IF,
        FOR,
        WITH,
        BLOCK
    }

    private final BlockType type;


    // IF
    private ASTNode condition;

    // FOR
    private ASTNode loopVariable;
    private ASTNode iterable;

    // WITH
    private List<JinjaWithAssignmentNode> assignments;

    // BLOCK
    private ASTNode blockName;

    private String conditionText;

    private ASTNode elseBlock;

//    private final java.util.List<ASTNode> body = new java.util.ArrayList<>();

    private JinjaBlockNode(
            BlockType type,
            int line,
            int column
    ) {
        super(type.name().toLowerCase(), line, column);
        this.type = type;
    }

    public static JinjaBlockNode ifBlock(
            ASTNode condition,
            String text,
            int line,
            int column
    ) {
        JinjaBlockNode node =
                new JinjaBlockNode(BlockType.IF, line, column);

        node.condition = condition;
        node.conditionText = text;

        return node;
    }

    public static JinjaBlockNode forBlock(
            ASTNode variable,
            ASTNode iterable,
            String text,
            int line,
            int column
    ) {
        JinjaBlockNode node =
                new JinjaBlockNode(BlockType.FOR, line, column);

        node.loopVariable = variable;
        node.iterable = iterable;
        node.conditionText = text;

        return node;
    }

    public static JinjaBlockNode withBlock(
            List<JinjaWithAssignmentNode> assignments,
            int line,
            int column
    ) {
        JinjaBlockNode node =
                new JinjaBlockNode(BlockType.WITH, line, column);

        node.assignments = assignments;

        for (ExpressionNode expr : assignments) {
            node.add(expr);
        }
        System.out.println("WITH BLOCK RECEIVED:");
        for (ASTNode e : assignments) {
            System.out.println("  child = " + e.getClass().getSimpleName());
        }
        return node;
    }

    public static JinjaBlockNode namedBlock(
            ASTNode blockName,
            int line,
            int column
    ) {
        JinjaBlockNode node =
                new JinjaBlockNode(BlockType.BLOCK, line, column);

        node.blockName = blockName;

        return node;
    }

    public BlockType getJinjaType() {
        return type;
    }

    public ASTNode getCondition() {
        return condition;
    }
    public ASTNode getLoopVariable() {
        return loopVariable;
    }
    public ASTNode getIterable() {
        return iterable;
    }
    public List<JinjaWithAssignmentNode> getAssignments() {
        return assignments;
    }
    public ASTNode getBlockName() {
        return blockName;
    }
    public String getConditionText() {
        return conditionText;
    }

    public List<ASTNode> getBody() {
        return children;
    }

//    public void add(ASTNode node) {
//        body.add(node);
//    }

    public ASTNode getElseBlock() {
        return elseBlock;
    }

    public void setElseBlock(ASTNode elseBlock) {
        this.elseBlock = elseBlock;
    }

    public void setCondition(ASTNode condition) {
        this.condition = condition;
    }

    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visit(this);
    }

    @Override
    public <T> T accept(HtmlWithCssVisitor<T> visitor) {
        return visitor.visit(this);
    }
}