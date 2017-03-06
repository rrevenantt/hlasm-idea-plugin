package org.antlr.jetbrains.adaptor.parser;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.ATN;
import org.antlr.v4.runtime.atn.ATNState;
import org.antlr.v4.runtime.atn.ParserATNSimulator;
import org.antlr.v4.runtime.misc.IntervalSet;
import org.antlr.v4.runtime.misc.Pair;

/** Adapt ANTLR's DefaultErrorStrategy so that we add error nodes
 *  for EOF if reached at start of resync's consumeUntil().
 *  Also set start/stop of missing token to always be the current token,
 *  even if that's EOF.
 */
public class ErrorStrategyAdaptor extends DefaultErrorStrategy {
	@Override
	protected void consumeUntil(Parser recognizer, IntervalSet set) {
		Token o = recognizer.getCurrentToken();
		if ( o.getType()==Token.EOF ) {
			recognizer.getRuleContext().addErrorNode(o);
		}
		super.consumeUntil(recognizer, set);
	}

	/** By default ANTLR makes the start/stop -1/-1 for invalid tokens
	 *  which is reasonable but here we want to highlight the
	 *  current position indicating that is where we lack a token.
	 *  if no input, highlight at position 0.
	 */
	protected Token getMissingSymbol(Parser recognizer) {
		Token missingSymbol = super.getMissingSymbol(recognizer);
		// alter the default missing symbol.
		if ( missingSymbol instanceof CommonToken) {
			int start, stop;
			Token current = recognizer.getCurrentToken();
			start = current.getStartIndex();
			stop = current.getStopIndex();
//			if (start == stop) start-=1;
			((CommonToken) missingSymbol).setStartIndex(start);
			((CommonToken) missingSymbol).setStopIndex(stop);
		}
		return missingSymbol;
	}

	@Override
	public void sync(Parser recognizer) throws RecognitionException {
		ATNState s = (ATNState)((ParserATNSimulator)recognizer.getInterpreter()).atn.states.get(recognizer.getState());
		if(!this.inErrorRecoveryMode(recognizer)) {
			TokenStream tokens = recognizer.getInputStream();
			int la = tokens.LA(1);
			if(!recognizer.getATN().nextTokens(s).contains(la) && la != -1) {
				if(!recognizer.isExpectedToken(la)) {
					switch(s.getStateType()) {
						case 3:
						case 4:
						case 5:
						case 10:
							if(this.singleTokenInsertion(recognizer) && this.singleTokenDeletion(recognizer) == null) {
								throw new InputMismatchException(recognizer);
							}
//							if ()
//								throw new InputMismatchException(recognizer);
							return;
						case 9:
						case 11:
							this.reportUnwantedToken(recognizer);
							IntervalSet expecting = recognizer.getExpectedTokens();
							IntervalSet whatFollowsLoopIterationOrRule = expecting.or(this.getErrorRecoverySet(recognizer));
							this.consumeUntil(recognizer, whatFollowsLoopIterationOrRule);
						case 6:
						case 7:
						case 8:
						default:
					}
				}
			}
		}

	}


	public Token myRecover(Parser recognizer) throws RecognitionException {
		IntervalSet expecting = this.getExpectedTokens(recognizer);
		System.out.println("myRecover missing " + expecting.toString(recognizer.getVocabulary()));
		if(this.singleTokenInsertion(recognizer)) {
			return this.getMissingSymbol(recognizer);
		/*	Token currentSymbol = recognizer.getCurrentToken();
//			IntervalSet expecting = this.getExpectedTokens(recognizer);
			int expectedTokenType = expecting.getMaxElement();
			String tokenText;
			if(expectedTokenType == -1) {
				tokenText = "<missing EOF>";
			} else {
				tokenText = "<missing " + recognizer.getVocabulary().getDisplayName(expectedTokenType) + ">";
			}

			Token current = currentSymbol;
			Token lookback = recognizer.getInputStream().LT(-1);
			if(currentSymbol.getType() == -1 && lookback != null) {
				current = lookback;
			}

			return recognizer.getTokenFactory().create(new Pair(current.getTokenSource(), current.getTokenSource().getInputStream()), expectedTokenType, tokenText, 0, -1, -1, current.getLine(), current.getCharPositionInLine());
*/
		}
		else return recoverInline(recognizer);
	}

	//	@Override
//	public void recover(Parser recognizer, RecognitionException e) {
//		e.printStackTrace();
//		super.recover(recognizer, e);
//	}
}
