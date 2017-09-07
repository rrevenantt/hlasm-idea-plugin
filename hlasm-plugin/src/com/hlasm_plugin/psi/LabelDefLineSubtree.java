package com.hlasm_plugin.psi;

import com.hlasm_plugin.HlasmASTFactory;
import com.hlasm_plugin.HlasmLanguage;
import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiNameIdentifierOwner;
import com.intellij.psi.PsiWhiteSpace;
import com.intellij.psi.impl.source.tree.LeafPsiElement;
import com.intellij.psi.impl.source.tree.TreeUtil;
import com.intellij.psi.tree.IElementType;
import com.intellij.psi.util.PsiTreeUtil;
import com.intellij.refactoring.Refactoring;
import com.intellij.refactoring.RefactoringFactory;
import hlasm.HlasmLexer;
import hlasm.HlasmParser;
import org.antlr.jetbrains.adaptor.lexer.PSIElementTypeFactory;
import org.antlr.jetbrains.adaptor.lexer.TokenIElementType;
import org.antlr.jetbrains.adaptor.psi.IdentifierDefSubtree;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Created by anisik on 12.06.2016.
 */
public class LabelDefLineSubtree extends IdentifierDefSubtree implements PsiNameIdentifierOwner{
    private String oldName;

    public LabelDefLineSubtree(@NotNull ASTNode node, @NotNull IElementType idElementType) {
        super(node, idElementType);
        oldName = getName();
    }

 /*   @Override
    public String getName(){
        String result = super.getName();
        if (result == null){
            System.out.println("getName error   "+this.getText());
            return this.getText();
        }
        return result;
    }*/

    @Nullable
    @Override
    public PsiElement getNameIdentifier() {
        ASTNode candidate = PsiTreeUtil.getDeepestFirst(this).getNode();
        return (candidate.getElementType() instanceof TokenIElementType &&
                ((TokenIElementType) candidate.getElementType()).getANTLRTokenType() == HlasmLexer.LABEL_DEF)
                ? (LeafPsiElement)candidate
                : null;
    }

    @Override
    public PsiElement setName(String name){
        System.out.println("setName in definition");
        if (getNameIdentifier() == null) return null;

//        super.setName(name);
        ((LeafPsiElement) getNameIdentifier()).replaceWithText(name);

        if (!oldName.equals(name)){
            ((HlasmPSIFileRoot)this.getContainingFile()).definitions.remove(oldName);
            ((HlasmPSIFileRoot)this.getContainingFile()).definitions.put(name,this);
            oldName = name;
        }
        return this;
    }

    @Override
    public void subtreeChanged(){
        String newName = getName();
        if (oldName == null) {
//            this.replace(LanguageParserDefinitions.INSTANCE.forLanguage(HlasmLanguage.INSTANCE).createElement(this.getNode()));
            return;
        }
        if (newName == null) {
            ((HlasmPSIFileRoot)this.getContainingFile()).definitions.remove(oldName);
        }
        if (!oldName.equals(newName)){
            ((HlasmPSIFileRoot)this.getContainingFile()).definitions.remove(oldName);
            ((HlasmPSIFileRoot)this.getContainingFile()).definitions.put(newName,this);
            oldName = newName;
        }
    }

    public LeafPsiElement getCommand(){
//        if (this.getChildren().length < 3)
//            return null;
        try {
            ASTNode lineChild = TreeUtil.findChildBackward(this.getNode(),(IElementType) PSIElementTypeFactory.getRuleIElementTypes(HlasmLanguage.INSTANCE).get(HlasmParser.RULE_line));
            return (LeafPsiElement) lineChild.findChildByType((IElementType) PSIElementTypeFactory.getTokenIElementTypes(HlasmLanguage.INSTANCE).get(HlasmLexer.COMMAND)).getPsi();
            //return (LeafPsiElement) findChildByType((IElementType) PSIElementTypeFactory.getTokenIElementTypes(HlasmLanguage.INSTANCE).get(HlasmLexer.COMMAND));
//            if (getName() != null) {
//                return (LeafPsiElement) this.getChildren()[1];
//            } else {
//                return (LeafPsiElement) this.getChildren()[0];
//            }
        }
        catch (NullPointerException | ClassCastException e){
            return null;
        }
    }
    public PsiElement getArguments(){
        return findChildByType((IElementType) PSIElementTypeFactory.getRuleIElementTypes(HlasmLanguage.INSTANCE).get(HlasmParser.RULE_arguments));
    }
}
