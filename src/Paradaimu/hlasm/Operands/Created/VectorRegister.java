package Paradaimu.hlasm.Operands.Created;

import Paradaimu.hlasm.Operands.Operand;
import org.jetbrains.annotations.NotNull;

public class VectorRegister extends Operand {
    private VectorRegister(int size, int bits) {
        super(size, bits, "V");
    }

    @NotNull
    public static VectorRegister V4() {
        return new VectorRegister(1,4);
    }
}
