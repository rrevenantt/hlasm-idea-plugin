lexer grammar JclLexer;

LINE_COMMENT    :   '//*' (~[\r\n])* ( '\r'? '\n' | EOF );
JOB_OPTION      :   '/*'  (~[\r\n])* ( '\r'? '\n' | EOF );

LINE_START      :   '//'   -> mode(LBL);

SYSIN           :    ~[/\r\n] (~[\r\n])*? ( '\r'? '\n' | EOF );

UNKNOWN_SYMBOL4 :   .   -> type(UNCKNOWN_SYMBOL);

mode LBL;
LABEL_DEF :
	ID_START_ONLY (ID_CONTINUE)*;

SPACES1:
    [ \t]+   -> mode(CMD),channel(HIDDEN)
    ;

ENDLINE:
    ENDLINE_EMPTY  -> mode(DEFAULT_MODE),channel(HIDDEN)
    ;

UNKNOWN_SYMBOL1 :   .   -> type(UNCKNOWN_SYMBOL);

mode CMD;

DD          :   'DD'    ;
EXEC        :   'EXEC'  ;
JOB         :   'JOB'   ;
SET         :   'SET'   ;

ANY_COMMAND :   ID_START (ID_CONTINUE)* ;

SPACES2:
    [ \t]+   -> mode(EVERYTHING),channel(HIDDEN),type(SPACES1)
    ;

ENDLINE2:
    ENDLINE_EMPTY  -> mode(DEFAULT_MODE),type(ENDLINE),channel(HIDDEN)
    ;

UNKNOWN_SYMBOL2 :   .   -> type(UNCKNOWN_SYMBOL);

mode EVERYTHING;

LEFT_ROUND_PAR: '(' ;
RIGHT_ROUND_PAR: ')' ;
EQUALS: '=';
EQUAL_FOR_TAPE: '=/';    // TODO: Temp solution for UNIT=/2101
MUL:'*';
COMMA_2 : ','ENDLINE_EMPTY-> type(COMMA),mode(CONTINUATION);
COMMA_1 : ', '-> type(COMMA),mode(CONTINUATION);
COMMA:',' ;
PLUS : '+';
MINUS:'-';
STRING : '\'' ('\'\'' | ~['] )*? '\'' ;

NUMBER :
    DIGIT+
    ;

fragment DIGIT :
    [0-9]
    ;
LABEL :
	ID_START_ONLY (ID_CONTINUE)*
	| '/' ID_START_ONLY (ID_CONTINUE)* '/';

fragment ID_START_ONLY:
    ID_START
    | '&' | '.'
    ;

fragment ID_START:
	[A-Z]
	| [a-z]
	| '@'|'#'|'$'|'_'
	| '&'                 // Temp solution for macro vars
	;

fragment ID_CONTINUE:
	ID_START
	| DIGIT
	| '%' | '.'
	;

ENDLINE1:
    (ENDLINE_EMPTY|(SPACES ENDLINE_COMMENT))  -> mode(DEFAULT_MODE),channel(HIDDEN)
    ;

fragment ENDLINE_EMPTY :
	SPACES? ( '\r'? '\n' | EOF)
	;
fragment ENDLINE_COMMENT :
	SPACES? ~[\n\r]*? ( '\r'? '\n'  | EOF)
	;
SPACES:
    [ \t]+ //-> skip //{spaces++; System.out.print(" " + spaces); if (spaces >= 2) }
    ;


UNCKNOWN_SYMBOL :   .   ;

mode CONTINUATION;

//LABEL1 :
//	ID_START_ONLY (ID_CONTINUE)* -> type(LABEL),mode(EVERYTHING);

//COMMA1 : ',' -> type(COMMA);

LINE_START1 :'//' [ \t]+ -> channel(HIDDEN),mode(EVERYTHING);

ENDLINE3:
    (ENDLINE_EMPTY|SYSIN)  -> channel(HIDDEN),type(ENDLINE1)
    ;

UNKNOWN_SYMBOL3 :   .   -> type(UNCKNOWN_SYMBOL);
