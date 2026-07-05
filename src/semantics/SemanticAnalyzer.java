package semantics;

import ast.core.ProgramNode;
import table.LabelTable;
import table.SymbolTable;
import visitors.DefinitionVisitor;
import visitors.TypeCheckVisitor;

import java.util.ArrayList;
import java.util.List;

public class SemanticAnalyzer {

    private final SymbolTable symbolTable;
    private final LabelTable labelTable;

    // Accept the existing tables from Main.java
    public SemanticAnalyzer(SymbolTable symbolTable, LabelTable labelTable) {
        this.symbolTable = symbolTable;
        this.labelTable = labelTable;
    }

    public void analyze(ProgramNode root) {
        // Pass 1: Build the Symbol Table
        DefinitionVisitor defVisitor = new DefinitionVisitor(symbolTable, labelTable);
        root.accept(defVisitor);

        // Pass 2: Type Checking and Semantic Validation
        TypeCheckVisitor typeChecker = new TypeCheckVisitor(symbolTable);
        root.accept(typeChecker);

        List<String> allErrors = new ArrayList<>();
        allErrors.addAll(defVisitor.getErrors());
        allErrors.addAll(typeChecker.getErrors());

        if (!allErrors.isEmpty()) {
            System.err.println("\n=== Semantic Analysis Failed ===");

            for (String error : allErrors) {
                System.err.println(error);
            }
        } else {
            System.out.println("[✓] Semantic Analysis Passed.");
        }
    }
}