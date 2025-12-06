package ast.python;

import ast.ASTVisitor;
import ast.core.ASTNode;

import java.util.List;

public class pyFunctionDecNode extends ASTNode {
    public final String name;
    public final List<String> parameters;

    public pyFunctionDecNode(String name, List<String> parameters, int line){
        super("FunctionDeclaration(" + name + ")" , line );
        this.name = name;
        this.parameters = parameters;
    }

    public void setBody(ASTNode body){
        add(body);
    }

    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
