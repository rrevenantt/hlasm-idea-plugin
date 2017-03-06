// Generated from C:/Users/anisik/IdeaProjects/hlasm-library-antlr/src/hlasm\JclParser.g4 by ANTLR 4.5.3
package hlasm;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link JclParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface JclParserVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link JclParser#file}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFile(JclParser.FileContext ctx);
	/**
	 * Visit a parse tree produced by {@link JclParser#line}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLine(JclParser.LineContext ctx);
	/**
	 * Visit a parse tree produced by {@link JclParser#command}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCommand(JclParser.CommandContext ctx);
	/**
	 * Visit a parse tree produced by {@link JclParser#arguments}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArguments(JclParser.ArgumentsContext ctx);
	/**
	 * Visit a parse tree produced by {@link JclParser#argument}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArgument(JclParser.ArgumentContext ctx);
	/**
	 * Visit a parse tree produced by {@link JclParser#named_argument}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNamed_argument(JclParser.Named_argumentContext ctx);
	/**
	 * Visit a parse tree produced by {@link JclParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(JclParser.ExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link JclParser#simple_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSimple_expr(JclParser.Simple_exprContext ctx);
	/**
	 * Visit a parse tree produced by {@link JclParser#keyword}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitKeyword(JclParser.KeywordContext ctx);
}