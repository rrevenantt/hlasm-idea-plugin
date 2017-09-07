// Generated from C:/Users/anisik/IdeaProjects/hlasm-library-antlr/src/hlasm\Test.g4 by ANTLR 4.7
package hlasm;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link TestParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface TestVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link TestParser#code}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCode(TestParser.CodeContext ctx);
	/**
	 * Visit a parse tree produced by {@link TestParser#statements}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatements(TestParser.StatementsContext ctx);
	/**
	 * Visit a parse tree produced by {@link TestParser#command}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCommand(TestParser.CommandContext ctx);
	/**
	 * Visit a parse tree produced by {@link TestParser#arguments}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArguments(TestParser.ArgumentsContext ctx);
	/**
	 * Visit a parse tree produced by {@link TestParser#arg}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArg(TestParser.ArgContext ctx);
}