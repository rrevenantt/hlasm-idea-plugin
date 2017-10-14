* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
* MACROS MYBRANCH(LABEL,LABEL)                                        *
* TEST MACROS FOR TESTING IN HLASM-IDEA-PLUGIN                        *
* LINKAGE:                                                            *
*      R3: FIRST ARGUMENT                                             *
*      R4: SECOND ARGUMENT                                            *
* RESULT:                                                             *
* R3 = R4: NEXT COMMAND AFTER MACRO                                   *
* R3 < R4: BRANCH TO &LABELA                                          *
* R3 > R4: BRANCH TO &LABELB                                          *
* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
         MACRO ,
         MYBRANCH &LABELA,&LABELB
         CLR    R3,R4
         BLR    &LABELA
         BHR    &LABELB
         MEND ,
* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
* UNIT TEST 1: MACRO BRANCH                                           *
* CREATE: PARADAIMU                                                   *
* FOR HLASM-IDEA-PLUGIN                                               *
* DATE: 07.10.2017                                                    *
* LINKAGE:                                                            *
*     R13: SAVE AREA                                                  *
*     R14: RETURN ADDRESS                                             *
* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
         PRINT  NOGEN
         YREGS  ,
UNITEST1 BGNPGM SAVEAREA,31,ANY
         LA     R3,15
         LA     R4,30
         MYBRANCH CALL1,CALL2
         B      RTRN
*UNREACHABLE LINE
CALL1    DS     0H
         B      RTRN
*UNREACHABLE LINE
CALL2    DS     0H
         B      RTRN
*UNREACHABLE LINE
RTRN     EQU    *
         LHI    R15,0
         STH    R15,RC
         ENDPGM RC
*ANALISIS END         
SAVEAREA DS    18F
RC       DS    H
         END   UNITEST1