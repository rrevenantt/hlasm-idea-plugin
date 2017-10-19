package Paradaimu.hlasm.Operands;

import org.jetbrains.annotations.NotNull;
/**
 * @author  Paradaimu
 * 14.10.2017
 * 
 * Interface for any operand
 */
public interface BasicOperand {
    
    /**
     * return data
    **/
    @NotNull
    byte[] getData();
    
    /**
     * set new data
     * @param data - formed, first byte can't use unassigned bits
    **/
    void setData(byte[] data);
    
    /**
     * get data size (in bytes)
    **/
    int getSize();
    
    /**
     * get bits (0 - 8) for first byte of data
    **/
    int getBits();
    
    /**
     * method for comparing first byte of new value and old data
    **/
    boolean isEqualsToBits(byte firstByte);
    
    /**
     * @return real size of operand in bit
    **/
    int getSizeOfOperand();
    
    /**
     * It's need to compare to equal any Operand class
     * @return name of operand
    **/
    String getName();
    
    /**
     * Compare logical implement of this interface to another implement
     * @param Other - class that implement BasicOperand interface
     * @return true - if this object equal to other, else false
    **/
    boolean isEqualTo(BasicOperand Other);

    /**
     * set new data
     * @param data - unformed, first byte can use unassigned bits
     */
    void setDataAdaptor(byte[] data);
}
