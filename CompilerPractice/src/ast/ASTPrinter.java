package ast;

import ast.core.ASTNode;

public class ASTPrinter {

    public static void print(ASTNode node) {
        print(node, "");
    }

    private static void print(ASTNode node, String indent) {
        System.out.println(indent + node);

        for (ASTNode child : node.children) {
            print(child, indent + "  ");
        }
    }
}
