package com.hlasm_plugin.psi;

import com.intellij.psi.impl.source.tree.LazyParseableElement;
import com.intellij.psi.impl.source.tree.TreeElement;
import com.intellij.psi.tree.IElementType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Created by anisik on 27.06.2016.
 */
public class CommandLazyASTNode extends LazyParseableElement {
    public CommandLazyASTNode(@NotNull IElementType type, @Nullable CharSequence text) {
        super(type, text);
    }


}
