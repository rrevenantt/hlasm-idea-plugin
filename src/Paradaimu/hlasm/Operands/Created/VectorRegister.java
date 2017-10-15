package Paradaimu.hlasm.Operands.Created;

import Paradaimu.hlasm.Operands.Operand;
import org.jetbrains.annotations.NotNull;

public class VectorRegister extends Operand {
    private VectorRegister(byte size, byte bits) {
        super(size,bits);
    }

    @NotNull
    public static VectorRegister V4() {
        return new VectorRegister((byte)1,(byte)4);
    }
}
