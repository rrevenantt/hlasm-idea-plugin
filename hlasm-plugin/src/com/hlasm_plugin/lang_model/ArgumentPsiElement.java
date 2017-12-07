package com.hlasm_plugin.lang_model;

import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;

public interface ArgumentPsiElement extends PsiElement {


    Optional<String> getArgumentName();

    ArgumentType computeArgumentType();



}
