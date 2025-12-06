lexer grammar pythonLexer;

tokens { INDENT, DEDENT }

// MEMBERS (indentation logic)
@lexer::members {

    // Count indentation levels
    private java.util.Stack<Integer> indents = new java.util.Stack<>();

    // Needed to ignore indentation inside parentheses/brackets
    private int opened = 0;

    // Buffer to emit INDENT/DEDENT properly
    private java.util.LinkedList<Token> pending = new java.util.LinkedList<>();

    @Override
    public void emit(Token token) {
        pending.add(token);
        super.setToken(token);
    }

    @Override
    public Token nextToken() {

        // If any buffered tokens exist → return them first
        if (!pending.isEmpty()) {
            return pending.poll();
        }

        Token next = super.nextToken();

        // Close all open indents on the end of file
        if (next.getType() == EOF) {
            while (!indents.isEmpty()) {
                indents.pop();
                emit(new CommonToken(DEDENT, ""));
            }
        }

        return next;
    }

    // Helper: emit INDENT token
    private void emitIndent(int wsCount) {
        indents.push(wsCount);
        emit(new CommonToken(INDENT, "<INDENT>"));
    }

    // Helper: emit DEDENT tokens
    private void emitDedent(int wsCount) {
        while (!indents.isEmpty() && indents.peek() > wsCount) {
            indents.pop();
            emit(new CommonToken(DEDENT, "<DEDENT>"));
        }
    }
}

// Keywords
IF: 'if';
ELIF: 'elif';
ELSE: 'else';
FOR: 'for';
IN: 'in';
DEF: 'def';
TRUE: 'true';
FALSE: 'false';
RETURN: 'return';

ROUTE: '@route';

// Operators and Symbols
ASSIGN: '=';
PLUS: '+';
MINUS: '-';
MULTIPLY: '*';
DIVIDE: '/';
MODIFY: '%';
EQUAL: '==';
NOT_EQUAL: '!=';
GREATER_THAN: '>';
LESS_THAN: '<';
GREATER_EQUAL: '>=';
LESS_EQUAL: '<=';
LP: '(' { opened++; };
RP: ')' { opened--; };
LSB: '[' { opened++; };
RSB: ']' { opened--; };
LCB: '{' { opened++; };
RCB: '}' { opened--; };
COMMA: ',';
COLON: ':';
SEMICOLON: ';';
DOT: '.';
DOUBLE_COT: '"';
HASHTAG: '#';

// Literals
NUMBER: [0-9]+ ('.' [0-9]+)?;
STRING: DOUBLE_COT (~["\r\n])* DOUBLE_COT;

// Identifiers
ID: [a-zA-Z_][a-zA-Z0-9_]*;

// Comments
COMMENT: HASHTAG ~[\r\n]* -> skip;
MULTILINE_COMMENT: '"""' (.)*? '"""' -> skip;

// Indentation
NEWLINE
    :   ('\r'? '\n')+  {

            // Count spaces after the newline
            int spaces = 0;
            int la = _input.LA(1);

            // skip pure newline inside (),[],{}
            if (opened > 0) {
                skip();
            }
            else {

                // accumulate indentation
                while (la == ' ' || la == '\t') {
                    if (la == ' ') spaces++;
                    if (la == '\t') spaces += 4; // tabs = 4 spaces
                    _input.consume();
                    la = _input.LA(1);
                }

                emit(new CommonToken(NEWLINE, "\n"));

                int currentIndent = indents.isEmpty() ? 0 : indents.peek();

                if (spaces > currentIndent) {
                    emitIndent(spaces);
                } else if (spaces < currentIndent) {
                    emitDedent(spaces);
                }
            }
        }
    ;

// Ignore isolated whitespace
WS: [ \t]+ -> skip;
