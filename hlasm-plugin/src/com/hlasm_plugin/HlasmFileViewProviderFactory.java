package com.hlasm_plugin;

import com.intellij.lang.Language;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.FileViewProvider;
import com.intellij.psi.FileViewProviderFactory;
import com.intellij.psi.PsiManager;
import com.intellij.psi.SingleRootFileViewProvider;
import org.jetbrains.annotations.NotNull;

/**
 * Created by anisik on 09.09.2016.
 */
public class HlasmFileViewProviderFactory implements FileViewProviderFactory {
    @NotNull
    @Override
    public FileViewProvider createFileViewProvider(@NotNull VirtualFile file, Language language, @NotNull PsiManager manager, boolean eventSystemEnabled) {
        assert (language.is(HlasmLanguage.INSTANCE));
        return new SingleRootFileViewProvider(manager,file,eventSystemEnabled,language){
            @NotNull
            @Override
            public CharSequence getContents() {
                return super.getContents().toString().replaceAll("([^\\n]{71})([^ \\n])\\n               ","$1");
            }
        };
    }
}
