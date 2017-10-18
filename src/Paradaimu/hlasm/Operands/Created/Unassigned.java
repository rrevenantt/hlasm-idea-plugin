package Paradaimu.hlasm.Operands.Created;

import Paradaimu.hlasm.Operands.Operand;
import org.jetbrains.annotations.NotNull;

public class Unassigned extends Operand {
    private Unassigned(int size, int bits){
        super(size, bits, "/");
    }
    
    @NotNull
    public static Unassigned Unassigned4(){
        return new Unassigned(1,4);
    }

    @NotNull
    public static Unassigned Unassigned8(){
        return new Unassigned(1,8);
    }
    
    @NotNull
    public static Unassigned Unassigned16(){
        return new Unassigned(2,8);
    }
}
