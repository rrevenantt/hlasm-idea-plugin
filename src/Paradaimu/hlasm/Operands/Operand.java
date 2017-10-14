package Paradaimu.hlasm.Operands;

import org.jetbrains.annotations.NotNull;
import org.w3c.dom.ranges.RangeException;

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
     * return data field 
    **/
    @NotNull
    @Override
    public byte[] getData(){ return data; }
    
    /**
     * return byte's in data
    **/
    @Override
    public int getSize() { return data.length; }
    
    /**
     * return bit's in FIRST byte of data
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
    **/
    @Override
    public boolean isEqualsToBits(byte firstByte) {
        return (Byte.compare(ByteMask.FirstOne(bits), firstByte) >= 0);
    }

    /**
     * Standard builder of class
     * @param data - actual data in type of operation
     * @param bits - bits of first byte of data
     * @throws Exception - if bits > 8 or bits < 0
     */
    public Operand(@NotNull byte[] data, byte bits) throws Exception {
        this.data = data;
        if (bits > 8 || bits < 0)
            throw new Exception("Bits can't be more than 8 or less than 0");
        this.bits = bits;
        
    }

    /**
     * Additional builder of class with lazy data initialization
     * @param bytes - bytes of data
     * @param bits - bits of first byte of data
     * @throws RangeException - if bytes <= 0
     * or
     * @throws Exception - if bits > 8 or bits < 0
     */
    public Operand(byte bytes, byte bits) throws Exception {
        try{
        data = new byte[bytes];
        if (bits > 8 || bits < 0)
            throw new Exception("Bits can't be more than 8 or less than 0");
        this.bits = bits;
        }
        catch (Exception e) {
            throw e;
        }
    }
}
