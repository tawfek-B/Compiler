lexer grammar HTMLWithCSSLexer;

// JINJA2
JINJA_BLOCK_OPEN      : '{%' -> pushMode(JINJA_BLOCK) ;
JINJA_EXPR_OPEN       : '{{' -> pushMode(JINJA_EXPR) ;
JINJA_COMMENT_OPEN    : '{#' -> pushMode(JINJA_COMMENT) ;
JINJA_RAW_OPEN        : '{% raw %}' -> pushMode(JINJA_RAW) ;
JINJA_ENDRAW          : '{% endraw %}' ;

// HTML tags
TAG_OPEN              : '<' -> pushMode(TAG) ;
SCRIPT_OPEN           : '<script' (~'>')* '>' -> pushMode(SCRIPT) ;
STYLE_OPEN            : '<style' (~'>')* '>' -> pushMode(STYLE) ;

// tokens
XML                     : '<?xml' .*? '>' ;
DTD                     : '<!DOCTYPE' .*? '>' ;
CDATA                   : '<![CDATA[' .*? ']]>' ;
HTML_CONDITIONAL_COMMENT: '<!--[' .*? ']-->' ;
HTML_COMMENT            : '<!--' .*? '-->' ;
SCRIPTLET             : '<%' .*? '%>' | '<?' .*? '?>' ;

SEA_WS                : [ \t\r\n]+ -> skip ;


HTML_TEXT             : ~[<{%]+ ;


mode TAG;
    TAG_CLOSE           : '>' -> popMode ;
    TAG_SLASH_CLOSE     : '/>' -> popMode ;
    TAG_SLASH           : '/' ;
    TAG_EQUALS          : '=' -> pushMode(ATTVALUE) ;
    TAG_NAME            : TAG_NameStartChar TAG_NameChar* ;
    TAG_WHITESPACE      : [ \t\r\n]+ -> channel(HIDDEN) ;

    fragment TAG_NameStartChar
        : [:a-zA-Z]
        | '\u2070'..'\u218F'
        | '\u2C00'..'\u2FEF'
        | '\u3001'..'\uD7FF'
        | '\uF900'..'\uFDCF'
        | '\uFDF0'..'\uFFFD'
        ;
    fragment TAG_NameChar
        : TAG_NameStartChar
        | '-' | '_' | '.' | DIGIT
        | '\u00B7'
        | '\u0300'..'\u036F'
        | '\u203F'..'\u2040'
        ;
    fragment DIGIT      : [0-9] ;

mode ATTVALUE;
    ATTVALUE_VALUE      : ' '* ATTRIBUTE -> popMode ;
    ATTRIBUTE           : DOUBLE_QUOTE_STRING
                        | SINGLE_QUOTE_STRING
                        | ATTCHARS
                        | HEXCHARS
                        | DECCHARS
                        ;

    fragment ATTCHARS   : ATTCHAR+ ' '? ;
    fragment ATTCHAR    : '-' | '_' | '.' | '/' | '+' | ',' | '?' | '=' | ':' | ';' | '#' | [0-9a-zA-Z] ;
    fragment HEXCHARS   : '#' [0-9a-fA-F]+ ;
    fragment DECCHARS   : [0-9]+ '%'? ;
    fragment DOUBLE_QUOTE_STRING : '"' ~[<"]* '"' ;
    fragment SINGLE_QUOTE_STRING : '\'' ~[<']* '\'' ;


mode SCRIPT;
    SCRIPT_BODY         : .*? '</script>' -> popMode ;
    SCRIPT_SHORT_BODY   : .*? '</script>' -> popMode ;

mode STYLE;
    STYLE_CLOSE
        :   '</style>' -> popMode
        ;

CHARSET     : '@charset' S* STRING_MACR? S* ';' ;
IMPORT      : '@import' S* ;
KEYFRAMES   : '@keyframes' S* ;
MEDIA       : '@media' S* ;
PAGE        : '@page' S* ;
VIEWPORT    : '@viewport' S* ;
FONTFACE    : '@font-face' S* ;
MARGIN_AREA         : '@top-left-corner' | '@top-left' | '@top-center' | '@top-right' | '@top-right-corner'
                    | '@bottom-left-corner' | '@bottom-left' | '@bottom-center' | '@bottom-right' | '@bottom-right-corner'
                    | '@left-top' | '@left-middle' | '@left-bottom'
                    | '@right-top' | '@right-middle' | '@right-bottom' ;
ATKEYWORD           : '@' MINUS? IDENT_MACR ;
CLASSKEYWORD        : '.' IDENT_MACR ;
STRING              : STRING_MACR ;
UNCLOSED_STRING     : UNCLOSED_STRING_MACR ;
HASH                : '#' NAME_MACR ;
INDEX               : INTEGER_MACR? [Nn] (S* [+-] S* INTEGER_MACR)? ;
NUMBER              : NUMBER_MACR ;
PERCENTAGE          : NUMBER_MACR '%' ;
DIMENSION           : NUMBER_MACR IDENT_MACR ;
URI                 : 'url(' W_MACR (STRING_MACR | URI_MACR) W_MACR ')' ;
UNCLOSED_URI        : 'url(' W_MACR (STRING_MACR | UNCLOSED_STRING_MACR | URI_MACR) W_MACR ;
UNIRANGE            : 'U+' [0-9A-Fa-f?]+ ('-' [0-9A-Fa-f]+)? ;

CDO                 : '<!--' ;
CDC                 : '<--';
SEMICOLON           : ';' ;
COLON               : ':' ;
COMMA               : ',' ;
LCURLY              : '{' ;
RCURLY              : '}' ;
LPAREN              : '(' ;
RPAREN              : ')' ;
LBRACKET            : '[' ;
RBRACKET            : ']' ;
EXCLAMATION         : '!' ;
TILDE               : '~' ;
MINUS               : '-' ;
PLUS                : '+' ;
ASTERISK            : '*' ;
POUND               : '#' ;
INCLUDES            : '~=' ;
DASHMATCH           : '|=' ;
STARTSWITH          : '^=' ;
ENDSWITH            : '$=' ;
CONTAINS            : '*=' ;
EQUALS              : '=';
SLASH               : '/';
GREATER             : '>';
FUNCTION            : IDENT_MACR '(' ;
IDENT               : IDENT_MACR;

S                   : [ \t\r\n\f]+ -> skip;
COMMENT             : '/*' .*? '*/' -> channel(HIDDEN) ;
SL_COMMENT          : '//' .*? [\n\r] -> channel(HIDDEN) ;

IMPORTANT           : '!' S* 'important' ;

CSS_TEXT            : . ;
    mode JINJA_EXPR;
        JINJA_EXPR_CLOSE    : '}}' -> popMode ;
        JINJA_EXPR_CONTENT  : ( ~('}' ) | '}' ~('}' ) )+ ;

    mode JINJA_BLOCK;
        JINJA_BLOCK_CLOSE   : '%}' -> popMode ;
        JINJA_BLOCK_CONTENT : ( ~('%' ) | '%' ~('}' ) )+ ;

    mode JINJA_COMMENT;
        JINJA_COMMENT_CLOSE : '#}' -> popMode ;
        JINJA_COMMENT_CONTENT : ( ~('#' ) | '#' ~('}' ) )+ ;

   mode JINJA_RAW;
       JINJA_RAW_END       : '{% endraw %}' -> popMode ;
       JINJA_RAW_CONTENT   : ( ~('%' | '{') | '{' ~'%' | '%' ~'{' )+ ;

//CSS fragments
fragment IDENT_MACR     : NAME_START NAME_CHAR* ;
fragment NAME_MACR      : NAME_CHAR+ ;
fragment NAME_START     : [a-zA-Z_] | NON_ASCII | ESCAPE_CHAR ;
fragment NAME_CHAR      : [a-zA-Z0-9_-] | NON_ASCII | ESCAPE_CHAR ;
fragment NON_ASCII      : [\u0080-\uFFFF] ;
fragment ESCAPE_CHAR    : '\\' ([0-9a-fA-F] W_CHAR? | .) ;
fragment INTEGER_MACR   : [0-9]+ ;
fragment NUMBER_MACR    : [0-9]+ | [0-9]* '.' [0-9]+ ;
fragment STRING_MACR    : '"' (STRING_CHAR | '\'')* '"' | '\'' (STRING_CHAR | '"')* '\'' ;
fragment UNCLOSED_STRING_MACR : '"' STRING_CHAR* | '\'' STRING_CHAR* ;
fragment STRING_CHAR    : ~['"\\\r\n] | '\\' . ;
fragment URI_MACR       : URI_CHAR* ;
fragment URI_CHAR       : ~[ \t\r\n"'()\\] | ESCAPE_CHAR ;
fragment W_MACR         : W_CHAR* ;
fragment W_CHAR         : [ \t\r\n] ;
fragment CTRL_CHAR      : [\u0001-\u0008\u000E-\u001F];