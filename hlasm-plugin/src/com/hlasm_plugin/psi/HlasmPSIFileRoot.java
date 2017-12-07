package com.hlasm_plugin.psi;

import com.hlasm_plugin.HlasmFileType;
import com.hlasm_plugin.HlasmIcons;
import com.hlasm_plugin.HlasmLanguage;
import com.hlasm_plugin.stubs.HlasmPsiFileStub;
import com.intellij.openapi.util.TextRange;
import com.intellij.psi.stubs.StubTree;
import com.intellij.psi.tree.IStubFileElementType;
import com.map_dump.model.dsect.Dsect;
import com.intellij.extapi.psi.PsiFileBase;
import com.intellij.openapi.fileTypes.FileType;
import com.intellij.psi.FileViewProvider;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiNamedElement;
import org.antlr.jetbrains.adaptor.SymtabUtils;
import org.antlr.jetbrains.adaptor.psi.ScopeNode;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import java.util.*;

/**
 * Created by anisik on 01.06.2016.
 */
public class HlasmPSIFileRoot extends PsiFileBase implements ScopeNode {

    public Map<String,LabelDefLineSubtree> definitions = new HashMap<>();
    public Map<String,PsiElement> macros = new HashMap<>();
    public Map<String,Dsect> dsects= new HashMap<>();
    public List<PsiElement> unmatchedMacro = new LinkedList<>();

    public HlasmPSIFileRoot(FileViewProvider viewProvider){
        super(viewProvider, HlasmLanguage.INSTANCE);
    }

    @Override
    public void onContentReload(){
        definitions.clear();
        super.onContentReload();
    }

    @Override
    public PsiElement getFirstChild() {
        return super.getFirstChild();
    }

    @Override
    public void subtreeChanged() {
        super.subtreeChanged();
    }

    @NotNull
    @Override
    public FileType getFileType(){
        return HlasmFileType.INSTANCE;
    }

    @Override
    public Icon getIcon(int flags){
        return HlasmIcons.HLASM;
    }

    @Override
    public PsiElement getContext(){
        //return getParent();r
        return null;
    }

    @Nullable
    @Override
    public PsiElement resolve(PsiNamedElement element){
        return SymtabUtils.resolve(this,HlasmLanguage.INSTANCE,element,"/line/LABEL");
    }


}
