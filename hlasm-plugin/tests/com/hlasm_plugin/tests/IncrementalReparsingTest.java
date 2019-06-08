package com.hlasm_plugin.tests;

import com.intellij.openapi.application.ApplicationManager;
import com.intellij.openapi.command.CommandProcessor;
import com.intellij.openapi.command.impl.UndoManagerImpl;
import com.intellij.openapi.components.ServiceManager;
import com.intellij.openapi.fileEditor.FileEditorManager;
import com.intellij.openapi.fileTypes.FileType;
import com.intellij.openapi.fileTypes.FileTypeRegistry;
import com.intellij.psi.PsiFile;
import com.intellij.psi.PsiFileFactory;
import com.intellij.psi.impl.DebugUtil;
import com.intellij.psi.text.BlockSupport;
import com.intellij.testFramework.fixtures.LightPlatformCodeInsightFixtureTestCase;
import com.intellij.util.IncorrectOperationException;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;

import java.util.Random;

public class IncrementalReparsingTest extends LightPlatformCodeInsightFixtureTestCase {
    private PsiFile myTestFile;
    private int myInsertOffset = 0;

    @Override
    public void setUp() throws Exception {
        super.setUp();
        System.out.println("setting up test");
    }


    public void testReparsing3() throws Exception{
        myTestFile = myFixture.configureByFile("test4.asm");

//        myFixture.checkHighlighting();

        Random random = new Random();
        String textStructureBefore = "";
        String textStructureAfter = "";
        String textStructureAfter2 = "";
        String result = "";
//        for (int i = 0; i < 100; i+=1) {
        try {
            while (true) {
//            System.out.println(TreeUtil.findFirstLeaf(myTestFile.getNode()).getText());
//        myFixture.checkHighlighting();
                if (myInsertOffset >= myTestFile.getTextLength())
                    break;
                System.out.println("------------------------ next reparse test ---------------------------- "+ myInsertOffset);
//        delete(5);
                textStructureBefore = DebugUtil.treeToString(myTestFile.getNode(),false,true);
//                insert("A");
                insert("\n");
//                delete(random.nextInt(50)+1);
                System.out.println("------------------------ reverting");
                Thread.sleep(100);
//            System.out.println(TreeUtil.findFirstLeaf(myTestFile.getNode()).getText());
                textStructureAfter = DebugUtil.treeToString(myTestFile.getNode(),false,true);
//                DocumentCommitThread.getInstance().waitForAllCommits();
//                time = System.nanoTime();
                UndoManagerImpl.getInstance(myFixture.getProject()).undo(
                        FileEditorManager.getInstance(myFixture.getProject()).getSelectedEditor(myTestFile.getVirtualFile()));

//                System.out.println("parsing time: " + (System.nanoTime() - time));
                textStructureAfter2 = DebugUtil.treeToString(myTestFile.getNode(),false,true);
                result = textStructureAfter + textStructureAfter2 + textStructureBefore;
//                DocumentCommitThread.getInstance().waitForAllCommits();
                myInsertOffset += random.nextInt(10);
            }
        }
        catch (AssertionError e){
//            System.out.println(textStructureBefore + "-------------\n" + textStructureAfter);
            throw e;
        }

    }


    protected void delete(final int length){
        String oldText = myTestFile.getText();
        String expectedNewText = oldText.substring(0, myInsertOffset) + oldText.substring(Math.min(myInsertOffset+length,oldText.length()));
        check(expectedNewText , "", length);
    }

    protected void insert(@NonNls final String s) throws IncorrectOperationException {
        String oldText = myTestFile.getText();
        String expectedNewText = oldText.substring(0, myInsertOffset) + s + oldText.substring(Math.min(myInsertOffset,oldText.length()));
        check(expectedNewText, s, 0);
    }
    protected void check(@NonNls final String expectedNewText,String s, int length) throws IncorrectOperationException {
        CommandProcessor.getInstance().executeCommand(getProject(), () -> ApplicationManager.getApplication().runWriteAction(() -> {


            doReparseAndCheck(s, expectedNewText, length);
            myInsertOffset += s.length();
        }), "asd", null);
    }


    private void doReparseAndCheck(final String s, final String expectedNewText, final int length) throws IncorrectOperationException {
        long time = System.currentTimeMillis();
        doReparse(s, length);
        System.out.println("parsing time: " + (System.currentTimeMillis() - time));
        String foundStructure = DebugUtil.treeToString(myTestFile.getNode(), false);
        System.out.println("--------------------- parse from scratch");
        final PsiFile psiFile = createDummyFile(getName() + "." + myTestFile.getFileType().getDefaultExtension(), expectedNewText);
        String expectedStructure = DebugUtil.treeToString(psiFile.getNode(), false);
        assertEquals(expectedStructure, foundStructure);

        assertEquals("Reparse tree should be equal to the document", expectedNewText, myTestFile.getText());
    }

    protected void doReparse(final String s, final int length) {
        CommandProcessor.getInstance().executeCommand(getProject(), () -> ApplicationManager.getApplication().runWriteAction(() -> {
            BlockSupport blockSupport = ServiceManager.getService(getProject(), BlockSupport.class);
            blockSupport.reparseRange(myTestFile, myInsertOffset , Math.min(myTestFile.getTextLength(),myInsertOffset + length), s);
        }), "asd", null);
    }

    protected PsiFile createDummyFile(@NotNull String fileName, @NotNull String text) throws IncorrectOperationException {
        FileType type = FileTypeRegistry.getInstance().getFileTypeByFileName(fileName);
        return PsiFileFactory.getInstance(getProject()).createFileFromText(fileName, type, text);
    }


    @Override
    protected String getTestDataPath() {
        return super.getTestDataPath()+"hlasm-plugin/testdata/";
    }
}
