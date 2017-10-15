package Paradaimu.hlasm.Operands.Created;

import Paradaimu.hlasm.Operands.Operand;
import org.jetbrains.annotations.NotNull;

public class Length extends Operand {
    private Length(byte size, byte bits) {
        super(size,bits);
    }

    @NotNull
    public static Length L4() {
        return new Length((byte)1,(byte)4);
    }

    @NotNull
    public static Length L8() {
        return new Length((byte)1,(byte)8);
    }
}
