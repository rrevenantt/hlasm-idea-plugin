package com.hlasm_plugin.stubs;

import com.hlasm_plugin.HlasmLanguage;
import com.hlasm_plugin.psi.HlasmMacroIElementType;
import com.hlasm_plugin.psi.HlasmMacroPsiElement;
import com.intellij.psi.stubs.IStubElementType;
import com.intellij.psi.stubs.StubBase;
import com.intellij.psi.stubs.StubElement;
import com.intellij.refactoring.safeDelete.usageInfo.SafeDeleteReferenceUsageInfo;
import hlasm.HlasmParser;
import org.antlr.jetbrains.adaptor.lexer.PSIElementTypeFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by anisik on 18.06.2017.
 */
public class HlasmMacroStubElement extends StubBase<HlasmMacroPsiElement> {
    public HlasmMacroStubElement(StubElement parent,String name) {
        super(parent, (IStubElementType) PSIElementTypeFactory.getRuleIElementTypes(HlasmLanguage.INSTANCE).get(HlasmParser.RULE_macro));
        this.name = name;
    }

//    public List<String> arguments = new ArrayList<>();
//
    public String name = "";

}
