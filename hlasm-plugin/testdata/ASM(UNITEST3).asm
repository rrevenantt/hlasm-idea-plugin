          PRINT  NOGEN
          YREGS  ,
UNITEST3  BGNPGM SAVEAREA,31,ANY

CALL1     EQU    *
          B      CALL3

CALL2     EQU    *
          B      CALL3

CALL3     EQU    *
          B      CALL4

CALL4     EQU    *
          B      CALL2                                                    
*UNREACHABLE START
RTRN      EQU    *    
          ENDPGM RC 
*UNREACHABLE END
SAVEAREA  DS     18F             
RC        DC     H'0'
*ANALISIS END
          END    UNITEST3