package com.hlasm_plugin.psi;

import com.intellij.lang.ASTNode;
import org.antlr.jetbrains.adaptor.psi.ANTLRPsiNode;
import org.jetbrains.annotations.NotNull;

/**
 * Created by anisik on 09.06.2017.
 */
public class HlasmMacroHeaderPsiElement extends ANTLRPsiNode {


    public HlasmMacroHeaderPsiElement(@NotNull ASTNode node) {
        super(node);
    }


}
