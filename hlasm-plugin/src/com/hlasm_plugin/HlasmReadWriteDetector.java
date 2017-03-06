package com.hlasm_plugin;

import com.intellij.codeInsight.highlighting.ReadWriteAccessDetector;
import com.intellij.openapi.util.Condition;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiReference;
import com.intellij.psi.util.PsiTreeUtil;
import hlasm.HlasmParser;
import org.antlr.jetbrains.adaptor.lexer.RuleIElementType;
import org.jetbrains.annotations.NotNull;

/**
 * Created by anisik on 17.11.2016.
 */
public class HlasmReadWriteDetector extends ReadWriteAccessDetector {

    @NotNull
    @Override
    public Access getExpressionAccess(@NotNull PsiElement expression) {
        return Access.ReadWrite;
    }

    @NotNull
    @Override
    public Access getReferenceAccess(@NotNull PsiElement referencedElement, @NotNull PsiReference reference) {
        PsiElement line = PsiTreeUtil.findFirstParent(reference.getElement(), new Condition<PsiElement>() {
            @Override
            public boolean value(PsiElement psiElement) {
                return (psiElement.getNode().getElementType() instanceof RuleIElementType)
                        &&(((RuleIElementType) psiElement.getNode().getElementType()).getRuleIndex() == HlasmParser.RULE_line);
            }
        });
        //reference.getElement().getNode()
//        HashMap<Integer,Integer> a = new HashMap<>().pu;
        return Access.ReadWrite;
    }

    @Override
    public boolean isDeclarationWriteAccess(@NotNull PsiElement element) {
        return false;
    }

    @Override
    public boolean isReadWriteAccessible(@NotNull PsiElement element) {
        return false;
    }
}

