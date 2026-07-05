lexer grammar pythonLexer;

tokens { INDENT, DEDENT }

@lexer::members {
    private java.util.ArrayDeque<Integer> indents = new java.util.ArrayDeque<>();
    private java.util.LinkedList<Token> pending = new java.util.LinkedList<>();
    private int opened = 0;

    @Override
    public Token nextToken() {
        // EOF handling - emit remaining dedents
        if (_input.LA(1) == EOF && !indents.isEmpty()) {
            if (pending.isEmpty()) {
                pending.add(new CommonToken(NEWLINE, "\n"));
            }
            while (!indents.isEmpty()) {
                indents.pop();
                pending.add(new CommonToken(DEDENT, ""));
            }
            pending.add(new CommonToken(EOF, "<EOF>"));
        }

        if (!pending.isEmpty()) {
            return pending.poll();
        }

        return super.nextToken();
    }
}

// Keywords
DEF         : 'def';
RETURN      : 'return';
BREAK       : 'break';
PASS        : 'pass';
CONTINUE    : 'continue';
IF          : 'if';
ELIF        : 'elif';
ELSE        : 'else';
WHILE       : 'while';
TRY         : 'try';
FINALLY     : 'finally';
EXCEPT      : 'except';
FOR         : 'for';
IN          : 'in';
TRUE        : 'True';
FALSE       : 'False';
RANGE       : 'range';
IMPORT      : 'import';
FROM        : 'from';
AS          : 'as';
GLOBAL      : 'global';
NONE        : 'None';
IS          : 'is';
OR          : 'or';
AND         : 'and';
NOT         : 'not';

AT          : '@';

// Operators & Symbols
ASSIGN          : '=';
PLUS            : '+';
MINUS           : '-';
MULTIPLY        : '*';
DIVIDE          : '/';
MODIFY          : '%';

PLUS_EQUAL      : '+=';
MINUS_EQUAL      : '-=';
TIMES_EQUAL      : '*=';
DIVIDE_EQUAL      : '/=';
MODULO_EQUAL      : '%=';

EQUAL           : '==';
NOT_EQUAL       : '!=';
GREATER_EQUAL   : '>=';
LESS_EQUAL      : '<=';
GREATER_THAN    : '>';
LESS_THAN       : '<';

LP  : '(' { opened++; } ;
RP  : ')' { opened--; } ;
LSB : '[' { opened++; } ;
RSB : ']' { opened--; } ;
LCB : '{' { opened++; } ;
RCB : '}' { opened--; } ;
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

// New line

NEWLINE
    : '\r'? '\n' (' ' | '\t')*
      {
          String text = getText();
          int nlLen = text.indexOf('\n') + 1;
          int indent = text.length() - nlLen;

          if (opened > 0 || indent == 0) {
              // Continuation line or blank line → no indent token
              skip();
          } else {
              // Emit NEWLINE to hidden channel
              emit(new CommonToken(NEWLINE, "\n"));

              int prev = indents.isEmpty() ? 0 : indents.peekFirst();

              if (indent > prev) {
                  indents.push(indent);
                  emit(new CommonToken(INDENT, " ".repeat(indent)));
              } else if (indent < prev) {
                  while (!indents.isEmpty() && indent < indents.peekFirst()) {
                      indents.pop();
                      emit(new CommonToken(DEDENT, ""));
                  }
              }
              // equal indent → nothing
          }
      }
      -> channel(HIDDEN)
    ;

// Skipped
COMMENT           : '#' ~[\r\n]* -> skip;
MULTILINE_COMMENT : '"""' .*? '"""' -> skip;
MULTILINE_STRING  : '"""' .*? '"""' -> skip;
WS                : [ \t]+ -> skip;