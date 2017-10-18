package Paradaimu.hlasm.Operands.Created;

import Paradaimu.hlasm.Operands.Operand;
import org.jetbrains.annotations.NotNull;

public class Mask extends Operand {
    private Mask(int size, int bits) {
        super(size, bits, "M");
    }

    @NotNull
    public static Mask M4() {
        return new Mask(1,4);
    }
}
