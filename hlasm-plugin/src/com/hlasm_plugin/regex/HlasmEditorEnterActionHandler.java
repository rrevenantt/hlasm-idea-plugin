package com.hlasm_plugin.regex;

import com.hlasm_plugin.HlasmSmartEnterProcessor;
import com.intellij.openapi.actionSystem.*;
import com.intellij.openapi.editor.Caret;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.editor.LogicalPosition;
import com.intellij.openapi.editor.VisualPosition;
import com.intellij.openapi.editor.actionSystem.EditorActionManager;
import com.intellij.openapi.editor.actionSystem.EditorWriteActionHandler;
import com.intellij.openapi.editor.event.DocumentEvent;
import com.intellij.openapi.editor.event.DocumentListener;
import com.intellij.openapi.editor.ex.util.EditorUtil;
import com.intellij.openapi.editor.impl.DocumentMarkupModel;
import com.intellij.psi.PsiDocumentManager;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import org.jetbrains.annotations.Nullable;

import static com.intellij.openapi.actionSystem.CommonDataKeys.PSI_ELEMENT;

/**
 * Created by anisik on 28.07.2016.
 */
public class HlasmEditorEnterActionHandler extends EditorWriteActionHandler {
    private EditorWriteActionHandler myActionHandler;

    public HlasmEditorEnterActionHandler(EditorWriteActionHandler handler){
        super(true);
        myActionHandler = handler;
    }

    @Override
    public void executeWriteAction(Editor editor, @Nullable Caret caret, DataContext dataContext) {
//        super.executeWriteAction(editor, caret, dataContext);
        PsiFile current =  CommonDataKeys.PSI_FILE.getData(dataContext);
        if (current == null)
            return;
        PsiFile psiFile = PsiDocumentManager.getInstance(CommonDataKeys.PROJECT.getData(dataContext)).getPsiFile(editor.getDocument());

        if(new HlasmSmartEnterProcessor().process(CommonDataKeys.PROJECT.getData(dataContext),
                editor, psiFile) == false){
            //EditorActionManager.getInstance().getActionHandler(IdeActions.).execute(editor,caret,dataContext);
            myActionHandler.execute(editor, caret, dataContext);
            return;
        }
//        VisualPosition pos = caret.getVisualPosition();
//        System.out.println("Smart Enter successful caret " + pos.line + pos.column);
//        PsiDocumentManager.getInstance(psiFile.getProject()).commitDocument(editor.getDocument());
//        PsiDocumentManager.getInstance(psiFile.getProject()).performLaterWhenAllCommitted( new Runnable() {
//            @Override
//            public void run() {
//                PsiElement current = psiFile.findElementAt(editor.getCaretModel().getPrimaryCaret().getOffset());
//                editor.getCaretModel().getPrimaryCaret().moveToOffset(current.getTextOffset()+current.getTextLength()-1);
//            }
//        });

//        PsiDocumentManager.getInstance(psiFile.getProject()).commitDocument(editor.getDocument());

//        System.out.printf("text|" + curr.getText() + "|");
 //        caret.moveToVisualPosition(new VisualPosition(pos.line+1,pos.column));
//        System.out.println("Smart Enter successful caret " + editor.getCaretModel().getLogicalPosition().line + editor.getCaretModel().getLogicalPosition().column);
    }
}
