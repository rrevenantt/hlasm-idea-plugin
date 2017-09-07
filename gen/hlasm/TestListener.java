// Generated from C:/Users/anisik/IdeaProjects/hlasm-library-antlr/src/hlasm\Test.g4 by ANTLR 4.7
package hlasm;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link TestParser}.
 */
public interface TestListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link TestParser#code}.
	 * @param ctx the parse tree
	 */
	void enterCode(TestParser.CodeContext ctx);
	/**
	 * Exit a parse tree produced by {@link TestParser#code}.
	 * @param ctx the parse tree
	 */
	void exitCode(TestParser.CodeContext ctx);
	/**
	 * Enter a parse tree produced by {@link TestParser#statements}.
	 * @param ctx the parse tree
	 */
	void enterStatements(TestParser.StatementsContext ctx);
	/**
	 * Exit a parse tree produced by {@link TestParser#statements}.
	 * @param ctx the parse tree
	 */
	void exitStatements(TestParser.StatementsContext ctx);
	/**
	 * Enter a parse tree produced by {@link TestParser#command}.
	 * @param ctx the parse tree
	 */
	void enterCommand(TestParser.CommandContext ctx);
	/**
	 * Exit a parse tree produced by {@link TestParser#command}.
	 * @param ctx the parse tree
	 */
	void exitCommand(TestParser.CommandContext ctx);
	/**
	 * Enter a parse tree produced by {@link TestParser#arguments}.
	 * @param ctx the parse tree
	 */
	void enterArguments(TestParser.ArgumentsContext ctx);
	/**
	 * Exit a parse tree produced by {@link TestParser#arguments}.
	 * @param ctx the parse tree
	 */
	void exitArguments(TestParser.ArgumentsContext ctx);
	/**
	 * Enter a parse tree produced by {@link TestParser#arg}.
	 * @param ctx the parse tree
	 */
	void enterArg(TestParser.ArgContext ctx);
	/**
	 * Exit a parse tree produced by {@link TestParser#arg}.
	 * @param ctx the parse tree
	 */
	void exitArg(TestParser.ArgContext ctx);
}