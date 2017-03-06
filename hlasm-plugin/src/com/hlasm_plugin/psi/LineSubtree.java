package com.hlasm_plugin.psi;

import com.intellij.psi.impl.source.tree.LazyParseablePsiElement;
import com.intellij.psi.tree.IElementType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Created by anisik on 23.10.2016.
 */
public class LineSubtree extends LazyParseablePsiElement {
    public LineSubtree(@NotNull IElementType type, @Nullable CharSequence buffer) {
        super(type, buffer);
    }
}
