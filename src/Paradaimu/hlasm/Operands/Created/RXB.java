package Paradaimu.hlasm.Operands.Created;

import Paradaimu.hlasm.Operands.Operand;
import org.jetbrains.annotations.NotNull;

public class RXB extends Operand {
    private RXB(int size, int bits){
        super(size, bits, "RXB");
    }

    @NotNull
    public static RXB RXB4() {
        return new RXB(1,4);
    }
}
