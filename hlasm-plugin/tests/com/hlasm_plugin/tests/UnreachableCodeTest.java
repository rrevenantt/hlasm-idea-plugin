package com.hlasm_plugin.tests;

import com.hlasm_plugin.inspections.UnreachableCode.*;
import com.hlasm_plugin.inspections.UnreachableCode.HlasmPsiViewer;
import com.intellij.openapi.diagnostic.Logger;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.testFramework.fixtures.LightPlatformCodeInsightFixtureTestCase;

public class UnreachableCodeTest extends LightPlatformCodeInsightFixtureTestCase
{
    private PsiFile myTestFile;
    private static final Logger LOG = Logger.getInstance("#com.intellij.psi.impl.PsiManagerImpl");
        
    @Override
    public void setUp() throws Exception {
        super.setUp();
        System.out.println("setting up test");
        LOG.isDebugEnabled();
    }

    @Override
    protected String getTestDataPath() {
        return super.getTestDataPath()+"hlasm-plugin/testdata/";
    }
    
    public void testCheck1() throws Exception 
    {
        myTestFile = myFixture.configureByFile("ASM(UNITEST3).asm");
        try
        {
            HlasmPsiViewer a = new HlasmPsiViewer()
            {
                @Override
                public int PsiViewerEnd(PsiElement element) {
                    System.out.println(element.getText() + " " + (element.getNode()).getElementType().toString());
                    return -1;
                }
            };
            a.PsiViewer(myTestFile.getChildren()[0]);
        }
        catch (AssertionError e)
        {
            throw e;
        }
    }
    
    
    public void testCheck2() throws Exception {
        myTestFile = myFixture.configureByFile("ASM(UNITEST1).asm");
        try {
            HlasmUnreachableCode.HighLight(myTestFile);
            System.out.println("=====");
        } catch (AssertionError e) {
            throw e;
        }
    }

    public void testCheck3() throws Exception {
        myTestFile = myFixture.configureByFile("ASM(UNITEST2).asm");
        try {
            HlasmUnreachableCode.HighLight(myTestFile);
            System.out.println("=====");
        } catch (AssertionError e) {
            throw e;
        }
    }

    public void testCheck4() throws Exception {
        myTestFile = myFixture.configureByFile("ASM(UNITEST3).asm");
        try {
            HlasmUnreachableCode.HighLight(myTestFile);
            System.out.println("=====");
        } catch (AssertionError e) {
            throw e;
        }
    }
    
    public void testCheck5() throws Exception
    {
        myTestFile = myFixture.configureByFile("ASM(FIRSTASK).asm");
        try {
            HlasmUnreachableCode.HighLight(myTestFile);
            System.out.println("=====");
        } catch (AssertionError e) {
            throw e;
        }
    }
}