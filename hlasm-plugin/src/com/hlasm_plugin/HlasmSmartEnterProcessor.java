package com.hlasm_plugin;

import com.intellij.codeInsight.editorActions.smartEnter.SmartEnterProcessor;
import com.intellij.lang.ASTNode;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.project.Project;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.impl.source.tree.LeafPsiElement;
import com.intellij.psi.tree.IElementType;
import com.intellij.psi.util.PsiTreeUtil;
import hlasm.HlasmLexer;
import org.antlr.jetbrains.adaptor.lexer.PSIElementTypeFactory;
import org.antlr.jetbrains.adaptor.lexer.TokenIElementType;
import org.jetbrains.annotations.NotNull;

/**
 * Created by anisik on 16.06.2016.
 */
public class HlasmSmartEnterProcessor extends SmartEnterProcessor {
    @Override
    public boolean process(@NotNull Project project, @NotNull Editor editor, @NotNull PsiFile psiFile) {
        PsiElement current = psiFile.findElementAt(editor.getCaretModel().getPrimaryCaret().getOffset());
        if(!psiFile.getLanguage().is(HlasmLanguage.INSTANCE)|| current == null)
            return false;
        PsiElement prev = PsiTreeUtil.prevLeaf(current,true);
        if (prev == null) return false;
        IElementType prevType = prev.getNode().getElementType();
        if ( isUncommited(project)){
            commit(editor);
        }
        if (prevType instanceof TokenIElementType
                && ((TokenIElementType) prevType).getANTLRTokenType() == HlasmLexer.COMMA
                /*&& ((TokenIElementType) current).getANTLRTokenType() == HlasmLexer.ENDLINE*/){

            String text = current.getText();
            int inLineOffset = current.getTextOffset() -
                    editor.getDocument().getLineStartOffset(editor.getDocument().getLineNumber(current.getTextOffset()));
//            System.out.println(inLineOffset + current.getTextLength());
            if (inLineOffset + current.getTextLength() > 73){
                return false;
            }
            if (inLineOffset + current.getTextLength() == 73){
                text = new StringBuilder(text).replace(text.length()-2,text.length()-1,"+")
                        //.insert(text.length() - 1, "                                                                        +".substring(inLineOffset + current.getTextLength()))
                        .append("               \n")
                        .toString();
            }
            else {
                text = new StringBuilder(text)
                        .insert(text.length() - 1, "                                                                        +".substring(inLineOffset + current.getTextLength())
                        ).append("               \n")
                        .toString();
            }

            int startOffset = current.getTextOffset();
            ASTNode newLeaf = HlasmASTFactory.leaf((IElementType) PSIElementTypeFactory.getTokenIElementTypes(HlasmLanguage.INSTANCE).get(HlasmLexer.ARG_SEPARATOR),text);
            ((LeafPsiElement)current).getTreeParent().replaceChild((LeafPsiElement)current,newLeaf);
//            PsiElement par = current.getParent();
//            current.getParent().deleteChildRange(current,current);
//            newLeaf.
//            par.addAfter(newLeaf,par.getLastChild());
//            current.replace(newLeaf);
//            editor.getDocument().replaceString(current.getTextOffset(),current.getTextOffset()+current.getTextLength(),text);
            //EditorActionManager.getInstance().getActionHandler(IdeActions.ACTION_EDITOR_START_NEW_LINE)
            //       .execute(editor,editor.getCaretModel().getPrimaryCaret(),((EditorEx)editor).getDataContext());
//            System.out.println(text.length());
//            editor.getCaretModel().getPrimaryCaret().moveToOffset(startOffset+text.length()-1);
//            commit(editor);
//            reformat(psiFile.findElementAt(editor.getCaretModel().getPrimaryCaret().getOffset()));

            //}, "SmartEnter", null, editor.getDocument());
            return true;
        }

        return false;
    }
}