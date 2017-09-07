package com.hlasm_plugin.psi;

import com.hlasm_plugin.HlasmASTFactory;
import com.hlasm_plugin.HlasmLanguage;
import com.intellij.openapi.util.TextRange;
import com.intellij.psi.*;
import com.intellij.psi.impl.PsiFileFactoryImpl;
import com.intellij.psi.impl.source.tree.LeafElement;
import com.intellij.psi.impl.source.tree.LeafPsiElement;
import com.intellij.psi.impl.source.tree.SharedImplUtil;
import com.intellij.psi.impl.source.tree.TreeUtil;
import com.intellij.psi.search.SearchScope;
import com.intellij.psi.tree.IElementType;
import com.intellij.psi.util.PsiTreeUtil;
import com.intellij.util.IncorrectOperationException;
import hlasm.HlasmLexer;
import hlasm.HlasmParser;
import org.antlr.jetbrains.adaptor.lexer.PSIElementTypeFactory;
import org.antlr.jetbrains.adaptor.lexer.TokenIElementType;
import org.antlr.jetbrains.adaptor.psi.ANTLRPsiLeafNode;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;

/**
 * Created by anisik on 13.06.2016.
 */
public class LabelTokenPSIElement extends LabelDefTokenPsiElement{

    private PsiReference cacheReference;

    public LabelTokenPSIElement(IElementType type, CharSequence text) {
        super(type, text);
    }

    @Override
    public String getName(){
        if (this.getText().charAt(this.getTextLength()-1) == '.')
            return this.getText().substring(0,this.getTextLength()-1);
        if (this.getText().contains("\n")) {
            int cutout = this.getText().indexOf('\n');
            //System.out.println(this.getText().substring(0, cutout - 1) + this.getText().substring(0, cutout + 16));
            return this.getText().substring(0, cutout - 1) + this.getText().substring(cutout + 16);
        }
        return this.getText();
    }

    @Override
    public PsiElement setName(@NotNull String name) throws IncorrectOperationException {
        cacheReference = null;
        return super.setName(name);
    }

    @Override
    public PsiReference getReference(){
//        if (((TokenIElementType) getElementType()).getANTLRTokenType() == HlasmLexer.LABEL_DEF)
//            return null;
        if (cacheReference != null && cacheReference.getElement().isValid() && cacheReference.getElement().getText().equals(this.getName())){
//            System.out.println("reference cache hit");
            return cacheReference;
        }
//        long startTime = System.nanoTime();
        if (((HlasmPSIFileRoot)this.getContainingFile()).definitions.containsKey(this.getText())) {
//            System.out.println("getReference time"+(System.nanoTime() - startTime));
            cacheReference = new LabelReference(this);
            return cacheReference;
        }
//        System.out.println("getReference time"+(System.nanoTime() - startTime));
        if (this.getText().charAt(this.getTextLength()-1) == '.'
                && ((HlasmPSIFileRoot)this.getContainingFile()).definitions.containsKey(this.getName())){
            cacheReference =  new LabelReference(this,new TextRange(0,this.getTextLength()-1));
            return cacheReference;
        }
        if (this.getText().contains("\n")
                && ((HlasmPSIFileRoot)this.getContainingFile()).definitions.containsKey(this.getName())){
            cacheReference = new RangedLabelReference(this);
            return cacheReference;
        }
        return null;
    }

    @NotNull
    @Override
    public SearchScope getUseScope() {
        return super.getUseScope();
    }
}
