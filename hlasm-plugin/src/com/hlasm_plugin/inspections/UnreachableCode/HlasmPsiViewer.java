package com.hlasm_plugin.inspections.UnreachableCode;

import com.intellij.psi.PsiElement;
import hlasm.HlasmParser;
import org.antlr.jetbrains.adaptor.lexer.RuleIElementType;

public abstract class HlasmPsiViewer 
{
    public abstract int PsiViewerEnd(PsiElement element);
    
    private int PsiViewer(PsiElement element, int state)
    {
        if (!(element.getNode().getElementType() instanceof RuleIElementType))
        {
            return PsiViewerEnd(element);
        }
        switch (((RuleIElementType) element.getNode().getElementType()).getRuleIndex()) {
            case HlasmParser.RULE_argument:
                for (PsiElement psiElement : element.getChildren())
                    state = PsiViewer(psiElement, state);
                break;
            case HlasmParser.RULE_arguments:
                for (PsiElement psiElement : element.getChildren())
                    state = PsiViewer(psiElement, state);
                break;
            case HlasmParser.RULE_complex_condition:
                for (PsiElement psiElement : element.getChildren())
                    state = PsiViewer(psiElement, state);
                break;
            case HlasmParser.RULE_condition:
                for (PsiElement psiElement : element.getChildren())
                    state = PsiViewer(psiElement, state);
                break;
            case HlasmParser.RULE_expression:
                for (PsiElement psiElement : element.getChildren())
                    state = PsiViewer(psiElement, state);
                break;
            case HlasmParser.RULE_line:
                for (PsiElement psiElement : element.getChildren())
                    state = PsiViewer(psiElement, state);
                break;
            case HlasmParser.RULE_line_wrapper:
                state = PsiViewer(element, state);
                break;
            case HlasmParser.RULE_lines:
                for (PsiElement psiElement : element.getChildren())
                    state = PsiViewer(psiElement, state);
                break;
            case HlasmParser.RULE_lines2:
                for (PsiElement psiElement : element.getChildren())
                    state = PsiViewer(psiElement, state);
                break;
            case HlasmParser.RULE_macro:
                for (PsiElement psiElement : element.getChildren())
                    state = PsiViewer(psiElement, state);
                break;
            case HlasmParser.RULE_macro_def_wr:
                state = PsiViewer(element, state);
                break;
            case HlasmParser.RULE_named_argument:
                for (PsiElement psiElement : element.getChildren())
                    state = PsiViewer(psiElement, state);
                break;
            case HlasmParser.RULE_simple_expr:
                for (PsiElement psiElement : element.getChildren())
                    state = PsiViewer(psiElement, state);
                break;
            case HlasmParser.RULE_statement:
                state = PsiViewer(element, state);
                break;
            case HlasmParser.RULE_statement2:
                state = PsiViewer(element, state);
                break;
        }
        return state;
    }
    
    public void PsiViewer(PsiElement element) {
        PsiViewer(element, -1);
    }
}
