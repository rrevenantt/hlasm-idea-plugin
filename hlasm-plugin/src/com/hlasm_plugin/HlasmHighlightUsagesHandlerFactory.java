package com.hlasm_plugin;

import com.intellij.codeInsight.highlighting.HighlightUsagesHandlerBase;
import com.intellij.codeInsight.highlighting.HighlightUsagesHandlerFactory;
import com.intellij.openapi.editor.Editor;
import com.intellij.psi.PsiFile;
import org.jetbrains.annotations.Nullable;

/**
 * Created by anisik on 16.11.2016.
 */
public class HlasmHighlightUsagesHandlerFactory implements HighlightUsagesHandlerFactory {
    @Nullable
    @Override
    public HighlightUsagesHandlerBase createHighlightUsagesHandler(Editor editor, PsiFile file) {
        return null;
    }
}
