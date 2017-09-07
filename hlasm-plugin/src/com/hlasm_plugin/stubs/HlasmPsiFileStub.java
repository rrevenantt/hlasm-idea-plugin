package com.hlasm_plugin.stubs;

import com.hlasm_plugin.HlasmParserDefenition;
import com.hlasm_plugin.psi.HlasmPSIFileRoot;
import com.intellij.psi.stubs.IStubElementType;
import com.intellij.psi.stubs.PsiFileStubImpl;
import com.intellij.psi.stubs.StubElement;
import com.intellij.psi.tree.IStubFileElementType;
import org.jetbrains.annotations.NotNull;

import java.util.List;

/**
 * Created by anisik on 18.06.2017.
 */
public class HlasmPsiFileStub extends PsiFileStubImpl<HlasmPSIFileRoot> {
    public HlasmPsiFileStub(HlasmPSIFileRoot file) {
        super(file);
    }

    @NotNull
    @Override
    public IStubFileElementType getType() {
        return (IStubFileElementType) HlasmParserDefenition.FILE;
    }




}
