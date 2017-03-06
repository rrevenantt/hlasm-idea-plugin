package com.hlasm_plugin.psi;

import com.intellij.find.findUsages.CustomUsageSearcher;
import com.intellij.find.findUsages.FindUsagesOptions;
import com.intellij.psi.PsiElement;
import com.intellij.usages.Usage;
import com.intellij.util.Processor;
import org.jetbrains.annotations.NotNull;

/**
 * Created by anisik on 31.10.2016.
 */
public class HlasmUsageSearcher extends CustomUsageSearcher {
    @Override
    public void processElementUsages(@NotNull PsiElement element, @NotNull Processor<Usage> processor, @NotNull FindUsagesOptions options) {
        System.out.println("processElementUsages test");

    }
}
