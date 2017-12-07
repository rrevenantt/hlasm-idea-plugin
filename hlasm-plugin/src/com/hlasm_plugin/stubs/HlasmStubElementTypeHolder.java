package com.hlasm_plugin.stubs;

import com.hlasm_plugin.HlasmLanguage;
import com.hlasm_plugin.HlasmParserDefenition;
import com.hlasm_plugin.psi.HlasmIFileElementType;
import com.hlasm_plugin.psi.HlasmMacroArgumentStubType;
import com.hlasm_plugin.psi.HlasmMacroIElementType;
import com.intellij.psi.tree.IFileElementType;
import hlasm.HlasmParser;
import org.antlr.jetbrains.adaptor.lexer.PSIElementTypeFactory;

/**
 * Created by anisik on 30.06.2017.
 */
public class HlasmStubElementTypeHolder {
    IFileElementType FILE = HlasmParserDefenition.FILE;
    HlasmMacroIElementType MACRO = (HlasmMacroIElementType) PSIElementTypeFactory.getRuleIElementTypes(HlasmLanguage.INSTANCE).get(HlasmParser.RULE_macro);
    HlasmMacroArgumentStubType ARG = (HlasmMacroArgumentStubType) PSIElementTypeFactory.getRuleIElementTypes(HlasmLanguage.INSTANCE).get(HlasmParser.RULE_argument);

}
