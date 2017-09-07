package com.hlasm_plugin;

import com.hlasm_plugin.psi.LabelDefTokenPsiElement;
import com.intellij.find.findUsages.FindUsagesHandler;
import com.intellij.find.findUsages.FindUsagesHandlerFactory;
import com.intellij.find.findUsages.FindUsagesOptions;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiNamedElement;
import com.intellij.psi.PsiReference;
import com.intellij.psi.impl.search.PsiSearchHelperImpl;
import com.intellij.psi.search.GlobalSearchScope;
import com.intellij.psi.search.GlobalSearchScopeUtil;
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
        return element instanceof PsiNamedElement && element.isValid() && element.getLanguage() == HlasmLanguage.INSTANCE;
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
            return new FindUsagesHandler(element){
                @NotNull
                @Override
                public Collection<PsiReference> findReferencesToHighlight(@NotNull PsiElement target, @NotNull SearchScope searchScope) {
                    return super.findReferencesToHighlight(target, searchScope);
                }

                @NotNull
                @Override
                public FindUsagesOptions getFindUsagesOptions() {
                    FindUsagesOptions options = super.getFindUsagesOptions();

                    if (getPsiElement() instanceof LabelDefTokenPsiElement)
                        options.searchScope = element.getUseScope();
                    return options;
                }
            };
        }
        return null;
    }
}
