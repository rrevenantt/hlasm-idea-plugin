CLATTERM TITLE 'CLATTERM CLAY Terminal TASK MODULE'
***********************************************************************
*                                                                     *
*** MODULE: CLATTERM                                                  *
*                                                                     *
*** DESCRIPTION: CLAY Terminal TASK MODULE                            *
*                                                                     *
*** ATTR: AMODE(31), RMODE(ANY), KEY 0, SUPER STATE                   *
*                                                                     *
*** LOAD: BY THE CLAY LOADER AT IPL TIME                              *
*                                                                     *
*                                                                     *
*** LINKAGE:                                                          *
*                                                                     *
*                                                                     *
*** REGISTERS:                                                        *
*   IN GENERAL THE ROUTINES WILL FOLLOW THE CONVENTION BELOW.         *
*                                                                     *
*   R13 SAVE AREA AND WORK AREA POINTER                               *
*   R12 CONSTANT BASE                                                 *
*   R11 CVT                                                           *
*   R10 TASK                                                          *
*   R0  PSA                                                           *
*                                                                     *
*                                                                     *
*********                                                             *
* HISTORY:                                                            *
* __DATE__  WHO  _________________CHANGE_DESCRIPTION_________________ *
* 09/06/07  DEL  BASE                                                 *
* 02/28/11  JJD  Move user data to macro, add various EVME msgs:      *
*                ECNL0013 FAILED LOGIN ATTEMPT BY user ON TERMNL xxxx *
*                ECNL0014 LOGIN BY user ON TERMINAL xxxx              *
*                ECNL0015 USER user LOGGED OFF TERMINAL xxxx          *
*                ECNL0016 USER user UNDIALED TERMINAL xxxx            *
* 06/28/11  JJD  a) Add more detailed messages for login failure@110628
*                   (controlled by the LOCKDOWN flag)           @110628
*                b) Add error message when returning from the   @110628
*                   EDIT function with a non-zero return code.  @110628
*                c) Allow EVME Login screen to exit via PF3.    @110628
*                   This is equivalent to entering '=u'.        @110628
*                d) Under EVME, if the CLATTERM ESTAE catches   @110628
*                   an abend, it will 'logoff' the terminal.    @110628
*                   The user will be presented with the login   @110628
*                   screen and a message in the lower right     @110628
*                   hand corner of the screen.                  @110628
*                e) Call @WAITIO Q=TASK,EMPTY=RETURN prior to   @110628
*                   issuing @CNSLIO write for the login screen. @110628
*                   This prevents a recursive 01E RSN 2 abend   @110628
*                   in CLSSCH.                                  @110628
* 07/26/11  JJD  Establish CLATTERM ESTAE as soon as possible.    @1001
* @110805   DJB  Support 3215 and other line devices as consoles      *
* 10/21/11  Jon  Add PLOFAIL for DLLQ F=NEXT                    @111021
* @111024   DJB  Ready promot for telnet consoles                     *
* 11/30/11  MAM  add build version                              @111130
* @120214   DJB  Skip echo when streaming JCL                         *
* @120607   DJB  Use different field for streaming                    *
* @130201   DJB  Avoid destructive save area chaining (CLAEDIT)       *
* @130306   DJB  Avoid destructive save area chaining for =L, too     *
* @130409   MHS  Don't use TASK_TRASH to store INTRDR file            *
* @130613   DJB  Fix resume code for VSE and Console (for panels)     *
* @131018   DJB  Dynamic screens.                                     *
* @140424   DJB  SPLTPRM to customize EVME vs. Clay panel text        *
* @140303   DJB  If the name of a module, try calling the program     *
* @150204   DJB  Add ENVBLOCK for program execution from menu.        *
* @150312   DJB  Clean up telnet console routing.  Common @WTO rtn.   *
* @150318   DJB  Require leading '!' for program execution (@140303)  *
* @160427   Jon  Change format of Linux Version Display               *
* @160705   DJB  Replace TR menu option with Jlog option              *
* @160706   DJB  Allow terminal sessions to be extracted from log     *
* @160921   DJB  "Command not supported" message can disappear        *
*                                                                     *
***********************************************************************

         COPY  @CLVARS                      Global ASM variables.
         ASMMREL   ON                       Relative processing.
         COPY  ASMMSP                       HLASM
B        OPSYN J
BE       OPSYN JE
BZ       OPSYN JZ
BNE      OPSYN JNE
BNZ      OPSYN JNZ
BAL      OPSYN BRAS
BCT      OPSYN JCT

***********************************************************************
*                                                                     *
* Name:                                                               *
*                                                                     *
*        STRLEN                                                       *
*                                                                     *
* Descripion:                                                         *
*                                                                     *
*        Obtain the string length for a character string              *
*                                                                     *
* On Exit:                                                            *
*                                                                     *
*        R1  -> Terminating NULL or Blank                             *
*        R15 -  String length                                         *
*                                                                     *
***********************************************************************
         MACRO    ,
&LABEL   STRLEN   &STRING
         LA       R14,&STRING              -> String
         LA       R15,L'&STRING            String max length
         LA       R1,0(R15,R14)            -> end+1
STRLOOP&SYSNDX    DS  0H
         BCTR     R1,0                     -> previous character
         CLI      0(R1),X'00'              A trailing NULL?
         BE       STRNEXT&SYSNDX           No
         CLI      0(R1),C' '               A trailing blank?
         BNE      STRDONE&SYSNDX           No
STRNEXT&SYSNDX    DS  0H                   -> previous character
         BCT      R15,STRLOOP&SYSNDX       Continue if anything left
         B        STRNULL&SYSNDX           Null string
STRDONE&SYSNDX    DS  0H
         LA       R1,1(R1)                 -> First trailing NULL/blank
STRNULL&SYSNDX    DS  0H
*
*   Returns:  R1  -> First trailing NULL/Blank
*             R15 -  String length
*
         MEND     ,


***********************************************************************
*                                                                     *
* Name:                                                               *
*                                                                     *
*       @ROWCOL                                                       *
*                                                                     *
* Descripion:                                                         *
*                                                                     *
*        ....                                                         *
*                                                                     *
***********************************************************************
         MACRO
&LABEL  @ROWCOL &BUFAD
         SR    R1,R1
         ICM   R1,B'0011',&BUFAD
         TM    &BUFAD,X'C0'       12-bit addressing?
         JZ    RC&SYSNDX
         SR    R0,R0
         SLDL  R0,18
         SR    R0,R0              remove two hi-order bits
         SLDL  R0,6
         SLL   R1,2               remove two hi-order bits
         SRDL  R0,26
*
RC&SYSNDX DS 0H
         SR    R0,R0
         LA    R15,80
         DR    R0,R15
         MEND

         #CVT     ,               CLAY CVT
         #WTOREC  ,                                             @110801
         #CLAMCS  ,                                             @110801

         IRXENVB  ,                                             @150204
ENVBLOCK_DSLN EQU *-ENVBLOCK                                    @150204
         IRXEXTE  ,                                             @150204
         IRXSHVB  ,                                             @150204
*
         GBLC  &SPARM1,&SPARM2,&SPARM3 PARMS FROM SPLTPRM
         SPLTPRM &SYSPARM
*
* CUSTOMIZE PANEL                                               @140424
*
         GBLC  &ENV
         AIF   ('&SPARM3'(1,4) EQ 'VCAX').SETEVME
&ENV     SETC  'CLAY'
         AGO   .ENVSET
.*
.SETEVME ANOP
&ENV     SETC  'EVME'
.*
.ENVSET  ANOP
*
***********************************************************************
*                                                                     *
*        Begin executable code                                        *
*                                                                     *
***********************************************************************
CLATTERM CSECT ,
CLATTERM RMODE ANY
CLATTERM AMODE 31

         STM   R14,R12,12(R13)                   SAVE REGS
         MODID BRANCH=YES,DATELBL=CLATMAIN_DATE
         USING #PSA,0                            ( PSA )
         L     R11,FLCCVT                        GET CVT ADDR
         USING #CVT,R11                          ( CVT )

***************************************************
* GET STORAGE FOR WORKAREA and base constant area *
***************************************************

         CLGETSTG SAVEREGS=N,                                          +
               LENGTH=WORKAREA_LEN
         LTR   R15,R15                           GOT STORAGE?
         JZ    TERMINAL_HAVE_WORKAREA              . YES
        @STOP  WSCTERM,REASON=9                  STOP CP
TERMINAL_HAVE_WORKAREA DS 0H
         ST    R13,4(,R1)                        CHAIN SAVE AREAS
         ST    R1,8(,R13)                        . . .
         LR    R13,R1                            . . .
         USING WORKAREA,R13                      ( WORKAREA )

         LARL  R12,CLATTERM_CONST                CONSTANTS AREA
         USING CLATTERM_CONST,R12                . . .

         XC    FLAG1,FLAG1
         XC    EDIT_DATASET,EDIT_DATASET
         XC    EDIT_VOLUME,EDIT_VOLUME
         XC    EDIT_CCUU,EDIT_CCUU
         XC    CLAEDIT_RESUME,CLAEDIT_RESUME
         XC    RET_AFTER_JUMP,RET_AFTER_JUMP
         XC    CURRENT_USER,CURRENT_USER
*                                                               @150204
* Init Evironment Block                                         @150204
*                                                               @150204
         LA    R0,ENV_BLOCK            clear ENVBLOCK           @150204
         ST    R0,WRK_ENV@             set address              @150204
         LA    R1,ENVBLOCK_DSLN                                 @150204
         XR    R15,R15                                          @150204
         MVCL  R0,R14                                           @150204
         LA    R9,ENV_BLOCK                                     @150204
        USING ENVBLOCK,R9                                       @150204
         MVC   ENVBLOCK_ID,=CL8'ENVBLOCK'                       @150204
*                                                               @150204
* Initialize the IRXEXTE                                        @150204
*                                                               @150204
         LA    R0,EXT_BLOCK            clear IRXEXTE            @150204
         LA    R1,IRXEXTE_DSLN                                  @150204
         MVCL  R0,R14                                           @150204
*                                                               @150204
        USING IRXEXTE,EXT_BLOCK        IRXEXTE_DSLN             @150204
         LA    R15,IRXEXTE                                      @150204
         ST    R15,ENVBLOCK_IRXEXTE    ENV points to IRXEXTE    @150204
*                                                               @150204
         LA    R15,2                   2 entries                @150204
         ST    R15,IRXEXTE_ENTRY_COUNT                          @150204
         MVC   IRXINIT,=V(CLBR14)      dummy INIT module        @150204
         MVC   IRXEXCOM,=V(CLARXCOM)   custom IRXEXCOM          @150204
        DROP  R9                                                @150204
*                                                               @150204

**      @CLTRACE MODULE='CLATMAIN',LOC='ENTRY',ID=1

***********************************************************************
*                                                                     *
* Terminal Task                                                       *
*                                                                     *
* THIS IS THE CLAY Terminal TASK REPRESENTED BY A TASK ON THE         *
* DISPATCHER QUEUE. THIS TASK CONTROLS THE FLOW OF THE user AND       *
* PRESENTS THE terminal INTERFACE.                                    *
*                                                                     *
* AFTER THE IPL WE GO INTO AN ENABLED WAIT, WAITING FOR AN ATTENTION  *
* FROM THE CONSOLE. WHEN WE RECEIVE THIS WE WILL PRESENT THE MAIN     *
* CLAY SCREEN AND THEN WAIT FOR INPUT.                                *
*                                                                     *
***********************************************************************

         USING #TASK,R10                         ( TASK )
TERMINAL_TASK DS 0H
         L     R10,PSA_ACTIVE_TASK               GET TASK ADDR
         CLC   TASK_ID,=C'TASK'                  GOOD TASK ID?
         JE    TERMINAL_TASK_GOOD_ID               . YES
        @STOP  WSCTERM,REASON=1                  STOP CP
TERMINAL_TASK_GOOD_ID DS 0H
         TM    TASK_FLAG1,#TASKTERM              CORRECT TASK?
         JO    TERMINAL_TASK_CORRECT_TASK          . YES
        @STOP  WSCTERM,REASON=2                  STOP CP
TERMINAL_TASK_CORRECT_TASK DS 0H

********************************************************************
* THIS PART OF CODE IS ENTERED AFTER THE IPL AND HANDLES THE FIRST *
* DISPLAY TO THE TERMINAL.                                         *
*                                                                  *
* FOR THE TERMINAL DEVICE WHICH IS THE ONLY ONE WE ARE INTERACTING *
* WITH IN THIS ROUTINE IS CONSISTANT. THIS IS ALSO TRUE FOR IT'S   *
* IOREQ WHICH WILL ALSO ALWAYS BE THE SAME.                        *
********************************************************************

         L     R7,TASK_TERMINAL                  Get terminate defn
         USING #DEVTERM,R7                       ( #DEVTERM )
         CLC   DEVTERM_ID,=AL4(DEVTERM_ID_NAME)  Good DEVTERM ID ???
         JE    TERMINAL_DEVTERM_GOOD_ID          . BR IF OK
        @STOP  WSCTERM,REASON=8                  STOP CP
TERMINAL_DEVTERM_GOOD_ID DS 0H

         L     R8,DEVTERM_IOREQ                  Get IOREQ

         USING #IOREQ,R8                         ( #IOREQ )
         USING IRB,IOREQ_IRB                     ( IRB )

         CLC   IOREQ_ID,=C'IORQ'                 GOOD IOREQ ID ???
         JE    TERMINAL_IOREQ_GOOD_ID            . BR IF OK
        @STOP  WSCTERM,REASON=6                  STOP CP
TERMINAL_IOREQ_GOOD_ID DS 0H

         ICM   R9,B'1111',IOREQ_DEVICE           CONSOLE DEVICE BLOCK
         JNZ   TERMINAL_GOOD_DEVICE_ADDR           . BR IF OK
        @STOP  WSCTERM,REASON=3                  STOP CP
         USING #DEVICE,R9                        ( DEVICE )
TERMINAL_GOOD_DEVICE_ADDR DS 0H
         CLC   DEVICE_ID,=C'DEVB'                GOOD DEVICE ID ???
         JE    TERMINAL_DEVICE_GOOD_ID             . YES
        @STOP  WSCTERM,REASON=4                  STOP CP

TERMINAL_DEVICE_GOOD_ID DS 0H
******************************************************************@1001
*                                                                 @1001
* Establish ESTAE for all menu functions                          @1001
*                                                                 @1001
******************************************************************@1001
         L     R2,=A(MENU_RECOVERY_RTN)          SETUP RECOVERY   @1001
        @ESTAE TYPE=ADD,EXIT=(R2),PARM=0         . ENVIRONMENT    @1001
         OC    CONSOLE_DEVICE_NUMBER,CONSOLE_DEVICE_NUMBER      @160706
         JNZ   TERMINAL_HAVE_DEVICE                             @160706
         MVC   CONSOLE_DEVICE_NUMBER,DEVICE_NUMBER COPY FOR DISPLAY

        @FORMAT ('EINIT000 TERMINAL.',X4,' STARTED'),           @160706+
               (CONSOLE_DEVICE_NUMBER),                         @160706+
               AREA=TASK_WTO_MSG,BLANK=L'TASK_WTO_MSG           @160706
        @WTO   UPDTOD=0                                         @160706
*                                                               @160706
TERMINAL_HAVE_DEVICE DS 0H                                      @160706
        @WAITIO QUEUE=TASK,                      WAIT FOR TERM INPUT   +
               EMPTY=WAIT
         LR    R8,R1                             COPY IOREQ ADDR

         CLC   IOREQ_ID,=C'IORQ'                 GOOD IOREQ ID ???
         JE    TERMINAL_ATTN_IOREQ_GOOD_ID       . YES
        @STOP  WSCTERM,REASON=6                  STOP CP
*                                                               @110801
TERMINAL_ATTN_IOREQ_GOOD_ID DS 0H
         TM    IRBDSTAT,IRBDSATN                 ATTENTION?
         JNO   TERMINAL_DEVICE_GOOD_ID           . NO, GO TRY AGAIN

        @CNSLIO TYPE=SNSID                       SENSE ID TO CONSOLE
         LR    R8,R1                             COPY IOREQ ADDR

        @CHECKIO IOREQ=#IOREQ,                   GOOD I/O ?            +
               ERP=Y,                                                  +
               ERROR=TERMINAL_ATTN_NONSENSE                     @110801

         CLC   DEVICE_TYPE,=X'3215'                             @110801
         JE    TERMINAL_ATTN_NONSENSE                           @110801
         CLI   IOREQ_DATA,X'FF'                  GOOD SENSE ID DATA?
         JE    TERMINAL_CONSOLE_SENSEID_GOOD       . YES
        @STOP  WSCTERM,REASON=7                  STOP CP
*                                                               @110801
TERMINAL_ATTN_NONSENSE DS 0H                                    @110801
        @CLCLEAR DEVTERM_CONS_INPUT                             @110801
        @BLDCCW1 1,CHANPGM,X'0A',DEVTERM_CONS_INPUT+6,X'00',100 @110801
*                                                               @110801
         LA    R2,CHANPGM          * SET CHANNEL PROGRAM        @110801
*                                                               @110801
        @STARTIO IOREQ=#IOREQ,                                  @110801+
               DEVICE=#DEVICE,                                  @110801+
               CCW=(R2),FMT=1,NOWTO=Y,                          @110801+
               TRANSLATE=I,                                     @110801+
               DLLQWA=DLLQ_WORKAREA                             @110801
*                                                               @110801
        @WAITIO IOREQ=#IOREQ,                                   @110801+
               DLLQWA=DLLQ_WORKAREA                             @110801
*                                                               @110801
        @CHECKIO IOREQ=#IOREQ,ERROR=IGNORE_ERROR_READ           @110801
*                                                               @110801
IGNORE_ERROR_READ DS 0H                                         @110801
    J    SKIP_ECHO                                              @110801
        @BLDCCW1 1,CHANPGM,X'09',DEVTERM_CONS_INPUT+6,X'00',60  @110801
*                                                               @110801
         LA    R2,CHANPGM          * SET CHANNEL PROGRAM        @110801
*                                                               @110801
        @STARTIO IOREQ=#IOREQ,                                  @110801+
               DEVICE=#DEVICE,                                  @110801+
               CCW=(R2),FMT=1,NOWTO=Y,                          @110801+
               TRANSLATE=I,                                       @0004+
               DLLQWA=DLLQ_WORKAREA                             @110801
*                                                               @110801
        @WAITIO IOREQ=#IOREQ,                                   @110801+
               DLLQWA=DLLQ_WORKAREA                             @110801
*                                                               @110801
        @CHECKIO IOREQ=#IOREQ,ERROR=IGNORE_ERROR_WRITE          @110801
*                                                               @110801
SKIP_ECHO DS 0H                                                 @110801
         OC    DEVTERM_CONS_INPUT+6(128),=CL128' '              @110801
         CLC   DEVTERM_CONS_INPUT+6(128),=CL128' '              @110801
         JE    TERMINAL_TASK                        null input  @110801
*
*        L     R10,PSA_ACTIVE_TASK
*       USING #TASK,R10
         ICM   R15,B'1111',TASK_INTRDR_FILE open tempfile?      @130409
         JNZ   SKIP_ECHO2                       . yes           @120214
        @FORMAT ('ECNSL000 ',C80,<,' (',C8,<,')'),              @110801+
               (DEVTERM_CONS_INPUT+6,TASK_IDENTIFIER),          @110801+
               AREA=TASK_WTO_MSG,BLANK=L'TASK_WTO_MSG           @110801
        @WTO   PRI=HIGH,UPDTOD=0                                @110801
        MVI    TASK_WTO_MSG,C'I'                                @150312
        @WTO   PRI=HIGH,UPDTOD=0,TASK=(*,CVT_IPL_TASK),         @150312+
               TERM=0                                           @150312
*                                                               @120214
SKIP_ECHO2 DS 0H                                                @120214
         CLI   DEVTERM_CONS_INPUT+6,C'<'       Stcmon?          @110801
         JNE   CNSL_NOT_STCMON                                  @110801
*                                                               @110801
* It's STCMON, add the terminal ID                              @110801
*                                                               @110801
         LA    R1,DEVTERM_CONS_INPUT+133                        @110801
         CLI   0(R1),C' '                                       @110801
         JH    *+8                                              @110801
         JCT   R1,*-8                                           @110801
         MVC   1(03,R1),=C',L='                                 @110801
         MVC   4(08,R1),TASK_IDENTIFIER                         @110801
*                                                               @110801
CNSL_NOT_STCMON DS 0H                                           @110801
         MCSOPER REQUEST=ACTIVATE,  ACTIVATE CONSOLE TO CATCH MSGS     +
               NAME=TASK_IDENTIFIER,                            @110801+
               CONSID=CONSID,       RECEIVES CONSOLE HANDLE     @110801+
               TERMNAME=TASK_IDENTIFIER,                        @110801+
               MCSCSA=MCSCSA,                                   @110801+
               MCSCSAA=MCSCSAA,                                 @110801+
               RTNCODE=RTNCODE,                                 @110801+
               RSNCODE=RSNCODE,                                 @110801+
               MF=(E,MCSOPER,COMPLETE)                          @110801
*                                                               @110801
         NOP   0                    skip these for now                 +
               OPERPARM=OPERPARM,                               @110801+
               MSGECB=MSGECB,                                   @110801+
                                                                @110801
         LTR   R15,R15                                          @110801
         JZ    OPER_TELL                                        @110801
         OI    FLAG1,FLAG1_PRECONS                              @110801
*                                                               @110801
OPER_TELL DS 0H                                                 @110801
*        LA    R1,=H'128'                                       @110801
*        ST    R1,CHANPGM                                       @110801
*        LA    R1,DEVTERM_CONS_INPUT+6                          @110801
*        ST    R1,CHANPGM+4                                     @110801
*        OI    CHANPGM+4,X'80'                                  @110801
*        LA    R1,CHANPGM                                       @110801
*        CALLRTN SVC34,TYPE=EXTERNAL                            @110801
*
         LA    R1,120
         STH   R1,DEVTERM_CONS_INPUT+4
         LA    R2,DEVTERM_CONS_INPUT+4
         MGCRE TEXT=(R2),                                              +
               CONSID=CONSID,                                          +
               MF=(E,MGCRE)
*                                                               @110801
*        MVC   WTO_DISP_POS,CVT_CONSOLE_WTO_CURRENT  CURRENT WTO
         LTR   R15,R15                                          @110801
         JZ    OPER_ECHO                                        @110801
         J     CNSL_NOT_SUPPORTED                               @110801
*                                                               @110801
OPER_ECHO DS 0H                                                 @110801
         ICM   R15,B'1111',TASK_INTRDR_FILE     open tempfile?  @130409
         JNZ   TERMINAL_TASK                    . yes           @120214
*
        @ZTIMER SET,BINTVL==AL4(5*100),MF=(E,STIML)    5 sec    @110801
*
        @FORMAT ('ECNSL000 Ready'),                             @111024+
               AREA=TASK_WTO_MSG,BLANK=L'TASK_WTO_MSG           @111024
        @WTO   PRI=HIGH,UPDTOD=0,CONSID=CONSID                  @111024
*                                                               @110801
OPER_GET DS 0H                                                  @110801
         MCSOPMSG REQUEST=GETMSG,   get a message               @110801X
               CONSID=CONSID,       my console id               @110801X
               RTNCODE=RTNCODE,     save return code            @110801X
               RSNCODE=RSNCODE,     save reason code            @110801X
               MF=(E,MCSOPMSG)                                  @110801
         LTR   R15,R15                                          @110801
         JNZ   OPER_GET_DONE                                    @110801
         LR    R3,R1                                            @110801
        USING MDB,R3                                            @110801
         LA    R5,MDBHLEN(,R3)                                  @110801
        USING MDBG,R5                                           @110801
        @FORMAT AREA=TASK_WTO_MSG,BLANK=L'TASK_WTO_MSG          @110801
         LA    R5,MDBGLN(,R5)                                   @110801
        DROP  R5                                                @110801
        USING MDBT,R5                                           @110801
         LH    R2,MDBTLEN                                       @110801
         AHI   R2,-1*MDBTMBOB                                   @110801
         LA    R0,MDBTMSGT                                      @110801
         LR    R1,R2                                            @110801
         LA    R14,TASK_WTO_MSG                                 @110801
         LR    R15,R1                                           @110801
         MVCL  R14,R0                                           @110801
        @BLDCCW1 1,CHANPGM,X'09',TASK_WTO_MSG,X'00',75  <== length?
*                                                               @110801
         LA    R2,CHANPGM          * SET CHANNEL PROGRAM        @110801
*                                                               @110801
        @STARTIO IOREQ=#IOREQ,                                  @110801+
               DEVICE=#DEVICE,                                  @110801+
               CCW=(R2),FMT=1,NOWTO=Y,                          @110801+
               TRANSLATE=I,                                       @0004+
               DLLQWA=DLLQ_WORKAREA                             @110801
*                                                               @110801
        @WAITIO IOREQ=#IOREQ,                                   @110801+
               DLLQWA=DLLQ_WORKAREA                             @110801
*                                                               @110801
        @CHECKIO IOREQ=#IOREQ,ERROR=IGNORE_ERROR_WRITE          @110801
*                                                               @110801
        CLRTNSTG SAVEREGS=Y,ADDR=(R3)                           @110801
         J     OPER_GET                                         @110801
*                                                               @110801
OPER_GET_DONE DS 0H                                             @110801
*        L     R10,PSA_ACTIVE_TASK
*       USING #TASK,R10
*
*        ICM   R15,B'1111',TASK_INTRDR_FILE     open tempfile?  @130409
*        JNZ   TERMINAL_TASK                    . yes           @120214
*       @FORMAT ('ECNSL000 Ready'),                             @111024+
               AREA=TASK_WTO_MSG,BLANK=L'TASK_WTO_MSG           @111024
*       @WTO   PRI=HIGH,UPDTOD=0,CONSID=CONSID                  @111024
         J     TERMINAL_TASK                                    @110801
        DROP  R3                                                @110801
*                                                               @110801
************************************                            @110801
* COMMAND ENTERED IS NOT SUPPORTED *                            @110801
************************************                            @110801
CNSL_NOT_SUPPORTED DS 0H                                        @110801
        @CLCLEAR TASK_WTO_MSG                                   @110801
         MVC   TASK_WTO_MSG(32),=C'ECNSL000 COMMAND NOT SUPPORTED: '
         MVC   TASK_WTO_MSG+33(L'TASK_WTO_MSG-33),DEVTERM_CONS_INPUT+6
        @WTO   PRI=HIGH,UPDTOD=0,CONSID=CONSID                  @160921
        @WTO   PRI=HIGH,UPDTOD=0                  broadcast     @110801
*        MVC   WTO_DISP_POS,CVT_CONSOLE_WTO_CURRENT  CURRENT WTO
*                                                               @110801
IGNORE_ERROR_WRITE DS 0H                                        @110801
         J     TERMINAL_TASK                                    @110801
*                                                               @110801
*                                                               @110801
*                                                               @110801
*                                                               @110801
*                                                               @110801
*                                                               @110801
*                                                               @110801

TERMINAL_CONSOLE_SENSEID_GOOD DS 0H

        @CLCLEAR SCREEN_ERROR_MSG                CLEAR ERROR MSG

***********************************************************************
*                                                                     *
* Determine 3270 screen size                                          *
*                                                                     *
***********************************************************************
*                                                               @131018
* Issue Read Query to get screen size                           @131018
*                                                               @131018
         L     R3,DEVTERM_SCREEN_COPY_AREA                      @131018
         MVC   0(08,R3),=X'000701FF0300A600' Implicit partition @131018
        @CNSLIO TYPE=WRITE,MOD=WSF,                             @131018+
               SCREEN=(R3),SCRNSIZE=7                           @131018
        @NIL   IOREQ_FLAG1_CS,               IRB IS OLD         @131018+
               X'FF'-#IRB_STORED,                               @131018+
               REF=IOREQ_FLAGS_CS                               @131018

        @WAITIO QUEUE=TASK,                  WAIT FOR ATTN OR   @131018+
               EMPTY=WAIT,                   . AUTO CNSL UPDATE @131018+
               CONSOLE=YES                                      @131018
*                                                               @131018
        @CNSLIO TYPE=READ                                       @131018

         CLI   DEVTERM_CONS_INPUT,X'88'      Query Reply        @131018
         JNE   TERMINAL_MAIN_SCREEN_DISPLAY                     @131018
         CLI   DEVTERM_CONS_INPUT+4,X'A6'    Implicit Part.     @131018
         JNE   TERMINAL_MAIN_SCREEN_DISPLAY                     @131018
         MVC   DEVTERM_COLS,DEVTERM_CONS_INPUT+14   Width       @131018
*        MVC   DEVTERM_ROWS,DEVTERM_CONS_INPUT+16   Height      @131018
         LH    R15,DEVTERM_CONS_INPUT+16                        @131018
         CHI   R15,DEVTERM_MAX_ROWS                             @131018
         JNH   *+8                                              @131018
         LHI   R15,DEVTERM_MAX_ROWS                             @131018
         STH   R15,DEVTERM_ROWS                                 @131018
*                                                                     *
***********************************************************************
*DEL     L     R2,=A(MENU_RECOVERY_RTN)          SETUP RECOVERY   @1001
*DEL    @ESTAE TYPE=ADD,EXIT=(R2),PARM=0         . ENVIRONMENT    @1001
*                                                                     *
*                                                                     *
***********************************************************************
*                                                                     *
* MAIN TERMINAL LOOP                                                  *
*                                                                     *
* THIS IS THE MAIN TERMINAL LOOP. WE SIT HERE WAITING FOR THE         *
* USER TO SELECT ONE OF THE MAIN FUNCTIONS. ONCE THE USER             *
* SELECTS A FUNCTION WE GO TO THAT ROUTINE. WHEN THE USER IS          *
* FINISHED WITH THAT FUNCTION WE WILL THEN ALWAYS RETURN TO           *
* THIS MAIN DISPLAY SCREEN LOOP.                                      *
*                                                                     *
***********************************************************************

TERMINAL_MAIN_SCREEN_DISPLAY DS 0H
         CLI   DEVTERM_CONS_INPUT+6,C'='
         JNE   TERMINAL_WRITE_SETUP
         MVC   DEVTERM_CONS_INPUT(L'DEVTERM_CONS_INPUT-1),DEVTERM_CONS_*
               INPUT+1
         J     TERMINAL_CHECK_USER_SELECTION
*
TERMINAL_WRITE_SETUP DS 0H
         ICM   R15,B'1111',RET_AFTER_JUMP        want to return?
         JZ    TERMINAL_WRITE_SETUP2             no
         XC    RET_AFTER_JUMP,RET_AFTER_JUMP     just one deep
         XR    R2,R2                             true resume signal
         BR    R15                               go directly there
*
TERMINAL_WRITE_SETUP2 DS 0H
         TM    CVT_MISC_OPTIONS,MISC_OPT_GDDR
         JO    GDDR_SHORTCUT
*
        @MOVESCR SCRNNAME=$SCREEN_MAIN,                                +
               SCRNADDR=SCR2MAIN,                                      +
               BASE=R5
         MVC   $MAIN_SCREEN_ERROR,SCREEN_ERROR_MSG
         MVC   $SNAME,CVT_SNAME                  SETUP MAIN SCREEN
        @FORMAT ('v',C1,'.',C2,'.',C1),                         @111130+
               (CVT_SYSVER,CVT_SYSVER+1,CVT_SYSVER+3),          @111130+
               AREA=$SYSVER
         MVC   $IPLTIME,CVT_IPL_TIME             . . .
         MVC   $IPLDATE,CVT_IPL_DATE             . . .
         MVC   $USERID,=CL8'OPER'                . . .
         MVC   $CPUID(L'CVT_CPU_ID),CVT_CPU_ID   . . .          @140527
**       point at server name in chem info                      @140527
         LA    R1,CVT_CHEM_INFO+L'CVT_CHEM_INFO-4-16            @140527
    IF   (CLC,CVT_CPU_ID,EQ,0(R1))                              @140527
         MVC   $CPUID,0(R1)                                     @140527
    ENDIF   ,                                                   @140527
         MVC   $SYSID,CVT_CPU_TYPE               . . .
         L     R2,CVT_IPL_DEVICE
        @CNVTEBC FROM=DEVICE_NUMBER-#DEVICE(R2),                       +
               TO=$IPLDEV,LEN=2
*
*  Insert Product version information to display
*
         MVC   $CLAYNAM(L'$CLAYNAM),=CL16'Clay'      Component name
        @FORMAT ('v',C1,'.',C2,'.',C1),                         @111130+
               (CVT_SYSVER,CVT_SYSVER+1,CVT_SYSVER+3),          @111130+
               AREA=$CLAYVER                           Clay Version
*
*  Insert Clay build date
*
*      * Make it look YYYY/MM/DD to match the others
*
         MVC   $CLAYDAT(2),=CL2'20'                  Insert century
         MVC   $CLAYDAT+2(2),CVT_BUILD_DATE+6        Copy YY
         MVI   $CLAYDAT+4,C'/'                       Move "/"
         MVC   $CLAYDAT+5(5),CVT_BUILD_DATE          Clay Build MM/DD
*
         MVC   $CLAYTIM(L'$CLAYTIM),CVT_BUILD_TIME   Clay Build time
         MVI   $CLAYTIM+2,C':'                       Move ":"
         MVC   $CLAYTIM+5(3),=CL3':00'               Move ":00"

         TM    CVT_OS_LEVEL0,CVT_OS_L0_CHEM_INFO     Chem info there?
         JNO   TERMINAL_WRITE_CONSOLE                No, just display
*
*  Insert Chem version information to display
*
         LA    R3,CVT_CHEM_INFO+(CRI_Chem-CRI)       -> Chem info
         USING RIE,R3                                (Addr info entry)

         MVC   $CHEMNAM(L'$CHEMNAM),RIE_Name         Component name
         XC    $CHEMVER(L'$CHEMVER),$CHEMVER         Clear version
         MVI   $CHEMVER,C'v'                         'v' identifier
         MVC   $CHEMVER+1(L'RIE_Revision),RIE_Revision Revision level
         STRLEN $CHEMVER                             Obtain Strlen
         MVI   0(R1),C'-'                            Mod ident  @160427
         MVC   1(4,R1),RIE_Modification              Modification lvl
         MVC   $CHEMDAT(L'$CHEMDAT),RIE_BuildDate    Build date
         MVC   $CHEMTIM(L'$CHEMTIM),RIE_BuildDate+11 Build time

*
*  Insert Hercules version information to display
*
         LA    R3,CVT_CHEM_INFO+(CRI_Herc-CRI)       -> Hercules info
         MVC   $HERCNAM(L'$HERCNAM),RIE_Name         Component name
         XC    $HERCVER(L'$HERCVER),$HERCVER         Clear version
         MVI   $HERCVER,C'v'                         'v' identifier
         MVC   $HERCVER+1(L'RIE_Revision),RIE_Revision Revision level
         STRLEN $HERCVER                             Obtain Strlen
         MVI   0(R1),C'-'                            Mod ident  @160427
         MVC   1(4,R1),RIE_Modification              Modification lvl
         MVC   $HERCDAT(L'$HERCDAT),RIE_BuildDate    Build date
         MVC   $HERCTIM(L'$HERCTIM),RIE_BuildDate+11 Build time
*
*  Insert Host version information to display
*
         LA    R3,CVT_CHEM_INFO+(CRI_Host-CRI)       -> Host info
         MVC   $HOSTNAM(L'$HOSTNAM),RIE_Name         Component name
         XC    $HOSTVER(L'$HOSTVER),$HOSTVER         Clear version
         MVI   $HOSTVER,C'v'                         'v' identifier
         MVC   $HOSTVER+1(L'RIE_Revision),RIE_Revision Revision level
         STRLEN $HOSTVER                             Obtain Strlen
*del0427 MVI   0(R1),C'-'                            Mod identifier
         MVC   0(4,R1),RIE_Modification              Remainder  @160427
         MVC   $HOSTDAT(L'$HOSTDAT),RIE_BuildDate    Build date
         MVI   $HOSTDAT+4,C'/'                       Set "/"
         MVI   $HOSTDAT+7,C'/'                       Set "/"
         MVC   $HOSTTIM(L'$HOSTTIM),RIE_BuildDate+11 Build time

         DROP  R3                                    (Done w/ RIE)
*
*  Send screen to the display
*
TERMINAL_WRITE_CONSOLE DS 0H
        @CNSLIO TYPE=WRITE,                                            +
               MOD=2,                                                  +
               SCREEN=$SCREEN_MAIN,                                    +
               SCRNSIZE=$SCREEN_MAIN_SIZE
         LR    R8,R1                             COPY IOREQ ADDR

        @CLCLEAR SCREEN_ERROR_MSG

* MAIN SCREEN IS DISPLAYED NOW JUST WAIT FOR THE OPERATOR TO
* ENTER SELECTION.
        @WAITIO QUEUE=TASK,                      WAIT FOR ATTN         +
               EMPTY=WAIT
         LR    R8,R1                             COPY IOREQ ADDR

         TM    IRBDSTAT,IRBDSATN                 ATTENTION?
         JO    TERMINAL_READ_CONSOLE_INPUT       . YES, GO GET INPUT
*        MVC   SCREEN_ERROR_MSG(20),=C'INPUT NOT UNDERSTOOD'    @131018
*                                                               @131018
* Issue Read Query to get screen size                           @131018
*                                                               @131018
         L     R3,DEVTERM_SCREEN_COPY_AREA                      @131018
         MVC   0(08,R3),=X'000701FF0300A600' Implicit partition @131018
        @CNSLIO TYPE=WRITE,MOD=WSF,                             @131018+
               SCREEN=(R3),SCRNSIZE=7                           @131018
        @NIL   IOREQ_FLAG1_CS,               IRB IS OLD         @131018+
               X'FF'-#IRB_STORED,                               @131018+
               REF=IOREQ_FLAGS_CS                               @131018

        @WAITIO QUEUE=TASK,                  WAIT FOR ATTN OR   @131018+
               EMPTY=WAIT,                   . AUTO CNSL UPDATE @131018+
               CONSOLE=YES                                      @131018
*                                                               @131018
        @CNSLIO TYPE=READ                                       @131018

         CLI   DEVTERM_CONS_INPUT,X'88'      Query Reply        @131018
         JNE   TERMINAL_MAIN_SCREEN_DISPLAY                     @131018
         CLI   DEVTERM_CONS_INPUT+4,X'A6'    Implicit Part.     @131018
         JNE   TERMINAL_MAIN_SCREEN_DISPLAY                     @131018
         MVC   DEVTERM_COLS,DEVTERM_CONS_INPUT+14   Width       @131018
*        MVC   DEVTERM_ROWS,DEVTERM_CONS_INPUT+16   Height      @131018
         LH    R15,DEVTERM_CONS_INPUT+16                        @131018
         CHI   R15,DEVTERM_MAX_ROWS                             @131018
         JNH   *+8                                              @131018
         LHI   R15,DEVTERM_MAX_ROWS                             @131018
         STH   R15,DEVTERM_ROWS                                 @131018
         J     TERMINAL_MAIN_SCREEN_DISPLAY      GO REDISPLAY

GDDR_SHORTCUT DS 0H
         TM    FLAG1,FLAG1_AUTH                  authenticated?
         JO    GDDR_AUTHENTIC
         XC    DEVTERM_CONS_INPUT,DEVTERM_CONS_INPUT
         CLAYLOAD LOAD,=CL8'SCR2VMEN'            LOAD SCR2VMEN
         LTR   R15,R15                           OK ?
         JZ    GDDR_LOAD_GOOD                        . YES

         ST    R0,LOAD_R0                        SAVE ERROR INFO
         ST    R1,LOAD_R1                        . . .
         ST    R15,LOAD_R15                      . . .
        @CLCLEAR CONSOLE_MSG
         MVC   CONSOLE_MSG(41),=C'ECNL0000 LOAD FOR SCR2VMEN FAILED'
        @CLCLEAR CONSOLE_MSG
         MVC   CONSOLE_MSG(61),=C'ECNL0000 R0(RS) XXXXXXXX  R1(ERROR) X+
               XXXXXXX  R15(RC) XXXXXXXX'
        @CNVTEBC FROM=LOAD_R0,TO=CONSOLE_MSG+16,LEN=4
        @CNVTEBC FROM=LOAD_R1,TO=CONSOLE_MSG+36,LEN=4
        @CNVTEBC FROM=LOAD_R15,TO=CONSOLE_MSG+54,LEN=4
*       @WTO   CONSOLE_MSG,PRI=MED                              @150312
         CALLRTN ISSUE_WTO                                      @150312
         MVC   WTO_DISP_POS,CVT_CONSOLE_WTO_CURRENT  CURRENT WTO
        @STOP  WSCTERM,REASON=1                      . YES

GDDR_LOAD_GOOD DS 0H
         L     R14,DEVTERM_SCREEN_COPY_AREA
         LA    R1,$SCREEN_VMEN_SIZE              #DBW to len
         LR    R15,R1
         MVCL  R14,R0

         L     R5,DEVTERM_SCREEN_COPY_AREA
        USING $SCREEN_VMEN,R5
         XC    $VMMSG,$VMMSG
         MVC   $VMMSG(L'SCREEN_ERROR_MSG),SCREEN_ERROR_MSG
         CLC   SCREEN_ERROR_MSG(30),ENTER_MSG    Add PF3 bit?   @110628
         JNE   GDDR_NOT_ENTER_MSG                               @110628
         MVC   $VMMSG+L'SCREEN_ERROR_MSG(9),ENTER_XTRA          @110628
*                                                               @110628
GDDR_NOT_ENTER_MSG DS 0H                                        @110628
         LA    R3,$SCREEN_VMEN_SIZE              #DBW to len
        DROP  R5
*                                                               @110628
        @WAITIO QUEUE=TASK,                IN CASE OF ABEND AND @110628+
               EMPTY=RETURN                . STILL ON IOQ_COMP  @110628

        @CNSLIO TYPE=WRITE,                                            +
               MOD=2,                                                  +
               SCREEN=(R5),                                            +
               SCRNSIZE=(R3)
         LR    R8,R1                             COPY IOREQ ADDR

        @CLCLEAR SCREEN_ERROR_MSG

* Logon screen is displayed - now just wait for the operator to
* enter userid and password.
        @WAITIO QUEUE=TASK,                      WAIT FOR ATTN         +
               EMPTY=WAIT
         LR    R8,R1                             COPY IOREQ ADDR
        @CNSLIO TYPE=READ                        READ USER INPUT
         LR    R8,R1                             COPY IOREQ ADDR
         MVC   SCREEN_ERROR_MSG(30),ENTER_MSG                   @110628
         CLI   DEVTERM_CONS_INPUT,PFK3      EXIT logon screen?  @110628
         JE    TERMINAL_IMMED_UNDIAL        yes - same as '=U'  @110628
         CLI   DEVTERM_CONS_INPUT+6,C' '         anything entered?
         JL    GDDR_SHORTCUT                     no - reissue
        @CLCLEAR SCREEN_ERROR_MSG
* isolate userid
         LA    R2,TERM_USERID
         LA    R3,DEVTERM_CONS_INPUT+6
         MVC   TERM_USERID,=CL8' '
*
TERMINAL_SCAN_USERID DS 0H
         CLI   0(R3),C' '
         JL    TERMINAL_HAVE_USERID
         OC    0(1,R2),0(R3)                     move and upper case
         LA    R2,1(,R2)
         LA    R3,1(,R3)
         J     TERMINAL_SCAN_USERID
* isolate password
TERMINAL_HAVE_USERID DS 0H
         CLC   TERM_USERID,=CL8'UNDIAL'
         JE    TERMINAL_IMMED_UNDIAL
         CLC   TERM_USERID,=CL8'=UNDIAL'
         JE    TERMINAL_IMMED_UNDIAL
         CLC   TERM_USERID,=CL8'=U'
         JE    TERMINAL_IMMED_UNDIAL
*
         CLI   0(R3),X'11'
         JNE   GDDR_SHORTCUT
        @CLCLEAR TERM_PASSWORD
         LA    R2,TERM_PASSWORD
         LA    R3,3(,R3)
*
TERMINAL_SCAN_PASSWORD DS 0H
         CLI   0(R3),C' '
         JL    TERMINAL_HAVE_PASSWORD
         OC    0(1,R2),0(R3)
         LA    R2,1(,R2)
         LA    R3,1(,R3)
         J     TERMINAL_SCAN_PASSWORD
*
TERMINAL_HAVE_PASSWORD DS 0H
         MVI   0(R2),X'00'                 terminate string
*
* Call security exit
*
         CALL  CLAYACF1,(=X'C0',TERM_USERID,TERM_PASSWORD),VL,         +
               MF=(E,PLIST)
         ST    R15,LOAD_R15                                     @110628
         LTR   R15,R15
         JZ    TERMINAL_AUTHORIZED
         JP    TERMINAL_GET_EMSG                                @110628
         XR    R15,R15               RC < 0, (-1 means bad call)@110628
*                                                               @110715
TERMINAL_GET_EMSG DS 0H                                         @110628
         TM    CVT_VM_FLAG1,CVT_VMF1_LOCKDOWN  in lockdown mode?@110628
         JZ    TERMINAL_GET_EMSG2    . no, give specific emsg   @110628
         LA    R15,20                . yes, give generic emsg   @110628
*                                                               @110628
TERMINAL_GET_EMSG2 DS 0H                                        @110628
         SRL   R15,2                 Divide by 4                @110628
         CHI   R15,MAX_EMSG          Within range?              @110628
         JNH   TERMINAL_GET_EMSG3    .Y, continue               @110628
         XR    R15,R15               .n, (perhaps new rc?)      @110628
*                                    (give Invalid call emsg)   @110628
TERMINAL_GET_EMSG3 DS 0H                                        @110628
         MHI   R15,L'SCREEN_ERROR_MSG      (should be 30)       @110628
         LA    R1,AUTH_EMSGS(R15)                               @110628
         MVC   SCREEN_ERROR_MSG(30),0(R1)                       @110628
*        MVC   SCREEN_ERROR_MSG(20),=CL20'Unauthorized user'    @110628
        @CLCLEAR CONSOLE_MSG
        @FORMAT ('ECNL0013 FAILED LOGIN ATTEMPT BY ',C8,<,' ON TERMINAL+
                ',X4,' RC:',X8),                                       +
               (TERM_USERID,CONSOLE_DEVICE_NUMBER,LOAD_R15),           +
               AREA=CONSOLE_MSG
         XC    TERM_USERID,TERM_USERID
         XC    TERM_PASSWORD,TERM_PASSWORD
*       @WTO   CONSOLE_MSG,PRI=MED                              @150312
         CALLRTN ISSUE_WTO                                      @150312
        @CLCLEAR CONSOLE_MSG

         J     GDDR_SHORTCUT
*
TERMINAL_IMMED_UNDIAL DS 0H
         CALLRTN SELECTED_UNDIAL
         J     GDDR_SHORTCUT
*
TERMINAL_AUTHORIZED DS 0H

         XC    TERM_PASSWORD,TERM_PASSWORD
        @CLCLEAR CONSOLE_MSG
        @FORMAT ('ECNL0014 LOGIN BY ',C8,<,' ON TERMINAL ',X4),        +
               (TERM_USERID,CONSOLE_DEVICE_NUMBER),                    +
               AREA=CONSOLE_MSG
*       @WTO   CONSOLE_MSG,PRI=MED                              @150312
         CALLRTN ISSUE_WTO                                      @150312
        @CLCLEAR CONSOLE_MSG

         ICM   R2,B'1111',CVT_USER_STACK
        USING USER_CONTROL,R2              ( #USER )
*
TERMINAL_LOOK_USERID DS 0H
         JZ    TERMINAL_NEW_USERID
         CLC   TERM_USERID,STACK_USERID
         JE    TERMINAL_FOUND_USERID
         ICM   R2,B'1111',STACK_NEXT
         J     TERMINAL_LOOK_USERID
*
TERMINAL_NEW_USERID DS 0H
         CLGETSTG SAVEREGS=Y,LENGTH=STACK_LN,COND=Y
         LTR   R15,R15
         JZ    TERMINAL_NEW_USERID_GOTSTG
         MVC   SCREEN_ERROR_MSG(20),=CL20'No USER storage'
         J     GDDR_SHORTCUT

TERMINAL_NEW_USERID_GOTSTG DS 0H
         LR    R2,R1
         XC    0(STACK_LN,R2),0(R2)
         MVC   STACK_EYEC,=C'UCTL'
         MVC   STACK_USERID,TERM_USERID
*
TERMINAL_STACK_ADD DS 0H
         L     R15,CVT_USER_STACK
         ST    R15,STACK_NEXT
         CS    R15,R2,CVT_USER_STACK
         JNZ   TERMINAL_STACK_ADD
*
* Make sure user isn't on another terminal
*
TERMINAL_FOUND_USERID DS 0H
         DLLQ  ANCH=CVT_DEVTERM,                 GET FIRST #DEVTERM    +
               F=FIRST,                                                +
               WA=DLLQ_WORKAREA,                                       +
               LOCK=NO,                                                +
               IFNONE=TERMINAL_USER_OK
         LR    R4,R1
SCAN     USING #DEVTERM,R4                       ( TASK )
*
TERMINAL_CHECK_DUPE DS 0H
         CLR   R7,R4
         JE    TERMINAL_CHECK_NEXT
         CL    R2,SCAN.DEVTERM_USER
         JNE   TERMINAL_CHECK_NEXT
*
         MVC   SCREEN_ERROR_MSG(20),=CL20'Already logged on'
         ST    R15,LOAD_R15
        @CLCLEAR CONSOLE_MSG
        @FORMAT ('ECNL0013 FAILED LOGIN ATTEMPT BY ',C8,<,' ON TERMINAL+
                ',X4,' RC:',X8),                                       +
               (TERM_USERID,CONSOLE_DEVICE_NUMBER,LOAD_R15),           +
               AREA=CONSOLE_MSG
         XC    TERM_USERID,TERM_USERID
         XC    TERM_PASSWORD,TERM_PASSWORD
*       @WTO   CONSOLE_MSG,PRI=MED                              @150312
         CALLRTN ISSUE_WTO                                      @150312
        @CLCLEAR CONSOLE_MSG

         J     GDDR_SHORTCUT
*
TERMINAL_CHECK_NEXT DS 0H
         DLLQ  ANCH=CVT_DEVTERM,                 GET NEXT #TASK        +
               F=NEXT,                                                 +
               ELE=(R4),                                               +
               WA=DLLQ_WORKAREA,                                       +
               LOCK=NO,                                                +
               PLOFAIL=TERMINAL_FOUND_USERID,                   @111021+
               IFNONE=TERMINAL_USER_OK
         LR    R4,R1
         J     TERMINAL_CHECK_DUPE
        DROP  SCAN
*
TERMINAL_USER_OK DS 0H
         ST    R2,CURRENT_USER
         ST    R2,DEVTERM_USER
         MVC   DEVTERM_WORKAREA,STACK_DEVTERM_WORKAREA
         MVC   DEVTERM_MEMWORK,STACK_DEVTERM_MEMWORK
         MVC   CLAEDIT_RESUME,STACK_CLAEDIT_RESUME
         MVC   RET_AFTER_JUMP,STACK_RET_AFTER_JUMP
         MVC   TASK_CLFILEX_ANCHOR,STACK_CLFILEX
         ICM   R15,B'1111',TASK_CLFILEX_ANCHOR
         JZ    TERMINAL_USER_NOFILE
SCAN    USING #CLFILEX,R15
*
TERMINAL_USER_FILE_LOOP DS 0H
         ST    R10,SCAN.CLFXTSK@                 reset task assoc
         ICM   R15,B'1111',SCAN.CLFILEX_CHAIN
         JNZ   TERMINAL_USER_FILE_LOOP
        DROP  SCAN
*
TERMINAL_USER_NOFILE DS 0H
         OI    FLAG1,FLAG1_AUTH                  authenticated?
*
         ICM   R15,B'1111',RET_AFTER_JUMP        want to return?
         JZ    GDDR_AUTHENTIC                    no
         XC    RET_AFTER_JUMP,RET_AFTER_JUMP     just one deep
         XR    R2,R2                             true resume signal
         BR    R15                               go directly there
*
        DROP  R2

GDDR_AUTHENTIC DS 0H
         MVI   DEVTERM_CONS_INPUT+6,C'C'         CONSOLE FUNC
         J     TERM_NOT_TRACE

TERMINAL_READ_CONSOLE_INPUT DS 0H
         XC    DEVTERM_CONS_INPUT,DEVTERM_CONS_INPUT CLR RESP AREA
        @CNSLIO TYPE=READ                        READ USER INPUT
         LR    R8,R1                             COPY IOREQ ADDR
TERMINAL_READ_CONSOLE_TEST DS 0H
         CLI   DEVTERM_CONS_INPUT,X'60'          No AID?        @131018
         JE    TERMINAL_MAIN_SCREEN_DISPLAY        . Yes, reshow

* PF 1 (HELP) ???

         CLI   DEVTERM_CONS_INPUT,PFK1           MAIN HELP SCREEN?
         JNE   TERMINAL_SCREEN_NOT_PF1             . NO
*
TERMINAL_READ_HELP DS 0H
*       @MOVESCR SCRNNAME=$SCREEN_HELP,                                +
               SCRNADDR=SCR2HELP,                                      +
               BASE=R5
*       @CNSLIO TYPE=WRITE,                                            +
               MOD=2,                                                  +
               SCREEN=$SCREEN_HELP,                                    +
               SCRNSIZE=$SCREEN_HELP_SIZE
*        LR    R8,R1                             COPY IOREQ ADDR
*
*       @WAITIO QUEUE=TASK,                      WAIT FOR ATTN         +
               EMPTY=WAIT
*        LR    R8,R1                             COPY IOREQ ADDR
         L     R0,WRK_ENV@
         XC    PLIST,PLIST
*        LA    R1,=C'EDIT'
*        ST    R1,PLIST
         LA    R1,SELECT_PARM_LN
         ST    R1,PLIST
         LA    R1,PLIST
         L     R15,=V(SELECT) CVT_CLAISPF@
         BASR  R14,R15
*        CALLRTN (R15),TYPE=EXTERNAL
         J     TERMINAL_MAIN_SCREEN_DISPLAY
*
TERMINAL_SCREEN_NOT_PF1 DS 0H

         CLI   DEVTERM_CONS_INPUT,ENTER          ENTER?
         JE    TERMINAL_CHECK_USER_SELECTION     . YES
         MVC   SCREEN_ERROR_MSG(20),=C'ONLY ENTER SUPPORTED'
         J     TERMINAL_MAIN_SCREEN_DISPLAY      GO DISPLAY MAIN SCREEN
TERMINAL_CHECK_USER_SELECTION DS 0H

         OC    DEVTERM_CONS_INPUT+6(8),CAPS      ALL UPPER CASE
         CLI   DEVTERM_CONS_INPUT+6,C'='
         JNE   TERMINAL_CHECK_PLAIN_SELECTION
         MVC   DEVTERM_CONS_INPUT+6(L'DEVTERM_CONS_INPUT-7),DEVTERM_CON+
               S_INPUT+7                         shift out the '='

TERMINAL_CHECK_PLAIN_SELECTION DS 0H
         CLI   DEVTERM_CONS_INPUT+6,C'!'         program?       @150318
         JE    TERM_NOT_NULL                     . yes          @150318
         CLI   DEVTERM_CONS_INPUT+6,C'H'         HELP FUNCTION?
         JE    TERMINAL_READ_HELP                . Yes, like F1

         CLC   =C'SY',DEVTERM_CONS_INPUT+6       CLAY SYSTEM FUNCTION?
         JNE   TERM_NOT_SYSTEM                   . NO
         CALLRTN SELECTED_SYSTEM
         J     TERMINAL_MAIN_SCREEN_DISPLAY
TERM_NOT_SYSTEM DS 0H

         CLC   =C'TR',DEVTERM_CONS_INPUT+6       SYSTEM TRACE FUNCTION?
         J     TERM_NOT_TRACE                    . Not Supprted @160705
         JNE   TERM_NOT_TRACE                    . NO
         CALLRTN SELECTED_TRACE
         J     TERMINAL_MAIN_SCREEN_DISPLAY
TERM_NOT_TRACE DS 0H

         CLI   DEVTERM_CONS_INPUT+6,C'C'         CONSOLE FUNCTION?
         JNE   TERM_NOT_CONSOLE                  . NO
TERM_GO_CONSOLE DS 0H
         CALLRTN SELECTED_CONSOLE
         CLI   DEVTERM_CONS_INPUT+6,C'='
         JNE   TERMINAL_MAIN_SCREEN_DISPLAY
         OI    DEVTERM_CONS_INPUT+7,C' '
         CLI   DEVTERM_CONS_INPUT+7,C'X'
         JE    TERM_EQUAL_X
         LARL  R15,TERM_GO_CONSOLE
         ST    R15,RET_AFTER_JUMP
         J     TERMINAL_MAIN_SCREEN_DISPLAY
TERM_NOT_CONSOLE DS 0H

         CLI   DEVTERM_CONS_INPUT+6,C'M'         STORAGE FUNCTION?
         JNE   TERM_NOT_MEMORY                   . NO
         LA    R2,1                              command entry
TERM_GO_MEMORY DS 0H
         CALLRTN SELECTED_MEMORY
         CLI   DEVTERM_CONS_INPUT+6,C'='
         JNE   TERMINAL_MAIN_SCREEN_DISPLAY
         OI    DEVTERM_CONS_INPUT+7,C' '
         CLI   DEVTERM_CONS_INPUT+7,C'X'
         JE    TERM_EQUAL_X
         LARL  R15,TERM_GO_MEMORY
         ST    R15,RET_AFTER_JUMP
         J     TERMINAL_MAIN_SCREEN_DISPLAY
TERM_NOT_MEMORY DS 0H

         CLI   DEVTERM_CONS_INPUT+6,C'D'         DEVICE FUNCTION?
         JNE   TERM_NOT_DEVICE                   . NO
         LA    R2,1                              command entry
TERM_GO_DEVICE DS 0H
         CALLRTN SELECTED_DEVICE
         CLI   DEVTERM_CONS_INPUT+6,C'='
         JNE   TERMINAL_MAIN_SCREEN_DISPLAY
         OI    DEVTERM_CONS_INPUT+7,C' '
         CLI   DEVTERM_CONS_INPUT+7,C'X'
         JE    TERM_EQUAL_X
         LARL  R15,TERM_GO_DEVICE
         ST    R15,RET_AFTER_JUMP
         J     TERMINAL_MAIN_SCREEN_DISPLAY
TERM_NOT_DEVICE DS 0H

         CLI   DEVTERM_CONS_INPUT+6,C'T'         SYSTEM TEST FUNCTION?
         JNE   TERM_NOT_TEST                     . NO
         CALLRTN SELECTED_TEST
         J     TERMINAL_MAIN_SCREEN_DISPLAY
TERM_NOT_TEST DS 0H

         CLI   DEVTERM_CONS_INPUT+6,C'H'         HELP FUNCTION?
         JNE   TERM_NOT_HELP                     . NO
         CALLRTN SELECTED_HELP
         J     TERMINAL_MAIN_SCREEN_DISPLAY
TERM_NOT_HELP DS 0H

         CLI   DEVTERM_CONS_INPUT+6,C'E'         Edit FUNCTION?
         JNE   TERM_NOT_EDIT                     . NO
TERM_GO_EDIT DS 0H
         CALLRTN SELECTED_EDIT
         CLI   DEVTERM_CONS_INPUT+6,C'='
         JNE   TERMINAL_MAIN_SCREEN_DISPLAY
         OI    DEVTERM_CONS_INPUT+7,C' '
         CLI   DEVTERM_CONS_INPUT+7,C'X'
         JE    TERM_EQUAL_X
         LARL  R15,TERM_GO_EDIT
         ST    R15,RET_AFTER_JUMP
         J     TERMINAL_MAIN_SCREEN_DISPLAY
TERM_NOT_EDIT DS 0H

         CLI   DEVTERM_CONS_INPUT+6,C'L'         Log FUNCTION?  @160705
         JNE   TERM_NOT_LOG                      . NO
TERM_GO_LOG DS 0H
         CALLRTN SELECTED_LOG
         CLI   DEVTERM_CONS_INPUT+6,C'='
         JNE   TERMINAL_MAIN_SCREEN_DISPLAY
         OI    DEVTERM_CONS_INPUT+7,C' '
         CLI   DEVTERM_CONS_INPUT+7,C'X'
         JE    TERM_EQUAL_X
         LARL  R15,TERM_GO_LOG
         ST    R15,RET_AFTER_JUMP
         J     TERMINAL_MAIN_SCREEN_DISPLAY
TERM_NOT_LOG DS 0H

         CLI   DEVTERM_CONS_INPUT+6,C'J'         Jlog FUNCTION? @160705
         JNE   TERM_NOT_JLOG                     . NO           @160705
TERM_GO_JLOG DS 0H                                              @160705
         CALLRTN SELECTED_JLOG                                  @160705
         CLI   DEVTERM_CONS_INPUT+6,C'='                        @160705
         JNE   TERMINAL_MAIN_SCREEN_DISPLAY                     @160705
         OI    DEVTERM_CONS_INPUT+7,C' '                        @160705
         CLI   DEVTERM_CONS_INPUT+7,C'X'                        @160705
         JE    TERM_EQUAL_X                                     @160705
         LARL  R15,TERM_GO_JLOG                                 @160705
         ST    R15,RET_AFTER_JUMP                               @160705
         J     TERMINAL_MAIN_SCREEN_DISPLAY                     @160705
TERM_NOT_JLOG DS 0H                                             @160705

         CLI   DEVTERM_CONS_INPUT+6,C'U'         Undial command?
         JE    TERM_GO_UNDIAL
         TM    CVT_MISC_OPTIONS,MISC_OPT_GDDR
         JNO   TERM_NOT_UNDIAL
         CLI   DEVTERM_CONS_INPUT+6,C'O'         Logoff command?
*        CLC   DEVTERM_CONS_INPUT+6(6),=C'LOGOFF'
         JNE   TERM_NOT_UNDIAL
*
*   logoff msg
*
        @CLCLEAR CONSOLE_MSG
        @FORMAT ('ECNL0015 USER ',C8,<,' LOGGED OFF TERMINAL ',X4),    +
               (TERM_USERID,CONSOLE_DEVICE_NUMBER),                    +
               AREA=CONSOLE_MSG
*       @WTO   CONSOLE_MSG,PRI=MED                              @150312
         CALLRTN ISSUE_WTO                                      @150312
        @CLCLEAR CONSOLE_MSG

         J     TERM_RESET
*
TERM_GO_UNDIAL DS 0H
         TM    CVT_OS_LEVEL0,CVT_OS_L0_VM_GUEST  Running under VM?
         JZ    TERM_NOT_NULL                     .n, invalid cmd then
         TM    CVT_MISC_OPTIONS,MISC_OPT_GDDR    issue undialed msg if
         JZ    TERM_UNDIAL_NOT_GDDR              . EVME user
*
*   undialed msg
*
        @CLCLEAR CONSOLE_MSG
        @FORMAT ('ECNL0016 USER ',C8,<,' UNDIALED TERMINAL ',X4),      +
               (TERM_USERID,CONSOLE_DEVICE_NUMBER),                    +
               AREA=CONSOLE_MSG
*       @WTO   CONSOLE_MSG,PRI=MED                              @150312
         CALLRTN ISSUE_WTO                                      @150312
        @CLCLEAR CONSOLE_MSG

TERM_UNDIAL_NOT_GDDR DS 0H
         CALLRTN SELECTED_UNDIAL

         TM    CVT_MISC_OPTIONS,MISC_OPT_GDDR
*        JO    TERM_EXIT
         JO    TERM_RESET

         CLI   DEVTERM_CONS_INPUT+6,C'='
         JNE   TERMINAL_MAIN_SCREEN_DISPLAY
         OI    DEVTERM_CONS_INPUT+7,C' '
         CLI   DEVTERM_CONS_INPUT+7,C'X'
         JE    TERM_EQUAL_X
         LARL  R15,TERM_GO_EDIT
         ST    R15,RET_AFTER_JUMP
         J     TERMINAL_MAIN_SCREEN_DISPLAY

TERM_RESET DS 0H
         NI    FLAG1,255-FLAG1_AUTH              not authenticated
         ICM   R2,B'1111',CURRENT_USER
         JZ    GDDR_SHORTCUT                     there is no user
        USING USER_CONTROL,R2
         MVC   STACK_DEVTERM_WORKAREA,DEVTERM_WORKAREA
         MVC   STACK_DEVTERM_MEMWORK,DEVTERM_MEMWORK
         MVC   STACK_CLAEDIT_RESUME,CLAEDIT_RESUME
         MVC   STACK_RET_AFTER_JUMP,RET_AFTER_JUMP
         MVC   STACK_CLFILEX,TASK_CLFILEX_ANCHOR
*
         XC    DEVTERM_WORKAREA,DEVTERM_WORKAREA
         XC    DEVTERM_MEMWORK,DEVTERM_MEMWORK
         XC    DEVTERM_USER,DEVTERM_USER
         XC    CLAEDIT_RESUME,CLAEDIT_RESUME
         XC    RET_AFTER_JUMP,RET_AFTER_JUMP     just one deep
         J     TERMINAL_MAIN_SCREEN_DISPLAY
        DROP  R2

TERM_NOT_UNDIAL DS 0H

         CLI   DEVTERM_CONS_INPUT+6,C' '         null entry?
         JNE   TERM_INPUT_INVALID                . NO           @150318
         J     TERMINAL_MAIN_SCREEN_DISPLAY      just ignore it
TERM_NOT_NULL DS 0H

*
* If the name of a module, try calling the specified program    @140303
*

         OC    DEVTERM_CONS_INPUT+7(8),=CL8' '                  @150318
         CLAYLOAD LOAD,DEVTERM_CONS_INPUT+7      LOAD program   @150318
         LTR   R15,R15                           OK ?           @140303
         JNZ   TERM_INPUT_INVALID                . no           @140303
*                                                               @140303
         ST    R0,LOAD_R0                        SAVE INFO      @140303
         ST    R1,LOAD_R1                        . . .          @140303
*                                                               @140303
         LR    R15,R0                                           @140303
         LA    R1,WRK_ENV@                                      @150204
         BALR  R14,R15                           call program   @140303
         J     TERMINAL_MAIN_SCREEN_DISPLAY      GO MAIN SCREEN @140303
*                                                               @140303
* Unrecognized input command or program name                    @140303
*                                                               @140303
TERM_INPUT_INVALID DS 0H                                        @140303
         XC    DEVTERM_CONS_INPUT,DEVTERM_CONS_INPUT CLR RESP AREA
         MVC   SCREEN_ERROR_MSG(23),=C'INVALID INPUT - REENTER'
         J     TERMINAL_MAIN_SCREEN_DISPLAY      GO DISPLAY MAIN SCREEN

TERM_EQUAL_X DS 0H
         XC    RET_AFTER_JUMP,RET_AFTER_JUMP     just one deep
         XC    DEVTERM_CONS_INPUT,DEVTERM_CONS_INPUT CLR RESP AREA
         J     TERMINAL_MAIN_SCREEN_DISPLAY      just ignore it

TERM_ABENDED DS 0H
         MVC   SCREEN_ERROR_MSG(23),=C'FUNCTION HAS ABENDED   '
         L     R10,PSA_ACTIVE_TASK               GET TASK ADDR
         TM    CVT_MISC_OPTIONS,MISC_OPT_GDDR                   @110628
         JZ    TERM_ABENDED_NOT_GDDR                            @110628
         MVI   DEVTERM_CONS_INPUT+6,C'='  SIMULATE LOGOFF ('=O')@110628
         MVI   DEVTERM_CONS_INPUT+7,C'O'         . ON ABEND     @110628
*
TERM_ABENDED_NOT_GDDR DS 0H                                     @110628
        USING #TASK,R10                         ( BASE TASK )
         ICM   R2,B'1100',TASK_ENQ_COUNT         Any serialisation ?
         JE    EOT_ENQ_DONE                      .No, bypass RESET
         SRL   R2,16                             Resource count
        @FORMAT ('TERM0003 ',C8,<,'.',C8,<,B1,O5,                      +
               ' resource(s) held at abend'),                          +
               (TASK_NAME,TASK_IDENTIFIER,(R2)),                       +
               AREA=TASK_WTO_MSG,BLANK=L'TASK_WTO_MSG
        @WTO   TASK_WTO_MSG

        @ENQ   RESET,MSGLVL=A,MF=S               Reset all

EOT_ENQ_DONE   DS 0H
         J     TERMINAL_MAIN_SCREEN_DISPLAY      GO DISPLAY MAIN SCREEN

TERM_EXIT DS 0H
         DLLQ  ANCH=CVT_DEVTERM,       program lock counter->R14       +
               F=LPLT
         DLLQ  ANCH=CVT_DEVTERM,       Dequeue our DEVTERM             +
               F=POPELE,                                               +
               ELE=#DEVTERM,                                           +
               PLOFAIL=TERM_EXIT,      Restart if queue chng           +
               WA=DLLQ_WORKAREA
         L     R10,DEVTERM_DEVICE
        @DEVVARY #OFFLINEFORCE_PENDING,DEVREQ=Y,DISP=Y,                +
               DEVICE=(R10)

         LR    R11,R13
         L     R13,4(R13)              POINT TO CALLERS SAVE AREA
         STM   R15,R1,16(R13)          SAVE   R15, R0, R1
         CLRTNSTG  SAVEREGS=N,ADDR=(R11)   FREE WORKING STORAGE
         LM    R14,R12,12(R13)         RELOAD REGISTERS
         SR    R15,R15
         BR    R14

*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*
*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*
*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*
*                                                                     *
* SUBROUTINES                                                         *
*                                                                     *
*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*
*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*
*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*

*********************************************************************
*                                                                   *
* MENU_RECOVERY_RTN                                                 *
*                                                                   *
*  INPUT: R0  ->EDWA                                                *
*         R15 ->EP                                                  *
*         R2-R14 ARE THE SAME AS OF THE TIME WHEN @ESTAE WAS ISSUED *
*                                                                   *
*                                                                   *
*********************************************************************

         PUSH  USING
         DROP  ,

MENU_RECOVERY_RTN DS 0H
         LR    R9,R15                            ENTRY POINT
         USING MENU_RECOVERY_RTN,R9              ( ROUTINE )
         LR    R5,R0                             R5 ->EDWA
         USING EDWA,R5                           ( EDWA )

         USING #PSA,0                            ( PSA )

         LARL  R12,CLATTERM_CONST                CONSTANTS AREA
         USING CLATTERM_CONST,R12                . . .

         L     R11,FLCCVT                        GET CVT ADDR
         USING #CVT,R11                          ( CVT )

         L     R10,PSA_ACTIVE_TASK               GET TASK ADDR
         USING #TASK,R10                         ( TASK )

        @WTO   'CLINIT00 ESTAE EXIT ENTERED FOR CLATTERM',PRI=HIGH

         CLC   EDWA_ID,=C'EDWA'
         JE    MENU_EDWA_GOOD
        @STOP  WSCINIT,REASON=13

MENU_EDWA_GOOD DS 0H

         MVC   EDWA_R_REGS+15*4(4),=F'24'        SET RC

         L     R2,=A(TERM_ABENDED)
        @ESTXR RETRY=YES,RETRYRTN=(R2),EDWA=(R5),DREGS=YES

         DROP  ,
         POP   USING


***********************************************************************
*                                                                     *
* CONSOLE PROCESSING                                                  *
*                                                                     *
***********************************************************************

         PUSH  USING
         DC    C'SELECTED_CONSOLE'
SELECTED_CONSOLE DS 0H
         STM   R14,R12,ROUTINE_SAVE_1

         CLAYLOAD LOAD,=CL8'CLACNSL'             LOAD CLACNSL
         LTR   R15,R15                           OK ?
         JZ    CONSOLE_LOAD_GOOD                     . YES

         ST    R0,LOAD_R0                        SAVE ERROR INFO
         ST    R1,LOAD_R1                        . . .
         ST    R15,LOAD_R15                      . . .
        @CLCLEAR CONSOLE_MSG
         MVC   CONSOLE_MSG(41),=C'ECNL0000 LOAD FOR MODULE CLACNSL FAIL+
               ED +'
        @CLCLEAR CONSOLE_MSG
         MVC   CONSOLE_MSG(61),=C'ECNL0000 R0(RS) XXXXXXXX  R1(ERROR) X+
               XXXXXXX  R15(RC) XXXXXXXX'
        @CNVTEBC FROM=LOAD_R0,TO=CONSOLE_MSG+16,LEN=4
        @CNVTEBC FROM=LOAD_R1,TO=CONSOLE_MSG+36,LEN=4
        @CNVTEBC FROM=LOAD_R15,TO=CONSOLE_MSG+54,LEN=4
*       @WTO   CONSOLE_MSG,PRI=MED                              @150312
         CALLRTN ISSUE_WTO                                      @150312
         MVC   WTO_DISP_POS,CVT_CONSOLE_WTO_CURRENT  CURRENT WTO
         J     CONSOLE_RETURN                        . YES

CONSOLE_LOAD_GOOD DS 0H
         OI    DEVTERM_FLAG1,DEVTERM_CONS_ACTIVE
         LR    R15,R0                            COPY EP ADDR
         L     R0,DEVTERM_WORKAREA                              @130613
         BASR  R14,R15                           PASS CNTL TO CLACNSL
         NI    DEVTERM_FLAG1,255-DEVTERM_CONS_ACTIVE
         CLI   DEVTERM_CONS_INPUT+6,C'='
         JNE   CONSOLE_RETURN
         LARL  R15,TERM_GO_EDIT
         ST    R15,RET_AFTER_JUMP
         ST    R1,DEVTERM_WORKAREA                              @130613

CONSOLE_RETURN DS 0H
         LM    R14,R12,ROUTINE_SAVE_1
         BR    R14
         POP   USING

***********************************************************************
*                                                                     *
* EDIT SCREEN PROCESSING                                              *
*                                                                     *
***********************************************************************

         PUSH  USING
         DC    C'SELECTED_EDIT'
SELECTED_EDIT  DS 0H
         STM   R14,R12,ROUTINE_SAVE_1
EDIT_SCREEN_ENTRY_POINT DS 0H

* Get the screen pattern

        @MOVESCR SCRNNAME=$SCREEN_EDIT,                                +
               SCRNADDR=SCR2EDIT,                                      +
               BASE=R5,DROP=YES

* Why are these two statements commented?

*        ICM   R0,B'1111',CLAEDIT_ADDR
*        JNZ   EDIT_MAIN_SCREEN_DISPLAY

* LOAD THE PROGRAM
         J     EDIT_DISPLAY
*
         CLAYLOAD LOAD,=CL8'CLAEDIT'
         LTR   R15,R15                           OK ?
         JZ    EDIT_LOAD_GOOD                    . YES
         ST    R0,LOAD_R0                        SAVE ERROR INFO
         ST    R1,LOAD_R1                        . . .
         ST    R15,LOAD_R15                      . . .
        @CLCLEAR CONSOLE_MSG
         MVC   CONSOLE_MSG(41),=C'ECNL0000 LOAD FOR MODULE CLAEDIT  FAI+
               LED +'
         MVC   CONSOLE_MSG+25(8),START_PROGRAM_NAME
*       @WTO   CONSOLE_MSG,PRI=MED                              @150312
         CALLRTN ISSUE_WTO                                      @150312
        @CLCLEAR CONSOLE_MSG
         MVC   CONSOLE_MSG(61),=C'ECNL0000 R0(RS) XXXXXXXX  R1(ERROR) X+
               XXXXXXX  R15(RC) XXXXXXXX'
        @CNVTEBC FROM=LOAD_R0,TO=CONSOLE_MSG+16,LEN=4
        @CNVTEBC FROM=LOAD_R1,TO=CONSOLE_MSG+36,LEN=4
        @CNVTEBC FROM=LOAD_R15,TO=CONSOLE_MSG+54,LEN=4
*       @WTO   CONSOLE_MSG,PRI=MED                              @150312
         CALLRTN ISSUE_WTO                                      @150312
         MVC   WTO_DISP_POS,CVT_CONSOLE_WTO_CURRENT  CURRENT WTO
         J     EDIT_RETURN

EDIT_LOAD_GOOD DS 0H
         C     R0,CLAEDIT_ADDR
         JE    EDIT_MAIN_SCREEN_DISPLAY
         ST    R0,CLAEDIT_ADDR                   SAVE ROUTINE ADDR
        @CLCLEAR CONSOLE_MSG
        @FORMAT ('ECNL0000 CLAEDIT loaded at ',X8),((R0)),             +
               AREA=CONSOLE_MSG
**      @WTO   CONSOLE_MSG,PRI=MED
         J     EDIT_MAIN_SCREEN_DISPLAY

EDIT_MAIN_SCREEN_HELP DS 0H
         LA    R3,$SCREEN_EDIT_SIZE               longer size
         J     EDIT_MAIN_SCREEN_DISPLAY2

EDIT_MAIN_SCREEN_DISPLAY DS 0H
         LA    R3,$SCREEN_EDIT_SIZE1              normal shorter size

EDIT_MAIN_SCREEN_DISPLAY2 DS 0H
         ICM   R0,B'1111',CLAEDIT_RESUME          Possible resume
         BNZ   NAME_DONE
         MVC   $EDITDSN,EDIT_DATASET
         MVC   $EDITVOL,EDIT_VOLUME
         MVC   $EDITCUU,EDIT_CCUU
        @CNSLIO TYPE=WRITE,                                            +
               MOD=2,                  - was 4, why? -                 +
               SCREEN=$SCREEN_EDIT,                                    +
               SCRNSIZE=(R3)
         LR    R8,R1                             COPY IOREQ ADDR

* WAIT FOR THE USER

        @NIL   IOREQ_FLAG1_CS,                   IRB IS OLD            +
               X'FF'-#IRB_STORED,                                      +
               REF=IOREQ_FLAGS_CS

        @WAITIO QUEUE=TASK,                      WAIT FOR ATTN         +
               EMPTY=WAIT
         LR    R8,R1                             COPY IOREQ ADDR
*
         ICM   R15,B'1111',DEVTERM_USER
         JZ    EDIT_NO_USER1

         CLC   DEVTERM_CONS_INPUT(08),=X'7D40C31140C17ED6'
         JE    EDIT_CHECK_INPUT
*
EDIT_NO_USER1 DS 0H
         TM    IOREQ_FLAG1_CS,#IRB_STORED        IRB STORED?
         JNO   EDIT_MAIN_SCREEN_DISPLAY2

         TM    IRBDSTAT,IRBDSATN                 ATTENTION?
         JO    EDIT_GET_INPUT                    . YES, GO GET INPUT

         ICM   R15,B'1111',DEVTERM_USER
         JZ    EDIT_NO_USER
         MVC   DEVTERM_CONS_INPUT(08),=X'7D40C31140C17ED6'
         J     EDIT_CHECK_INPUT
*
EDIT_NO_USER DS 0H
        @WTO   'EEDIT000 INVALID INPUT',                               +
               PRI=HIGH
         J     EDIT_SCREEN_ENTRY_POINT           GO REDISPLAY

EDIT_GET_INPUT DS 0H
         XC    DEVTERM_CONS_INPUT,DEVTERM_CONS_INPUT CLR RESP AREA
        @CNSLIO TYPE=READ                        READ USER INPUT
         LR    R8,R1                             COPY IOREQ ADDR

* PF 1 (EDIT HELP)

         CLI   DEVTERM_CONS_INPUT,PFK1           HELP?
         JE    EDIT_MAIN_SCREEN_HELP               . YES

* PF 3 (EXIT EDIT)

         CLI   DEVTERM_CONS_INPUT,PFK3           EXIT EDIT?
         JE    EDIT_RETURN                         . YES

* ENTER

         CLI   DEVTERM_CONS_INPUT,ENTER          ENTER?
         JE    EDIT_CHECK_INPUT
        @WTO   'EEDIT000 ENTER AND PF3 SUPPORTED FOR NOW'
         J     EDIT_SCREEN_ENTRY_POINT

EDIT_CHECK_INPUT DS 0H
         XC    EDIT_DATASET,EDIT_DATASET
         XC    EDIT_VOLUME,EDIT_VOLUME
         XC    EDIT_CCUU,EDIT_CCUU
         LA    R3,DEVTERM_CONS_INPUT+3 past the aid and cursor
*
* Input R3 points to the console buffer containing the dsname
*
EDIT_CHECK_OUTER DS 0H
         CLI   0(R3),X'11'          sba?
         JNE   NAME_DONE
        @ROWCOL 1(R3)               relative to zero
         LA    R3,3(,R3)
         LA    R0,54                   avoid runaway
         LA    R15,FORMAT_STG
         XC    FORMAT_STG,FORMAT_STG
*
EDIT_CHECK_INNER DS 0H
         CLI   0(R3),C' '
         JE    EDIT_CHECK_SKIP
         JL    EDIT_CHECK_WHAT
         MVC   0(1,R15),0(R3)
         LA    R15,1(,R15)
*
EDIT_CHECK_SKIP DS 0H
         LA    R3,1(,R3)
         JCT   R0,EDIT_CHECK_INNER
*
EDIT_CHECK_WHAT DS 0H
         CLI   FORMAT_STG,C'='        avoid wiping out prior value
         JNE   EDIT_CHECK_THIS
         CLI   FORMAT_STG+2,C' '
         JH    EDIT_CHECK_OUTER
         MVC   DEVTERM_CONS_INPUT+6(8),FORMAT_STG
         J     EDIT_RETURN
*
EDIT_CHECK_THIS DS 0H
         LA    R15,EDIT_DATASET
         CHI   R1,2                   row 2?
         JE    EDIT_CHECK_EXT_DSN
         LA    R15,EDIT_VOLUME
         CHI   R1,3                   row 3?
         JE    EDIT_CHECK_EXT_VOL
         LA    R15,EDIT_CCUU
         CHI   R1,4                   row 4?
         JE    EDIT_CHECK_EXT_CUU
         J     NAME_DONE
*
EDIT_CHECK_EXT_DSN DS 0H
         MVC   EDIT_DATASET,FORMAT_STG
         J     EDIT_CHECK_OUTER
*
EDIT_CHECK_EXT_VOL DS 0H
         MVC   EDIT_VOLUME,FORMAT_STG
         J     EDIT_CHECK_OUTER
*
EDIT_CHECK_EXT_CUU DS 0H
         MVC   EDIT_CCUU,FORMAT_STG
         J     EDIT_CHECK_OUTER
*
EDIT_DISPLAY DS 0H
         L     R15,CVT_CLAISPF@
         LA    R0,WRK_ENV@
        CALLRTN (R15),(=C'EDIT',=C'EDIHINIT'),TYPE=CLAISPF
NAME_DONE DS 0H
        @FORMAT AREA=$EDIT_SCREEN_ERROR,BLANK=L'$EDIT_SCREEN_ERROR
         L     R15,CLAEDIT_ADDR                  Routine addr
         ICM   R0,B'1111',CLAEDIT_RESUME         Possible resume
         JZ    EDIT_CALL                         it's not
         LR    R1,R0
         ST    R1,8(,R13)                        re-link save areas
*        ST    R13,4(,R1)                             "         @130201

EDIT_CALL DS 0H
         LA    R1,DEVTERM_CONS_INPUT             Pass input data
         BASR  R14,R15

* if R15 = -1, then we will later resume the edit

         LTR   R15,R15
         JZ    EDIT_RETRY               was EDIT_RETURN
         SR    R0,R0
         BCTR  R0,0
         CR    R15,R0
         JNE   EDIT_ERROR

* Edit wants to be able to resume - R1 is resume info

         ST    R1,CLAEDIT_RESUME
         J     EDIT_EXIT                         CONTINUE

EDIT_RETRY DS 0H
         XC    CLAEDIT_RESUME,CLAEDIT_RESUME
         J     EDIT_SCREEN_ENTRY_POINT

EDIT_ERROR DS 0H
         CHI   R15,MAX_EDIT_ERR           RC in MSG range?      @110628
         JH    EDIT_ERROR_DEFAULT_MSG     .N, use dflt msg      @110628
         BCTR  R15,0                      .Y, (no msg 0)        @110628
         MHI   R15,EDIT_ERRMSG_SIZE       . .                   @110628
         LA    R15,EDIT_ERROR_MSGS(R15)   Get emsg correpsndng  @110628
         MVC   $EDIT_SCREEN_ERROR,0(R15)  . to return code      @110628
         J     EDIT_ERROR_NON_DEF_MSG     . and display it      @110628
*
EDIT_ERROR_DEFAULT_MSG DS 0H                                    @110628
        @FORMAT ('Return code=',O4),((R15)),AREA=$EDIT_SCREEN_ERROR,   +
               BLANK=L'$EDIT_SCREEN_ERROR
*
EDIT_ERROR_NON_DEF_MSG DS 0H                                    @110628
         XC    CLAEDIT_RESUME,CLAEDIT_RESUME
         J     EDIT_MAIN_SCREEN_DISPLAY

EDIT_RETURN DS 0H
         XC    CLAEDIT_RESUME,CLAEDIT_RESUME

EDIT_EXIT DS 0H
         LM    R14,R12,ROUTINE_SAVE_1
         BR    R14
         POP   USING

***********************************************************************
*                                                                     *
* LOG PROCESSING                                                      *
*                                                                     *
***********************************************************************

         PUSH  USING
         DC    C'SELECTED_LOG'
SELECTED_LOG   DS 0H
         STM   R14,R12,ROUTINE_SAVE_1
LOG_SCREEN_ENTRY_POINT DS 0H

         ICM   R0,B'1111',CLAEDIT_LOG_RESUME     Possible resume
         BNZ   LOG_NAME_DONE

* LOAD THE PROGRAM

         CLAYLOAD LOAD,=CL8'CLAEDIT'
         LTR   R15,R15                           OK ?
         JZ    LOG_LOAD_GOOD                     . YES
         ST    R0,LOAD_R0                        SAVE ERROR INFO
         ST    R1,LOAD_R1                        . . .
         ST    R15,LOAD_R15                      . . .
        @CLCLEAR CONSOLE_MSG
         MVC   CONSOLE_MSG(41),=C'ECNL0000 LOAD FOR MODULE CLAEDIT  FAI+
               LED +'
         MVC   CONSOLE_MSG+25(8),START_PROGRAM_NAME
*       @WTO   CONSOLE_MSG,PRI=MED                              @150312
         CALLRTN ISSUE_WTO                                      @150312
        @CLCLEAR CONSOLE_MSG
         MVC   CONSOLE_MSG(61),=C'ECNL0000 R0(RS) XXXXXXXX  R1(ERROR) X+
               XXXXXXX  R15(RC) XXXXXXXX'
        @CNVTEBC FROM=LOAD_R0,TO=CONSOLE_MSG+16,LEN=4
        @CNVTEBC FROM=LOAD_R1,TO=CONSOLE_MSG+36,LEN=4
        @CNVTEBC FROM=LOAD_R15,TO=CONSOLE_MSG+54,LEN=4
*       @WTO   CONSOLE_MSG,PRI=MED                              @150312
         CALLRTN ISSUE_WTO                                      @150312
         MVC   WTO_DISP_POS,CVT_CONSOLE_WTO_CURRENT  CURRENT WTO
         J     LOG_RETURN

LOG_LOAD_GOOD DS 0H
         C     R0,CLAEDIT_ADDR
         JE    LOG_MAIN_SCREEN_DISPLAY
         ST    R0,CLAEDIT_ADDR                   SAVE ROUTINE ADDR
        @CLCLEAR CONSOLE_MSG
        @FORMAT ('ECNL0000 CLAEDIT loaded at ',X8),((R0)),             +
               AREA=CONSOLE_MSG
**      @WTO   CONSOLE_MSG,PRI=MED
         J     LOG_MAIN_SCREEN_DISPLAY

*
* Going directly to log - simulate user entry
*
LOG_MAIN_SCREEN_DISPLAY DS 0H

LOG_GET_INPUT DS 0H
         XC    DEVTERM_CONS_INPUT,DEVTERM_CONS_INPUT CLR RESP AREA

* ENTER

         MVI   DEVTERM_CONS_INPUT,ENTER          ENTER?
         MVC   DEVTERM_CONS_INPUT+6(8),=CL8'=SYSLOG'
*
LOG_NAME_DONE DS 0H
         L     R15,CLAEDIT_ADDR                  Routine addr
         ICM   R0,B'1111',CLAEDIT_LOG_RESUME     Possible resume
         JZ    LOG_CALL                          it's not
         LR    R1,R0
         ST    R1,8(,R13)                        re-link save areas
*        ST    R13,4(,R1)                             "         @130306

LOG_CALL DS 0H
         LA    R1,DEVTERM_CONS_INPUT             Pass input data
         BASR  R14,R15

* if R15 = -1, then we will later resume the edit

         LTR   R15,R15
         JZ    LOG_RETRY               was EDIT_RETURN
         SR    R0,R0
         BCTR  R0,0
         CR    R15,R0
         JNE   LOG_ERROR

* Edit wants to be able to resume - R1 is resume info

         ST    R1,CLAEDIT_LOG_RESUME
         J     LOG_EXIT                         CONTINUE

LOG_RETRY DS 0H
         XC    CLAEDIT_LOG_RESUME,CLAEDIT_LOG_RESUME
*        J     LOG_SCREEN_ENTRY_POINT
         LARL  R3,TERM_GO_LOG
         CL    R3,RET_AFTER_JUMP
         JNE   LOG_RETURN
         XC    RET_AFTER_JUMP,RET_AFTER_JUMP
         J     LOG_RETURN

LOG_ERROR DS 0H
*       @FORMAT ('Return code=',O4),((R15)),AREA=$EDIT_SCREEN_ERROR,   +
               BLANK=L'$EDIT_SCREEN_ERROR
         XC    CLAEDIT_LOG_RESUME,CLAEDIT_LOG_RESUME
         J     LOG_MAIN_SCREEN_DISPLAY

LOG_RETURN DS 0H
         XC    CLAEDIT_LOG_RESUME,CLAEDIT_LOG_RESUME

LOG_EXIT DS 0H
         LM    R14,R12,ROUTINE_SAVE_1
         BR    R14
         POP   USING

***********************************************************************
*                                                                     *
* JLOG PROCESSING                                               @160705
*                                                                     *
***********************************************************************

         PUSH  USING
         DC    C'SELECTED_JLOG'                                 @160705
SELECTED_JLOG  DS 0H                                            @160705
         STM   R14,R12,ROUTINE_SAVE_1
JLOG_SCREEN_ENTRY_POINT DS 0H

         ICM   R0,B'1111',CLAEDIT_JLOG_RESUME    Possible resume
         BNZ   JLOG_NAME_DONE

* LOAD THE PROGRAM

         CLAYLOAD LOAD,=CL8'CLAEDIT'
         LTR   R15,R15                           OK ?
         JZ    JLOG_LOAD_GOOD                    . YES
         ST    R0,LOAD_R0                        SAVE ERROR INFO
         ST    R1,LOAD_R1                        . . .
         ST    R15,LOAD_R15                      . . .
        @CLCLEAR CONSOLE_MSG
         MVC   CONSOLE_MSG(41),=C'ECNL0000 LOAD FOR MODULE CLAEDIT  FAI+
               LED +'
         MVC   CONSOLE_MSG+25(8),START_PROGRAM_NAME
*       @WTO   CONSOLE_MSG,PRI=MED
         CALLRTN ISSUE_WTO
        @CLCLEAR CONSOLE_MSG
         MVC   CONSOLE_MSG(61),=C'ECNL0000 R0(RS) XXXXXXXX  R1(ERROR) X+
               XXXXXXX  R15(RC) XXXXXXXX'
        @CNVTEBC FROM=LOAD_R0,TO=CONSOLE_MSG+16,LEN=4
        @CNVTEBC FROM=LOAD_R1,TO=CONSOLE_MSG+36,LEN=4
        @CNVTEBC FROM=LOAD_R15,TO=CONSOLE_MSG+54,LEN=4
*       @WTO   CONSOLE_MSG,PRI=MED
         CALLRTN ISSUE_WTO
         MVC   WTO_DISP_POS,CVT_CONSOLE_WTO_CURRENT  CURRENT WTO
         J     JLOG_RETURN

JLOG_LOAD_GOOD DS 0H
         C     R0,CLAEDIT_ADDR
         JE    JLOG_MAIN_SCREEN_DISPLAY
         ST    R0,CLAEDIT_ADDR                   SAVE ROUTINE ADDR
        @CLCLEAR CONSOLE_MSG
        @FORMAT ('ECNL0000 CLAEDIT loaded at ',X8),((R0)),             +
               AREA=CONSOLE_MSG
**      @WTO   CONSOLE_MSG,PRI=MED
         J     JLOG_MAIN_SCREEN_DISPLAY

*
* Going directly to log - simulate user entry
*
JLOG_MAIN_SCREEN_DISPLAY DS 0H

JLOG_GET_INPUT DS 0H
         XC    DEVTERM_CONS_INPUT,DEVTERM_CONS_INPUT CLR RESP AREA

* ENTER

         MVI   DEVTERM_CONS_INPUT,ENTER          ENTER?
         MVC   DEVTERM_CONS_INPUT+6(8),=CL8'=JLOG  '
*
JLOG_NAME_DONE DS 0H
         L     R15,CLAEDIT_ADDR                  Routine addr
         ICM   R0,B'1111',CLAEDIT_JLOG_RESUME    Possible resume
         JZ    JLOG_CALL                         it's not
         LR    R1,R0
         ST    R1,8(,R13)                        re-link save areas
*        ST    R13,4(,R1)                             "

JLOG_CALL DS 0H
         LA    R1,DEVTERM_CONS_INPUT             Pass input data
         BASR  R14,R15

* if R15 = -1, then we will later resume the edit

         LTR   R15,R15
         JZ    JLOG_RETRY              was EDIT_RETURN
         SR    R0,R0
         BCTR  R0,0
         CR    R15,R0
         JNE   JLOG_ERROR

* Edit wants to be able to resume - R1 is resume info

         ST    R1,CLAEDIT_JLOG_RESUME
         J     JLOG_EXIT                        CONTINUE

JLOG_RETRY DS 0H
         XC    CLAEDIT_JLOG_RESUME,CLAEDIT_JLOG_RESUME
*        J     JLOG_SCREEN_ENTRY_POINT
         LARL  R3,TERM_GO_JLOG
         CL    R3,RET_AFTER_JUMP
         JNE   JLOG_RETURN
         XC    RET_AFTER_JUMP,RET_AFTER_JUMP
         J     JLOG_RETURN

JLOG_ERROR DS 0H
*       @FORMAT ('Return code=',O4),((R15)),AREA=$EDIT_SCREEN_ERROR,   +
               BLANK=L'$EDIT_SCREEN_ERROR
         XC    CLAEDIT_JLOG_RESUME,CLAEDIT_JLOG_RESUME
         J     JLOG_MAIN_SCREEN_DISPLAY

JLOG_RETURN DS 0H
         XC    CLAEDIT_JLOG_RESUME,CLAEDIT_JLOG_RESUME

JLOG_EXIT DS 0H                                                 @160705
        @CLCLEAR SCREEN_ERROR_MSG                               @160705
         LM    R14,R12,ROUTINE_SAVE_1                           @160705
         BR    R14                                              @160705
         POP   USING

***********************************************************************
*                                                                     *
* STORAGE SCREEN PROCESSING                                           *
*                                                                     *
***********************************************************************

         PUSH  USING
         DC    C'SELECTED_MEMORY'
SELECTED_MEMORY DS 0H
         STM   R14,R12,ROUTINE_SAVE_1

         CLAYLOAD LOAD,=CL8'CLAVSE'              LOAD CLAVSE
         LTR   R15,R15                           OK ?
         JZ    VSE_LOAD_GOOD                     . YES
         ST    R0,LOAD_R0                        SAVE ERROR INFO
         ST    R1,LOAD_R1                        . . .
         ST    R15,LOAD_R15                      . . .
        @CLCLEAR CONSOLE_MSG
         MVC   CONSOLE_MSG(41),=C'ECNL0000 LOAD FOR MODULE CLAVSE FAILE+
               D +'
        @CLCLEAR CONSOLE_MSG
         MVC   CONSOLE_MSG(61),=C'ECNL0000 R0(RS) XXXXXXXX  R1(ERROR) X+
               XXXXXXX  R15(RC) XXXXXXXX'
        @CNVTEBC FROM=LOAD_R0,TO=CONSOLE_MSG+16,LEN=4
        @CNVTEBC FROM=LOAD_R1,TO=CONSOLE_MSG+36,LEN=4
        @CNVTEBC FROM=LOAD_R15,TO=CONSOLE_MSG+54,LEN=4
*       @WTO   CONSOLE_MSG,PRI=MED                              @150312
         CALLRTN ISSUE_WTO                                      @150312
         MVC   WTO_DISP_POS,CVT_CONSOLE_WTO_CURRENT  CURRENT WTO
         J     VSE_RETURN

VSE_LOAD_GOOD DS 0H
         LR    R15,R0                            COPY EP ADDR
         L     R0,DEVTERM_MEMWORK
         SR    R1,R1                             FLAG TO DO MEMORY MGR
         BASR  R14,R15                           PASS CONTROL TO CLAVSE

* if R15 = -1, then we will later resume                        @130613

         LTR   R15,R15                                          @130613
         JZ    VSE_RETURN                                       @130613
         SR    R0,R0                                            @130613
         BCTR  R0,0                                             @130613
         CR    R15,R0                                           @130613
         JNE   VSE_RETURN                                       @130613

* VSE wants to be able to resume - R1 is resume info            @130613

         ST    R1,DEVTERM_MEMWORK                               @130613

VSE_RETURN DS 0H
         LM    R14,R12,ROUTINE_SAVE_1
         BR    R14
         POP   USING

***********************************************************************
*                                                                     *
* DEVICE SCREEN PROCESSING                                            *
*                                                                     *
***********************************************************************

         PUSH  USING
         DC    C'SELECTED_DEVICE'
SELECTED_DEVICE DS 0H
         STM   R14,R12,ROUTINE_SAVE_1

         CLAYLOAD LOAD,=CL8'CLAVSE'              LOAD CLAVSE
         LTR   R15,R15                           OK ?
         JZ    DDV_LOAD_GOOD                     . YES
         ST    R0,LOAD_R0                        SAVE ERROR INFO
         ST    R1,LOAD_R1                        . . .
         ST    R15,LOAD_R15                      . . .
        @CLCLEAR CONSOLE_MSG
         MVC   CONSOLE_MSG(41),=C'ECNL0000 LOAD FOR MODULE CLAVSE   FAI+
               LED +'
        @CLCLEAR CONSOLE_MSG
         MVC   CONSOLE_MSG(61),=C'ECNL0000 R0(RS) XXXXXXXX  R1(ERROR) X+
               XXXXXXX  R15(RC) XXXXXXXX'
        @CNVTEBC FROM=LOAD_R0,TO=CONSOLE_MSG+16,LEN=4
        @CNVTEBC FROM=LOAD_R1,TO=CONSOLE_MSG+36,LEN=4
        @CNVTEBC FROM=LOAD_R15,TO=CONSOLE_MSG+54,LEN=4
*       @WTO   CONSOLE_MSG,PRI=MED                              @150312
         CALLRTN ISSUE_WTO                                      @150312
         MVC   WTO_DISP_POS,CVT_CONSOLE_WTO_CURRENT  CURRENT WTO
         J     DDV_RETURN

DDV_LOAD_GOOD DS 0H
         LR    R15,R0                  COPY EP ADDR
         L     R0,DEVTERM_MEMWORK      possible resume
         LA    R1,1                    FLAG TO DISPLAY CONTROLLER(S)
         BASR  R14,R15                 PASS CONTROL TO CLAVSE

DDV_RETURN DS 0H
         LM    R14,R12,ROUTINE_SAVE_1
         BR    R14
         POP   USING

***********************************************************************
*                                                                     *
* TRACE SCREEN PROCESSING                                             *
*                                                                     *
***********************************************************************

         PUSH  USING
         DC    C'SELECTED_TRACE'
SELECTED_TRACE DS 0H
         STM   R14,R12,ROUTINE_SAVE_1

         CLAYLOAD LOAD,=CL8'CLATRAVW'            LOAD CLAVSE
         LTR   R15,R15                           OK ?
         JZ    TRV_LOAD_GOOD                     . YES
         ST    R0,LOAD_R0                        SAVE ERROR INFO
         ST    R1,LOAD_R1                        . . .
         ST    R15,LOAD_R15                      . . .
        @CLCLEAR CONSOLE_MSG
         MVC   CONSOLE_MSG(41),=C'ECNL0000 LOAD FOR MODULE CLATRAVW FAI+
               LED +'
        @CLCLEAR CONSOLE_MSG
         MVC   CONSOLE_MSG(61),=C'ECNL0000 R0(RS) XXXXXXXX  R1(ERROR) X+
               XXXXXXX  R15(RC) XXXXXXXX'
        @CNVTEBC FROM=LOAD_R0,TO=CONSOLE_MSG+16,LEN=4
        @CNVTEBC FROM=LOAD_R1,TO=CONSOLE_MSG+36,LEN=4
        @CNVTEBC FROM=LOAD_R15,TO=CONSOLE_MSG+54,LEN=4
*       @WTO   CONSOLE_MSG,PRI=MED                              @150312
         CALLRTN ISSUE_WTO                                      @150312
         MVC   WTO_DISP_POS,CVT_CONSOLE_WTO_CURRENT  CURRENT WTO
         J     TRV_RETURN

TRV_LOAD_GOOD DS 0H
         LR    R15,R0                  COPY EP ADDR
         L     R0,DEVTERM_MEMWORK      possible resume
         LA    R1,1                    FLAG TO DISPLAY CONTROLLER(S)
         BASR  R14,R15                 PASS CONTROL TO CLATRAVW

*        MVC   SCREEN_ERROR_MSG(5),=C'TRACE'

TRV_RETURN DS 0H
         LM    R14,R12,ROUTINE_SAVE_1
         BR    R14
         POP   USING

***********************************************************************
*                                                                     *
* SYSTEM SCREEN PROCESSING                                            *
*                                                                     *
***********************************************************************

         PUSH  USING
         DC    C'SELECTED_SYSTEM'
SELECTED_SYSTEM DS 0H
         STM   R14,R12,ROUTINE_SAVE_1

         MVC   SCREEN_ERROR_MSG(6),=C'SYSTEM'

         LM    R14,R12,ROUTINE_SAVE_1
         BR    R14
         POP   USING

***********************************************************************
*                                                                     *
* TEST SCREEN PROCESSING                                              *
*                                                                     *
***********************************************************************

         PUSH  USING
         DC    C'SELECTED_TEST'
SELECTED_TEST  DS 0H
         STM   R14,R12,ROUTINE_SAVE_1

         MVC   SCREEN_ERROR_MSG(4),=C'TEST'

         LM    R14,R12,ROUTINE_SAVE_1
         BR    R14
         POP   USING

***********************************************************************
*                                                                     *
* HELP SCREEN PROCESSING                                              *
*                                                                     *
***********************************************************************

         PUSH  USING
         DC    C'SELECTED_HELP'
SELECTED_HELP  DS 0H
         STM   R14,R12,ROUTINE_SAVE_1

         MVC   SCREEN_ERROR_MSG(4),=C'HELP'

         LM    R14,R12,ROUTINE_SAVE_1
         BR    R14
         POP   USING

***********************************************************************
*                                                                     *
* UNDIAL      PROCESSING                                              *
*                                                                     *
***********************************************************************

         PUSH  USING
         DC    C'SELECTED_UNDIAL'
SELECTED_UNDIAL DS 0H
         STM   R14,R12,ROUTINE_SAVE_1

         MVC   SCREEN_ERROR_MSG(6),=C'UNDIAL'

        @FORMAT ('RESET ',X4),(CONSOLE_DEVICE_NUMBER),                 +
               AREA=WTO_MSG
         LA    R0,WTO_MSG
         LA    R1,6+4
         DIAG  R0,R1,X'08'        reset the graf


         LM    R14,R12,ROUTINE_SAVE_1
         BR    R14
         POP   USING
***********************************************************************
*                                                                     *
* ISSUE_WTO                                                     @150312
*                                                               @150312
***********************************************************************

         PUSH  USING                                            @150312
         DC    C'ISSUE_WTO'                                     @150312
ISSUE_WTO DS 0H                                                 @150312
         ST    R14,SAVE_R14                                     @150312
*                                                               @150312
        @WTO   CONSOLE_MSG,PRI=MED                              @150312
*                                                               @150312
         L     R14,SAVE_R14                                     @150312
         BR    R14                                              @150312
         POP   USING                                            @150312
***********************************************************************
*                                                                     *
* CONSTANT AREA                                                       *
*                                                                     *
***********************************************************************

CLATTERM_CONST DS 0D
         DC    C'CLATTERM CONSTANTS AREA'

         COPY  @TRTAB

         LTORG ,

@STCK_MONTH DC AL1(31,28,31,30,31,30,31,31,30,31,30,31) MONTH TABLE
@STCK_LEAP  DC AL1(31,29,31,30,31,30,31,31,30,31,30,31) LEAP YEAR
CAPS        DC 80X'40'
UNPACKT     DC C'0123456789ABCDEF'

*                                                               @110628
*        emsgs same length as SCREEN_ERROR_MSG                  @110628
AUTH_EMSGS DS 0H                                                @110628
*        --    cl30'123456789 123456789 123456789 '             @110628
         DC    CL30'Invalid authorization call    '  0 : (<0/-1)@110628
         DC    CL30'Invalid password              '  4          @110628
         DC    CL30'Userid is not authorized      '  8          @110628
         DC    CL30'EVME not authorized           ' 12          @110628
         DC    CL30'Userid is not valid           ' 16          @110628
         DC    CL30'Unauthorized user             ' 20 :lockdown@110628
MAX_EMSG EQU   (*-AUTH_EMSGS)/30                                @110628
*                                                               @110628
*                                                               @110628
*        emsgs same length as SCREEN_ERROR_MSG                  @110628
EDIT_ERROR_MSGS DS 0H                                           @110628
*        --    cl30'123456789 123456789 123456789 '             @110628
         DC    CL30'Volser not found              '  1          @110628
EDIT_ERRMSG_SIZE EQU *-EDIT_ERROR_MSGS                          @110628
         DC    CL30'CUU has invalid characters    '  2          @110628
         DC    CL30'CUU not found                 '  3          @110628
         DC    CL30'Device not CLASS DASD         '  4          @110628
         DC    CL30'Error getting storage         '  5          @110628
         DC    CL30' ** available **              '  6          @110628
         DC    CL30'File has unknown format       '  7          @110628
         DC    CL30'I/O error trying to read VTOC '  8          @110628
MAX_EDIT_ERR   EQU  (*-EDIT_ERROR_MSGS)/30                      @110628
*                                                               @110628
*                                                               @110628
ENTER_MSG DC   CL30'Enter userid and password or P'             @110628
ENTER_XTRA DC  CL9'F3       '                                   @110628
*                                                               @110628
SELECT_PARM_LN DC H'30'
SELECT_PARM DC CL30'PANEL(SCR1HELP)    '
CLAEDIT_PARAMS   DC =X'7D4040114040'
CLAEDIT_FILENAME DC =CL44' '             DATASET NAME
                 DC =X'114040'
CLAEDIT_VOLSER   EQU *-CLAEDIT_PARAMS
                 DC =CL6' '              VOLSER
                 DC =X'114040'
CLAEDIT_CUU      EQU *-CLAEDIT_PARAMS
                 DC =CL4' '              CUU
CLAEDIT_PARAMS_LN EQU *-CLAEDIT_PARAMS
********************************
* GETMAINED READ/WRITE STORAGE *
********************************

WORKAREA DSECT
SAVEAREA       DS 18F
ROUTINE_SAVE_1 DS 18F
SAVE_R14       DS   F                                           @150312

CURRENT_USER      DS A            current USER_CONTROL
CHANPGM           DS 8D                                         @110801

LOAD_R0           DS F
LOAD_R1           DS F
LOAD_R15          DS F

WTO_DISP_POS       DS A
DISPLAY_TASK_ADDR  DS A
CLAEDIT_ADDR       DS A            ADDRESS OF CLAEDIT
CLAEDIT_RESUME     DS A
CLAEDIT_LOG_RESUME DS A
CLAEDIT_JLOG_RESUME DS A                                        @160705
RET_AFTER_JUMP     DS A            return to last application

STCKDBL  DS D
DATE     DS CL8
TIME     DS CL8
DAY      DS C

FLAG1    DS    X
FLAG1_RETURN_EDIT  EQU  X'80'     no longer used
FLAG1_AUTH         EQU  X'01'     authentication done
FLAG1_PRECONS      EQU  X'02'     MCS console pre-existed       @110801

CONSOLE_DEVICE_NUMBER  DS XL2
EDIT_DATASET           DS CL44
EDIT_VOLUME            DS CL6
EDIT_CCUU              DS CL5
EDIT_PARAMS            DS CL(CLAEDIT_PARAMS_LN)

LOAD_SAVEAREA  DS 18F
LOAD_PARMAREA  CLAYLOAD MF=L
               FORMATN  MF=L
               @CNVTDEC MF=L

START_PROGRAM_NAME DS CL8
TERM_USERID        DS CL8
FORMAT_STG         DS XL44    big enough for dsname
       ORG  FORMAT_STG
TERM_PASSWORD      DS CL32
       ORG  ,
SCREEN_ERROR_MSG DS CL30
CONSOLE_MSG      DS CL80

WTO_MSG          DS CL68
PLIST            DS 6F
       ORG PLIST                                                @110801
STIML         @ZTIMER MF=L                                      @110801
       ORG ,                                                    @110801

DLLQ_WORKAREA    DLLQ F=WA
*                                                               @110801
         IEZMGCR  DSECT=NO                                      @110801
*                                                               @110801
MCSOPER    MCSOPER  ,MF=L                                       @110801
MCSOPMSG   MCSOPMSG ,MF=L                                       @110801
MGCRE      MGCRE    ,MF=L                                       @110801
*                                                               @110801
OPERPARM      DS    F                                           @110801
MSGECB        DS    F                  MSGECB                   @110801
MCSCSA        DS    0F                 MCSCSA                   @110801
MCSCSAA       DS    0F                 MCSCSAA                  @110801
RTNCODE       DS    0F                 RTNCODE                  @110801
RSNCODE       DS    0F                 RSNCODE                  @110801
              DS    F                                           @110801
CONSID        DS    F                  THE CONSOLE HANDLE       @110801
*                                                               @150204
WRK_ENV@    DS A                                                @150204
ENV_BLOCK   DS XL(ENVBLOCK_DSLN)                                @150204
           DS   0D                                              @150204
EXT_BLOCK  DS   XL(IRXEXTE_DSLN)                                @150204
*                                                               @150204
WORKAREA_LEN EQU *-WORKAREA


****************************
* SCREENS                  *
****************************

$SCREEN_MAIN    SCR1MAIN CSECT=NO
$SCREEN_EDIT    SCR1EDIT CSECT=NO
$SCREEN_HELP    SCR1HELP CSECT=NO
$SCREEN_VMEN    SCR1VMEN CSECT=NO

*****************************
* CLAIPL00 WAIT STATE CODES *
*****************************

        @WSCODES

****************************
* DSECTS                   *
****************************

         @REGEQU  ,               GENERAL REGISTERS
         @PFKEQU  ,               PROGRAM FUNCTION KEYS
         #PSA     ,               CLAY PSA
         #TASK    ,               CLAY TASK
         #DEVICE  ,               CLAY DEVICE
         #IOREQ   ,               CLAY IOREQ
         #WTOREC  ,               CLAY WTOREC
         #EDWA    ,               CLAY Diag Work Area
         #ESCB    ,               CLAY ESTAE
         #DEVTERM ,               CLAY TERMINAL DEVICE DEFINITION
         #USER    ,               EMVE USER DEFINITION
         #CLFILEX ,               CLAY CLFILEX
         @CHEMREQ REVINFO,MF=D    Chem request revision info area

         END   CLATTERM
