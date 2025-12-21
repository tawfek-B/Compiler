package ast.html;

import ast.HtmlWithCssVisitor;

public class CDataNode extends HtmlNode {
    private String data;

    public CDataNode(String data, int line) {
        super("CData Node", line);
        this.data = data;
    }
    public String  getData() {
        return data;
    }

    @Override
    public String  toString(){
        return "CDataNode: " + data;
    }


    public <T> T accept(HtmlWithCssVisitor<T> visitor) {
        return visitor.visit(this);
    }

}
