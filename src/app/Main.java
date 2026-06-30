package app;

import antlr.grammars.HTMLWithCSSLexer;
import antlr.grammars.HTMLWithCSSParser;
import antlr.grammars.pythonLexer;
import antlr.grammars.pythonParser;
import ast.core.*;
import ast.css.*;
import ast.html.*;
import ast.jinja.JinjaBlockNode;
import ast.jinja.JinjaExpressionNode;
import ast.python.*;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.ParseTree;
import table.LabelTable;
import table.SymbolTable;
import visitors.HtmlWithCssVisitorClass;
import visitors.PythonASTBuilderVisitor;
import visitors.DefinitionVisitor;
import visitors.TypeCheckVisitor;

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

        // Split files by type
        List<Path> pyFiles = allFiles.stream()
                .filter(p -> p.toString().toLowerCase().endsWith(".py"))
                .toList();

        List<Path> htmlFiles = allFiles.stream()
                .filter(p -> p.toString().toLowerCase().endsWith(".html"))
                .toList();

        // 1. Process all Python files FIRST — this populates the symbol table
        if (!pyFiles.isEmpty()) {
            System.out.println("\n=== Processing Python Files ===");
            symbolTable.clear();   // Fresh start for Python
            labelTable.clear();
            symbolTable.setCurrentFileOrigin(path);  // or track per-file
            for (Path py : pyFiles) {
                processPythonFile(py);
            }
            System.out.println("\n=== Python Symbol Table ===");
            symbolTable.printScopeTree();
        }

        // 2. Then process HTML files — they can now resolve Python symbols!
        //    Do NOT clear() here — HTML needs to see Python symbols
        if (!htmlFiles.isEmpty()) {
            System.out.println("\n=== Processing HTML/Jinja Files ===");
            for (Path html : htmlFiles) {
                // HTML gets its own nested scope under the global Python scope
                processHtmlFile(html);
            }
        }

        System.out.println("\nAll files processed successfully.");
    }

    private static void processPythonFile(Path filePath) {
        String fileName = filePath.getFileName().toString();
        symbolTable.setCurrentFileOrigin(fileName);
        System.out.println("\n--- " + fileName + " ---");

        try {
            CharStream input = CharStreams.fromPath(filePath);
            pythonLexer lexer = new pythonLexer(input);
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            pythonParser parser = new pythonParser(tokens);
            parser.removeErrorListeners();
            ParseTree tree = parser.program();
            PythonASTBuilderVisitor builder = new PythonASTBuilderVisitor();
            ASTNode ast = builder.visit(tree);

            // Don't clear here — we want to accumulate Python symbols across files
            ast.accept(new DefinitionVisitor(symbolTable, labelTable));

            System.out.println("AST:");
            printAst(ast);

        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private static void processHtmlFile(Path filePath) {
        String fileName = filePath.getFileName().toString();
        symbolTable.setCurrentFileOrigin(fileName);  // NEW
        System.out.println("\n--- " + fileName + " ---");

        try {
            CharStream input = CharStreams.fromPath(filePath);
            HTMLWithCSSLexer lexer = new HTMLWithCSSLexer(input);
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            HTMLWithCSSParser parser = new HTMLWithCSSParser(tokens);
            parser.removeErrorListeners();
            ParseTree tree = parser.htmlDocument();
            ASTNode ast = (new HtmlWithCssVisitorClass()).visit(tree);

            // HTML enters its own scope so CSS classes don't pollute global Python scope
            symbolTable.enterScope("html_" + fileName);
            labelTable.clear();  // Labels can be fresh per HTML file

            ast.accept(new DefinitionVisitor(symbolTable, labelTable));

            System.out.println("\nSymbol Table (HTML + inherited Python):");
            symbolTable.printScopeTree();

            System.out.println("\nLabel Table:");
            labelTable.print();

            System.out.println("\nAST:");
            printAst(ast);

            // Exit HTML scope so next HTML file starts fresh
            symbolTable.exitScope();

            printCssDetails(ast, fileName);

        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private static void printAst(ASTNode node) {
        printAst(node, "", true);
    }

    private static void printAst(ASTNode node, String prefix, boolean isLast) {
        if (node == null) return;

        String connector = isLast ? "└─ " : "├─ ";
        String label = formatNode(node);

        String base = prefix + connector + label;
        int dotsNeeded = Math.max(1, 140 - base.length());
        String dots = ".".repeat(dotsNeeded);

        System.out.println(
                base + "        " + dots + "(line " + node.getLine() + ", col " + node.getColumn() + ")"
        );

        List<ASTNode> children = node.getChildren();
        for (int i = 0; i < children.size(); i++) {
            boolean last = (i == children.size() - 1);
            printAst(
                    children.get(i),
                    prefix + (isLast ? "   " : "│  "),
                    last
            );
        }
    }

    private static String formatNode(ASTNode node) {

        // HTML
        if (node instanceof HtmlDocumentNode) {
            return "HtmlDocument";
        }

        if (node instanceof HtmlDoctypeNode d) {
            return "Doctype: " + d.getText();
        }

        if (node instanceof HtmlTagNode t) {
            return "<" + t.getTagName() + ">";
        }

        if (node instanceof HtmlAttributeNode a) {
            return "ATTRIBUTE\t" + a.getName() +
                    (a.getValue() != null && !a.getValue().isEmpty()
                            ? ": " + a.getValue()
                            : "");
        }

        if (node instanceof HtmlTextNode) {
            return "TEXT";
        }

        if (node instanceof HtmlCommentNode c) {
            return "COMMENT: " + c.getComment();
        }

        // Jinja
        if (node instanceof JinjaBlockNode j) {
            return "JINJA block: " + j.getJinjaType();
        }

        if (node instanceof JinjaExpressionNode) {
            return "JINJA expression";
        }

        // CSS
        if (node instanceof CssDocumentNode) {
            return "CSS Document (Check printCssDetails() output above)";
        }

        // Python
        if (node instanceof FunctionDefNode fn) {
            String params = fn.getParameters().stream()
                    .map(ParameterNode::getName)
                    .collect(Collectors.joining(", "));
            return "Function Definition: " + fn.getName() + "(" + params + ")";
        }


        if (node instanceof ParameterNode) {
            return "Parameter: " + ((ParameterNode) node).getName();
        }

        if (node instanceof ComparisonNode c) {
            return "Comparison: " + c.getOperator();
        }

        if (node instanceof DecoratorNode d) {
            return "Decorator: @" + d.getExpression();
        }


        // Core
        if (node instanceof IdentifierNode) {
            return "Identifier: " + ((IdentifierNode) node).getName();
        }

        if (node instanceof StringLiteralNode) {
            return "String: " + ((StringLiteralNode) node).getValue();
        }

        if (node instanceof NumberLiteralNode) {
            return "Number: " + ((NumberLiteralNode) node).getValue();
        }

        if (node instanceof BooleanLiteralNode) {
            return "Boolean: " + ((BooleanLiteralNode) node).getValue();
        }

        if (node instanceof NoneLiteralNode) {
            return "None";
        }

        return node.getClass().getSimpleName();
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