package com.hlasm_plugin.inspections.UnreachableCode;

import java.util.ArrayList;
import java.util.List;

import com.intellij.lang.annotation.AnnotationHolder;
import com.intellij.lang.annotation.Annotator;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.PsiRecursiveElementWalkingVisitor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/** *@author Paradaimu */
public class HlasmUnreachableCode extends PsiRecursiveElementWalkingVisitor implements Annotator {
    @Override
    public void annotate(@NotNull PsiElement var1, @NotNull AnnotationHolder var2)
    {
        
    }
    
    
    
    
    
    
    @Nullable
    private static PsiTreeLabelAnalysis ParseArg(int iter, PsiElement line_wrapper) {
        String temp;

        String labelInput = null;
        ArrayList<String> labelOutput = new ArrayList<String>();
        boolean isSafeComm = false;

        PsiElement element[] = line_wrapper.getChildren();
        for (int i = 0; i < element.length; i++) {
            temp = element[i].getNode().toString();
            //Search for Label to call
            if (temp.equals("PsiElement(LABEL_DEF)"))
                labelInput = element[i].getText();
            else if (temp.equals("Element(line)")) {
                PsiElement ANTLRTreeLine[] = element[i].getChildren();
                for (int j = 0; j < ANTLRTreeLine.length; j++) {
                    temp = ANTLRTreeLine[j].toString();
                    //This is special commands, where can'not be goto
                    if (/*temp.equals("PsiElement('EQU')") ||*/ temp.equals("PsiElement('DC')")
                            || temp.equals("PsiElement('DS')")) {
                        //TODO arg check
                        isSafeComm = true;
                        continue;
                    }
                    //This goto commands
                    if (temp.equals("ANTLRPsiNode(arguments)")) {
                        PsiElement anotherElement[] = ANTLRTreeLine[j].getChildren();
                        for (int z = 0; z < anotherElement.length; z++)
                            if (anotherElement[z].toString().equals("ANTLRPsiNode(argument)") &&
                                    anotherElement[z].getFirstChild().getFirstChild() != null) {
                                if (anotherElement[z].getFirstChild().getFirstChild()
                                        .getFirstChild().getNode().toString().equals("LABEL"))
                                    ;
                                temp = anotherElement[z].getFirstChild().getFirstChild()
                                        .getFirstChild().getText();
                                if (temp != null) {
                                    boolean badLabel = false;
                                    char check = temp.toCharArray()[0];
                                    for (int h = 0; h < 10; h++)
                                        if (check == h + 48)/*48 - '0'*/
                                            badLabel = true;
                                    if (check == '*')
                                        badLabel = true;
                                    if (!badLabel)
                                        labelOutput.add(temp);
                                }
                            }
                        anotherElement = null;
                    }
                }
                ANTLRTreeLine = null;
            }
        }
        element = null;
        temp = null;

        return labelInput == null && labelOutput.size() == 0 ?
                null : new PsiTreeLabelAnalysis(iter, isSafeComm, labelInput, labelOutput);
    }

    private static ArrayList<PsiTreeLabelAnalysis> analysisPsiFile(PsiFile psiFile) {
        PsiElement file = psiFile.getChildren()[0];
        PsiElement HlasmLines[];

        PsiTreeLabelAnalysis node;
        ArrayList<PsiTreeLabelAnalysis> analysis = new ArrayList<PsiTreeLabelAnalysis>();

        //for (int i = 0; i < file.length; i++)
        for (int j = 0, size = file.getChildren().length; j < size; j++) {
            HlasmLines = file.getChildren();
            node = ParseArg(j, HlasmLines[j].getFirstChild());
            if (node != null)
                analysis.add(node);
        }
        file = null;
        HlasmLines = null;
        node = null;

        return analysis;
    }

    private static class doubleInt {
        public int begin;
        public int end;

        public doubleInt(int first, int last) {
            begin = first;
            end = last;
        }

        public doubleInt() {
            begin = 0;
            end = 0;
        }
    }
    
    private static ArrayList<PsiTreeLabelAnalysis> analisisHlasmFile(ArrayList<PsiTreeLabelAnalysis> analyses) {
        boolean isCall;
        
        ArrayList<PsiTreeLabelAnalysis> myClone = (ArrayList<PsiTreeLabelAnalysis>)analyses.clone();

        for (int i = 0; i < myClone.size(); i++) {
            if (myClone.get(i).isSafeCommand) {
                myClone.remove(i);
                i--;
            }
        }
        for (int i = 0; i < myClone.size(); i++) {
            isCall = false;
            for (int j = 0; j < myClone.get(i).labelOut.size(); j++) {
                for (int k = 0; k < myClone.size(); k++)
                    if (myClone.get(i).labelOut.get(j).equals(myClone.get(k).labelIn))
                        isCall = true;
                if (!isCall)
                {
                    myClone.get(i).labelOut.remove(j);
                    j--;
                }
            }
            if (myClone.get(i).labelIn == null && myClone.get(i).labelOut.isEmpty())
            {
                myClone.remove(i);
                i--;
            }
        }
        return myClone;
    }
    
    private static ArrayList<PsiTreeLabelAnalysis> analysesLabelReachable(ArrayList<PsiTreeLabelAnalysis> analyses) {
        int first, last;
        String label;

        for (int i = 0, j; i < analyses.size(); i++)
            if (analyses.get(i).labelOut.isEmpty())
                analyses.get(i).isSafeCommand = true;
            else
            {
                label = analyses.get(i).labelOut.get(0);
                first = analyses.get(i).line;
                analyses.get(i).isSafeCommand = true;
                for (j = 0; j < analyses.size(); j++)
                {
                    last = analyses.get(j).line;
                    //Loop
                    if (analyses.get(j).labelIn != null
                            && analyses.get(j).labelIn.equals(label)
                            && analyses.get(j).isSafeCommand)
                    {
                        i = analyses.size();
                        break;
                    }
                    //Unreachable
                    else if (analyses.get(j).labelIn != null
                            && analyses.get(j).labelIn.equals(label)
                            && last != first)
                    {
                        i = j - 1;
                        break;
                    }
                }
            }
        return analyses;
    }
    
    private static ArrayList<doubleInt> analysisLabelCall(ArrayList<PsiTreeLabelAnalysis> analyses) throws InterruptedException {
        
        ArrayList<doubleInt> returnVal = new ArrayList<>();
        boolean isCall = false;
        
        for (int i = 0, j; i < analyses.size(); i++)
            if (!analyses.get(i).isSafeCommand) {
                for (j = i; j < analyses.size(); j++)
                    if (analyses.get(i).isSafeCommand) {
                        returnVal.add(new doubleInt(analyses.get(i - 1).line + 1, analyses.get(j).line - 1));
                        isCall = true;
                    }
            if (!isCall) {
                returnVal.add(new doubleInt(analyses.get(i - 1).line + 1, Integer.MAX_VALUE));
            }
            i = j;
        }
            
        return returnVal;
    }

    private static void whatInTree(ArrayList<PsiTreeLabelAnalysis> tree)
    {
        if (tree == null)
            System.out.println("!Nope!");
        else
            for (int i = 0; i < tree.size(); i++)
                System.out.println(tree.get(i).line + "\t"
                        + tree.get(i).isSafeCommand + "\t"
                        + tree.get(i).labelIn + "\t"
                        + tree.get(i).labelOut);
    }

    private static void whatInInts(ArrayList<doubleInt> tree)
    {
        if (tree == null)
            System.out.println("!Nope!");
        else
            for (int i = 0; i < tree.size(); i++)
                System.out.println(tree.get(i).begin + "\t-\t" + tree.get(i).end);
    }
    
    public static void HighLight(PsiFile psiFile) throws Exception
    {
        ArrayList<doubleInt> HighLightMark;
        try 
        {
            ArrayList<PsiTreeLabelAnalysis> psiTree = analysisPsiFile(psiFile);
            whatInTree(psiTree);
            System.out.println("====");
            ArrayList<PsiTreeLabelAnalysis> hlasmTree = analisisHlasmFile(psiTree);
            whatInTree(hlasmTree);
            System.out.println("====");
            ArrayList<PsiTreeLabelAnalysis> labelCall = analysesLabelReachable(hlasmTree);
            whatInTree(labelCall);
            System.out.println("====");
            HighLightMark = analysisLabelCall(labelCall);
            whatInInts(HighLightMark);
            System.out.println("====");
        }
        catch (AssertionError e)
        {
            throw e;
        }
        
    }

    private class PsiTreeLabelAnalysis
    {
        public int line;
        public boolean isSafeCommand = false;
        public String labelIn = null;
        public List<String> labelOut = null;

        public PsiTreeLabelAnalysis(int lineWithLabel, boolean isSafeComm, String labelInput, String labelOutput[])
        {
            line = lineWithLabel;
            isSafeCommand = isSafeComm;
            labelIn = labelInput;
            for (int i = 0, s = labelOutput.length; i < s; i++)
                labelOut.add(labelOutput[i]);
        }

        public PsiTreeLabelAnalysis(int lineWithLabel, boolean isSafeComm, String labelInput, List<String> labelOutput)
        {
            line = lineWithLabel;
            isSafeCommand = isSafeComm;
            labelIn = labelInput;
            labelOut = labelOutput;
        }
    }
}


