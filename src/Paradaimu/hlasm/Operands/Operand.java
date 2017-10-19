package Paradaimu.hlasm.Operands;

import org.jetbrains.annotations.NotNull;

import javax.xml.bind.DatatypeConverter;
import java.util.Arrays;

/**
 * @author  Paradaimu
 * 14.10.2017
 *  
 * structure:
 *      size: 3
 *      bits: 4
 *      data: 00001001 00010101 011101100
 *            ////|
 * Not use - **** *--- Actual first element
 *    (only zero)     (any data)    
 **/
public class Operand implements BasicOperand {

    private byte[] data;
    private final int bits;
    private final String name;
    
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
    public int getBits() { return bits; }
    
    /**
     * Set new data if they bit's and bytes equal
     * @param value - new data
     **/
    @Override
    public void setData(@NotNull byte[] value) {
        if (data.length == value.length && this.isEqualsToBits(value[0]))
            data = value.clone();
    }
    
    /**
     * Use to prof equals of first byte of new data and count of bits
     * @param firstByte - first byte of new data
     * @return true if equal bits else false
    **/
    @Override
    public boolean isEqualsToBits(byte firstByte) {
        //bool(15)  -> 0000 1111
        //bits == 8 -> 1111 1111
        return (bits == 8 || (firstByte <= (byte)15) && firstByte >= 0);
    }
    
    /**
     * Standard builder of class
     * @param data - actual data in type of operation
     * @param bits - bits of first byte of data
     */
    public Operand(@NotNull byte[] data, int bits, String name){
        this.data = data.clone();
        this.bits = bits;
        this.name = name;
    }

    /**
     * Additional builder of class with lazy data initialization
     * @param bytes - bytes of data
     * @param bits - bits of first byte of data
     */
    public Operand(int bytes, int bits, String name) {
        data = new byte[bytes];
        this.bits = bits;
        this.name = name;
    }

    /**
     * @return real size of data
     */
    @Override
    public int getSizeOfOperand() {
        return 8 * (getSize() - 1) + getBits();
    }
    
    /**
     * @return name (or mnemonic) of class (can be type)
     */
    @Override
    public String getName() {
        return name;
    }

    /**
     * Compare logical two implement of BasicOperand interface
     * @param First - any implement of BasicOperand interface
     * @param Second - any implement of BasicOperand interface
     * @return true if they are equal (not by ref), else false
     */
    public static boolean isEqual(BasicOperand First, BasicOperand Second) {
        return First.getName().equals(Second.getName())
                && First.getSize() == Second.getSize()
                && First.getBits() == Second.getBits()
                && Arrays.equals(First.getData(), Second.getData());
    }

    /**
     * Compare logical implement of this interface to another implement
     * @param Other - class that implement BasicOperand interface
     * @return true - if this object equal to other, else false
     **/
    @Override
    public boolean isEqualTo(BasicOperand Other) {
        return isEqual(this, Other);
    }

    /**
     * Set new data if they bit's and bytes equal
     * @param value - new data, but unformed
     **/
    @Override
    public void setDataAdaptor(byte[] value) {
        //if full byte or 4 bit code > 0 
        if (getBits() == 8 || 
                (value.length == 1 
                        && value[0] >= (byte)0)) setData(value);
        //else if data == 4
        else if (getBits() == 4) {
            String newData = DatatypeConverter.printHexBinary(value);
            //if len % 2 == 0 then not need additional 0
            if (newData.length() % 2 == 0) {
                // if data unformed (8BA0) then -> (08BA)
                if (newData.charAt(0) != '0' 
                        && newData.charAt(newData.length()-1) == '0')
                    newData = "0" + newData.substring(0,newData.length()-1);
                else {
                    setData(value);
                    return;
                }
            }
            else 
                newData = "0" + newData;
            
            setData(DatatypeConverter.parseHexBinary(newData));
        }
        //for readable code
        else return;
    }
}
