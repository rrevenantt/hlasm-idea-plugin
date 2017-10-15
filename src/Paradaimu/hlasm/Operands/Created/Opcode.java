package Paradaimu.hlasm.Operands.Created;

import Paradaimu.hlasm.Operands.Operand;
import org.jetbrains.annotations.NotNull;

public class Opcode extends Operand {
    private Opcode(byte size, byte bits) {
        super(size,bits);
    }

    @NotNull
    public static Opcode Opcode4() {
        return new Opcode((byte)1,(byte)4);
    }
    
    @NotNull
    public static Opcode Opcode8() {
        return new Opcode((byte)1,(byte)8);
    }
    
    @NotNull
    public static Opcode Opcode16() { 
        return new Opcode((byte)2,(byte)8); 
    }
}
