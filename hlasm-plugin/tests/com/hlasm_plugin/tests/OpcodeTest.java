package com.hlasm_plugin.tests;

import Paradaimu.hlasm.Opcodes.Opcodes;
import com.intellij.testFramework.fixtures.LightPlatformCodeInsightFixtureTestCase;

import java.io.*;

public class OpcodeTest extends LightPlatformCodeInsightFixtureTestCase {

    @Override
    public void setUp() throws Exception {
        super.setUp();
        System.out.println("setting up test");
    } 
    
    public void test_01() {
        System.out.println(Opcodes.opcodes.size());
        File file = new File("C:\\Users\\theni\\Documents\\GitHub\\hlasm-idea-plugin\\src\\Paradaimu\\hlasm\\Opcodes\\DataOfOperations\\s390-opc.txt");
       
        
        Opcodes.ReadFileWithOpcodes(file);
        System.out.println(Opcodes.opcodes.size());
        
        
    }
}
