package com.hlasm_plugin;

import com.hlasm_plugin.psi.HlasmRecursiveWSTokenBinders;
import com.intellij.lang.ASTNode;
import com.intellij.lang.PsiBuilder;
import com.intellij.openapi.progress.ProgressIndicatorProvider;
import com.intellij.psi.tree.IElementType;
import com.intellij.psi.tree.IFileElementType;
import hlasm.HlasmLexer;
import hlasm.HlasmParser;
import org.antlr.jetbrains.adaptor.lexer.PSIElementTypeFactory;
import org.antlr.jetbrains.adaptor.lexer.RuleIElementType;
import org.antlr.jetbrains.adaptor.lexer.TokenIElementType;
import org.antlr.jetbrains.adaptor.parser.ANTLRParseTreeToPSIConverter;
import org.antlr.jetbrains.adaptor.parser.ANTLRParserAdaptor;
import org.antlr.jetbrains.adaptor.parser.ErrorStrategyAdaptor;
import org.antlr.v4.runtime.Parser;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.RuleContext;
import org.antlr.v4.runtime.atn.ATN;
import org.antlr.v4.runtime.atn.ATNState;
import org.antlr.v4.runtime.atn.ParserATNSimulator;
import org.antlr.v4.runtime.atn.RuleTransition;
import org.antlr.v4.runtime.misc.IntervalSet;
import org.antlr.v4.runtime.tree.ParseTree;
import org.jetbrains.annotations.NotNull;

/**
 * Created by anisik on 28.06.2017.
 */
public class HlasmANTLRParserAdaptor extends ANTLRParserAdaptor {

    public HlasmANTLRParserAdaptor(Parser parser) {
        super(HlasmLanguage.INSTANCE, parser);
    }


    @Override
    protected ParseTree parse(Parser parser, IElementType root) {
        parser.setErrorHandler(new ErrorStrategyAdaptor(){
            @Override
            protected void consumeUntil(Parser recognizer, IntervalSet set) {
//                System.out.println("--- recovering in rule " + HlasmParser.ruleNames[ recognizer.getContext().getRuleIndex()]);
//                System.out.println("--- recovering set:"+set.toString(recognizer.getVocabulary()));
//                if(	recognizer.getContext().getRuleIndex() == HlasmParser.RULE_line_wrapper
//                        || recognizer.getContext().getRuleIndex() == HlasmParser.RULE_line
//                        || recognizer.getContext().getRuleIndex() == HlasmParser.RULE_arguments
//                        ) {
//                    super.consumeUntil(recognizer, new IntervalSet(HlasmLexer.ENDLINE));
//                }

                int posBefore = recognizer.getInputStream().index();
                super.consumeUntil(recognizer, set);
                if (posBefore == recognizer.getInputStream().index()){
                    recognizer.consume();
                }

            }
            @Override
            protected IntervalSet getErrorRecoverySet(Parser recognizer) {
                ATN atn = ((ParserATNSimulator)recognizer.getInterpreter()).atn;
                RuleContext ctx = recognizer.getContext();

                IntervalSet recoverSet;
                for(recoverSet = new IntervalSet(); ctx != null && ((RuleContext)ctx).invokingState >= 0; ctx = ((RuleContext)ctx).parent) {
                    if (ctx.getRuleIndex() == HlasmParser.RULE_statement){
                        recoverSet.add(HlasmParser.LABEL_DEF);
                        recoverSet.add(HlasmParser.EQU,HlasmParser.COMMAND);
                        continue;
                    }
                    ATNState invokingState = (ATNState)atn.states.get(((RuleContext)ctx).invokingState);
                    RuleTransition rt = (RuleTransition)invokingState.transition(0);
                    IntervalSet follow = atn.nextTokens(rt.followState);
                    recoverSet.addAll(follow);
                }

                recoverSet.remove(-2);
                return recoverSet;
            }

        });

        if (root instanceof IFileElementType) {
            return ((HlasmParser) parser).lines2();
        }
        if (root instanceof RuleIElementType) {
            switch (((RuleIElementType) root).getRuleIndex()) {
                case HlasmParser.RULE_line_wrapper:
                    System.out.println("line reparsing");
                    return ((HlasmParser) parser).line_wrapper();
                case HlasmParser.RULE_statement:
                    System.out.println("statement line reparsing");
                    return ((HlasmParser) parser).statement2();
                case HlasmParser.RULE_lines:
                    System.out.println("lines reparsing");
                    return ((HlasmParser) parser).lines2();
//                        case HlasmParser.RULE_code_chunks:
//                            System.out.println("code block reparsing");
//                            return ((HlasmParser) parser).code_chunks();
                default:
                    return ((HlasmParser) parser).statement();
            }
        }

        if (root instanceof TokenIElementType) {
            System.out.println("leaf reparsing " + HlasmParser.tokenNames[((TokenIElementType) root).getANTLRTokenType()]);
            System.out.println("data " + ((HlasmParser) parser).getInputStream().getText());
            return ((HlasmParser) parser).simple_expr();
        }
        System.out.println(" parsing of " + HlasmParser.ruleNames[((RuleIElementType) root).getRuleIndex()]);
        return ((HlasmParser) parser).line_wrapper();
    }

    @NotNull
    @Override
    public ASTNode parse(IElementType root, PsiBuilder builder) {
        if (root instanceof IFileElementType) {
            System.out.println("-------Full tree reparse");
            //Pair.getFirst(chameleon.getUserData(BlockSupport.TREE_TO_BE_REPARSED))


            //builder.
        }

        ASTNode node = super.parse(root, builder);

        return node;
    }

    @Override
    protected ANTLRParseTreeToPSIConverter createListener(Parser parser, IElementType root, PsiBuilder builder) {
        return new ANTLRParseTreeToPSIConverter(language, parser, builder) {
            @Override
            public void enterEveryRule(ParserRuleContext ctx) {
                ProgressIndicatorProvider.checkCanceled();
                PsiBuilder.Marker marker = getBuilder().mark();

                if (language.is(HlasmLanguage.INSTANCE)) {
                    if (ctx.getRuleIndex() == HlasmParser.RULE_line
                            || ctx.getRuleIndex() == HlasmParser.RULE_line_wrapper
                            || ctx.getRuleIndex() == HlasmParser.RULE_macro_def_wr
                            || ctx.getRuleIndex() == HlasmParser.RULE_statement
                            || ctx.getRuleIndex() == HlasmParser.RULE_macro
                            || ctx.getRuleIndex() == HlasmParser.RULE_lines2
                            || ctx.getRuleIndex() == HlasmParser.RULE_lines) {
                        marker.setCustomEdgeTokenBinders(HlasmRecursiveWSTokenBinders.leadingCommentsBinder(
                                PSIElementTypeFactory.createTokenSet(HlasmLanguage.INSTANCE, HlasmLexer.SPACES1, HlasmLexer.COMMENT)
                        ), null);
                    }
                }
                markers.push(marker);
            }

            @Override
            public void exitEveryRule(ParserRuleContext ctx) {
                ProgressIndicatorProvider.checkCanceled();
                PsiBuilder.Marker marker = markers.pop();

                marker.done((IElementType) getRuleElementTypes().get(ctx.getRuleIndex()));

                if (language.is(HlasmLanguage.INSTANCE)) {
                    if (ctx.getRuleIndex() == HlasmParser.RULE_line
                            || ctx.getRuleIndex() == HlasmParser.RULE_statement
                            || ctx.getRuleIndex() == HlasmParser.RULE_line_wrapper
                            || ctx.getRuleIndex() == HlasmParser.RULE_macro
                            || ctx.getRuleIndex() == HlasmParser.RULE_macro_def_wr
                            || ctx.getRuleIndex() == HlasmParser.RULE_lines2
                            || ctx.getRuleIndex() == HlasmParser.RULE_lines) {
                        marker.setCustomEdgeTokenBinders(HlasmRecursiveWSTokenBinders.leadingCommentsBinder(
                                PSIElementTypeFactory.createTokenSet(HlasmLanguage.INSTANCE, HlasmLexer.SPACES1, HlasmLexer.COMMENT))
                                , HlasmRecursiveWSTokenBinders.trailingCommentsBinder(
                                        PSIElementTypeFactory.createTokenSet(HlasmLanguage.INSTANCE, HlasmLexer.ENDLINE_COMM, HlasmLexer.ARG_SEPARATOR)
                                ));
                    }
                }
            }

        };
    }

}
