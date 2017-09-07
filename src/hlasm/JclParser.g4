parser grammar JclParser;
options { tokenVocab = JclLexer; }

file        : line+ EOF ;

line        : LINE_COMMENT
            | JOB_OPTION
            | LINE_START (command| ENDLINE)?
            | SYSIN
            ;

command     : LABEL_DEF? keyword arguments? ;

arguments :
	argument (COMMA argument)*
//	| argument
	;

argument :
	//expression SPACES? LABEL SPACES simple_expr      # MacroCond
	named_argument
	| expression
	;

named_argument:
    LABEL EQUALS argument
    | LABEL EQUAL_FOR_TAPE argument     // TODO: Temp solution for UNIT=/2101
    ;

expression:
    simple_expr+
    | simple_expr? LEFT_ROUND_PAR arguments RIGHT_ROUND_PAR
//    | simple_expr '(' simple_expr COMMA simple_expr ')'
//    | '=' simple_expr
    | expression (PLUS|MUL) expression
    | expression MINUS expression
    ;

simple_expr:
    LABEL
    | NUMBER
    | '*'
//    | '='? LABEL? LEFT_ROUND_PAR arguments RIGHT_ROUND_PAR
    | STRING
    ;

keyword     :
    DD
    | EXEC
    | JOB
    | SET
    | ANY_COMMAND
    ;