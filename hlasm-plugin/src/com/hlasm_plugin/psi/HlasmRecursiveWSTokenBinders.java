package com.hlasm_plugin.psi;

import com.intellij.lang.WhitespacesAndCommentsBinder;
import com.intellij.psi.tree.IElementType;
import com.intellij.psi.tree.TokenSet;
import org.jetbrains.annotations.NotNull;

import java.util.List;

/**
 * Created by anisik on 09.11.2016.
 */
public class HlasmRecursiveWSTokenBinders {

    public static WhitespacesAndCommentsBinder leadingCommentsBinder(@NotNull final TokenSet commentTypes) {
        return new RecursiveWSBinder() {
            @Override
            public int getEdgePosition(List<IElementType> tokens, boolean atStreamEdge, TokenTextGetter getter) {
                int i = 0;
                while (i < tokens.size() && !commentTypes.contains(tokens.get(i))) {
                    i++;
                }
                return i;
            }
        };
    }

    public static WhitespacesAndCommentsBinder trailingCommentsBinder(@NotNull final TokenSet commentTypes) {
        return new RecursiveWSBinder() {
            @Override
            public int getEdgePosition(List<IElementType> tokens, boolean atStreamEdge, TokenTextGetter getter) {
                int i = tokens.size() - 1;
                while (i >= 0 && !commentTypes.contains(tokens.get(i))) {
                    i--;
                }
                return i + 1;
            }
        };
    }
    public static abstract class RecursiveWSBinder implements WhitespacesAndCommentsBinder//x   ,WhitespacesAndCommentsBinder.RecursiveBinder
    {

    }
}
