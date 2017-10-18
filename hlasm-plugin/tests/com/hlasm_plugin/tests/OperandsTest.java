package com.hlasm_plugin.tests;

import Paradaimu.hlasm.Operands.*;
import Paradaimu.hlasm.Operands.Created.*;
import com.intellij.testFramework.fixtures.LightPlatformCodeInsightFixtureTestCase;

public class OperandsTest extends LightPlatformCodeInsightFixtureTestCase {
    
    @Override
    public void setUp() throws Exception {
        super.setUp();
        System.out.println("setting up test");
    }
    
    public void test_01(){
        Register R1 = Register.R4();
        byte[] a = new byte[1];
        a[0] = Byte.parseByte("00000001");
        R1.setData(a);
        System.out.println((Byte.compare(ByteMask.LastOne(R1.getBits()), a[0]) >= 0));
        System.out.println(Byte.parseByte("00000001") + " " + R1.getData()[0] + "\t" + R1.getBits() + "\t" + R1.getSize());
        OutMessage(R1);
    }
    
    public void test_02(){
        Opcode Op4 = Opcode.Opcode4();
        byte[] a = new byte[1];
        a[0] = (byte)(-110);
        Op4.setData(a);
        OutMessage(Op4);
        a[0] = (byte)(14);
        Op4.setData(a);
        OutMessage(Op4);
    }

    public void test_03(){
        Opcode Op8 = Opcode.Opcode8();
        byte[] a = new byte[1];
        a[0] = (byte)(-110);
        Op8.setData(a);
        OutMessage(Op8);
    }
    
    public void test_04(){
        byte[] a = new byte[3];
        for (int i = 0; i < 3; i++)
            System.out.println(a[i]);
    }
    
    private void OutMessage(Operand a)
    {
        for (int i = 0; i < a.getSize(); i++)
            System.out.print(a.getData()[i] + "\t");
        System.out.println("|\t"  + a.getBits() + "\t" + a.getSize());
    }
}
