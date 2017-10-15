package Paradaimu.hlasm.Operands.Created;

import Paradaimu.hlasm.Operands.Operand;
import org.jetbrains.annotations.NotNull;

public class Index extends Operand {
    private Index(byte size, byte bits) {
        super(size,bits);
    }

    @NotNull
    public static Index X4() {
        return new Index((byte)1,(byte)4);
    }
}
