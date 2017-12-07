package com.hlasm_plugin;

import com.hlasm_plugin.psi.LabelDefLineSubtree;
import com.intellij.codeInsight.editorActions.BackspaceHandlerDelegate;
import com.intellij.openapi.application.ApplicationManager;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.editor.EditorModificationUtil;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.util.PsiTreeUtil;

import java.util.regex.Pattern;

public class HlasmBackspaceHandler extends BackspaceHandlerDelegate {
    int previousCaretPos;
    @Override
    public void beforeCharDeleted(char c, PsiFile file, Editor editor) {
        if (c == '\n')
            previousCaretPos = editor.getCaretModel().getOffset();
    }

    @Override
    public boolean charDeleted(char c, PsiFile file, Editor editor) {
        if (file.getLanguage() != HlasmLanguage.INSTANCE) return false;

        if (c == ' '
                || (c=='\n' && editor.getCaretModel().getOffset() == previousCaretPos)
                ){
            PsiElement line = PsiTreeUtil.findElementOfClassAtOffset(file,editor.getCaretModel().getOffset(), LabelDefLineSubtree.class,false);
            if (Pattern.matches("\\A *\\n\\z",line.getText())){
//                ApplicationManager.getApplication().runWriteAction(()->line.delete());
                int pos = line.getNode().getStartOffset();
                if (editor.getCaretModel().getOffset() == previousCaretPos) {
                    editor.getSelectionModel().
                            setSelection(pos, pos + line.getTextLength());
                }
                else {
                    editor.getSelectionModel().
                            setSelection(pos, pos + line.getTextLength() - 1);
                }
                EditorModificationUtil.deleteSelectedText(editor);
                editor.getCaretModel().moveToOffset(pos-1);
                return true;
            }
        }

        return false;
    }
}
