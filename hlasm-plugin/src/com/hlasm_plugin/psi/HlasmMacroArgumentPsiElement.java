package com.hlasm_plugin.psi;

import com.hlasm_plugin.HlasmLanguage;
import com.hlasm_plugin.lang_model.ArgumentPsiElement;
import com.hlasm_plugin.lang_model.ArgumentType;
import com.hlasm_plugin.stubs.HlasmMacroArgumentStub;
import com.intellij.extapi.psi.StubBasedPsiElementBase;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiNameIdentifierOwner;
import com.intellij.psi.StubBasedPsiElement;
import com.intellij.psi.impl.source.tree.TreeUtil;
import com.intellij.psi.stubs.IStubElementType;
import com.intellij.psi.stubs.StubElement;
import com.intellij.psi.util.PsiTreeUtil;
import com.intellij.util.IncorrectOperationException;
import hlasm.HlasmLexer;
import hlasm.HlasmParser;
import org.antlr.jetbrains.adaptor.lexer.PSIElementTypeFactory;
import org.antlr.jetbrains.adaptor.lexer.TokenIElementType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;

public class HlasmMacroArgumentPsiElement extends StubBasedPsiElementBase<HlasmMacroArgumentStub> implements StubBasedPsiElement<HlasmMacroArgumentStub>,ArgumentPsiElement,PsiNameIdentifierOwner {
    public static final  HlasmMacroArgumentPsiElement[] EMPTYARG = new HlasmMacroArgumentPsiElement[0];
    public HlasmMacroArgumentPsiElement(@NotNull HlasmMacroArgumentStub stub, @NotNull IStubElementType nodeType) {
        super(stub, nodeType);
    }

    public HlasmMacroArgumentPsiElement(@NotNull ASTNode node) {
        super(node);
    }

    @Override
    public Optional<String> getArgumentName() {
        if (getGreenStub() != null)
            return Optional.ofNullable(getGreenStub().name);
//
        if (this.getFirstChild().getNode().getElementType() == PSIElementTypeFactory.getRuleIElementTypes(HlasmLanguage.INSTANCE).get(HlasmParser.RULE_named_argument))
            return Optional.of(TreeUtil.findFirstLeaf(this.getNode()).getText());

        return Optional.empty();
    }

    @Override
    public ArgumentType computeArgumentType() {
        return null;
    }

    @Nullable
    @Override
    public PsiElement getNameIdentifier() {
        //if (PsiTreeUtil.getParentOfType(this, HlasmMacroHeaderPsiElement.class) == null )
        ASTNode name = TreeUtil.findFirstLeaf(this.getNode());
        if (name == null) return null;
        if (((TokenIElementType) name.getElementType()).getANTLRTokenType() != HlasmLexer.LABEL) return null;
        return name.getPsi();
    }

    @Override
    public String getName() {
//        if (getNameIdentifier() == null) return null;
        if (!getArgumentName().isPresent()) return null;
        String temp = getArgumentName().orElse("");//getNameIdentifier().getText();

        return temp.substring(temp.startsWith("&")?1:0);
    }

    @Override
    public PsiElement setName(@NotNull String name) throws IncorrectOperationException {
        throw new IncorrectOperationException();
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" + getNode().getElementType().toString() + ")";
    }}
