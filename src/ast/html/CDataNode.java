package ast.html;

import ast.core.AstNode;

public class CDataNode extends AstNode {
    private String data;

    public CDataNode(String data) {
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
