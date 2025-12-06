package ast.html;

import ast.core.ASTNode;

public class CDataNode extends ASTNode {
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
}
