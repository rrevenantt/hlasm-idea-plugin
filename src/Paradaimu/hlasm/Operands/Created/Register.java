package Paradaimu.hlasm.Operands.Created;

import Paradaimu.hlasm.Operands.Operand;
import org.jetbrains.annotations.NotNull;

public class Register extends Operand {
    private Register(int size, int bits){
        super(size, bits, "R");
    }
    
    @NotNull
    public static Register R4() {
        return new Register(1,4);
    }
}
