package com.hlasm_plugin.psi;

import com.hlasm_plugin.HlasmLanguage;
import com.hlasm_plugin.HlasmParserDefenition;
import com.hlasm_plugin.regex.HlasmRegexLibrary;
import com.intellij.lang.*;
import com.intellij.lang.impl.PsiBuilderImpl;
import com.intellij.lexer.LexerBase;
import com.intellij.openapi.diagnostic.Logger;
import com.intellij.openapi.progress.ProcessCanceledException;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.util.Pair;
import com.intellij.openapi.util.TextRange;
import com.intellij.openapi.util.text.StringUtil;
import com.intellij.psi.PsiElement;
import com.intellij.psi.TokenType;
import com.intellij.psi.impl.source.DummyHolder;
import com.intellij.psi.impl.source.PsiFileImpl;
import com.intellij.psi.impl.source.tree.*;
import com.intellij.psi.text.BlockSupport;
import com.intellij.psi.tree.IElementType;
import com.intellij.psi.tree.IFileElementType;

import com.intellij.psi.tree.IReparseableElementType;
import com.intellij.psi.tree.TokenSet;
import com.intellij.psi.util.PsiTreeUtil;
import com.intellij.psi.util.PsiUtil;
import com.intellij.util.ThreeState;
import com.intellij.util.TripleFunction;
import com.intellij.util.diff.FlyweightCapableTreeStructure;
import hlasm.HlasmLexer;
import hlasm.HlasmParser;
import org.antlr.jetbrains.adaptor.lexer.ANTLRLexerAdaptor;
import org.antlr.jetbrains.adaptor.lexer.PSIElementTypeFactory;
import org.antlr.jetbrains.adaptor.lexer.RuleIElementType;
import org.antlr.jetbrains.adaptor.lexer.TokenIElementType;
import org.antlr.jetbrains.adaptor.parser.ANTLRParserAdaptor;
import org.codehaus.groovy.transform.sc.transformers.RangeExpressionTransformer;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import sun.reflect.generics.tree.Tree;

/**
 * Created by anisik on 25.04.2017.
 */
public class HlasmStatementsElementType extends IReparseableElementType implements RuleIElementType {
    RuleIElementType ruleID;

    public HlasmStatementsElementType(@NonNls String debugName, Language language, RuleIElementType ruleID) {
        super(debugName, language);
        this.ruleID = ruleID;
    }

    @Override
    public boolean isParsable(@Nullable ASTNode parent, CharSequence buffer, Language fileLanguage, Project project) {
        return parent instanceof FileASTNode || !HlasmRegexLibrary.macro.matcher(buffer).matches();
//        return true;
    }

    @Nullable
    @Override
    public ASTNode createNode(CharSequence text) {
        return LanguageASTFactory.INSTANCE.forLanguage(this.getLanguage()).createLazy(this, text);
    }

    @Override
    public int getRuleIndex() {
        return ruleID.getRuleIndex();
    }

    //@Override
    protected ASTNode doParseContents1(@NotNull ASTNode chameleon, @NotNull PsiElement psi) {
        if (chameleon.getUserData(BlockSupport.TREE_TO_BE_REPARSED) == null
                || psi.getContainingFile() instanceof DummyHolder) {
            System.out.println("no old data to be reparsed");
            return super.doParseContents(chameleon, psi);
        }

        ASTNode oldRoot = Pair.getFirst(chameleon.getUserData(BlockSupport.TREE_TO_BE_REPARSED));
        CharSequence oldText = Pair.getSecond(chameleon.getUserData(BlockSupport.TREE_TO_BE_REPARSED));
        CharSequence newText = chameleon.getChars();

        Project project = psi.getProject();
        Language languageForParser = getLanguageForParser(psi);
        PsiBuilder builder = PsiBuilderFactory.getInstance().createBuilder(project, chameleon, null, languageForParser, newText);
//        builder.putUserData(BlockSupportImpl.TREE_TO_BE_REPARSED,chameleon.getUserData(BlockSupportImpl.TREE_TO_BE_REPARSED));
        ANTLRParserAdaptor parser = (ANTLRParserAdaptor) LanguageParserDefinitions.INSTANCE.forLanguage(languageForParser).createParser(project);
        parser.oldTree = oldRoot;
        parser.newText = newText;
        parser.oldText = oldText;

        ASTNode node = parser.parse(this, builder);
        return node.getFirstChildNode();

    }

    @Override
    protected ASTNode doParseContents(@NotNull ASTNode chameleon, @NotNull PsiElement psi) {

        if (chameleon.getUserData(BlockSupport.TREE_TO_BE_REPARSED) == null
            //|| psi.getContainingFile() instanceof DummyHolder
                ) {
            System.out.println("no old data to be reparsed");
            return super.doParseContents(chameleon, psi);
        }

        try {
            TreeElement oldRoot = (TreeElement) Pair.getFirst(chameleon.getUserData(BlockSupport.TREE_TO_BE_REPARSED));
            CharSequence oldFullText = Pair.getSecond(chameleon.getUserData(BlockSupport.TREE_TO_BE_REPARSED));
            CharSequence oldText = oldRoot.getChars();
            CharSequence newText = chameleon.getChars();


            PsiFileImpl psiFile = (PsiFileImpl) psi;
            //   PsiFileImpl psiCopy = (PsiFileImpl) ((PsiFile) psi).getViewProvider().clone().getPsi(HlasmLanguage.INSTANCE);
//        psiFile.copy()
//        psiFile.getOriginalFile();
//            long startTime = System.nanoTime();

//            System.out.println("copy time " + (System.nanoTime() - startTime));
//
//        TextRange changedRange = DocumentCommitThread.getChangedPsiRange(psi.getContainingFile(), (FileElement) oldRoot, newText);
//         = DocumentCommitThread.getChangedPsiRange(psi.getContainingFile(), (FileElement) oldRoot, newText);
            int commonPrefixLength = StringUtil.commonPrefixLength(oldText, newText);
//        if (commonPrefixLength == newText.length() && newText.length() == oldText.length()) {
//            return null;
//        }

            int commonSuffixLength = Math.min(StringUtil.commonSuffixLength(oldText, newText), oldText.length() - commonPrefixLength);
//        TextRange changedRange = new TextRange(commonPrefixLength, Math.max(oldText.length() - commonSuffixLength,oldText.length()-newText.length()));
            TextRange changedRange = new TextRange(commonPrefixLength,
                    Math.max(oldText.length() - commonSuffixLength, commonPrefixLength + Math.max(0, oldText.length() - newText.length())));

            System.out.println("changed start:" + changedRange.getStartOffset() + ",end:" + changedRange.getEndOffset() + ",length:" + changedRange.getLength());
//        changedRange = new TextRange(Math.max(changedRange.getStartOffset() - 1,0), Math.min(changedRange.getEndOffset()+1, oldText.length()));

//        ASTNode aaa = psiFile.getNode().findLeafElementAt()
//        TokenSet toFind = TokenSet.create(((IElementType) PSIElementTypeFactory.getRuleIElementTypes(HlasmLanguage.INSTANCE).get(HlasmParser.RULE_statement)),
//                TokenType.ERROR_ELEMENT);
//        if (oldRoot.findLeafElementAt(changedRange.getEndOffset()) == null)
//            return super.doParseContents(chameleon, psi);
//        ASTNode beginChild = TreeUtil.findParent(oldRoot.findLeafElementAt(changedRange.getStartOffset()),
//                toFind);
//        ASTNode endChild = TreeUtil.findParent(oldRoot.findLeafElementAt(changedRange.getEndOffset()),
//                toFind);
            TreeElement beginChild = findChildAtOffset(oldRoot, changedRange.getStartOffset());
            TreeElement endChild = findChildAtOffset(oldRoot, changedRange.getEndOffset());
            if (beginChild == null || endChild == null) {
                System.out.println("lul again full reparse?");
                return super.doParseContents(chameleon, psi);
            }
            try {


                if (beginChild.getFirstChildNode() == null || !(beginChild.getFirstChildNode().getElementType() instanceof RuleIElementType)
                        || !(((RuleIElementType) beginChild.getFirstChildNode().getElementType()).getRuleIndex() == HlasmParser.RULE_macro && beginChild == endChild)) {

                    //find next successfully parsed function
//        if (((RuleIElementType) endChild.getFirstChildNode().getElementType()).getRuleIndex() != HlasmParser.RULE_function_def_wr
//                && endChild.getTreeNext() != null){
                    if (beginChild.getTreePrev() != null)
                        beginChild = beginChild.getTreePrev();
                    if (endChild.getTreeNext() != null)
                        endChild = endChild.getTreeNext();


//            while (beginChild != null
//                    && (beginChild.getFirstChildNode() == null || !(beginChild.getFirstChildNode().getElementType() instanceof RuleIElementType))
//                    ){
//                beginChild = beginChild.getTreePrev();
//            }
//            while (endChild != null
//                    && (endChild.getFirstChildNode() == null || !(endChild.getFirstChildNode().getElementType() instanceof RuleIElementType))
//                    ){
//                endChild = endChild.getTreeNext();
//            }


                    while (beginChild.getTreePrev() != null
                            && (PsiTreeUtil.hasErrorElements(beginChild.getPsi())
                            || beginChild.getElementType() == TokenType.ERROR_ELEMENT
                            || !(TreeUtil.findLastLeaf(beginChild).getElementType() instanceof TokenIElementType)
                            || (TreeUtil.findLastLeaf(beginChild).getElementType() instanceof TokenIElementType
                            && ((TokenIElementType) TreeUtil.findLastLeaf(beginChild).getElementType()).getANTLRTokenType() != HlasmLexer.ENDLINE)
                            || beginChild.getFirstChildNode() == null
                            || !(beginChild.getFirstChildNode().getElementType() instanceof RuleIElementType)
                            || oldText.charAt(beginChild.getStartOffsetInParent() - 1) != '\n'))
                        beginChild = beginChild.getTreePrev();

                    while ((PsiTreeUtil.hasErrorElements(endChild.getPsi())
                            || endChild.getElementType() == TokenType.ERROR_ELEMENT
                            || !(TreeUtil.findLastLeaf(endChild).getElementType() instanceof TokenIElementType)
                            || (TreeUtil.findLastLeaf(endChild).getElementType() instanceof TokenIElementType
                            && ((TokenIElementType) TreeUtil.findLastLeaf(endChild).getElementType()).getANTLRTokenType() != HlasmLexer.ENDLINE)
                            || endChild.getFirstChildNode() == null
                            || !(endChild.getFirstChildNode().getElementType() instanceof RuleIElementType))
                            && endChild.getTreeNext() != null)
                        endChild = endChild.getTreeNext();
                }
            } catch (Exception e) {
//            Logger.getInstance(this.getClass()).

                System.out.println("lul again full reparse?");
                return super.doParseContents(chameleon, psi);
            }
//            endChild = endChild.getTreeNext();
//        }
//        while (true){
//            if (endChild.getTreeNext() == null)
//                break;
//            if (((RuleIElementType) endChild.getTreeNext().getFirstChildNode().getElementType()).getRuleIndex() == HlasmParser.RULE_function_def_wr) {
//                break;
//            }
//            endChild = endChild.getTreeNext();
//
//        }
//        PsiElement endleaf = PsiTreeUtil.findFirstParent(psiCopy.getNode().findLeafElementAt( changedRange.getEndOffset()).getPsi(), new Condition<PsiElement>() {
//            @Override
//            public boolean value(PsiElement psiElement) {
//                return psiElement.getNode().getElementType() instanceof RuleIElementType &&
//                        ((RuleIElementType) psiElement.getNode().getElementType()).getRuleIndex() == HlasmParser.RULE_code_chunks;
//            }
//        });

//        psiFile.getNode().getLighterAST();

            CharSequence reparsedText = newText.subSequence(beginChild.getStartOffsetInParent(),
                    Math.min(endChild.getStartOffsetInParent() + endChild.getTextLength() + newText.length() - oldText.length(), newText.length()));

            CharSequence oldReparsedText = oldText.subSequence(beginChild.getStartOffsetInParent(), endChild.getStartOffsetInParent() + endChild.getTextLength());

            System.out.println("actually reparsed range:" + beginChild.getStartOffsetInParent() + " to " +
                    (endChild.getStartOffsetInParent() + endChild.getTextLength()) + " len " + (endChild.getStartOffsetInParent() - beginChild.getStartOffsetInParent() + endChild.getTextLength()));
            if (oldReparsedText.length() > 10000 && reparsedText.length() > 10000) {
                System.err.println("ATTENTION!!! very big reparsing ");
                System.out.println("diff text" + oldText.subSequence(changedRange.getStartOffset(), changedRange.getEndOffset()));
            } else {
                System.out.println("Old text:" + oldReparsedText);
                System.out.println("New text:" + reparsedText);
            }
            System.out.println("All statements old:" + beginChild.getTreeParent().getChildren(null).length);
            System.out.println("changed range: " + changedRange.getStartOffset() + "," + changedRange.getEndOffset());


            Project project = psi.getProject();
            Language languageForParser = getLanguageForParser(psi);
            final TreeElement beginFinal = beginChild;
            final TreeElement endFinal = endChild;
            final ANTLRLexerAdaptor delegate = (ANTLRLexerAdaptor) HlasmParserDefenition.INSTANCE.createLexer(null);
            final int changeTextSize = newText.length() - oldText.length();
            int newForceReparsedTextEnd = endFinal.getStartOffsetInParent() + endFinal.getTextLength() + changeTextSize;
            PsiBuilder builder = PsiBuilderFactory.getInstance().createBuilder(
                    project,
                    chameleon,
                    new LexerBase() {
                        @Override
                        public void start(@NotNull CharSequence buffer, int startOffset, int endOffset, int initialState) {
                            delegate.getState();
//                        delegate.start(buffer,startOffset,endOffset,initialState);
                            currOld = oldRoot.getFirstChildNode();
                            currTarget = beginFinal;
                            currState = 0;
                            changeOffset = 0;

                            if (beginFinal == currOld)
                                startDelegate();
                        }

                        @Override
                        public int getState() {
                            return 0;
                        }

                        @Override
                        public int getTokenEnd() {
                            return 0;
                        }


                        @NotNull
                        @Override
                        public CharSequence getBufferSequence() {
                            return newText;
                        }

                        @Override
                        public int getBufferEnd() {
                            return 0;
                        }

                        TreeElement currOld = oldRoot.getFirstChildNode();
                        ASTNode currTarget = beginFinal;
                        int currState = 0;
                        int changeOffset = 0;
                        int wtf = getState();
                        int count = 0;

                        @NotNull
                        @Override
                        public String getTokenText() {
                            if (currState == 0)
                                return currOld.getText();
                            return delegate.getTokenText();
                        }

                        @Nullable
                        @Override
                        public IElementType getTokenType() {
                            if (currOld == null) {
                                System.out.println("old not reparsed statement all:" + count);
                                return null;
                            }
                            if (currState == 0) {
//                            return getLexer().getTokenFactory().create(HlasmLexer.OLD_TOKEN,null);
                                count += 1;
//                            return (IElementType) PSIElementTypeFactory.getTokenIElementTypes(HlasmLanguage.INSTANCE).get(HlasmLexer.OLD_TOKEN);\
                                return (IElementType) PSIElementTypeFactory.getRuleIElementTypes(HlasmLanguage.INSTANCE).get(HlasmParser.RULE_statement
                                );
                            }

                            return delegate.getTokenType();
                        }

                        @Override
                        public int getTokenStart() {
                            if (currState == 0) {
                                return currOld.getStartOffsetInParent() + changeOffset;
                            }
                            return delegate.getTokenStart();
                        }

                        @Override
                        public void advance() {
                            if (currState == 2) currState = 0;
                            if (currState == 0) {
                                currOld = currOld.getTreeNext();
                                if (currOld != null && currOld == currTarget) {
                                    System.out.println("old not reparsed statement first part:" + count);
                                    startDelegate();
                                    return;
                                }
                            }
                            if (currState == 1) {
                                delegate.advance();

                                if (delegate.getTokenType() != null
                                        && delegate.getTokenStart() >= currOld.getStartOffsetInParent() + currOld.getTextLength() + changeTextSize)
                                    currOld = currOld.getTreeNext();

                                if (delegate.getTokenType() == null
                                        || ((delegate.getTokenStart() > newForceReparsedTextEnd
                                        && ((TokenIElementType) delegate.getTokenType()).getANTLRTokenType() == HlasmLexer.ENDLINE)
                                        && TreeUtil.findLastLeaf(currOld, true).getElementType() instanceof TokenIElementType
                                        && ((TokenIElementType) TreeUtil.findLastLeaf(currOld, true).getElementType()).getANTLRTokenType() == HlasmLexer.ENDLINE)
                                        && currOld.getStartOffsetInParent() + currOld.getTextLength() + changeTextSize == delegate.getTokenEnd()
                                        ) {

                                    currState = 2;
                                    currTarget = null;
                                    if (delegate.getTokenEnd() - beginFinal.getStartOffsetInParent() > 1000)
                                        System.out.println("lulululululul \n" + newText.subSequence(beginFinal.getStartOffsetInParent(), beginFinal.getStartOffsetInParent() + 1000));
                                    //currOld = endFinal.getTreeNext();
                                }
                            }
                        }

                        void startDelegate() {
                            currState = 1;
                            changeOffset = changeTextSize;
                            currOld = endFinal.getTreeNext();
                            delegate.getState();
//                        delegate.start(newText, beginFinal.getStartOffsetInParent(), endFinal.getStartOffsetInParent() + endFinal.getTextLength() + changeOffset);
                            delegate.start(newText, beginFinal.getStartOffsetInParent(), newText.length());
                            delegate.setLexerLine(oldRoot.getPsi().getContainingFile().getViewProvider().getDocument().getLineNumber(beginFinal.getStartOffset()));
                        }

                    },
                    languageForParser,
                    newText);
//            final int changedRangeMiddle = (changedRange.getStartOffset() + changedRange.getEndOffset())/2;
            builder.putUserDataUnprotected(PsiBuilderImpl.CUSTOM_COMPARATOR, new TripleFunction<ASTNode, LighterASTNode, FlyweightCapableTreeStructure<LighterASTNode>, ThreeState>() {
                @Override
                public ThreeState fun(ASTNode astNode1, LighterASTNode lighterASTNode, FlyweightCapableTreeStructure<LighterASTNode> lighterASTNodeFlyweightCapableTreeStructure) {
                    if (lighterASTNode.getTokenType() instanceof RuleIElementType && astNode1 instanceof TreeElement
                            && ((RuleIElementType) lighterASTNode.getTokenType()).getRuleIndex() == HlasmParser.RULE_statement) {
//                    System.out.println("custom comparator");
//                    if (lighterASTNode.getStartOffset() < beginFinal.getStartOffset() || lighterASTNode.getEndOffset() > endFinal.getStartOffset()+endFinal.getTextLength() + changeTextSize)
//                        return ThreeState.YES;
                        TreeElement astNode = (TreeElement) astNode1;
                        if ((astNode.getStartOffsetInParent() < beginFinal.getStartOffsetInParent() && lighterASTNode.getStartOffset() < beginFinal.getStartOffsetInParent())
                                || (astNode.getStartOffsetInParent() > endFinal.getStartOffsetInParent() && lighterASTNode.getStartOffset() > endFinal.getStartOffsetInParent() + changeTextSize))

                            return ThreeState.YES;

//                        if (changedRange.intersects(lighterASTNode.getStartOffset(), lighterASTNode.getEndOffset())) {
                        if (//changedRange.contains(lighterASTNode.getStartOffset()) ||
                                (lighterASTNode.getStartOffset() <= changedRange.getStartOffset() && lighterASTNode.getEndOffset() >= changedRange.getStartOffset())) {
                            System.out.println("definite NO  " + lighterASTNode.getStartOffset() + "," + lighterASTNode.getEndOffset());
                            return ThreeState.NO;
                        }
                        return ThreeState.UNSURE;
                    }
                    return ThreeState.UNSURE;
                }
            });
//        builder.putUserData(BlockSupportImpl.TREE_TO_BE_REPARSED,chameleon.getUserData(BlockSupportImpl.TREE_TO_BE_REPARSED));
            ANTLRParserAdaptor parser = (ANTLRParserAdaptor) LanguageParserDefinitions.INSTANCE.forLanguage(languageForParser).createParser(project);
//        parser.oldTree = oldRoot;
//        parser.newText = newText;
//        parser.oldText = oldText;
//        parser.actuallyReparsedNew = new TextRange(beginChild.getStartOffset(),endChild.getStartOffset() + endChild.getTextLength());

            ASTNode node = parser.parse(this, builder);
            return node.getFirstChildNode();
        }
        catch (BlockSupport.ReparsedSuccessfullyException|ProcessCanceledException e){
            throw e;
        }
        catch (Exception e){
            System.err.println("error dirong reparsing " + e.getMessage() );
            e.printStackTrace();
            throw e;
        }
//        PsiFile copy = BlockSupportImpl.getFileCopy(psiFile,psiFile.getViewProvider());

//            FileASTNode astNodeCopy = (FileASTNode) oldRoot.copyElement();
//            DummyHolder tempHolder = new DummyHolder(psiFile.getManager(),psi);
//            PsiFileFactoryImpl.getInstance(psi.getProject()).createFileFromText;
//            DummyHolderFactory.createHolder()

//            ASTNode childIter = beginChild;
//            while (childIter!=endChild) {
//                ASTNode copy = childIter.copyElement();
//                tempHolder.getTreeElement().addInternal((TreeElement) copy, copy, null, null);
//                childIter = childIter.getTreeNext();
//            }

//            ((LightVirtualFile) tempHolder.getContainingFile()).setContent(this,reparsedText,false);


//            Project project = psi.getProject();
//            Language languageForParser = getLanguageForParser(psi);

        //  psiCopy.putUserData(BlockSupportImpl.TREE_TO_BE_REPARSED,null);
//            ParserDefinition parserDefinition = LanguageParserDefinitions.INSTANCE.forLanguage(languageForParser);
//            PsiBuilder builder = PsiBuilderFactory.getInstance().createBuilder(project, psiCopy.getNode(), null, languageForParser, reparsedText);
//        PsiBuilder builder = PsiBuilderFactory.getInstance().createBuilder(LanguageParserDefinitions.INSTANCE.forLanguage(languageForParser),
//                LanguageParserDefinitions.INSTANCE.forLanguage(languageForParser).createLexer(psi.getProject()),reparsedText);
//            PsiBuilder builder = new PsiBuilderImpl(project,psiCopy,parserDefinition,parserDefinition.createLexer(project),psiCopy.getNode().getCharTable(),reparsedText,null,null);
//            PsiBuilder builder = null;


//            builder = new PsiBuilderImpl(project, psiFile, parserDefinition, parserDefinition.createLexer(project),
//                    psiFile.getNode().getCharTable(), reparsedText, null, null);
//            tempHolder.getTreeElement().putUserData(BlockSupportImpl.TREE_TO_BE_REPARSED,
//                    new Pair<ASTNode,CharSequence>(tempHolder.getTreeElement(),oldReparsedText));
//            builder = PsiBuilderFactory.getInstance().createBuilder(project, tempHolder.getTreeElement(), null, languageForParser, reparsedText);
//
//            PsiParser parser = LanguageParserDefinitions.INSTANCE.forLanguage(languageForParser).createParser(project);

        //adding code_chunks elements from the end;
//            builder.getLightTree();

//            try {
        //ASTNode reparsedNode = parser.parse(this, builder).getFirstChildNode();//.getFirstChildNode();
//            ((ANTLRParserAdaptor) parser).parseLight(this, builder);
//            FlyweightCapableTreeStructure<LighterASTNode> FCtreeStructure = builder.getLightTree();
//            }
//            catch (BlockSupportImpl.ReparsedSuccessfullyException e){
//
//            }


//        DiffLog diffLog = new DiffLog();
//        diffLog.nodeDeleted(beginLeaf.getParent().getNode(),beginLeaf.getNode());
//            ASTNode parentReparsed = endChild.getTreeParent();
//            ASTNode anchor = endChild.getTreeNext();
//            anchor.getTreeParent().removeRange(beginLeaf, anchor);
//            ((TreeElement) beginChild).rawRemoveUpTo((TreeElement) anchor);
//        while (beginLeaf != endleaf){
//            beginLeaf = beginLeaf.getNextSibling();
//            beginLeaf.delete();
//            diffLog.nodeDeleted(beginLeaf.getParent().getNode(),beginLeaf.getNode());
//        }


//            while (node != null) {
//            diffLog.nodeInserted(beginLeaf.getParent().getNode(),node,intertIndex);
//            anchor.getParent().addRangeBefore(node.getFirstChildNode().getPsi(),node.getLastChildNode().getPsi(),anchor);
        //anchor.getTreeParent().addChildren(node.getFirstChildNode(), node.getLastChildNode().getTreeNext(), anchor);
//                if (anchor != null)
//                    ((TreeElement) anchor).rawInsertBeforeMe((TreeElement) node.clone());
//                else
//                    ((TreeElement) parentReparsed.getLastChildNode()).rawInsertAfterMe((TreeElement) node.clone());
//                node = node.getTreeNext();
//            }


//            diffLog = BlockSupportImpl.mergeTrees(psiFile, oldRoot, astNodeCopy, new StandardProgressIndicatorBase(), oldText);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }


//        System.out.println("reparsed");
//        DocumentCommitThread.doActualPsiChange(psiFile,diffLog);
//        return super.doParseContents(chameleon, psi);
//        throw new BlockSupport.ReparsedSuccessfullyException(diffLog);

//        return psiFile.getFirstChild().getNode();
    }


    TreeElement findChildAtOffset(ASTNode node, int offset) {
        ASTNode child = node.getFirstChildNode();
        if (child == null) return null;

        while (child != null && ((TreeElement) child).getStartOffsetInParent()+child.getTextLength() < offset) {

            child = child.getTreeNext();
        }
        return (TreeElement) child;
    }

}
