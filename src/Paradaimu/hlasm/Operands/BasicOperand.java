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
    **/
    void setData(byte[] data);
    /**
     * get data size (in bytes)
    **/
    int getSize();
    /**
     * get bits (0 - 8) for first byte of data
    **/
    byte getBits();
    /**
     * method for comparing first byte of new value and old data
    **/
    boolean isEqualsToBits(byte firstByte);
}
