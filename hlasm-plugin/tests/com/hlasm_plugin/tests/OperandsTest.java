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

    public void test_05(){
        Register Reg = Register.R4();
        byte[] data = new byte[1];
        data[0] = 8;
        Reg.setDataAdaptor(data);
        OutMessage(Reg);
        data[0] = -16;
        OutMessage(Reg);
        Register Reg2 = Register.R4();
        Reg2.setDataAdaptor(data);
        OutMessage(Reg2);
        System.out.println(Reg.isEqualTo(Reg2));
        data[0] = 8;
        Reg2.setData(data);
        System.out.println(Register.isEqual(Reg,Reg2));
        Opcode Op = Opcode.Opcode8();
        System.out.println(Operand.isEqual(Reg,Op));
        System.out.println(Operand.isEqual(Reg,Reg2));
    }
    
    private void OutMessage(Operand a)
    {
        for (int i = 0; i < a.getSize(); i++)
            System.out.print(a.getData()[i] + "\t");
        System.out.println(" | "  + a.getBits() + " | " + a.getSize() 
                + " | "  + a.getSizeOfOperand() + " | "  + a.getName());
    }
}
