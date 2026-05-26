// semantics/SemanticAnalyzer.java
package semantics;

import ast.core.ASTNode;
import table.LabelTable;
import table.SymbolTable;
import visitors.DefinitionVisitor;
import visitors.TypeCheckVisitor;

public class SemanticAnalyzer {

    public SemanticError analyze(ASTNode root) {
        SymbolTable symbolTable = new SymbolTable();
        LabelTable labelTable = new LabelTable();

        FlaskBuiltins.populate(symbolTable);   // ← Important

        // Pass 1: Definition + Scope building
        DefinitionVisitor defVisitor = new DefinitionVisitor(symbolTable, labelTable);
        root.accept(defVisitor);

        // Pass 2: Name resolution + Type checking (to be implemented)
        TypeCheckVisitor typeChecker = new TypeCheckVisitor(symbolTable);
        typeChecker.visit(root);

        SemanticError errorReporter = new SemanticError();
        // TODO: collect errors from typeChecker

        return errorReporter;
    }
}