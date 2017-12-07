package com.hlasm_plugin.psi;

import com.hlasm_plugin.HlasmLanguage;
import com.hlasm_plugin.HlasmParserDefenition;
import com.intellij.lang.Language;
import hlasm.HlasmLexer;
import hlasm.HlasmParser;
import org.antlr.jetbrains.adaptor.lexer.DefaultIElementTypesFactory;
import org.antlr.jetbrains.adaptor.lexer.PSIElementTypeFactory;
import org.antlr.jetbrains.adaptor.lexer.RuleIElementType;
import org.antlr.jetbrains.adaptor.lexer.TokenIElementType;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.List;

/**
 * Created by anisik on 17.10.2016.
 */
public class HlasmIElementTypesFactory extends DefaultIElementTypesFactory {
    public static final HlasmIElementTypesFactory INSTANCE = new HlasmIElementTypesFactory();
//    public HashMap<Integer,Integer> tokenToRuleMap;


    public HlasmIElementTypesFactory() {
//        tokenToRuleMap = new HashMap<>();
//        tokenToRuleMap.put(HlasmLexer.OLD_TOKEN,HlasmParser.RULE_statement);
    }

    @NotNull
    @Override
    public List<TokenIElementType> createTokenIElementTypes(Language language, String[] tokenNames) {
        List<TokenIElementType> iElementTypes = super.createTokenIElementTypes(language, tokenNames);
        if (!language.is(HlasmLanguage.INSTANCE)) return iElementTypes;
        //System.out.println(" " + tokenNames.length + " " + HlasmLexer.LABEL + tokenNames[HlasmLexer.LABEL]);
        iElementTypes.set(HlasmLexer.LABEL,new LabelReparseableIElementType(tokenNames[HlasmLexer.LABEL],language,iElementTypes.get(HlasmLexer.LABEL)));
        iElementTypes.set(HlasmLexer.LABEL_DEF,new LabelReparseableIElementType(tokenNames[HlasmLexer.LABEL_DEF],language,iElementTypes.get(HlasmLexer.LABEL_DEF)));
        iElementTypes.set(HlasmParser.OLD_TOKEN, new StatementIElementType("statement",language,HlasmParser.RULE_statement));
        return iElementTypes;
    }

    @NotNull
    @Override
    public List<RuleIElementType> createRuleIElementTypes(Language language, String[] ruleNames) {
        List<RuleIElementType> iElementTypes = super.createRuleIElementTypes(language, ruleNames);
        if (!language.is(HlasmLanguage.INSTANCE)) return iElementTypes;
        iElementTypes.set(HlasmParser.RULE_line_wrapper,new RuleLazyIElementType(ruleNames[HlasmParser.RULE_line_wrapper],language,iElementTypes.get(HlasmParser.RULE_line_wrapper)));
        iElementTypes.set(HlasmParser.RULE_statement, (RuleIElementType) PSIElementTypeFactory.getTokenIElementTypes(HlasmLanguage.INSTANCE).get(HlasmLexer.OLD_TOKEN));
        iElementTypes.set(HlasmParser.RULE_macro_def_wr,new RuleLazyIElementType(ruleNames[HlasmParser.RULE_macro_def_wr],language,iElementTypes.get(HlasmParser.RULE_macro_def_wr)));
        iElementTypes.set(HlasmParser.RULE_lines,new HlasmStatementsElementType(ruleNames[HlasmParser.RULE_lines],language,iElementTypes.get(HlasmParser.RULE_lines)));
        iElementTypes.set(HlasmParser.RULE_lines2,iElementTypes.get(HlasmParser.RULE_lines));
        iElementTypes.set(HlasmParser.RULE_macro,new HlasmMacroIElementType());
        iElementTypes.set(HlasmParser.RULE_argument,new HlasmMacroArgumentStubType());
//        iElementTypes.set(HlasmParser.RULE_code_chunks,new CodeBlockLazyIElementType(ruleNames[HlasmParser.RULE_code_chunks],language,iElementTypes.get(HlasmParser.RULE_code_chunks)));

        return iElementTypes;
    }
}
