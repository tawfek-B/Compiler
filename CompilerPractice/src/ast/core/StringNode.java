package ast.core;

public class StringNode extends ASTNode{

        public final String value;

        public StringNode(String value, int line){
            super("String(\"" + value + "\")",line);
            this.value = value;

        }
    }

