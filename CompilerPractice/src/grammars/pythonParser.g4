parser grammar pythonParser;

options { tokenVocab=pythonLexer; }

// Program
program
    : statement* EOF
    ;

// Statements
statement
    : decorator NEWLINE functionDec             #decorated_LN_Function_Statement
    | decorator functionDec                     #decorated_Function_Statement
    | assignment                                #assign_Statement
    | ifStatement                               #if_Statement
//    | forStatement                              #for_Statement
    | whileStatement                            #while_Statement
    | tryStatement                              #try_Statement
    | forEachStatement                          #for_Each_Statement
    | functionDec                               #function_Statement
    | returnStatement                           #return_Statement
    | expr                                      #expression_Statement
    ;

// Decorators
decorator
    : ROUTE LP STRING RP                        #routeDecorator
    ;

// Functions
functionDec
    : DEF ID LP parameterList? RP COLON block   #functionDeclaration
    ;

parameterList
    : ID (COMMA ID)*                            #parameterListDeclaration
    ;

// Blocks
block
    : INDENT statement+ DEDENT                  #blockStatement
    ;

// Assignment & Return
assignment
    : ID ASSIGN expr                            #assign
    ;

returnStatement
    : RETURN expr?                              #returnValue
    ;

// Conditionals
ifStatement
    : IF expr COLON block elifStatement* elseStatement?  #ifBlock
    ;

elifStatement
    : ELIF expr COLON block                     #elifBlock
    ;

elseStatement
    : ELSE COLON block                          #elseBlock
    ;

// Loops
//forStatement
//    : FOR ID IN RANGE LP expr COMMA expr (COMMA expr)? RP COLON block     #forLoop
//    ;

forEachStatement
    : FOR ID IN expr COLON block elseStatement? #forEachLoop
    ;

whileStatement
    : WHILE expr COLON block elseStatement?     #whileLoop
    ;

exceptStatement
    : EXCEPT expr? COLON block    #exceptBlock
    ;

tryStatement
    : TRY COLON block (exceptStatement+ elseStatement? finallyStatement? | finallyStatement)  #tryBlock
    ;

finallyStatement
    : FINALLY COLON block   #finallyBlock
    ;

// Expressions
expr
    : compareExpr
    ;

compareExpr
    : addExpr ((EQUAL | NOT_EQUAL | GREATER_THAN | LESS_THAN | GREATER_EQUAL | LESS_EQUAL) addExpr)*    #compareExpression
    ;

addExpr
    : mulExpr ((PLUS | MINUS) mulExpr)*         #addsubExpression
    ;

mulExpr
    : atom ((MULTIPLY | DIVIDE | MODIFY) atom)* #muldivExpression
    ;

atom
    : LP expr RP                                #parenthesisExpression
    | listLiteral                               #listExpression
    | dictLiteral                               #dictExpression
    | functionCall                              #callExpression
    | NUMBER                                    #numberExpression
    | STRING                                    #stringExpression
    | TRUE                                      #trueExpression
    | FALSE                                     #falseExpression
    | ID                                        #idExpression
    ;

// Function Calls
functionCall
    : ID LP argumentList? RP                    #functionCallExpression
    ;

argumentList
    : expr (COMMA expr)*                        #argumentListExpression
    ;

// Literals
listLiteral
    : LSB (expr (COMMA expr)*)? RSB             #listLiteralExpression
    ;

dictLiteral
    : LCB (pair (COMMA pair)*)? RCB             #dictLiteralExpression
    ;

pair
    : ID COLON expr                             #dictPairExpression
    ;