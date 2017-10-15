package Paradaimu.hlasm.Operands;

import org.jetbrains.annotations.NotNull;

/**
 * @author  Paradaimu
 * 14.10.2017
 *  
 * structure:
 *      bits: 00000011 (3)
 *      data: 00000111 00010101 011101100
 *            |////|
 *   Not use -**** *--- Actual first element
 *    (only zero)     (any data)    
 **/
public class Operand implements BasicOperand {

    private byte[] data;
    private final byte bits;
   
    /**
     * @return data field 
    **/
    @NotNull
    @Override
    public byte[] getData(){ return data; }
    
    /**
     * @return byte's in data
    **/
    @Override
    public int getSize() { return data.length; }
    
    /**
     * @return bit's in FIRST byte of data
    **/
    @Override
    public byte getBits() { return bits; }
    
    /**
     * Set new data if they bit's and bytes equal
     * @param value - new data
     **/
    @Override
    public void setData(@NotNull byte[] value) {
        if (data.length == value.length && this.isEqualsToBits(value[0]))
            data = value;
    }
    
    /**
     * Use to prof equals of first byte of new data and count of bits
     * @param firstByte - first byte of new data
     * @return true if equal bits else false
    **/
    @Override
    public boolean isEqualsToBits(byte firstByte) {
        return (ByteMask.LastOne(bits) < (byte) 0
                || (firstByte <= ByteMask.LastOne(bits)) && firstByte >= 0);
    }

    /**
     * Standard builder of class
     * @param data - actual data in type of operation
     * @param bits - bits of first byte of data
     */
    public Operand(@NotNull byte[] data, byte bits){
        this.data = data;
        this.bits = bits;
    }

    /**
     * Additional builder of class with lazy data initialization
     * @param bytes - bytes of data
     * @param bits - bits of first byte of data
     */
    public Operand(byte bytes, byte bits) {
        data = new byte[bytes];
        this.bits = bits;
    }
    
}
