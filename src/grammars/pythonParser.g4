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
    | importStatement                           #import_Statement
    | globalStatement                           #global_Statement
    | assignment                                #assign_Statement
    | ifStatement                               #if_Statement
    | forStatement                              #for_Statement
    | whileStatement                            #while_Statement
    | tryStatement                              #try_Statement
    | returnStatement                           #return_Statement
    | breakStatement                            #break_Statement
    | continueStatement                         #continue_Statement
    | passStatement                             #pass_Statement
    | expr SEMICOLON?                           #expression_Statement
    ;

// Import statements
importStatement
    : IMPORT dottedName (AS ID)?                #simpleImport
    | FROM dottedName IMPORT importNames        #fromImport
    ;

dottedName
    : ID (DOT ID)*
    ;

importNames
    : MULTIPLY
    | ID (AS ID)? (COMMA ID (AS ID)?)*
    ;

// Global statement
globalStatement
    : GLOBAL ID (COMMA ID)*
    ;

// Decorators
decorator
    : AT ID (DOT ID)* LP argumentList? RP      #decoratorWithArgs
    | AT ID LP argumentList? RP                #simpleDecorator
    ;

// Functions
functionDec
    : decorator* DEF ID LP parameterList? RP COLON block   #functionDeclaration
    ;

parameterList
    : ID (COMMA ID)*                            #parameterListDeclaration
    ;

// Blocks
block
    : INDENT statement+ DEDENT                  #blockStatement
    ;

// Assignment / Return
assignment
    : ID augAssign expr                         #augmentedAssignment
    | ID (DOT ID)*  ASSIGN expr                 #assign
    ;

augAssign
    : PLUS_EQUAL
    | MINUS_EQUAL
    | TIMES_EQUAL
    | DIVIDE_EQUAL
    | MODULO_EQUAL
    ;

returnStatement
    : RETURN expr?                              #returnValue
    ;

passStatement
    : PASS                                      #passBlock
    ;
breakStatement
    : BREAK                                     #breakBlock
    ;
continueStatement
    : CONTINUE                                  #continueBlock
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
forStatement
    : FOR ID IN expr COLON block elseStatement? #forLoop
    ;

whileStatement
    : WHILE expr COLON block elseStatement?     #whileLoop
    ;

// Try / except / finally
exceptStatement
    : EXCEPT expr? COLON block                  #exceptBlock
    ;

tryStatement
    : TRY COLON block (exceptStatement+ elseStatement? finallyStatement? | finallyStatement)  #tryBlock
    ;

finallyStatement
    : FINALLY COLON block                       #finallyBlock
    ;

// Expressions
expr
    : logicalOrExpr
    ;

logicalOrExpr
    : logicalAndExpr (OR logicalAndExpr)*           #logicalOrExpression
    ;

logicalAndExpr
    : notExpr (AND notExpr)*                        #logicalAndExpression
    ;

notExpr
    : NOT notExpr                                   #notExpression
    | NOT IN compareExpr                            #notInExpression         // optional but nice
    | compareExpr                                   #toComparison
    ;

compareExpr
    : addExpr (compOp addExpr)*                     #compareExpression
    ;

compOp
    : IS (NOT)?
    | NOT IN
    | IN
    | EQUAL
    | NOT_EQUAL
    | LESS_THAN
    | GREATER_THAN
    | LESS_EQUAL
    | GREATER_EQUAL
    ;

addExpr
    : mulExpr ((PLUS | MINUS) mulExpr)*         #addsubExpression
    ;

mulExpr
    : atom ((MULTIPLY | DIVIDE | MODIFY) atom)* #muldivExpression
    ;

atom
    : LP expr RP                                #parenthesisExpression
    | atom DOT ID                               #attributeAccess
    | atom LSB expr RSB                         #subscriptionExpression
    | atom LP argumentList? RP                  #callExpression
    | listLiteral                               #listExpression
    | listComp                                  #listCompExpression
    | generatorExpr                             #generatorAtomExpression
    | setComp                                   #setCompExpression            // optional
    | dictComp                                  #dictCompExpression           // optional
    | dictLiteral                               #dictExpression
    | NUMBER                                    #numberExpression
    | STRING                                    #stringExpression
    | TRUE                                      #trueExpression
    | FALSE                                     #falseExpression
    | NONE                                      #noneExpression
    | ID                                        #idExpression
    ;

// Remove or comment out these rules completely:
// functionCall
//     : ID LP argumentList? RP                    #functionCallExpression
//     ;

// List comprehension
// Replace your current listComp rule with these:

comp
    : FOR ID IN expr (IF expr)?        #comprehension
    ;

listComp
    : LSB expr comp+ RSB               #listComprehensionExpression
    ;

generatorExpr
    : LP expr comp+ RP                 #generatorExpression
    ;

setComp
    : LCB expr comp+ RCB               #setComprehensionExpression     // optional
    ;

dictComp
    : LCB pair comp+ RCB               #dictComprehensionExpression    // optional
    ;

// Function Calls
functionCall
    : ID LP argumentList? RP                    #functionCallExpression
    ;

argumentList
    : argument (COMMA argument)*                #argumentListExpression
    ;

argument
    : expr                                      #positionalArgument
    | ID ASSIGN expr                            #keywordArgument
    ;

// Literals
listLiteral
    : LSB (expr (COMMA expr)*)? RSB             #listLiteralExpression
    ;

dictLiteral
    : LCB (pair (COMMA pair)*)? RCB             #dictLiteralExpression
    ;

pair
    : (ID | STRING) COLON expr                  #dictPairExpression
    ;