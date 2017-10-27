          MACRO ,
          MYMACRO &KEYPARM=ONE
          B      &KEYPARM
          MEND ,

          PRINT  NOGEN
          YREGS  ,
UNITEST2  BGNPGM SAVEAREA,31,ANY

CALL1     EQU    *
          LHI    R15,0
          MYMACRO PARM=CALL2
*UNREACHABLE START
          LHI    R15,4
          B      CALL3
*UNREACHABLE END
CALL2     EQU    *
          LHI    R15,4
          B      CALL3
*UNREACHABLE LINE
CALL3     EQU    *
          B      RTRN
*UNREACHABLE LINE
RTRN      EQU    *
          STH    R15,RC
          ENDPGM RC
*ANALISIS END
SAVEAREA  DS     18F
RC        DS     H
          END    UNITEST2