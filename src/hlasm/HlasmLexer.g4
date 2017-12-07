lexer grammar HlasmLexer;

@lexer::header {
import java.util.*;
}

@lexer::members {
    public boolean isJcl = false;
    public HashSet<String> prologs = new HashSet(10);
    int spaces  = 0;
    int parenth = 0;
    int inAIF   = 0;
    StringBuilder lineEnd = new StringBuilder();
}

tokens {
PROLOG_MACRO, ENDLINE,COMMENT,ENDLINE_COMM,OLD_TOKEN,STRING_ERROR
}


//default mode

//COMMENT_sasdf:
//    'ASDFASDFASDFASDFSTRING THAT NEVER EXISTSASDFASDFASDFASDFASDFASDFASDF'
//    ;

LONG_COMMENT:
    '.'? '*' /*(~[\r\n])*?*/ -> more,pushMode(COMMENT_MODE)//{(_input.index()-_tokenStartCharIndex)<72}?
    //COMMENT_SHORT
    ;

//DOTCOMMENT:
//    DOT LONG_COMMENT -> type(COMMENT)
//    ;

LABEL_DEF :
	ID_START_ONLY (ID_CONTINUE | '&' | '.' | '(' | ')' )*  
	;

SPACES1:
    [ \t]+   -> mode(CMD),channel(HIDDEN)
    ;

ENDLINE:
     ( '\r'? '\n' ) {spaces = 0; parenth = 0; inAIF=0;_modeStack.clear();}  //-> type(COMMENT)//-> mode(DEFAULT_MODE)
    ;

//SINGLE_CRLF : '\r'?'\n' ->type(SPACES1),channel(HIDDEN);

UNKNOWN_CHAR1 : . -> type(UNKNOWN_CHAR);

mode CMD;

PUSH        : 'PUSH';
POP         : 'POP';
PRINT       : 'PRINT';
EQU         : 'EQU';
CSECT       : 'CSECT' ;
DSECT       : 'DSECT' ;
RSECT       : 'RSECT' ;
DS          : 'DS' ;
DC          : 'DC' ;
COPY        : 'COPY';
SPACE       : 'SPACE' ;
USING       : 'USING' ;
DROP        : 'DROP' ;
ALIAS       :  'ALIAS';
AMODE       :  'AMODE';
EJECT       :  'EJECT';
END         :  'END';
ENTRY       :  'ENTRY';
LOCTR       :  'LOCTR';
LTORG       :  'LTORG';
OPSYN       :  'OPSYN';
ORG         :  'ORG';
CCW         :  'CCW';
AGO         :  'AGO';
MACRO       :  'MACRO';
MEND        :  'MEND';
ANOP        :  'ANOP';
LCLA        :  'LCLA';
LCLB        :  'LCLB';
LCLC        :  'LCLC';
GBLC        :  'GBLC';
GBLA        :  'GBLA';
GBLB        :  'GBLB';
AIF         :  'AIF'  {inAIF = 1;};
SETB        :  'SETB' {inAIF = 1;};
SETA        :  'SETA' {inAIF = 1;};
SETC        :  'SETC' {inAIF = 1;};

COMMAND :
    ID_START (ID_CONTINUE)*
//    {
//        if (prologs.contains(getText()))
//            setType(PROLOG_MACRO);
//    }
    ;
//ENDLINE_COMM:
//    (( (SPACES ';'|SPACES ',')  (SPACES? |SPACES ~[\r\n]*)   ) | ENDLINE_EMPTY)
//                {spaces = 0; parenth = 0; inAIF=0;}  -> mode(DEFAULT_MODE),type(COMMENT)
//    ;
ENDLINE2:
    ( '\r'? '\n' ) {spaces = 0; parenth = 0; inAIF=0;_modeStack.clear();}   -> type(ENDLINE),mode(DEFAULT_MODE)
    ;

SPACES2:
    [ \t]+   -> mode(EVERYTHING),channel(HIDDEN),type(SPACES1)
    ;

//SINGLE_CRLF2 : '\r'?'\n' ->mode(DEFAULT_MODE),type(ENDLINE),channel(HIDDEN);
UNKNOWN_CHAR2 : . -> type(UNKNOWN_CHAR);

mode EVERYTHING;

//SPACES3:
  //  [ \t]+  {parenth == 0}? -> mode(ENDLINE),skip
    //;

//D0:  // TODO: Temp solution for D'0'
//    ([DL])'\''~[ +\-()\r\n]+ '\''->type(STRING);
STRING_DS:   // not full String handler to workaround D' and S'
    ('D'|'S') '\'' (~['\n\r])*? '\'' -> type(STRING)
    ;

FIELD_INFO:
    ('L'|'N'|'T'|'K'|'D'|'I'|'O'|'S')'\'';

STRING_QUOTE:
    NUMBER?([CGXBFHEDLPZAYSVJQR] [AEUHBDQY]? ('L' NUMBER+)?)?'\'' //-> more,pushMode(IN_STRING)
    {
//        if (_input.LA(1) == '\n'){
//                setType(STRING_ERROR);
//            }
//            else {
                more();
                pushMode(IN_STRING);
//            }
    }; //.*? '\'';


ENDLINE1:
    /*(SPACES ';'|SPACES ',')? */ ( '\r'? '\n' )   {spaces = 0; parenth = 0; inAIF=0;_modeStack.clear();}  -> mode(DEFAULT_MODE),type(ENDLINE)
    ;

//ARG_SEPARATOR :
//	(~[ ,\r] ( '\r'? '\n' ) '               '
//	| SPACES ~[\n\r]*? ~[ \r] ( '\r'? '\n' ) '               '    ) ->  channel(HIDDEN)         //{spaces >= 2}?
//	| COMMA
//    ENDLINE_COMMENT
//	;


fragment ENDLINE_EMPTY :
	SPACES? ( '\r'? '\n' )
	;
ONYL_CONT :
    ~[ \r\n] ( '\r'? '\n' ) {_tokenStartCharPositionInLine >=71}?
        -> pushMode(LINE_CONTINUATION),more
    ;
ENDLINE_COMMENT :
	SPACES ~[\n\r]* //( '\r'? '\n' )
	{
//	    int lineEnd = getText().indexOf("\n");
//        if (_tokenStartCharPositionInLine + getText().length() > 72)
//	        System.out.println(_tokenStartCharPositionInLine+" "+getText().length() + " |" + getText()+"|||" + getText().charAt(72-_tokenStartCharPositionInLine-1));

	    if(_tokenStartCharPositionInLine < 72 && _tokenStartCharPositionInLine + getText().length() >= 72
	            && getText().charAt(72-_tokenStartCharPositionInLine-1) != ' '){
//	            more();
                setType(ENDLINE_COMM);
                setChannel(HIDDEN);
	            pushMode(LINE_CONTINUATION);
	            ((LexerATNSimulator)this.getInterpreter()).consume(_input);
	    }
	    else{
	        setType(ENDLINE_COMM);
	        setChannel(HIDDEN);
//	        mode(DEFAULT_MODE);
//	        spaces = 0; parenth = 0; inAIF=0;
	    }

	}
	{inAIF==0 || parenth == 0}?  //{spaces >= 2 && parenth == 0}?
	;

LEFT_ROUND_PAR: '(' {parenth++;};
RIGHT_ROUND_PAR: ')' {parenth--;} ;
DOT : '.' ;
COMMA : ',' ;
PLUS : '+';
MINUS:'-';
EQUALS: '=';
MUL:'*';
DIVIDE:[/];


LEN_TYPE :
    NUMBER LABEL ;

NUMBER :
    DIGIT+
    ;

fragment DIGIT :
    [0-9]
    ;



LABEL :
	(ID_START_ONLY (ID_CONTINUE)*
	| '<' | '{' )//| ';'         // TEMP WORKAROUND WITH ;
	{
//	    if(getCharPositionInLine()==71 && _input.LA(1) != ' '){
//	        ((LexerATNSimulator)this.getInterpreter()).consume(_input);
//	    }
	    if(getCharPositionInLine()==72 && _input.LA(1) == '\n'){
	        ((LexerATNSimulator)this.getInterpreter()).consume(_input);
	        more();
	        pushMode(LABEL_CONTINUATION);
	    }
	    else if (getCharPositionInLine()>=72){
	        setType(ERROR);
	    }
	}
	;

/*LABEL_CONT :
    ID_START_ONLY (ID_CONTINUE)* '.'? ~[ /r/n] ('/r'? '/n')?
    {
        if(index()==73){
            more();
        	pushMode(LINE_CONTINUATION);
        }
    }
    ;*/

//LABEL_SEP :
//    ID_START_ONLY (ID_CONTINUE)* (~[ /r/n] '\r'? '\n' '               ') (ID_CONTINUE)* '.'?
//    ;

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




//mode ENDLINE;

SPACES:
    [ \t]+ -> channel(HIDDEN),type(SPACES1)//-> skip //{spaces++; System.out.print(" " + spaces); if (spaces >= 2) }
    ;

//SINGLE_CRLF3 :
//    '\r'?'\n'
//    {
//        spaces = 0; parenth = 0; inAIF=0;
//    }-> mode(DEFAULT_MODE),type(ENDLINE),channel(HIDDEN)
//;
UNKNOWN_CHAR : . ;

mode IN_STRING;

ESCAPE : '\'\'' -> more;
STRING : '\'' -> popMode;

BAD_STRING : '\r'? '\n' -> type(STRING_ERROR),mode(DEFAULT_MODE);
SPACES_COMM1 : SPACES ->more;
COMMENT_CONT1 : ~[ \r\n]
 {
// 	    if(getCharPositionInLine()==71 && _input.LA(1) != ' '){
// 	        ((LexerATNSimulator)this.getInterpreter()).consume(_input);
// 	    }
 	    if(getCharPositionInLine()==72 && _input.LA(1) == '\n'){
 	        ((LexerATNSimulator)this.getInterpreter()).consume(_input);
 	        more();
 	        //pushMode(LABEL_CONTINUATION);
 	    }
 	    else if (getCharPositionInLine()>=72){
 	        setType(ERROR);
 	    }

//        if (_input.LA(1) == '\n'){
//            setType(ERROR);
//        }
//        else {
            more();
//        }

//        if (getCharPositionInLine() < 15){
//            more();
//        }
//        else{
//            setType(ERROR);
//            popMode();
//        }

 	}
;

mode LINE_CONTINUATION;

ARG_SEPARATOR :   '               ' -> popMode,channel(HIDDEN);
ERROR : '\r'? '\n' {
    _modeStack.clear();
    mode(DEFAULT_MODE);
    if (getCharPositionInLine() < 15)
        setType(ENDLINE);
    };
ERROR2 : .
    {
        if (getCharPositionInLine() < 15 && _input.LA(1) != -1){
            if ( _input.LA(1) != '\n')
                more();
        }
        else{
            setType(ERROR);
            popMode();
        }
    }
    ;

mode LABEL_CONTINUATION;
LABEL_SEP : '               ' (ID_CONTINUE)*
    -> popMode,type(LABEL);
ERROR3 : '\r'? '\n' -> popMode,type(ERROR);
ERROR4 : .
    {
        if (getCharPositionInLine() < 15){
            more();
        }
        else{
            setType(ERROR);
            popMode();
        }
    }
    ;

mode COMMENT_MODE;

//COMMENT_ENDLINE : ~[ ]'\r'? '\n'
//    {
//        if (Math.floorMod(getCharIndex()-_tokenStartCharIndex,73)!=0){
//            setType(COMMENT);
//            popMode();
//        }
//        else{
//            more();
//        }
//    }
//    ;
//COMMENT_ENDLINE2 : [ ]'\r'? '\n' -> popMode,type(COMMENT)
//    ;
COMMENT_ENDLINE3 : '\r'? '\n' -> popMode,type(ENDLINE)
    ;
//SPACES_COMM : SPACES ->more;
COMMENT_CONT : ~[\r\n]
 {

//        if(_input.LA(1) == '\n'){
//            System.out.println(getCharPositionInLine());
//        }
 	    if(getCharPositionInLine()==71)
 	    {
 	        setType(COMMENT);
 	        setChannel(HIDDEN);
 	        boolean shouldCancelMore = true;
 	        if(_input.LA(1) != ' ' && _input.LA(1) != '\n' && _input.LA(1) != -1){
 	            shouldCancelMore = false;
 	        }
// 	        else{
//				//popMode();
				if (_input.LA(1) == '\n')
				    break;
//			}

 	        while (_input.LA(1) != '\n' && _input.LA(1) != -1){
 	            //if (_input.LA(1) != ' ') shouldCancelMore = true;
 	            ((LexerATNSimulator)this.getInterpreter()).consume(_input);
 	        }
 	        if (!shouldCancelMore) {
 	            more();
 	            if (_input.LA(1) != -1)
 	                ((LexerATNSimulator)this.getInterpreter()).consume(_input);
 	        }
 	        break;
        }
// 	    if (getCharPositionInLine()>=72 ){
// 	        setType(ERROR);
// 	        while (_input.LA(1) != '\n'){
// 	            ((LexerATNSimulator)this.getInterpreter()).consume(_input);
// 	        }
// 	        more();
// 	        break;
// 	    }

 	    if (_input.LA(1) == '\n'){
 	        setType(COMMENT);
            break;
        }
        else {
            if (_input.LA(1) == '\n')
        	    break;
            more();
        }
//        if (getCharPositionInLine() < 15){
//            more();
//        }
//        else{
//            setType(ERROR);
//            popMode();
//        }

 	}
;

