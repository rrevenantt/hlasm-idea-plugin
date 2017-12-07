package com.hlasm_plugin.inspections;

import com.hlasm_plugin.HlasmSyntaxHighlighter;
import com.hlasm_plugin.lang_model.ArgumentPsiElement;
import com.hlasm_plugin.psi.LabelDefLineSubtree;
import com.intellij.lang.annotation.AnnotationHolder;
import com.intellij.lang.annotation.Annotator;
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors;
import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.editor.markup.EffectType;
import com.intellij.openapi.editor.markup.TextAttributes;
import com.intellij.openapi.progress.ProgressManager;
import com.intellij.openapi.util.TextRange;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiRecursiveElementWalkingVisitor;
import com.intellij.psi.PsiReference;
import com.intellij.psi.TokenType;
import com.intellij.psi.util.PsiTreeUtil;
import com.intellij.ui.JBColor;
import com.intellij.util.ui.UIUtil;
import hlasm.HlasmLexer;
import hlasm.HlasmParser;
import org.antlr.jetbrains.adaptor.lexer.RuleIElementType;
import org.antlr.jetbrains.adaptor.lexer.TokenIElementType;
import org.intellij.lang.regexp.RegExpHighlighter;
import org.jetbrains.annotations.NotNull;

import java.awt.*;
import java.awt.font.TextAttribute;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by ]{.
 */
public class AssistHlasmAnnotator implements Annotator {

    private boolean yregs = false;
    private final String errReg = "Incorrect register";
    private final String errParm = "Incorrect parameter syntax";
    private static Pattern ampVar = Pattern.compile("(&[^.()'& ]+\\.?)|(&&)|('')");
    private static Pattern register = Pattern.compile("\\AR([0-9]|1[0-5])\\z");
    static TextAttributesKey macroVarAttribute = TextAttributesKey.createTextAttributesKey("hlasm.macrovar", new TextAttributes(new JBColor(0xaa88dd, 0xaa88dd),
            null, null, null, 0));
    static TextAttributesKey textPrefixAttr = TextAttributesKey.createTextAttributesKey("hlasm.stringprefix",
            new TextAttributes(new JBColor(0xddaa66, 0xddaa66),
                    null, null, null, Font.ITALIC));

    static TextAttributesKey equAttr = TextAttributesKey.createTextAttributesKey("hlasm.equ",
            new TextAttributes(null,
                    new Color(UIUtil.getEditorPaneBackground().getRGB() + 0x5 - 0x050500),null, null, 0));



    static TextAttributesKey registerAttr = TextAttributesKey.createTextAttributesKey("hlasm.register",

//            new TextAttributes(HlasmSyntaxHighlighter.ID.getDefaultAttributes().getForegroundColor(),
//                    null, new JBColor(0x777777,0x777777), EffectType.LINE_UNDERSCORE, 0));
            new TextAttributes(new JBColor(0xd5d5d5,0xd5d5d5),
                    null, null,null, Font.BOLD));


    @Override
    public void annotate(@NotNull PsiElement element, @NotNull AnnotationHolder holder) {
        if (!(element.getNode().getElementType() instanceof TokenIElementType))
            return;

//        ProgressManager.checkCanceled();
        TokenIElementType tElem = ((TokenIElementType) (element.getNode().getElementType()));
        switch (tElem.getANTLRTokenType()) {
            case HlasmParser.COMMAND: {
                String name = element.getText().toUpperCase();
//            if(name.equals("YREGS"))
                yregs = true;
                PsiElement elem = element.getNextSibling().getNextSibling();
            /*if(name.equals("LA")){
                PsiElement[] elemArr = elem.getChildren();
                if(checkNumParm(elemArr, holder, 2, errParm))
                    return;
                checkParmAsReg(elemArr[0], holder);      
                PsiElement[] elemArr1 = elemArr[0].getChildren();                
                PsiElement[] elemArr2 = elemArr[2].getFirstChild().getChildren();
                tElem = ((TokenIElementType)(elemArr2[0].getFirstChild().getNode().getElementType()));
                if(tElem.getANTLRTokenType() == HlasmParser.NUMBER){
                        if((stringToInt(elemArr1[0].getText()) < 0) || ((stringToInt(elemArr1[0].getText()) > 4096))){
                            TextRange range = new TextRange(elemArr2[0].getTextRange().getStartOffset(), elemArr2[0].getTextRange().getEndOffset());
                            holder.createErrorAnnotation(range, "Incorrect offset.\n Valid values: 0 - 4096");
                        }
                        elemArr2 = elemArr[2].getFirstChild().getNextSibling().getChildren();
                        if(((TokenIElementType)(elemArr2[0].getFirstChild().getNode().getElementType())).getANTLRTokenType() != HlasmParser.LEFT_ROUND_PAR){
                            TextRange range = new TextRange(elemArr2[0].getTextRange().getStartOffset(), elemArr2[0].getTextRange().getEndOffset());
                            holder.createErrorAnnotation(range, "Incorrect syntax");
                        }
                        elemArr1 = elemArr2[1].getChildren();
                        if(elemArr1.length > 3){
                            TextRange range = new TextRange(elemArr2[1].getTextRange().getStartOffset(), elemArr2[1].getTextRange().getEndOffset());
                            holder.createErrorAnnotation(range, "Incorrect parameter syntax");
                        }else{
         //                   if()
                        }
                        if(((TokenIElementType)(elemArr2[2].getFirstChild().getNode().getElementType())).getANTLRTokenType() != HlasmParser.RIGHT_ROUND_PAR){
                            TextRange range = new TextRange(elemArr2[2].getTextRange().getStartOffset(), elemArr2[2].getTextRange().getEndOffset());
                            holder.createErrorAnnotation(range, "Incorrect syntax");
                        }
                        
                }
                if(tElem.getANTLRTokenType() != HlasmParser.LABEL){
                    TextRange range = new TextRange(elemArr[2].getTextRange().getStartOffset(), elemArr[2].getTextRange().getEndOffset());
                    holder.createErrorAnnotation(range, "Incorrect parameter syntax");
                }
                return;
            }*/
                try {
                    if (name.equals("L") || name.equals("LR")) {
                        PsiElement[] elemArr = elem.getChildren();
                        PsiElement[] elemArr1 = elemArr[2].getFirstChild().getChildren();
                        if (elemArr1.length == 1) {
                            elemArr1[0] = elemArr1[0].getFirstChild();
                            tElem = ((TokenIElementType) (elemArr1[0].getNode().getElementType()));
                            TextRange range = new TextRange(element.getTextRange().getStartOffset(), element.getTextRange().getEndOffset());
                            if (tElem.getANTLRTokenType() == HlasmParser.NUMBER) {
                                holder.createWarningAnnotation(range, "Perhaps this refers to the LA").registerFix(new LToLaFix(element));
                            } else {
                                if ((tElem.getANTLRTokenType() == HlasmParser.LABEL) && (name.equals("L"))) {
                                    if (elemArr1[0].getText().substring(0, 1).equals("R") && (stringToInt(elemArr1[0].getText()) < 16)) {
                                        holder.createWarningAnnotation(range, "Perhaps this refers to the LR");
                                    }
                                    elemArr1 = elemArr1[0].getReference().resolve().getChildren();
                                    elemArr1 = elemArr1[1].getChildren();
                                    if (((TokenIElementType) (elemArr1[0].getNode().getElementType())).getANTLRTokenType() == HlasmParser.EQU) {
                                        elemArr1 = elemArr1[1].getFirstChild().getFirstChild().getChildren();
                                        if (elemArr1.length == 1) {
                                            if (((TokenIElementType) (elemArr1[0].getFirstChild().getNode().getElementType())).getANTLRTokenType() == HlasmParser.NUMBER) {
                                                holder.createWarningAnnotation(range, "Perhaps this refers to the LA").registerFix(new LToLaFix(element));
                                            } else {
                                                elemArr1 = elemArr1[1].getFirstChild().getFirstChild().getChildren();
                                                for (int i = 0; i < elemArr1.length; i++) {
                                                    if (((TokenIElementType) (elemArr1[i].getFirstChild().getNode().getElementType())).getANTLRTokenType() == HlasmParser.LABEL)
                                                        break;
                                                }
                                                holder.createWarningAnnotation(range, "Perhaps this refers to the LA").registerFix(new LToLaFix(element));
                                            }
                                        } else {
                                            for (int i = 0; i < elemArr1.length; i++) {
                                                if (((TokenIElementType) (elemArr1[i].getFirstChild().getNode().getElementType())).getANTLRTokenType() == HlasmParser.LABEL)
                                                    break;
                                            }
                                            holder.createWarningAnnotation(range, "Perhaps this refers to the LA").registerFix(new LToLaFix(element));

                                        }
                                    }
                                }
                            }
                        }
                    }
                } catch (Exception e) {
//                    System.out.println(" error during AssistHlasmAnnotator");
                }
                break;
            }
            case HlasmLexer.LABEL:

                PsiReference reference = element.getReference();
                if (reference != null) {
                    PsiElement def =  reference.resolve();
                    if (def!=null && def instanceof LabelDefLineSubtree && def.getContainingFile() == element.getContainingFile() &&
                            ((TokenIElementType) ((LabelDefLineSubtree) def).getCommand().getNode().getElementType()).getANTLRTokenType() == HlasmLexer.EQU){
//                        ArgumentPsiElement[] args = ((LabelDefLineSubtree) def).getArguments();
//
//                        holder.createInfoAnnotation(element, args.length == 1 && args[0].getText().length()<20?args[0].getText():null).setTextAttributes(equAttr);
                    }
                }

                if (((RuleIElementType) element.getParent().getNode().getElementType()).getRuleIndex() == HlasmParser.RULE_named_argument) {
                    holder.createInfoAnnotation(element, null)
                            .setTextAttributes(macroVarAttribute);
                    break;
                }
                if (register.matcher(element.getText()).matches()) {
                    holder.createInfoAnnotation(element, null).setTextAttributes(registerAttr);
                    break;
                }
            case HlasmParser.LABEL_DEF:
            case HlasmLexer.STRING:
                String text = element.getText();
                int quoteOffset = element.getText().indexOf('\'');
                Matcher matcher = ampVar.matcher(text.substring(quoteOffset+1));
                while (matcher.find()) {
                    if(matcher.start(1)>=0) {
                        holder.createInfoAnnotation(new TextRange(element.getTextOffset() + matcher.start()+quoteOffset+1, element.getTextOffset() + matcher.end()+quoteOffset+1), null)
                                .setTextAttributes(macroVarAttribute);
                    }
                    else{
                        holder.createInfoAnnotation(new TextRange(element.getTextOffset() + matcher.start()+quoteOffset+1, element.getTextOffset() + matcher.end()+quoteOffset+1), null)
                                .setTextAttributes(HlasmSyntaxHighlighter.KEYWORD);
                    }
                }
                if (tElem.getANTLRTokenType() != HlasmLexer.STRING)
                    break;

                if (quoteOffset > 0)
                    holder.createInfoAnnotation(new TextRange(element.getTextOffset(), element.getTextOffset() + quoteOffset), null).setTextAttributes(textPrefixAttr);

        }
    }

    private int stringToInt(String str) {
        int numReg;
        try {
            numReg = Integer.valueOf(str);
        } catch (NumberFormatException e) {
            if (yregs)
                numReg = Integer.valueOf(str.substring(1));
            else
                numReg = -1;
        }
        return numReg;
    }

    private void checkParmAsReg(@NotNull PsiElement element, @NotNull AnnotationHolder holder) {
        if (checkNumParm(element.getFirstChild().getChildren(), holder, 1, errReg))
            return;
        PsiElement[] elemArr1 = element.getChildren();
        TokenIElementType tElem = ((TokenIElementType) (elemArr1[0].getFirstChild().getFirstChild().getNode().getElementType()));
        if ((tElem.getANTLRTokenType() == HlasmParser.NUMBER) || (tElem.getANTLRTokenType() == HlasmParser.LABEL)) {
            if ((stringToInt(elemArr1[0].getText()) < 0) || ((stringToInt(elemArr1[0].getText()) > 15))) {
                TextRange range = new TextRange(elemArr1[0].getTextRange().getStartOffset(), elemArr1[0].getTextRange().getEndOffset());
                holder.createErrorAnnotation(range, errReg);
            }
        } else {
            TextRange range = new TextRange(elemArr1[0].getTextRange().getStartOffset(), elemArr1[0].getTextRange().getEndOffset());
            holder.createErrorAnnotation(range, errParm);
        }
        return;
    }

    private void checkParmAsStore(@NotNull PsiElement element, @NotNull AnnotationHolder holder) {

    }

    private void checkParmAsIndex(@NotNull PsiElement element, @NotNull AnnotationHolder holder) {

    }

    private boolean checkNumParm(@NotNull PsiElement[] elemArr, @NotNull AnnotationHolder holder, @NotNull int num, String err) {
        num = num * 2 - 1;
        if (elemArr.length != num) {
            TextRange range = new TextRange(elemArr[0].getTextRange().getStartOffset(), elemArr[elemArr.length - 1].getTextRange().getEndOffset());
            holder.createErrorAnnotation(range, err);
            return true;
        }
        return false;
    }
}
