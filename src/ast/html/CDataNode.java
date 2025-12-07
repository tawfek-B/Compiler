package ast.html;

import ast.core.ASTNode;
import visitors.HtmlVisitor;

public class CDataNode extends HtmlNode {
    private String data;

    public CDataNode(String data, int line) {
        super("Css Data Node", line);
        this.data = data;
    }
    public String  getData() {
        return data;
    }

    @Override
    public String  toString(){
        return "CDataNode: " + data;
    }

    public <T> T accept(HtmlVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
