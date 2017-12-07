package com.hlasm_plugin.inspections;

import com.hlasm_plugin.psi.LabelDefLineSubtree;
import com.intellij.lang.annotation.AnnotationHolder;
import com.intellij.lang.annotation.Annotator;
import com.intellij.openapi.util.TextRange;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiRecursiveElementWalkingVisitor;
import org.jetbrains.annotations.NotNull;
import org.antlr.jetbrains.adaptor.lexer.*;
import hlasm.HlasmParser;
import org.antlr.jetbrains.adaptor.psi.ANTLRPsiNode;
import java.util.ArrayList;

/**
 * Created by ]{.
 */
public class BRSAnnotator implements Annotator {
    
    private ArrayList<String> regs = new ArrayList(32);
    
    @Override
    public void annotate(@NotNull PsiElement element, @NotNull AnnotationHolder holder) {
        if (!(element.getNode().getElementType() instanceof TokenIElementType) || element instanceof RuleIElementType)
            return;
        PsiElement elem = element;
        TokenIElementType tElem = ((TokenIElementType)(elem.getNode().getElementType()));
        if(tElem.getANTLRTokenType() == HlasmParser.USING){
            elem = element.getParent();
            PsiElement[] elemArr = new ANTLRPsiNode(elem.getNode()).getChildren();
            if(!regs.contains(elemArr[3].getText()))
                regs.add(elemArr[3].getText());
        }
        if(tElem.getANTLRTokenType() == HlasmParser.DROP){
            elem = element.getParent();
            PsiElement[] elemArr = new ANTLRPsiNode(elem.getNode()).getChildren();
            elemArr = new ANTLRPsiNode(elemArr[1].getNode()).getChildren();
            for(int i = regs.size() - 1; i >= 0; i--){
                for(int j = elemArr.length - 1; j >= 0; j = j - 2) {
                    if(stringToInt(elemArr[j].getText()) == stringToInt(regs.get(i))){
                        regs.remove(i);
                    }
                }
            }
        }
        if(tElem.getANTLRTokenType() == HlasmParser.END){
            regs.clear();
//            for(int i = regs.size() - 1; i >= 0; i--)
//                regs.remove(i);
        }
        if(tElem.getANTLRTokenType()== HlasmParser.COMMAND) {
            String name = element.getText().toUpperCase();
            if ((elem.getText().length() == 1) || !(elem.getText().toUpperCase().equals("EX")) || !(elem.getText().substring(0, 2).toUpperCase().equals("ST"))) {
                elem = element.getNextSibling().getNextSibling();
                PsiElement[] elemArr = elem.getChildren();
                elemArr[0] = elemArr[0].getFirstChild();
                elemArr[2] = elemArr[2].getFirstChild();
                PsiElement[] elemArr1 = elemArr[0].getChildren();
//                PsiElement[] elemArr2 = elemArr[2].getChildren();
                if (name.equals("PGMBEGIN") || name.equals("RTNBEGIN"))
                    regs.clear();
                if (name.equals("CLC") || name.equals("MVC")) {
                    if(elemArr[0].getParent().getChildren().length == 2){
                        elemArr1 = elemArr[0].getNextSibling().getChildren();
                        if(elemArr1[1].getChildren().length == 1) {
                            int len1, len2;
                            elem = elemArr[0].getFirstChild().getFirstChild().getReference().resolve();
                            elemArr1 = elem.getChildren();
                            elemArr1 = elemArr1[1].getChildren();
                            len1 = takingLen(elemArr1[1].getText());
                            elemArr1 = elemArr[0].getParent().getChildren();
                            elemArr1 = elemArr1[1].getChildren();
                            if(((TokenIElementType)(elemArr1[0].getNode().getElementType())).getANTLRTokenType() == HlasmParser.PLUS){
                                len1 = len1 - stringToInt(elemArr1[1].getText());
                            }else{
                                len1 = len1 + stringToInt(elemArr1[1].getText());
                            }
                            elem = elemArr[2].getFirstChild().getFirstChild().getReference().resolve();
                            elemArr1 = elem.getChildren();
                            elemArr1 = elemArr1[1].getChildren();
                            len2 = takingLen(elemArr1[1].getText());
                            if(len1 < len2){
                                TextRange range = new TextRange(elemArr[0].getTextRange().getStartOffset(), elemArr[2].getTextRange().getEndOffset());
                                holder.createWarningAnnotation(range, "Incorrect length attribute");
                            }
                        }
                    }else {
                        elemArr1 = elemArr1[1].getChildren();
                        elemArr1 = elemArr1[1].getChildren();
                        if ((stringToInt(elemArr1[0].getText()) > 256) || (stringToInt(elemArr1[0].getText()) < 0)) {
                            TextRange range = new TextRange(elemArr1[0].getTextRange().getStartOffset(), elemArr1[0].getTextRange().getEndOffset());
                            holder.createErrorAnnotation(range, "Incorrect length attribute.\n Valid values: 0 - 256");
                        }
                    }
                }
                if(!regs.isEmpty()) {
                    if (elemArr.length == 3) {
                        if (elemArr1.length == 1) {
                            for (int i = regs.size() - 1; i >= 0; i--) {
                                if (stringToInt(elemArr[0].getText()) == stringToInt(regs.get(i))) {
                                    TextRange range = new TextRange(elemArr[0].getTextRange().getStartOffset(), elemArr[0].getTextRange().getEndOffset());
                                    holder.createWarningAnnotation(range, "Base register spoiling");
                                }
                            }
                        }
                        if (name.equals("D") || name.equals("DR") || name.equals("M") || name.equals("MR")) {
                            int nextElem = stringToInt(elemArr[0].getText());
                            if (nextElem == 15)
                                nextElem = 0;
                            else
                                nextElem++;
                            for (int i = regs.size() - 1; i >= 0; i--) {
                                if (nextElem == stringToInt(regs.get(i))) {
                                    TextRange range = new TextRange(elemArr[0].getTextRange().getStartOffset(), elemArr[0].getTextRange().getEndOffset());
                                    holder.createWarningAnnotation(range, "Base register " + regs.get(i) + " spoiling");
                                }
                            }
                        }
//                if(elemArr2.length == 1){
//                    for(int i = regs.size() - 1; i >= 0; i--){
//                        if(elemArr[2].getText().equals(regs.get(i))){
//                            TextRange range = new TextRange(elemArr[2].getTextRange().getStartOffset(), elemArr[2].getTextRange().getEndOffset());
//                            holder.createErrorAnnotation(range, "Base register spoiling");
//                        }
//                    }
//                }
                    } else {
                        tElem = ((TokenIElementType) (elemArr[2].getFirstChild().getFirstChild().getNode().getElementType()));
                        if (HlasmParser.STRING == tElem.getANTLRTokenType()) {
                            for (int i = regs.size() - 1; i >= 0; i--) {
                                if (stringToInt(elemArr[0].getText()) == stringToInt(regs.get(i))) {
                                    TextRange range = new TextRange(elemArr[0].getTextRange().getStartOffset(), elemArr[0].getTextRange().getEndOffset());
                                    holder.createWarningAnnotation(range, "Base register spoiling");
                                }
                            }
                        } else {
                            int startR = stringToInt(elemArr[0].getText());
                            int endR = stringToInt(elemArr[2].getText());
                            for (int i = regs.size() - 1; i >= 0; i--) {
                                if (startR > endR) {
                                    if ((stringToInt(regs.get(i)) <= startR) && (stringToInt(regs.get(i)) <= endR)) {
                                        TextRange range = new TextRange(elemArr[0].getTextRange().getStartOffset(), elemArr[2].getTextRange().getEndOffset());
                                        holder.createWarningAnnotation(range, "Base register spoiling");
                                    }
                                } else {
                                    if ((stringToInt(regs.get(i)) >= startR) && (stringToInt(regs.get(i)) <= endR)) {
                                        TextRange range = new TextRange(elemArr[0].getTextRange().getStartOffset(), elemArr[2].getTextRange().getEndOffset());
                                        holder.createWarningAnnotation(range, "Base register spoiling");
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return;

    }

//    @Override
//    public void visitElement(PsiElement element) {
//        if (!(element instanceof LabelDefLineSubtree))
//            return;
//        super.visitElement(element);
//    }
    
    private int stringToInt(String str) {
        int numReg;
        try {
            numReg = Integer.valueOf(str);
        }catch (NumberFormatException e) {
            numReg = Integer.valueOf(str.substring(1));
        }
        return numReg;
    }
    
    private int takingLen (String str){
        int i;
        for(i = 0; i < str.length() - 1; i++){
            if(str.substring(i, i + 1).toUpperCase().equals("L")){
                i++;
                int q;
                for(q = i; q < str.length() - 1; q++){
                    if(str.substring(q, q + 1).toUpperCase().equals("'")){
                        return Integer.valueOf(str.substring(i, q));
                    }
                }
                return Integer.valueOf(str.substring(i, q + 1));
            }
            if(str.substring(i, i + 1).toUpperCase().equals("'")){
                i++;
                return str.length() - 1 - i;
            }
        }
        return -1;
    }
}
