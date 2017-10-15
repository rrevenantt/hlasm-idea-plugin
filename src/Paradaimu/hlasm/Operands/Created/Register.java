package Paradaimu.hlasm.Operands.Created;

import Paradaimu.hlasm.Operands.Operand;
import org.jetbrains.annotations.NotNull;

public class Register extends Operand {
    private Register(byte size, byte bits){
        super(size,bits);
    }
    
    @NotNull
    public static Register R4() {
        return new Register((byte)1,(byte)4);
    }
}
