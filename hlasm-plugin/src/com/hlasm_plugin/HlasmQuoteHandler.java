package com.hlasm_plugin;

import com.intellij.codeInsight.editorActions.MultiCharQuoteHandler;
import com.intellij.codeInsight.editorActions.SimpleTokenSetQuoteHandler;
import com.intellij.openapi.editor.Document;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.editor.highlighter.HighlighterIterator;
import hlasm.HlasmParser;
import org.jetbrains.annotations.Nullable;

/**
 * Created by anisik on 02.12.2016.
 */
public class HlasmQuoteHandler extends SimpleTokenSetQuoteHandler implements MultiCharQuoteHandler {
    public HlasmQuoteHandler() {super(HlasmParserDefenition.STRING);}

    @Nullable
    @Override
    public CharSequence getClosingQuote(HighlighterIterator iterator, int offset) {
        Document document = iterator.getDocument();
        if (document.getText().charAt(iterator.getStart()) == '\''){
            return "\'";
        }
        return null;
    }

    @Override
    public boolean hasNonClosedLiteral(Editor editor, HighlighterIterator iterator, int offset) {
        //return super.hasNonClosedLiteral(editor, iterator, offset);
        Document document = iterator.getDocument();
        if (document.getText().charAt(iterator.getStart()) == '\'' && document.getText().charAt(iterator.getEnd()) != '\''){
            return true;
        }
        return false;
    }
}
