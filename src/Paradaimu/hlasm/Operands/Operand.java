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
public abstract class Operand implements BasicOperand {

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
    public short getBits() { return bits; }
    
    /**
     * Set new data if they bit's and bytes equal
     * @param value - new data
     **/
    @Override
    public void setData(byte[] value) {
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
     */
    public Operand(byte[] data, byte bits) {
        this.data = data;
        this.bits = bits;
    }

    /**
     * Additional builder of class with lazy data initialization
     * @param bytes - bytes of data
     * @param bits - bits of first byte of data
     * @throws RangeException - if bytes <= 0
     */
    public Operand(byte bytes, byte bits) throws RangeException {
        try{
        data = new byte[bytes];
        }
        catch (Exception e) {
            throw e;
        }
        finally {
            this.bits = bits;
        }
    }
}
