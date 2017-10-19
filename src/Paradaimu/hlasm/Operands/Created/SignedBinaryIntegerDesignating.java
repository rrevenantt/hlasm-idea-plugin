package Paradaimu.hlasm.Operands.Created;

import Paradaimu.hlasm.Operands.Operand;
import org.jetbrains.annotations.NotNull;

public class SignedBinaryIntegerDesignating extends Operand {
    private SignedBinaryIntegerDesignating(int size, int bits) {
        super(size, bits, "RI");
    }

    @NotNull
    public static SignedBinaryIntegerDesignating RI12() {
        return new SignedBinaryIntegerDesignating(2,4);
    }

    @NotNull
    public static SignedBinaryIntegerDesignating RI16() {
        return new SignedBinaryIntegerDesignating(2,8);
    }

    @NotNull
    public static SignedBinaryIntegerDesignating RI24() {
        return new SignedBinaryIntegerDesignating(3,8);
    }

    @NotNull
    public static SignedBinaryIntegerDesignating RI32() {
        return new SignedBinaryIntegerDesignating(4,8);
    }
}
