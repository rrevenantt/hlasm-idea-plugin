package Paradaimu.hlasm.Operands.Created;

import Paradaimu.hlasm.Operands.Operand;
import org.jetbrains.annotations.NotNull;

public class SignedBinaryIntegerDesignating extends Operand {
    private SignedBinaryIntegerDesignating(byte size, byte bits) {
        super(size,bits);
    }

    @NotNull
    public static SignedBinaryIntegerDesignating RI12() {
        return new SignedBinaryIntegerDesignating((byte)2,(byte)4);
    }

    @NotNull
    public static SignedBinaryIntegerDesignating RI16() {
        return new SignedBinaryIntegerDesignating((byte)2,(byte)8);
    }

    @NotNull
    public static SignedBinaryIntegerDesignating RI24() {
        return new SignedBinaryIntegerDesignating((byte)3,(byte)8);
    }

    @NotNull
    public static SignedBinaryIntegerDesignating RI32() {
        return new SignedBinaryIntegerDesignating((byte)4,(byte)8);
    }
}
