package com.hlasm_plugin;

import com.hlasm_plugin.psi.HlasmLinesPsiElement;
import com.hlasm_plugin.psi.LabelDefLineSubtree;
import com.intellij.application.options.editor.CodeFoldingOptionsProvider;
import com.intellij.codeInsight.folding.CodeFoldingManager;
import com.intellij.codeInsight.folding.impl.CodeFoldingManagerImpl;
import com.intellij.lang.ASTNode;
import com.intellij.lang.folding.*;
import com.intellij.openapi.diagnostic.Logger;
import com.intellij.openapi.editor.Document;
import com.intellij.openapi.util.TextRange;
import com.intellij.psi.PsiComment;
import com.intellij.psi.PsiDocumentManager;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.impl.source.tree.LeafPsiElement;
import com.intellij.psi.impl.source.tree.PsiCommentImpl;
import com.intellij.psi.impl.source.tree.TreeElement;
import com.intellij.psi.impl.source.tree.TreeUtil;
import com.intellij.psi.util.PsiTreeUtil;
import hlasm.HlasmLexer;
import hlasm.HlasmParser;
import org.antlr.jetbrains.adaptor.lexer.RuleIElementType;
import org.antlr.jetbrains.adaptor.lexer.TokenIElementType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.junit.Rule;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static com.intellij.psi.util.PsiTreeUtil.findChildOfType;

/**
 * Created by anisik on 31.05.2017.
 */
public class HlasmFoldingBuilder extends FoldingBuilderEx {
    @Nullable
    @Override
    public String getPlaceholderText(@NotNull ASTNode node) {
        return "...\n";
    }

    @Nullable
    @Override
    public String getPlaceholderText(@NotNull ASTNode node, @NotNull TextRange range) {
//        return super.getPlaceholderText(node, range);
        return getPlaceholderText(node);
    }

    @NotNull
    @Override
    public FoldingDescriptor[] buildFoldRegions(@NotNull PsiElement root, @NotNull Document document, boolean quick) {
//        System.out.println("buildFolding for " + root.getContainingFile().getVirtualFile().getName() + " " + quick);
        if (quick) return new FoldingDescriptor[0];
        ArrayList<FoldingDescriptor> foldingDescriptors = new ArrayList<>(50);

        root.getFirstChild().acceptChildren(new PsiElementVisitor() {
            TextRange currentFold = null;
            TextRange currentFoldComm = null;
            int currFoldSize = 0;
            int currFoldCommSize = 0;

            @Override
            public void visitElement(PsiElement element) {
                try {
                    if (PsiTreeUtil.getDeepestFirst(element).getNode().getElementType() instanceof TokenIElementType
                            && (((TokenIElementType) ((LeafPsiElement) PsiTreeUtil.getDeepestFirst(element)).getElementType()).getANTLRTokenType()== HlasmLexer.COMMENT
                                || ((TokenIElementType) ((LeafPsiElement) PsiTreeUtil.getDeepestFirst(element)).getElementType()).getANTLRTokenType()== HlasmLexer.ENDLINE)
                            ){
                        if (currentFoldComm == null) {
                            currentFoldComm = element.getTextRange();
                            currFoldCommSize = 0;
                        }
                        else currFoldCommSize += element.getTextLength();
                    }
                    else if (currentFoldComm != null){
                        if (document.getLineNumber(currentFoldComm.getEndOffset()+currFoldCommSize) - document.getLineNumber(currentFoldComm.getStartOffset())>3){
                            foldingDescriptors.add(new NamedFoldingDescriptor(element.getNode().getTreePrev(),currentFoldComm.grown(currFoldCommSize-1),null,"*** ... "));
                        }
                        currentFoldComm = null;
                    }

                    if (((RuleIElementType) element.getFirstChild().getNode().getElementType()).getRuleIndex() == HlasmParser.RULE_macro) {
                        //todo properly fix '-1' workaround
                        TextRange range = PsiTreeUtil.<HlasmLinesPsiElement>findChildOfType(element.getFirstChild(), HlasmLinesPsiElement.class).getTextRange();
                        if (range.getLength() > 10) {
                            foldingDescriptors.add(new FoldingDescriptor(element.getFirstChild(), range.grown(-1)));
                        }
                        return;
                    }
                    if (((RuleIElementType) element.getFirstChild().getNode().getElementType()).getRuleIndex() == HlasmParser.RULE_line_wrapper
                            && ((LabelDefLineSubtree) element.getFirstChild()).getCommand() != null
                            ) {
                        String command = ((LabelDefLineSubtree) element.getFirstChild()).getCommand().getText();
                        if (command.equals("PGMBEGIN") || command.equals("RTNBEGIN")) {
                            currentFold = new TextRange(element.getStartOffsetInParent() + element.getTextLength(),
                                    element.getStartOffsetInParent() + element.getTextLength());
                            currFoldSize = 0;
                            return;
                        }

                        if (currentFold != null
                                && (command.equals("PGMEND") || command.equals("RTNEND"))) {
                            if (currFoldSize > 10) {
                                foldingDescriptors.add(new FoldingDescriptor(root.getFirstChild().getNode(), currentFold.grown(currFoldSize - 1)));

                            }
                            currentFold = null;
                            return;
                        }
                    }
                    if (currentFold != null) {
                        currFoldSize += element.getTextLength();
                    }
                } catch (Throwable e) {
                    Logger.getInstance(this.getClass()).warn(e);
                    System.err.println(e.getMessage());
                    System.err.println(element.getText());
                    return ;
                }
            }

        });
//        foldingDescriptors.add(new FoldingDescriptor());

        return foldingDescriptors.toArray(new FoldingDescriptor[foldingDescriptors.size()]);
    }

    @Override
    public boolean isCollapsedByDefault(@NotNull ASTNode node) {
        if (node.getElementType() instanceof RuleIElementType && ((RuleIElementType) node.getElementType()).getRuleIndex() == HlasmParser.RULE_macro)
            return true;
        return false;
    }
}
