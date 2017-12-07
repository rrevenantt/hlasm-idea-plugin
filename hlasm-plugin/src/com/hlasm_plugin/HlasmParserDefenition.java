package com.hlasm_plugin;

import com.hlasm_plugin.psi.*;
import com.intellij.lang.*;
import com.intellij.lexer.Lexer;
import com.intellij.openapi.progress.ProgressIndicatorProvider;
import com.intellij.openapi.project.Project;
import com.intellij.psi.*;
import com.intellij.psi.tree.IElementType;
import com.intellij.psi.tree.IFileElementType;
import com.intellij.psi.tree.TokenSet;
import hlasm.HlasmLexer;
import hlasm.HlasmParser;
import org.antlr.jetbrains.adaptor.lexer.*;
import org.antlr.jetbrains.adaptor.parser.ANTLRParseTreeToPSIConverter;
import org.antlr.jetbrains.adaptor.parser.ANTLRParserAdaptor;
import org.antlr.jetbrains.adaptor.psi.ANTLRPsiLeafNode;
import org.antlr.jetbrains.adaptor.psi.ANTLRPsiNode;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.IntStream;
import org.antlr.v4.runtime.Parser;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ParseTree;
import org.jetbrains.annotations.NotNull;

/**
 * Created by anisik on 01.06.2016.
 */
public class HlasmParserDefenition implements ParserDefinition {
    public static final IFileElementType FILE = new HlasmIFileElementType();
    public static final HlasmParserDefenition INSTANCE = new HlasmParserDefenition();

    static {
        //PSIElementTypeFactory.iElementTypesFactory.put() = HlasmIElementTypesFactory.INSTANCE;
        PSIElementTypeFactory.defineLanguageIElementTypes(HlasmLanguage.INSTANCE,
                HlasmParser.tokenNames,
                HlasmParser.ruleNames,
                HlasmIElementTypesFactory.INSTANCE);

    }

    public static final TokenSet COMMENTS =
            PSIElementTypeFactory.createTokenSet(
                    HlasmLanguage.INSTANCE,
                    HlasmLexer.COMMENT,
                    HlasmLexer.ENDLINE_COMM,
                    HlasmLexer.ARG_SEPARATOR);

    public static final TokenSet WHITESPACE =
            PSIElementTypeFactory.createTokenSet(
                    HlasmLanguage.INSTANCE,
                    HlasmLexer.SPACES1);

    public static final TokenSet STRING =
            PSIElementTypeFactory.createTokenSet(
                    HlasmLanguage.INSTANCE,
                    HlasmLexer.STRING,
                    HlasmLexer.STRING_ERROR);

    @NotNull
    @Override
    public Lexer createLexer(Project project){
        HlasmLexer lexer = new HlasmLexer(null);
        lexer.prologs.add("RTNBEGIN");
        lexer.prologs.add("PGMBEGIN");
        return new ANTLRLexerAdaptor(HlasmLanguage.INSTANCE,lexer){
            @Override
            public void start(CharSequence buffer, int startOffset, int endOffset, int initialState) {
//                this.buffer = buffer;
//                this.endOffset = endOffset;


//                CharStream in = new CharSequenceCharStream(buffer, endOffset, IntStream.UNKNOWN_SOURCE_NAME);
//                in.seek(startOffset);
                int newStartOffset = startOffset;
                int prevOffset = startOffset;
                while (prevOffset > 0 && buffer.charAt(prevOffset) != '\n') {
                    prevOffset--;
//                    in.seek(prevOffset+1	);
                    newStartOffset = prevOffset + 1;
                }

                super.start(buffer,newStartOffset,endOffset,initialState);

                while (getTokenStart()<startOffset
                        && endOffset != 0)
                    advance();
            }
        };
    }

    @Override
    public IFileElementType getFileNodeType() {
        return FILE;
    }

    public PsiElement createElement(ASTNode node){
        IElementType elType = node.getElementType();
        // tokens are leafs and are created in AST factory
        // so this should never be true
        if (elType instanceof TokenIElementType && !(elType instanceof RuleIElementType)){
            System.out.println("weird reparsing "+node.getText());
            //return new ANTLRPsiLeafNode(elType,node.getText());
            System.out.println(node.getText());
            if(((TokenIElementType)node.getElementType()).getANTLRTokenType() == HlasmLexer.LABEL
                    || ((TokenIElementType)node.getElementType()).getANTLRTokenType() == HlasmLexer.LABEL_DEF){
                return new LabelTokenPSIElement(node.getElementType(),node.getText());
            }

            return new ANTLRPsiLeafNode(node.getElementType(),node.getChars());
        }
        if (!(elType instanceof RuleIElementType)){
            System.out.println("weird reparsing "+node.getText());
            return new ANTLRPsiNode(node);
        }

        RuleIElementType ruleIElementType = (RuleIElementType) elType;
//        if (node.getFirstChildNode() != null
//                && node.getFirstChildNode().getElementType() instanceof TokenIElementType
//                && ((TokenIElementType)node.getFirstChildNode().getElementType()).getANTLRTokenType() == HlasmLexer.LABEL_DEF)
//            System.out.println(elType);
        //PsiManager.getInstance().getModificationTracker().
        switch (ruleIElementType.getRuleIndex() ) {
            case HlasmParser.RULE_line_wrapper:
                if (
//                || ruleIElementType.getRuleIndex() == HlasmParser.RULE_function_def
                /*|| ruleIElementType.getRuleIndex() == HlasmParser.RULE_macro*/
                        node.getFirstChildNode() != null
//                && node.getFirstChildNode().getElementType() instanceof TokenIElementType
//                && ((TokenIElementType)node.getFirstChildNode().getElementType()).getANTLRTokenType() == HlasmLexer.LABEL_DEF
                        ) {
                    LabelDefLineSubtree element = new LabelDefLineSubtree(node, (IElementType) PSIElementTypeFactory.getTokenIElementTypes(HlasmLanguage.INSTANCE).get(HlasmLexer.LABEL_DEF));
                    if (element.getContainingFile() == null || !(element.getContainingFile() instanceof HlasmPSIFileRoot)) {
                        System.out.println("WTF !!!!11111 HlasmParserDefinition.createElement ");
                        System.out.println("              " + element.getText());
                        return element;
                    }
                    if (node.getFirstChildNode().getElementType() instanceof TokenIElementType
                            && ((TokenIElementType) node.getFirstChildNode().getElementType()).getANTLRTokenType() == HlasmLexer.LABEL_DEF) {
//                        System.out.println("label tree saved" + node.getFirstChildNode().getText());
                        ((HlasmPSIFileRoot) element.getContainingFile()).definitions.put(node.getFirstChildNode().getText(), element);
                    }
                    return element;
                }
                break;
            case HlasmParser.RULE_macro_def_wr:
                return new HlasmMacroHeaderPsiElement(node);
            case  HlasmParser.RULE_macro:
                return new HlasmMacroPsiElement(node);
            case HlasmParser.RULE_lines:
                return new HlasmLinesPsiElement(node);
            case HlasmParser.RULE_argument:
                return new HlasmMacroArgumentPsiElement(node);
        }
        /*
        switch (ruleIElementType.getRuleIndex()){
            case HlasmParser.RULE_line:
                return
        }*/
        return new ANTLRPsiNode(node);
    }

    public PsiFile createFile(FileViewProvider viewProvider){
        //viewProvider.getDocument().putUserData(BlockSupport.DO_NOT_REPARSE_INCREMENTALLY,null);
        return new HlasmPSIFileRoot(viewProvider);
    }

    public SpaceRequirements spaceExistanceTypeBetweenTokens(ASTNode left, ASTNode right) {
        if ((left.getElementType() instanceof TokenIElementType
                    && ((TokenIElementType) left.getElementType()).getANTLRTokenType() == HlasmLexer.COMMAND)
                || (right.getElementType() instanceof TokenIElementType
                    && ((TokenIElementType) right.getElementType()).getANTLRTokenType() == HlasmLexer.COMMAND)
                ) {
            return SpaceRequirements.MUST;
        }
        return SpaceRequirements.MAY;
    }

    public PsiParser createParser(final Project project){

        /*EditorFactory.getInstance().addEditorFactoryListener(new EditorFactoryListener() {
            @Override
            public void editorCreated(@NotNull EditorFactoryEvent event) {
                event.getEditor().getGutter().registerTextAnnotation(new TextAnnotationGutterProvider() {
                    @Nullable
                    @Override
                    public String getLineText(int line, Editor editor) {
                        return "test1";
                    }

                    @Nullable
                    @Override
                    public String getToolTip(int line, Editor editor) {
                        return "test2";
                    }

                    @Override
                    public EditorFontType getStyle(int line, Editor editor) {
                        return EditorFontType.PLAIN;
                    }

                    @Nullable
                    @Override
                    public ColorKey getColor(int line, Editor editor) {
                        return ColorKey.createColorKey("red");
                    }

                    @Nullable
                    @Override
                    public Color getBgColor(int line, Editor editor) {
                        return null;
                    }

                    @Override
                    public List<AnAction> getPopupActions(int line, Editor editor) {
                        return null;
                    }

                    @Override
                    public void gutterClosed() {

                    }
                });
            }
//
            @Override
            public void editorReleased(@NotNull EditorFactoryEvent event) {

            }
        });*/
//        EditorFactory.getInstance().getEventMulticaster().addDocumentListener(new DocumentAdapter() {
//            @Override
//            public void beforeDocumentChange(DocumentEvent e) {
//                System.out.println("document going to be changed"+ e.getDocument());
//            }
//
//            @Override
//            public void documentChanged(DocumentEvent e) {
//                System.out.println("document changed");
//            }
//        });

        HlasmParser parser = new HlasmParser(null);
        return new HlasmANTLRParserAdaptor(parser);
    }

    @NotNull
    public TokenSet getWhitespaceTokens() {
        return WHITESPACE;
    }

    @NotNull
    public TokenSet getCommentTokens() {
        return COMMENTS;
    }

    @NotNull
    public TokenSet getStringLiteralElements() {
        return STRING;
    }
}
