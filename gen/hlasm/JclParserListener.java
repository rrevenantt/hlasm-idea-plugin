// Generated from C:/Users/anisik/IdeaProjects/hlasm-library-antlr/src/hlasm\JclParser.g4 by ANTLR 4.7
package hlasm;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link JclParser}.
 */
public interface JclParserListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link JclParser#file}.
	 * @param ctx the parse tree
	 */
	void enterFile(JclParser.FileContext ctx);
	/**
	 * Exit a parse tree produced by {@link JclParser#file}.
	 * @param ctx the parse tree
	 */
	void exitFile(JclParser.FileContext ctx);
	/**
	 * Enter a parse tree produced by {@link JclParser#line}.
	 * @param ctx the parse tree
	 */
	void enterLine(JclParser.LineContext ctx);
	/**
	 * Exit a parse tree produced by {@link JclParser#line}.
	 * @param ctx the parse tree
	 */
	void exitLine(JclParser.LineContext ctx);
	/**
	 * Enter a parse tree produced by {@link JclParser#command}.
	 * @param ctx the parse tree
	 */
	void enterCommand(JclParser.CommandContext ctx);
	/**
	 * Exit a parse tree produced by {@link JclParser#command}.
	 * @param ctx the parse tree
	 */
	void exitCommand(JclParser.CommandContext ctx);
	/**
	 * Enter a parse tree produced by {@link JclParser#arguments}.
	 * @param ctx the parse tree
	 */
	void enterArguments(JclParser.ArgumentsContext ctx);
	/**
	 * Exit a parse tree produced by {@link JclParser#arguments}.
	 * @param ctx the parse tree
	 */
	void exitArguments(JclParser.ArgumentsContext ctx);
	/**
	 * Enter a parse tree produced by {@link JclParser#argument}.
	 * @param ctx the parse tree
	 */
	void enterArgument(JclParser.ArgumentContext ctx);
	/**
	 * Exit a parse tree produced by {@link JclParser#argument}.
	 * @param ctx the parse tree
	 */
	void exitArgument(JclParser.ArgumentContext ctx);
	/**
	 * Enter a parse tree produced by {@link JclParser#named_argument}.
	 * @param ctx the parse tree
	 */
	void enterNamed_argument(JclParser.Named_argumentContext ctx);
	/**
	 * Exit a parse tree produced by {@link JclParser#named_argument}.
	 * @param ctx the parse tree
	 */
	void exitNamed_argument(JclParser.Named_argumentContext ctx);
	/**
	 * Enter a parse tree produced by {@link JclParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(JclParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link JclParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(JclParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link JclParser#simple_expr}.
	 * @param ctx the parse tree
	 */
	void enterSimple_expr(JclParser.Simple_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link JclParser#simple_expr}.
	 * @param ctx the parse tree
	 */
	void exitSimple_expr(JclParser.Simple_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link JclParser#keyword}.
	 * @param ctx the parse tree
	 */
	void enterKeyword(JclParser.KeywordContext ctx);
	/**
	 * Exit a parse tree produced by {@link JclParser#keyword}.
	 * @param ctx the parse tree
	 */
	void exitKeyword(JclParser.KeywordContext ctx);
}