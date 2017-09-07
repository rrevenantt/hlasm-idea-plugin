package com.hlasm_plugin.psi;

import com.hlasm_plugin.HlasmLanguage;
import com.hlasm_plugin.stubs.HlasmMacroStubElement;
import com.intellij.extapi.psi.StubBasedPsiElementBase;
import com.intellij.lang.ASTNode;
import com.intellij.lang.Language;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiNameIdentifierOwner;
import com.intellij.psi.PsiNamedElement;
import com.intellij.psi.StubBasedPsiElement;
import com.intellij.psi.impl.source.tree.LeafPsiElement;
import com.intellij.psi.stubs.IStubElementType;
import com.intellij.psi.util.PsiTreeUtil;
import com.intellij.util.IncorrectOperationException;
import org.antlr.jetbrains.adaptor.SymtabUtils;
import org.antlr.jetbrains.adaptor.psi.ANTLRPsiNode;
import org.antlr.jetbrains.adaptor.psi.ScopeNode;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Created by anisik on 18.06.2017.
 */
public class HlasmMacroPsiElement extends StubBasedPsiElementBase<HlasmMacroStubElement> implements PsiNameIdentifierOwner,StubBasedPsiElement<HlasmMacroStubElement>{
    public HlasmMacroPsiElement(@NotNull ASTNode node) {
        super(node);
    }

    public HlasmMacroPsiElement(@NotNull HlasmMacroStubElement stub, @NotNull IStubElementType nodeType) {
        super(stub, nodeType);
    }

    public LeafPsiElement getMacroName(){
        return PsiTreeUtil.findChildOfType(this,MacroCallTokenPsiElement.class);
    }

    @NotNull
    @Override
    public Language getLanguage() {
        return HlasmLanguage.INSTANCE;
    }

    @Nullable
    @Override
    public PsiElement getNameIdentifier() {
        return getMacroName();
    }

    @Override
    public String getName() {
        return getGreenStub() != null ? getGreenStub().name : getNameIdentifier().getText();
    }

    @Override
    public PsiElement setName(@NotNull String name) throws IncorrectOperationException {
        throw new IncorrectOperationException();
    }

}
