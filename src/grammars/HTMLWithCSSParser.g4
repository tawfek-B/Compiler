parser grammar HTMLWithCSSParser;

options {tokenVocab=HTMLWithCSSLexer;}

htmlDocument
    : documentItem* EOF
    ;

documentItem
    : SEA_WS                                            # seaWsItem
    | SCRIPTLET                                         # scriptletItem
    | XML                                               # xmlItem
    | DTD                                               # dtdItem
    | HTML_COMMENT                                      # htmlCommentItem
    | HTML_CONDITIONAL_COMMENT                          # conditionalCommentItem
    | jinjaExpression                                   # jinjaExprItem
    | jinjaBlock                                        # jinjaBlockItem
    | jinjaComment                                      # jinjaCommentItem
    | htmlElement                                       # htmlElementItem
    ;

htmlElement
    : TAG_OPEN TAG_NAME htmlAttribute* TAG_CLOSE
      htmlContent?
      TAG_OPEN TAG_SLASH TAG_NAME TAG_CLOSE             # htmlPairedTag
    | TAG_OPEN TAG_NAME htmlAttribute* TAG_SLASH_CLOSE  # htmlVoidTag
    | SCRIPTLET                                         # scriptletElement
    | SCRIPT_OPEN (SCRIPT_BODY | SCRIPT_SHORT_BODY)     # scriptTag
    | style                                             # styleTag
    ;

style
    : STYLE_OPEN stylesheet STYLE_CLOSE                 # fullStyle
    ;

jinjaExpression
    : JINJA_EXPR_OPEN JINJA_EXPR_CONTENT JINJA_EXPR_CLOSE   # jinjaExpr
    ;

jinjaBlock
    : JINJA_BLOCK_OPEN JINJA_BLOCK_CONTENT JINJA_BLOCK_CLOSE # jinjaBlockTag
    | JINJA_RAW_OPEN JINJA_RAW_CONTENT JINJA_RAW_END         # jinjaRawBlock
    ;

jinjaComment
    : JINJA_COMMENT_OPEN JINJA_COMMENT_CONTENT JINJA_COMMENT_CLOSE # jinjaComm
    ;

htmlContent
    : ( htmlChardata
      | htmlElement
      | CDATA
      | HTML_COMMENT
      | HTML_CONDITIONAL_COMMENT
      | jinjaExpression
      | jinjaBlock
      | jinjaComment
      )*                                                # htmlContentBlock
    ;

htmlChardata
    : HTML_TEXT                                         # textData
    | SEA_WS                                            # wsData
    ;

htmlAttribute
    : TAG_NAME (TAG_EQUALS ATTVALUE_VALUE)?             # attr
    ;

htmlMisc
    : HTML_COMMENT | HTML_CONDITIONAL_COMMENT | SEA_WS
    ;

stylesheet
    : ( CDO | CDC | S | statement )*
    ;

statement
    : ruleset | atstatement
    ;

atstatement
    : CHARSET
    | IMPORT S* (STRING | URI | UNCLOSED_STRING | UNCLOSED_URI) S* media? SEMICOLON
    | PAGE pseudo? S* LCURLY S* declarations margin_rule* RCURLY
    | VIEWPORT S* LCURLY S* declarations RCURLY
    | FONTFACE S* LCURLY S* declarations RCURLY
    | MEDIA S* media? LCURLY S* (media_rule S*)* RCURLY
    | KEYFRAMES S* IDENT S* LCURLY S* (keyframe_block S*)* RCURLY
    | ATKEYWORD S* any* (LCURLY any* RCURLY | SEMICOLON)
    ;

media
    : media_query (COMMA S* media_query)*
    ;

media_query
    : (media_term S*)+
    ;

media_term
    : IDENT | LPAREN S* IDENT S* (COLON S* terms)? RPAREN
    ;

media_rule
    : ruleset | atstatement
    ;

keyframe_block
    : keyframe_selector (COMMA S* keyframe_selector)* LCURLY S* declarations RCURLY
    ;

keyframe_selector
    : IDENT | PERCENTAGE
    ;

ruleset
    : (combined_selector (COMMA S* combined_selector)*)? LCURLY S* declarations RCURLY
    ;

combined_selector
    : selector (combinator selector)*
    ;

combinator
    : GREATER S* | PLUS S* | TILDE S* | S+
    ;

selector
    : (IDENT | ASTERISK) selpart* S*
    | selpart+ S*
    ;

selpart
    : HASH | CLASSKEYWORD | LBRACKET S* attribute RBRACKET | pseudo
    ;

attribute
    : IDENT S* ((EQUALS | INCLUDES | DASHMATCH | STARTSWITH | ENDSWITH | CONTAINS) S* (IDENT | STRING) S*)?
    ;

pseudo
    : COLON COLON? (MINUS? IDENT | FUNCTION S* (MINUS? IDENT | MINUS? NUMBER | MINUS? INDEX | selector (COMMA S* selector)*) S* RPAREN)
    ;

declarations
    : declaration? (SEMICOLON S* declaration?)*
    ;

declaration
    : IDENT COLON S* terms? IMPORTANT?
    ;

terms
    : term+
    ;

term
    : IDENT | NUMBER | PERCENTAGE | DIMENSION | STRING | UNCLOSED_STRING
    | URI | UNCLOSED_URI | HASH | UNIRANGE | funct
    | MINUS | PLUS | COMMA | SLASH
    ;

funct
    : FUNCTION S* terms? RPAREN
    ;

any
    : . // fallback
    ;

margin_rule : MARGIN_AREA S* LCURLY S* declarations RCURLY ;