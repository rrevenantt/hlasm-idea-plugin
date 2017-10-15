package Paradaimu.hlasm.Operands.Created;

import Paradaimu.hlasm.Operands.Operand;
import org.jetbrains.annotations.NotNull;

public class Unassigned extends Operand {
    private Unassigned(byte size, byte bits){
        super(size,bits);
    }
    
    @NotNull
    public static Unassigned Unassigned4(){
        return new Unassigned((byte)1,(byte)4);
    }

    @NotNull
    public static Unassigned Unassigned8(){
        return new Unassigned((byte)1,(byte)8);
    }
    
    @NotNull
    public static Unassigned Unassigned16(){
        return new Unassigned((byte)2,(byte)8);
    }
}
