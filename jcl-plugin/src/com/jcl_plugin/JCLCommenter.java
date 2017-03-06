package com.jcl_plugin;

import com.intellij.codeInsight.generation.CommenterDataHolder;
import com.intellij.codeInsight.generation.IndentedCommenter;
import com.intellij.codeInsight.generation.SelfManagingCommenter;
import com.intellij.openapi.editor.Document;
import com.intellij.openapi.util.TextRange;
import com.intellij.psi.PsiFile;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Created by anisik on 02.08.2016.
 */
public class JCLCommenter implements IndentedCommenter,SelfManagingCommenter<CommenterDataHolder> {
    @Nullable
    @Override
    public String getBlockCommentPrefix() {
        return null;
    }

    @Nullable
    @Override
    public String getBlockCommentSuffix() {
        return null;
    }

    @Nullable
    @Override
    public String getCommentedBlockCommentPrefix() {
        return null;
    }

    @Nullable
    @Override
    public String getCommentedBlockCommentSuffix() {
        return null;
    }

    @Nullable
    @Override
    public String getLineCommentPrefix() {
        return "*";
    }

    @Nullable
    @Override
    public Boolean forceIndentedLineComment() {
        return false;
    }
///////////////////////////////////////////////////////////////////////
    @Nullable
    @Override
    public CommenterDataHolder createLineCommentingState(int startLine, int endLine, @NotNull Document document, @NotNull PsiFile file) {
        return new CommenterDataHolder() {
        };
    }

    @Nullable
    @Override
    public CommenterDataHolder createBlockCommentingState(int selectionStart, int selectionEnd, @NotNull Document document, @NotNull PsiFile file) {
        return null;
    }

    @Override
    public void commentLine(int line, int offset, @NotNull Document document, @NotNull CommenterDataHolder data) {
        int commentStartOffset = document.getLineStartOffset(line)+2;
        if (document.getText().charAt(commentStartOffset)==' '){
            document.replaceString(commentStartOffset,commentStartOffset+1,"*");
            return;
        }
        String lineText = "*" + document.getText(new TextRange(commentStartOffset,document.getLineStartOffset(line+1)));
        int i,j;
        for(i = 1,j = 0; i < lineText.length() && j<3; i++){
            if (lineText.charAt(i)==' ') {
                j++;
                while (i < lineText.length() && lineText.charAt(i) == ' '){
                    i++;
                }
            }
        }
        String newLineText;
        if (j < 3 && i < 72) {
            newLineText = lineText;
        }else {
            newLineText = lineText.substring(0, i - 2) + lineText.substring(i - 1, lineText.length());
        }
        document.replaceString(commentStartOffset,document.getLineStartOffset(line+1),newLineText);
    }

    @Override
    public void uncommentLine(int line, int offset, @NotNull Document document, @NotNull CommenterDataHolder data) {
        int commentStartOffset = document.getLineStartOffset(line)+2;
        if (document.getText().charAt(commentStartOffset+1)==' '){
            document.replaceString(commentStartOffset,commentStartOffset+1," ");
            return;
        }
        String lineText = document.getText(new TextRange(commentStartOffset+1,document.getLineStartOffset(line+1)));
        int i,j;
        for(i = 1,j = 0; i < lineText.length() && j<3; i++){
            if (lineText.charAt(i)==' ') {
                j++;
                while (lineText.charAt(i) == ' '){
                    i++;
                }
            }
        }
        String newLineText = lineText.substring(0,i-1) + " " + lineText.substring(i-1,lineText.length());
        document.replaceString(commentStartOffset,document.getLineStartOffset(line+1),newLineText);
    }

    @Override
    public boolean isLineCommented(int line, int offset, @NotNull Document document, @NotNull CommenterDataHolder data) {
        return document.getText().charAt(document.getLineStartOffset(line)+2)=='*';
    }

    @Nullable
    @Override
    public String getCommentPrefix(int line, @NotNull Document document, @NotNull CommenterDataHolder data) {
        return null;
    }

    @Nullable
    @Override
    public TextRange getBlockCommentRange(int selectionStart, int selectionEnd, @NotNull Document document, @NotNull CommenterDataHolder data) {
        return null;
    }

    @Nullable
    @Override
    public String getBlockCommentPrefix(int selectionStart, @NotNull Document document, @NotNull CommenterDataHolder data) {
        return null;
    }

    @Nullable
    @Override
    public String getBlockCommentSuffix(int selectionEnd, @NotNull Document document, @NotNull CommenterDataHolder data) {
        return null;
    }

    @Override
    public void uncommentBlockComment(int startOffset, int endOffset, Document document, CommenterDataHolder data) {

    }

    @NotNull
    @Override
    public TextRange insertBlockComment(int startOffset, int endOffset, Document document, CommenterDataHolder data) {
        return null;
    }
}
