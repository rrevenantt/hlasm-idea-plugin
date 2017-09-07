package com.hlasm_plugin.psi;

import com.hlasm_plugin.HlasmLanguage;
import com.intellij.lang.*;
import com.intellij.openapi.project.Project;
import com.intellij.psi.PsiElement;
import com.intellij.psi.stubs.IStubElementType;
import com.intellij.psi.tree.ILazyParseableElementType;
import com.intellij.psi.tree.ILazyParseableElementTypeBase;
import com.intellij.psi.tree.IReparseableElementType;

import hlasm.HlasmParser;
import org.antlr.jetbrains.adaptor.lexer.PSIElementTypeFactory;
import org.antlr.jetbrains.adaptor.lexer.RuleIElementType;
import org.antlr.jetbrains.adaptor.lexer.TokenIElementType;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Created by anisik on 06.06.2017.
 */
public class StatementIElementType extends ILazyParseableElementType implements RuleIElementType,TokenIElementType,ILazyParseableElementTypeBase {
    RuleIElementType ruleIDcache=null;
    int ruleID;
    public StatementIElementType(@NonNls String debugName, Language language, RuleIElementType ruleID) {
        super(debugName, language);
        this.ruleID = ruleID.getRuleIndex();
    }

    public StatementIElementType(@NonNls String debugName, Language language, int ruleID) {
        super(debugName, language);
        this.ruleID = ruleID;
    }

    @Override
    public ASTNode parseContents(ASTNode chameleon) {
        PsiElement psi = chameleon.getTreeParent().getPsi();
        Project project = psi.getProject();
        Language languageForParser = psi.getLanguage();
        PsiBuilder builder = PsiBuilderFactory.getInstance().createBuilder(project, chameleon, null, languageForParser, chameleon.getChars());
        PsiParser parser = LanguageParserDefinitions.INSTANCE.forLanguage(languageForParser).createParser(project);
        ASTNode node = parser.parse(this, builder);
        return node.getFirstChildNode();
    }

    @Override
    public int getANTLRTokenType() {
        return HlasmParser.OLD_TOKEN;
    }

    @Nullable
    public ASTNode createNode(CharSequence text) {
        return LanguageASTFactory.INSTANCE.forLanguage(this.getLanguage()).createLazy(this, text);
    }


    @Override
    public int getRuleIndex() {
//        if (ruleIDcache == null)
//            ruleIDcache = (RuleIElementType) PSIElementTypeFactory.getRuleIElementTypes(HlasmLanguage.INSTANCE).get(ruleID);
//        return ruleIDcache.getRuleIndex();
        return ruleID;
    }


}
