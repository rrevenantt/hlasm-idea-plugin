package com.hlasm_plugin.psi;

import com.hlasm_plugin.HlasmASTFactory;
import com.hlasm_plugin.project.ZOSProjectService;
import com.hlasm_plugin.stubs.HlasmStubIndex;
import com.intellij.codeInsight.completion.InsertHandler;
import com.intellij.codeInsight.completion.InsertionContext;
import com.intellij.codeInsight.lookup.AutoCompletionPolicy;
import com.intellij.codeInsight.lookup.LookupElement;
import com.intellij.codeInsight.lookup.LookupElementBuilder;
import com.intellij.openapi.module.ModuleServiceManager;
import com.intellij.openapi.module.ModuleUtilCore;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.util.TextRange;
import com.intellij.psi.*;
import com.intellij.psi.impl.source.tree.LeafPsiElement;
import com.intellij.psi.search.GlobalSearchScope;
import com.intellij.psi.stubs.AbstractStubIndex;
import com.intellij.psi.stubs.StubIndex;
import com.intellij.psi.tree.IElementType;
import com.intellij.util.IncorrectOperationException;
import org.antlr.jetbrains.adaptor.psi.ANTLRPsiLeafNode;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.*;

/**
 * Created by anisik on 18.06.2017.
 */
public class MacroCallTokenPsiElement extends ANTLRPsiLeafNode implements PsiNamedElement {
    public MacroCallTokenPsiElement(IElementType type, CharSequence text) {
        super(type, text);
    }

    private PsiReference cacheReference = null;

    @Override
    public PsiReference getReference() {

        List<String> macroDatasets = ModuleServiceManager.getService(ModuleUtilCore.findModuleForPsiElement(this), ZOSProjectService.class).getMacroConcatenation();
        Collection<HlasmMacroPsiElement> macros = HlasmStubIndex.INSTANCE.getSorted(
                getText(), MacroCallTokenPsiElement.this.getProject(),
                GlobalSearchScope.everythingScope(MacroCallTokenPsiElement.this.getProject()),
                (o1, o2) -> {
                    if (o1==o2) return 0;
                    int a1 = macroDatasets.indexOf(o1.getContainingFile().getParent().getName());
                    int a2 = macroDatasets.indexOf(o2.getContainingFile().getParent().getName());

                    return a1<a2?-1:1;
                });
//                GlobalSearchScope.moduleScope(ModuleUtilCore.findModuleForPsiElement(this)));


        if (macros.size() == 0) {
//            System.out.println("only autocompletion reference");
            if (cacheReference != null && cacheReference.getElement().isValid() && cacheReference.getElement().getText().equals(this.getName())){
//            System.out.println("reference cache hit");
                return cacheReference;
            }
            cacheReference =
            /*if (!defaultAutomomplReferenceMap.containsKey(getProject())){
                defaultAutomomplReferenceMap.put(getProject(),*/new PsiReferenceBase<MacroCallTokenPsiElement>(this,new TextRange(0,getTextLength()), true) {
                    @Nullable
                    @Override
                    public PsiElement resolve() {
                        return null;
                    }

                    @NotNull
                    @Override
                    public Object[] getVariants() {

                        return HlasmStubIndex.INSTANCE.getAllKeysAsArray(MacroCallTokenPsiElement.this.getProject());
                    }

            }/*);
            }

            return defaultAutomomplReferenceMap.get(getProject())*/;
            return cacheReference;
        }


        if (macroDatasets!= null  && macroDatasets.size() != 0){
            PsiElement target = macros.iterator().next();
            return new PsiReferenceBase<MacroCallTokenPsiElement>(this,new TextRange(0,getTextLength())) {
                @Nullable
                @Override
                public PsiElement resolve() {
                    return target;
                }

                @NotNull
                @Override
                public Object[] getVariants() {
                    return new Object[0];
                }

                @Override
                public boolean isReferenceTo(PsiElement element) {
                    return element == resolve();
                }
            };
        }

        return new PsiPolyVariantReferenceBase<MacroCallTokenPsiElement>(this) {
            @NotNull
            @Override
            public Object[] getVariants() {
//                return new Object[0];

                return HlasmStubIndex.INSTANCE.getAllKeysAsArray(MacroCallTokenPsiElement.this.getProject());
            }

            @NotNull
//            @Override
            public ResolveResult[] multiResolve(boolean incompleteCode) {
                Collection<HlasmMacroPsiElement> macros = HlasmStubIndex.INSTANCE.get(
                        getText(),MacroCallTokenPsiElement.this.getProject(),
                        GlobalSearchScope.everythingScope(MacroCallTokenPsiElement.this.getProject()));
//                        GlobalSearchScope.moduleScope(ModuleUtilCore.findModuleForPsiElement(MacroCallTokenPsiElement.this)));
                ArrayList<PsiElementResolveResult> resolveResults = new ArrayList<>(macros.size());
                for (HlasmMacroPsiElement element :
                        macros) {
//                    if(macroDatasets == null || macroDatasets.size() == 0)
                        resolveResults.add(new PsiElementResolveResult(element));
//                    else if (macroDatasets.contains(element.getContainingFile().getContainingDirectory().getName())){
//                        resolveResults.add(new PsiElementResolveResult(element));
//                        break;
//                    }
//                    System.out.println("add reference "+element.getGreenStub().name + " file "+element.getContainingFile().getParent());
                }
                return resolveResults.toArray(ResolveResult.EMPTY_ARRAY);
            }

            @Override
            public TextRange getRangeInElement() {
                return new TextRange(0,MacroCallTokenPsiElement.this.getTextLength());
            }

            @Nullable
            @Override
            public PsiElement resolve() {
                return null;
//                ResolveResult[] results = multiResolve(false);
//                return results.length == 0? null : results[0].getElement();
            }

            @Override
            public boolean isReferenceTo(PsiElement element) {
                if (element instanceof PsiNamedElement){
                    return  ((PsiNamedElement) element).getName().equals(getElement().getText());
                }
//                if (element instanceof MacroCallTokenPsiElement && element.getReference() instanceof PsiPolyVariantReference
//                        ) {

//                    ResolveResult[] results = ((PsiPolyVariantReference) element.getReference()).multiResolve(false);
//                    return results.length != 0 && super.isReferenceTo(results[0].getElement());
//                    return element.getText().equals(getElement().getText());
//                }
                return false;
//                return super.isReferenceTo(element);
            }
        };


    }

    @Override
    public PsiElement setName(@NotNull String name) throws IncorrectOperationException {
        return this.replace((LeafPsiElement)HlasmASTFactory.leaf(getElementType(),name));
    }

    @Override
    public String getName() {
        return getText();
    }
}
