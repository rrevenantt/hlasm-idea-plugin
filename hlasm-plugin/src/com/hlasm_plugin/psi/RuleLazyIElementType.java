package com.hlasm_plugin.psi;

import com.hlasm_plugin.regex.HlasmRegexLibrary;
import com.intellij.lang.*;
import com.intellij.openapi.project.Project;
import com.intellij.psi.PsiElement;
import com.intellij.psi.tree.IReparseableElementType;
import hlasm.HlasmParser;
import org.antlr.jetbrains.adaptor.lexer.RuleIElementType;
import org.antlr.jetbrains.adaptor.lexer.TokenIElementType;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.regex.Pattern;

/**
 * Created by anisik on 30.06.2016.
 */
public class RuleLazyIElementType extends IReparseableElementType implements RuleIElementType,TokenIElementType{
    private RuleIElementType ruleID;

    public RuleLazyIElementType(@NonNls String debugName, Language language, RuleIElementType ruleID) {
        super(debugName, language);
        this.ruleID = ruleID;
    }

    @Override
    public int getRuleIndex() {
        return ruleID.getRuleIndex();
    }

    @Override
    public boolean isParsable(CharSequence buffer, Language fileLanguage, Project project) {
        return false;//buffer.length() <= 72 || buffer.charAt(72)
//        return HlasmParserDefenition.INSTANCE.createParser(project).parse(this,new PsiBuilderImpl(project,
//                HlasmParserDefenition.INSTANCE,HlasmParserDefenition.INSTANCE.createLexer(project),
//                HlasmASTFactory.composite(this),buffer)).findChildByType(TokenType.ERROR_ELEMENT) == null;
    }


    @Override
    public int getANTLRTokenType() {
        return HlasmParser.OLD_TOKEN;
    }

    @Override
    public boolean isParsable(@Nullable ASTNode parent, CharSequence buffer, Language fileLanguage, Project project) {
//        HlasmLexer lexer = new HlasmLexer(new CharSequenceCharStream(buffer,-1,"temp"));
//        SyntaxErrorListener listener =  new SyntaxErrorListener();
//        CommonTokenStream tokenStream = new CommonTokenStream(lexer);
        long startTime = System.nanoTime();
//        boolean result = HlasmRegexLibrary.match_statement(buffer);
        boolean result = HlasmRegexLibrary.asmline.matcher(buffer).matches() && HlasmRegexLibrary.asm_first_line.matcher(buffer).matches() ;
//        System.out.println("regex time " +(System.nanoTime() - startTime));
        result = result|| HlasmRegexLibrary.comline.matcher(buffer).matches();
        System.out.println("regex time " +(System.nanoTime() - startTime));
        result = result && !HlasmRegexLibrary.macro.matcher(buffer).matches();
//        HlasmParser parser = new HlasmParser(new CommonTokenStream(lexer));
//        parser.addErrorListener(listener);
//        parser.setErrorHandler(new ErrorStrategyAdaptor());
//        parser.line();
//        boolean result = listener.getSyntaxErrors().size() == 0 && lexer._hitEOF;
//        boolean result = HlasmParserDefenition.INSTANCE.createParser(project).parse(this,new PsiBuilderImpl(project,
//                HlasmParserDefenition.INSTANCE,HlasmParserDefenition.INSTANCE.createLexer(project),
//                parent,buffer)).findChildByType(TokenType.ERROR_ELEMENT) == null;
        if (!result)
            System.out.println("notReparsable|"+buffer+"|");
//        System.out.println("Reparsing " + result + "|"+buffer+"|");
        return result;

    }

    @Nullable
    @Override
    public ASTNode createNode(CharSequence text) {
        return LanguageASTFactory.INSTANCE.forLanguage(this.getLanguage()).createLazy(this, text);
    }

    @Override
    protected ASTNode doParseContents(@NotNull ASTNode chameleon, @NotNull PsiElement psi) {
        System.out.println("doParseContents " + chameleon.getTextLength());
        Project project = psi.getProject();
        Language languageForParser = getLanguageForParser(psi);
        PsiBuilder builder = PsiBuilderFactory.getInstance().createBuilder(project, chameleon, null, languageForParser, chameleon.getChars());
        /*builder.putUserDataUnprotected(PsiBuilderImpl.CUSTOM_COMPARATOR, new TripleFunction<ASTNode, LighterASTNode, FlyweightCapableTreeStructure<LighterASTNode>, ThreeState>() {
            @Override
            public ThreeState fun(ASTNode astNode, LighterASTNode lighterASTNode, FlyweightCapableTreeStructure<LighterASTNode> lighterASTNodeFlyweightCapableTreeStructure) {
                LighterASTNode[] children = LighterASTNode.EMPTY_ARRAY;
                Ref<LighterASTNode[]> ref = new Ref<>(children);
                lighterASTNodeFlyweightCapableTreeStructure.getChildren(lighterASTNode,ref);
                if (ref.get().length==0) return ThreeState.UNSURE;
                LighterASTNode firstChild = ref.get()[0];
                if ((astNode.getElementType() instanceof RuleIElementType
                        && (((RuleIElementType) astNode.getElementType()).getRuleIndex() == HlasmParser.RULE_line
                            || ((RuleIElementType) astNode.getElementType()).getRuleIndex() == HlasmParser.RULE_function_def)
                        ) && (lighterASTNode.getTokenType() instanceof RuleIElementType
                         && (((RuleIElementType) lighterASTNode.getTokenType()).getRuleIndex() == HlasmParser.RULE_line
                         || ((RuleIElementType) lighterASTNode.getTokenType()).getRuleIndex() == HlasmParser.RULE_function_def)
                        ) && (astNode.getFirstChildNode().getElementType() instanceof TokenIElementType ) && (firstChild.getTokenType() instanceof TokenIElementType) &&
                        ((TokenIElementType)astNode.getFirstChildNode().getElementType()).getANTLRTokenType() != ((TokenIElementType)firstChild.getTokenType()).getANTLRTokenType())
                    return ThreeState.NO;


                return ThreeState.UNSURE;
            }

        });*/
            PsiParser parser = LanguageParserDefinitions.INSTANCE.forLanguage(languageForParser).createParser(project);
            ASTNode node = parser.parse(this, builder);
            return node.getFirstChildNode();

    }

}
