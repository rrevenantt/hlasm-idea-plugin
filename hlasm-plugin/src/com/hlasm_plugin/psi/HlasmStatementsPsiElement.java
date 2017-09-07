package com.hlasm_plugin.psi;

import com.intellij.lang.ASTNode;
import org.antlr.jetbrains.adaptor.psi.ANTLRPsiNode;
import org.jetbrains.annotations.NotNull;

/**
 * Created by anisik on 18.06.2017.
 */
public class HlasmStatementsPsiElement extends ANTLRPsiNode {
    public HlasmStatementsPsiElement(@NotNull ASTNode node) {
        super(node);
    }
}
