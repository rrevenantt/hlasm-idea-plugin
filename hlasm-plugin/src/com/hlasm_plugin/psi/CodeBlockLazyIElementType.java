package com.hlasm_plugin.psi;

import com.hlasm_plugin.regex.HlasmRegexLibrary;
import com.intellij.lang.ASTNode;
import com.intellij.lang.Language;
import com.intellij.lang.LanguageASTFactory;
import com.intellij.openapi.project.Project;
import com.intellij.psi.PsiElement;
import com.intellij.psi.tree.IReparseableElementType;
import org.antlr.jetbrains.adaptor.lexer.RuleIElementType;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Created by anisik on 11.11.2016.
 */
public class CodeBlockLazyIElementType extends IReparseableElementType implements RuleIElementType {
    private RuleIElementType ruleID;

    public CodeBlockLazyIElementType(@NonNls String debugName, Language language, RuleIElementType ruleID) {
        super(debugName, language);
        this.ruleID = ruleID;
    }

    @Override
    public int getRuleIndex() {
        return ruleID.getRuleIndex();
    }

    @Override
    public boolean isParsable(@Nullable ASTNode parent, CharSequence buffer, Language fileLanguage, Project project) {
//        boolean result = HlasmRegexLibrary.match_code_block(buffer);
//         TODO: 11.11.2016 check for first command to be function prolog
//        if (!result) System.out.println("notReparsable|"+buffer+"|");
//        return result;
        return false;
    }

    @Nullable
    @Override
    public ASTNode createNode(CharSequence text) {
        return LanguageASTFactory.INSTANCE.forLanguage(this.getLanguage()).createLazy(this, text);
    }

    @Override
    protected ASTNode doParseContents(@NotNull ASTNode chameleon, @NotNull PsiElement psi) {
        System.out.println("doParseContents " + chameleon.getTextLength());
        return super.doParseContents(chameleon, psi);
    }
}
