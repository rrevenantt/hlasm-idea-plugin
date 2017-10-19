package Paradaimu.hlasm.Operands.Created;

import Paradaimu.hlasm.Operands.Operand;
import org.jetbrains.annotations.NotNull;

public class Index extends Operand {
    private Index(int size, int bits) {
        super(size, bits, "X");
    }

    @NotNull
    public static Index X4() {
        return new Index(1,4);
    }
}
