// Generated from C:/Users/anisik/IdeaProjects/hlasm-library-antlr/src/hlasm\HlasmParser.g4 by ANTLR 4.7
package hlasm;

import org.antlr.jetbrains.adaptor.*;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link HlasmParser}.
 */
public interface HlasmParserListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link HlasmParser#lines2}.
	 * @param ctx the parse tree
	 */
	void enterLines2(HlasmParser.Lines2Context ctx);
	/**
	 * Exit a parse tree produced by {@link HlasmParser#lines2}.
	 * @param ctx the parse tree
	 */
	void exitLines2(HlasmParser.Lines2Context ctx);
	/**
	 * Enter a parse tree produced by {@link HlasmParser#lines}.
	 * @param ctx the parse tree
	 */
	void enterLines(HlasmParser.LinesContext ctx);
	/**
	 * Exit a parse tree produced by {@link HlasmParser#lines}.
	 * @param ctx the parse tree
	 */
	void exitLines(HlasmParser.LinesContext ctx);
	/**
	 * Enter a parse tree produced by {@link HlasmParser#statement2}.
	 * @param ctx the parse tree
	 */
	void enterStatement2(HlasmParser.Statement2Context ctx);
	/**
	 * Exit a parse tree produced by {@link HlasmParser#statement2}.
	 * @param ctx the parse tree
	 */
	void exitStatement2(HlasmParser.Statement2Context ctx);
	/**
	 * Enter a parse tree produced by {@link HlasmParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(HlasmParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link HlasmParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(HlasmParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link HlasmParser#macro}.
	 * @param ctx the parse tree
	 */
	void enterMacro(HlasmParser.MacroContext ctx);
	/**
	 * Exit a parse tree produced by {@link HlasmParser#macro}.
	 * @param ctx the parse tree
	 */
	void exitMacro(HlasmParser.MacroContext ctx);
	/**
	 * Enter a parse tree produced by {@link HlasmParser#macro_def_wr}.
	 * @param ctx the parse tree
	 */
	void enterMacro_def_wr(HlasmParser.Macro_def_wrContext ctx);
	/**
	 * Exit a parse tree produced by {@link HlasmParser#macro_def_wr}.
	 * @param ctx the parse tree
	 */
	void exitMacro_def_wr(HlasmParser.Macro_def_wrContext ctx);
	/**
	 * Enter a parse tree produced by {@link HlasmParser#line_wrapper}.
	 * @param ctx the parse tree
	 */
	void enterLine_wrapper(HlasmParser.Line_wrapperContext ctx);
	/**
	 * Exit a parse tree produced by {@link HlasmParser#line_wrapper}.
	 * @param ctx the parse tree
	 */
	void exitLine_wrapper(HlasmParser.Line_wrapperContext ctx);
	/**
	 * Enter a parse tree produced by {@link HlasmParser#line}.
	 * @param ctx the parse tree
	 */
	void enterLine(HlasmParser.LineContext ctx);
	/**
	 * Exit a parse tree produced by {@link HlasmParser#line}.
	 * @param ctx the parse tree
	 */
	void exitLine(HlasmParser.LineContext ctx);
	/**
	 * Enter a parse tree produced by {@link HlasmParser#complex_condition}.
	 * @param ctx the parse tree
	 */
	void enterComplex_condition(HlasmParser.Complex_conditionContext ctx);
	/**
	 * Exit a parse tree produced by {@link HlasmParser#complex_condition}.
	 * @param ctx the parse tree
	 */
	void exitComplex_condition(HlasmParser.Complex_conditionContext ctx);
	/**
	 * Enter a parse tree produced by {@link HlasmParser#condition}.
	 * @param ctx the parse tree
	 */
	void enterCondition(HlasmParser.ConditionContext ctx);
	/**
	 * Exit a parse tree produced by {@link HlasmParser#condition}.
	 * @param ctx the parse tree
	 */
	void exitCondition(HlasmParser.ConditionContext ctx);
	/**
	 * Enter a parse tree produced by {@link HlasmParser#arguments}.
	 * @param ctx the parse tree
	 */
	void enterArguments(HlasmParser.ArgumentsContext ctx);
	/**
	 * Exit a parse tree produced by {@link HlasmParser#arguments}.
	 * @param ctx the parse tree
	 */
	void exitArguments(HlasmParser.ArgumentsContext ctx);
	/**
	 * Enter a parse tree produced by {@link HlasmParser#argument}.
	 * @param ctx the parse tree
	 */
	void enterArgument(HlasmParser.ArgumentContext ctx);
	/**
	 * Exit a parse tree produced by {@link HlasmParser#argument}.
	 * @param ctx the parse tree
	 */
	void exitArgument(HlasmParser.ArgumentContext ctx);
	/**
	 * Enter a parse tree produced by {@link HlasmParser#named_argument}.
	 * @param ctx the parse tree
	 */
	void enterNamed_argument(HlasmParser.Named_argumentContext ctx);
	/**
	 * Exit a parse tree produced by {@link HlasmParser#named_argument}.
	 * @param ctx the parse tree
	 */
	void exitNamed_argument(HlasmParser.Named_argumentContext ctx);
	/**
	 * Enter a parse tree produced by {@link HlasmParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(HlasmParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link HlasmParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(HlasmParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link HlasmParser#simple_expr}.
	 * @param ctx the parse tree
	 */
	void enterSimple_expr(HlasmParser.Simple_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link HlasmParser#simple_expr}.
	 * @param ctx the parse tree
	 */
	void exitSimple_expr(HlasmParser.Simple_exprContext ctx);
}