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

    public SemanticAnalyzer(SymbolTable symbolTable, LabelTable labelTable) {
        this.symbolTable = symbolTable;
        this.labelTable = labelTable;
    }

    /**
     * Runs both semantic passes and returns the combined error list, so
     * callers can also write it to compiler_output/semantic_report.txt in
     * addition to the existing console output.
     */
    public List<String> analyze(ProgramNode root) {
        DefinitionVisitor defVisitor = new DefinitionVisitor(symbolTable, labelTable);
        root.accept(defVisitor);

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
            System.out.println("\n=== Semantic Analysis Passed. ===");
        }

        return allErrors;
    }
}