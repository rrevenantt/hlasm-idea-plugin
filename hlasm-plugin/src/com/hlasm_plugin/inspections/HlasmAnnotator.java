package com.hlasm_plugin.inspections;

import com.hlasm_plugin.psi.LabelDefLineSubtree;
import com.intellij.lang.annotation.AnnotationHolder;
import com.intellij.lang.annotation.Annotator;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiRecursiveElementWalkingVisitor;
import org.jetbrains.annotations.NotNull;

/**
 * Created by anisik on 15.12.2016.
 */
public class HlasmAnnotator extends PsiRecursiveElementWalkingVisitor implements Annotator {
    @Override
    public void annotate(@NotNull PsiElement element, @NotNull AnnotationHolder holder) {
//        if (!(((RuleIElementType) element.getNode().getElementType()).getRuleIndex() == HlasmParser.RULE_lines))
//            return;
        
    }

    @Override
    public void visitElement(PsiElement element) {
        if (!(element instanceof LabelDefLineSubtree))
            return;
        super.visitElement(element);
    }
}
