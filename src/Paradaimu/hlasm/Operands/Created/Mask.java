package Paradaimu.hlasm.Operands.Created;

import Paradaimu.hlasm.Operands.Operand;
import org.jetbrains.annotations.NotNull;

public class Mask extends Operand {
    private Mask(byte size, byte bits) {
        super(size,bits);
    }

    @NotNull
    public static Mask M4() {
        return new Mask((byte)1,(byte)4);
    }
}
