package ast.python;

import ast.core.ASTNode;

import java.util.ArrayList;
import java.util.List;

public class pyFunctionCallNode extends ASTNode {
    public final String name;
    public final List<ASTNode> arguments = new ArrayList<>();

    public pyFunctionCallNode(String name, int line){
        super("FunctionCall(" + name + ")", line);
        this.name = name;
    }

    public void addArguments(ASTNode argument){
        arguments.add(argument);
        add(argument);

    }
}
