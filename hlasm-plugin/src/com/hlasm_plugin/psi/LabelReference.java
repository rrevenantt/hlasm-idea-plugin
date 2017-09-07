package com.hlasm_plugin.psi;

import com.intellij.codeInsight.lookup.LookupElementBuilder;
import com.intellij.openapi.util.TextRange;
import com.intellij.psi.MultiRangeReference;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiManager;
import com.intellij.psi.PsiReferenceBase;
import com.intellij.psi.util.PsiUtil;
import com.intellij.util.IncorrectOperationException;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Thread.currentThread;

/**
 * Created by anisik on 14.06.2016.
 */
public class LabelReference extends PsiReferenceBase<LabelTokenPSIElement >{


    public LabelReference(@NotNull LabelTokenPSIElement element) {
        super(element, new TextRange(0,element.getText().length()));
    }

    public LabelReference(LabelTokenPSIElement element, TextRange rangeInElement) {
        super(element, rangeInElement);
    }

    @Nullable
    @Override
    public PsiElement resolve() {
//        System.out.println(myElement.getText() + ".resolve()");
        return ((HlasmPSIFileRoot)myElement.getContainingFile()).definitions.get(myElement.getName());
    }

    @Override
    public PsiElement handleElementRename(String newElementName) throws IncorrectOperationException {
        PsiElement newElement = myElement.setName(newElementName);
        return newElement;
    }


    @Override
    public boolean isReferenceTo(PsiElement element) {
//        System.out.println(Thread.currentThread().getStackTrace()[1]);
//        System.out.println(myElement.getText() + ".isReferenceTo()");
        return element == this.resolve();
//        return element == ((HlasmPSIFileRoot)myElement.getContainingFile()).definitions.get(myElement.getName());
    }

    @NotNull
    @Override
    public Object[] getVariants() {
//        return new Object[]{"TEST1","TEST2"};
        return new Object[0];
    }

}
