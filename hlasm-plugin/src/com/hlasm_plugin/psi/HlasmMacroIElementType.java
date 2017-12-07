package com.hlasm_plugin.psi;

import com.hlasm_plugin.HlasmLanguage;
import com.hlasm_plugin.stubs.HlasmMacroStubElement;
import com.hlasm_plugin.stubs.HlasmStubIndex;
import com.intellij.lang.ASTNode;
import com.intellij.lang.FileASTNode;
import com.intellij.lang.Language;
import com.intellij.openapi.progress.ProgressIndicatorProvider;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.PsiFile;
import com.intellij.psi.impl.source.tree.TreeUtil;
import com.intellij.psi.stubs.*;
import com.intellij.psi.tree.IElementType;
import com.intellij.util.indexing.IndexingDataKeys;
import hlasm.HlasmLexer;
import hlasm.HlasmParser;
import org.antlr.jetbrains.adaptor.lexer.PSIElementTypeFactory;
import org.antlr.jetbrains.adaptor.lexer.RuleIElementType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.IOException;

/**
 * Created by anisik on 01.07.2017.
 */
public class HlasmMacroIElementType extends IStubElementType<HlasmMacroStubElement,HlasmMacroPsiElement> implements RuleIElementType{
    public HlasmMacroIElementType() {
        super("macro", HlasmLanguage.INSTANCE);
    }

    @Override
    public int getRuleIndex() {
        return HlasmParser.RULE_macro;
    }

    @Override
    public HlasmMacroPsiElement createPsi(@NotNull HlasmMacroStubElement stub) {
        return new HlasmMacroPsiElement(stub,this);
    }

    @NotNull
    @Override
    public HlasmMacroStubElement createStub(@NotNull HlasmMacroPsiElement psi, StubElement parentStub) {
        return new HlasmMacroStubElement(parentStub,psi.getMacroName().getText());
    }

    /**
     * We should create stub only for macros with the same name as containing member
     * This function checks if this condition true
     *
     * @param node to check
     * @return true, if we should create stub for this node
     */
    @Override
    public boolean shouldCreateStub(ASTNode node) {
        try {
            ASTNode parent = node.getTreeParent();
            while (!(parent instanceof FileASTNode)){
                parent = parent.getTreeParent();
            }


            ASTNode macrodef = node.findChildByType((IElementType) PSIElementTypeFactory.getRuleIElementTypes(HlasmLanguage.INSTANCE).get(HlasmParser.RULE_macro_def_wr)).getFirstChildNode();
            macrodef = macrodef.findChildByType((IElementType) PSIElementTypeFactory.getRuleIElementTypes(HlasmLanguage.INSTANCE).get(HlasmParser.RULE_line));
//            System.out.println("macro:"+macrodef.findChildByType((IElementType) PSIElementTypeFactory.getTokenIElementTypes(HlasmLanguage.INSTANCE).get(HlasmLexer.COMMAND)).getText());
//            if (! parent.getPsi().isPhysical() || !parent.getPsi().isValid())
//                return false;


//            System.out.println("file :"+ parent.getPsi().getUserData(IndexingDataKeys.VIRTUAL_FILE).getNameWithoutExtension());
            VirtualFile virtualFile = parent.getPsi().getUserData(IndexingDataKeys.VIRTUAL_FILE);
            virtualFile = virtualFile == null? parent.getPsi().getContainingFile().getVirtualFile() :virtualFile;
            return virtualFile.getNameWithoutExtension().equals(
                    macrodef.findChildByType((IElementType) PSIElementTypeFactory.getTokenIElementTypes(HlasmLanguage.INSTANCE).get(HlasmLexer.COMMAND)).getText());
        }
        catch (Exception e){
            ProgressIndicatorProvider.checkCanceled();
            System.out.println("error in shouldCreateStub " + e.toString());
            return false;
        }
    }

    @Override
    public void serialize(@NotNull HlasmMacroStubElement stub, @NotNull StubOutputStream dataStream) throws IOException {
        dataStream.writeName(stub.name);
    }

    @NotNull
    @Override
    public HlasmMacroStubElement deserialize(@NotNull StubInputStream dataStream, StubElement parentStub) throws IOException {
        return new HlasmMacroStubElement(parentStub, dataStream.readName().getString());
    }

    @NotNull
    @Override
    public String getExternalId() {
        return "hlasm.macro";
    }

    @Override
    public void indexStub(@NotNull HlasmMacroStubElement stub, @NotNull IndexSink sink) {
        System.out.println("saved in index:" + stub.name);
        HlasmStubIndex.INSTANCE.cache = null;
        sink.occurrence(HlasmStubIndex.KEY,stub.name);
    }
}
