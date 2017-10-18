package Paradaimu.hlasm.Operands.Created;

import Paradaimu.hlasm.Operands.Operand;
import org.jetbrains.annotations.NotNull;

public class Base extends Operand {
    private Base(int size, int bits) {
        super(size,bits,"B");
    }

    @NotNull
    public static Base B4() {
        return new Base(1,4);
    }
}
