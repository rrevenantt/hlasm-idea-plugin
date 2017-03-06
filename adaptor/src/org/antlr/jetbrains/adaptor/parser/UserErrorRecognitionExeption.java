package org.antlr.jetbrains.adaptor.parser;

import org.antlr.v4.runtime.*;

/**
 * Created by anisik on 16.11.2016.
 */
public class UserErrorRecognitionExeption extends RecognitionException {
    public UserErrorRecognitionExeption(String message, Parser parser, IntStream input, ParserRuleContext ctx) {
        super(message, parser, input, ctx);
        this.setOffendingToken(parser.getCurrentToken());
    }
}
