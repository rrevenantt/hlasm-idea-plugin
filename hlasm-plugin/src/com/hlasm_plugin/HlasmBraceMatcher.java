package com.hlasm_plugin;

import com.intellij.lang.BracePair;
import com.intellij.lang.PairedBraceMatcher;
import com.intellij.psi.PsiFile;
import com.intellij.psi.tree.IElementType;
import hlasm.HlasmLexer;
import org.antlr.jetbrains.adaptor.lexer.PSIElementTypeFactory;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Created by anisik on 22.11.2016.
 */
public class HlasmBraceMatcher implements PairedBraceMatcher {
    @Override
    public BracePair[] getPairs() {
        return new BracePair[]{new BracePair((IElementType) PSIElementTypeFactory.getTokenIElementTypes(HlasmLanguage.INSTANCE).get(HlasmLexer.LEFT_ROUND_PAR),
                (IElementType) PSIElementTypeFactory.getTokenIElementTypes(HlasmLanguage.INSTANCE).get(HlasmLexer.RIGHT_ROUND_PAR),
                false)};
    }

    @Override
    public boolean isPairedBracesAllowedBeforeType(@NotNull IElementType lbraceType, @Nullable IElementType contextType) {
        return  PSIElementTypeFactory.createTokenSet(HlasmLanguage.INSTANCE,HlasmLexer.RIGHT_ROUND_PAR,HlasmLexer.COMMENT,HlasmLexer.ENDLINE,HlasmLexer.SPACES1,HlasmLexer.COMMA).contains(contextType);
    }

    @Override
    public int getCodeConstructStart(PsiFile file, int openingBraceOffset) {
        return 0;
    }
}
