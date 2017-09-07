package com.hlasm_plugin;

import com.intellij.codeInsight.completion.CompletionContributor;
import com.intellij.codeInsight.completion.CompletionInitializationContext;
import org.jetbrains.annotations.NotNull;

/**
 * Created by anisik on 31.10.2016.
 */
public class HlasmCompletionContributor extends CompletionContributor {
    public HlasmCompletionContributor() {
//        extend();
    }

    @Override
    public void duringCompletion(@NotNull CompletionInitializationContext context) {
        super.duringCompletion(context);
    }

    @Override
    public void beforeCompletion(@NotNull CompletionInitializationContext context) {
        super.beforeCompletion(context);
        context.setDummyIdentifier("Z");
    }

}
