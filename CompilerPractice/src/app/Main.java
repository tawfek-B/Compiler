package app;

//import ast.HtmlWithCssVisitorClass;
//import ast.core.ASTNode;
//import ast.css.CssDocumentNode;
//import grammars.HTMLWithCSSLexer;
//import grammars.HTMLWithCSSParser;
import antlr.grammars.pythonLexer;
import antlr.grammars.pythonParser;
import org.antlr.v4.runtime.*;

import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {

    public static void main(String[] args) throws Exception {
        String code = new String(Files.readAllBytes(Paths.get("C:\\Users\\DELL\\IdeaProjects\\CompilerPractice\\src\\test\\test.py")));

        pythonLexer lexer = new pythonLexer(CharStreams.fromString(code));

        Token token;
        Vocabulary vocabulary = lexer.getVocabulary();

        System.out.println("=== TOKENS ===");
        while ((token = lexer.nextToken()).getType() != Token.EOF) {
            String tokenName = vocabulary.getDisplayName(token.getType());

            String tokenText = token.getText();
            if (tokenText == null) {
                tokenText = "<no text>";
            } else {
                tokenText = tokenText
                        .replace("\n", "\\n")
                        .replace("\r", "\\r")
                        .replace("\t", "\\t");
            }

            System.out.printf("Line %3d:%-3d  %-20s  %s%n",
                    token.getLine(),
                    token.getCharPositionInLine(),
                    tokenName,
                    tokenText);
        }
        System.out.println("EOF");
        System.out.println("===============\n");

        lexer.reset();

        CommonTokenStream tokens = new CommonTokenStream(lexer);

        pythonParser parser = new pythonParser(tokens);

        System.out.println("Parsing completed successfully.");
    }
}