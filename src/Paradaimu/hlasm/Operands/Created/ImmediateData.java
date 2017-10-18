package Paradaimu.hlasm.Operands.Created;

import Paradaimu.hlasm.Operands.Operand;
import org.jetbrains.annotations.NotNull;

public class ImmediateData extends Operand {
    private ImmediateData(int size, int bits) {
        super(size, bits, "I");
    }

    @NotNull
    public static ImmediateData I8() {
        return new ImmediateData(1,8);
    }

    @NotNull
    public static ImmediateData I16() {
        return new ImmediateData(2,8);
    }
    
    @NotNull
    public static ImmediateData I32() {
        return new ImmediateData(4,8);
    }
}
