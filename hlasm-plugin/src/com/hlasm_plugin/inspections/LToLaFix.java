package com.hlasm_plugin.inspections;

import com.hlasm_plugin.HlasmASTFactory;
import com.intellij.codeInsight.FileModificationService;
import com.intellij.codeInsight.intention.impl.BaseIntentionAction;
import com.intellij.codeInspection.LocalQuickFix;
import com.intellij.codeInspection.LocalQuickFixAndIntentionActionOnPsiElement;
import com.intellij.openapi.application.WriteAction;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.project.Project;
import com.intellij.psi.PsiDocumentManager;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.impl.DocumentCommitThread;
import com.intellij.util.IncorrectOperationException;
import org.jetbrains.annotations.Nls;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class LToLaFix extends LocalQuickFixAndIntentionActionOnPsiElement {

    public LToLaFix(@Nullable PsiElement element) {
        super(element);
    }

    @Override
    public void invoke(@NotNull Project project, @NotNull PsiFile file, @Nullable Editor editor, @NotNull PsiElement startElement, @NotNull PsiElement endElement) {
        if (!FileModificationService.getInstance().prepareFileForWrite(startElement.getContainingFile())) return;
        System.out.println("try quickfix");
        WriteAction.run(()->{
//            startElement.replace((PsiElement) HlasmASTFactory.leaf(startElement.getNode().getElementType(),"LA"));
            editor.getDocument().replaceString(startElement.getTextOffset(),startElement.getTextOffset()+startElement.getTextLength(),"LA");
            PsiDocumentManager.getInstance(project).commitDocument(editor.getDocument());
        });
    }

    @NotNull
    @Override
    public String getText() {
        return "Change to la";
    }

    @Nls
    @NotNull
    @Override
    public String getFamilyName() {
        return "Instruction errors";
    }
}
