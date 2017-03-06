package com.hlasm_plugin.psi;

import com.hlasm_plugin.HlasmLanguage;
import com.intellij.lang.Language;
import hlasm.HlasmLexer;
import hlasm.HlasmParser;
import org.antlr.jetbrains.adaptor.lexer.DefaultIElementTypesFactory;
import org.antlr.jetbrains.adaptor.lexer.RuleIElementType;
import org.antlr.jetbrains.adaptor.lexer.TokenIElementType;
import org.jetbrains.annotations.NotNull;

import java.util.List;

/**
 * Created by anisik on 17.10.2016.
 */
public class HlasmIElementTypesFactory extends DefaultIElementTypesFactory {
    public static final HlasmIElementTypesFactory INSTANCE = new HlasmIElementTypesFactory();

    public HlasmIElementTypesFactory() {
    }

    @NotNull
    @Override
    public List<TokenIElementType> createTokenIElementTypes(Language language, String[] tokenNames) {
        List<TokenIElementType> iElementTypes = super.createTokenIElementTypes(language, tokenNames);
        if (!language.is(HlasmLanguage.INSTANCE)) return iElementTypes;
        //System.out.println(" " + tokenNames.length + " " + HlasmLexer.LABEL + tokenNames[HlasmLexer.LABEL]);
        iElementTypes.set(HlasmLexer.LABEL,new LabelReparseableIElementType(tokenNames[HlasmLexer.LABEL],language,iElementTypes.get(HlasmLexer.LABEL)));
        iElementTypes.set(HlasmLexer.LABEL_DEF,new LabelReparseableIElementType(tokenNames[HlasmLexer.LABEL_DEF],language,iElementTypes.get(HlasmLexer.LABEL_DEF)));
        return iElementTypes;
    }

    @NotNull
    @Override
    public List<RuleIElementType> createRuleIElementTypes(Language language, String[] ruleNames) {
        List<RuleIElementType> iElementTypes = super.createRuleIElementTypes(language, ruleNames);
        if (!language.is(HlasmLanguage.INSTANCE)) return iElementTypes;
        iElementTypes.set(HlasmParser.RULE_line_wrapper,new RuleLazyIElementType(ruleNames[HlasmParser.RULE_line_wrapper],language,iElementTypes.get(HlasmParser.RULE_line_wrapper)));
        iElementTypes.set(HlasmParser.RULE_function_def_wr,new RuleLazyIElementType(ruleNames[HlasmParser.RULE_function_def_wr],language,iElementTypes.get(HlasmParser.RULE_function_def_wr)));
        iElementTypes.set(HlasmParser.RULE_code_chunks,new CodeBlockLazyIElementType(ruleNames[HlasmParser.RULE_code_chunks],language,iElementTypes.get(HlasmParser.RULE_code_chunks)));

        return iElementTypes;
    }
}
