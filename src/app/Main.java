package app;

import antlr.grammars.HTMLWithCSSLexer;
import antlr.grammars.HTMLWithCSSParser;
import ast.core.ASTNode;
import ast.css.*;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.ParseTree;
import table.LabelTable;
import table.SymbolTable;
import visitors.HtmlWithCssVisitorClass;
import visitors.SymbolTableVisitor;

import java.io.IOException;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    private static final SymbolTable symbolTable = new SymbolTable();
    private static final LabelTable labelTable = new LabelTable();

    public static void main(String[] args) {
        String path = args.length > 0 ? args[0] : "src/test";

        System.out.println("Processing files in: " + path);
        System.out.println("===========================================");

        Path start = Paths.get(path);
        List<Path> allFiles = new ArrayList<>();

        if (Files.isRegularFile(start)) {
            allFiles.add(start);
        } else {
            try (Stream<Path> paths = Files.walk(start)) {
                allFiles = paths.filter(Files::isRegularFile)
                        .collect(Collectors.toList());
            } catch (IOException e) {
                System.err.println("Error walking directory: " + e.getMessage());
                return;
            }
        }

        List<Path> htmlFiles = allFiles.stream()
                .filter(p -> p.toString().toLowerCase().endsWith(".html"))
                .toList();

        if (!htmlFiles.isEmpty()) {
            System.out.println("\n=== Processing HTML/Jinja Files ===");
            for (Path html : htmlFiles) {
                processSingleFile(html);
            }
        }

        System.out.println("\nAll files processed successfully.");
    }

    private static void processSingleFile(Path filePath) {
        String fileName = filePath.getFileName().toString();
        System.out.println("\n--- " + fileName + " ---");

        try {
            CharStream input = CharStreams.fromPath(filePath);
            ASTNode ast = null;

            if (fileName.toLowerCase().endsWith(".html")) {
                ast = processHtmlFile(input);
                printCssDetails(ast, fileName);
            } else {
                System.out.println("Skipping unsupported file type");
                return;
            }

            if (ast != null) {
                System.out.println("AST:");
                printAst(ast, "");
            }

            System.out.println("Done.");
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private static ASTNode processHtmlFile(CharStream input) {
        HTMLWithCSSLexer lexer = new HTMLWithCSSLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        HTMLWithCSSParser parser = new HTMLWithCSSParser(tokens);
        parser.removeErrorListeners();
        ParseTree tree = parser.htmlDocument();
        ASTNode ast = (new HtmlWithCssVisitorClass()).visit(tree);

        symbolTable.clear();
        labelTable.clear();
        ast.accept(new SymbolTableVisitor(symbolTable, labelTable));

        System.out.println("\nSymbol Table:");
        symbolTable.print();

        System.out.println("\nLabel Table:");
        labelTable.print();
        System.out.println();

        return ast;
    }
    private static void printAst(ASTNode node, String indent) {
        if (node == null) return;

        String type = node.getClass().getSimpleName();
        System.out.println(indent + type + " (line " + node.getLine() +
                ", col " + node.getColumn() + ")");

        for (ASTNode child : node.getChildren()) {
            printAst(child, indent + "  ");
        }
    }

    private static void printCssDetails(ASTNode node, String fileName) {
        boolean[] found = {false};
        printCssRecursive(node, "", found);

        if (!found[0]) {
            System.out.println("No Stylesheet in: " + fileName);
        }
    }

    private static void printCssRecursive(ASTNode node, String indent, boolean[] found) {
        if (node instanceof CssDocumentNode cssDoc) {
            found[0] = true;
            System.out.println(indent + "CSS Document (line " + cssDoc.getLine() + "):");
            indent += "  ";

            for (CssNode rule : cssDoc.getRules()) {
                if (rule instanceof CssRuleNode r) {
                    System.out.println(indent + "Ruleset:");
                    for (var sel : r.getSelectors()) {
                        System.out.println(indent + "  → " + sel.getSelector());
                    }
                    if (!r.getDeclarations().isEmpty()) {
                        System.out.println(indent + "  Declarations:");
                        for (var decl : r.getDeclarations()) {
                            String imp = decl.isImportant() ? " !" : "";
                            System.out.println(indent + "    " + decl.getProperty() + ": " + decl.getValue() + imp);
                        }
                    }
                } else {
                    System.out.println(indent + rule.getClass().getSimpleName());
                }
            }
            System.out.println();
        }

        for (ASTNode child : node.getChildren()) {
            printCssRecursive(child, indent, found);
        }
    }
}