package app;

import antlr.grammars.HTMLWithCSSLexer;
import antlr.grammars.HTMLWithCSSParser;
import ast.core.ASTNode;
import ast.html.*;
        import ast.css.*;
        import ast.jinja.*;
        import org.antlr.runtime.ANTLRStringStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.Token;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) throws IOException {
        String filePath = "test/test.html";

        InputStream stream = Main.class.getClassLoader().getResourceAsStream(filePath);
        if (stream == null) {
            throw new FileNotFoundException("Could not find " + filePath + " in resources");
        }

        String template = new String(stream.readAllBytes(), StandardCharsets.UTF_8);

        HTMLWithCSSLexer lexer = new HTMLWithCSSLexer(CharStreams.fromString(template));

        Token t;
        while ((t = lexer.nextToken()).getType() != Token.EOF) {
            String tokenName = lexer.getVocabulary().getSymbolicName(t.getType());
            System.out.println("Token: " + tokenName + " Text: " + t.getText().replace("\n", "\\n"));
        }
    }

    public static void printAst(ASTNode node, int indent) {
        String prefix = "  ".repeat(indent);
        System.out.println(prefix + node);

        for (ASTNode child : node.getChildren()) {
            printAst(child, indent + 1);
        }
    }
}