// Generated from C:/Users/anisik/IdeaProjects/hlasm-library-antlr/src/hlasm\HlasmParser.g4 by ANTLR 4.5.3
package hlasm;

import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link HlasmParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface HlasmParserVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link HlasmParser#lines}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLines(HlasmParser.LinesContext ctx);
	/**
	 * Visit a parse tree produced by {@link HlasmParser#code_chunks}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCode_chunks(HlasmParser.Code_chunksContext ctx);
	/**
	 * Visit a parse tree produced by {@link HlasmParser#macro}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMacro(HlasmParser.MacroContext ctx);
	/**
	 * Visit a parse tree produced by {@link HlasmParser#macro_def_wr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMacro_def_wr(HlasmParser.Macro_def_wrContext ctx);
	/**
	 * Visit a parse tree produced by {@link HlasmParser#function_def_wr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunction_def_wr(HlasmParser.Function_def_wrContext ctx);
	/**
	 * Visit a parse tree produced by {@link HlasmParser#function_def}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunction_def(HlasmParser.Function_defContext ctx);
	/**
	 * Visit a parse tree produced by {@link HlasmParser#line_wrapper}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLine_wrapper(HlasmParser.Line_wrapperContext ctx);
	/**
	 * Visit a parse tree produced by {@link HlasmParser#line}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLine(HlasmParser.LineContext ctx);
	/**
	 * Visit a parse tree produced by {@link HlasmParser#complex_condition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComplex_condition(HlasmParser.Complex_conditionContext ctx);
	/**
	 * Visit a parse tree produced by {@link HlasmParser#condition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCondition(HlasmParser.ConditionContext ctx);
	/**
	 * Visit a parse tree produced by {@link HlasmParser#arguments}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArguments(HlasmParser.ArgumentsContext ctx);
	/**
	 * Visit a parse tree produced by {@link HlasmParser#argument}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArgument(HlasmParser.ArgumentContext ctx);
	/**
	 * Visit a parse tree produced by {@link HlasmParser#named_argument}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNamed_argument(HlasmParser.Named_argumentContext ctx);
	/**
	 * Visit a parse tree produced by {@link HlasmParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(HlasmParser.ExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link HlasmParser#simple_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSimple_expr(HlasmParser.Simple_exprContext ctx);
}