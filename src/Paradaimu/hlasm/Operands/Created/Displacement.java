package Paradaimu.hlasm.Operands.Created;

import Paradaimu.hlasm.Operands.Operand;
import org.jetbrains.annotations.NotNull;

public class Displacement extends Operand {
    private Displacement(int size, int bits, String name) {
        super(size, bits, name);
    }

    @NotNull
    public static Displacement D12() {
        return new Displacement(2,4, "D");
    }

    @NotNull
    public static Displacement DL12() {
        return new Displacement(2,4, "DL");
    }

    @NotNull
    public static Displacement DH8() {
        return new Displacement(1,8, "DH");
    }
}
