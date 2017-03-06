package com.hlasm_plugin.psi;

import com.intellij.lang.Language;
import com.intellij.openapi.project.Project;
import com.intellij.psi.tree.IElementType;
import com.intellij.psi.tree.IReparseableLeafElementType;
import hlasm.HlasmLexer;
import org.antlr.jetbrains.adaptor.lexer.CharSequenceCharStream;
import org.antlr.jetbrains.adaptor.lexer.TokenIElementType;
import org.antlr.v4.runtime.Token;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Created by anisik on 17.10.2016.
 */
public class LabelReparseableIElementType extends IElementType implements TokenIElementType,IReparseableLeafElementType<LabelTokenPSIElement> {
    private TokenIElementType antlrType;

    @Nullable
    @Override
    public LabelTokenPSIElement reparseLeaf(@NotNull LabelTokenPSIElement leaf, @NotNull CharSequence newText) {
        if (isParsable(newText, leaf.getLanguage(), leaf.getProject())) {
            return new LabelTokenPSIElement(leaf.getElementType(), newText);
        }
        return null;
    }

    // test
    public LabelReparseableIElementType(@NonNls String debugName, Language language, TokenIElementType antlrType) {
        super(debugName, language);
        this.antlrType = antlrType;
    }

    @Override
    public int getANTLRTokenType() {
        return antlrType.getANTLRTokenType();
    }

    //@Override
    public boolean isParsable(CharSequence newText, Language fileLanguage, Project project) {
        Token token = new HlasmLexer(new CharSequenceCharStream(newText, newText.length(), "labelReparse")).nextToken();
        System.out.println("reparse " + newText);
        if ((token.getType() == HlasmLexer.LABEL || token.getType() == HlasmLexer.LABEL_DEF)
                && (token.getText().length() == newText.length())) {
            System.out.println("successful reparse " + newText);
            return true;
        }
        return false;
    }
}
