package Paradaimu.hlasm.Operands.Created;

import Paradaimu.hlasm.Operands.Operand;
import org.jetbrains.annotations.NotNull;

public class Displacement extends Operand {
    private Displacement(byte size, byte bits) {
        super(size,bits);
    }

    @NotNull
    public static Displacement D12() {
        return new Displacement((byte)2,(byte)4);
    }

    @NotNull
    public static Displacement DL12() {
        return new Displacement((byte)2,(byte)4);
    }

    @NotNull
    public static Displacement DH8() {
        return new Displacement((byte)1,(byte)8);
    }
}
