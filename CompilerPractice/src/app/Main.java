

package app;

import antlr.grammars.pythonLexer;
import antlr.grammars.pythonParser;
import ast.core.ASTNode;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import table.LabelTable;
import table.SymbolTable;
import visitors.PythonASTBuilderVisitor;
import visitors.SymbolTableVisitor;

import java.io.IOException;

public class Main {

    public static void main(String[] args) {

        String filePath = args.length > 0 ? args[0] : "src/test/test.py";
//        String filePath = args.length > 0 ? args[0] : "src/test/test_working.py";

        try {
            System.out.println("Reading file: " + filePath);
            CharStream input = CharStreams.fromFileName(filePath);

            // Lexer & Token stream
            pythonLexer lexer = new pythonLexer(input);
            CommonTokenStream tokens = new CommonTokenStream(lexer);

            // all tokens
            // printTokens(tokens);

            // Parser setup
            pythonParser parser = new pythonParser(tokens);
            parser.removeErrorListeners();

            CollectingErrorListener errorListener = new CollectingErrorListener();
            parser.addErrorListener(errorListener);

            System.out.println("\n===== PARSING =====");
            var tree = parser.program();

            System.out.println(tree);

            System.out.println("Parsing successful ✓");

            // AST
            System.out.println("\n===== BUILDING AST =====");
            PythonASTBuilderVisitor astBuilder = new PythonASTBuilderVisitor();

            ASTNode ast = astBuilder.visit(tree);

            if (ast == null) {
                System.err.println("AST root node is null!");
                return;
            }

            System.out.println("\n=== FULL AST TREE ===");
            printNode(ast, "");

            // Symbol & Label tables
            System.out.println("\n===== SYMBOL TABLE =====");
            SymbolTable symbolTable = new SymbolTable();
            LabelTable labelTable = new LabelTable();

            SymbolTableVisitor symVisitor = new SymbolTableVisitor(symbolTable, labelTable);
            ast.accept(symVisitor);

            symbolTable.print();
            System.out.println("\n===== LABEL TABLE =====");
            labelTable.print();

            System.out.println("\nProcessing finished successfully.");

        } catch (IOException e) {
            System.err.println("Error reading file: " + filePath);
            e.printStackTrace();
        } catch (Exception e) {
            System.err.println("Unexpected error during processing:");
            e.printStackTrace();
        }
    }

    // Token printer
    private static void printTokens(CommonTokenStream tokens) {
        tokens.fill();
        System.out.println("\n===== TOKENS =====");
        for (Token token : tokens.getTokens()) {
            String name = pythonLexer.VOCABULARY.getSymbolicName(token.getType());
            String text = token.getText().replace("\n", "\\n").replace("\r", "\\r");
            System.out.printf("%-18s '%s'%n", name, text);
        }
    }

    private static void printNode(ASTNode node, String indent) {
        if (node == null) return;

        System.out.println(indent + node.getClass().getSimpleName() +
                "\t|\tLine: " + node.getLine() +
                "\t|\tColumn: " + node.getColumn() +
                "\t|\tChildren: " + node.getChildren().size());

        for (ASTNode child : node.getChildren()) {
            printNode(child, indent + "  ");
        }
    }

    // Inner class for collecting and nicely printing syntax errors
    static class CollectingErrorListener extends BaseErrorListener {
        private final java.util.List<String> errors = new java.util.ArrayList<>();

        @Override
        public void syntaxError(Recognizer<?, ?> recognizer,
                                Object offendingSymbol,
                                int line,
                                int charPositionInLine,
                                String msg,
                                RecognitionException e) {
            String symbolText = offendingSymbol instanceof Token ?
                    ((Token) offendingSymbol).getText() : String.valueOf(offendingSymbol);

            String errorMsg = String.format(
                    "[line %d:%d] %s\n    → offending symbol: '%s'",
                    line, charPositionInLine, msg, symbolText.replace("\n", "\\n")
            );
            errors.add(errorMsg);
        }

        public void printAllErrors() {
            if (errors.isEmpty()) {
                System.err.println("No syntax errors collected.");
                return;
            }
            for (String error : errors) {
                System.err.println(error);
                System.err.println();
            }
        }
    }
}