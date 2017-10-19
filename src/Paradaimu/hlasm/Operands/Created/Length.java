package Paradaimu.hlasm.Operands.Created;

import Paradaimu.hlasm.Operands.Operand;
import org.jetbrains.annotations.NotNull;

public class Length extends Operand {
    private Length(int size, int bits) {
        super(size, bits,"L");
    }

    @NotNull
    public static Length L4() {
        return new Length(1,4);
    }

    @NotNull
    public static Length L8() {
        return new Length(1,8);
    }
}
