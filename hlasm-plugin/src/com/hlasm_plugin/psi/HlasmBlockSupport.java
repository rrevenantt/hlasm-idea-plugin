package com.hlasm_plugin.psi;

import com.hlasm_plugin.HlasmLanguage;
import com.intellij.extapi.psi.PsiFileBase;
import com.intellij.lang.*;
import com.intellij.openapi.progress.ProgressIndicator;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.util.Couple;
import com.intellij.openapi.util.Ref;
import com.intellij.openapi.util.TextRange;
import com.intellij.psi.PsiFile;
import com.intellij.psi.impl.source.text.BlockSupportImpl;
import com.intellij.psi.impl.source.text.DiffLog;
import com.intellij.psi.impl.source.tree.ASTShallowComparator;
import com.intellij.psi.impl.source.tree.ASTStructure;
import com.intellij.psi.impl.source.tree.TreeElement;
import hlasm.HlasmParser;
import org.antlr.jetbrains.adaptor.lexer.RuleIElementType;
import org.jetbrains.annotations.NotNull;

import java.io.BufferedReader;
import java.io.Reader;
import java.nio.CharBuffer;

/**
 * Created by anisik on 17.09.2016.
 */
public class HlasmBlockSupport extends BlockSupportImpl{
    public HlasmBlockSupport(Project project) {
        super(project);
    }

    @NotNull
    @Override
    public DiffLog reparseRange(@NotNull PsiFile file,
                                @NotNull FileASTNode oldFileNode,
                                @NotNull TextRange changedPsiRange,
                                @NotNull CharSequence newFileText,
                                @NotNull ProgressIndicator indicator,
                                @NotNull CharSequence lastCommittedText) {
        if (! file.getLanguage().is(HlasmLanguage.INSTANCE))
            return super.reparseRange(file, oldFileNode, changedPsiRange, newFileText, indicator, lastCommittedText);

        final PsiFileBase fileBase = (PsiFileBase)file;
        final Couple<ASTNode> reparseableRoots = findReparseableRoots(fileBase, oldFileNode, changedPsiRange, newFileText);
        if (reparseableRoots != null)
            return mergeTrees(fileBase, reparseableRoots.first, reparseableRoots.second, indicator, lastCommittedText);

        System.out.println("testtest");
        int lengthShift = newFileText.length() - oldFileNode.getTextLength();
        ASTNode leftChangedNode =  oldFileNode.findLeafElementAt(Math.max(0,changedPsiRange.getStartOffset()-1));
        leftChangedNode = leftChangedNode.getTreeParent();
        while (((RuleIElementType)leftChangedNode.getElementType()).getRuleIndex() != HlasmParser.RULE_line){
            leftChangedNode = leftChangedNode.getTreeParent();
        }
        ASTNode rightChangedNode =  oldFileNode.findLeafElementAt(Math.min(changedPsiRange.getStartOffset()+1,oldFileNode.getTextLength()));
        rightChangedNode = rightChangedNode.getTreeParent();
        while (((RuleIElementType)rightChangedNode.getElementType()).getRuleIndex() != HlasmParser.RULE_line){
            rightChangedNode = rightChangedNode.getTreeParent();
        }

        Project project = file.getProject();
        Language languageForParser = file.getLanguage();

        PsiBuilder builder = PsiBuilderFactory.getInstance().createBuilder(
                fileBase.getParserDefinition(),fileBase.getParserDefinition().createLexer(project),
                newFileText.subSequence(leftChangedNode.getStartOffset(),rightChangedNode.getStartOffset()+ lengthShift));
        PsiParser parser = LanguageParserDefinitions.INSTANCE.forLanguage(languageForParser).createParser(project);
        ASTNode node = parser.parse(oldFileNode.getElementType(), builder);
        node = node.getFirstChildNode();
        //fileBase.getNode().add
        ASTNode anchorBefore = rightChangedNode.getTreeNext();
        TreeElement changedFile = (TreeElement) fileBase.getNode().copyElement();
        changedFile.removeRange(leftChangedNode,anchorBefore);
        changedFile.addChildren(node.getFirstChildNode(),null,anchorBefore);
        DiffLog diffLog = new DiffLog();
        /*ASTNode nodeToDelete = leftChangedNode;
        while (nodeToDelete != rightChangedNode){
            difflog.nodeDeleted(oldFileNode,nodeToDelete);
            nodeToDelete = nodeToDelete.getTreeNext();
            assert (nodeToDelete == null);
        }
        difflog.nodeDeleted(oldFileNode,rightChangedNode);

        for (ASTNode child: node.getChildren(null)
             ) {
            difflog.nodeInserted(oldFileNode,child,);
        }*/
        final ASTShallowComparator comparator = new ASTShallowComparator(indicator);
        final ASTStructure treeStructure = new ASTStructure(changedFile) {
            @Override
            public int getChildren(@NotNull ASTNode astNode, @NotNull Ref<ASTNode[]> into) {
                indicator.checkCanceled();
                return super.getChildren(astNode, into);
            }
        };
        diffTrees(oldFileNode, diffLog, comparator, treeStructure, indicator, lastCommittedText);
        return diffLog;
    }

}
