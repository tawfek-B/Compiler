package ast.core;

import ast.ASTVisitor;

public class StringNode extends ASTNode{

        public final String value;

        public StringNode(String value, int line){
            super("String(\"" + value + "\")",line);
            this.value = value;

        }

    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visit(this);
    }
    }

