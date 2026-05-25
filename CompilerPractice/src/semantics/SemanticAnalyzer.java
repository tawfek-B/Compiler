package semantics;

import ast.core.ASTNode;
import ast.core.ProgramNode;
import table.LabelTable;
import table.SymbolTable;
import visitors.DefinitionVisitor;
import visitors.TypeCheckVisitor;

class SemanticAnalyzer {

    public void analyze(ASTNode root) {

        SymbolTable symbolTable = new SymbolTable();

        // Pass 1
        new DefinitionVisitor(symbolTable, new LabelTable()).visit((ProgramNode) root);

        // Pass 2
        new TypeCheckVisitor(symbolTable).visit(root);
    }
}
