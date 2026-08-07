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
import generation.ASTJsonSerializer;
import generation.PythonEmitterVisitor;
import generation.HtmlJinjaEmitterVisitor;
import generation.RenderOrchestrator;
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

    private static final String OUTPUT_DIR = "generated";
    private static final String RENDER_OUTPUT_DIR = "output";
    private static final String COMPILER_OUTPUT_DIR = "compiler_output";

    private static ProgramNode pythonRoot = null;
    private static String pythonRootFileName = null;
    private static final List<String> jinjaRootNames = new ArrayList<>();
    private static final List<ASTNode> jinjaRootNodes = new ArrayList<>();

    private static final List<String> semanticReportLines = new ArrayList<>();
    private static final List<String> generationLogLines = new ArrayList<>();

    public static void main(String[] args) {
        String path = args.length > 0 ? args[0] : "src/test";

        System.out.println("Processing files in: " + path);
        System.out.println("===========================================");

        try {
            Files.createDirectories(Paths.get(RENDER_OUTPUT_DIR));
            Files.createDirectories(Paths.get(COMPILER_OUTPUT_DIR));
        } catch (IOException e) {
            System.err.println("Failed to create output directories: " + e.getMessage());
        }

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
                .filter(p -> {
                    String lower = p.toString().toLowerCase();
                    return lower.endsWith(".html") || lower.endsWith(".jinja");
                })
                .toList();

        List<Path> supportFiles = allFiles.stream()
                .filter(p -> {
                    String lower = p.toString().toLowerCase();
                    return lower.endsWith(".css") || lower.endsWith(".js");
                })
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


        copySupportFile(appPy, "app.py");

        for (Path supportFile : supportFiles) {
            copySupportFile(supportFile, supportFile.getFileName().toString());
        }

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
                String warning = "Semantic Warning: template '" + templateName +
                        "' was referenced but not found on disk.";
                System.err.println(warning);
                semanticReportLines.add(warning);
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
            unreached.forEach(name -> {
                System.out.println("  " + name + " — no render_template() or {% extends %} path reaches it");
                generationLogLines.add("Skipped (unreachable): " + name);
            });
        }

        if (pythonRoot != null) {
            Map<String, ASTNode> templatesByName = new LinkedHashMap<>();
            for (int i = 0; i < jinjaRootNames.size(); i++) {
                templatesByName.put(jinjaRootNames.get(i), jinjaRootNodes.get(i));
            }
            RenderOrchestrator orchestrator = new RenderOrchestrator(pythonRoot, templatesByName, Paths.get(RENDER_OUTPUT_DIR));
            orchestrator.renderAll();
            for (String line : orchestrator.getLog()) {
                System.out.println("[Render] " + line);
                generationLogLines.add("[Render] " + line);
            }
        }


        writeAstJsonFiles();
        writeSemanticReport();
        writeGenerationLog();

        System.out.println("\nAll reachable files processed successfully.");
    }

    private static void copySupportFile(Path source, String targetName) {
        try {
            Path target = Paths.get(RENDER_OUTPUT_DIR).resolve(targetName);
            Files.copy(source, target, StandardCopyOption.REPLACE_EXISTING);
            String msg = "Copied support file " + targetName + " -> " + target;
            System.out.println("[Support] " + msg);
            generationLogLines.add(msg);
        } catch (IOException e) {
            String msg = "Failed to copy support file " + targetName + ": " + e.getMessage();
            System.err.println("[Support] " + msg);
            generationLogLines.add(msg);
        }
    }

    private static void writeSemanticReport() {
        try {
            Path reportPath = Paths.get(COMPILER_OUTPUT_DIR).resolve("semantic_report.txt");
            String content = semanticReportLines.isEmpty()
                    ? "No semantic errors or warnings were found.\n"
                    : String.join("\n", semanticReportLines) + "\n";
            Files.writeString(reportPath, content);
            System.out.println("\n[Report] Wrote " + reportPath);
        } catch (IOException e) {
            System.err.println("[Report] Failed to write semantic_report.txt: " + e.getMessage());
        }
    }

    private static void writeGenerationLog() {
        try {
            Path logPath = Paths.get(COMPILER_OUTPUT_DIR).resolve("generation_log.txt");
            String content = String.join("\n", generationLogLines) + "\n";
            Files.writeString(logPath, content);
            System.out.println("[Report] Wrote " + logPath);
        } catch (IOException e) {
            System.err.println("[Report] Failed to write generation_log.txt: " + e.getMessage());
        }
    }

    private static void writeAstJsonFiles() {
        ASTJsonSerializer serializer = new ASTJsonSerializer();

        if (pythonRoot != null) {
            try {
                Path pyPath = Paths.get(COMPILER_OUTPUT_DIR).resolve("ast_python.json");
                StringBuilder sb = new StringBuilder();
                sb.append("{\n  \"file\": ").append('"').append(pythonRootFileName).append("\",\n");
                sb.append("  \"ast\": ");
                sb.append(serializer.serialize(pythonRoot, 1));
                sb.append("\n}\n");
                Files.writeString(pyPath, sb.toString());
                System.out.println("[Report] Wrote " + pyPath);
                generationLogLines.add("Wrote AST JSON: " + pyPath);
            } catch (IOException e) {
                System.err.println("[Report] Failed to write ast_python.json: " + e.getMessage());
                generationLogLines.add("ERROR writing ast_python.json: " + e.getMessage());
            }
        }

        try {
            Path jinjaPath = Paths.get(COMPILER_OUTPUT_DIR).resolve("ast_jinja.json");
            StringBuilder sb = new StringBuilder();
            sb.append("{\n  \"templates\": [\n");
            for (int i = 0; i < jinjaRootNames.size(); i++) {
                sb.append("    {\n      \"file\": \"").append(jinjaRootNames.get(i)).append("\",\n");
                sb.append("      \"ast\": ");
                sb.append(serializer.serialize(jinjaRootNodes.get(i), 3));
                sb.append("\n    }");
                if (i < jinjaRootNames.size() - 1) sb.append(",");
                sb.append("\n");
            }
            sb.append("  ]\n}\n");
            Files.writeString(jinjaPath, sb.toString());
            System.out.println("[Report] Wrote " + jinjaPath);
            generationLogLines.add("Wrote AST JSON: " + jinjaPath);
        } catch (IOException e) {
            System.err.println("[Report] Failed to write ast_jinja.json: " + e.getMessage());
            generationLogLines.add("ERROR writing ast_jinja.json: " + e.getMessage());
        }
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
        generationLogLines.add("Processing Python file: " + fileName);

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
                pythonRoot = program;
                pythonRootFileName = fileName;
                SemanticAnalyzer analyzer = new SemanticAnalyzer(symbolTable, labelTable);
                List<String> errors = analyzer.analyze(program);

                if (!errors.isEmpty()) {
                    semanticReportLines.add("=== " + fileName + " ===");
                    semanticReportLines.addAll(errors);
                    semanticReportLines.add("");
                    generationLogLines.add("Semantic analysis for " + fileName + ": " + errors.size() + " error(s) found");
                } else {
                    generationLogLines.add("Semantic analysis for " + fileName + ": passed");
                }

                System.out.println("AST: ");
                printAst(ast);

                emitPythonFile(program, fileName);
            }

        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
            e.printStackTrace();
            generationLogLines.add("ERROR processing " + fileName + ": " + e.getMessage());
        }
    }

    private static void emitHtmlFile(ASTNode ast, String fileName) {
        try {
            String generatedSource = new HtmlJinjaEmitterVisitor().emit(ast);

            Path outDir = Paths.get(OUTPUT_DIR);
            Files.createDirectories(outDir);
            Path outFile = outDir.resolve(fileName);
            Files.writeString(outFile, generatedSource);

            System.out.println("\n[Codegen] Wrote generated template to " + outFile);
            generationLogLines.add("Wrote re-emitted template source: " + outFile);
        } catch (IOException e) {
            System.err.println("[Codegen] Failed to write generated file for " + fileName + ": " + e.getMessage());
            generationLogLines.add("ERROR writing generated template " + fileName + ": " + e.getMessage());
        }
    }

    private static void emitPythonFile(ProgramNode program, String fileName) {
        try {
            String generatedSource = new PythonEmitterVisitor().emit(program);

            Path outDir = Paths.get(OUTPUT_DIR);
            Files.createDirectories(outDir);
            Path outFile = outDir.resolve(fileName);
            Files.writeString(outFile, generatedSource);

            System.out.println("\n[Codegen] Wrote generated Python to " + outFile);
            generationLogLines.add("Wrote re-emitted Python source: " + outFile);

            CollectingErrorListener errorListener = new CollectingErrorListener();

            CharStream regenInput = CharStreams.fromString(generatedSource);
            pythonLexer regenLexer = new pythonLexer(regenInput);
            regenLexer.removeErrorListeners();
            regenLexer.addErrorListener(errorListener);

            CommonTokenStream regenTokens = new CommonTokenStream(regenLexer);
            pythonParser regenParser = new pythonParser(regenTokens);
            regenParser.removeErrorListeners();
            regenParser.addErrorListener(errorListener);
            regenParser.program();

            if (errorListener.errors.isEmpty()) {
                System.out.println("[Codegen] Round-trip check passed: generated " + fileName + " re-parses cleanly.");
                generationLogLines.add("Round-trip check passed for " + fileName);
            } else {
                System.err.println("[Codegen] Round-trip check FAILED for generated " + fileName + ":");
                errorListener.errors.forEach(err -> System.err.println("  " + err));
                generationLogLines.add("Round-trip check FAILED for " + fileName + ": " + errorListener.errors.size() + " issue(s)");
            }
        } catch (IOException e) {
            System.err.println("[Codegen] Failed to write generated file for " + fileName + ": " + e.getMessage());
            generationLogLines.add("ERROR writing generated Python " + fileName + ": " + e.getMessage());
        }
    }

    /** Collects syntax errors instead of printing them, for the round-trip check. */
    private static class CollectingErrorListener extends BaseErrorListener {
        final List<String> errors = new ArrayList<>();

        @Override
        public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol,
                                int line, int charPositionInLine,
                                String msg, RecognitionException e) {
            errors.add("line " + line + ":" + charPositionInLine + " " + msg);
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
        generationLogLines.add("Processing HTML/Jinja file: " + fileName);

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
            jinjaRootNames.add(fileName);
            jinjaRootNodes.add(ast);

            symbolTable.enterScope("html_" + fileName);

            // Inject Python context variables passed via render_template(...)
            Map<String, Symbol> context = symbolTable.getTemplateContext(fileName);
            if (context != null) {
                System.out.println("[Bridge] Injecting " + context.size() + " variables into " + fileName);
                generationLogLines.add("Injected " + context.size() + " context variable(s) into " + fileName);
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

            collectExtends(ast, extendedTemplates);

            symbolTable.exitScope();
            printCssDetails(ast, fileName);
            emitHtmlFile(ast, fileName);

            if (!allErrors.isEmpty()) {
                System.err.println("\n=== Semantic Analysis Failed in " + fileName + " ===");
                allErrors.forEach(System.err::println);
                semanticReportLines.add("=== " + fileName + " ===");
                semanticReportLines.addAll(allErrors);
                semanticReportLines.add("");
                generationLogLines.add("Semantic analysis for " + fileName + ": " + allErrors.size() + " error(s) found");
            } else {
                generationLogLines.add("Semantic analysis for " + fileName + ": passed");
            }

        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
            e.printStackTrace();
            generationLogLines.add("ERROR processing " + fileName + ": " + e.getMessage());
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