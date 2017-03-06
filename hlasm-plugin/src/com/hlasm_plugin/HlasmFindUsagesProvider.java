package com.hlasm_plugin;

import com.hlasm_plugin.psi.HlasmIElementTypesFactory;
import com.hlasm_plugin.psi.HlasmPSIFileRoot;
import com.intellij.lang.cacheBuilder.DefaultWordsScanner;
import com.intellij.lang.cacheBuilder.WordsScanner;
import com.intellij.lang.findUsages.FindUsagesProvider;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiNamedElement;
import com.intellij.psi.tree.TokenSet;
import hlasm.HlasmLexer;
import hlasm.HlasmParser;
import org.antlr.jetbrains.adaptor.lexer.ANTLRLexerAdaptor;
import org.antlr.jetbrains.adaptor.lexer.PSIElementTypeFactory;
import org.antlr.jetbrains.adaptor.lexer.RuleIElementType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Created by anisik on 15.06.2016.
 */
public class HlasmFindUsagesProvider implements FindUsagesProvider {
    static {
        PSIElementTypeFactory.iElementTypesFactory = HlasmIElementTypesFactory.INSTANCE;
        PSIElementTypeFactory.defineLanguageIElementTypes(HlasmLanguage.INSTANCE,
                HlasmParser.tokenNames,
                HlasmParser.ruleNames);
    }

    @Nullable
    @Override
    public WordsScanner getWordsScanner() {
        return new DefaultWordsScanner(new ANTLRLexerAdaptor(HlasmLanguage.INSTANCE,new HlasmLexer(null)),
                PSIElementTypeFactory.createTokenSet(HlasmLanguage.INSTANCE, HlasmLexer.LABEL_DEF,HlasmLexer.LABEL),
                HlasmParserDefenition.COMMENTS,
                TokenSet.EMPTY);
    }

    @Override
    public boolean canFindUsagesFor(@NotNull PsiElement psiElement) {
        return psiElement instanceof PsiNamedElement;
    }

    @Nullable
    @Override
    public String getHelpId(@NotNull PsiElement psiElement) {
        return null;
    }

    @NotNull
    @Override
    public String getType(@NotNull PsiElement element) {
        return "label";
    }

    @NotNull
    @Override
    public String getDescriptiveName(@NotNull PsiElement element) {
        //return getNodeText(element,true);
        return ((PsiNamedElement)element).getName();
    }

    @NotNull
    @Override
    public String getNodeText(@NotNull PsiElement element, boolean useFullName) {
        PsiElement el = element;
        while (!(el instanceof HlasmPSIFileRoot)){
            if (el.getNode().getElementType() instanceof RuleIElementType
                &&((RuleIElementType)el.getNode().getElementType()).getRuleIndex() == HlasmParser.RULE_line){
                return el.getText();
            }
            el = el.getParent();
        }
        return element.getText();
    }
}
