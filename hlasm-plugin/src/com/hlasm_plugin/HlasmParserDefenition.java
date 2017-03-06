package com.hlasm_plugin;

import com.hlasm_plugin.psi.HlasmIElementTypesFactory;
import com.hlasm_plugin.psi.HlasmPSIFileRoot;
import com.hlasm_plugin.psi.LabelDefLineSubtree;
import com.hlasm_plugin.psi.LabelTokenPSIElement;
import com.intellij.lang.*;
import com.intellij.lexer.Lexer;
import com.intellij.openapi.project.Project;
import com.intellij.psi.*;
import com.intellij.psi.tree.IElementType;
import com.intellij.psi.tree.IFileElementType;
import com.intellij.psi.tree.TokenSet;
import hlasm.HlasmLexer;
import hlasm.HlasmParser;
import org.antlr.jetbrains.adaptor.lexer.ANTLRLexerAdaptor;
import org.antlr.jetbrains.adaptor.lexer.PSIElementTypeFactory;
import org.antlr.jetbrains.adaptor.lexer.RuleIElementType;
import org.antlr.jetbrains.adaptor.lexer.TokenIElementType;
import org.antlr.jetbrains.adaptor.parser.ANTLRParserAdaptor;
import org.antlr.jetbrains.adaptor.psi.ANTLRPsiLeafNode;
import org.antlr.jetbrains.adaptor.psi.ANTLRPsiNode;
import org.antlr.v4.runtime.Parser;
import org.antlr.v4.runtime.tree.ParseTree;
import org.jetbrains.annotations.NotNull;

/**
 * Created by anisik on 01.06.2016.
 */
public class HlasmParserDefenition implements ParserDefinition {
    public static final IFileElementType FILE = new IFileElementType(HlasmLanguage.INSTANCE);
    public static final HlasmParserDefenition INSTANCE = new HlasmParserDefenition();

    static {
        PSIElementTypeFactory.iElementTypesFactory = HlasmIElementTypesFactory.INSTANCE;
        PSIElementTypeFactory.defineLanguageIElementTypes(HlasmLanguage.INSTANCE,
                HlasmParser.tokenNames,
                HlasmParser.ruleNames);
    }

    public static final TokenSet COMMENTS =
            PSIElementTypeFactory.createTokenSet(
                    HlasmLanguage.INSTANCE,
                    HlasmLexer.COMMENT,
                    HlasmLexer.ENDLINE_COMM,
                    HlasmLexer.ARG_SEPARATOR);

    public static final TokenSet WHITESPACE =
            PSIElementTypeFactory.createTokenSet(
                    HlasmLanguage.INSTANCE,
                    HlasmLexer.SPACES1);

    public static final TokenSet STRING =
            PSIElementTypeFactory.createTokenSet(
                    HlasmLanguage.INSTANCE,
                    HlasmLexer.STRING);

    @NotNull
    @Override
    public Lexer createLexer(Project project){
        HlasmLexer lexer = new HlasmLexer(null);
        lexer.prologs.add("RTNBEGIN");
        lexer.prologs.add("PGMBEGIN");
        return new ANTLRLexerAdaptor(HlasmLanguage.INSTANCE,lexer);
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
            System.out.println("weird reparsing "+node.getText());
            //return new ANTLRPsiLeafNode(elType,node.getText());
            System.out.println(node.getText());
            if(((TokenIElementType)node.getElementType()).getANTLRTokenType() == HlasmLexer.LABEL
                    || ((TokenIElementType)node.getElementType()).getANTLRTokenType() == HlasmLexer.LABEL_DEF){
                return new LabelTokenPSIElement(node.getElementType(),node.getText());
            }

            return new ANTLRPsiLeafNode(node.getElementType(),node.getChars());
        }
        if (!(elType instanceof RuleIElementType)){
            System.out.println("weird reparsing "+node.getText());
            return new ANTLRPsiNode(node);
        }

        RuleIElementType ruleIElementType = (RuleIElementType) elType;
//        if (node.getFirstChildNode() != null
//                && node.getFirstChildNode().getElementType() instanceof TokenIElementType
//                && ((TokenIElementType)node.getFirstChildNode().getElementType()).getANTLRTokenType() == HlasmLexer.LABEL_DEF)
//            System.out.println(elType);
        //PsiManager.getInstance().getModificationTracker().
        if ((ruleIElementType.getRuleIndex() == HlasmParser.RULE_line
                || ruleIElementType.getRuleIndex() == HlasmParser.RULE_function_def
                /*|| ruleIElementType.getRuleIndex() == HlasmParser.RULE_macro*/)
                && node.getFirstChildNode() != null
//                && node.getFirstChildNode().getElementType() instanceof TokenIElementType
//                && ((TokenIElementType)node.getFirstChildNode().getElementType()).getANTLRTokenType() == HlasmLexer.LABEL_DEF
                ){
            LabelDefLineSubtree element = new LabelDefLineSubtree(node,(IElementType) PSIElementTypeFactory.getTokenIElementTypes(HlasmLanguage.INSTANCE).get(HlasmLexer.LABEL_DEF));
            if (element.getContainingFile() == null || !(element.getContainingFile() instanceof HlasmPSIFileRoot) ){
                System.out.println("WTF !!!!11111 HlasmParserDefinition.createElement ");
                System.out.println("              " + element.getText());
                return element;
            }
            if ( node.getFirstChildNode().getElementType() instanceof TokenIElementType
                && ((TokenIElementType)node.getFirstChildNode().getElementType()).getANTLRTokenType() == HlasmLexer.LABEL_DEF) {
                System.out.println("label tree saved" + node.getFirstChildNode().getText());
                ((HlasmPSIFileRoot) element.getContainingFile()).definitions.put(node.getFirstChildNode().getText(), element);
            }
            return element;
        }
        /*
        switch (ruleIElementType.getRuleIndex()){
            case HlasmParser.RULE_line:
                return
        }*/
        return new ANTLRPsiNode(node);
    }

    public PsiFile createFile(FileViewProvider viewProvider){
        //viewProvider.getDocument().putUserData(BlockSupport.DO_NOT_REPARSE_INCREMENTALLY,null);
        return new HlasmPSIFileRoot(viewProvider);
    }

    public SpaceRequirements spaceExistanceTypeBetweenTokens(ASTNode left, ASTNode right) {
        if ((left.getElementType() instanceof TokenIElementType
                    && ((TokenIElementType) left.getElementType()).getANTLRTokenType() == HlasmLexer.COMMAND)
                || (right.getElementType() instanceof TokenIElementType
                    && ((TokenIElementType) right.getElementType()).getANTLRTokenType() == HlasmLexer.COMMAND)
                ) {
            return SpaceRequirements.MUST;
        }
        return SpaceRequirements.MAY;
    }

    public PsiParser createParser(final Project project){

        HlasmParser parser = new HlasmParser(null);
        return (new ANTLRParserAdaptor(HlasmLanguage.INSTANCE,parser) {
            @Override
            protected ParseTree parse(Parser parser, IElementType root) {
                if (root instanceof IFileElementType){
                    return ((HlasmParser) parser).lines();
                }
                if (root instanceof RuleIElementType) {
                    switch (((RuleIElementType) root).getRuleIndex()){
                        case HlasmParser.RULE_line_wrapper:
                            System.out.println("line reparsing");
                            return ((HlasmParser) parser).line_wrapper();
                        case HlasmParser.RULE_function_def_wr:
                            System.out.println("fn line reparsing");
                            return ((HlasmParser) parser).function_def_wr();
                        case HlasmParser.RULE_code_chunks:
                            System.out.println("code block reparsing");
                            return ((HlasmParser) parser).code_chunks();
                        default:
                            return ((HlasmParser) parser).line_wrapper();
                    }
                }

                if (root instanceof TokenIElementType){
                    System.out.println("leaf reparsing " + HlasmParser.tokenNames[ ((TokenIElementType) root) .getANTLRTokenType()]);
                    System.out.println("data " + ((HlasmParser) parser).getInputStream().getText());
                    return ((HlasmParser) parser).simple_expr();
                }
                System.out.println(" parsing of "+HlasmParser.ruleNames[((RuleIElementType)root).getRuleIndex()]);
                return ((HlasmParser) parser).line_wrapper() ;
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
