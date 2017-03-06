package com.jcl_plugin;

import com.hlasm_plugin.psi.HlasmIElementTypesFactory;
import com.intellij.lang.*;
import com.intellij.lexer.Lexer;
import com.intellij.openapi.project.Project;
import com.intellij.psi.FileViewProvider;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.tree.IElementType;
import com.intellij.psi.tree.IFileElementType;
import com.intellij.psi.tree.TokenSet;
import hlasm.JclLexer;
import hlasm.JclParser;
import org.antlr.jetbrains.adaptor.lexer.ANTLRLexerAdaptor;
import org.antlr.jetbrains.adaptor.lexer.PSIElementTypeFactory;
import org.antlr.jetbrains.adaptor.lexer.RuleIElementType;
import org.antlr.jetbrains.adaptor.lexer.TokenIElementType;
import org.antlr.jetbrains.adaptor.parser.ANTLRParserAdaptor;
import org.antlr.jetbrains.adaptor.psi.ANTLRPsiNode;
import org.antlr.v4.runtime.Parser;
import org.antlr.v4.runtime.tree.ParseTree;
import org.jetbrains.annotations.NotNull;

/**
 * Created by anisik on 21.07.2016.
 */
public class JclParserDefenition implements ParserDefinition {
    public static final IFileElementType FILE = new IFileElementType(JclLanguage.INSTANCE);

    static {
         PSIElementTypeFactory.defineLanguageIElementTypes(JclLanguage.INSTANCE,
                JclParser.tokenNames,
                JclParser.ruleNames);
    }

    public static final TokenSet COMMENTS =
            PSIElementTypeFactory.createTokenSet(
                    JclLanguage.INSTANCE,
                    JclLexer.LINE_COMMENT,
                    JclLexer.ENDLINE1
            );

    public static final TokenSet WHITESPACE =
            PSIElementTypeFactory.createTokenSet(
                    JclLanguage.INSTANCE,
                    JclLexer.SPACES1,
                    JclLexer.ENDLINE,
                    JclLexer.LINE_START1
            );

    public static final TokenSet STRING =
            PSIElementTypeFactory.createTokenSet(
                    JclLanguage.INSTANCE,
                    JclLexer.STRING);

    @NotNull
    @Override
    public Lexer createLexer(Project project){
        JclLexer lexer = new JclLexer(null);
        return new ANTLRLexerAdaptor(JclLanguage.INSTANCE,lexer);
    }

    @Override
    public IFileElementType getFileNodeType() {
        return FILE;
    }

    public PsiElement createElement(ASTNode node){
        IElementType elType = node.getElementType();
        // tokens are leafs and are created in AST factory
        // so this should never be true
        if (elType instanceof TokenIElementType){

            return new ANTLRPsiNode(node);
        }
        if (!(elType instanceof RuleIElementType)){
            System.out.println("weird reparsing "+node.getText());
            return new ANTLRPsiNode(node);
        }
        return new ANTLRPsiNode(node);
    }

    public PsiFile createFile(FileViewProvider viewProvider){
        //viewProvider.getDocument().putUserData(BlockSupport.DO_NOT_REPARSE_INCREMENTALLY,null);
        return new JclPsiFileRoot(viewProvider);
    }

    public SpaceRequirements spaceExistanceTypeBetweenTokens(ASTNode left, ASTNode right) {
        return SpaceRequirements.MAY;
    }

    public PsiParser createParser(final Project project){

        JclParser parser = new JclParser(null);
        return (new ANTLRParserAdaptor(JclLanguage.INSTANCE,parser) {
            @Override
            protected ParseTree parse(Parser parser, IElementType root) {
                if (root instanceof IFileElementType){
                    return ((JclParser) parser).file();
                }
                System.out.println(" parsing of "+JclParser.ruleNames[((RuleIElementType)root).getRuleIndex()]);
                return ((JclParser) parser).line() ;
            }

            @NotNull
            @Override
            public ASTNode parse(IElementType root, PsiBuilder builder) {
                if (root instanceof IFileElementType) {
                    System.out.println("-------Full tree reparse");
                    PsiBuilderFactory a;


                    //builder.
                }
                return super.parse(root, builder);
            }
        });
    }

    @NotNull
    public TokenSet getWhitespaceTokens() {
        return WHITESPACE;
    }

    @NotNull
    public TokenSet getCommentTokens() {
        return COMMENTS;
    }

    @NotNull
    public TokenSet getStringLiteralElements() {
        return STRING;
    }
}
