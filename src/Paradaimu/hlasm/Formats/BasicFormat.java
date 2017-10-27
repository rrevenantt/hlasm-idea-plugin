package Paradaimu.hlasm.Formats;

import Paradaimu.hlasm.Opcodes.OpcodeType;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author Paradaimu
 * 20.10.2017
 */
public interface BasicFormat {
    /**
     * @return 1, 2 or 3 word size
     */
    int getSizeOfFormat();
    
    String getName();
    
    byte[] getData();

    /**
     * TODO For future
     * @return Variable formats
     */
    String[] getAllForm();

    BasicFormat getSubFormat(String form);
    
    BasicFormat[] getAllSubFormat();
    
    void setData();
    
    boolean isEqualTo(BasicFormat other);
    
    boolean isTypeOfFormat();
}
