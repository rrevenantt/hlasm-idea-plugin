package Paradaimu.hlasm.Operands;

public class ByteMask {
    public static byte FirstZero(byte integer) {
        switch (integer) {
            case 0: return -128;    //1111 1111
            case 1: return 127;     //0111 1111
            case 2: return 63;      //0011 1111
            case 3: return 31;      //0001 1111
            case 4: return 15;      //0000 1111
            case 5: return 7;       //0000 0111
            case 6: return 3;       //0000 0011
            case 7: return 1;       //0000 0001
            default: return 0;      //0000 0000
        }
    }

    public static byte LastZero(byte integer) {
        switch (integer) {
            case 0: return -128;    //1111 1111
            case 1: return -127;    //1111 1110
            case 2: return -125;    //1111 1100
            case 3: return -121;    //1111 1000
            case 4: return -113;    //1111 0000
            case 5: return -97;     //1110 0000
            case 6: return -65;     //1100 0000
            case 7: return -1;      //1000 0000
            default: return 0;      //0000 0000
        }
    }
    
    public static byte FirstOne(byte integer) {
        switch (integer) {
            case 1: return -1;      //1000 0000
            case 2: return -65;     //1100 0000
            case 3: return -97;     //1110 0000
            case 4: return -113;    //1111 0000
            case 5: return -121;    //1111 1000
            case 6: return -125;    //1111 1100
            case 7: return -127;    //1111 1110
            case 8: return -128;    //1111 1111
            default: return 0;      //0000 0000
        }
    }

    public static byte LastOne(byte integer) {
        switch (integer) {
            case 1: return 1;       //0000 0001
            case 2: return 3;       //0000 0011
            case 3: return 7;       //0000 0111
            case 4: return 15;      //0000 1111
            case 5: return 31;      //0001 1111
            case 6: return 63;      //0011 1111
            case 7: return 127;     //0111 1111
            case 8: return -128;    //1111 1111
            default: return 0;      //0000 0000
        }
    }
}
