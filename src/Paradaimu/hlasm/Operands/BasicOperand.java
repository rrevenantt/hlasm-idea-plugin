package Paradaimu.hlasm.Operands;

import org.jetbrains.annotations.NotNull;

public interface BasicOperand {
    @NotNull
    byte[] getData();
    
    void setData(byte[] data);
    
    int getSize();

    short getBits();
    
    boolean isEqualsToBits(byte firstByte);
}
