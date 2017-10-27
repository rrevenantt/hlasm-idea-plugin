package com.hlasm_plugin.inspections.UnreachableCode;

import java.util.List;

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
