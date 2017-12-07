package com.hlasm_plugin.psi;

import com.hlasm_plugin.HlasmLanguage;
import com.hlasm_plugin.lang_model.ArgumentPsiElement;
import com.hlasm_plugin.stubs.HlasmMacroArgumentStub;
import com.intellij.lang.ASTNode;
import com.intellij.lang.Language;
import com.intellij.psi.impl.source.tree.TreeUtil;
import com.intellij.psi.stubs.*;
import com.intellij.psi.tree.IElementType;
import com.intellij.psi.util.PsiTreeUtil;
import com.intellij.util.ArrayUtil;
import com.intellij.util.io.StringRef;
import hlasm.HlasmLexer;
import hlasm.HlasmParser;
import org.antlr.jetbrains.adaptor.lexer.PSIElementTypeFactory;
import org.antlr.jetbrains.adaptor.lexer.RuleIElementType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import sun.reflect.generics.tree.Tree;

import java.io.IOException;

public class HlasmMacroArgumentStubType extends IStubElementType<HlasmMacroArgumentStub,HlasmMacroArgumentPsiElement> implements RuleIElementType{
    public HlasmMacroArgumentStubType() {
        super("argument", HlasmLanguage.INSTANCE);
    }

    @NotNull
    @Override
    public HlasmMacroArgumentStub createStub(@NotNull HlasmMacroArgumentPsiElement psi, StubElement parentStub) {
        if(psi.getArgumentName().isPresent())
            return new HlasmMacroArgumentStub(parentStub,this,-1,psi.getArgumentName().orElse(""));
//
        ArgumentPsiElement[] arguments = PsiTreeUtil.getParentOfType(psi,LabelDefLineSubtree.class)
                .getArguments();
        return new HlasmMacroArgumentStub(parentStub,this, ArrayUtil.indexOf(arguments,psi),"");
//        return new HlasmMacroArgumentStub(parentStub,this,-1,null);
    }

    /**
     *
     * @param stub
     * @return
     */
    @Override
    public HlasmMacroArgumentPsiElement createPsi(@NotNull HlasmMacroArgumentStub stub) {
        return new HlasmMacroArgumentPsiElement(stub,this);
    }

    @Override
    public boolean shouldCreateStub(ASTNode node) {
        ASTNode parent = TreeUtil.findParent(node,(IElementType) PSIElementTypeFactory.getRuleIElementTypes(HlasmLanguage.INSTANCE).get(HlasmParser.RULE_macro_def_wr));
        return parent != null && ((HlasmMacroIElementType) parent.getTreeParent().getElementType()).shouldCreateStub(parent.getTreeParent());
//        return false;
    }

    @NotNull
    @Override
    public String getExternalId() {
        return "hlasm.macro.arg";
    }

    @Override
    public void serialize(@NotNull HlasmMacroArgumentStub stub, @NotNull StubOutputStream dataStream) throws IOException {
        dataStream.writeInt(stub.position);
        dataStream.writeName(stub.name);
    }

    @NotNull
    @Override
    public HlasmMacroArgumentStub deserialize(@NotNull StubInputStream dataStream, StubElement parentStub) throws IOException {
        int pos = dataStream.readInt();
        StringRef name = dataStream.readName();
        return new HlasmMacroArgumentStub(parentStub,this,pos,name == null?null:name.getString());
    }

    @Override
    public void indexStub(@NotNull HlasmMacroArgumentStub stub, @NotNull IndexSink sink) {

    }

    @Override
    public int getRuleIndex() {
        return HlasmParser.RULE_argument;
    }
}
