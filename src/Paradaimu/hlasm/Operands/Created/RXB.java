package Paradaimu.hlasm.Operands.Created;

import Paradaimu.hlasm.Operands.Operand;
import org.jetbrains.annotations.NotNull;

public class RXB extends Operand {
    private RXB(byte size, byte bits){
        super(size,bits);
    }

    @NotNull
    public static RXB RXB4() {
        return new RXB((byte)1,(byte)4);
    }
}
