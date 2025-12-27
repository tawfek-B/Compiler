package ast.html;


import ast.core.ASTVisitor;
import ast.core.HtmlWithCssVisitor;

public class CDataNode extends HtmlNode {
    private String data;

    public CDataNode(String data, int line, int column) {
        super("CData Node", line, column);
        this.data = data;
    }
    public String  getData() {
        return data;
    }

    @Override
    public String  toString(){
        return "CDataNode: " + data;
    }


    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return null;
    }

    @Override
    public <T> T accept(HtmlWithCssVisitor<T> visitor) { return visitor.visit(this); }
}
