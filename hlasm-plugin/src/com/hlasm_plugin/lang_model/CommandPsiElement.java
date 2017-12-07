package com.hlasm_plugin.lang_model;

import com.intellij.psi.PsiElement;

public interface CommandPsiElement extends PsiElement {
    String getCommandString();
    ArgumentPsiElement[] getArguments();
    InstructionFormat getInstructionFormat();
}
