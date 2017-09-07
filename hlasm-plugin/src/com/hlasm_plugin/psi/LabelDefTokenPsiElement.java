package com.hlasm_plugin.psi;

import com.hlasm_plugin.HlasmASTFactory;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiNamedElement;
import com.intellij.psi.impl.source.tree.LeafPsiElement;
import com.intellij.psi.search.GlobalSearchScope;
import com.intellij.psi.search.LocalSearchScope;
import com.intellij.psi.search.SearchScope;
import com.intellij.psi.tree.IElementType;
import com.intellij.util.IncorrectOperationException;
import org.antlr.jetbrains.adaptor.psi.ANTLRPsiLeafNode;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;

/**
 * Created by anisik on 03.07.2017.
 */
public class LabelDefTokenPsiElement extends ANTLRPsiLeafNode implements PsiNamedElement {
    public LabelDefTokenPsiElement(IElementType type, CharSequence text) {
        super(type, text);
    }

    @Override
    public String getName() {
        return getText();
    }

    @Override
    public PsiElement setName(@NonNls @NotNull String name) throws IncorrectOperationException {
        System.out.println("name changed"+this.getName()+ " to " + name);
//        LabelTokenPSIElement newElement = new LabelTokenPSIElement(this.getElementType(),name);
        /*PsiFileFactoryImpl psiFactory = (PsiFileFactoryImpl)PsiFileFactory.getInstance(this.getProject());
        LeafPsiElement newElement;
        if(((TokenIElementType)this.getElementType()).getANTLRTokenType() == HlasmLexer.LABEL_DEF){
            newElement = (LeafPsiElement) PsiTreeUtil.getDeepestFirst(
                    psiFactory.createElementFromText(name + " TEST \n", HlasmLanguage.INSTANCE,
                            (IElementType) PSIElementTypeFactory.getRuleIElementTypes(HlasmLanguage.INSTANCE).get(HlasmParser.RULE_line_wrapper),
                            getParent()));
        }
        else {
             newElement= (LeafPsiElement) PsiTreeUtil.getDeepestLast(
                    psiFactory.createElementFromText(" TEST " + name, HlasmLanguage.INSTANCE,
                            (IElementType) PSIElementTypeFactory.getRuleIElementTypes(HlasmLanguage.INSTANCE).get(HlasmParser.RULE_line_wrapper),
                            getParent()));
        }
//        this.getNode().getTreeParent().replaceChild(this,newElement);

*/


        LeafPsiElement newLeaf = (LeafPsiElement) HlasmASTFactory.leaf(this.getElementType(),name);
//        this.getTreeParent().replaceChild(this.getNode(),newLeaf); //super.replace(newElement);
        this.replaceWithText(name);
        return this;//.replace(newLeaf);
//        return newElement;
    }

    @NotNull
    @Override
    public SearchScope getUseScope() {
        return GlobalSearchScope.fileScope(getContainingFile());
    }

    @NotNull
    @Override
    public GlobalSearchScope getResolveScope() {
        return GlobalSearchScope.fileScope(getContainingFile());
    }

    @Override
    public PsiElement getContext() {
        return super.getContext();
    }
}
