package com.hlasm_plugin.inspections;

import com.intellij.codeInspection.LocalInspectionTool;
import com.intellij.codeInspection.LocalInspectionToolSession;
import com.intellij.codeInspection.ProblemDescriptorBase;
import com.intellij.codeInspection.ProblemsHolder;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.tree.IElementType;
import hlasm.HlasmLexer;
import org.antlr.jetbrains.adaptor.lexer.TokenIElementType;
import org.jetbrains.annotations.Nls;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class HlasmUsingInspectionTool extends LocalInspectionTool {

    @Nls
    @NotNull
    @Override
    public String getDisplayName() {
        return "Inspect usings instructions";
    }

    @NotNull
    @Override
    public PsiElementVisitor buildVisitor(@NotNull ProblemsHolder holder, boolean isOnTheFly, @NotNull LocalInspectionToolSession session) {
        return new PsiElementVisitor(){
            @Override
            public void visitElement(PsiElement element) {
                IElementType type = element.getNode().getElementType();
                if(! (type instanceof TokenIElementType))
                    return;

                if (((TokenIElementType) type).getANTLRTokenType() == HlasmLexer.USING){

                }


            }
        };
    }
}
