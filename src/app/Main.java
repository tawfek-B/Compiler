package app;

import antlr.grammars.*;
import visitors.HtmlWithCssVisitorClass;
import ast.core.*;
import ast.html.*;
import ast.jinja.*;
import ast.css.*;
import org.antlr.v4.runtime.*;

import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {

    public static void main(String[] args) throws Exception {

        String filePath = "C:\\Users\\Asus\\ANTLR\\CompilerPractice\\src\\test\\test.html";
        String template = Files.readString(Paths.get(filePath));

        var lexer = new HTMLWithCSSLexer(CharStreams.fromString(template));
        var tokens = new CommonTokenStream(lexer);
        var parser = new HTMLWithCSSParser(tokens);
        var tree = parser.htmlDocument();

        var visitor = new HtmlWithCssVisitorClass();
        ASTNode root = visitor.visit(tree);

        System.out.println("=== FULL AST TREE ===");
        printNode(root, "");

        System.out.println("\n=== DETAILED CSS CONTENT ===");
        printCssDetails(root, "");
    }

    private static void printNode(ASTNode node, String indent) {
        if (node == null) return;

        System.out.println(node.getClass().getSimpleName() + "\t|\tLine: " + node.getLine() + "\t|\tColumn: " + node.getColumn() +"\t|\tChildren: " + node.getChildren());

        for (ASTNode child : node.getChildren()) {
            printNode(child, indent + "  ");
        }
    }

    private static void printCssDetails(ASTNode node, String indent) {
        // Only process when we find a CssDocumentNode
        if (node instanceof CssDocumentNode cssDoc) {
            System.out.println(indent + "CSS Document Node (line " + cssDoc.getLine() + ") contains:");
            indent += "  ";

            for (CssNode rule : cssDoc.getRules()) {
                if (rule instanceof CssAtRuleNode atRule) {
                    String value = atRule.getValue().trim();
                    System.out.println(indent + "@" + atRule.getName() + (value.isEmpty() ? "" : " " + value));
                }
                else if (rule instanceof CssKeyframesNode kf) {
                    System.out.println(indent + "@keyframes " + kf.toString().replace("CSS Keyframes Node: ", "").trim());
                }
                else if (rule instanceof CssMediaRuleNode media) {
                    System.out.println(indent + "@media rule (contains " + media.getChildren().size() + " nested items)");
                }
                else if (rule instanceof CssRuleNode cssRule) {
                    System.out.println(indent + "Ruleset (line " + cssRule.getLine() + ") with " + cssRule.getSelectors().size() + " selector(s):");
                    for (var sel : cssRule.getSelectors()) {
                        System.out.println(indent + "  → " + sel.getSelector().trim());
                    }

                    if (!cssRule.getDeclarations().isEmpty()) {
                        System.out.println(indent + "  Declarations (" + cssRule.getDeclarations().size() + "):");
                        for (var decl : cssRule.getDeclarations()) {
                            String imp = decl.isImportant() ? " !important" : "";
                            System.out.println(indent + "    " + decl.getProperty().trim() + ": " + decl.getValue().trim() + imp);
                        }
                    } else {
                        System.out.println(indent + "  (no declarations)");
                    }
                }
                else if (rule instanceof CssNode) {
                    System.out.println(indent + rule.getClass().getSimpleName() + " (line " + rule.getLine() + ")");
                }
                System.out.println();
            }
            System.out.println();
        }

        for (ASTNode child : node.getChildren()) {
            printCssDetails(child, indent);
        }
    }
}