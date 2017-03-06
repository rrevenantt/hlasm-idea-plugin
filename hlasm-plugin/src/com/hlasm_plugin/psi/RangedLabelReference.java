package com.hlasm_plugin.psi;

import com.intellij.openapi.util.TextRange;
import com.intellij.psi.MultiRangeReference;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiReferenceBase;
import com.intellij.util.IncorrectOperationException;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by anisik on 14.06.2016.
 */
public class RangedLabelReference extends PsiReferenceBase<LabelTokenPSIElement > implements MultiRangeReference{


    public RangedLabelReference(@NotNull LabelTokenPSIElement element) {
        super(element, new TextRange(0,element.getText().length()));
    }

    public RangedLabelReference(LabelTokenPSIElement element, TextRange rangeInElement) {
        super(element, rangeInElement);
    }

    @Nullable
    @Override
    public PsiElement resolve() {
        System.out.println(myElement.getText() + ".resolve()");
        return ((HlasmPSIFileRoot)myElement.getContainingFile()).definitions.get(myElement.getName());
    }

    @Override
    public PsiElement handleElementRename(String newElementName) throws IncorrectOperationException {
        return null;
    }


    @Override
    public boolean isReferenceTo(PsiElement element) {
//        System.out.println(Thread.currentThread().getStackTrace()[12]);
        System.out.println(myElement.getText() + ".isReferenceTo()");
        return element == this.resolve();
    }

    @NotNull
    @Override
    public Object[] getVariants() {
        return new Object[0];
    }

    
    @NotNull
    @Override
    public List<TextRange> getRanges() {
        System.out.println(myElement.getText() + ".getRanges");
        List<TextRange> ranges= new ArrayList<TextRange>();
        if (myElement.getText().contains("\n")){
            ranges.add(new TextRange(0,myElement.getText().indexOf('\n')-1));
            ranges.add(new TextRange(myElement.getText().lastIndexOf(' ')+1,myElement.getTextLength()));
        }
        else {
            ranges.add(getRangeInElement());
        }
        //System.out.println(ranges);
        return ranges;
    }

}
