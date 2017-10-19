package Paradaimu.hlasm.Operands.Created;

import Paradaimu.hlasm.Operands.Operand;
import org.jetbrains.annotations.NotNull;

public class Opcode extends Operand {
    private Opcode(int size, int bits) {
        super(size, bits, "Opcode");
    }

    @NotNull
    public static Opcode Opcode4() {
        return new Opcode(1,4);
    }
    
    @NotNull
    public static Opcode Opcode8() {
        return new Opcode(1,8);
    }
    
    @NotNull
    public static Opcode Opcode16() { 
        return new Opcode(2,8); 
    }
}
