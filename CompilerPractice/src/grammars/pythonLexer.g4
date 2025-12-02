lexer grammar pythonLexer;

// Keywords

IF: 'if';
ELIF: 'else if';
ELSE: 'else';
FOR: 'for';
IN: 'in';
DEF: 'def';
TRUE: 'true';
FALSE: 'false';
RETURN: 'return';

// flask decorator keyword
ROUTE: '@route';


// Operatiors

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
LP: '(';
RP: ')';
LSB: '[';
RSB: ']';
LCB: '{';
RCB: '}';
DOUBLE_COT: '"';
HASHTAG: '#';
COMMA: ',';
COLON: ':';
SEMICOLON: ';';
DOT: '.';


// Identifiers - comments and white space

NUMBER: [0-9]+ (DOT[0-9]+)?;
STRING: DOUBLE_COT (~["\r\n])* DOUBLE_COT;
ID: [a-zA-Z_][a-zA-Z0-9]*;

COMMENT: HASHTAG ~[\r\n]* -> skip;
MULTILINE_COMMENT: '"""' (.)*? '"""' -> skip;
WS: [ \t]+ -> skip;
NEWLINE: '\r'? '\n';


