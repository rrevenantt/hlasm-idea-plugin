package Paradaimu.hlasm.Operands.Created;

import Paradaimu.hlasm.Operands.Operand;
import org.jetbrains.annotations.NotNull;

public class ImmediateData extends Operand {
    private ImmediateData(byte size, byte bits) {
        super(size,bits);
    }

    @NotNull
    public static ImmediateData I8() {
        return new ImmediateData((byte)1,(byte)8);
    }

    @NotNull
    public static ImmediateData I16() {
        return new ImmediateData((byte)2,(byte)8);
    }
    
    @NotNull
    public static ImmediateData I32() {
        return new ImmediateData((byte)4,(byte)8);
    }
}
