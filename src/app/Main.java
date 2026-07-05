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
import ast.jinja.JinjaExtendNode;
import ast.python.*;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.ParseTree;
import semantics.SemanticAnalyzer;
import table.LabelTable;
import table.Symbol;
import table.SymbolTable;
import visitors.HtmlWithCssVisitorClass;
import visitors.PythonASTBuilderVisitor;
import visitors.DefinitionVisitor;
import visitors.TypeCheckVisitor;

import java.io.IOException;
import java.nio.file.*;
import java.util.*;
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

        List<Path> pyFiles = allFiles.stream()
                .filter(p -> p.toString().toLowerCase().endsWith(".py"))
                .toList();

        List<Path> htmlFiles = allFiles.stream()
                .filter(p -> p.toString().toLowerCase().endsWith(".html"))
                .toList();

        // 1. Always start from app.py — this is the single Python entry point.
        Path appPy = findFileByName(pyFiles, "app.py");

        if (appPy == null) {
            System.err.println("\nNo 'app.py' found under " + path + " — cannot determine entry point.");
            return;
        }

        System.out.println("\n=== Processing Python Files ===");
        symbolTable.clear();
        labelTable.clear();
        symbolTable.setCurrentFileOrigin(path);
        processPythonFile(appPy);

        // 2. Discover HTML files by following render_template(...) calls found in app.py,
        //    then follow {% extends %} chains from each reached template.
        Set<String> visitedTemplates = new LinkedHashSet<>();
        Deque<String> queue = new ArrayDeque<>(symbolTable.getRegisteredTemplateNames());

        if (queue.isEmpty()) {
            System.out.println("\nNo render_template(...) calls found in app.py — no templates to process.");
        } else {
            System.out.println("\n=== Processing HTML/Jinja Files (reachable from app.py) ===");
        }

        while (!queue.isEmpty()) {
            String templateName = queue.poll();
            if (visitedTemplates.contains(templateName)) continue;
            visitedTemplates.add(templateName);

            Path templatePath = findFileByName(htmlFiles, templateName);
            if (templatePath == null) {
                System.err.println("Semantic Warning: template '" + templateName +
                        "' was referenced but not found on disk.");
                continue;
            }

            List<String> extendedTemplates = processHtmlFile(templatePath);
            for (String ext : extendedTemplates) {
                if (!visitedTemplates.contains(ext)) {
                    queue.add(ext);
                }
            }
        }

        // Report templates that exist on disk but were never reached
        List<String> unreached = htmlFiles.stream()
                .map(p -> p.getFileName().toString())
                .filter(name -> !visitedTemplates.contains(name))
                .toList();


        symbolTable.printScopeTree();

        if (!unreached.isEmpty()) {
            System.out.println("\n=== Unreachable Templates (not analyzed) ===");
            unreached.forEach(name ->
                    System.out.println("  " + name + " — no render_template() or {% extends %} path reaches it"));
        }

        System.out.println("\nAll reachable files processed successfully.");
    }

    private static Path findFileByName(List<Path> candidates, String fileName) {
        for (Path p : candidates) {
            if (p.getFileName().toString().equals(fileName)) {
                return p;
            }
        }
        return null;
    }

    private static String stripQuotes(String s) {
        if (s == null) return null;
        s = s.trim();
        if (s.length() >= 2 &&
                ((s.startsWith("\"") && s.endsWith("\"")) ||
                        (s.startsWith("'") && s.endsWith("'")))) {
            return s.substring(1, s.length() - 1);
        }
        return s;
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

            if (ast instanceof ProgramNode program) {
                SemanticAnalyzer analyzer = new SemanticAnalyzer(symbolTable, labelTable);
                analyzer.analyze(program);

                System.out.println("AST: ");
                printAst(ast);
            }

        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }

    /**
     * Processes a single HTML/Jinja template and returns the list of template
     * names it {% extends %}, so the caller can continue the reachability walk.
     */
    private static List<String> processHtmlFile(Path filePath) {
        String fileName = filePath.getFileName().toString();
        symbolTable.setCurrentFileOrigin(fileName);
        System.out.println("\n--- " + fileName + " ---");

        List<String> extendedTemplates = new ArrayList<>();

        try {
            CharStream input = CharStreams.fromPath(filePath);
            HTMLWithCSSLexer lexer = new HTMLWithCSSLexer(input);
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            HTMLWithCSSParser parser = new HTMLWithCSSParser(tokens);
            parser.removeErrorListeners();
            ParseTree tree = parser.htmlDocument();
            HtmlWithCssVisitorClass htmlWithCssVisitor = new HtmlWithCssVisitorClass();
            ASTNode ast = htmlWithCssVisitor.visit(tree);

            symbolTable.enterScope("html_" + fileName);

            // Inject Python context variables passed via render_template(...)
            Map<String, Symbol> context = symbolTable.getTemplateContext(fileName);
            if (context != null) {
                System.out.println("[Bridge] Injecting " + context.size() + " variables into " + fileName);
                for (Symbol sym : context.values()) {
                    symbolTable.define(sym);
                }
            }

            labelTable.clear();

            DefinitionVisitor defVisitor = new DefinitionVisitor(symbolTable, labelTable);
            ast.accept(defVisitor);

            TypeCheckVisitor jinjaChecker = new TypeCheckVisitor(symbolTable);
            ast.accept(jinjaChecker);

            List<String> allErrors = new ArrayList<>();
            allErrors.addAll(defVisitor.getErrors());
            allErrors.addAll(jinjaChecker.getErrors());
            allErrors.addAll(htmlWithCssVisitor.getErrors());

            System.out.println("\nLabel Table:");
            labelTable.print();
            System.out.println("\nAST:");
            printAst(ast);

            // Discover {% extends %} targets before leaving the scope
            collectExtends(ast, extendedTemplates);

            symbolTable.exitScope();
            printCssDetails(ast, fileName);


            if (!allErrors.isEmpty()) {
                System.err.println("\n=== Semantic Analysis Failed in " + fileName + " ===");
                allErrors.forEach(System.err::println);
            }

        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
            e.printStackTrace();
        }

        return extendedTemplates;
    }

    private static void collectExtends(ASTNode node, List<String> out) {
        if (node instanceof JinjaExtendNode extend) {
            String target = stripQuotes(extend.getPath());
            if (target != null && !target.isBlank()) {
                out.add(target);
            }
        }
        for (ASTNode child : node.getChildren()) {
            collectExtends(child, out);
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
        if (node instanceof JinjaBlockNode j) {
            switch (j.getJinjaType()) {
                case BLOCK -> {
                    return "JINJA block: BLOCK\t" + (((IdentifierNode) (j.getBlockName())).getName());
                }
                case FOR -> {
                    return "JINJA block: FOR\t" + (((IdentifierNode) (j.getIterable())).getName());
                }
                case IF -> {
                    return "JINJA block: IF\t" + (((IdentifierNode) (j.getCondition())).getName());
                }
                case WITH -> {
                    java.util.List<String> names = new java.util.ArrayList<>();

                    j.getAssignments().forEach(assign -> names.add(assign.getName()));
                    String assigns = String.join(" - ", names);

                    return "JINJA block: WITH\t" + assigns;
                }
            }
        }
        if (node instanceof JinjaExpressionNode) {
            return "JINJA expression";
        }
        if (node instanceof JinjaExtendNode ext) {
            return "JinjaExtendNode: " + ext.getPath();
        }
        if (node instanceof CssDocumentNode) {
            return "CSS Document (Check printCssDetails() output above)";
        }
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