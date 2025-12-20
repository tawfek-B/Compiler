lexer grammar pythonLexer;

tokens { INDENT, DEDENT }

@members {
    private java.util.Stack<Integer> indents = new java.util.Stack<>();
    private java.util.LinkedList<Token> pendingTokens = new java.util.LinkedList<>();
    private int lastIndent = 0;

    @Override
    public Token nextToken() {
        if (!pendingTokens.isEmpty()) {
            return pendingTokens.poll();
        }

        Token next = super.nextToken();

        if (next.getType() == EOF) {
            while (!indents.isEmpty()) {
                indents.pop();
                pendingTokens.add(new CommonToken(DEDENT));
            }
            pendingTokens.add(next); // EOF
            return pendingTokens.poll();
        }

        return next;
    }
}

// Keywords
DEF     : 'def';
RETURN  : 'return';
IF      : 'if';
ELIF    : 'elif';
ELSE    : 'else';
WHILE   : 'while';
TRY     : 'try';
FINALLY : 'finally';
EXCEPT  : 'except';
FOR     : 'for';
IN      : 'in';
TRUE    : 'true';
FALSE   : 'false';
RANGE   : 'range';

ROUTE   : '@route';

// Operators & Symbols
ASSIGN          : '=';
PLUS            : '+';
MINUS           : '-';
MULTIPLY        : '*';
DIVIDE          : '/';
MODIFY          : '%';

EQUAL           : '==';
NOT_EQUAL       : '!=';
GREATER_EQUAL   : '>=';
LESS_EQUAL      : '<=';
GREATER_THAN    : '>';
LESS_THAN       : '<';

LP  : '(';
RP  : ')';
LSB : '[';
RSB : ']';
LCB : '{';
RCB : '}';
COLON : ':';
COMMA : ',';
SEMICOLON : ';';
DOT : '.';

// Literals
NUMBER
    : INT ('.' INT)?
    ;

fragment INT : [0-9]+;

STRING
    : '"' (~["\r\n])* '"'
    ;

// Identifiers
ID
    : [a-zA-Z_][a-zA-Z_0-9]*
    ;

// New line with Indentation
NEWLINE
    : ('\r'? '\n')+
      {
        int indent = 0;
        int la = _input.LA(1);

        while (la == ' ' || la == '\t') {
            indent += (la == '\t') ? 4 : 1;
            _input.consume();
            la = _input.LA(1);
        }

        // Create tokens with proper line and column (copy from current NEWLINE token)
        CommonToken indentToken;
        CommonToken newlineToken = new CommonToken(NEWLINE);
        newlineToken.setLine(getLine());
        newlineToken.setCharPositionInLine(getCharPositionInLine());

        if (indent > lastIndent) {
            indents.push(indent);
            lastIndent = indent;

            indentToken = new CommonToken(INDENT);
            indentToken.setLine(getLine() + 1);
            indentToken.setCharPositionInLine(0);
            pendingTokens.add(indentToken);
        } else {
            while (!indents.isEmpty() && indent < lastIndent) {
                indents.pop();

                indentToken = new CommonToken(DEDENT);
                indentToken.setLine(getLine());
                indentToken.setCharPositionInLine(-1);
                pendingTokens.add(indentToken);

                lastIndent = indents.isEmpty() ? 0 : indents.peek();
            }
        }

        pendingTokens.add(newlineToken);
      }
    ;
// Skipped
COMMENT
    : '#' ~[\r\n]* -> skip
    ;

MULTILINE_COMMENT
    : '"""' .*? '"""' -> skip
    ;

MULTILINE_STRING
    : '"""' .*? '"""' -> skip
    ;

WS
    : [ \t]+ -> skip
    ;