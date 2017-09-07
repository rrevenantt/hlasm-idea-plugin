package com.hlasm_plugin.psi;

import com.intellij.lang.ASTNode;
import com.intellij.psi.impl.source.tree.LeafPsiElement;
import org.antlr.jetbrains.adaptor.psi.ANTLRPsiNode;
import org.jetbrains.annotations.NotNull;

/**
 * Created by anisik on 18.06.2017.
 */
public class HlasmArgumentPsiElement extends ANTLRPsiNode {
    public HlasmArgumentPsiElement(@NotNull ASTNode node) {
        super(node);
    }

    public LeafPsiElement getArgumentName(){
        return  null;
    }
}
