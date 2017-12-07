package com.hlasm_plugin;

import com.hlasm_plugin.psi.LabelDefTokenPsiElement;
import com.hlasm_plugin.psi.LabelTokenPSIElement;
import com.hlasm_plugin.psi.MacroCallTokenPsiElement;
import com.hlasm_plugin.stubs.HlasmStubIndex;
import com.intellij.core.CoreASTFactory;
import com.intellij.extapi.psi.PsiFileBase;
import com.intellij.lang.*;
import com.intellij.lang.impl.PsiBuilderImpl;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.project.ProjectManager;
import com.intellij.openapi.project.ex.ProjectManagerEx;
import com.intellij.psi.PsiElement;
import com.intellij.psi.impl.source.tree.CompositeElement;
import com.intellij.psi.impl.source.tree.FileElement;
import com.intellij.psi.impl.source.tree.LazyParseableElement;
import com.intellij.psi.impl.source.tree.LeafElement;
import com.intellij.psi.tree.IElementType;
import com.intellij.psi.tree.IFileElementType;
import com.intellij.psi.tree.ILazyParseableElementType;
import hlasm.HlasmLexer;
import org.antlr.jetbrains.adaptor.lexer.TokenIElementType;
import org.jetbrains.annotations.NotNull;

/**
 * Created by anisik on 14.06.2016.
 */
public class HlasmASTFactory extends CoreASTFactory {
    @Override
    @NotNull
    public LazyParseableElement createLazy(final ILazyParseableElementType type, final CharSequence text) {
//        if (type instanceof IFileElementType){
//            return new FileElement(new IFileElementType(HlasmLanguage.INSTANCE){
//                @Override
//                protected ASTNode doParseContents(@NotNull ASTNode chameleon, @NotNull PsiElement psi) {
//                    Project project = psi.getProject();
//                    Language languageForParser = getLanguageForParser(psi);
//                    PsiBuilder builder = new PsiBuilderImpl(project,((PsiFileBase)psi.getContainingFile()).getParserDefinition(),
//                            ((PsiFileBase)psi.getContainingFile()).getParserDefinition().createLexer(project),chameleon,chameleon.getText()){
//
//                    }; //PsiBuilderFactory.getInstance().createBuilder(project, chameleon, null, languageForParser, chameleon.getChars());
//                    PsiParser parser = LanguageParserDefinitions.INSTANCE.forLanguage(languageForParser).createParser(project);
//                    ASTNode node = parser.parse(this, builder);
//                    return node.getFirstChildNode();
//                    System.out.println("-------reparsing file" + psi.getContainingFile().getVirtualFile().getName());
//                    return super.doParseContents(chameleon,psi);
//                }
//            },text);
//        }
//        if (type instanceof RuleLazyIElementType){
//            System.out.println("create lazy " + text);
//        }
        return super.createLazy(type,text);
    }

    @NotNull
    @Override
    public CompositeElement createComposite(IElementType type) {

//        if (((RuleIElementType)type).getRuleIndex() == HlasmParser.RULE_line) {
        //    System.out.println("lazy reparsable node created ");
//            return new CommandLazyASTNode(type, null);
//        }

        return super.createComposite(type);
    }

    @NotNull
    @Override
    public LeafElement createLeaf(@NotNull IElementType type, CharSequence text) {
        if ( type instanceof TokenIElementType)
            switch (((TokenIElementType) type).getANTLRTokenType()){
//                case HlasmLexer.LABEL_DEF:
//                    return new LabelDefTokenPsiElement(type, text);
                case HlasmLexer.LABEL:
                    return new LabelTokenPSIElement (type, text);
                case HlasmLexer.COMMAND:
                    return new MacroCallTokenPsiElement(type,text);
            }

        return super.createLeaf(type, text);
    }
}
