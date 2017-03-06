package com.hlasm_plugin;

import com.intellij.find.findUsages.FindUsagesHandler;
import com.intellij.find.findUsages.FindUsagesHandlerFactory;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiNamedElement;
import com.intellij.psi.PsiReference;
import com.intellij.psi.impl.search.PsiSearchHelperImpl;
import com.intellij.psi.search.SearchScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Collection;

/**
 * Created by anisik on 08.09.2016.
 */
public class HlasmFindUsagesHandlerFactory extends FindUsagesHandlerFactory {
    @Override
    public boolean canFindUsages(@NotNull PsiElement element) {
//        System.out.printf(element.getText() + (element instanceof PsiNamedElement && element.isValid()));
        return element instanceof PsiNamedElement && element.isValid();
    }

    @Nullable
    @Override
    public FindUsagesHandler createFindUsagesHandler(@NotNull PsiElement element, boolean forHighlightUsages) {
        /*return new FindUsagesHandler(element) {
            @NotNull
            @Override
            public Collection<PsiReference> findReferencesToHighlight(@NotNull PsiElement target, @NotNull SearchScope searchScope) {
//                if (target.getLanguage().is(HlasmLanguage.INSTANCE)){
//                    PsiSearchHelperImpl.processTextOccurrences() target.getContainingFile()
//                }
                return super.findReferencesToHighlight(target, searchScope);
            }
        };*/
        if (canFindUsages(element)) {
            return new FindUsagesHandler(element){};
        }
        return null;
    }
}
