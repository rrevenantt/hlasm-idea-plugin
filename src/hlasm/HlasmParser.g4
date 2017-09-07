parser grammar HlasmParser;
options { tokenVocab=HlasmLexer; }

@parser::header {
import org.antlr.jetbrains.adaptor.*;
}

@parser::members { public boolean isJcl = false;  }

lines2 : (statement| OLD_TOKEN)* EOF;

lines : //lines_wr EOF;

//lines_wr :
	(statement| OLD_TOKEN)*
//	 EOF
//	| line SPACES 'END'
	;
//code_chunks :
    //function_def line_wrapper+
//    function_def_wr (line_wrapper)* //line_wrappers
//    line_wrapper //line_wrappers
//    | macro   `   ``
//	;
   /* catch [NoViableAltException re] {
    if (_errHandler instanceof ErrorStrategyAdaptor){
        try{
            ((ErrorStrategyAdaptor)_errHandler).myRecover(this);
//               	_localctx.exception = re;
//               	_errHandler.reportError(this, re);
//               	_errHandler.recover(this, re);
        }
        catch (RecognitionException lre){
        	_localctx.exception = lre;
        	_errHandler.reportError(this, lre);
        	_errHandler.recover(this, lre);
        }
    }
//    else {
       	_localctx.exception = re;
       	_errHandler.reportError(this, re);
       	_errHandler.recover(this, re);
//    }
    }
    catch [RecognitionException re] {
    	_localctx.exception = re;
    	_errHandler.reportError(this, re);
    	_errHandler.recover(this, re);
    }*/
statement :
    line_wrapper
//    | OLD_TOKEN
    | macro
    ;

macro :
    MACRO arguments ENDLINE+ macro_def_wr lines LABEL_DEF? MEND arguments ENDLINE
    ;

macro_def_wr : line_wrapper  ;

//function_def_wr : LABEL_DEF line ENDLINE ;

//function_def:
//    LABEL_DEF line ENDLINE //(line_wrapper)+
//    ;

//endline: SPACES LABEL ENDLINE EOF;
//line_wrappers : (line_wrapper)+;
//    catch [RecognitionException e] {System.out.println("exception "+e.getMessage()); throw e;}
//    finally {System.out.println("1111 " + e.getMessage());}

line_wrapper :
    LABEL_DEF? line? ENDLINE

    ;

line :
//	COMMENT
	  AMODE (NUMBER|LABEL)
	|  COPY LABEL
	|  EJECT arguments
	|  END (LABEL|COMMA)?
	|  ENTRY LABEL+
	|  (LOCTR|LTORG) arguments
	|  OPSYN LABEL?
	|  CCW  arguments
	//| LABEL_DEF? CCW0
	|  ORG (expression|COMMA?)
	|  (SETB|SETA|SETC) complex_condition LABEL?  //LEFT_ROUND_PAR condition ( SPACES LABEL SPACES condition)*? RIGHT_ROUND_PAR LABEL?
	|  (AIF) complex_condition LABEL? (COMMA complex_condition LABEL?)*
	|  (SETB|SETA|SETC) (expression)
	|  USING expression (COMMA expression)+
	|  (DC | DS)  arguments
	| ALIAS LABEL
	| EQU arguments
	| (DSECT|RSECT|CSECT) (expression|COMMA?)
//	| LABEL_DEF? DROP (NUMBER|LABEL)+
	| DROP arguments
	| SPACE arguments
	| COMMAND arguments
	| ANOP arguments
	| (LCLA|LCLB|LCLC|GBLC|GBLB|GBLA) arguments
	| AGO LABEL
//	| LABEL_DEF? /*{_errHandler.sync(this);}*/ COMMAND
//	| ENDLINE
//	| LABEL_DEF
//	{
//	    if (getCurrentToken().getType() == ENDLINE){
//	        ErrorNode err = _localctx.addErrorNode(_localctx.getStart());
//	        Token currToken = _localctx.getStart();
//	               RecognitionException myex = new InputMismatchException(this){
//		    		@Override
//		    		public Token getOffendingToken() {
//		    			return currToken;
//		    		}
//		    	};
//	        notifyErrorListeners(currToken,"command expected",myex);
//	           if (_localctx != null ) throw myex;
//	    }
//	    else { _errHandler.recoverInline(this);}
//	}  // TODO FIX THIS WORKAROUND

//	)? ENDLINE
//	| EOF
//	| (LABEL)? SPACES command ENDLINE  //SPACES arguments
	;

complex_condition:
    LEFT_ROUND_PAR complex_condition RIGHT_ROUND_PAR
    | condition (LABEL complex_condition)?

;

condition :
    ((expression )? LABEL )? expression
    ;

arguments :
	argument (COMMA argument)+
//	| argument  ENDLINE v
	| argument
	;

argument :
	//expression SPACES? LABEL SPACES simple_expr      # MacroCond
	named_argument
	| expression
	;

named_argument:
    LABEL '=' expression
    ;

expression:
    simple_expr*
    | simple_expr? LEFT_ROUND_PAR arguments RIGHT_ROUND_PAR LABEL?
//    | simple_expr '(' simple_expr COMMA simple_expr ')'
//    | '=' simple_expr
    | expression (PLUS|MUL|DIVIDE) expression
    | expression MINUS expression
    ;

//subexpression :
//
//    ;

simple_expr:
    LABEL
//    | '='? D0  // TODO: Temp solution for D'0'
    | FIELD_INFO '='? LABEL
    | NUMBER
    | '*'
    | '='? (LEN_TYPE|LABEL) STRING
    | '='? LABEL? LEFT_ROUND_PAR arguments RIGHT_ROUND_PAR
    | STRING
    | LEN_TYPE
    | '='
    | DOT
    ;
