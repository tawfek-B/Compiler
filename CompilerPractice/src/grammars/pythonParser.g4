parser grammar pythonParser;

options { tokenVocab=pythonLexer; }

// Program
program
    : statement* EOF
    ;

// Statements
statement
    : assignment NEWLINE?                       #assign_Statement
    | ifStatement                               #if_Statement
    | forStatement                              #for_Statement
    | forEachStatement                          #for_Each_Statement
    | functionDec                               #function_Statement
    | decorator functionDec                     #decorated_Function_Statement
    | returnStatement NEWLINE?                  #return_Statement
    | expr NEWLINE?                             #expression_Statement
    ;

// Flask decorator
decorator
    : ROUTE LP STRING RP                        #routeDecorator
    ;


// Function declarations
functionDec
    : DEF ID LP parameterList? RP COLON block   #functionDeclaration
    ;

parameterList
    : ID (COMMA ID)*                            #parameterListDeclaration
    ;

block
    : NEWLINE INDENT statement+ DEDENT          #blockStatement
    ;


// Assign / Return
assignment
    : ID ASSIGN expr                            #assign
    ;

returnStatement
    : RETURN expr?                              #returnValue
    ;


// If / Elif / Else
ifStatement
    : IF expr COLON block elifStatement* elseStatement?    #ifBlock
    ;

elifStatement
    : ELIF expr COLON block                                #elifBlock
    ;

elseStatement
    : ELSE COLON block                                     #elseBlock
    ;


// Loops
forStatement
    : FOR ID ASSIGN expr SEMICOLON expr SEMICOLON assignment COLON block      #forLoop
    ;

forEachStatement
    : FOR ID IN expr COLON block                           #forEachLoop
    ;

// Expressions
expr
    : expr (MULTIPLY|DIVIDE|MODIFY) expr                                             #muldivExpression
    | expr (PLUS|MINUS) expr                                                         #addsubExpression
    | expr (EQUAL|NOT_EQUAL|GREATER_THAN|LESS_THAN|GREATER_EQUAL|LESS_EQUAL) expr    #compareExpression
    | LP expr RP                                                                     #parenthesisExpression
    | listLiteral                                                                    #listExpression
    | dictLiteral                                                                    #dictExpression
    | functionCall                                                                   #callExpression
    | NUMBER                                                                         #numberExpression
    | STRING                                                                         #stringExpression
    | TRUE                                                                           #trueExpression
    | FALSE                                                                          #falseExpression
    | ID                                                                             #idExpression
    ;


// Function calls
functionCall
    : ID LP argumentList? RP                      #functionCallExpression
    ;

argumentList
    : expr (COMMA expr)*                          #argumentListExpression
    ;

// Literals
listLiteral
    : LSB (expr (COMMA expr)*)? RSB               #listLiteralExpression
    ;

dictLiteral
    : LCB (expr (COMMA pair)*)? RCB               #dictLiteralExpression
    ;

pair
    : ID COLON expr                               #dictPairExpression
    ;
