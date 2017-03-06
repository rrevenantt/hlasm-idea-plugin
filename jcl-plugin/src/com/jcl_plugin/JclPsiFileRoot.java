package com.jcl_plugin;

import com.hlasm_plugin.HlasmIcons;
import com.intellij.extapi.psi.PsiFileBase;
import com.intellij.openapi.fileTypes.FileType;
import com.intellij.psi.FileViewProvider;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

/**
 * Created by anisik on 21.07.2016.
 */
public class JclPsiFileRoot extends PsiFileBase {
    public JclPsiFileRoot(@NotNull FileViewProvider viewProvider) {
        super(viewProvider, JclLanguage.INSTANCE);
    }


    @NotNull
    @Override
    public FileType getFileType() {
        return JclFileType.INSTANCE;
    }

    @Nullable
    @Override
    public Icon getIcon(int flags) {
        return HlasmIcons.HLASM;
    }
}
