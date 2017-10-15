package Paradaimu.hlasm.Operands.Created;

import Paradaimu.hlasm.Operands.Operand;
import org.jetbrains.annotations.NotNull;

public class Base extends Operand {
    private Base(byte size, byte bits) {
        super(size,bits);
    }

    @NotNull
    public static Base B4() {
        return new Base((byte)1,(byte)4);
    }
}
