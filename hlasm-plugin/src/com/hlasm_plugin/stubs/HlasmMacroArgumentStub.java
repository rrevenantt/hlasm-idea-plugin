package com.hlasm_plugin.stubs;

import com.hlasm_plugin.HlasmLanguage;
import com.hlasm_plugin.psi.HlasmMacroArgumentPsiElement;
import com.intellij.psi.stubs.IStubElementType;
import com.intellij.psi.stubs.StubBase;
import com.intellij.psi.stubs.StubElement;
import hlasm.HlasmParser;
import org.antlr.jetbrains.adaptor.lexer.PSIElementTypeFactory;

public class HlasmMacroArgumentStub extends StubBase<HlasmMacroArgumentPsiElement> {
    public HlasmMacroArgumentStub(StubElement parent,IStubElementType type, int position, String name) {
        super(parent,type);
        this.position = position;
        this.name = name;
    }

    public int position;
    public String name;

}
