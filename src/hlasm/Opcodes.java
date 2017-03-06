package hlasm;

import java.util.HashMap;
import javax.xml.bind.DatatypeConverter;
public class Opcodes { 


public static HashMap<String,Opcode> opcodes = new HashMap<>();
    public static final Opcode OP_A = new Opcode(DatatypeConverter.parseHexBinary("5a"),"A",OpcodeType.RX_RRRD,"add","g5","esa,zarch");
    public static final Opcode OP_AD = new Opcode(DatatypeConverter.parseHexBinary("6a"),"AD",OpcodeType.RX_FRRD,"add normalized (long)","g5","esa,zarch");
    public static final Opcode OP_ADR = new Opcode(DatatypeConverter.parseHexBinary("2a"),"ADR",OpcodeType.RR_FF,"add normalized (long)","g5","esa,zarch");
    public static final Opcode OP_AE = new Opcode(DatatypeConverter.parseHexBinary("7a"),"AE",OpcodeType.RX_FRRD,"add normalized (short)","g5","esa,zarch");
    public static final Opcode OP_AER = new Opcode(DatatypeConverter.parseHexBinary("3a"),"AER",OpcodeType.RR_FF,"add normalized (short)","g5","esa,zarch");
    public static final Opcode OP_AH = new Opcode(DatatypeConverter.parseHexBinary("4a"),"AH",OpcodeType.RX_RRRD,"add halfword","g5","esa,zarch");
    public static final Opcode OP_AL = new Opcode(DatatypeConverter.parseHexBinary("5e"),"AL",OpcodeType.RX_RRRD,"add logical","g5","esa,zarch");
    public static final Opcode OP_ALR = new Opcode(DatatypeConverter.parseHexBinary("1e"),"ALR",OpcodeType.RR_RR,"add logical","g5","esa,zarch");
    public static final Opcode OP_AP = new Opcode(DatatypeConverter.parseHexBinary("fa"),"AP",OpcodeType.SS_LLRDRD,"add decimal","g5","esa,zarch");
    public static final Opcode OP_AR = new Opcode(DatatypeConverter.parseHexBinary("1a"),"AR",OpcodeType.RR_RR,"add","g5","esa,zarch");
    public static final Opcode OP_AU = new Opcode(DatatypeConverter.parseHexBinary("7e"),"AU",OpcodeType.RX_FRRD,"add unnormalized (short)","g5","esa,zarch");
    public static final Opcode OP_AUR = new Opcode(DatatypeConverter.parseHexBinary("3e"),"AUR",OpcodeType.RR_FF,"add unnormalized (short)","g5","esa,zarch");
    public static final Opcode OP_AW = new Opcode(DatatypeConverter.parseHexBinary("6e"),"AW",OpcodeType.RX_FRRD,"add unnormalized (long)","g5","esa,zarch");
    public static final Opcode OP_AWR = new Opcode(DatatypeConverter.parseHexBinary("2e"),"AWR",OpcodeType.RR_FF,"add unnormalized (long)","g5","esa,zarch");
    public static final Opcode OP_AXR = new Opcode(DatatypeConverter.parseHexBinary("36"),"AXR",OpcodeType.RR_FEFE,"add normalized","g5","esa,zarch");
    public static final Opcode OP_BAKR = new Opcode(DatatypeConverter.parseHexBinary("b240"),"BAKR",OpcodeType.RRE_RR,"branch and stack","g5","esa,zarch");
    public static final Opcode OP_BAL = new Opcode(DatatypeConverter.parseHexBinary("45"),"BAL",OpcodeType.RX_RRRD,"branch and link","g5","esa,zarch");
    public static final Opcode OP_BALR = new Opcode(DatatypeConverter.parseHexBinary("05"),"BALR",OpcodeType.RR_RR,"branch and link","g5","esa,zarch");
    public static final Opcode OP_BAS = new Opcode(DatatypeConverter.parseHexBinary("4d"),"BAS",OpcodeType.RX_RRRD,"branch and save","g5","esa,zarch");
    public static final Opcode OP_BASR = new Opcode(DatatypeConverter.parseHexBinary("0d"),"BASR",OpcodeType.RR_RR,"branch and save","g5","esa,zarch");
    public static final Opcode OP_BASSM = new Opcode(DatatypeConverter.parseHexBinary("0c"),"BASSM",OpcodeType.RR_RR,"branch and save and set mode","g5","esa,zarch");
    public static final Opcode OP_BC = new Opcode(DatatypeConverter.parseHexBinary("47"),"BC",OpcodeType.RX_URRD,"branch on condition","g5","esa,zarch");
    public static final Opcode OP_BCR = new Opcode(DatatypeConverter.parseHexBinary("07"),"BCR",OpcodeType.RR_UR,"branch on condition","g5","esa,zarch");
    public static final Opcode OP_BCT = new Opcode(DatatypeConverter.parseHexBinary("46"),"BCT",OpcodeType.RX_RRRD,"branch on count","g5","esa,zarch");
    public static final Opcode OP_BCTR = new Opcode(DatatypeConverter.parseHexBinary("06"),"BCTR",OpcodeType.RR_RR,"branch on count","g5","esa,zarch");
    public static final Opcode OP_BSG = new Opcode(DatatypeConverter.parseHexBinary("b258"),"BSG",OpcodeType.RRE_RR,"branch in subspace group","g5","esa,zarch");
    public static final Opcode OP_BSM = new Opcode(DatatypeConverter.parseHexBinary("0b"),"BSM",OpcodeType.RR_RR,"branch and set mode","g5","esa,zarch");
    public static final Opcode OP_BXH = new Opcode(DatatypeConverter.parseHexBinary("86"),"BXH",OpcodeType.RS_RRRD,"branch on index high","g5","esa,zarch");
    public static final Opcode OP_BXLE = new Opcode(DatatypeConverter.parseHexBinary("87"),"BXLE",OpcodeType.RS_RRRD,"branch on index low or equal","g5","esa,zarch");
    public static final Opcode OP_C = new Opcode(DatatypeConverter.parseHexBinary("59"),"C",OpcodeType.RX_RRRD,"compare","g5","esa,zarch");
    public static final Opcode OP_CD = new Opcode(DatatypeConverter.parseHexBinary("69"),"CD",OpcodeType.RX_FRRD,"compare (long)","g5","esa,zarch");
    public static final Opcode OP_CDR = new Opcode(DatatypeConverter.parseHexBinary("29"),"CDR",OpcodeType.RR_FF,"compare (long)","g5","esa,zarch");
    public static final Opcode OP_CDS = new Opcode(DatatypeConverter.parseHexBinary("bb"),"CDS",OpcodeType.RS_RERERD,"compare double and swap","g5","esa,zarch");
    public static final Opcode OP_CE = new Opcode(DatatypeConverter.parseHexBinary("79"),"CE",OpcodeType.RX_FRRD,"compare (short)","g5","esa,zarch");
    public static final Opcode OP_CER = new Opcode(DatatypeConverter.parseHexBinary("39"),"CER",OpcodeType.RR_FF,"compare (short)","g5","esa,zarch");
    public static final Opcode OP_CFC = new Opcode(DatatypeConverter.parseHexBinary("b21a"),"CFC",OpcodeType.S_RD,"compare and form codeword","g5","esa,zarch");
    public static final Opcode OP_CH = new Opcode(DatatypeConverter.parseHexBinary("49"),"CH",OpcodeType.RX_RRRD,"compare halfword","g5","esa,zarch");
    public static final Opcode OP_CL = new Opcode(DatatypeConverter.parseHexBinary("55"),"CL",OpcodeType.RX_RRRD,"compare logical","g5","esa,zarch");
    public static final Opcode OP_CLC = new Opcode(DatatypeConverter.parseHexBinary("d5"),"CLC",OpcodeType.SS_L0RDRD,"compare logical","g5","esa,zarch");
    public static final Opcode OP_CLCL = new Opcode(DatatypeConverter.parseHexBinary("0f"),"CLCL",OpcodeType.RR_RR,"compare logical long","g5","esa,zarch");
    public static final Opcode OP_CLI = new Opcode(DatatypeConverter.parseHexBinary("95"),"CLI",OpcodeType.SI_URD,"compare logical","g5","esa,zarch");
    public static final Opcode OP_CLM = new Opcode(DatatypeConverter.parseHexBinary("bd"),"CLM",OpcodeType.RS_RURD,"compare logical characters under mask","g5","esa,zarch");
    public static final Opcode OP_CLR = new Opcode(DatatypeConverter.parseHexBinary("15"),"CLR",OpcodeType.RR_RR,"compare logical","g5","esa,zarch");
    public static final Opcode OP_CLST = new Opcode(DatatypeConverter.parseHexBinary("b25d"),"CLST",OpcodeType.RRE_RR,"compare logical string","g5","esa,zarch");
    public static final Opcode OP_CP = new Opcode(DatatypeConverter.parseHexBinary("f9"),"CP",OpcodeType.SS_LLRDRD,"compare decimal","g5","esa,zarch");
    public static final Opcode OP_CPYA = new Opcode(DatatypeConverter.parseHexBinary("b24d"),"CPYA",OpcodeType.RRE_AA,"copy access","g5","esa,zarch");
    public static final Opcode OP_CR = new Opcode(DatatypeConverter.parseHexBinary("19"),"CR",OpcodeType.RR_RR,"compare","g5","esa,zarch");
    public static final Opcode OP_CS = new Opcode(DatatypeConverter.parseHexBinary("ba"),"CS",OpcodeType.RS_RRRD,"compare and swap","g5","esa,zarch");
    public static final Opcode OP_CSCH = new Opcode(DatatypeConverter.parseHexBinary("b230"),"CSCH",OpcodeType.S_00,"clear subchannel","g5","esa,zarch");
    public static final Opcode OP_CUSE = new Opcode(DatatypeConverter.parseHexBinary("b257"),"CUSE",OpcodeType.RRE_RERE,"compare until substring equal","g5","esa,zarch");
    public static final Opcode OP_CSP = new Opcode(DatatypeConverter.parseHexBinary("b250"),"CSP",OpcodeType.RRE_RR,"compare and swap and purge","g5","esa,zarch");
    public static final Opcode OP_CVB = new Opcode(DatatypeConverter.parseHexBinary("4f"),"CVB",OpcodeType.RX_RRRD,"convert to binary","g5","esa,zarch");
    public static final Opcode OP_CVD = new Opcode(DatatypeConverter.parseHexBinary("4e"),"CVD",OpcodeType.RX_RRRD,"convert to decimal","g5","esa,zarch");
    public static final Opcode OP_D = new Opcode(DatatypeConverter.parseHexBinary("5d"),"D",OpcodeType.RX_RERRD,"divide","g5","esa,zarch");
    public static final Opcode OP_DD = new Opcode(DatatypeConverter.parseHexBinary("6d"),"DD",OpcodeType.RX_FRRD,"divide (long)","g5","esa,zarch");
    public static final Opcode OP_DDR = new Opcode(DatatypeConverter.parseHexBinary("2d"),"DDR",OpcodeType.RR_FF,"divide (long)","g5","esa,zarch");
    public static final Opcode OP_DE = new Opcode(DatatypeConverter.parseHexBinary("7d"),"DE",OpcodeType.RX_FRRD,"divide (short)","g5","esa,zarch");
    public static final Opcode OP_DER = new Opcode(DatatypeConverter.parseHexBinary("3d"),"DER",OpcodeType.RR_FF,"divide (short)","g5","esa,zarch");
    public static final Opcode OP_DIAG = new Opcode(DatatypeConverter.parseHexBinary("83"),"DIAG",OpcodeType.RS_RRRD,"diagnose","g5","esa,zarch");
    public static final Opcode OP_DP = new Opcode(DatatypeConverter.parseHexBinary("fd"),"DP",OpcodeType.SS_LLRDRD,"divide decimal","g5","esa,zarch");
    public static final Opcode OP_DR = new Opcode(DatatypeConverter.parseHexBinary("1d"),"DR",OpcodeType.RR_RER,"divide","g5","esa,zarch");
    public static final Opcode OP_DXR = new Opcode(DatatypeConverter.parseHexBinary("b22d"),"DXR",OpcodeType.RRE_FEFE,"divide (ext.)","g5","esa,zarch");
    public static final Opcode OP_EAR = new Opcode(DatatypeConverter.parseHexBinary("b24f"),"EAR",OpcodeType.RRE_RA,"extract access","g5","esa,zarch");
    public static final Opcode OP_ED = new Opcode(DatatypeConverter.parseHexBinary("de"),"ED",OpcodeType.SS_L0RDRD,"edit","g5","esa,zarch");
    public static final Opcode OP_EDMK = new Opcode(DatatypeConverter.parseHexBinary("df"),"EDMK",OpcodeType.SS_L0RDRD,"edit and mark","g5","esa,zarch");
    public static final Opcode OP_EPAR = new Opcode(DatatypeConverter.parseHexBinary("b226"),"EPAR",OpcodeType.RRE_R0,"extract primary ASN","g5","esa,zarch");
    public static final Opcode OP_EREG = new Opcode(DatatypeConverter.parseHexBinary("b249"),"EREG",OpcodeType.RRE_RR,"extract stacked registers","g5","esa,zarch");
    public static final Opcode OP_ESAR = new Opcode(DatatypeConverter.parseHexBinary("b227"),"ESAR",OpcodeType.RRE_R0,"extract secondary ASN","g5","esa,zarch");
    public static final Opcode OP_ESTA = new Opcode(DatatypeConverter.parseHexBinary("b24a"),"ESTA",OpcodeType.RRE_RR,"extract stacked state","g5","esa,zarch");
    public static final Opcode OP_EX = new Opcode(DatatypeConverter.parseHexBinary("44"),"EX",OpcodeType.RX_RRRD,"execute","g5","esa,zarch");
    public static final Opcode OP_HDR = new Opcode(DatatypeConverter.parseHexBinary("24"),"HDR",OpcodeType.RR_FF,"halve (long)","g5","esa,zarch");
    public static final Opcode OP_HER = new Opcode(DatatypeConverter.parseHexBinary("34"),"HER",OpcodeType.RR_FF,"halve (short)","g5","esa,zarch");
    public static final Opcode OP_HSCH = new Opcode(DatatypeConverter.parseHexBinary("b231"),"HSCH",OpcodeType.S_00,"halt subchannel","g5","esa,zarch");
    public static final Opcode OP_IAC = new Opcode(DatatypeConverter.parseHexBinary("b224"),"IAC",OpcodeType.RRE_R0,"insert address space control","g5","esa,zarch");
    public static final Opcode OP_IC = new Opcode(DatatypeConverter.parseHexBinary("43"),"IC",OpcodeType.RX_RRRD,"insert character","g5","esa,zarch");
    public static final Opcode OP_ICM = new Opcode(DatatypeConverter.parseHexBinary("bf"),"ICM",OpcodeType.RS_RURD,"insert characters under mask","g5","esa,zarch");
    public static final Opcode OP_IPK = new Opcode(DatatypeConverter.parseHexBinary("b20b"),"IPK",OpcodeType.S_00,"insert PSW key","g5","esa,zarch");
    public static final Opcode OP_IPM = new Opcode(DatatypeConverter.parseHexBinary("b222"),"IPM",OpcodeType.RRE_R0,"insert program mask","g5","esa,zarch");
    public static final Opcode OP_IPTE = new Opcode(DatatypeConverter.parseHexBinary("b221"),"IPTE",OpcodeType.RRE_RR,"invalidate page table entry","g5","esa,zarch");
    public static final Opcode OP_ISKE = new Opcode(DatatypeConverter.parseHexBinary("b229"),"ISKE",OpcodeType.RRE_RR,"insert storage key extended","g5","esa,zarch");
    public static final Opcode OP_IVSK = new Opcode(DatatypeConverter.parseHexBinary("b223"),"IVSK",OpcodeType.RRE_RR,"insert virtual storage key","g5","esa,zarch");
    public static final Opcode OP_L = new Opcode(DatatypeConverter.parseHexBinary("58"),"L",OpcodeType.RX_RRRD,"load","g5","esa,zarch");
    public static final Opcode OP_LA = new Opcode(DatatypeConverter.parseHexBinary("41"),"LA",OpcodeType.RX_RRRD,"load address","g5","esa,zarch");
    public static final Opcode OP_LAE = new Opcode(DatatypeConverter.parseHexBinary("51"),"LAE",OpcodeType.RX_RRRD,"load address extended","g5","esa,zarch");
    public static final Opcode OP_LAM = new Opcode(DatatypeConverter.parseHexBinary("9a"),"LAM",OpcodeType.RS_AARD,"load access multiple","g5","esa,zarch");
    public static final Opcode OP_LASP = new Opcode(DatatypeConverter.parseHexBinary("e500"),"LASP",OpcodeType.SSE_RDRD,"load address space parameters","g5","esa,zarch");
    public static final Opcode OP_LCDR = new Opcode(DatatypeConverter.parseHexBinary("23"),"LCDR",OpcodeType.RR_FF,"load complement (long)","g5","esa,zarch");
    public static final Opcode OP_LCER = new Opcode(DatatypeConverter.parseHexBinary("33"),"LCER",OpcodeType.RR_FF,"load complement (short)","g5","esa,zarch");
    public static final Opcode OP_LCR = new Opcode(DatatypeConverter.parseHexBinary("13"),"LCR",OpcodeType.RR_RR,"load complement","g5","esa,zarch");
    public static final Opcode OP_LCTL = new Opcode(DatatypeConverter.parseHexBinary("b7"),"LCTL",OpcodeType.RS_CCRD,"load control","g5","esa,zarch");
    public static final Opcode OP_LD = new Opcode(DatatypeConverter.parseHexBinary("68"),"LD",OpcodeType.RX_FRRD,"load (long)","g5","esa,zarch");
    public static final Opcode OP_LDR = new Opcode(DatatypeConverter.parseHexBinary("28"),"LDR",OpcodeType.RR_FF,"load (long)","g5","esa,zarch");
    public static final Opcode OP_LE = new Opcode(DatatypeConverter.parseHexBinary("78"),"LE",OpcodeType.RX_FRRD,"load (short)","g5","esa,zarch");
    public static final Opcode OP_LER = new Opcode(DatatypeConverter.parseHexBinary("38"),"LER",OpcodeType.RR_FF,"load (short)","g5","esa,zarch");
    public static final Opcode OP_LH = new Opcode(DatatypeConverter.parseHexBinary("48"),"LH",OpcodeType.RX_RRRD,"load halfword","g5","esa,zarch");
    public static final Opcode OP_LM = new Opcode(DatatypeConverter.parseHexBinary("98"),"LM",OpcodeType.RS_RRRD,"load multiple","g5","esa,zarch");
    public static final Opcode OP_LNDR = new Opcode(DatatypeConverter.parseHexBinary("21"),"LNDR",OpcodeType.RR_FF,"load negative (long)","g5","esa,zarch");
    public static final Opcode OP_LNER = new Opcode(DatatypeConverter.parseHexBinary("31"),"LNER",OpcodeType.RR_FF,"load negative (short)","g5","esa,zarch");
    public static final Opcode OP_LNR = new Opcode(DatatypeConverter.parseHexBinary("11"),"LNR",OpcodeType.RR_RR,"load negative","g5","esa,zarch");
    public static final Opcode OP_LPDR = new Opcode(DatatypeConverter.parseHexBinary("20"),"LPDR",OpcodeType.RR_FF,"load positive (long)","g5","esa,zarch");
    public static final Opcode OP_LPER = new Opcode(DatatypeConverter.parseHexBinary("30"),"LPER",OpcodeType.RR_FF,"load positive (short)","g5","esa,zarch");
    public static final Opcode OP_LPR = new Opcode(DatatypeConverter.parseHexBinary("10"),"LPR",OpcodeType.RR_RR,"load positive","g5","esa,zarch");
    public static final Opcode OP_LPSW = new Opcode(DatatypeConverter.parseHexBinary("82"),"LPSW",OpcodeType.S_RD,"load PSW","g5","esa,zarch");
    public static final Opcode OP_LR = new Opcode(DatatypeConverter.parseHexBinary("18"),"LR",OpcodeType.RR_RR,"load","g5","esa,zarch");
    public static final Opcode OP_LRA = new Opcode(DatatypeConverter.parseHexBinary("b1"),"LRA",OpcodeType.RX_RRRD,"load real address","g5","esa,zarch");
    public static final Opcode OP_LDXR = new Opcode(DatatypeConverter.parseHexBinary("25"),"LDXR",OpcodeType.RR_FFE,"load rounded (ext. to long)","g5","esa,zarch");
    public static final Opcode OP_LRDR = new Opcode(DatatypeConverter.parseHexBinary("25"),"LRDR",OpcodeType.RR_FFE,"load rounded (ext. to long)","g5","esa,zarch");
    public static final Opcode OP_LEDR = new Opcode(DatatypeConverter.parseHexBinary("35"),"LEDR",OpcodeType.RR_FF,"load rounded (long to short)","g5","esa,zarch");
    public static final Opcode OP_LRER = new Opcode(DatatypeConverter.parseHexBinary("35"),"LRER",OpcodeType.RR_FF,"load rounded (long to short)","g5","esa,zarch");
    public static final Opcode OP_LTDR = new Opcode(DatatypeConverter.parseHexBinary("22"),"LTDR",OpcodeType.RR_FF,"load and test (long)","g5","esa,zarch");
    public static final Opcode OP_LTER = new Opcode(DatatypeConverter.parseHexBinary("32"),"LTER",OpcodeType.RR_FF,"load and test (short)","g5","esa,zarch");
    public static final Opcode OP_LTR = new Opcode(DatatypeConverter.parseHexBinary("12"),"LTR",OpcodeType.RR_RR,"load and test","g5","esa,zarch");
    public static final Opcode OP_LURA = new Opcode(DatatypeConverter.parseHexBinary("b24b"),"LURA",OpcodeType.RRE_RR,"load using real address","g5","esa,zarch");
    public static final Opcode OP_M = new Opcode(DatatypeConverter.parseHexBinary("5c"),"M",OpcodeType.RX_RERRD,"multiply","g5","esa,zarch");
    public static final Opcode OP_MC = new Opcode(DatatypeConverter.parseHexBinary("af"),"MC",OpcodeType.SI_URD,"monitor call","g5","esa,zarch");
    public static final Opcode OP_MD = new Opcode(DatatypeConverter.parseHexBinary("6c"),"MD",OpcodeType.RX_FRRD,"multiply (long)","g5","esa,zarch");
    public static final Opcode OP_MDR = new Opcode(DatatypeConverter.parseHexBinary("2c"),"MDR",OpcodeType.RR_FF,"multiply (long)","g5","esa,zarch");
    public static final Opcode OP_MDE = new Opcode(DatatypeConverter.parseHexBinary("7c"),"MDE",OpcodeType.RX_FRRD,"multiply (short to long)","g5","esa,zarch");
    public static final Opcode OP_ME = new Opcode(DatatypeConverter.parseHexBinary("7c"),"ME",OpcodeType.RX_FRRD,"multiply (short to long)","g5","esa,zarch");
    public static final Opcode OP_MDER = new Opcode(DatatypeConverter.parseHexBinary("3c"),"MDER",OpcodeType.RR_FF,"multiply short to long hfp","g5","esa,zarch");
    public static final Opcode OP_MER = new Opcode(DatatypeConverter.parseHexBinary("3c"),"MER",OpcodeType.RR_FF,"multiply (short to long)","g5","esa,zarch");
    public static final Opcode OP_MH = new Opcode(DatatypeConverter.parseHexBinary("4c"),"MH",OpcodeType.RX_RRRD,"multiply halfword","g5","esa,zarch");
    public static final Opcode OP_MP = new Opcode(DatatypeConverter.parseHexBinary("fc"),"MP",OpcodeType.SS_LLRDRD,"multiply decimal","g5","esa,zarch");
    public static final Opcode OP_MR = new Opcode(DatatypeConverter.parseHexBinary("1c"),"MR",OpcodeType.RR_RER,"multiply","g5","esa,zarch");
    public static final Opcode OP_MSCH = new Opcode(DatatypeConverter.parseHexBinary("b232"),"MSCH",OpcodeType.S_RD,"modify subchannel","g5","esa,zarch");
    public static final Opcode OP_MSTA = new Opcode(DatatypeConverter.parseHexBinary("b247"),"MSTA",OpcodeType.RRE_R0,"modify stacked state","g5","esa,zarch");
    public static final Opcode OP_MVC = new Opcode(DatatypeConverter.parseHexBinary("d2"),"MVC",OpcodeType.SS_L0RDRD,"move","g5","esa,zarch");
    public static final Opcode OP_MVCDK = new Opcode(DatatypeConverter.parseHexBinary("e50f"),"MVCDK",OpcodeType.SSE_RDRD,"move with destination key","g5","esa,zarch");
    public static final Opcode OP_MVCIN = new Opcode(DatatypeConverter.parseHexBinary("e8"),"MVCIN",OpcodeType.SS_L0RDRD,"move inverse","g5","esa,zarch");
    public static final Opcode OP_MVCK = new Opcode(DatatypeConverter.parseHexBinary("d9"),"MVCK",OpcodeType.SS_RRRDRD,"move with key","g5","esa,zarch");
    public static final Opcode OP_MVCL = new Opcode(DatatypeConverter.parseHexBinary("0e"),"MVCL",OpcodeType.RR_RR,"move long","g5","esa,zarch");
    public static final Opcode OP_MVCP = new Opcode(DatatypeConverter.parseHexBinary("da"),"MVCP",OpcodeType.SS_RRRDRD,"move to primary","g5","esa,zarch");
    public static final Opcode OP_MVCS = new Opcode(DatatypeConverter.parseHexBinary("db"),"MVCS",OpcodeType.SS_RRRDRD,"move to secondary","g5","esa,zarch");
    public static final Opcode OP_MVCSK = new Opcode(DatatypeConverter.parseHexBinary("e50e"),"MVCSK",OpcodeType.SSE_RDRD,"move with source key","g5","esa,zarch");
    public static final Opcode OP_MVI = new Opcode(DatatypeConverter.parseHexBinary("92"),"MVI",OpcodeType.SI_URD,"move","g5","esa,zarch");
    public static final Opcode OP_MVN = new Opcode(DatatypeConverter.parseHexBinary("d1"),"MVN",OpcodeType.SS_L0RDRD,"move numerics","g5","esa,zarch");
    public static final Opcode OP_MVO = new Opcode(DatatypeConverter.parseHexBinary("f1"),"MVO",OpcodeType.SS_LLRDRD,"move with offset","g5","esa,zarch");
    public static final Opcode OP_MVPG = new Opcode(DatatypeConverter.parseHexBinary("b254"),"MVPG",OpcodeType.RRE_RR,"move page","g5","esa,zarch");
    public static final Opcode OP_MVST = new Opcode(DatatypeConverter.parseHexBinary("b255"),"MVST",OpcodeType.RRE_RR,"move string","g5","esa,zarch");
    public static final Opcode OP_MVZ = new Opcode(DatatypeConverter.parseHexBinary("d3"),"MVZ",OpcodeType.SS_L0RDRD,"move zones","g5","esa,zarch");
    public static final Opcode OP_MXD = new Opcode(DatatypeConverter.parseHexBinary("67"),"MXD",OpcodeType.RX_FERRD,"multiply (long to ext.)","g5","esa,zarch");
    public static final Opcode OP_MXDR = new Opcode(DatatypeConverter.parseHexBinary("27"),"MXDR",OpcodeType.RR_FEF,"multiply (long to ext.)","g5","esa,zarch");
    public static final Opcode OP_MXR = new Opcode(DatatypeConverter.parseHexBinary("26"),"MXR",OpcodeType.RR_FEFE,"multiply (ext.)","g5","esa,zarch");
    public static final Opcode OP_N = new Opcode(DatatypeConverter.parseHexBinary("54"),"N",OpcodeType.RX_RRRD,"AND","g5","esa,zarch");
    public static final Opcode OP_NC = new Opcode(DatatypeConverter.parseHexBinary("d4"),"NC",OpcodeType.SS_L0RDRD,"AND","g5","esa,zarch");
    public static final Opcode OP_NI = new Opcode(DatatypeConverter.parseHexBinary("94"),"NI",OpcodeType.SI_URD,"AND","g5","esa,zarch");
    public static final Opcode OP_NR = new Opcode(DatatypeConverter.parseHexBinary("14"),"NR",OpcodeType.RR_RR,"AND","g5","esa,zarch");
    public static final Opcode OP_O = new Opcode(DatatypeConverter.parseHexBinary("56"),"O",OpcodeType.RX_RRRD,"OR","g5","esa,zarch");
    public static final Opcode OP_OC = new Opcode(DatatypeConverter.parseHexBinary("d6"),"OC",OpcodeType.SS_L0RDRD,"OR","g5","esa,zarch");
    public static final Opcode OP_OI = new Opcode(DatatypeConverter.parseHexBinary("96"),"OI",OpcodeType.SI_URD,"OR","g5","esa,zarch");
    public static final Opcode OP_OR = new Opcode(DatatypeConverter.parseHexBinary("16"),"OR",OpcodeType.RR_RR,"OR","g5","esa,zarch");
    public static final Opcode OP_PACK = new Opcode(DatatypeConverter.parseHexBinary("f2"),"PACK",OpcodeType.SS_LLRDRD,"pack","g5","esa,zarch");
    public static final Opcode OP_PALB = new Opcode(DatatypeConverter.parseHexBinary("b248"),"PALB",OpcodeType.RRE_00,"purge ALB","g5","esa,zarch");
    public static final Opcode OP_PC = new Opcode(DatatypeConverter.parseHexBinary("b218"),"PC",OpcodeType.S_RD,"program call","g5","esa,zarch");
    public static final Opcode OP_PR = new Opcode(DatatypeConverter.parseHexBinary("0101"),"PR",OpcodeType.E,"program return","g5","esa,zarch");
    public static final Opcode OP_PT = new Opcode(DatatypeConverter.parseHexBinary("b228"),"PT",OpcodeType.RRE_RR,"program transfer","g5","esa,zarch");
    public static final Opcode OP_PTLB = new Opcode(DatatypeConverter.parseHexBinary("b20d"),"PTLB",OpcodeType.S_00,"purge TLB","g5","esa,zarch");
    public static final Opcode OP_RCHP = new Opcode(DatatypeConverter.parseHexBinary("b23b"),"RCHP",OpcodeType.S_00,"reset channel path","g5","esa,zarch");
    public static final Opcode OP_RRBE = new Opcode(DatatypeConverter.parseHexBinary("b22a"),"RRBE",OpcodeType.RRE_RR,"reset reference bit extended","g5","esa,zarch");
    public static final Opcode OP_RSCH = new Opcode(DatatypeConverter.parseHexBinary("b238"),"RSCH",OpcodeType.S_00,"resume subchannel","g5","esa,zarch");
    public static final Opcode OP_S = new Opcode(DatatypeConverter.parseHexBinary("5b"),"S",OpcodeType.RX_RRRD,"subtract","g5","esa,zarch");
    public static final Opcode OP_SAC = new Opcode(DatatypeConverter.parseHexBinary("b219"),"SAC",OpcodeType.S_RD,"set address space control","g5","esa,zarch");
    public static final Opcode OP_SACF = new Opcode(DatatypeConverter.parseHexBinary("b279"),"SACF",OpcodeType.S_RD,"set address space control fast","g5","esa,zarch");
    public static final Opcode OP_SAL = new Opcode(DatatypeConverter.parseHexBinary("b237"),"SAL",OpcodeType.S_00,"set address limit","g5","esa,zarch");
    public static final Opcode OP_SAR = new Opcode(DatatypeConverter.parseHexBinary("b24e"),"SAR",OpcodeType.RRE_AR,"set access","g5","esa,zarch");
    public static final Opcode OP_SCHM = new Opcode(DatatypeConverter.parseHexBinary("b23c"),"SCHM",OpcodeType.S_00,"set channel monitor","g5","esa,zarch");
    public static final Opcode OP_SCK = new Opcode(DatatypeConverter.parseHexBinary("b204"),"SCK",OpcodeType.S_RD,"set clock","g5","esa,zarch");
    public static final Opcode OP_SCKC = new Opcode(DatatypeConverter.parseHexBinary("b206"),"SCKC",OpcodeType.S_RD,"set clock comparator","g5","esa,zarch");
    public static final Opcode OP_SD = new Opcode(DatatypeConverter.parseHexBinary("6b"),"SD",OpcodeType.RX_FRRD,"subtract normalized (long)","g5","esa,zarch");
    public static final Opcode OP_SDR = new Opcode(DatatypeConverter.parseHexBinary("2b"),"SDR",OpcodeType.RR_FF,"subtract normalized (long)","g5","esa,zarch");
    public static final Opcode OP_SE = new Opcode(DatatypeConverter.parseHexBinary("7b"),"SE",OpcodeType.RX_FRRD,"subtract normalized (short)","g5","esa,zarch");
    public static final Opcode OP_SER = new Opcode(DatatypeConverter.parseHexBinary("3b"),"SER",OpcodeType.RR_FF,"subtract normalized (short)","g5","esa,zarch");
    public static final Opcode OP_SH = new Opcode(DatatypeConverter.parseHexBinary("4b"),"SH",OpcodeType.RX_RRRD,"subtract halfword","g5","esa,zarch");
    public static final Opcode OP_SIE = new Opcode(DatatypeConverter.parseHexBinary("b214"),"SIE",OpcodeType.S_RD,"start interpretive execution","g5","esa,zarch");
    public static final Opcode OP_SIGP = new Opcode(DatatypeConverter.parseHexBinary("ae"),"SIGP",OpcodeType.RS_RRRD,"signal processor","g5","esa,zarch");
    public static final Opcode OP_SL = new Opcode(DatatypeConverter.parseHexBinary("5f"),"SL",OpcodeType.RX_RRRD,"subtract logical","g5","esa,zarch");
    public static final Opcode OP_SLA = new Opcode(DatatypeConverter.parseHexBinary("8b"),"SLA",OpcodeType.RS_R0RD,"shift left single","g5","esa,zarch");
    public static final Opcode OP_SLDA = new Opcode(DatatypeConverter.parseHexBinary("8f"),"SLDA",OpcodeType.RS_RE0RD,"shift left double (long)","g5","esa,zarch");
    public static final Opcode OP_SLDL = new Opcode(DatatypeConverter.parseHexBinary("8d"),"SLDL",OpcodeType.RS_RE0RD,"shift left double logical (long)","g5","esa,zarch");
    public static final Opcode OP_SLL = new Opcode(DatatypeConverter.parseHexBinary("89"),"SLL",OpcodeType.RS_R0RD,"shift left single logical","g5","esa,zarch");
    public static final Opcode OP_SLR = new Opcode(DatatypeConverter.parseHexBinary("1f"),"SLR",OpcodeType.RR_RR,"subtract logical","g5","esa,zarch");
    public static final Opcode OP_SP = new Opcode(DatatypeConverter.parseHexBinary("fb"),"SP",OpcodeType.SS_LLRDRD,"subtract decimal","g5","esa,zarch");
    public static final Opcode OP_SPKA = new Opcode(DatatypeConverter.parseHexBinary("b20a"),"SPKA",OpcodeType.S_RD,"set PSW key from address","g5","esa,zarch");
    public static final Opcode OP_SPM = new Opcode(DatatypeConverter.parseHexBinary("04"),"SPM",OpcodeType.RR_R0,"set program mask","g5","esa,zarch");
    public static final Opcode OP_SPT = new Opcode(DatatypeConverter.parseHexBinary("b208"),"SPT",OpcodeType.S_RD,"set CPU timer","g5","esa,zarch");
    public static final Opcode OP_SPX = new Opcode(DatatypeConverter.parseHexBinary("b210"),"SPX",OpcodeType.S_RD,"set prefix","g5","esa,zarch");
    public static final Opcode OP_SQDR = new Opcode(DatatypeConverter.parseHexBinary("b244"),"SQDR",OpcodeType.RRE_FF,"square root (long)","g5","esa,zarch");
    public static final Opcode OP_SQER = new Opcode(DatatypeConverter.parseHexBinary("b245"),"SQER",OpcodeType.RRE_FF,"square root (short)","g5","esa,zarch");
    public static final Opcode OP_SR = new Opcode(DatatypeConverter.parseHexBinary("1b"),"SR",OpcodeType.RR_RR,"subtract","g5","esa,zarch");
    public static final Opcode OP_SRA = new Opcode(DatatypeConverter.parseHexBinary("8a"),"SRA",OpcodeType.RS_R0RD,"shift right single","g5","esa,zarch");
    public static final Opcode OP_SRDA = new Opcode(DatatypeConverter.parseHexBinary("8e"),"SRDA",OpcodeType.RS_RE0RD,"shift right double (long)","g5","esa,zarch");
    public static final Opcode OP_SRDL = new Opcode(DatatypeConverter.parseHexBinary("8c"),"SRDL",OpcodeType.RS_RE0RD,"shift right double logical (long)","g5","esa,zarch");
    public static final Opcode OP_SRL = new Opcode(DatatypeConverter.parseHexBinary("88"),"SRL",OpcodeType.RS_R0RD,"shift right single logical","g5","esa,zarch");
    public static final Opcode OP_SRP = new Opcode(DatatypeConverter.parseHexBinary("f0"),"SRP",OpcodeType.SS_LIRDRD,"shift and round decimal","g5","esa,zarch");
    public static final Opcode OP_SRST = new Opcode(DatatypeConverter.parseHexBinary("b25e"),"SRST",OpcodeType.RRE_RR,"search string","g5","esa,zarch");
    public static final Opcode OP_SSAR = new Opcode(DatatypeConverter.parseHexBinary("b225"),"SSAR",OpcodeType.RRE_R0,"set secondary ASN","g5","esa,zarch");
    public static final Opcode OP_SSCH = new Opcode(DatatypeConverter.parseHexBinary("b233"),"SSCH",OpcodeType.S_RD,"start subchannel","g5","esa,zarch");
    public static final Opcode OP_SSKE = new Opcode(DatatypeConverter.parseHexBinary("b22b"),"SSKE",OpcodeType.RRE_RR,"set storage key extended","g5","esa,zarch");
    public static final Opcode OP_SSM = new Opcode(DatatypeConverter.parseHexBinary("80"),"SSM",OpcodeType.S_RD,"set system mask","g5","esa,zarch");
    public static final Opcode OP_ST = new Opcode(DatatypeConverter.parseHexBinary("50"),"ST",OpcodeType.RX_RRRD,"store","g5","esa,zarch");
    public static final Opcode OP_STAM = new Opcode(DatatypeConverter.parseHexBinary("9b"),"STAM",OpcodeType.RS_AARD,"store access multiple","g5","esa,zarch");
    public static final Opcode OP_STAP = new Opcode(DatatypeConverter.parseHexBinary("b212"),"STAP",OpcodeType.S_RD,"store CPU address","g5","esa,zarch");
    public static final Opcode OP_STC = new Opcode(DatatypeConverter.parseHexBinary("42"),"STC",OpcodeType.RX_RRRD,"store character","g5","esa,zarch");
    public static final Opcode OP_STCK = new Opcode(DatatypeConverter.parseHexBinary("b205"),"STCK",OpcodeType.S_RD,"store clock","g5","esa,zarch");
    public static final Opcode OP_STCKC = new Opcode(DatatypeConverter.parseHexBinary("b207"),"STCKC",OpcodeType.S_RD,"store clock comparator","g5","esa,zarch");
    public static final Opcode OP_STCM = new Opcode(DatatypeConverter.parseHexBinary("be"),"STCM",OpcodeType.RS_RURD,"store characters under mask","g5","esa,zarch");
    public static final Opcode OP_STCPS = new Opcode(DatatypeConverter.parseHexBinary("b23a"),"STCPS",OpcodeType.S_RD,"store channel path status","g5","esa,zarch");
    public static final Opcode OP_STCRW = new Opcode(DatatypeConverter.parseHexBinary("b239"),"STCRW",OpcodeType.S_RD,"store channel report word","g5","esa,zarch");
    public static final Opcode OP_STCTL = new Opcode(DatatypeConverter.parseHexBinary("b6"),"STCTL",OpcodeType.RS_CCRD,"store control","g5","esa,zarch");
    public static final Opcode OP_STD = new Opcode(DatatypeConverter.parseHexBinary("60"),"STD",OpcodeType.RX_FRRD,"store (long)","g5","esa,zarch");
    public static final Opcode OP_STE = new Opcode(DatatypeConverter.parseHexBinary("70"),"STE",OpcodeType.RX_FRRD,"store (short)","g5","esa,zarch");
    public static final Opcode OP_STH = new Opcode(DatatypeConverter.parseHexBinary("40"),"STH",OpcodeType.RX_RRRD,"store halfword","g5","esa,zarch");
    public static final Opcode OP_STIDP = new Opcode(DatatypeConverter.parseHexBinary("b202"),"STIDP",OpcodeType.S_RD,"store CPU id","g5","esa,zarch");
    public static final Opcode OP_STM = new Opcode(DatatypeConverter.parseHexBinary("90"),"STM",OpcodeType.RS_RRRD,"store multiple","g5","esa,zarch");
    public static final Opcode OP_STNSM = new Opcode(DatatypeConverter.parseHexBinary("ac"),"STNSM",OpcodeType.SI_URD,"store then AND system mask","g5","esa,zarch");
    public static final Opcode OP_STOSM = new Opcode(DatatypeConverter.parseHexBinary("ad"),"STOSM",OpcodeType.SI_URD,"store then OR system mask","g5","esa,zarch");
    public static final Opcode OP_STPT = new Opcode(DatatypeConverter.parseHexBinary("b209"),"STPT",OpcodeType.S_RD,"store CPU timer","g5","esa,zarch");
    public static final Opcode OP_STPX = new Opcode(DatatypeConverter.parseHexBinary("b211"),"STPX",OpcodeType.S_RD,"store prefix","g5","esa,zarch");
    public static final Opcode OP_STSCH = new Opcode(DatatypeConverter.parseHexBinary("b234"),"STSCH",OpcodeType.S_RD,"store subchannel","g5","esa,zarch");
    public static final Opcode OP_STURA = new Opcode(DatatypeConverter.parseHexBinary("b246"),"STURA",OpcodeType.RRE_RR,"store using real address","g5","esa,zarch");
    public static final Opcode OP_SU = new Opcode(DatatypeConverter.parseHexBinary("7f"),"SU",OpcodeType.RX_FRRD,"subtract unnormalized (short)","g5","esa,zarch");
    public static final Opcode OP_SUR = new Opcode(DatatypeConverter.parseHexBinary("3f"),"SUR",OpcodeType.RR_FF,"subtract unnormalized (short)","g5","esa,zarch");
    public static final Opcode OP_SVC = new Opcode(DatatypeConverter.parseHexBinary("0a"),"SVC",OpcodeType.RR_U0,"supervisor call","g5","esa,zarch");
    public static final Opcode OP_SW = new Opcode(DatatypeConverter.parseHexBinary("6f"),"SW",OpcodeType.RX_FRRD,"subtract unnormalized (long)","g5","esa,zarch");
    public static final Opcode OP_SWR = new Opcode(DatatypeConverter.parseHexBinary("2f"),"SWR",OpcodeType.RR_FF,"subtract unnormalized (long)","g5","esa,zarch");
    public static final Opcode OP_SXR = new Opcode(DatatypeConverter.parseHexBinary("37"),"SXR",OpcodeType.RR_FEFE,"subtract normalized (ext.)","g5","esa,zarch");
    public static final Opcode OP_TAR = new Opcode(DatatypeConverter.parseHexBinary("b24c"),"TAR",OpcodeType.RRE_AR,"test access","g5","esa,zarch");
    public static final Opcode OP_TB = new Opcode(DatatypeConverter.parseHexBinary("b22c"),"TB",OpcodeType.RRE_0R,"test block","g5","esa,zarch");
    public static final Opcode OP_TM = new Opcode(DatatypeConverter.parseHexBinary("91"),"TM",OpcodeType.SI_URD,"test under mask","g5","esa,zarch");
    public static final Opcode OP_TPI = new Opcode(DatatypeConverter.parseHexBinary("b236"),"TPI",OpcodeType.S_RD,"test pending interruption","g5","esa,zarch");
    public static final Opcode OP_TPROT = new Opcode(DatatypeConverter.parseHexBinary("e501"),"TPROT",OpcodeType.SSE_RDRD,"test protection","g5","esa,zarch");
    public static final Opcode OP_TR = new Opcode(DatatypeConverter.parseHexBinary("dc"),"TR",OpcodeType.SS_L0RDRD,"translate","g5","esa,zarch");
    public static final Opcode OP_TRACE = new Opcode(DatatypeConverter.parseHexBinary("99"),"TRACE",OpcodeType.RS_RRRD,"trace","g5","esa,zarch");
    public static final Opcode OP_TRT = new Opcode(DatatypeConverter.parseHexBinary("dd"),"TRT",OpcodeType.SS_L0RDRD,"translate and test","g5","esa,zarch");
    public static final Opcode OP_TS = new Opcode(DatatypeConverter.parseHexBinary("93"),"TS",OpcodeType.S_RD,"test and set","g5","esa,zarch");
    public static final Opcode OP_TSCH = new Opcode(DatatypeConverter.parseHexBinary("b235"),"TSCH",OpcodeType.S_RD,"test subchannel","g5","esa,zarch");
    public static final Opcode OP_UNPK = new Opcode(DatatypeConverter.parseHexBinary("f3"),"UNPK",OpcodeType.SS_LLRDRD,"unpack","g5","esa,zarch");
    public static final Opcode OP_UPT = new Opcode(DatatypeConverter.parseHexBinary("0102"),"UPT",OpcodeType.E,"update tree","g5","esa,zarch");
    public static final Opcode OP_X = new Opcode(DatatypeConverter.parseHexBinary("57"),"X",OpcodeType.RX_RRRD,"exclusive OR","g5","esa,zarch");
    public static final Opcode OP_XC = new Opcode(DatatypeConverter.parseHexBinary("d7"),"XC",OpcodeType.SS_L0RDRD,"exclusive OR","g5","esa,zarch");
    public static final Opcode OP_XI = new Opcode(DatatypeConverter.parseHexBinary("97"),"XI",OpcodeType.SI_URD,"exclusive OR","g5","esa,zarch");
    public static final Opcode OP_XR = new Opcode(DatatypeConverter.parseHexBinary("17"),"XR",OpcodeType.RR_RR,"exclusive OR","g5","esa,zarch");
    public static final Opcode OP_ZAP = new Opcode(DatatypeConverter.parseHexBinary("f8"),"ZAP",OpcodeType.SS_LLRDRD,"zero and add","g5","esa,zarch");
    public static final Opcode OP_AHI = new Opcode(DatatypeConverter.parseHexBinary("a70a"),"AHI",OpcodeType.RI_RI,"add halfword immediate","g5","esa,zarch");
    public static final Opcode OP_BRXH = new Opcode(DatatypeConverter.parseHexBinary("84"),"BRXH",OpcodeType.RSI_RRP,"branch relative on index high","g5","esa,zarch");
    public static final Opcode OP_BRXLE = new Opcode(DatatypeConverter.parseHexBinary("85"),"BRXLE",OpcodeType.RSI_RRP,"branch relative on index low or equal","g5","esa,zarch");
    public static final Opcode OP_BRAS = new Opcode(DatatypeConverter.parseHexBinary("a705"),"BRAS",OpcodeType.RI_RP,"branch relative and save","g5","esa,zarch");
    public static final Opcode OP_BRC = new Opcode(DatatypeConverter.parseHexBinary("a704"),"BRC",OpcodeType.RI_UP,"branch relative on condition","g5","esa,zarch");
    public static final Opcode OP_BRCT = new Opcode(DatatypeConverter.parseHexBinary("a706"),"BRCT",OpcodeType.RI_RP,"branch relative on count","g5","esa,zarch");
    public static final Opcode OP_CKSM = new Opcode(DatatypeConverter.parseHexBinary("b241"),"CKSM",OpcodeType.RRE_RR,"checksum","g5","esa,zarch");
    public static final Opcode OP_CHI = new Opcode(DatatypeConverter.parseHexBinary("a70e"),"CHI",OpcodeType.RI_RI,"compare halfword immediate","g5","esa,zarch");
    public static final Opcode OP_CLCLE = new Opcode(DatatypeConverter.parseHexBinary("a9"),"CLCLE",OpcodeType.RS_RRRD,"compare logical long extended","g5","esa,zarch");
    public static final Opcode OP_LHI = new Opcode(DatatypeConverter.parseHexBinary("a708"),"LHI",OpcodeType.RI_RI,"load halfword immediate","g5","esa,zarch");
    public static final Opcode OP_MVCLE = new Opcode(DatatypeConverter.parseHexBinary("a8"),"MVCLE",OpcodeType.RS_RERERD,"move long extended","g5","esa,zarch");
    public static final Opcode OP_MHI = new Opcode(DatatypeConverter.parseHexBinary("a70c"),"MHI",OpcodeType.RI_RI,"multiply halfword immediate","g5","esa,zarch");
    public static final Opcode OP_MSR = new Opcode(DatatypeConverter.parseHexBinary("b252"),"MSR",OpcodeType.RRE_RR,"multiply single","g5","esa,zarch");
    public static final Opcode OP_MS = new Opcode(DatatypeConverter.parseHexBinary("71"),"MS",OpcodeType.RX_RRRD,"multiply single","g5","esa,zarch");
    public static final Opcode OP_TMLH = new Opcode(DatatypeConverter.parseHexBinary("a700"),"TMLH",OpcodeType.RI_RU,"test under mask low high","g5","esa,zarch");
    public static final Opcode OP_TMH = new Opcode(DatatypeConverter.parseHexBinary("a700"),"TMH",OpcodeType.RI_RU,"test under mask high","g5","esa,zarch");
    public static final Opcode OP_TMLL = new Opcode(DatatypeConverter.parseHexBinary("a701"),"TMLL",OpcodeType.RI_RU,"test under mask low low","g5","esa,zarch");
    public static final Opcode OP_TML = new Opcode(DatatypeConverter.parseHexBinary("a701"),"TML",OpcodeType.RI_RU,"test under mask low","g5","esa,zarch");
    public static final Opcode OP_NOPR = new Opcode(DatatypeConverter.parseHexBinary("0700"),"NOPR",OpcodeType.RR_0R,"no operation","g5","esa,zarch");
    public static final Opcode OP_BR = new Opcode(DatatypeConverter.parseHexBinary("07f0"),"BR",OpcodeType.RR_0R,"unconditional branch","g5","esa,zarch");
    public static final Opcode OP_NOP = new Opcode(DatatypeConverter.parseHexBinary("4700"),"NOP",OpcodeType.RX_0RRD,"no operation","g5","esa,zarch");
    public static final Opcode OP_B = new Opcode(DatatypeConverter.parseHexBinary("47f0"),"B",OpcodeType.RX_0RRD,"unconditional branch","g5","esa,zarch");
    public static final Opcode OP_J = new Opcode(DatatypeConverter.parseHexBinary("a7f4"),"J",OpcodeType.RI_0P,"unconditional jump","g5","esa,zarch");
    public static final Opcode OP_AXBR = new Opcode(DatatypeConverter.parseHexBinary("b34a"),"AXBR",OpcodeType.RRE_FEFE,"add extended bfp","g5","esa,zarch");
    public static final Opcode OP_ADBR = new Opcode(DatatypeConverter.parseHexBinary("b31a"),"ADBR",OpcodeType.RRE_FF,"add long bfp","g5","esa,zarch");
    public static final Opcode OP_ADB = new Opcode(DatatypeConverter.parseHexBinary("ed000000001a"),"ADB",OpcodeType.RXE_FRRD,"add long bfp","g5","esa,zarch");
    public static final Opcode OP_AEBR = new Opcode(DatatypeConverter.parseHexBinary("b30a"),"AEBR",OpcodeType.RRE_FF,"add short bfp","g5","esa,zarch");
    public static final Opcode OP_AEB = new Opcode(DatatypeConverter.parseHexBinary("ed000000000a"),"AEB",OpcodeType.RXE_FRRD,"add short bfp","g5","esa,zarch");
    public static final Opcode OP_CXBR = new Opcode(DatatypeConverter.parseHexBinary("b349"),"CXBR",OpcodeType.RRE_FEFE,"compare extended bfp","g5","esa,zarch");
    public static final Opcode OP_CDBR = new Opcode(DatatypeConverter.parseHexBinary("b319"),"CDBR",OpcodeType.RRE_FF,"compare long bfp","g5","esa,zarch");
    public static final Opcode OP_CDB = new Opcode(DatatypeConverter.parseHexBinary("ed0000000019"),"CDB",OpcodeType.RXE_FRRD,"compare long bfp","g5","esa,zarch");
    public static final Opcode OP_CEBR = new Opcode(DatatypeConverter.parseHexBinary("b309"),"CEBR",OpcodeType.RRE_FF,"compare short bfp","g5","esa,zarch");
    public static final Opcode OP_CEB = new Opcode(DatatypeConverter.parseHexBinary("ed0000000009"),"CEB",OpcodeType.RXE_FRRD,"compare short bfp","g5","esa,zarch");
    public static final Opcode OP_KXBR = new Opcode(DatatypeConverter.parseHexBinary("b348"),"KXBR",OpcodeType.RRE_FF,"compare and signal extended bfp","g5","esa,zarch");
    public static final Opcode OP_KDBR = new Opcode(DatatypeConverter.parseHexBinary("b318"),"KDBR",OpcodeType.RRE_FF,"compare and signal long bfp","g5","esa,zarch");
    public static final Opcode OP_KDB = new Opcode(DatatypeConverter.parseHexBinary("ed0000000018"),"KDB",OpcodeType.RXE_FRRD,"compare and signal long bfp","g5","esa,zarch");
    public static final Opcode OP_KEBR = new Opcode(DatatypeConverter.parseHexBinary("b308"),"KEBR",OpcodeType.RRE_FF,"compare and signal short bfp","g5","esa,zarch");
    public static final Opcode OP_KEB = new Opcode(DatatypeConverter.parseHexBinary("ed0000000008"),"KEB",OpcodeType.RXE_FRRD,"compare and signal short bfp","g5","esa,zarch");
    public static final Opcode OP_CXFBR = new Opcode(DatatypeConverter.parseHexBinary("b396"),"CXFBR",OpcodeType.RRE_FER,"convert from fixed 32 to extended bfp","g5","esa,zarch");
    public static final Opcode OP_CDFBR = new Opcode(DatatypeConverter.parseHexBinary("b395"),"CDFBR",OpcodeType.RRE_FR,"convert from fixed 32 to long bfp","g5","esa,zarch");
    public static final Opcode OP_CEFBR = new Opcode(DatatypeConverter.parseHexBinary("b394"),"CEFBR",OpcodeType.RRE_FR,"convert from fixed 32 to short bfp","g5","esa,zarch");
    public static final Opcode OP_CFXBR = new Opcode(DatatypeConverter.parseHexBinary("b39a"),"CFXBR",OpcodeType.RRF_U0RFE,"convert to fixed extended bfp to 32","g5","esa,zarch");
    public static final Opcode OP_CFDBR = new Opcode(DatatypeConverter.parseHexBinary("b399"),"CFDBR",OpcodeType.RRF_U0RF,"convert to fixed long bfp to 32","g5","esa,zarch");
    public static final Opcode OP_CFEBR = new Opcode(DatatypeConverter.parseHexBinary("b398"),"CFEBR",OpcodeType.RRF_U0RF,"convert to fixed short bfp to 32","g5","esa,zarch");
    public static final Opcode OP_DXBR = new Opcode(DatatypeConverter.parseHexBinary("b34d"),"DXBR",OpcodeType.RRE_FEFE,"divide extended bfp","g5","esa,zarch");
    public static final Opcode OP_DDBR = new Opcode(DatatypeConverter.parseHexBinary("b31d"),"DDBR",OpcodeType.RRE_FF,"divide long bfp","g5","esa,zarch");
    public static final Opcode OP_DDB = new Opcode(DatatypeConverter.parseHexBinary("ed000000001d"),"DDB",OpcodeType.RXE_FRRD,"divide long bfp","g5","esa,zarch");
    public static final Opcode OP_DEBR = new Opcode(DatatypeConverter.parseHexBinary("b30d"),"DEBR",OpcodeType.RRE_FF,"divide short bfp","g5","esa,zarch");
    public static final Opcode OP_DEB = new Opcode(DatatypeConverter.parseHexBinary("ed000000000d"),"DEB",OpcodeType.RXE_FRRD,"divide short bfp","g5","esa,zarch");
    public static final Opcode OP_DIDBR = new Opcode(DatatypeConverter.parseHexBinary("b35b"),"DIDBR",OpcodeType.RRF_FUFF,"divide to integer long bfp","g5","esa,zarch");
    public static final Opcode OP_DIEBR = new Opcode(DatatypeConverter.parseHexBinary("b353"),"DIEBR",OpcodeType.RRF_FUFF,"divide to integer short bfp","g5","esa,zarch");
    public static final Opcode OP_EFPC = new Opcode(DatatypeConverter.parseHexBinary("b38c"),"EFPC",OpcodeType.RRE_RR,"extract fpc","g5","esa,zarch");
    public static final Opcode OP_LTXBR = new Opcode(DatatypeConverter.parseHexBinary("b342"),"LTXBR",OpcodeType.RRE_FEFE,"load and test extended bfp","g5","esa,zarch");
    public static final Opcode OP_LTDBR = new Opcode(DatatypeConverter.parseHexBinary("b312"),"LTDBR",OpcodeType.RRE_FF,"load and test long bfp","g5","esa,zarch");
    public static final Opcode OP_LTEBR = new Opcode(DatatypeConverter.parseHexBinary("b302"),"LTEBR",OpcodeType.RRE_FF,"load and test short bfp","g5","esa,zarch");
    public static final Opcode OP_LCXBR = new Opcode(DatatypeConverter.parseHexBinary("b343"),"LCXBR",OpcodeType.RRE_FEFE,"load complement extended bfp","g5","esa,zarch");
    public static final Opcode OP_LCDBR = new Opcode(DatatypeConverter.parseHexBinary("b313"),"LCDBR",OpcodeType.RRE_FF,"load complement long bfp","g5","esa,zarch");
    public static final Opcode OP_LCEBR = new Opcode(DatatypeConverter.parseHexBinary("b303"),"LCEBR",OpcodeType.RRE_FF,"load complement short bfp","g5","esa,zarch");
    public static final Opcode OP_FIXBR = new Opcode(DatatypeConverter.parseHexBinary("b347"),"FIXBR",OpcodeType.RRF_U0FEFE,"load fp integer extended bfp","g5","esa,zarch");
    public static final Opcode OP_FIDBR = new Opcode(DatatypeConverter.parseHexBinary("b35f"),"FIDBR",OpcodeType.RRF_U0FF,"load fp integer long bfp","g5","esa,zarch");
    public static final Opcode OP_FIEBR = new Opcode(DatatypeConverter.parseHexBinary("b357"),"FIEBR",OpcodeType.RRF_U0FF,"load fp integer short bfp","g5","esa,zarch");
    public static final Opcode OP_LFPC = new Opcode(DatatypeConverter.parseHexBinary("b29d"),"LFPC",OpcodeType.S_RD,"load fpc","g5","esa,zarch");
    public static final Opcode OP_LXDBR = new Opcode(DatatypeConverter.parseHexBinary("b305"),"LXDBR",OpcodeType.RRE_FEF,"load lengthened long to extended bfp","g5","esa,zarch");
    public static final Opcode OP_LXDB = new Opcode(DatatypeConverter.parseHexBinary("ed0000000005"),"LXDB",OpcodeType.RXE_FERRD,"load lengthened long to extended bfp","g5","esa,zarch");
    public static final Opcode OP_LXEBR = new Opcode(DatatypeConverter.parseHexBinary("b306"),"LXEBR",OpcodeType.RRE_FEF,"load lengthened short to extended bfp","g5","esa,zarch");
    public static final Opcode OP_LXEB = new Opcode(DatatypeConverter.parseHexBinary("ed0000000006"),"LXEB",OpcodeType.RXE_FERRD,"load lengthened short to extended bfp","g5","esa,zarch");
    public static final Opcode OP_LDEBR = new Opcode(DatatypeConverter.parseHexBinary("b304"),"LDEBR",OpcodeType.RRE_FF,"load lengthened short to long bfp","g5","esa,zarch");
    public static final Opcode OP_LDEB = new Opcode(DatatypeConverter.parseHexBinary("ed0000000004"),"LDEB",OpcodeType.RXE_FRRD,"load lengthened short to long bfp","g5","esa,zarch");
    public static final Opcode OP_LNXBR = new Opcode(DatatypeConverter.parseHexBinary("b341"),"LNXBR",OpcodeType.RRE_FEFE,"load negative extended bfp","g5","esa,zarch");
    public static final Opcode OP_LNDBR = new Opcode(DatatypeConverter.parseHexBinary("b311"),"LNDBR",OpcodeType.RRE_FF,"load negative long bfp","g5","esa,zarch");
    public static final Opcode OP_LNEBR = new Opcode(DatatypeConverter.parseHexBinary("b301"),"LNEBR",OpcodeType.RRE_FF,"load negative short bfp","g5","esa,zarch");
    public static final Opcode OP_LPXBR = new Opcode(DatatypeConverter.parseHexBinary("b340"),"LPXBR",OpcodeType.RRE_FEFE,"load positive extended bfp","g5","esa,zarch");
    public static final Opcode OP_LPDBR = new Opcode(DatatypeConverter.parseHexBinary("b310"),"LPDBR",OpcodeType.RRE_FF,"load positive long bfp","g5","esa,zarch");
    public static final Opcode OP_LPEBR = new Opcode(DatatypeConverter.parseHexBinary("b300"),"LPEBR",OpcodeType.RRE_FF,"load positive short bfp","g5","esa,zarch");
    public static final Opcode OP_LDXBR = new Opcode(DatatypeConverter.parseHexBinary("b345"),"LDXBR",OpcodeType.RRE_FEFE,"load rounded extended to long bfp","g5","esa,zarch");
    public static final Opcode OP_LEXBR = new Opcode(DatatypeConverter.parseHexBinary("b346"),"LEXBR",OpcodeType.RRE_FEFE,"load rounded extended to short bfp","g5","esa,zarch");
    public static final Opcode OP_LEDBR = new Opcode(DatatypeConverter.parseHexBinary("b344"),"LEDBR",OpcodeType.RRE_FF,"load rounded long to short bfp","g5","esa,zarch");
    public static final Opcode OP_MXBR = new Opcode(DatatypeConverter.parseHexBinary("b34c"),"MXBR",OpcodeType.RRE_FEFE,"multiply extended bfp","g5","esa,zarch");
    public static final Opcode OP_MDBR = new Opcode(DatatypeConverter.parseHexBinary("b31c"),"MDBR",OpcodeType.RRE_FF,"multiply long bfp","g5","esa,zarch");
    public static final Opcode OP_MDB = new Opcode(DatatypeConverter.parseHexBinary("ed000000001c"),"MDB",OpcodeType.RXE_FRRD,"multiply long bfp","g5","esa,zarch");
    public static final Opcode OP_MXDBR = new Opcode(DatatypeConverter.parseHexBinary("b307"),"MXDBR",OpcodeType.RRE_FEF,"multiply long to extended bfp","g5","esa,zarch");
    public static final Opcode OP_MXDB = new Opcode(DatatypeConverter.parseHexBinary("ed0000000007"),"MXDB",OpcodeType.RXE_FERRD,"multiply long to extended bfp","g5","esa,zarch");
    public static final Opcode OP_MEEBR = new Opcode(DatatypeConverter.parseHexBinary("b317"),"MEEBR",OpcodeType.RRE_FF,"multiply short bfp","g5","esa,zarch");
    public static final Opcode OP_MEEB = new Opcode(DatatypeConverter.parseHexBinary("ed0000000017"),"MEEB",OpcodeType.RXE_FRRD,"multiply short bfp","g5","esa,zarch");
    public static final Opcode OP_MDEBR = new Opcode(DatatypeConverter.parseHexBinary("b30c"),"MDEBR",OpcodeType.RRE_FF,"multiply short to long bfp","g5","esa,zarch");
    public static final Opcode OP_MDEB = new Opcode(DatatypeConverter.parseHexBinary("ed000000000c"),"MDEB",OpcodeType.RXE_FRRD,"multiply short to long bfp","g5","esa,zarch");
    public static final Opcode OP_MADBR = new Opcode(DatatypeConverter.parseHexBinary("b31e"),"MADBR",OpcodeType.RRF_F0FF,"multiply and add long bfp","g5","esa,zarch");
    public static final Opcode OP_MADB = new Opcode(DatatypeConverter.parseHexBinary("ed000000001e"),"MADB",OpcodeType.RXF_FRRDF,"multiply and add long bfp","g5","esa,zarch");
    public static final Opcode OP_MAEBR = new Opcode(DatatypeConverter.parseHexBinary("b30e"),"MAEBR",OpcodeType.RRF_F0FF,"multiply and add short bfp","g5","esa,zarch");
    public static final Opcode OP_MAEB = new Opcode(DatatypeConverter.parseHexBinary("ed000000000e"),"MAEB",OpcodeType.RXF_FRRDF,"multiply and add short bfp","g5","esa,zarch");
    public static final Opcode OP_MSDBR = new Opcode(DatatypeConverter.parseHexBinary("b31f"),"MSDBR",OpcodeType.RRF_F0FF,"multiply and subtract long bfp","g5","esa,zarch");
    public static final Opcode OP_MSDB = new Opcode(DatatypeConverter.parseHexBinary("ed000000001f"),"MSDB",OpcodeType.RXF_FRRDF,"multiply and subtract long bfp","g5","esa,zarch");
    public static final Opcode OP_MSEBR = new Opcode(DatatypeConverter.parseHexBinary("b30f"),"MSEBR",OpcodeType.RRF_F0FF,"multiply and subtract short bfp","g5","esa,zarch");
    public static final Opcode OP_MSEB = new Opcode(DatatypeConverter.parseHexBinary("ed000000000f"),"MSEB",OpcodeType.RXF_FRRDF,"multiply and subtract short bfp","g5","esa,zarch");
    public static final Opcode OP_SFPC = new Opcode(DatatypeConverter.parseHexBinary("b384"),"SFPC",OpcodeType.RRE_RR,"set fpc","g5","esa,zarch");
    public static final Opcode OP_SRNM = new Opcode(DatatypeConverter.parseHexBinary("b299"),"SRNM",OpcodeType.S_RD,"set rounding mode","g5","esa,zarch");
    public static final Opcode OP_SQXBR = new Opcode(DatatypeConverter.parseHexBinary("b316"),"SQXBR",OpcodeType.RRE_FEFE,"square root extended bfp","g5","esa,zarch");
    public static final Opcode OP_SQDBR = new Opcode(DatatypeConverter.parseHexBinary("b315"),"SQDBR",OpcodeType.RRE_FF,"square root long bfp","g5","esa,zarch");
    public static final Opcode OP_SQDB = new Opcode(DatatypeConverter.parseHexBinary("ed0000000015"),"SQDB",OpcodeType.RXE_FRRD,"square root long bfp","g5","esa,zarch");
    public static final Opcode OP_SQEBR = new Opcode(DatatypeConverter.parseHexBinary("b314"),"SQEBR",OpcodeType.RRE_FF,"square root short bfp","g5","esa,zarch");
    public static final Opcode OP_SQEB = new Opcode(DatatypeConverter.parseHexBinary("ed0000000014"),"SQEB",OpcodeType.RXE_FRRD,"square root short bfp","g5","esa,zarch");
    public static final Opcode OP_STFPC = new Opcode(DatatypeConverter.parseHexBinary("b29c"),"STFPC",OpcodeType.S_RD,"store fpc","g5","esa,zarch");
    public static final Opcode OP_SXBR = new Opcode(DatatypeConverter.parseHexBinary("b34b"),"SXBR",OpcodeType.RRE_FEFE,"subtract extended bfp","g5","esa,zarch");
    public static final Opcode OP_SDBR = new Opcode(DatatypeConverter.parseHexBinary("b31b"),"SDBR",OpcodeType.RRE_FF,"subtract long bfp","g5","esa,zarch");
    public static final Opcode OP_SDB = new Opcode(DatatypeConverter.parseHexBinary("ed000000001b"),"SDB",OpcodeType.RXE_FRRD,"subtract long bfp","g5","esa,zarch");
    public static final Opcode OP_SEBR = new Opcode(DatatypeConverter.parseHexBinary("b30b"),"SEBR",OpcodeType.RRE_FF,"subtract short bfp","g5","esa,zarch");
    public static final Opcode OP_SEB = new Opcode(DatatypeConverter.parseHexBinary("ed000000000b"),"SEB",OpcodeType.RXE_FRRD,"subtract short bfp","g5","esa,zarch");
    public static final Opcode OP_TCXB = new Opcode(DatatypeConverter.parseHexBinary("ed0000000012"),"TCXB",OpcodeType.RXE_FERRD,"test data class extended bfp","g5","esa,zarch");
    public static final Opcode OP_TCDB = new Opcode(DatatypeConverter.parseHexBinary("ed0000000011"),"TCDB",OpcodeType.RXE_FRRD,"test data class long bfp","g5","esa,zarch");
    public static final Opcode OP_TCEB = new Opcode(DatatypeConverter.parseHexBinary("ed0000000010"),"TCEB",OpcodeType.RXE_FRRD,"test data class short bfp","g5","esa,zarch");
    public static final Opcode OP_SIGA = new Opcode(DatatypeConverter.parseHexBinary("b274"),"SIGA",OpcodeType.S_RD,"signal adapter","g5","esa,zarch");
    public static final Opcode OP_CUUTF = new Opcode(DatatypeConverter.parseHexBinary("b2a6"),"CUUTF",OpcodeType.RRE_RERE,"convert unicode to utf-8","g5","esa,zarch");
    public static final Opcode OP_CUTFU = new Opcode(DatatypeConverter.parseHexBinary("b2a7"),"CUTFU",OpcodeType.RRE_RR,"convert utf-8 to unicode","g5","esa,zarch");
    public static final Opcode OP_PLO = new Opcode(DatatypeConverter.parseHexBinary("ee"),"PLO",OpcodeType.SS_RRRDRD2,"perform locked operation","g5","esa,zarch");
    public static final Opcode OP_BSA = new Opcode(DatatypeConverter.parseHexBinary("b25a"),"BSA",OpcodeType.RRE_RR,"branch and set authority","g5","esa,zarch");
    public static final Opcode OP_RP = new Opcode(DatatypeConverter.parseHexBinary("b277"),"RP",OpcodeType.S_RD,"resume program","g5","esa,zarch");
    public static final Opcode OP_SCKPF = new Opcode(DatatypeConverter.parseHexBinary("0107"),"SCKPF",OpcodeType.E,"set clock programmable field","g5","esa,zarch");
    public static final Opcode OP_STSI = new Opcode(DatatypeConverter.parseHexBinary("b27d"),"STSI",OpcodeType.S_RD,"store system information","g5","esa,zarch");
    public static final Opcode OP_TRAP2 = new Opcode(DatatypeConverter.parseHexBinary("01ff"),"TRAP2",OpcodeType.E,"trap","g5","esa,zarch");
    public static final Opcode OP_TRAP4 = new Opcode(DatatypeConverter.parseHexBinary("b2ff"),"TRAP4",OpcodeType.S_RD,"trap4","g5","esa,zarch");
    public static final Opcode OP_STCKE = new Opcode(DatatypeConverter.parseHexBinary("b278"),"STCKE",OpcodeType.S_RD,"store clock extended","g5","esa,zarch");
    public static final Opcode OP_TRE = new Opcode(DatatypeConverter.parseHexBinary("b2a5"),"TRE",OpcodeType.RRE_RER,"translate extended","g5","esa,zarch");
    public static final Opcode OP_MVCLU = new Opcode(DatatypeConverter.parseHexBinary("eb000000008e"),"MVCLU",OpcodeType.RSE_RERERD,"move long unicode","g5","esa,zarch");
    public static final Opcode OP_PKA = new Opcode(DatatypeConverter.parseHexBinary("e9"),"PKA",OpcodeType.SS_L2RDRD,"pack ascii","g5","esa,zarch");
    public static final Opcode OP_PKU = new Opcode(DatatypeConverter.parseHexBinary("e1"),"PKU",OpcodeType.SS_L2RDRD,"pack unicode","g5","esa,zarch");
    public static final Opcode OP_TROO = new Opcode(DatatypeConverter.parseHexBinary("b993"),"TROO",OpcodeType.RRE_RER,"translate one to one","g5","esa,zarch");
    public static final Opcode OP_TROT = new Opcode(DatatypeConverter.parseHexBinary("b992"),"TROT",OpcodeType.RRE_RER,"translate one to two","g5","esa,zarch");
    public static final Opcode OP_TRTO = new Opcode(DatatypeConverter.parseHexBinary("b991"),"TRTO",OpcodeType.RRE_RER,"translate two to one","g5","esa,zarch");
    public static final Opcode OP_TRTT = new Opcode(DatatypeConverter.parseHexBinary("b990"),"TRTT",OpcodeType.RRE_RER,"translate two to two","g5","esa,zarch");
    public static final Opcode OP_UNPKA = new Opcode(DatatypeConverter.parseHexBinary("ea"),"UNPKA",OpcodeType.SS_L0RDRD,"unpack ascii","g5","esa,zarch");
    public static final Opcode OP_UNPKU = new Opcode(DatatypeConverter.parseHexBinary("e2"),"UNPKU",OpcodeType.SS_L0RDRD,"unpack unicode","g5","esa,zarch");
    public static final Opcode OP_THDER = new Opcode(DatatypeConverter.parseHexBinary("b358"),"THDER",OpcodeType.RRE_FF,"convert short bfp to long hfp","g5","esa,zarch");
    public static final Opcode OP_THDR = new Opcode(DatatypeConverter.parseHexBinary("b359"),"THDR",OpcodeType.RRE_FF,"convert long bfp to long hfp","g5","esa,zarch");
    public static final Opcode OP_TBEDR = new Opcode(DatatypeConverter.parseHexBinary("b350"),"TBEDR",OpcodeType.RRF_U0FF,"convert long hfp to short bfp","g5","esa,zarch");
    public static final Opcode OP_TBDR = new Opcode(DatatypeConverter.parseHexBinary("b351"),"TBDR",OpcodeType.RRF_U0FF,"convert long hfp to long bfp","g5","esa,zarch");
    public static final Opcode OP_LZER = new Opcode(DatatypeConverter.parseHexBinary("b374"),"LZER",OpcodeType.RRE_F0,"load short zero","g5","esa,zarch");
    public static final Opcode OP_LZDR = new Opcode(DatatypeConverter.parseHexBinary("b375"),"LZDR",OpcodeType.RRE_F0,"load long zero","g5","esa,zarch");
    public static final Opcode OP_LZXR = new Opcode(DatatypeConverter.parseHexBinary("b376"),"LZXR",OpcodeType.RRE_FE0,"load extended zero","g5","esa,zarch");
    public static final Opcode OP_BCTGR = new Opcode(DatatypeConverter.parseHexBinary("b946"),"BCTGR",OpcodeType.RRE_RR,"branch on count 64","z900","zarch");
    public static final Opcode OP_LPGR = new Opcode(DatatypeConverter.parseHexBinary("b900"),"LPGR",OpcodeType.RRE_RR,"load positive 64","z900","zarch");
    public static final Opcode OP_LPGFR = new Opcode(DatatypeConverter.parseHexBinary("b910"),"LPGFR",OpcodeType.RRE_RR,"load positive 64<32","z900","zarch");
    public static final Opcode OP_LNGR = new Opcode(DatatypeConverter.parseHexBinary("b901"),"LNGR",OpcodeType.RRE_RR,"load negative 64","z900","zarch");
    public static final Opcode OP_LNGFR = new Opcode(DatatypeConverter.parseHexBinary("b911"),"LNGFR",OpcodeType.RRE_RR,"load negative 64<32","z900","zarch");
    public static final Opcode OP_LTGR = new Opcode(DatatypeConverter.parseHexBinary("b902"),"LTGR",OpcodeType.RRE_RR,"load and test 64","z900","zarch");
    public static final Opcode OP_LTGFR = new Opcode(DatatypeConverter.parseHexBinary("b912"),"LTGFR",OpcodeType.RRE_RR,"load and test 64<32","z900","zarch");
    public static final Opcode OP_LCGR = new Opcode(DatatypeConverter.parseHexBinary("b903"),"LCGR",OpcodeType.RRE_RR,"load complement 64","z900","zarch");
    public static final Opcode OP_LCGFR = new Opcode(DatatypeConverter.parseHexBinary("b913"),"LCGFR",OpcodeType.RRE_RR,"load complement 64<32","z900","zarch");
    public static final Opcode OP_NGR = new Opcode(DatatypeConverter.parseHexBinary("b980"),"NGR",OpcodeType.RRE_RR,"and 64","z900","zarch");
    public static final Opcode OP_CLGR = new Opcode(DatatypeConverter.parseHexBinary("b921"),"CLGR",OpcodeType.RRE_RR,"compare logical 64","z900","zarch");
    public static final Opcode OP_CLGFR = new Opcode(DatatypeConverter.parseHexBinary("b931"),"CLGFR",OpcodeType.RRE_RR,"compare logical 64<32","z900","zarch");
    public static final Opcode OP_OGR = new Opcode(DatatypeConverter.parseHexBinary("b981"),"OGR",OpcodeType.RRE_RR,"or 64","z900","zarch");
    public static final Opcode OP_XGR = new Opcode(DatatypeConverter.parseHexBinary("b982"),"XGR",OpcodeType.RRE_RR,"exclusive or 64","z900","zarch");
    public static final Opcode OP_LGR = new Opcode(DatatypeConverter.parseHexBinary("b904"),"LGR",OpcodeType.RRE_RR,"load 64","z900","zarch");
    public static final Opcode OP_LGFR = new Opcode(DatatypeConverter.parseHexBinary("b914"),"LGFR",OpcodeType.RRE_RR,"load 64<32","z900","zarch");
    public static final Opcode OP_CGR = new Opcode(DatatypeConverter.parseHexBinary("b920"),"CGR",OpcodeType.RRE_RR,"compare 64","z900","zarch");
    public static final Opcode OP_CGFR = new Opcode(DatatypeConverter.parseHexBinary("b930"),"CGFR",OpcodeType.RRE_RR,"compare 64<32","z900","zarch");
    public static final Opcode OP_AGR = new Opcode(DatatypeConverter.parseHexBinary("b908"),"AGR",OpcodeType.RRE_RR,"add 64","z900","zarch");
    public static final Opcode OP_AGFR = new Opcode(DatatypeConverter.parseHexBinary("b918"),"AGFR",OpcodeType.RRE_RR,"add 64<32","z900","zarch");
    public static final Opcode OP_SGR = new Opcode(DatatypeConverter.parseHexBinary("b909"),"SGR",OpcodeType.RRE_RR,"subtract 64","z900","zarch");
    public static final Opcode OP_SGFR = new Opcode(DatatypeConverter.parseHexBinary("b919"),"SGFR",OpcodeType.RRE_RR,"subtract 64<32","z900","zarch");
    public static final Opcode OP_ALGR = new Opcode(DatatypeConverter.parseHexBinary("b90a"),"ALGR",OpcodeType.RRE_RR,"add logical 64","z900","zarch");
    public static final Opcode OP_ALGFR = new Opcode(DatatypeConverter.parseHexBinary("b91a"),"ALGFR",OpcodeType.RRE_RR,"add logical 64<32","z900","zarch");
    public static final Opcode OP_SLGR = new Opcode(DatatypeConverter.parseHexBinary("b90b"),"SLGR",OpcodeType.RRE_RR,"subtract logical 64","z900","zarch");
    public static final Opcode OP_SLGFR = new Opcode(DatatypeConverter.parseHexBinary("b91b"),"SLGFR",OpcodeType.RRE_RR,"subtract logical 64<32","z900","zarch");
    public static final Opcode OP_BCTG = new Opcode(DatatypeConverter.parseHexBinary("e30000000046"),"BCTG",OpcodeType.RXE_RRRD,"branch on count 64","z900","zarch");
    public static final Opcode OP_CVDG = new Opcode(DatatypeConverter.parseHexBinary("e3000000002e"),"CVDG",OpcodeType.RXE_RRRD,"convert to decimal 64","z900","zarch");
    public static final Opcode OP_CVBG = new Opcode(DatatypeConverter.parseHexBinary("e3000000000e"),"CVBG",OpcodeType.RXE_RRRD,"convert to binary 64","z900","zarch");
    public static final Opcode OP_STG = new Opcode(DatatypeConverter.parseHexBinary("e30000000024"),"STG",OpcodeType.RXE_RRRD,"store 64","z900","zarch");
    public static final Opcode OP_NG = new Opcode(DatatypeConverter.parseHexBinary("e30000000080"),"NG",OpcodeType.RXE_RRRD,"and 64","z900","zarch");
    public static final Opcode OP_CLG = new Opcode(DatatypeConverter.parseHexBinary("e30000000021"),"CLG",OpcodeType.RXE_RRRD,"compare logical 64","z900","zarch");
    public static final Opcode OP_CLGF = new Opcode(DatatypeConverter.parseHexBinary("e30000000031"),"CLGF",OpcodeType.RXE_RRRD,"compare logical 64<32","z900","zarch");
    public static final Opcode OP_OG = new Opcode(DatatypeConverter.parseHexBinary("e30000000081"),"OG",OpcodeType.RXE_RRRD,"or 64","z900","zarch");
    public static final Opcode OP_XG = new Opcode(DatatypeConverter.parseHexBinary("e30000000082"),"XG",OpcodeType.RXE_RRRD,"exclusive or 64","z900","zarch");
    public static final Opcode OP_LG = new Opcode(DatatypeConverter.parseHexBinary("e30000000004"),"LG",OpcodeType.RXE_RRRD,"load 64","z900","zarch");
    public static final Opcode OP_LGF = new Opcode(DatatypeConverter.parseHexBinary("e30000000014"),"LGF",OpcodeType.RXE_RRRD,"load 64<32","z900","zarch");
    public static final Opcode OP_LGH = new Opcode(DatatypeConverter.parseHexBinary("e30000000015"),"LGH",OpcodeType.RXE_RRRD,"load halfword 64","z900","zarch");
    public static final Opcode OP_CG = new Opcode(DatatypeConverter.parseHexBinary("e30000000020"),"CG",OpcodeType.RXE_RRRD,"compare 64","z900","zarch");
    public static final Opcode OP_CGF = new Opcode(DatatypeConverter.parseHexBinary("e30000000030"),"CGF",OpcodeType.RXE_RRRD,"compare 64<32","z900","zarch");
    public static final Opcode OP_AG = new Opcode(DatatypeConverter.parseHexBinary("e30000000008"),"AG",OpcodeType.RXE_RRRD,"add 64","z900","zarch");
    public static final Opcode OP_AGF = new Opcode(DatatypeConverter.parseHexBinary("e30000000018"),"AGF",OpcodeType.RXE_RRRD,"add 64<32","z900","zarch");
    public static final Opcode OP_SG = new Opcode(DatatypeConverter.parseHexBinary("e30000000009"),"SG",OpcodeType.RXE_RRRD,"subtract 64","z900","zarch");
    public static final Opcode OP_SGF = new Opcode(DatatypeConverter.parseHexBinary("e30000000019"),"SGF",OpcodeType.RXE_RRRD,"subtract 64<32","z900","zarch");
    public static final Opcode OP_ALG = new Opcode(DatatypeConverter.parseHexBinary("e3000000000a"),"ALG",OpcodeType.RXE_RRRD,"add logical 64","z900","zarch");
    public static final Opcode OP_ALGF = new Opcode(DatatypeConverter.parseHexBinary("e3000000001a"),"ALGF",OpcodeType.RXE_RRRD,"add logical 64<32","z900","zarch");
    public static final Opcode OP_SLG = new Opcode(DatatypeConverter.parseHexBinary("e3000000000b"),"SLG",OpcodeType.RXE_RRRD,"subtract logical 64","z900","zarch");
    public static final Opcode OP_SLGF = new Opcode(DatatypeConverter.parseHexBinary("e3000000001b"),"SLGF",OpcodeType.RXE_RRRD,"subtract logical 64<32","z900","zarch");
    public static final Opcode OP_MSG = new Opcode(DatatypeConverter.parseHexBinary("e3000000000c"),"MSG",OpcodeType.RXE_RRRD,"multiply single 64","z900","zarch");
    public static final Opcode OP_MSGF = new Opcode(DatatypeConverter.parseHexBinary("e3000000001c"),"MSGF",OpcodeType.RXE_RRRD,"multiply single 64<32","z900","zarch");
    public static final Opcode OP_BRXHG = new Opcode(DatatypeConverter.parseHexBinary("ec0000000044"),"BRXHG",OpcodeType.RIE_RRP,"branch relative on index high 64","z900","zarch");
    public static final Opcode OP_BRXLG = new Opcode(DatatypeConverter.parseHexBinary("ec0000000045"),"BRXLG",OpcodeType.RIE_RRP,"branch relative on index low or equal 64","z900","zarch");
    public static final Opcode OP_BXHG = new Opcode(DatatypeConverter.parseHexBinary("eb0000000044"),"BXHG",OpcodeType.RSE_RRRD,"branch on index high 64","z900","zarch");
    public static final Opcode OP_BXLEG = new Opcode(DatatypeConverter.parseHexBinary("eb0000000045"),"BXLEG",OpcodeType.RSE_RRRD,"branch on index low or equal 64","z900","zarch");
    public static final Opcode OP_SRLG = new Opcode(DatatypeConverter.parseHexBinary("eb000000000c"),"SRLG",OpcodeType.RSE_RRRD,"shift right single logical 64","z900","zarch");
    public static final Opcode OP_SLLG = new Opcode(DatatypeConverter.parseHexBinary("eb000000000d"),"SLLG",OpcodeType.RSE_RRRD,"shift left single logical 64","z900","zarch");
    public static final Opcode OP_SRAG = new Opcode(DatatypeConverter.parseHexBinary("eb000000000a"),"SRAG",OpcodeType.RSE_RRRD,"shift right single 64","z900","zarch");
    public static final Opcode OP_SLAG = new Opcode(DatatypeConverter.parseHexBinary("eb000000000b"),"SLAG",OpcodeType.RSE_RRRD,"shift left single 64","z900","zarch");
    public static final Opcode OP_STMG = new Opcode(DatatypeConverter.parseHexBinary("eb0000000024"),"STMG",OpcodeType.RSE_RRRD,"store multiple 64","z900","zarch");
    public static final Opcode OP_STMH = new Opcode(DatatypeConverter.parseHexBinary("eb0000000026"),"STMH",OpcodeType.RSE_RRRD,"store multiple high","z900","zarch");
    public static final Opcode OP_LMG = new Opcode(DatatypeConverter.parseHexBinary("eb0000000004"),"LMG",OpcodeType.RSE_RRRD,"load multiple 64","z900","zarch");
    public static final Opcode OP_LMH = new Opcode(DatatypeConverter.parseHexBinary("eb0000000096"),"LMH",OpcodeType.RSE_RRRD,"load multiple high","z900","zarch");
    public static final Opcode OP_LMD = new Opcode(DatatypeConverter.parseHexBinary("ef"),"LMD",OpcodeType.SS_RRRDRD3,"load multiple disjoint","z900","zarch");
    public static final Opcode OP_TRACG = new Opcode(DatatypeConverter.parseHexBinary("eb000000000f"),"TRACG",OpcodeType.RSE_RRRD,"trace 64","z900","zarch");
    public static final Opcode OP_LRAG = new Opcode(DatatypeConverter.parseHexBinary("e30000000003"),"LRAG",OpcodeType.RXE_RRRD,"load real address 64","z900","zarch");
    public static final Opcode OP_STRAG = new Opcode(DatatypeConverter.parseHexBinary("e502"),"STRAG",OpcodeType.SSE_RDRD,"store read address","z900","zarch");
    public static final Opcode OP_STCTG = new Opcode(DatatypeConverter.parseHexBinary("eb0000000025"),"STCTG",OpcodeType.RSE_CCRD,"store control 64","z900","zarch");
    public static final Opcode OP_LCTLG = new Opcode(DatatypeConverter.parseHexBinary("eb000000002f"),"LCTLG",OpcodeType.RSE_CCRD,"load control 64","z900","zarch");
    public static final Opcode OP_CSG = new Opcode(DatatypeConverter.parseHexBinary("eb0000000030"),"CSG",OpcodeType.RSE_RRRD,"compare and swap 64","z900","zarch");
    public static final Opcode OP_CDSG = new Opcode(DatatypeConverter.parseHexBinary("eb000000003e"),"CDSG",OpcodeType.RSE_RERERD,"compare double and swap 64","z900","zarch");
    public static final Opcode OP_CLMH = new Opcode(DatatypeConverter.parseHexBinary("eb0000000020"),"CLMH",OpcodeType.RSE_RURD,"compare logical characters under mask high","z900","zarch");
    public static final Opcode OP_STCMH = new Opcode(DatatypeConverter.parseHexBinary("eb000000002c"),"STCMH",OpcodeType.RSE_RURD,"store characters under mask high","z900","zarch");
    public static final Opcode OP_ICMH = new Opcode(DatatypeConverter.parseHexBinary("eb0000000080"),"ICMH",OpcodeType.RSE_RURD,"insert characters under mask high","z900","zarch");
    public static final Opcode OP_TMHH = new Opcode(DatatypeConverter.parseHexBinary("a702"),"TMHH",OpcodeType.RI_RU,"test under mask high high","z900","zarch");
    public static final Opcode OP_TMHL = new Opcode(DatatypeConverter.parseHexBinary("a703"),"TMHL",OpcodeType.RI_RU,"test under mask high low","z900","zarch");
    public static final Opcode OP_BRCL = new Opcode(DatatypeConverter.parseHexBinary("c004"),"BRCL",OpcodeType.RIL_UP,"branch relative on condition long","z900","esa,zarch");
    public static final Opcode OP_JG = new Opcode(DatatypeConverter.parseHexBinary("c0f4"),"JG",OpcodeType.RIL_0P,"unconditional jump long","z900","esa,zarch");
    public static final Opcode OP_BRASL = new Opcode(DatatypeConverter.parseHexBinary("c005"),"BRASL",OpcodeType.RIL_RP,"branch relative and save long","z900","esa,zarch");
    public static final Opcode OP_BRCTG = new Opcode(DatatypeConverter.parseHexBinary("a707"),"BRCTG",OpcodeType.RI_RP,"branch relative on count 64","z900","zarch");
    public static final Opcode OP_LGHI = new Opcode(DatatypeConverter.parseHexBinary("a709"),"LGHI",OpcodeType.RI_RI,"load halfword immediate 64","z900","zarch");
    public static final Opcode OP_AGHI = new Opcode(DatatypeConverter.parseHexBinary("a70b"),"AGHI",OpcodeType.RI_RI,"add halfword immediate 64","z900","zarch");
    public static final Opcode OP_MGHI = new Opcode(DatatypeConverter.parseHexBinary("a70d"),"MGHI",OpcodeType.RI_RI,"multiply halfword immediate 64","z900","zarch");
    public static final Opcode OP_CGHI = new Opcode(DatatypeConverter.parseHexBinary("a70f"),"CGHI",OpcodeType.RI_RI,"compare halfword immediate 64","z900","zarch");
    public static final Opcode OP_STURG = new Opcode(DatatypeConverter.parseHexBinary("b925"),"STURG",OpcodeType.RRE_RR,"store using real address 64","z900","zarch");
    public static final Opcode OP_EREGG = new Opcode(DatatypeConverter.parseHexBinary("b90e"),"EREGG",OpcodeType.RRE_RR,"extract stacked registers 64","z900","zarch");
    public static final Opcode OP_LURAG = new Opcode(DatatypeConverter.parseHexBinary("b905"),"LURAG",OpcodeType.RRE_RR,"load using real address 64","z900","zarch");
    public static final Opcode OP_MSGR = new Opcode(DatatypeConverter.parseHexBinary("b90c"),"MSGR",OpcodeType.RRE_RR,"multiply single 64","z900","zarch");
    public static final Opcode OP_MSGFR = new Opcode(DatatypeConverter.parseHexBinary("b91c"),"MSGFR",OpcodeType.RRE_RR,"multiply single 64<32","z900","zarch");
    public static final Opcode OP_CEGBR = new Opcode(DatatypeConverter.parseHexBinary("b3a4"),"CEGBR",OpcodeType.RRE_FR,"convert from fixed 64 to short bfp","z900","zarch");
    public static final Opcode OP_CDGBR = new Opcode(DatatypeConverter.parseHexBinary("b3a5"),"CDGBR",OpcodeType.RRE_FR,"convert from fixed 64 to long bfp","z900","zarch");
    public static final Opcode OP_CXGBR = new Opcode(DatatypeConverter.parseHexBinary("b3a6"),"CXGBR",OpcodeType.RRE_FER,"convert from fixed 64 to extended bfp","z900","zarch");
    public static final Opcode OP_CGEBR = new Opcode(DatatypeConverter.parseHexBinary("b3a8"),"CGEBR",OpcodeType.RRF_U0RF,"convert to fixed short bfd to 64","z900","zarch");
    public static final Opcode OP_CGDBR = new Opcode(DatatypeConverter.parseHexBinary("b3a9"),"CGDBR",OpcodeType.RRF_U0RF,"convert to fixed long bfp to 64","z900","zarch");
    public static final Opcode OP_CGXBR = new Opcode(DatatypeConverter.parseHexBinary("b3aa"),"CGXBR",OpcodeType.RRF_U0RFE,"convert to fixed extended bfp to 64","z900","zarch");
    public static final Opcode OP_CEGR = new Opcode(DatatypeConverter.parseHexBinary("b3c4"),"CEGR",OpcodeType.RRE_FR,"convert from fixed 64 to short hfp","z900","zarch");
    public static final Opcode OP_CDGR = new Opcode(DatatypeConverter.parseHexBinary("b3c5"),"CDGR",OpcodeType.RRE_FR,"convert from fixed 64 to long hfp","z900","zarch");
    public static final Opcode OP_CXGR = new Opcode(DatatypeConverter.parseHexBinary("b3c6"),"CXGR",OpcodeType.RRE_FER,"convert from fixed 64 to extended hfp","z900","zarch");
    public static final Opcode OP_CGER = new Opcode(DatatypeConverter.parseHexBinary("b3c8"),"CGER",OpcodeType.RRF_U0RF,"convert to fixed short hfp to 64","z900","zarch");
    public static final Opcode OP_CGDR = new Opcode(DatatypeConverter.parseHexBinary("b3c9"),"CGDR",OpcodeType.RRF_U0RF,"convert to fixed long hfp to 64","z900","zarch");
    public static final Opcode OP_CGXR = new Opcode(DatatypeConverter.parseHexBinary("b3ca"),"CGXR",OpcodeType.RRF_U0RFE,"convert to fixed extended hfp to 64","z900","zarch");
    public static final Opcode OP_TAM = new Opcode(DatatypeConverter.parseHexBinary("010b"),"TAM",OpcodeType.E,"test addressing mode","z900","esa,zarch");
    public static final Opcode OP_SAM24 = new Opcode(DatatypeConverter.parseHexBinary("010c"),"SAM24",OpcodeType.E,"set addressing mode 24","z900","esa,zarch");
    public static final Opcode OP_SAM31 = new Opcode(DatatypeConverter.parseHexBinary("010d"),"SAM31",OpcodeType.E,"set addressing mode 31","z900","esa,zarch");
    public static final Opcode OP_SAM64 = new Opcode(DatatypeConverter.parseHexBinary("010e"),"SAM64",OpcodeType.E,"set addressing mode 64","z900","zarch");
    public static final Opcode OP_IIHH = new Opcode(DatatypeConverter.parseHexBinary("a500"),"IIHH",OpcodeType.RI_RU,"insert immediate high high","z900","zarch");
    public static final Opcode OP_IIHL = new Opcode(DatatypeConverter.parseHexBinary("a501"),"IIHL",OpcodeType.RI_RU,"insert immediate high low","z900","zarch");
    public static final Opcode OP_IILH = new Opcode(DatatypeConverter.parseHexBinary("a502"),"IILH",OpcodeType.RI_RU,"insert immediate low high","z900","zarch");
    public static final Opcode OP_IILL = new Opcode(DatatypeConverter.parseHexBinary("a503"),"IILL",OpcodeType.RI_RU,"insert immediate low low","z900","zarch");
    public static final Opcode OP_NIHH = new Opcode(DatatypeConverter.parseHexBinary("a504"),"NIHH",OpcodeType.RI_RU,"and immediate high high","z900","zarch");
    public static final Opcode OP_NIHL = new Opcode(DatatypeConverter.parseHexBinary("a505"),"NIHL",OpcodeType.RI_RU,"and immediate high low","z900","zarch");
    public static final Opcode OP_NILH = new Opcode(DatatypeConverter.parseHexBinary("a506"),"NILH",OpcodeType.RI_RU,"and immediate low high","z900","zarch");
    public static final Opcode OP_NILL = new Opcode(DatatypeConverter.parseHexBinary("a507"),"NILL",OpcodeType.RI_RU,"and immediate low low","z900","zarch");
    public static final Opcode OP_OIHH = new Opcode(DatatypeConverter.parseHexBinary("a508"),"OIHH",OpcodeType.RI_RU,"or immediate high high","z900","zarch");
    public static final Opcode OP_OIHL = new Opcode(DatatypeConverter.parseHexBinary("a509"),"OIHL",OpcodeType.RI_RU,"or immediate high low","z900","zarch");
    public static final Opcode OP_OILH = new Opcode(DatatypeConverter.parseHexBinary("a50a"),"OILH",OpcodeType.RI_RU,"or immediate low high","z900","zarch");
    public static final Opcode OP_OILL = new Opcode(DatatypeConverter.parseHexBinary("a50b"),"OILL",OpcodeType.RI_RU,"or immediate low low","z900","zarch");
    public static final Opcode OP_LLIHH = new Opcode(DatatypeConverter.parseHexBinary("a50c"),"LLIHH",OpcodeType.RI_RU,"load logical immediate high high","z900","zarch");
    public static final Opcode OP_LLIHL = new Opcode(DatatypeConverter.parseHexBinary("a50d"),"LLIHL",OpcodeType.RI_RU,"load logical immediate high low","z900","zarch");
    public static final Opcode OP_LLILH = new Opcode(DatatypeConverter.parseHexBinary("a50e"),"LLILH",OpcodeType.RI_RU,"load logical immediate low high","z900","zarch");
    public static final Opcode OP_LLILL = new Opcode(DatatypeConverter.parseHexBinary("a50f"),"LLILL",OpcodeType.RI_RU,"load logical immediate low low","z900","zarch");
    public static final Opcode OP_STFL = new Opcode(DatatypeConverter.parseHexBinary("b2b1"),"STFL",OpcodeType.S_RD,"store facility list","z900","esa,zarch");
    public static final Opcode OP_LPSWE = new Opcode(DatatypeConverter.parseHexBinary("b2b2"),"LPSWE",OpcodeType.S_RD,"load psw extended","z900","zarch");
    public static final Opcode OP_DSGR = new Opcode(DatatypeConverter.parseHexBinary("b90d"),"DSGR",OpcodeType.RRE_RER,"divide single 64","z900","zarch");
    public static final Opcode OP_LRVGR = new Opcode(DatatypeConverter.parseHexBinary("b90f"),"LRVGR",OpcodeType.RRE_RR,"load reversed 64","z900","zarch");
    public static final Opcode OP_LLGFR = new Opcode(DatatypeConverter.parseHexBinary("b916"),"LLGFR",OpcodeType.RRE_RR,"load logical 64<32","z900","zarch");
    public static final Opcode OP_LLGTR = new Opcode(DatatypeConverter.parseHexBinary("b917"),"LLGTR",OpcodeType.RRE_RR,"load logical thirty one bits","z900","zarch");
    public static final Opcode OP_DSGFR = new Opcode(DatatypeConverter.parseHexBinary("b91d"),"DSGFR",OpcodeType.RRE_RER,"divide single 64<32","z900","zarch");
    public static final Opcode OP_LRVR = new Opcode(DatatypeConverter.parseHexBinary("b91f"),"LRVR",OpcodeType.RRE_RR,"load reversed 32","z900","esa,zarch");
    public static final Opcode OP_MLGR = new Opcode(DatatypeConverter.parseHexBinary("b986"),"MLGR",OpcodeType.RRE_RER,"multiply logical 64","z900","zarch");
    public static final Opcode OP_DLGR = new Opcode(DatatypeConverter.parseHexBinary("b987"),"DLGR",OpcodeType.RRE_RER,"divide logical 64","z900","zarch");
    public static final Opcode OP_ALCGR = new Opcode(DatatypeConverter.parseHexBinary("b988"),"ALCGR",OpcodeType.RRE_RR,"add logical with carry 64","z900","zarch");
    public static final Opcode OP_SLBGR = new Opcode(DatatypeConverter.parseHexBinary("b989"),"SLBGR",OpcodeType.RRE_RR,"subtract logical with borrow 64","z900","zarch");
    public static final Opcode OP_EPSW = new Opcode(DatatypeConverter.parseHexBinary("b98d"),"EPSW",OpcodeType.RRE_RR,"extract psw","z900","esa,zarch");
    public static final Opcode OP_MLR = new Opcode(DatatypeConverter.parseHexBinary("b996"),"MLR",OpcodeType.RRE_RER,"multiply logical 32","z900","esa,zarch");
    public static final Opcode OP_DLR = new Opcode(DatatypeConverter.parseHexBinary("b997"),"DLR",OpcodeType.RRE_RER,"divide logical 32","z900","esa,zarch");
    public static final Opcode OP_ALCR = new Opcode(DatatypeConverter.parseHexBinary("b998"),"ALCR",OpcodeType.RRE_RR,"add logical with carry 32","z900","esa,zarch");
    public static final Opcode OP_SLBR = new Opcode(DatatypeConverter.parseHexBinary("b999"),"SLBR",OpcodeType.RRE_RR,"subtract logical with borrow 32","z900","esa,zarch");
    public static final Opcode OP_ESEA = new Opcode(DatatypeConverter.parseHexBinary("b99d"),"ESEA",OpcodeType.RRE_R0,"extract and set extended authority","z900","zarch");
    public static final Opcode OP_LARL = new Opcode(DatatypeConverter.parseHexBinary("c000"),"LARL",OpcodeType.RIL_RP,"load address relative long","z900","esa,zarch");
    public static final Opcode OP_DSG = new Opcode(DatatypeConverter.parseHexBinary("e3000000000d"),"DSG",OpcodeType.RXE_RERRD,"divide single 64","z900","zarch");
    public static final Opcode OP_LRVG = new Opcode(DatatypeConverter.parseHexBinary("e3000000000f"),"LRVG",OpcodeType.RXE_RRRD,"load reversed 64","z900","zarch");
    public static final Opcode OP_LLGF = new Opcode(DatatypeConverter.parseHexBinary("e30000000016"),"LLGF",OpcodeType.RXE_RRRD,"load logical 64<32","z900","zarch");
    public static final Opcode OP_LLGT = new Opcode(DatatypeConverter.parseHexBinary("e30000000017"),"LLGT",OpcodeType.RXE_RRRD,"load logical thirty one bits","z900","zarch");
    public static final Opcode OP_DSGF = new Opcode(DatatypeConverter.parseHexBinary("e3000000001d"),"DSGF",OpcodeType.RXE_RERRD,"divide single 64<32","z900","zarch");
    public static final Opcode OP_LRV = new Opcode(DatatypeConverter.parseHexBinary("e3000000001e"),"LRV",OpcodeType.RXE_RRRD,"load reversed 32","z900","esa,zarch");
    public static final Opcode OP_LRVH = new Opcode(DatatypeConverter.parseHexBinary("e3000000001f"),"LRVH",OpcodeType.RXE_RRRD,"load reversed 16","z900","esa,zarch");
    public static final Opcode OP_STRVG = new Opcode(DatatypeConverter.parseHexBinary("e3000000002f"),"STRVG",OpcodeType.RXE_RRRD,"store reversed 64","z900","zarch");
    public static final Opcode OP_STRV = new Opcode(DatatypeConverter.parseHexBinary("e3000000003e"),"STRV",OpcodeType.RXE_RRRD,"store reversed 32","z900","esa,zarch");
    public static final Opcode OP_STRVH = new Opcode(DatatypeConverter.parseHexBinary("e3000000003f"),"STRVH",OpcodeType.RXE_RRRD,"store reversed 64","z900","esa,zarch");
    public static final Opcode OP_MLG = new Opcode(DatatypeConverter.parseHexBinary("e30000000086"),"MLG",OpcodeType.RXE_RERRD,"multiply logical 64","z900","zarch");
    public static final Opcode OP_DLG = new Opcode(DatatypeConverter.parseHexBinary("e30000000087"),"DLG",OpcodeType.RXE_RERRD,"divide logical 64","z900","zarch");
    public static final Opcode OP_ALCG = new Opcode(DatatypeConverter.parseHexBinary("e30000000088"),"ALCG",OpcodeType.RXE_RRRD,"add logical with carry 64","z900","zarch");
    public static final Opcode OP_SLBG = new Opcode(DatatypeConverter.parseHexBinary("e30000000089"),"SLBG",OpcodeType.RXE_RRRD,"subtract logical with borrow 64","z900","zarch");
    public static final Opcode OP_STPQ = new Opcode(DatatypeConverter.parseHexBinary("e3000000008e"),"STPQ",OpcodeType.RXE_RRRD,"store pair to quadword","z900","zarch");
    public static final Opcode OP_LPQ = new Opcode(DatatypeConverter.parseHexBinary("e3000000008f"),"LPQ",OpcodeType.RXE_RERRD,"load pair from quadword","z900","zarch");
    public static final Opcode OP_ML = new Opcode(DatatypeConverter.parseHexBinary("e30000000096"),"ML",OpcodeType.RXE_RERRD,"multiply logical 32","z900","esa,zarch");
    public static final Opcode OP_DL = new Opcode(DatatypeConverter.parseHexBinary("e30000000097"),"DL",OpcodeType.RXE_RERRD,"divide logical 32","z900","esa,zarch");
    public static final Opcode OP_ALC = new Opcode(DatatypeConverter.parseHexBinary("e30000000098"),"ALC",OpcodeType.RXE_RRRD,"add logical with carry 32","z900","esa,zarch");
    public static final Opcode OP_SLB = new Opcode(DatatypeConverter.parseHexBinary("e30000000099"),"SLB",OpcodeType.RXE_RRRD,"subtract logical with borrow 32","z900","esa,zarch");
    public static final Opcode OP_LLGC = new Opcode(DatatypeConverter.parseHexBinary("e30000000090"),"LLGC",OpcodeType.RXE_RRRD,"load logical character","z900","zarch");
    public static final Opcode OP_LLGH = new Opcode(DatatypeConverter.parseHexBinary("e30000000091"),"LLGH",OpcodeType.RXE_RRRD,"load logical halfword","z900","zarch");
    public static final Opcode OP_RLLG = new Opcode(DatatypeConverter.parseHexBinary("eb000000001c"),"RLLG",OpcodeType.RSE_RRRD,"rotate left single logical 64","z900","zarch");
    public static final Opcode OP_RLL = new Opcode(DatatypeConverter.parseHexBinary("eb000000001d"),"RLL",OpcodeType.RSE_RRRD,"rotate left single logical 32","z900","esa,zarch");
    public static final Opcode OP_CXR = new Opcode(DatatypeConverter.parseHexBinary("b369"),"CXR",OpcodeType.RRE_FEFE,"compare extended hfp","g5","esa,zarch");
    public static final Opcode OP_CXFR = new Opcode(DatatypeConverter.parseHexBinary("b3b6"),"CXFR",OpcodeType.RRE_FER,"convert from fixed 32 to extended hfp","g5","esa,zarch");
    public static final Opcode OP_CDFR = new Opcode(DatatypeConverter.parseHexBinary("b3b5"),"CDFR",OpcodeType.RRE_FR,"convert from fixed 32 to long hfp","g5","esa,zarch");
    public static final Opcode OP_CEFR = new Opcode(DatatypeConverter.parseHexBinary("b3b4"),"CEFR",OpcodeType.RRE_FR,"convert from fixed 32 to short hfp","g5","esa,zarch");
    public static final Opcode OP_CFXR = new Opcode(DatatypeConverter.parseHexBinary("b3ba"),"CFXR",OpcodeType.RRF_U0RFE,"convert to fixed extended hfp to 32","g5","esa,zarch");
    public static final Opcode OP_CFDR = new Opcode(DatatypeConverter.parseHexBinary("b3b9"),"CFDR",OpcodeType.RRF_U0RF,"convert to fixed long hfp to 32","g5","esa,zarch");
    public static final Opcode OP_CFER = new Opcode(DatatypeConverter.parseHexBinary("b3b8"),"CFER",OpcodeType.RRF_U0RF,"convert to fixed short hfp to 32","g5","esa,zarch");
    public static final Opcode OP_LTXR = new Opcode(DatatypeConverter.parseHexBinary("b362"),"LTXR",OpcodeType.RRE_FEFE,"load and test extended hfp","g5","esa,zarch");
    public static final Opcode OP_LCXR = new Opcode(DatatypeConverter.parseHexBinary("b363"),"LCXR",OpcodeType.RRE_FEFE,"load complement extended hfp","g5","esa,zarch");
    public static final Opcode OP_FIXR = new Opcode(DatatypeConverter.parseHexBinary("b367"),"FIXR",OpcodeType.RRE_FEFE,"load fp integer extended hfp","g5","esa,zarch");
    public static final Opcode OP_FIDR = new Opcode(DatatypeConverter.parseHexBinary("b37f"),"FIDR",OpcodeType.RRE_FF,"load fp integer long hfp","g5","esa,zarch");
    public static final Opcode OP_FIER = new Opcode(DatatypeConverter.parseHexBinary("b377"),"FIER",OpcodeType.RRE_FF,"load fp integer short hfp","g5","esa,zarch");
    public static final Opcode OP_LXDR = new Opcode(DatatypeConverter.parseHexBinary("b325"),"LXDR",OpcodeType.RRE_FEF,"load lengthened long to extended hfp","g5","esa,zarch");
    public static final Opcode OP_LXD = new Opcode(DatatypeConverter.parseHexBinary("ed0000000025"),"LXD",OpcodeType.RXE_FERRD,"load lengthened long to extended hfp","g5","esa,zarch");
    public static final Opcode OP_LXER = new Opcode(DatatypeConverter.parseHexBinary("b326"),"LXER",OpcodeType.RRE_FEF,"load lengthened short to extended hfp","g5","esa,zarch");
    public static final Opcode OP_LXE = new Opcode(DatatypeConverter.parseHexBinary("ed0000000026"),"LXE",OpcodeType.RXE_FERRD,"load lengthened short to extended hfp","g5","esa,zarch");
    public static final Opcode OP_LDER = new Opcode(DatatypeConverter.parseHexBinary("b324"),"LDER",OpcodeType.RRE_FF,"load lengthened short to long hfp","g5","esa,zarch");
    public static final Opcode OP_LDE = new Opcode(DatatypeConverter.parseHexBinary("ed0000000024"),"LDE",OpcodeType.RXE_FRRD,"load lengthened short to long hfp","g5","esa,zarch");
    public static final Opcode OP_LNXR = new Opcode(DatatypeConverter.parseHexBinary("b361"),"LNXR",OpcodeType.RRE_FEFE,"load negative extended hfp","g5","esa,zarch");
    public static final Opcode OP_LPXR = new Opcode(DatatypeConverter.parseHexBinary("b360"),"LPXR",OpcodeType.RRE_FEFE,"load positive extended hfp","g5","esa,zarch");
    public static final Opcode OP_LEXR = new Opcode(DatatypeConverter.parseHexBinary("b366"),"LEXR",OpcodeType.RRE_FFE,"load rounded extended to short hfp","g5","esa,zarch");
    public static final Opcode OP_MEER = new Opcode(DatatypeConverter.parseHexBinary("b337"),"MEER",OpcodeType.RRE_FF,"multiply short hfp","g5","esa,zarch");
    public static final Opcode OP_MEE = new Opcode(DatatypeConverter.parseHexBinary("ed0000000037"),"MEE",OpcodeType.RXE_FRRD,"multiply short hfp","g5","esa,zarch");
    public static final Opcode OP_SQXR = new Opcode(DatatypeConverter.parseHexBinary("b336"),"SQXR",OpcodeType.RRE_FEFE,"square root extended hfp","g5","esa,zarch");
    public static final Opcode OP_SQE = new Opcode(DatatypeConverter.parseHexBinary("ed0000000034"),"SQE",OpcodeType.RXE_FRRD,"square root short hfp","g5","esa,zarch");
    public static final Opcode OP_SQD = new Opcode(DatatypeConverter.parseHexBinary("ed0000000035"),"SQD",OpcodeType.RXE_FRRD,"square root long hfp","g5","esa,zarch");
    public static final Opcode OP_CMPSC = new Opcode(DatatypeConverter.parseHexBinary("b263"),"CMPSC",OpcodeType.RRE_RR,"compression call","g5","esa,zarch");
    public static final Opcode OP_TP = new Opcode(DatatypeConverter.parseHexBinary("eb00000000c0"),"TP",OpcodeType.RSL_R0RD,"test decimal","g5","esa,zarch");
    public static final Opcode OP_LXR = new Opcode(DatatypeConverter.parseHexBinary("b365"),"LXR",OpcodeType.RRE_FEFE,"load extended fp","g5","esa,zarch");
    public static final Opcode OP_PGIN = new Opcode(DatatypeConverter.parseHexBinary("b22e"),"PGIN",OpcodeType.RRE_RR,"page in","g5","esa,zarch");
    public static final Opcode OP_PGOUT = new Opcode(DatatypeConverter.parseHexBinary("b22f"),"PGOUT",OpcodeType.RRE_RR,"page out","g5","esa,zarch");
    public static final Opcode OP_XSCH = new Opcode(DatatypeConverter.parseHexBinary("b276"),"XSCH",OpcodeType.S_00,"cancel subchannel","g5","esa,zarch");
    public static final Opcode OP_AY = new Opcode(DatatypeConverter.parseHexBinary("e3000000005a"),"AY",OpcodeType.RXY_RRRD,"add with long offset","z990","zarch");
    public static final Opcode OP_AHY = new Opcode(DatatypeConverter.parseHexBinary("e3000000007a"),"AHY",OpcodeType.RXY_RRRD,"add halfword with long offset","z990","zarch");
    public static final Opcode OP_ALY = new Opcode(DatatypeConverter.parseHexBinary("e3000000005e"),"ALY",OpcodeType.RXY_RRRD,"add logical with long offset","z990","zarch");
    public static final Opcode OP_NIY = new Opcode(DatatypeConverter.parseHexBinary("eb0000000054"),"NIY",OpcodeType.SIY_URD,"and immediate with long offset","z990","zarch");
    public static final Opcode OP_NY = new Opcode(DatatypeConverter.parseHexBinary("e30000000054"),"NY",OpcodeType.RXY_RRRD,"and with long offset","z990","zarch");
    public static final Opcode OP_CY = new Opcode(DatatypeConverter.parseHexBinary("e30000000059"),"CY",OpcodeType.RXY_RRRD,"compare with long offset","z990","zarch");
    public static final Opcode OP_CSY = new Opcode(DatatypeConverter.parseHexBinary("eb0000000014"),"CSY",OpcodeType.RSY_RRRD,"compare and swap with long offset","z990","zarch");
    public static final Opcode OP_CDSY = new Opcode(DatatypeConverter.parseHexBinary("eb0000000031"),"CDSY",OpcodeType.RSY_RERERD,"compare double and swap with long offset","z990","zarch");
    public static final Opcode OP_CHY = new Opcode(DatatypeConverter.parseHexBinary("e30000000079"),"CHY",OpcodeType.RXY_RRRD,"compare halfword with long offset","z990","zarch");
    public static final Opcode OP_CLY = new Opcode(DatatypeConverter.parseHexBinary("e30000000055"),"CLY",OpcodeType.RXY_RRRD,"compare logical with long offset","z990","zarch");
    public static final Opcode OP_CLIY = new Opcode(DatatypeConverter.parseHexBinary("eb0000000055"),"CLIY",OpcodeType.SIY_URD,"compare logical immediate with long offset","z990","zarch");
    public static final Opcode OP_CLMY = new Opcode(DatatypeConverter.parseHexBinary("eb0000000021"),"CLMY",OpcodeType.RSY_RURD,"compare logical characters under mask with long offset","z990","zarch");
    public static final Opcode OP_CVBY = new Opcode(DatatypeConverter.parseHexBinary("e30000000006"),"CVBY",OpcodeType.RXY_RRRD,"convert to binary with long offset","z990","zarch");
    public static final Opcode OP_CVDY = new Opcode(DatatypeConverter.parseHexBinary("e30000000026"),"CVDY",OpcodeType.RXY_RRRD,"convert to decimal with long offset","z990","zarch");
    public static final Opcode OP_XIY = new Opcode(DatatypeConverter.parseHexBinary("eb0000000057"),"XIY",OpcodeType.SIY_URD,"exclusive or immediate with long offset","z990","zarch");
    public static final Opcode OP_XY = new Opcode(DatatypeConverter.parseHexBinary("e30000000057"),"XY",OpcodeType.RXY_RRRD,"exclusive or with long offset","z990","zarch");
    public static final Opcode OP_ICY = new Opcode(DatatypeConverter.parseHexBinary("e30000000073"),"ICY",OpcodeType.RXY_RRRD,"insert character with long offset","z990","zarch");
    public static final Opcode OP_ICMY = new Opcode(DatatypeConverter.parseHexBinary("eb0000000081"),"ICMY",OpcodeType.RSY_RURD,"insert characters with long offset","z990","zarch");
    public static final Opcode OP_LDY = new Opcode(DatatypeConverter.parseHexBinary("ed0000000065"),"LDY",OpcodeType.RXY_FRRD,"load (long) with long offset","z990","zarch");
    public static final Opcode OP_LEY = new Opcode(DatatypeConverter.parseHexBinary("ed0000000064"),"LEY",OpcodeType.RXY_FRRD,"load (short) with long offset","z990","zarch");
    public static final Opcode OP_LY = new Opcode(DatatypeConverter.parseHexBinary("e30000000058"),"LY",OpcodeType.RXY_RRRD,"load with long offset","z990","zarch");
    public static final Opcode OP_LAMY = new Opcode(DatatypeConverter.parseHexBinary("eb000000009a"),"LAMY",OpcodeType.RSY_AARD,"load access multiple","z990","zarch");
    public static final Opcode OP_LAY = new Opcode(DatatypeConverter.parseHexBinary("e30000000071"),"LAY",OpcodeType.RXY_RRRD,"load address with long offset","z990","zarch");
    public static final Opcode OP_LB = new Opcode(DatatypeConverter.parseHexBinary("e30000000076"),"LB",OpcodeType.RXY_RRRD,"load byte with long offset","z990","zarch");
    public static final Opcode OP_LGB = new Opcode(DatatypeConverter.parseHexBinary("e30000000077"),"LGB",OpcodeType.RXY_RRRD,"load byte with long offset 64","z990","zarch");
    public static final Opcode OP_LHY = new Opcode(DatatypeConverter.parseHexBinary("e30000000078"),"LHY",OpcodeType.RXY_RRRD,"load halfword with long offset","z990","zarch");
    public static final Opcode OP_LMY = new Opcode(DatatypeConverter.parseHexBinary("eb0000000098"),"LMY",OpcodeType.RSY_RRRD,"load multiple with long offset","z990","zarch");
    public static final Opcode OP_LRAY = new Opcode(DatatypeConverter.parseHexBinary("e30000000013"),"LRAY",OpcodeType.RXY_RRRD,"load real address with long offset","z990","zarch");
    public static final Opcode OP_MVIY = new Opcode(DatatypeConverter.parseHexBinary("eb0000000052"),"MVIY",OpcodeType.SIY_URD,"move immediate with long offset","z990","zarch");
    public static final Opcode OP_MSY = new Opcode(DatatypeConverter.parseHexBinary("e30000000051"),"MSY",OpcodeType.RXY_RRRD,"multiply single with long offset","z990","zarch");
    public static final Opcode OP_OIY = new Opcode(DatatypeConverter.parseHexBinary("eb0000000056"),"OIY",OpcodeType.SIY_URD,"or immediate with long offset","z990","zarch");
    public static final Opcode OP_OY = new Opcode(DatatypeConverter.parseHexBinary("e30000000056"),"OY",OpcodeType.RXY_RRRD,"or with long offset","z990","zarch");
    public static final Opcode OP_STDY = new Opcode(DatatypeConverter.parseHexBinary("ed0000000067"),"STDY",OpcodeType.RXY_FRRD,"store (long) with long offset","z990","zarch");
    public static final Opcode OP_STEY = new Opcode(DatatypeConverter.parseHexBinary("ed0000000066"),"STEY",OpcodeType.RXY_FRRD,"store (short) with long offset","z990","zarch");
    public static final Opcode OP_STY = new Opcode(DatatypeConverter.parseHexBinary("e30000000050"),"STY",OpcodeType.RXY_RRRD,"store with long offset","z990","zarch");
    public static final Opcode OP_STAMY = new Opcode(DatatypeConverter.parseHexBinary("eb000000009b"),"STAMY",OpcodeType.RSY_AARD,"store access multiple with long offset","z990","zarch");
    public static final Opcode OP_STCY = new Opcode(DatatypeConverter.parseHexBinary("e30000000072"),"STCY",OpcodeType.RXY_RRRD,"store character with long offset","z990","zarch");
    public static final Opcode OP_STCMY = new Opcode(DatatypeConverter.parseHexBinary("eb000000002d"),"STCMY",OpcodeType.RSY_RURD,"store characters under mask with long offset","z990","zarch");
    public static final Opcode OP_STHY = new Opcode(DatatypeConverter.parseHexBinary("e30000000070"),"STHY",OpcodeType.RXY_RRRD,"store halfword with long offset","z990","zarch");
    public static final Opcode OP_STMY = new Opcode(DatatypeConverter.parseHexBinary("eb0000000090"),"STMY",OpcodeType.RSY_RRRD,"store multiple with long offset","z990","zarch");
    public static final Opcode OP_SY = new Opcode(DatatypeConverter.parseHexBinary("e3000000005b"),"SY",OpcodeType.RXY_RRRD,"subtract with long offset","z990","zarch");
    public static final Opcode OP_SHY = new Opcode(DatatypeConverter.parseHexBinary("e3000000007b"),"SHY",OpcodeType.RXY_RRRD,"subtract halfword with long offset","z990","zarch");
    public static final Opcode OP_SLY = new Opcode(DatatypeConverter.parseHexBinary("e3000000005f"),"SLY",OpcodeType.RXY_RRRD,"subtract logical with long offset","z990","zarch");
    public static final Opcode OP_TMY = new Opcode(DatatypeConverter.parseHexBinary("eb0000000051"),"TMY",OpcodeType.SIY_URD,"test under mask with long offset","z990","zarch");
    public static final Opcode OP_CLCLU = new Opcode(DatatypeConverter.parseHexBinary("eb000000008f"),"CLCLU",OpcodeType.RSY_RRRD,"compare logical long unicode with long offset","z990","esa,zarch");
    public static final Opcode OP_CSPG = new Opcode(DatatypeConverter.parseHexBinary("b98a"),"CSPG",OpcodeType.RRE_RR,"compare and swap and purge","z990","zarch");
    public static final Opcode OP_IDTE = new Opcode(DatatypeConverter.parseHexBinary("b98e"),"IDTE",OpcodeType.RRF_R0RR,"invalidate dat table entry","z990","zarch");
    public static final Opcode OP_MADR = new Opcode(DatatypeConverter.parseHexBinary("b33e"),"MADR",OpcodeType.RRF_F0FF,"multiply and add long hfp","z990","esa,zarch");
    public static final Opcode OP_MAD = new Opcode(DatatypeConverter.parseHexBinary("ed000000003e"),"MAD",OpcodeType.RXF_FRRDF,"multiply and add long hfp","z990","esa,zarch");
    public static final Opcode OP_MAER = new Opcode(DatatypeConverter.parseHexBinary("b32e"),"MAER",OpcodeType.RRF_F0FF,"multiply and add short hfp","z990","esa,zarch");
    public static final Opcode OP_MAE = new Opcode(DatatypeConverter.parseHexBinary("ed000000002e"),"MAE",OpcodeType.RXF_FRRDF,"multiply and add short hfp","z990","esa,zarch");
    public static final Opcode OP_MSDR = new Opcode(DatatypeConverter.parseHexBinary("b33f"),"MSDR",OpcodeType.RRF_F0FF,"multiply and subtract long hfp","z990","esa,zarch");
    public static final Opcode OP_MSD = new Opcode(DatatypeConverter.parseHexBinary("ed000000003f"),"MSD",OpcodeType.RXF_FRRDF,"multiply and subtract long hfp","z990","esa,zarch");
    public static final Opcode OP_MSER = new Opcode(DatatypeConverter.parseHexBinary("b32f"),"MSER",OpcodeType.RRF_F0FF,"mutliply and subtract short hfp","z990","esa,zarch");
    public static final Opcode OP_MSE = new Opcode(DatatypeConverter.parseHexBinary("ed000000002f"),"MSE",OpcodeType.RXF_FRRDF,"multiply and subttract short hfp","z990","esa,zarch");
    public static final Opcode OP_KM = new Opcode(DatatypeConverter.parseHexBinary("b92e"),"KM",OpcodeType.RRE_RR,"cipher message","z990","esa,zarch");
    public static final Opcode OP_KMC = new Opcode(DatatypeConverter.parseHexBinary("b92f"),"KMC",OpcodeType.RRE_RR,"cipher message with chaining","z990","esa,zarch");
    public static final Opcode OP_KIMD = new Opcode(DatatypeConverter.parseHexBinary("b93e"),"KIMD",OpcodeType.RRE_RR,"compute intermediate message digest","z990","esa,zarch");
    public static final Opcode OP_KLMD = new Opcode(DatatypeConverter.parseHexBinary("b93f"),"KLMD",OpcodeType.RRE_RR,"compute last message digest","z990","esa,zarch");
    public static final Opcode OP_KMAC = new Opcode(DatatypeConverter.parseHexBinary("b91e"),"KMAC",OpcodeType.RRE_RR,"compute message authentication code","z990","esa,zarch");
    public static final Opcode OP_EPAIR = new Opcode(DatatypeConverter.parseHexBinary("b99a"),"EPAIR",OpcodeType.RRE_R0,"extract primary ASN and instance","z990","esa,zarch");
    public static final Opcode OP_ESAIR = new Opcode(DatatypeConverter.parseHexBinary("b99b"),"ESAIR",OpcodeType.RRE_R0,"extract secondary ASN and instance","z990","esa,zarch");
    public static final Opcode OP_PTI = new Opcode(DatatypeConverter.parseHexBinary("b99e"),"PTI",OpcodeType.RRE_RR,"program transfer with instance","z990","esa,zarch");
    public static final Opcode OP_SSAIR = new Opcode(DatatypeConverter.parseHexBinary("b99f"),"SSAIR",OpcodeType.RRE_R0,"set secondary ASN with instance","z990","esa,zarch");
    public static final Opcode OP_AFI = new Opcode(DatatypeConverter.parseHexBinary("c209"),"AFI",OpcodeType.RIL_RI,"add immediate 32","z9-109","zarch");
    public static final Opcode OP_AGFI = new Opcode(DatatypeConverter.parseHexBinary("c208"),"AGFI",OpcodeType.RIL_RI,"add immediate 64<32","z9-109","zarch");
    public static final Opcode OP_ALFI = new Opcode(DatatypeConverter.parseHexBinary("c20b"),"ALFI",OpcodeType.RIL_RU,"add logical immediate 32","z9-109","zarch");
    public static final Opcode OP_ALGFI = new Opcode(DatatypeConverter.parseHexBinary("c20a"),"ALGFI",OpcodeType.RIL_RU,"add logical immediate 64<32","z9-109","zarch");
    public static final Opcode OP_NIHF = new Opcode(DatatypeConverter.parseHexBinary("c00a"),"NIHF",OpcodeType.RIL_RU,"and immediate high","z9-109","zarch");
    public static final Opcode OP_NILF = new Opcode(DatatypeConverter.parseHexBinary("c00b"),"NILF",OpcodeType.RIL_RU,"and immediate low","z9-109","zarch");
    public static final Opcode OP_CFI = new Opcode(DatatypeConverter.parseHexBinary("c20d"),"CFI",OpcodeType.RIL_RI,"compare immediate 32","z9-109","zarch");
    public static final Opcode OP_CGFI = new Opcode(DatatypeConverter.parseHexBinary("c20c"),"CGFI",OpcodeType.RIL_RI,"compare immediate 64<32","z9-109","zarch");
    public static final Opcode OP_CLFI = new Opcode(DatatypeConverter.parseHexBinary("c20f"),"CLFI",OpcodeType.RIL_RU,"compare logical immediate 32","z9-109","zarch");
    public static final Opcode OP_CLGFI = new Opcode(DatatypeConverter.parseHexBinary("c20e"),"CLGFI",OpcodeType.RIL_RU,"compare logical immediate 64<32","z9-109","zarch");
    public static final Opcode OP_XIHF = new Opcode(DatatypeConverter.parseHexBinary("c006"),"XIHF",OpcodeType.RIL_RU,"exclusive or immediate high","z9-109","zarch");
    public static final Opcode OP_XILF = new Opcode(DatatypeConverter.parseHexBinary("c007"),"XILF",OpcodeType.RIL_RU,"exclusive or immediate low","z9-109","zarch");
    public static final Opcode OP_IIHF = new Opcode(DatatypeConverter.parseHexBinary("c008"),"IIHF",OpcodeType.RIL_RU,"insert immediate high","z9-109","zarch");
    public static final Opcode OP_IILF = new Opcode(DatatypeConverter.parseHexBinary("c009"),"IILF",OpcodeType.RIL_RU,"insert immediate low","z9-109","zarch");
    public static final Opcode OP_FLOGR = new Opcode(DatatypeConverter.parseHexBinary("b983"),"FLOGR",OpcodeType.RRE_RER,"find leftmost one","z9-109","zarch");
    public static final Opcode OP_LT = new Opcode(DatatypeConverter.parseHexBinary("e30000000012"),"LT",OpcodeType.RXY_RRRD,"load and test 32","z9-109","zarch");
    public static final Opcode OP_LTG = new Opcode(DatatypeConverter.parseHexBinary("e30000000002"),"LTG",OpcodeType.RXY_RRRD,"load and test 64","z9-109","zarch");
    public static final Opcode OP_LBR = new Opcode(DatatypeConverter.parseHexBinary("b926"),"LBR",OpcodeType.RRE_RR,"load byte 32","z9-109","zarch");
    public static final Opcode OP_LGBR = new Opcode(DatatypeConverter.parseHexBinary("b906"),"LGBR",OpcodeType.RRE_RR,"load byte 64","z9-109","zarch");
    public static final Opcode OP_LHR = new Opcode(DatatypeConverter.parseHexBinary("b927"),"LHR",OpcodeType.RRE_RR,"load halfword 32","z9-109","zarch");
    public static final Opcode OP_LGHR = new Opcode(DatatypeConverter.parseHexBinary("b907"),"LGHR",OpcodeType.RRE_RR,"load halfword 64","z9-109","zarch");
    public static final Opcode OP_LGFI = new Opcode(DatatypeConverter.parseHexBinary("c001"),"LGFI",OpcodeType.RIL_RI,"load immediate 64<32","z9-109","zarch");
    public static final Opcode OP_LLC = new Opcode(DatatypeConverter.parseHexBinary("e30000000094"),"LLC",OpcodeType.RXY_RRRD,"load logical character 32","z9-109","zarch");
    public static final Opcode OP_LLCR = new Opcode(DatatypeConverter.parseHexBinary("b994"),"LLCR",OpcodeType.RRE_RR,"load logical character 32","z9-109","zarch");
    public static final Opcode OP_LLGCR = new Opcode(DatatypeConverter.parseHexBinary("b984"),"LLGCR",OpcodeType.RRE_RR,"load logical character 64","z9-109","zarch");
    public static final Opcode OP_LLH = new Opcode(DatatypeConverter.parseHexBinary("e30000000095"),"LLH",OpcodeType.RXY_RRRD,"load logical halfword 32","z9-109","zarch");
    public static final Opcode OP_LLHR = new Opcode(DatatypeConverter.parseHexBinary("b995"),"LLHR",OpcodeType.RRE_RR,"load logical halfword 32","z9-109","zarch");
    public static final Opcode OP_LLGHR = new Opcode(DatatypeConverter.parseHexBinary("b985"),"LLGHR",OpcodeType.RRE_RR,"load logical halfword 64","z9-109","zarch");
    public static final Opcode OP_LLIHF = new Opcode(DatatypeConverter.parseHexBinary("c00e"),"LLIHF",OpcodeType.RIL_RU,"load logical immediate high","z9-109","zarch");
    public static final Opcode OP_LLILF = new Opcode(DatatypeConverter.parseHexBinary("c00f"),"LLILF",OpcodeType.RIL_RU,"load logical immediate low","z9-109","zarch");
    public static final Opcode OP_OIHF = new Opcode(DatatypeConverter.parseHexBinary("c00c"),"OIHF",OpcodeType.RIL_RU,"or immediate high","z9-109","zarch");
    public static final Opcode OP_OILF = new Opcode(DatatypeConverter.parseHexBinary("c00d"),"OILF",OpcodeType.RIL_RU,"or immediate low","z9-109","zarch");
    public static final Opcode OP_SLFI = new Opcode(DatatypeConverter.parseHexBinary("c205"),"SLFI",OpcodeType.RIL_RU,"subtract logical immediate 32","z9-109","zarch");
    public static final Opcode OP_SLGFI = new Opcode(DatatypeConverter.parseHexBinary("c204"),"SLGFI",OpcodeType.RIL_RU,"subtract logical immediate 64<32","z9-109","zarch");
    public static final Opcode OP_PTFF = new Opcode(DatatypeConverter.parseHexBinary("0104"),"PTFF",OpcodeType.E,"perform timing facility function","z9-109","zarch");
    public static final Opcode OP_STFLE = new Opcode(DatatypeConverter.parseHexBinary("b2b0"),"STFLE",OpcodeType.S_RD,"store facility list extended","z9-109","zarch");
    public static final Opcode OP_STCKF = new Opcode(DatatypeConverter.parseHexBinary("b27c"),"STCKF",OpcodeType.S_RD,"store clock fast","z9-109","zarch");
    public static final Opcode OP_MVCOS = new Opcode(DatatypeConverter.parseHexBinary("c800"),"MVCOS",OpcodeType.SSF_RRDRD,"move with optional specifications","z9-109","zarch");
    public static final Opcode OP_LPTEA = new Opcode(DatatypeConverter.parseHexBinary("b9aa"),"LPTEA",OpcodeType.RRF_RURR2,"load page-table-entry address","z9-109","zarch");
    public static final Opcode OP_CU24 = new Opcode(DatatypeConverter.parseHexBinary("b9b1"),"CU24",OpcodeType.RRF_U0RERE,"convert utf-16 to utf-32","z9-109","zarch");
    public static final Opcode OP_CU21 = new Opcode(DatatypeConverter.parseHexBinary("b2a6"),"CU21",OpcodeType.RRF_U0RERE,"convert utf-16 to utf-8","z9-109","zarch");
    public static final Opcode OP_CU42 = new Opcode(DatatypeConverter.parseHexBinary("b9b3"),"CU42",OpcodeType.RRE_RERE,"convert utf-32 to utf-16","z9-109","zarch");
    public static final Opcode OP_CU41 = new Opcode(DatatypeConverter.parseHexBinary("b9b2"),"CU41",OpcodeType.RRE_RERE,"convert utf-32 to utf-8","z9-109","zarch");
    public static final Opcode OP_CU12 = new Opcode(DatatypeConverter.parseHexBinary("b2a7"),"CU12",OpcodeType.RRF_U0RERE,"convert utf-8 to utf-16","z9-109","zarch");
    public static final Opcode OP_CU14 = new Opcode(DatatypeConverter.parseHexBinary("b9b0"),"CU14",OpcodeType.RRF_U0RERE,"convert utf-8 to utf-32","z9-109","zarch");
    public static final Opcode OP_SRSTU = new Opcode(DatatypeConverter.parseHexBinary("b9be"),"SRSTU",OpcodeType.RRE_RR,"search string unicode","z9-109","zarch");
    public static final Opcode OP_TRTR = new Opcode(DatatypeConverter.parseHexBinary("d0"),"TRTR",OpcodeType.SS_L0RDRD,"tranlate and test reverse","z9-109","zarch");
    public static final Opcode OP_MYR = new Opcode(DatatypeConverter.parseHexBinary("b33b"),"MYR",OpcodeType.RRF_FE0FF,"multiply unnormalized long hfp","z9-109","zarch");
    public static final Opcode OP_MYHR = new Opcode(DatatypeConverter.parseHexBinary("b33d"),"MYHR",OpcodeType.RRF_F0FF,"multiply unnormalized long hfp high","z9-109","zarch");
    public static final Opcode OP_MYLR = new Opcode(DatatypeConverter.parseHexBinary("b339"),"MYLR",OpcodeType.RRF_F0FF,"multiply unnormalized long hfp low","z9-109","zarch");
    public static final Opcode OP_MY = new Opcode(DatatypeConverter.parseHexBinary("ed000000003b"),"MY",OpcodeType.RXF_FRRDFE,"multiply unnormalized long hfp","z9-109","zarch");
    public static final Opcode OP_MYH = new Opcode(DatatypeConverter.parseHexBinary("ed000000003d"),"MYH",OpcodeType.RXF_FRRDF,"multiply unnormalized long hfp high","z9-109","zarch");
    public static final Opcode OP_MYL = new Opcode(DatatypeConverter.parseHexBinary("ed0000000039"),"MYL",OpcodeType.RXF_FRRDF,"multiply unnormalized long hfp low","z9-109","zarch");
    public static final Opcode OP_MAYR = new Opcode(DatatypeConverter.parseHexBinary("b33a"),"MAYR",OpcodeType.RRF_F0FF,"multiply and add unnormalized long hfp","z9-109","zarch");
    public static final Opcode OP_MAYHR = new Opcode(DatatypeConverter.parseHexBinary("b33c"),"MAYHR",OpcodeType.RRF_F0FF,"multiply and add unnormalized long hfp high","z9-109","zarch");
    public static final Opcode OP_MAYLR = new Opcode(DatatypeConverter.parseHexBinary("b338"),"MAYLR",OpcodeType.RRF_F0FF,"multiply and add unnormalized long hfp low","z9-109","zarch");
    public static final Opcode OP_MAY = new Opcode(DatatypeConverter.parseHexBinary("ed000000003a"),"MAY",OpcodeType.RXF_FRRDF,"multiply and add unnormalized long hfp","z9-109","zarch");
    public static final Opcode OP_MAYH = new Opcode(DatatypeConverter.parseHexBinary("ed000000003c"),"MAYH",OpcodeType.RXF_FRRDF,"multiply and add unnormalized long hfp high","z9-109","zarch");
    public static final Opcode OP_MAYL = new Opcode(DatatypeConverter.parseHexBinary("ed0000000038"),"MAYL",OpcodeType.RXF_FRRDF,"multiply and add unnormalized long hfp low","z9-109","zarch");
    public static final Opcode OP_LPDFR = new Opcode(DatatypeConverter.parseHexBinary("b370"),"LPDFR",OpcodeType.RRE_FF,"load positive no cc","z9-ec","zarch");
    public static final Opcode OP_LNDFR = new Opcode(DatatypeConverter.parseHexBinary("b371"),"LNDFR",OpcodeType.RRE_FF,"load negative no cc","z9-ec","zarch");
    public static final Opcode OP_CPSDR = new Opcode(DatatypeConverter.parseHexBinary("b372"),"CPSDR",OpcodeType.RRF_F0FF2,"copy sign","z9-ec","zarch");
    public static final Opcode OP_LCDFR = new Opcode(DatatypeConverter.parseHexBinary("b373"),"LCDFR",OpcodeType.RRE_FF,"load complement no cc","z9-ec","zarch");
    public static final Opcode OP_LDGR = new Opcode(DatatypeConverter.parseHexBinary("b3c1"),"LDGR",OpcodeType.RRE_FR,"load fpr from gr","z9-ec","zarch");
    public static final Opcode OP_LGDR = new Opcode(DatatypeConverter.parseHexBinary("b3cd"),"LGDR",OpcodeType.RRE_RF,"load gr from fpr","z9-ec","zarch");
    public static final Opcode OP_ADTR = new Opcode(DatatypeConverter.parseHexBinary("b3d2"),"ADTR",OpcodeType.RRR_F0FF,"add long dfp","z9-ec","zarch");
    public static final Opcode OP_AXTR = new Opcode(DatatypeConverter.parseHexBinary("b3da"),"AXTR",OpcodeType.RRR_FE0FEFE,"add extended dfp","z9-ec","zarch");
    public static final Opcode OP_CDTR = new Opcode(DatatypeConverter.parseHexBinary("b3e4"),"CDTR",OpcodeType.RRE_FF,"compare long dfp","z9-ec","zarch");
    public static final Opcode OP_CXTR = new Opcode(DatatypeConverter.parseHexBinary("b3ec"),"CXTR",OpcodeType.RRE_FEFE,"compare extended dfp","z9-ec","zarch");
    public static final Opcode OP_KDTR = new Opcode(DatatypeConverter.parseHexBinary("b3e0"),"KDTR",OpcodeType.RRE_FF,"compare and signal long dfp","z9-ec","zarch");
    public static final Opcode OP_KXTR = new Opcode(DatatypeConverter.parseHexBinary("b3e8"),"KXTR",OpcodeType.RRE_FF,"compare and signal extended dfp","z9-ec","zarch");
    public static final Opcode OP_CEDTR = new Opcode(DatatypeConverter.parseHexBinary("b3f4"),"CEDTR",OpcodeType.RRE_FF,"compare exponent long dfp","z9-ec","zarch");
    public static final Opcode OP_CEXTR = new Opcode(DatatypeConverter.parseHexBinary("b3fc"),"CEXTR",OpcodeType.RRE_FEFE,"compare exponent extended dfp","z9-ec","zarch");
    public static final Opcode OP_CDGTR = new Opcode(DatatypeConverter.parseHexBinary("b3f1"),"CDGTR",OpcodeType.RRE_FR,"convert from fixed long dfp","z9-ec","zarch");
    public static final Opcode OP_CXGTR = new Opcode(DatatypeConverter.parseHexBinary("b3f9"),"CXGTR",OpcodeType.RRE_FER,"convert from fixed extended dfp","z9-ec","zarch");
    public static final Opcode OP_CDSTR = new Opcode(DatatypeConverter.parseHexBinary("b3f3"),"CDSTR",OpcodeType.RRE_FR,"convert from signed bcd long dfp","z9-ec","zarch");
    public static final Opcode OP_CXSTR = new Opcode(DatatypeConverter.parseHexBinary("b3fb"),"CXSTR",OpcodeType.RRE_FR,"convert from signed bcd extended dfp","z9-ec","zarch");
    public static final Opcode OP_CDUTR = new Opcode(DatatypeConverter.parseHexBinary("b3f2"),"CDUTR",OpcodeType.RRE_FR,"convert from unsigned bcd to long dfp","z9-ec","zarch");
    public static final Opcode OP_CXUTR = new Opcode(DatatypeConverter.parseHexBinary("b3fa"),"CXUTR",OpcodeType.RRE_FER,"convert from unsigned bcd to extended dfp","z9-ec","zarch");
    public static final Opcode OP_CGDTR = new Opcode(DatatypeConverter.parseHexBinary("b3e1"),"CGDTR",OpcodeType.RRF_U0RF,"convert from long dfp to fixed","z9-ec","zarch");
    public static final Opcode OP_CGXTR = new Opcode(DatatypeConverter.parseHexBinary("b3e9"),"CGXTR",OpcodeType.RRF_U0RFE,"convert from extended dfp to fixed","z9-ec","zarch");
    public static final Opcode OP_CSDTR = new Opcode(DatatypeConverter.parseHexBinary("b3e3"),"CSDTR",OpcodeType.RRE_RF,"convert from long dfp to signed bcd","z9-ec","zarch");
    public static final Opcode OP_CSXTR = new Opcode(DatatypeConverter.parseHexBinary("b3eb"),"CSXTR",OpcodeType.RRE_RFE,"convert from extended dfp to signed bcd","z9-ec","zarch");
    public static final Opcode OP_CUDTR = new Opcode(DatatypeConverter.parseHexBinary("b3e2"),"CUDTR",OpcodeType.RRE_RF,"convert from long dfp to unsigned bcd","z9-ec","zarch");
    public static final Opcode OP_CUXTR = new Opcode(DatatypeConverter.parseHexBinary("b3ea"),"CUXTR",OpcodeType.RRE_RFE,"convert from extended dfp to unsigned bcd","z9-ec","zarch");
    public static final Opcode OP_DDTR = new Opcode(DatatypeConverter.parseHexBinary("b3d1"),"DDTR",OpcodeType.RRR_F0FF,"divide long dfp","z9-ec","zarch");
    public static final Opcode OP_DXTR = new Opcode(DatatypeConverter.parseHexBinary("b3d9"),"DXTR",OpcodeType.RRR_FE0FEFE,"divide extended dfp","z9-ec","zarch");
    public static final Opcode OP_EEDTR = new Opcode(DatatypeConverter.parseHexBinary("b3e5"),"EEDTR",OpcodeType.RRE_RF,"extract biased exponent from long dfp","z9-ec","zarch");
    public static final Opcode OP_EEXTR = new Opcode(DatatypeConverter.parseHexBinary("b3ed"),"EEXTR",OpcodeType.RRE_RFE,"extract biased exponent from extended dfp","z9-ec","zarch");
    public static final Opcode OP_ESDTR = new Opcode(DatatypeConverter.parseHexBinary("b3e7"),"ESDTR",OpcodeType.RRE_RF,"extract significance from long dfp","z9-ec","zarch");
    public static final Opcode OP_ESXTR = new Opcode(DatatypeConverter.parseHexBinary("b3ef"),"ESXTR",OpcodeType.RRE_RFE,"extract significance from extended dfp","z9-ec","zarch");
    public static final Opcode OP_IEDTR = new Opcode(DatatypeConverter.parseHexBinary("b3f6"),"IEDTR",OpcodeType.RRF_F0FR,"insert biased exponent long dfp","z9-ec","zarch");
    public static final Opcode OP_IEXTR = new Opcode(DatatypeConverter.parseHexBinary("b3fe"),"IEXTR",OpcodeType.RRF_FE0FER,"insert biased exponent extended dfp","z9-ec","zarch");
    public static final Opcode OP_LTDTR = new Opcode(DatatypeConverter.parseHexBinary("b3d6"),"LTDTR",OpcodeType.RRE_FF,"load and test long dfp","z9-ec","zarch");
    public static final Opcode OP_LTXTR = new Opcode(DatatypeConverter.parseHexBinary("b3de"),"LTXTR",OpcodeType.RRE_FEFE,"load and test extended dfp","z9-ec","zarch");
    public static final Opcode OP_FIDTR = new Opcode(DatatypeConverter.parseHexBinary("b3d7"),"FIDTR",OpcodeType.RRF_UUFF,"load fp integer long dfp","z9-ec","zarch");
    public static final Opcode OP_FIXTR = new Opcode(DatatypeConverter.parseHexBinary("b3df"),"FIXTR",OpcodeType.RRF_UUFEFE,"load fp integer extended dfp","z9-ec","zarch");
    public static final Opcode OP_LFAS = new Opcode(DatatypeConverter.parseHexBinary("b2bd"),"LFAS",OpcodeType.S_RD,"load fpd and signal","z9-ec","zarch");
    public static final Opcode OP_LDETR = new Opcode(DatatypeConverter.parseHexBinary("b3d4"),"LDETR",OpcodeType.RRF_0UFF,"load lengthened long dfp","z9-ec","zarch");
    public static final Opcode OP_LXDTR = new Opcode(DatatypeConverter.parseHexBinary("b3dc"),"LXDTR",OpcodeType.RRF_0UFEF,"load lengthened extended dfp","z9-ec","zarch");
    public static final Opcode OP_LEDTR = new Opcode(DatatypeConverter.parseHexBinary("b3d5"),"LEDTR",OpcodeType.RRF_UUFF,"load rounded long dfp","z9-ec","zarch");
    public static final Opcode OP_LDXTR = new Opcode(DatatypeConverter.parseHexBinary("b3dd"),"LDXTR",OpcodeType.RRF_UUFFE,"load rounded extended dfp","z9-ec","zarch");
    public static final Opcode OP_MDTR = new Opcode(DatatypeConverter.parseHexBinary("b3d0"),"MDTR",OpcodeType.RRR_F0FF,"multiply long dfp","z9-ec","zarch");
    public static final Opcode OP_MXTR = new Opcode(DatatypeConverter.parseHexBinary("b3d8"),"MXTR",OpcodeType.RRR_FE0FEFE,"multiply extended dfp","z9-ec","zarch");
    public static final Opcode OP_QADTR = new Opcode(DatatypeConverter.parseHexBinary("b3f5"),"QADTR",OpcodeType.RRF_FUFF,"Quantize long dfp","z9-ec","zarch");
    public static final Opcode OP_QAXTR = new Opcode(DatatypeConverter.parseHexBinary("b3fd"),"QAXTR",OpcodeType.RRF_FEUFEFE,"Quantize extended dfp","z9-ec","zarch");
    public static final Opcode OP_RRDTR = new Opcode(DatatypeConverter.parseHexBinary("b3f7"),"RRDTR",OpcodeType.RRF_FFRU,"Reround long dfp","z9-ec","zarch");
    public static final Opcode OP_RRXTR = new Opcode(DatatypeConverter.parseHexBinary("b3ff"),"RRXTR",OpcodeType.RRF_FEFERU,"Reround extended dfp","z9-ec","zarch");
    public static final Opcode OP_SRNMT = new Opcode(DatatypeConverter.parseHexBinary("b2b9"),"SRNMT",OpcodeType.S_RD,"set rounding mode dfp","z9-ec","zarch");
    public static final Opcode OP_SFASR = new Opcode(DatatypeConverter.parseHexBinary("b385"),"SFASR",OpcodeType.RRE_R0,"set fpc and signal","z9-ec","zarch");
    public static final Opcode OP_SLDT = new Opcode(DatatypeConverter.parseHexBinary("ed0000000040"),"SLDT",OpcodeType.RXF_FRRDF,"shift coefficient left long dfp","z9-ec","zarch");
    public static final Opcode OP_SLXT = new Opcode(DatatypeConverter.parseHexBinary("ed0000000048"),"SLXT",OpcodeType.RXF_FERRDFE,"shift coefficient left extended dfp","z9-ec","zarch");
    public static final Opcode OP_SRDT = new Opcode(DatatypeConverter.parseHexBinary("ed0000000041"),"SRDT",OpcodeType.RXF_FRRDF,"shift coefficient right long dfp","z9-ec","zarch");
    public static final Opcode OP_SRXT = new Opcode(DatatypeConverter.parseHexBinary("ed0000000049"),"SRXT",OpcodeType.RXF_FERRDFE,"shift coefficient right extended dfp","z9-ec","zarch");
    public static final Opcode OP_SDTR = new Opcode(DatatypeConverter.parseHexBinary("b3d3"),"SDTR",OpcodeType.RRR_F0FF,"subtract long dfp","z9-ec","zarch");
    public static final Opcode OP_SXTR = new Opcode(DatatypeConverter.parseHexBinary("b3db"),"SXTR",OpcodeType.RRR_FE0FEFE,"subtract extended dfp","z9-ec","zarch");
    public static final Opcode OP_TDCET = new Opcode(DatatypeConverter.parseHexBinary("ed0000000050"),"TDCET",OpcodeType.RXE_FRRD,"test data class short dfp","z9-ec","zarch");
    public static final Opcode OP_TDCDT = new Opcode(DatatypeConverter.parseHexBinary("ed0000000054"),"TDCDT",OpcodeType.RXE_FRRD,"test data class long dfp","z9-ec","zarch");
    public static final Opcode OP_TDCXT = new Opcode(DatatypeConverter.parseHexBinary("ed0000000058"),"TDCXT",OpcodeType.RXE_FERRD,"test data class extended dfp","z9-ec","zarch");
    public static final Opcode OP_TDGET = new Opcode(DatatypeConverter.parseHexBinary("ed0000000051"),"TDGET",OpcodeType.RXE_FRRD,"test data group short dfp","z9-ec","zarch");
    public static final Opcode OP_TDGDT = new Opcode(DatatypeConverter.parseHexBinary("ed0000000055"),"TDGDT",OpcodeType.RXE_FRRD,"test data group long dfp","z9-ec","zarch");
    public static final Opcode OP_TDGXT = new Opcode(DatatypeConverter.parseHexBinary("ed0000000059"),"TDGXT",OpcodeType.RXE_FERRD,"test data group extended dfp","z9-ec","zarch");
    public static final Opcode OP_PFPO = new Opcode(DatatypeConverter.parseHexBinary("010a"),"PFPO",OpcodeType.E,"perform floating point operation","z9-ec","zarch");
    public static final Opcode OP_ECTG = new Opcode(DatatypeConverter.parseHexBinary("c801"),"ECTG",OpcodeType.SSF_RRDRD,"extract cpu time","z9-ec","zarch");
    public static final Opcode OP_CSST = new Opcode(DatatypeConverter.parseHexBinary("c802"),"CSST",OpcodeType.SSF_RRDRD,"compare and swap and store","z9-ec","zarch");
    public static final Opcode OP_ASI = new Opcode(DatatypeConverter.parseHexBinary("eb000000006a"),"ASI",OpcodeType.SIY_IRD,"add immediate (32<8)","z10","zarch");
    public static final Opcode OP_AGSI = new Opcode(DatatypeConverter.parseHexBinary("eb000000007a"),"AGSI",OpcodeType.SIY_IRD,"add immediate (64<8)","z10","zarch");
    public static final Opcode OP_ALSI = new Opcode(DatatypeConverter.parseHexBinary("eb000000006e"),"ALSI",OpcodeType.SIY_IRD,"add logical with signed immediate (32<8)","z10","zarch");
    public static final Opcode OP_ALGSI = new Opcode(DatatypeConverter.parseHexBinary("eb000000007e"),"ALGSI",OpcodeType.SIY_IRD,"add logical with signed immediate (64<8)","z10","zarch");
    public static final Opcode OP_CRL = new Opcode(DatatypeConverter.parseHexBinary("c60d"),"CRL",OpcodeType.RIL_RP,"compare relative long (32)","z10","zarch");
    public static final Opcode OP_CGRL = new Opcode(DatatypeConverter.parseHexBinary("c608"),"CGRL",OpcodeType.RIL_RP,"compare relative long (64)","z10","zarch");
    public static final Opcode OP_CGFRL = new Opcode(DatatypeConverter.parseHexBinary("c60c"),"CGFRL",OpcodeType.RIL_RP,"compare relative long (64<32)","z10","zarch");
    public static final Opcode OP_CRB = new Opcode(DatatypeConverter.parseHexBinary("ec00000000f6"),"CRB",OpcodeType.RRS_RRRDU,"compare and branch (32)","z10","zarch");
    public static final Opcode OP_CGRB = new Opcode(DatatypeConverter.parseHexBinary("ec00000000e4"),"CGRB",OpcodeType.RRS_RRRDU,"compare and branch (64)","z10","zarch");
    public static final Opcode OP_CRJ = new Opcode(DatatypeConverter.parseHexBinary("ec0000000076"),"CRJ",OpcodeType.RIE_RRPU,"compare and branch relative (32)","z10","zarch");
    public static final Opcode OP_CGRJ = new Opcode(DatatypeConverter.parseHexBinary("ec0000000064"),"CGRJ",OpcodeType.RIE_RRPU,"compare and branch relative (64)","z10","zarch");
    public static final Opcode OP_CIB = new Opcode(DatatypeConverter.parseHexBinary("ec00000000fe"),"CIB",OpcodeType.RIS_RURDI,"compare immediate and branch (32<8)","z10","zarch");
    public static final Opcode OP_CGIB = new Opcode(DatatypeConverter.parseHexBinary("ec00000000fc"),"CGIB",OpcodeType.RIS_RURDI,"compare immediate and branch (64<8)","z10","zarch");
    public static final Opcode OP_CIJ = new Opcode(DatatypeConverter.parseHexBinary("ec000000007e"),"CIJ",OpcodeType.RIE_RUPI,"compare immediate and branch relative (32<8)","z10","zarch");
    public static final Opcode OP_CGIJ = new Opcode(DatatypeConverter.parseHexBinary("ec000000007c"),"CGIJ",OpcodeType.RIE_RUPI,"compare immediate and branch relative (64<8)","z10","zarch");
    public static final Opcode OP_CRT = new Opcode(DatatypeConverter.parseHexBinary("b972"),"CRT",OpcodeType.RRF_U0RR,"compare and trap","z10","zarch");
    public static final Opcode OP_CGRT = new Opcode(DatatypeConverter.parseHexBinary("b960"),"CGRT",OpcodeType.RRF_U0RR,"compare and trap 64","z10","zarch");
    public static final Opcode OP_CIT = new Opcode(DatatypeConverter.parseHexBinary("ec0000000072"),"CIT",OpcodeType.RIE_R0IU,"compare immediate and trap (32<16)","z10","zarch");
    public static final Opcode OP_CGIT = new Opcode(DatatypeConverter.parseHexBinary("ec0000000070"),"CGIT",OpcodeType.RIE_R0IU,"compare immediate and trap (64<16)","z10","zarch");
    public static final Opcode OP_CGH = new Opcode(DatatypeConverter.parseHexBinary("e30000000034"),"CGH",OpcodeType.RXY_RRRD,"compare halfword (64<16)","z10","zarch");
    public static final Opcode OP_CHHSI = new Opcode(DatatypeConverter.parseHexBinary("e554"),"CHHSI",OpcodeType.SIL_RDI,"compare halfword immediate (16<16)","z10","zarch");
    public static final Opcode OP_CHSI = new Opcode(DatatypeConverter.parseHexBinary("e55c"),"CHSI",OpcodeType.SIL_RDI,"compare halfword immediate (32<16)","z10","zarch");
    public static final Opcode OP_CGHSI = new Opcode(DatatypeConverter.parseHexBinary("e558"),"CGHSI",OpcodeType.SIL_RDI,"compare halfword immediate (64<16)","z10","zarch");
    public static final Opcode OP_CHRL = new Opcode(DatatypeConverter.parseHexBinary("c605"),"CHRL",OpcodeType.RIL_RP,"compare halfword relative long (32<8)","z10","zarch");
    public static final Opcode OP_CGHRL = new Opcode(DatatypeConverter.parseHexBinary("c604"),"CGHRL",OpcodeType.RIL_RP,"compare halfword relative long (64<8)","z10","zarch");
    public static final Opcode OP_CLHHSI = new Opcode(DatatypeConverter.parseHexBinary("e555"),"CLHHSI",OpcodeType.SIL_RDU,"compare logical immediate (16<16)","z10","zarch");
    public static final Opcode OP_CLFHSI = new Opcode(DatatypeConverter.parseHexBinary("e55d"),"CLFHSI",OpcodeType.SIL_RDU,"compare logical immediate (32<16)","z10","zarch");
    public static final Opcode OP_CLGHSI = new Opcode(DatatypeConverter.parseHexBinary("e559"),"CLGHSI",OpcodeType.SIL_RDU,"compare logical immediate (64<16)","z10","zarch");
    public static final Opcode OP_CLRL = new Opcode(DatatypeConverter.parseHexBinary("c60f"),"CLRL",OpcodeType.RIL_RP,"compare logical relative long (32)","z10","zarch");
    public static final Opcode OP_CLGRL = new Opcode(DatatypeConverter.parseHexBinary("c60a"),"CLGRL",OpcodeType.RIL_RP,"compare logical relative long (64)","z10","zarch");
    public static final Opcode OP_CLGFRL = new Opcode(DatatypeConverter.parseHexBinary("c60e"),"CLGFRL",OpcodeType.RIL_RP,"compare logical relative long (64<32)","z10","zarch");
    public static final Opcode OP_CLHRL = new Opcode(DatatypeConverter.parseHexBinary("c607"),"CLHRL",OpcodeType.RIL_RP,"compare logical relative long (32<16)","z10","zarch");
    public static final Opcode OP_CLGHRL = new Opcode(DatatypeConverter.parseHexBinary("c606"),"CLGHRL",OpcodeType.RIL_RP,"compare logical relative long (64<16)","z10","zarch");
    public static final Opcode OP_CLRB = new Opcode(DatatypeConverter.parseHexBinary("ec00000000f7"),"CLRB",OpcodeType.RRS_RRRDU,"compare logical and branch (32)","z10","zarch");
    public static final Opcode OP_CLGRB = new Opcode(DatatypeConverter.parseHexBinary("ec00000000e5"),"CLGRB",OpcodeType.RRS_RRRDU,"compare logical and branch (64)","z10","zarch");
    public static final Opcode OP_CLRJ = new Opcode(DatatypeConverter.parseHexBinary("ec0000000077"),"CLRJ",OpcodeType.RIE_RRPU,"compare logical and branch relative (32)","z10","zarch");
    public static final Opcode OP_CLGRJ = new Opcode(DatatypeConverter.parseHexBinary("ec0000000065"),"CLGRJ",OpcodeType.RIE_RRPU,"compare logical and branch relative (64)","z10","zarch");
    public static final Opcode OP_CLIB = new Opcode(DatatypeConverter.parseHexBinary("ec00000000ff"),"CLIB",OpcodeType.RIS_RURDU,"compare logical immediate and branch (32<8)","z10","zarch");
    public static final Opcode OP_CLGIB = new Opcode(DatatypeConverter.parseHexBinary("ec00000000fd"),"CLGIB",OpcodeType.RIS_RURDU,"compare logical immediate and branch (64<8)","z10","zarch");
    public static final Opcode OP_CLIJ = new Opcode(DatatypeConverter.parseHexBinary("ec000000007f"),"CLIJ",OpcodeType.RIE_RUPU,"compare logical immediate and branch relative (32<8)","z10","zarch");
    public static final Opcode OP_CLGIJ = new Opcode(DatatypeConverter.parseHexBinary("ec000000007d"),"CLGIJ",OpcodeType.RIE_RUPU,"compare logical immediate and branch relative (64<8)","z10","zarch");
    public static final Opcode OP_CLRT = new Opcode(DatatypeConverter.parseHexBinary("b973"),"CLRT",OpcodeType.RRF_U0RR,"compare logical and trap (32)","z10","zarch");
    public static final Opcode OP_CLGRT = new Opcode(DatatypeConverter.parseHexBinary("b961"),"CLGRT",OpcodeType.RRF_U0RR,"compare logical and trap (64)","z10","zarch");
    public static final Opcode OP_CLFIT = new Opcode(DatatypeConverter.parseHexBinary("ec0000000073"),"CLFIT",OpcodeType.RIE_R0UU,"compare logical and trap (32<16)","z10","zarch");
    public static final Opcode OP_CLGIT = new Opcode(DatatypeConverter.parseHexBinary("ec0000000071"),"CLGIT",OpcodeType.RIE_R0UU,"compare logical and trap (64<16)","z10","zarch");
    public static final Opcode OP_ECAG = new Opcode(DatatypeConverter.parseHexBinary("eb000000004c"),"ECAG",OpcodeType.RSY_RRRD,"extract cache attribute","z10","zarch");
    public static final Opcode OP_LRL = new Opcode(DatatypeConverter.parseHexBinary("c40d"),"LRL",OpcodeType.RIL_RP,"load relative long (32)","z10","zarch");
    public static final Opcode OP_LGRL = new Opcode(DatatypeConverter.parseHexBinary("c408"),"LGRL",OpcodeType.RIL_RP,"load relative long (64)","z10","zarch");
    public static final Opcode OP_LGFRL = new Opcode(DatatypeConverter.parseHexBinary("c40c"),"LGFRL",OpcodeType.RIL_RP,"load relative long (64<32)","z10","zarch");
    public static final Opcode OP_LAEY = new Opcode(DatatypeConverter.parseHexBinary("e30000000075"),"LAEY",OpcodeType.RXY_RRRD,"load address extended","z10","zarch");
    public static final Opcode OP_LTGF = new Opcode(DatatypeConverter.parseHexBinary("e30000000032"),"LTGF",OpcodeType.RXY_RRRD,"load and test (64<32)","z10","zarch");
    public static final Opcode OP_LHRL = new Opcode(DatatypeConverter.parseHexBinary("c405"),"LHRL",OpcodeType.RIL_RP,"load halfword relative long (32<16)","z10","zarch");
    public static final Opcode OP_LGHRL = new Opcode(DatatypeConverter.parseHexBinary("c404"),"LGHRL",OpcodeType.RIL_RP,"load halfword relative long (64<16)","z10","zarch");
    public static final Opcode OP_LLGFRL = new Opcode(DatatypeConverter.parseHexBinary("c40e"),"LLGFRL",OpcodeType.RIL_RP,"load logical relative long (64<32)","z10","zarch");
    public static final Opcode OP_LLHRL = new Opcode(DatatypeConverter.parseHexBinary("c402"),"LLHRL",OpcodeType.RIL_RP,"load logical halfword relative long (32<16)","z10","zarch");
    public static final Opcode OP_LLGHRL = new Opcode(DatatypeConverter.parseHexBinary("c406"),"LLGHRL",OpcodeType.RIL_RP,"load logical halfword relative long (64<16)","z10","zarch");
    public static final Opcode OP_MVHHI = new Opcode(DatatypeConverter.parseHexBinary("e544"),"MVHHI",OpcodeType.SIL_RDI,"move (16<16)","z10","zarch");
    public static final Opcode OP_MVHI = new Opcode(DatatypeConverter.parseHexBinary("e54c"),"MVHI",OpcodeType.SIL_RDI,"move (32<16)","z10","zarch");
    public static final Opcode OP_MVGHI = new Opcode(DatatypeConverter.parseHexBinary("e548"),"MVGHI",OpcodeType.SIL_RDI,"move (64<16)","z10","zarch");
    public static final Opcode OP_MFY = new Opcode(DatatypeConverter.parseHexBinary("e3000000005c"),"MFY",OpcodeType.RXY_RERRD,"multiply","z10","zarch");
    public static final Opcode OP_MHY = new Opcode(DatatypeConverter.parseHexBinary("e3000000007c"),"MHY",OpcodeType.RXY_RRRD,"multiply halfword","z10","zarch");
    public static final Opcode OP_MSFI = new Opcode(DatatypeConverter.parseHexBinary("c201"),"MSFI",OpcodeType.RIL_RI,"multiply single immediate (32)","z10","zarch");
    public static final Opcode OP_MSGFI = new Opcode(DatatypeConverter.parseHexBinary("c200"),"MSGFI",OpcodeType.RIL_RI,"multiply single immediate (64)","z10","zarch");
    public static final Opcode OP_PFD = new Opcode(DatatypeConverter.parseHexBinary("e30000000036"),"PFD",OpcodeType.RXY_URRD,"prefetch data","z10","zarch");
    public static final Opcode OP_PFDRL = new Opcode(DatatypeConverter.parseHexBinary("c602"),"PFDRL",OpcodeType.RIL_UP,"prefetch data relative long","z10","zarch");
    public static final Opcode OP_RNSBG = new Opcode(DatatypeConverter.parseHexBinary("ec0000000054"),"RNSBG",OpcodeType.RIE_RRUUU,"rotate then and selected bits","z10","zarch");
    public static final Opcode OP_RXSBG = new Opcode(DatatypeConverter.parseHexBinary("ec0000000057"),"RXSBG",OpcodeType.RIE_RRUUU,"rotate then exclusive or selected bits","z10","zarch");
    public static final Opcode OP_ROSBG = new Opcode(DatatypeConverter.parseHexBinary("ec0000000056"),"ROSBG",OpcodeType.RIE_RRUUU,"rotate then or selected bits","z10","zarch");
    public static final Opcode OP_RISBG = new Opcode(DatatypeConverter.parseHexBinary("ec0000000055"),"RISBG",OpcodeType.RIE_RRUUU,"rotate then insert selected bits","z10","zarch");
    public static final Opcode OP_STRL = new Opcode(DatatypeConverter.parseHexBinary("c40f"),"STRL",OpcodeType.RIL_RP,"store relative long (32)","z10","zarch");
    public static final Opcode OP_STGRL = new Opcode(DatatypeConverter.parseHexBinary("c40b"),"STGRL",OpcodeType.RIL_RP,"store relative long (64)","z10","zarch");
    public static final Opcode OP_STHRL = new Opcode(DatatypeConverter.parseHexBinary("c407"),"STHRL",OpcodeType.RIL_RP,"store halfword relative long","z10","zarch");
    public static final Opcode OP_EXRL = new Opcode(DatatypeConverter.parseHexBinary("c600"),"EXRL",OpcodeType.RIL_RP,"execute relative long","z10","zarch");
    public static final Opcode OP_PTF = new Opcode(DatatypeConverter.parseHexBinary("b9a2"),"PTF",OpcodeType.RRE_R0,"perform topology function","z10","zarch");
    public static final Opcode OP_PFMF = new Opcode(DatatypeConverter.parseHexBinary("b9af"),"PFMF",OpcodeType.RRE_RR,"perform frame management function","z10","zarch");
    public static final Opcode OP_TRTE = new Opcode(DatatypeConverter.parseHexBinary("b9bf"),"TRTE",OpcodeType.RRF_U0RER,"translate and test extended","z10","zarch");
    public static final Opcode OP_TRTRE = new Opcode(DatatypeConverter.parseHexBinary("b9bd"),"TRTRE",OpcodeType.RRF_U0RER,"translate and test reverse extended","z10","zarch");
    public static final Opcode OP_ECPGA = new Opcode(DatatypeConverter.parseHexBinary("b2ed"),"ECPGA",OpcodeType.RRE_RR,"extract coprocessor-group address","z10","zarch");
    public static final Opcode OP_ECCTR = new Opcode(DatatypeConverter.parseHexBinary("b2e4"),"ECCTR",OpcodeType.RRE_RR,"extract cpu counter","z10","zarch");
    public static final Opcode OP_EPCTR = new Opcode(DatatypeConverter.parseHexBinary("b2e5"),"EPCTR",OpcodeType.RRE_RR,"extract peripheral counter","z10","zarch");
    public static final Opcode OP_LCCTL = new Opcode(DatatypeConverter.parseHexBinary("b284"),"LCCTL",OpcodeType.S_RD,"load cpu-counter-set controls","z10","zarch");
    public static final Opcode OP_LPCTL = new Opcode(DatatypeConverter.parseHexBinary("b285"),"LPCTL",OpcodeType.S_RD,"load peripheral-counter-set controls","z10","zarch");
    public static final Opcode OP_LSCTL = new Opcode(DatatypeConverter.parseHexBinary("b287"),"LSCTL",OpcodeType.S_RD,"load sampling controls","z10","zarch");
    public static final Opcode OP_QCTRI = new Opcode(DatatypeConverter.parseHexBinary("b28e"),"QCTRI",OpcodeType.S_RD,"query counter information","z10","zarch");
    public static final Opcode OP_QSI = new Opcode(DatatypeConverter.parseHexBinary("b286"),"QSI",OpcodeType.S_RD,"query sampling information","z10","zarch");
    public static final Opcode OP_SCCTR = new Opcode(DatatypeConverter.parseHexBinary("b2e0"),"SCCTR",OpcodeType.RRE_RR,"set cpu counter","z10","zarch");
    public static final Opcode OP_SPCTR = new Opcode(DatatypeConverter.parseHexBinary("b2e1"),"SPCTR",OpcodeType.RRE_RR,"set peripheral counter","z10","zarch");
    public static final Opcode OP_LPP = new Opcode(DatatypeConverter.parseHexBinary("b280"),"LPP",OpcodeType.S_RD,"load program parameter","z10","zarch");
    public static final Opcode OP_PCKMO = new Opcode(DatatypeConverter.parseHexBinary("b928"),"PCKMO",OpcodeType.RRE_00,"perform cryptographic key management operation","z10","zarch");
    public static final Opcode OP_AHHHR = new Opcode(DatatypeConverter.parseHexBinary("b9c8"),"AHHHR",OpcodeType.RRF_R0RR2,"add high high","z196","zarch");
    public static final Opcode OP_AHHLR = new Opcode(DatatypeConverter.parseHexBinary("b9d8"),"AHHLR",OpcodeType.RRF_R0RR2,"add high low","z196","zarch");
    public static final Opcode OP_AIH = new Opcode(DatatypeConverter.parseHexBinary("cc08"),"AIH",OpcodeType.RIL_RI,"add immediate high","z196","zarch");
    public static final Opcode OP_ALHHHR = new Opcode(DatatypeConverter.parseHexBinary("b9ca"),"ALHHHR",OpcodeType.RRF_R0RR2,"add logical high high","z196","zarch");
    public static final Opcode OP_ALHHLR = new Opcode(DatatypeConverter.parseHexBinary("b9da"),"ALHHLR",OpcodeType.RRF_R0RR2,"add logical high low","z196","zarch");
    public static final Opcode OP_ALSIH = new Opcode(DatatypeConverter.parseHexBinary("cc0a"),"ALSIH",OpcodeType.RIL_RI,"add logical with signed immediate high with cc","z196","zarch");
    public static final Opcode OP_ALSIHN = new Opcode(DatatypeConverter.parseHexBinary("cc0b"),"ALSIHN",OpcodeType.RIL_RI,"add logical with signed immediate high no cc","z196","zarch");
    public static final Opcode OP_BRCTH = new Opcode(DatatypeConverter.parseHexBinary("cc06"),"BRCTH",OpcodeType.RIL_RP,"branch relative on count high","z196","zarch");
    public static final Opcode OP_CHHR = new Opcode(DatatypeConverter.parseHexBinary("b9cd"),"CHHR",OpcodeType.RRE_RR,"compare high high","z196","zarch");
    public static final Opcode OP_CHLR = new Opcode(DatatypeConverter.parseHexBinary("b9dd"),"CHLR",OpcodeType.RRE_RR,"compare high low","z196","zarch");
    public static final Opcode OP_CHF = new Opcode(DatatypeConverter.parseHexBinary("e300000000cd"),"CHF",OpcodeType.RXY_RRRD,"compare high","z196","zarch");
    public static final Opcode OP_CIH = new Opcode(DatatypeConverter.parseHexBinary("cc0d"),"CIH",OpcodeType.RIL_RI,"compare immediate high","z196","zarch");
    public static final Opcode OP_CLHHR = new Opcode(DatatypeConverter.parseHexBinary("b9cf"),"CLHHR",OpcodeType.RRE_RR,"compare logical high high","z196","zarch");
    public static final Opcode OP_CLHLR = new Opcode(DatatypeConverter.parseHexBinary("b9df"),"CLHLR",OpcodeType.RRE_RR,"compare logical high low","z196","zarch");
    public static final Opcode OP_CLHF = new Opcode(DatatypeConverter.parseHexBinary("e300000000cf"),"CLHF",OpcodeType.RXY_RRRD,"compare logical high","z196","zarch");
    public static final Opcode OP_CLIH = new Opcode(DatatypeConverter.parseHexBinary("cc0f"),"CLIH",OpcodeType.RIL_RU,"compare logical immediate","z196","zarch");
    public static final Opcode OP_LBH = new Opcode(DatatypeConverter.parseHexBinary("e300000000c0"),"LBH",OpcodeType.RXY_RRRD,"load byte high","z196","zarch");
    public static final Opcode OP_LHH = new Opcode(DatatypeConverter.parseHexBinary("e300000000c4"),"LHH",OpcodeType.RXY_RRRD,"load halfword high","z196","zarch");
    public static final Opcode OP_LFH = new Opcode(DatatypeConverter.parseHexBinary("e300000000ca"),"LFH",OpcodeType.RXY_RRRD,"load high","z196","zarch");
    public static final Opcode OP_LLCH = new Opcode(DatatypeConverter.parseHexBinary("e300000000c2"),"LLCH",OpcodeType.RXY_RRRD,"load logical character high","z196","zarch");
    public static final Opcode OP_LLHH = new Opcode(DatatypeConverter.parseHexBinary("e300000000c6"),"LLHH",OpcodeType.RXY_RRRD,"load logical halfword high","z196","zarch");
    public static final Opcode OP_RISBHG = new Opcode(DatatypeConverter.parseHexBinary("ec000000005d"),"RISBHG",OpcodeType.RIE_RRUUU,"rotate then insert selected bits high","z196","zarch");
    public static final Opcode OP_RISBLG = new Opcode(DatatypeConverter.parseHexBinary("ec0000000051"),"RISBLG",OpcodeType.RIE_RRUUU,"rotate then insert selected bits low","z196","zarch");
    public static final Opcode OP_STCH = new Opcode(DatatypeConverter.parseHexBinary("e300000000c3"),"STCH",OpcodeType.RXY_RRRD,"store character high","z196","zarch");
    public static final Opcode OP_STHH = new Opcode(DatatypeConverter.parseHexBinary("e300000000c7"),"STHH",OpcodeType.RXY_RRRD,"store halfword high","z196","zarch");
    public static final Opcode OP_STFH = new Opcode(DatatypeConverter.parseHexBinary("e300000000cb"),"STFH",OpcodeType.RXY_RRRD,"store high","z196","zarch");
    public static final Opcode OP_SHHHR = new Opcode(DatatypeConverter.parseHexBinary("b9c9"),"SHHHR",OpcodeType.RRF_R0RR2,"subtract high high","z196","zarch");
    public static final Opcode OP_SHHLR = new Opcode(DatatypeConverter.parseHexBinary("b9d9"),"SHHLR",OpcodeType.RRF_R0RR2,"subtract high low","z196","zarch");
    public static final Opcode OP_SLHHHR = new Opcode(DatatypeConverter.parseHexBinary("b9cb"),"SLHHHR",OpcodeType.RRF_R0RR2,"subtract logical high high","z196","zarch");
    public static final Opcode OP_SLHHLR = new Opcode(DatatypeConverter.parseHexBinary("b9db"),"SLHHLR",OpcodeType.RRF_R0RR2,"subtract logical high low","z196","zarch");
    public static final Opcode OP_LAA = new Opcode(DatatypeConverter.parseHexBinary("eb00000000f8"),"LAA",OpcodeType.RSY_RRRD,"load and add 32 bit","z196","zarch");
    public static final Opcode OP_LAAG = new Opcode(DatatypeConverter.parseHexBinary("eb00000000e8"),"LAAG",OpcodeType.RSY_RRRD,"load and add 64 bit","z196","zarch");
    public static final Opcode OP_LAAL = new Opcode(DatatypeConverter.parseHexBinary("eb00000000fa"),"LAAL",OpcodeType.RSY_RRRD,"load and add logical 32 bit","z196","zarch");
    public static final Opcode OP_LAALG = new Opcode(DatatypeConverter.parseHexBinary("eb00000000ea"),"LAALG",OpcodeType.RSY_RRRD,"load and add logical 64 bit","z196","zarch");
    public static final Opcode OP_LAN = new Opcode(DatatypeConverter.parseHexBinary("eb00000000f4"),"LAN",OpcodeType.RSY_RRRD,"load and and 32 bit","z196","zarch");
    public static final Opcode OP_LANG = new Opcode(DatatypeConverter.parseHexBinary("eb00000000e4"),"LANG",OpcodeType.RSY_RRRD,"load and and 64 bit","z196","zarch");
    public static final Opcode OP_LAX = new Opcode(DatatypeConverter.parseHexBinary("eb00000000f7"),"LAX",OpcodeType.RSY_RRRD,"load and exclusive or 32 bit","z196","zarch");
    public static final Opcode OP_LAXG = new Opcode(DatatypeConverter.parseHexBinary("eb00000000e7"),"LAXG",OpcodeType.RSY_RRRD,"load and exclusive or 64 bit","z196","zarch");
    public static final Opcode OP_LAO = new Opcode(DatatypeConverter.parseHexBinary("eb00000000f6"),"LAO",OpcodeType.RSY_RRRD,"load and or 32 bit","z196","zarch");
    public static final Opcode OP_LAOG = new Opcode(DatatypeConverter.parseHexBinary("eb00000000e6"),"LAOG",OpcodeType.RSY_RRRD,"load and or 64 bit","z196","zarch");
    public static final Opcode OP_LPD = new Opcode(DatatypeConverter.parseHexBinary("c804"),"LPD",OpcodeType.SSF_RERDRD2,"load pair disjoint 32 bit","z196","zarch");
    public static final Opcode OP_LPDG = new Opcode(DatatypeConverter.parseHexBinary("c805"),"LPDG",OpcodeType.SSF_RERDRD2,"load pair disjoint 64 bit","z196","zarch");
    public static final Opcode OP_LOCR = new Opcode(DatatypeConverter.parseHexBinary("b9f2"),"LOCR",OpcodeType.RRF_U0RR,"load on condition 32 bit","z196","zarch");
    public static final Opcode OP_LOCGR = new Opcode(DatatypeConverter.parseHexBinary("b9e2"),"LOCGR",OpcodeType.RRF_U0RR,"load on condition 64  bit","z196","zarch");
    public static final Opcode OP_LOC = new Opcode(DatatypeConverter.parseHexBinary("eb00000000f2"),"LOC",OpcodeType.RSY_RURD2,"load on condition 32 bit","z196","zarch");
    public static final Opcode OP_LOCG = new Opcode(DatatypeConverter.parseHexBinary("eb00000000e2"),"LOCG",OpcodeType.RSY_RURD2,"load on condition 64 bit","z196","zarch");
    public static final Opcode OP_STOC = new Opcode(DatatypeConverter.parseHexBinary("eb00000000f3"),"STOC",OpcodeType.RSY_RURD2,"store on condition 32 bit","z196","zarch");
    public static final Opcode OP_STOCG = new Opcode(DatatypeConverter.parseHexBinary("eb00000000e3"),"STOCG",OpcodeType.RSY_RURD2,"store on condition 64 bit","z196","zarch");
    public static final Opcode OP_ARK = new Opcode(DatatypeConverter.parseHexBinary("b9f8"),"ARK",OpcodeType.RRF_R0RR2,"add 3 operands 32 bit","z196","zarch");
    public static final Opcode OP_AGRK = new Opcode(DatatypeConverter.parseHexBinary("b9e8"),"AGRK",OpcodeType.RRF_R0RR2,"add 3 operands 64 bit","z196","zarch");
    public static final Opcode OP_AHIK = new Opcode(DatatypeConverter.parseHexBinary("ec00000000d8"),"AHIK",OpcodeType.RIE_RRI0,"add immediate 3 operands 32 bit","z196","zarch");
    public static final Opcode OP_AGHIK = new Opcode(DatatypeConverter.parseHexBinary("ec00000000d9"),"AGHIK",OpcodeType.RIE_RRI0,"add immediate 3 operands 64 bit","z196","zarch");
    public static final Opcode OP_ALRK = new Opcode(DatatypeConverter.parseHexBinary("b9fa"),"ALRK",OpcodeType.RRF_R0RR2,"add logical 3 operands 32 bit","z196","zarch");
    public static final Opcode OP_ALGRK = new Opcode(DatatypeConverter.parseHexBinary("b9ea"),"ALGRK",OpcodeType.RRF_R0RR2,"add logical 3 operands 64 bit","z196","zarch");
    public static final Opcode OP_ALHSIK = new Opcode(DatatypeConverter.parseHexBinary("ec00000000da"),"ALHSIK",OpcodeType.RIE_RRI0,"add logical immediate 3 operands 32 bit","z196","zarch");
    public static final Opcode OP_ALGHSIK = new Opcode(DatatypeConverter.parseHexBinary("ec00000000db"),"ALGHSIK",OpcodeType.RIE_RRI0,"add logical immediate 3 operands 64 bit","z196","zarch");
    public static final Opcode OP_NRK = new Opcode(DatatypeConverter.parseHexBinary("b9f4"),"NRK",OpcodeType.RRF_R0RR2,"and 3 operands 32 bit","z196","zarch");
    public static final Opcode OP_NGRK = new Opcode(DatatypeConverter.parseHexBinary("b9e4"),"NGRK",OpcodeType.RRF_R0RR2,"and 3 operands 64 bit","z196","zarch");
    public static final Opcode OP_XRK = new Opcode(DatatypeConverter.parseHexBinary("b9f7"),"XRK",OpcodeType.RRF_R0RR2,"xor 3 operands 32 bit","z196","zarch");
    public static final Opcode OP_XGRK = new Opcode(DatatypeConverter.parseHexBinary("b9e7"),"XGRK",OpcodeType.RRF_R0RR2,"xor 3 operands 64 bit","z196","zarch");
    public static final Opcode OP_ORK = new Opcode(DatatypeConverter.parseHexBinary("b9f6"),"ORK",OpcodeType.RRF_R0RR2,"or 3 operands 32 bit","z196","zarch");
    public static final Opcode OP_OGRK = new Opcode(DatatypeConverter.parseHexBinary("b9e6"),"OGRK",OpcodeType.RRF_R0RR2,"or 3 operands 64 bit","z196","zarch");
    public static final Opcode OP_SLAK = new Opcode(DatatypeConverter.parseHexBinary("eb00000000dd"),"SLAK",OpcodeType.RSY_RRRD,"shift left single 3 operands 32 bit","z196","zarch");
    public static final Opcode OP_SLLK = new Opcode(DatatypeConverter.parseHexBinary("eb00000000df"),"SLLK",OpcodeType.RSY_RRRD,"shift left single logical 3 operands 32 bit","z196","zarch");
    public static final Opcode OP_SRAK = new Opcode(DatatypeConverter.parseHexBinary("eb00000000dc"),"SRAK",OpcodeType.RSY_RRRD,"shift right single 3 operands 32 bit","z196","zarch");
    public static final Opcode OP_SRLK = new Opcode(DatatypeConverter.parseHexBinary("eb00000000de"),"SRLK",OpcodeType.RSY_RRRD,"shift right single logical 3 operands 32 bit","z196","zarch");
    public static final Opcode OP_SRK = new Opcode(DatatypeConverter.parseHexBinary("b9f9"),"SRK",OpcodeType.RRF_R0RR2,"subtract 3 operands 32 bit","z196","zarch");
    public static final Opcode OP_SGRK = new Opcode(DatatypeConverter.parseHexBinary("b9e9"),"SGRK",OpcodeType.RRF_R0RR2,"subtract 3 operands 64 bit","z196","zarch");
    public static final Opcode OP_SLRK = new Opcode(DatatypeConverter.parseHexBinary("b9fb"),"SLRK",OpcodeType.RRF_R0RR2,"subtract logical 3 operands 32 bit","z196","zarch");
    public static final Opcode OP_SLGRK = new Opcode(DatatypeConverter.parseHexBinary("b9eb"),"SLGRK",OpcodeType.RRF_R0RR2,"subtract logical 3 operands 64 bit","z196","zarch");
    public static final Opcode OP_POPCNT = new Opcode(DatatypeConverter.parseHexBinary("b9e1"),"POPCNT",OpcodeType.RRE_RR,"population count","z196","zarch");
    public static final Opcode OP_RRBM = new Opcode(DatatypeConverter.parseHexBinary("b9ae"),"RRBM",OpcodeType.RRE_RR,"reset reference bits multiple","z196","zarch");
    public static final Opcode OP_CEFBRA = new Opcode(DatatypeConverter.parseHexBinary("b394"),"CEFBRA",OpcodeType.RRF_UUFR,"convert from 32 bit fixed to short bfp with rounding mode","z196","zarch");
    public static final Opcode OP_CDFBRA = new Opcode(DatatypeConverter.parseHexBinary("b395"),"CDFBRA",OpcodeType.RRF_UUFR,"convert from 32 bit fixed to long bfp with rounding mode","z196","zarch");
    public static final Opcode OP_CXFBRA = new Opcode(DatatypeConverter.parseHexBinary("b396"),"CXFBRA",OpcodeType.RRF_UUFER,"convert from 32 bit fixed to extended bfp with rounding mode","z196","zarch");
    public static final Opcode OP_CEGBRA = new Opcode(DatatypeConverter.parseHexBinary("b3a4"),"CEGBRA",OpcodeType.RRF_UUFR,"convert from 64 bit fixed to short bfp with rounding mode","z196","zarch");
    public static final Opcode OP_CDGBRA = new Opcode(DatatypeConverter.parseHexBinary("b3a5"),"CDGBRA",OpcodeType.RRF_UUFR,"convert from 64 bit fixed to long bfp with rounding mode","z196","zarch");
    public static final Opcode OP_CXGBRA = new Opcode(DatatypeConverter.parseHexBinary("b3a6"),"CXGBRA",OpcodeType.RRF_UUFER,"convert from 64 bit fixed to extended bfp with rounding mode","z196","zarch");
    public static final Opcode OP_CELFBR = new Opcode(DatatypeConverter.parseHexBinary("b390"),"CELFBR",OpcodeType.RRF_UUFR,"convert from 32 bit logical fixed to short bfp with rounding mode","z196","zarch");
    public static final Opcode OP_CDLFBR = new Opcode(DatatypeConverter.parseHexBinary("b391"),"CDLFBR",OpcodeType.RRF_UUFR,"convert from 32 bit logical fixed to long bfp with rounding mode","z196","zarch");
    public static final Opcode OP_CXLFBR = new Opcode(DatatypeConverter.parseHexBinary("b392"),"CXLFBR",OpcodeType.RRF_UUFER,"convert from 32 bit logical fixed to extended bfp with rounding mode","z196","zarch");
    public static final Opcode OP_CELGBR = new Opcode(DatatypeConverter.parseHexBinary("b3a0"),"CELGBR",OpcodeType.RRF_UUFR,"convert from 64 bit logical fixed to short bfp with rounding mode","z196","zarch");
    public static final Opcode OP_CDLGBR = new Opcode(DatatypeConverter.parseHexBinary("b3a1"),"CDLGBR",OpcodeType.RRF_UUFR,"convert from 64 bit logical fixed to long bfp with rounding mode","z196","zarch");
    public static final Opcode OP_CXLGBR = new Opcode(DatatypeConverter.parseHexBinary("b3a2"),"CXLGBR",OpcodeType.RRF_UUFER,"convert from 64 bit logical fixed to extended bfp with rounding mode","z196","zarch");
    public static final Opcode OP_CFEBRA = new Opcode(DatatypeConverter.parseHexBinary("b398"),"CFEBRA",OpcodeType.RRF_UURF,"convert to 32 bit fixed from short bfp with rounding mode","z196","zarch");
    public static final Opcode OP_CFDBRA = new Opcode(DatatypeConverter.parseHexBinary("b399"),"CFDBRA",OpcodeType.RRF_UURF,"convert to 32 bit fixed from long bfp with rounding mode","z196","zarch");
    public static final Opcode OP_CFXBRA = new Opcode(DatatypeConverter.parseHexBinary("b39a"),"CFXBRA",OpcodeType.RRF_UURFE,"convert to 32 bit fixed from extended bfp with rounding mode","z196","zarch");
    public static final Opcode OP_CGEBRA = new Opcode(DatatypeConverter.parseHexBinary("b3a8"),"CGEBRA",OpcodeType.RRF_UURF,"convert to 64 bit fixed from short bfp with rounding mode","z196","zarch");
    public static final Opcode OP_CGDBRA = new Opcode(DatatypeConverter.parseHexBinary("b3a9"),"CGDBRA",OpcodeType.RRF_UURF,"convert to 64 bit fixed from long bfp with rounding mode","z196","zarch");
    public static final Opcode OP_CGXBRA = new Opcode(DatatypeConverter.parseHexBinary("b3aa"),"CGXBRA",OpcodeType.RRF_UURFE,"convert to 64 bit fixed from extended bfp with rounding mode","z196","zarch");
    public static final Opcode OP_CLFEBR = new Opcode(DatatypeConverter.parseHexBinary("b39c"),"CLFEBR",OpcodeType.RRF_UURF,"convert to 32 bit fixed logical from short bfp with rounding mode","z196","zarch");
    public static final Opcode OP_CLFDBR = new Opcode(DatatypeConverter.parseHexBinary("b39d"),"CLFDBR",OpcodeType.RRF_UURF,"convert to 32 bit fixed logical from long bfp with rounding mode","z196","zarch");
    public static final Opcode OP_CLFXBR = new Opcode(DatatypeConverter.parseHexBinary("b39e"),"CLFXBR",OpcodeType.RRF_UURFE,"convert to 32 bit fixed logical from extended bfp with rounding mode","z196","zarch");
    public static final Opcode OP_CLGEBR = new Opcode(DatatypeConverter.parseHexBinary("b3ac"),"CLGEBR",OpcodeType.RRF_UURF,"convert to 64 bit fixed logical from short bfp with rounding mode","z196","zarch");
    public static final Opcode OP_CLGDBR = new Opcode(DatatypeConverter.parseHexBinary("b3ad"),"CLGDBR",OpcodeType.RRF_UURF,"convert to 64 bit fixed logical from long bfp with rounding mode","z196","zarch");
    public static final Opcode OP_CLGXBR = new Opcode(DatatypeConverter.parseHexBinary("b3ae"),"CLGXBR",OpcodeType.RRF_UURFE,"convert to 64 bit fixed logical from extended bfp with rounding mode","z196","zarch");
    public static final Opcode OP_FIEBRA = new Opcode(DatatypeConverter.parseHexBinary("b357"),"FIEBRA",OpcodeType.RRF_UUFF,"load fp integer short bfp with inexact suppression","z196","zarch");
    public static final Opcode OP_FIDBRA = new Opcode(DatatypeConverter.parseHexBinary("b35f"),"FIDBRA",OpcodeType.RRF_UUFF,"load fp integer long bfp with inexact suppression","z196","zarch");
    public static final Opcode OP_FIXBRA = new Opcode(DatatypeConverter.parseHexBinary("b347"),"FIXBRA",OpcodeType.RRF_UUFEFE,"load fp integer extended bfp with inexact suppression","z196","zarch");
    public static final Opcode OP_LEDBRA = new Opcode(DatatypeConverter.parseHexBinary("b344"),"LEDBRA",OpcodeType.RRF_UUFF,"load rounded short/long bfp to short/long bfp with rounding mode","z196","zarch");
    public static final Opcode OP_LDXBRA = new Opcode(DatatypeConverter.parseHexBinary("b345"),"LDXBRA",OpcodeType.RRF_UUFEFE,"load rounded long/extended bfp to long/extended bfp with rounding mode","z196","zarch");
    public static final Opcode OP_LEXBRA = new Opcode(DatatypeConverter.parseHexBinary("b346"),"LEXBRA",OpcodeType.RRF_UUFEFE,"load rounded short/extended bfp to short/extended bfp with rounding mode","z196","zarch");
    public static final Opcode OP_ADTRA = new Opcode(DatatypeConverter.parseHexBinary("b3d2"),"ADTRA",OpcodeType.RRF_FUFF2,"add long dfp with rounding mode","z196","zarch");
    public static final Opcode OP_AXTRA = new Opcode(DatatypeConverter.parseHexBinary("b3da"),"AXTRA",OpcodeType.RRF_FEUFEFE2,"add extended dfp with rounding mode","z196","zarch");
    public static final Opcode OP_CDGTRA = new Opcode(DatatypeConverter.parseHexBinary("b3f1"),"CDGTRA",OpcodeType.RRF_UUFR,"convert from fixed long dfp with rounding mode","z196","zarch");
    public static final Opcode OP_CDFTR = new Opcode(DatatypeConverter.parseHexBinary("b951"),"CDFTR",OpcodeType.RRF_UUFR,"convert from 32 bit fixed to long dfp with rounding mode","z196","zarch");
    public static final Opcode OP_CXFTR = new Opcode(DatatypeConverter.parseHexBinary("b959"),"CXFTR",OpcodeType.RRF_UUFER,"convert from 32 bit fixed to extended dfp with rounding mode","z196","zarch");
    public static final Opcode OP_CXGTRA = new Opcode(DatatypeConverter.parseHexBinary("b3f9"),"CXGTRA",OpcodeType.RRF_UUFER,"convert from fixed extended dfp with rounding mode","z196","zarch");
    public static final Opcode OP_CDLGTR = new Opcode(DatatypeConverter.parseHexBinary("b952"),"CDLGTR",OpcodeType.RRF_UUFR,"convert from 64 bit fixed logical to long dfp with rounding mode","z196","zarch");
    public static final Opcode OP_CXLGTR = new Opcode(DatatypeConverter.parseHexBinary("b95a"),"CXLGTR",OpcodeType.RRF_UUFER,"convert from 64 bit fixed logical to extended dfp with rounding mode","z196","zarch");
    public static final Opcode OP_CDLFTR = new Opcode(DatatypeConverter.parseHexBinary("b953"),"CDLFTR",OpcodeType.RRF_UUFR,"convert from 32 bit fixed logical to long dfp with rounding mode","z196","zarch");
    public static final Opcode OP_CXLFTR = new Opcode(DatatypeConverter.parseHexBinary("b95b"),"CXLFTR",OpcodeType.RRF_UUFR,"convert from 32 bit fixed logical to extended dfp with rounding mode","z196","zarch");
    public static final Opcode OP_CGDTRA = new Opcode(DatatypeConverter.parseHexBinary("b3e1"),"CGDTRA",OpcodeType.RRF_UURF,"convert to 64 bit fixed from long dfp with rounding mode","z196","zarch");
    public static final Opcode OP_CGXTRA = new Opcode(DatatypeConverter.parseHexBinary("b3e9"),"CGXTRA",OpcodeType.RRF_UURFE,"convert to 64 bit fixed from extended dfp with rounding mode","z196","zarch");
    public static final Opcode OP_CFDTR = new Opcode(DatatypeConverter.parseHexBinary("b941"),"CFDTR",OpcodeType.RRF_UURF,"convert to 32 bit fixed from long dfp source with rounding mode","z196","zarch");
    public static final Opcode OP_CFXTR = new Opcode(DatatypeConverter.parseHexBinary("b949"),"CFXTR",OpcodeType.RRF_UURF,"convert to 32 bit fixed from extended dfp source with rounding mode","z196","zarch");
    public static final Opcode OP_CLGDTR = new Opcode(DatatypeConverter.parseHexBinary("b942"),"CLGDTR",OpcodeType.RRF_UURF,"convert to 64 bit fixed logical from long dfp with rounding mode","z196","zarch");
    public static final Opcode OP_CLGXTR = new Opcode(DatatypeConverter.parseHexBinary("b94a"),"CLGXTR",OpcodeType.RRF_UURFE,"convert to 64 bit fixed logical from extended dfp with rounding mode","z196","zarch");
    public static final Opcode OP_CLFDTR = new Opcode(DatatypeConverter.parseHexBinary("b943"),"CLFDTR",OpcodeType.RRF_UURF,"convert to 32 bit fixed logical from long dfp with rounding mode","z196","zarch");
    public static final Opcode OP_CLFXTR = new Opcode(DatatypeConverter.parseHexBinary("b94b"),"CLFXTR",OpcodeType.RRF_UURFE,"convert to 32 bit fixed logical from extended dfp with rounding mode","z196","zarch");
    public static final Opcode OP_DDTRA = new Opcode(DatatypeConverter.parseHexBinary("b3d1"),"DDTRA",OpcodeType.RRF_FUFF2,"divide long dfp with rounding mode","z196","zarch");
    public static final Opcode OP_DXTRA = new Opcode(DatatypeConverter.parseHexBinary("b3d9"),"DXTRA",OpcodeType.RRF_FEUFEFE2,"divide extended dfp with rounding mode","z196","zarch");
    public static final Opcode OP_MDTRA = new Opcode(DatatypeConverter.parseHexBinary("b3d0"),"MDTRA",OpcodeType.RRF_FUFF2,"multiply long dfp with rounding mode","z196","zarch");
    public static final Opcode OP_MXTRA = new Opcode(DatatypeConverter.parseHexBinary("b3d8"),"MXTRA",OpcodeType.RRF_FEUFEFE2,"multiply extended dfp with rounding mode","z196","zarch");
    public static final Opcode OP_SDTRA = new Opcode(DatatypeConverter.parseHexBinary("b3d3"),"SDTRA",OpcodeType.RRF_FUFF2,"subtract long dfp with rounding mode","z196","zarch");
    public static final Opcode OP_SXTRA = new Opcode(DatatypeConverter.parseHexBinary("b3db"),"SXTRA",OpcodeType.RRF_FEUFEFE2,"subtract extended dfp with rounding mode","z196","zarch");
    public static final Opcode OP_SRNMB = new Opcode(DatatypeConverter.parseHexBinary("b2b8"),"SRNMB",OpcodeType.S_RD,"set 3 bit bfp rounding mode","z196","zarch");
    public static final Opcode OP_KMF = new Opcode(DatatypeConverter.parseHexBinary("b92a"),"KMF",OpcodeType.RRE_RR,"cipher message with CFB","z196","zarch");
    public static final Opcode OP_KMO = new Opcode(DatatypeConverter.parseHexBinary("b92b"),"KMO",OpcodeType.RRE_RR,"cipher message with OFB","z196","zarch");
    public static final Opcode OP_PCC = new Opcode(DatatypeConverter.parseHexBinary("b92c"),"PCC",OpcodeType.RRE_00,"perform cryptographic computation","z196","zarch");
    public static final Opcode OP_KMCTR = new Opcode(DatatypeConverter.parseHexBinary("b92d"),"KMCTR",OpcodeType.RRF_R0RR2,"cipher message with counter","z196","zarch");
    public static final Opcode OP_ETND = new Opcode(DatatypeConverter.parseHexBinary("b2ec"),"ETND",OpcodeType.RRE_R0,"extract transaction nesting depth","zEC12","zarch");
    public static final Opcode OP_NTSTG = new Opcode(DatatypeConverter.parseHexBinary("e30000000025"),"NTSTG",OpcodeType.RXY_RRRD,"nontransactional store","zEC12","zarch");
    public static final Opcode OP_TABORT = new Opcode(DatatypeConverter.parseHexBinary("b2fc"),"TABORT",OpcodeType.S_RD,"transaction abort","zEC12","zarch");
    public static final Opcode OP_TBEGIN = new Opcode(DatatypeConverter.parseHexBinary("e560"),"TBEGIN",OpcodeType.SIL_RDU,"transaction begin","zEC12","zarch");
    public static final Opcode OP_TBEGINC = new Opcode(DatatypeConverter.parseHexBinary("e561"),"TBEGINC",OpcodeType.SIL_RDU,"constrained transaction begin","zEC12","zarch");
    public static final Opcode OP_TEND = new Opcode(DatatypeConverter.parseHexBinary("b2f8"),"TEND",OpcodeType.S_00,"transaction end","zEC12","zarch");
    public static final Opcode OP_BPP = new Opcode(DatatypeConverter.parseHexBinary("c7"),"BPP",OpcodeType.SMI_U0RDP,"branch prediction preload","zEC12","zarch");
    public static final Opcode OP_BPRP = new Opcode(DatatypeConverter.parseHexBinary("c5"),"BPRP",OpcodeType.MII_UPP,"branch prediction relative preload","zEC12","zarch");
    public static final Opcode OP_PPA = new Opcode(DatatypeConverter.parseHexBinary("b2e8"),"PPA",OpcodeType.RRF_U0RR,"perform processor assist","zEC12","zarch");
    public static final Opcode OP_NIAI = new Opcode(DatatypeConverter.parseHexBinary("b2fa"),"NIAI",OpcodeType.IE_UU,"next instruction access intent","zEC12","zarch");
    public static final Opcode OP_CRDTE = new Opcode(DatatypeConverter.parseHexBinary("b98f"),"CRDTE",OpcodeType.RRF_RURR2,"compare and replace DAT table entry","zEC12","zarch");
    public static final Opcode OP_LAT = new Opcode(DatatypeConverter.parseHexBinary("e3000000009f"),"LAT",OpcodeType.RXY_RRRD,"load and trap 32 bit","zEC12","zarch");
    public static final Opcode OP_LGAT = new Opcode(DatatypeConverter.parseHexBinary("e30000000085"),"LGAT",OpcodeType.RXY_RRRD,"load and trap 64 bit","zEC12","zarch");
    public static final Opcode OP_LFHAT = new Opcode(DatatypeConverter.parseHexBinary("e300000000c8"),"LFHAT",OpcodeType.RXY_RRRD,"load high and trap","zEC12","zarch");
    public static final Opcode OP_LLGFAT = new Opcode(DatatypeConverter.parseHexBinary("e3000000009d"),"LLGFAT",OpcodeType.RXY_RRRD,"load logical and trap 32>64","zEC12","zarch");
    public static final Opcode OP_LLGTAT = new Opcode(DatatypeConverter.parseHexBinary("e3000000009c"),"LLGTAT",OpcodeType.RXY_RRRD,"load logical thirty one bits and trap 31>64","zEC12","zarch");
    public static final Opcode OP_CLT = new Opcode(DatatypeConverter.parseHexBinary("eb0000000023"),"CLT",OpcodeType.RSY_RURD,"compare logical and trap 32 bit reg-mem","zEC12","zarch");
    public static final Opcode OP_CLGT = new Opcode(DatatypeConverter.parseHexBinary("eb000000002b"),"CLGT",OpcodeType.RSY_RURD,"compare logical and trap 64 bit reg-mem","zEC12","zarch");
    public static final Opcode OP_RISBGN = new Opcode(DatatypeConverter.parseHexBinary("ec0000000059"),"RISBGN",OpcodeType.RIE_RRUUU,"rotate then insert selected bits nocc","zEC12","zarch");
    public static final Opcode OP_CDZT = new Opcode(DatatypeConverter.parseHexBinary("ed00000000aa"),"CDZT",OpcodeType.RSL_LRDFU,"convert from zoned long","zEC12","zarch");
    public static final Opcode OP_CXZT = new Opcode(DatatypeConverter.parseHexBinary("ed00000000ab"),"CXZT",OpcodeType.RSL_LRDFEU,"convert from zoned extended","zEC12","zarch");
    public static final Opcode OP_CZDT = new Opcode(DatatypeConverter.parseHexBinary("ed00000000a8"),"CZDT",OpcodeType.RSL_LRDFU,"convert to zoned long","zEC12","zarch");
    public static final Opcode OP_CZXT = new Opcode(DatatypeConverter.parseHexBinary("ed00000000a9"),"CZXT",OpcodeType.RSL_LRDFEU,"convert to zoned extended","zEC12","zarch");
    public static final Opcode OP_LCBB = new Opcode(DatatypeConverter.parseHexBinary("e70000000027"),"LCBB",OpcodeType.RXE_RRRDU,"load count to block boundary","z13","zarch");
    public static final Opcode OP_VGEF = new Opcode(DatatypeConverter.parseHexBinary("e70000000013"),"VGEF",OpcodeType.VRV_VVXRDU,"vector gather element 4 byte elements","z13","zarch");
    public static final Opcode OP_VGEG = new Opcode(DatatypeConverter.parseHexBinary("e70000000012"),"VGEG",OpcodeType.VRV_VVXRDU,"vector gather element 8 byte elements","z13","zarch");
    public static final Opcode OP_VGBM = new Opcode(DatatypeConverter.parseHexBinary("e70000000044"),"VGBM",OpcodeType.VRI_V0U,"vector generate byte mask","z13","zarch");
    public static final Opcode OP_VZERO = new Opcode(DatatypeConverter.parseHexBinary("e70000000044"),"VZERO",OpcodeType.VRI_V,"vector set to zero","z13","zarch");
    public static final Opcode OP_VONE = new Opcode(DatatypeConverter.parseHexBinary("e700ffff0044"),"VONE",OpcodeType.VRI_V,"vector set to ones","z13","zarch");
    public static final Opcode OP_VGM = new Opcode(DatatypeConverter.parseHexBinary("e70000000046"),"VGM",OpcodeType.VRI_V0UUU,"vector generate mask","z13","zarch");
    public static final Opcode OP_VGMB = new Opcode(DatatypeConverter.parseHexBinary("e70000000046"),"VGMB",OpcodeType.VRI_V0UU,"vector generate mask byte","z13","zarch");
    public static final Opcode OP_VGMH = new Opcode(DatatypeConverter.parseHexBinary("e70000001046"),"VGMH",OpcodeType.VRI_V0UU,"vector generate mask halfword","z13","zarch");
    public static final Opcode OP_VGMF = new Opcode(DatatypeConverter.parseHexBinary("e70000002046"),"VGMF",OpcodeType.VRI_V0UU,"vector generate mask word","z13","zarch");
    public static final Opcode OP_VGMG = new Opcode(DatatypeConverter.parseHexBinary("e70000003046"),"VGMG",OpcodeType.VRI_V0UU,"vector generate mask double word","z13","zarch");
    public static final Opcode OP_VL = new Opcode(DatatypeConverter.parseHexBinary("e70000000006"),"VL",OpcodeType.VRX_VRRD,"vector memory load","z13","zarch");
    public static final Opcode OP_VLR = new Opcode(DatatypeConverter.parseHexBinary("e70000000056"),"VLR",OpcodeType.VRX_VV,"vector register load","z13","zarch");
    public static final Opcode OP_VLREP = new Opcode(DatatypeConverter.parseHexBinary("e70000000005"),"VLREP",OpcodeType.VRX_VRRDU,"vector load and replicate","z13","zarch");
    public static final Opcode OP_VLREPB = new Opcode(DatatypeConverter.parseHexBinary("e70000000005"),"VLREPB",OpcodeType.VRX_VRRD,"vector load and replicate byte elements","z13","zarch");
    public static final Opcode OP_VLREPH = new Opcode(DatatypeConverter.parseHexBinary("e70000001005"),"VLREPH",OpcodeType.VRX_VRRD,"vector load and replicate halfword elements","z13","zarch");
    public static final Opcode OP_VLREPF = new Opcode(DatatypeConverter.parseHexBinary("e70000002005"),"VLREPF",OpcodeType.VRX_VRRD,"vector load and replicate word elements","z13","zarch");
    public static final Opcode OP_VLREPG = new Opcode(DatatypeConverter.parseHexBinary("e70000003005"),"VLREPG",OpcodeType.VRX_VRRD,"vector load and replicate double word elements","z13","zarch");
    public static final Opcode OP_VLEB = new Opcode(DatatypeConverter.parseHexBinary("e70000000000"),"VLEB",OpcodeType.VRX_VRRDU,"vector load byte element","z13","zarch");
    public static final Opcode OP_VLEH = new Opcode(DatatypeConverter.parseHexBinary("e70000000001"),"VLEH",OpcodeType.VRX_VRRDU,"vector load halfword element","z13","zarch");
    public static final Opcode OP_VLEF = new Opcode(DatatypeConverter.parseHexBinary("e70000000003"),"VLEF",OpcodeType.VRX_VRRDU,"vector load word element","z13","zarch");
    public static final Opcode OP_VLEG = new Opcode(DatatypeConverter.parseHexBinary("e70000000002"),"VLEG",OpcodeType.VRX_VRRDU,"vector load double word element","z13","zarch");
    public static final Opcode OP_VLEIB = new Opcode(DatatypeConverter.parseHexBinary("e70000000040"),"VLEIB",OpcodeType.VRI_V0IU,"vector load byte element immediate","z13","zarch");
    public static final Opcode OP_VLEIH = new Opcode(DatatypeConverter.parseHexBinary("e70000000041"),"VLEIH",OpcodeType.VRI_V0IU,"vector load halfword element immediate","z13","zarch");
    public static final Opcode OP_VLEIF = new Opcode(DatatypeConverter.parseHexBinary("e70000000043"),"VLEIF",OpcodeType.VRI_V0IU,"vector load word element immediate","z13","zarch");
    public static final Opcode OP_VLEIG = new Opcode(DatatypeConverter.parseHexBinary("e70000000042"),"VLEIG",OpcodeType.VRI_V0IU,"vector load double word element immediate","z13","zarch");
    public static final Opcode OP_VLGV = new Opcode(DatatypeConverter.parseHexBinary("e70000000021"),"VLGV",OpcodeType.VRS_RVRDU,"vector load gr from vr element","z13","zarch");
    public static final Opcode OP_VLGVB = new Opcode(DatatypeConverter.parseHexBinary("e70000000021"),"VLGVB",OpcodeType.VRS_RVRD,"vector load gr from vr byte element","z13","zarch");
    public static final Opcode OP_VLGVH = new Opcode(DatatypeConverter.parseHexBinary("e70000001021"),"VLGVH",OpcodeType.VRS_RVRD,"vector load gr from vr halfword element","z13","zarch");
    public static final Opcode OP_VLGVF = new Opcode(DatatypeConverter.parseHexBinary("e70000002021"),"VLGVF",OpcodeType.VRS_RVRD,"vector load gr from vr word element","z13","zarch");
    public static final Opcode OP_VLGVG = new Opcode(DatatypeConverter.parseHexBinary("e70000003021"),"VLGVG",OpcodeType.VRS_RVRD,"vector load gr from vr double word element","z13","zarch");
    public static final Opcode OP_VLLEZ = new Opcode(DatatypeConverter.parseHexBinary("e70000000004"),"VLLEZ",OpcodeType.VRX_VRRDU,"vector load logical element and zero","z13","zarch");
    public static final Opcode OP_VLLEZB = new Opcode(DatatypeConverter.parseHexBinary("e70000000004"),"VLLEZB",OpcodeType.VRX_VRRD,"vector load logical byte element and zero","z13","zarch");
    public static final Opcode OP_VLLEZH = new Opcode(DatatypeConverter.parseHexBinary("e70000001004"),"VLLEZH",OpcodeType.VRX_VRRD,"vector load logical halfword element and zero","z13","zarch");
    public static final Opcode OP_VLLEZF = new Opcode(DatatypeConverter.parseHexBinary("e70000002004"),"VLLEZF",OpcodeType.VRX_VRRD,"vector load logical word element and zero","z13","zarch");
    public static final Opcode OP_VLLEZG = new Opcode(DatatypeConverter.parseHexBinary("e70000003004"),"VLLEZG",OpcodeType.VRX_VRRD,"vector load logical double word element and zero","z13","zarch");
    public static final Opcode OP_VLM = new Opcode(DatatypeConverter.parseHexBinary("e70000000036"),"VLM",OpcodeType.VRS_VVRD,"vector load multiple","z13","zarch");
    public static final Opcode OP_VLBB = new Opcode(DatatypeConverter.parseHexBinary("e70000000007"),"VLBB",OpcodeType.VRX_VRRDU,"vector load to block boundary","z13","zarch");
    public static final Opcode OP_VLVG = new Opcode(DatatypeConverter.parseHexBinary("e70000000022"),"VLVG",OpcodeType.VRS_VRRDU,"vector load VR element from GR","z13","zarch");
    public static final Opcode OP_VLVGB = new Opcode(DatatypeConverter.parseHexBinary("e70000000022"),"VLVGB",OpcodeType.VRS_VRRD,"vector load VR byte element from GR","z13","zarch");
    public static final Opcode OP_VLVGH = new Opcode(DatatypeConverter.parseHexBinary("e70000001022"),"VLVGH",OpcodeType.VRS_VRRD,"vector load VR halfword element from GR","z13","zarch");
    public static final Opcode OP_VLVGF = new Opcode(DatatypeConverter.parseHexBinary("e70000002022"),"VLVGF",OpcodeType.VRS_VRRD,"vector load VR word element from GR","z13","zarch");
    public static final Opcode OP_VLVGG = new Opcode(DatatypeConverter.parseHexBinary("e70000003022"),"VLVGG",OpcodeType.VRS_VRRD,"vector load VR double word element from GR","z13","zarch");
    public static final Opcode OP_VLVGP = new Opcode(DatatypeConverter.parseHexBinary("e70000000062"),"VLVGP",OpcodeType.VRR_VRR,"vector load VR from GRs disjoint","z13","zarch");
    public static final Opcode OP_VLL = new Opcode(DatatypeConverter.parseHexBinary("e70000000037"),"VLL",OpcodeType.VRS_VRRD,"vector load with length","z13","zarch");
    public static final Opcode OP_VMRH = new Opcode(DatatypeConverter.parseHexBinary("e70000000061"),"VMRH",OpcodeType.VRR_VVV0U,"vector merge high","z13","zarch");
    public static final Opcode OP_VMRHB = new Opcode(DatatypeConverter.parseHexBinary("e70000000061"),"VMRHB",OpcodeType.VRR_VVV,"vector merge high byte","z13","zarch");
    public static final Opcode OP_VMRHH = new Opcode(DatatypeConverter.parseHexBinary("e70000001061"),"VMRHH",OpcodeType.VRR_VVV,"vector merge high halfword","z13","zarch");
    public static final Opcode OP_VMRHF = new Opcode(DatatypeConverter.parseHexBinary("e70000002061"),"VMRHF",OpcodeType.VRR_VVV,"vector merge high word","z13","zarch");
    public static final Opcode OP_VMRHG = new Opcode(DatatypeConverter.parseHexBinary("e70000003061"),"VMRHG",OpcodeType.VRR_VVV,"vector merge high double word","z13","zarch");
    public static final Opcode OP_VMRL = new Opcode(DatatypeConverter.parseHexBinary("e70000000060"),"VMRL",OpcodeType.VRR_VVV0U,"vector merge low","z13","zarch");
    public static final Opcode OP_VMRLB = new Opcode(DatatypeConverter.parseHexBinary("e70000000060"),"VMRLB",OpcodeType.VRR_VVV,"vector merge low byte","z13","zarch");
    public static final Opcode OP_VMRLH = new Opcode(DatatypeConverter.parseHexBinary("e70000001060"),"VMRLH",OpcodeType.VRR_VVV,"vector merge low halfword","z13","zarch");
    public static final Opcode OP_VMRLF = new Opcode(DatatypeConverter.parseHexBinary("e70000002060"),"VMRLF",OpcodeType.VRR_VVV,"vector merge low word","z13","zarch");
    public static final Opcode OP_VMRLG = new Opcode(DatatypeConverter.parseHexBinary("e70000003060"),"VMRLG",OpcodeType.VRR_VVV,"vector merge low double word","z13","zarch");
    public static final Opcode OP_VPK = new Opcode(DatatypeConverter.parseHexBinary("e70000000094"),"VPK",OpcodeType.VRR_VVV0U,"vector pack","z13","zarch");
    public static final Opcode OP_VPKH = new Opcode(DatatypeConverter.parseHexBinary("e70000001094"),"VPKH",OpcodeType.VRR_VVV,"vector pack halfword","z13","zarch");
    public static final Opcode OP_VPKF = new Opcode(DatatypeConverter.parseHexBinary("e70000002094"),"VPKF",OpcodeType.VRR_VVV,"vector pack word","z13","zarch");
    public static final Opcode OP_VPKG = new Opcode(DatatypeConverter.parseHexBinary("e70000003094"),"VPKG",OpcodeType.VRR_VVV,"vector pack double word","z13","zarch");
    public static final Opcode OP_VPKS = new Opcode(DatatypeConverter.parseHexBinary("e70000000097"),"VPKS",OpcodeType.VRR_VVV0U0U,"vector pack saturate","z13","zarch");
    public static final Opcode OP_VPKSH = new Opcode(DatatypeConverter.parseHexBinary("e70000001097"),"VPKSH",OpcodeType.VRR_VVV,"vector pack saturate halfword","z13","zarch");
    public static final Opcode OP_VPKSF = new Opcode(DatatypeConverter.parseHexBinary("e70000002097"),"VPKSF",OpcodeType.VRR_VVV,"vector pack saturate word","z13","zarch");
    public static final Opcode OP_VPKSG = new Opcode(DatatypeConverter.parseHexBinary("e70000003097"),"VPKSG",OpcodeType.VRR_VVV,"vector pack saturate double word","z13","zarch");
    public static final Opcode OP_VPKSHS = new Opcode(DatatypeConverter.parseHexBinary("e70000101097"),"VPKSHS",OpcodeType.VRR_VVV,"vector pack saturate halfword","z13","zarch");
    public static final Opcode OP_VPKSFS = new Opcode(DatatypeConverter.parseHexBinary("e70000102097"),"VPKSFS",OpcodeType.VRR_VVV,"vector pack saturate word","z13","zarch");
    public static final Opcode OP_VPKSGS = new Opcode(DatatypeConverter.parseHexBinary("e70000103097"),"VPKSGS",OpcodeType.VRR_VVV,"vector pack saturate double word","z13","zarch");
    public static final Opcode OP_VPKLS = new Opcode(DatatypeConverter.parseHexBinary("e70000000095"),"VPKLS",OpcodeType.VRR_VVV0U0U,"vector pack logical saturate","z13","zarch");
    public static final Opcode OP_VPKLSH = new Opcode(DatatypeConverter.parseHexBinary("e70000001095"),"VPKLSH",OpcodeType.VRR_VVV,"vector pack logical saturate halfword","z13","zarch");
    public static final Opcode OP_VPKLSF = new Opcode(DatatypeConverter.parseHexBinary("e70000002095"),"VPKLSF",OpcodeType.VRR_VVV,"vector pack logical saturate word","z13","zarch");
    public static final Opcode OP_VPKLSG = new Opcode(DatatypeConverter.parseHexBinary("e70000003095"),"VPKLSG",OpcodeType.VRR_VVV,"vector pack logical saturate double word","z13","zarch");
    public static final Opcode OP_VPKLSHS = new Opcode(DatatypeConverter.parseHexBinary("e70000101095"),"VPKLSHS",OpcodeType.VRR_VVV,"vector pack logical saturate halfword","z13","zarch");
    public static final Opcode OP_VPKLSFS = new Opcode(DatatypeConverter.parseHexBinary("e70000102095"),"VPKLSFS",OpcodeType.VRR_VVV,"vector pack logical saturate word","z13","zarch");
    public static final Opcode OP_VPKLSGS = new Opcode(DatatypeConverter.parseHexBinary("e70000103095"),"VPKLSGS",OpcodeType.VRR_VVV,"vector pack logical saturate double word","z13","zarch");
    public static final Opcode OP_VPERM = new Opcode(DatatypeConverter.parseHexBinary("e7000000008c"),"VPERM",OpcodeType.VRR_VVV0V,"vector permute","z13","zarch");
    public static final Opcode OP_VPDI = new Opcode(DatatypeConverter.parseHexBinary("e70000000084"),"VPDI",OpcodeType.VRR_VVV0U,"vector permute double word immediate","z13","zarch");
    public static final Opcode OP_VREP = new Opcode(DatatypeConverter.parseHexBinary("e7000000004d"),"VREP",OpcodeType.VRI_VVUU,"vector replicate","z13","zarch");
    public static final Opcode OP_VREPB = new Opcode(DatatypeConverter.parseHexBinary("e7000000004d"),"VREPB",OpcodeType.VRI_VVU,"vector replicate byte","z13","zarch");
    public static final Opcode OP_VREPH = new Opcode(DatatypeConverter.parseHexBinary("e7000000104d"),"VREPH",OpcodeType.VRI_VVU,"vector replicate halfword","z13","zarch");
    public static final Opcode OP_VREPF = new Opcode(DatatypeConverter.parseHexBinary("e7000000204d"),"VREPF",OpcodeType.VRI_VVU,"vector replicate word","z13","zarch");
    public static final Opcode OP_VREPG = new Opcode(DatatypeConverter.parseHexBinary("e7000000304d"),"VREPG",OpcodeType.VRI_VVU,"vector replicate double word","z13","zarch");
    public static final Opcode OP_VREPI = new Opcode(DatatypeConverter.parseHexBinary("e70000000045"),"VREPI",OpcodeType.VRI_V0IU,"vector replicate immediate","z13","zarch");
    public static final Opcode OP_VREPIB = new Opcode(DatatypeConverter.parseHexBinary("e70000000045"),"VREPIB",OpcodeType.VRI_V0I,"vector replicate immediate byte","z13","zarch");
    public static final Opcode OP_VREPIH = new Opcode(DatatypeConverter.parseHexBinary("e70000001045"),"VREPIH",OpcodeType.VRI_V0I,"vector replicate immediate halfword","z13","zarch");
    public static final Opcode OP_VREPIF = new Opcode(DatatypeConverter.parseHexBinary("e70000002045"),"VREPIF",OpcodeType.VRI_V0I,"vector replicate immediate word","z13","zarch");
    public static final Opcode OP_VREPIG = new Opcode(DatatypeConverter.parseHexBinary("e70000003045"),"VREPIG",OpcodeType.VRI_V0I,"vector replicate immediate double word","z13","zarch");
    public static final Opcode OP_VSCEF = new Opcode(DatatypeConverter.parseHexBinary("e7000000001b"),"VSCEF",OpcodeType.VRV_VVXRDU,"vector scatter element 4 byte","z13","zarch");
    public static final Opcode OP_VSCEG = new Opcode(DatatypeConverter.parseHexBinary("e7000000001a"),"VSCEG",OpcodeType.VRV_VVXRDU,"vector scatter element 8 byte","z13","zarch");
    public static final Opcode OP_VSEL = new Opcode(DatatypeConverter.parseHexBinary("e7000000008d"),"VSEL",OpcodeType.VRR_VVV0V,"vector select","z13","zarch");
    public static final Opcode OP_VSEG = new Opcode(DatatypeConverter.parseHexBinary("e7000000005f"),"VSEG",OpcodeType.VRR_VV0U,"vector sign extend to double word","z13","zarch");
    public static final Opcode OP_VSEGB = new Opcode(DatatypeConverter.parseHexBinary("e7000000005f"),"VSEGB",OpcodeType.VRR_VV,"vector sign extend byte to double word","z13","zarch");
    public static final Opcode OP_VSEGH = new Opcode(DatatypeConverter.parseHexBinary("e7000000105f"),"VSEGH",OpcodeType.VRR_VV,"vector sign extend halfword to double word","z13","zarch");
    public static final Opcode OP_VSEGF = new Opcode(DatatypeConverter.parseHexBinary("e7000000205f"),"VSEGF",OpcodeType.VRR_VV,"vector sign extend word to double word","z13","zarch");
    public static final Opcode OP_VST = new Opcode(DatatypeConverter.parseHexBinary("e7000000000e"),"VST",OpcodeType.VRX_VRRD,"vector store","z13","zarch");
    public static final Opcode OP_VSTEB = new Opcode(DatatypeConverter.parseHexBinary("e70000000008"),"VSTEB",OpcodeType.VRX_VRRDU,"vector store byte element","z13","zarch");
    public static final Opcode OP_VSTEH = new Opcode(DatatypeConverter.parseHexBinary("e70000000009"),"VSTEH",OpcodeType.VRX_VRRDU,"vector store halfword element","z13","zarch");
    public static final Opcode OP_VSTEF = new Opcode(DatatypeConverter.parseHexBinary("e7000000000b"),"VSTEF",OpcodeType.VRX_VRRDU,"vector store word element","z13","zarch");
    public static final Opcode OP_VSTEG = new Opcode(DatatypeConverter.parseHexBinary("e7000000000a"),"VSTEG",OpcodeType.VRX_VRRDU,"vector store double word element","z13","zarch");
    public static final Opcode OP_VSTM = new Opcode(DatatypeConverter.parseHexBinary("e7000000003e"),"VSTM",OpcodeType.VRS_VVRD,"vector store multiple","z13","zarch");
    public static final Opcode OP_VSTL = new Opcode(DatatypeConverter.parseHexBinary("e7000000003f"),"VSTL",OpcodeType.VRS_VRRD,"vector store with length","z13","zarch");
    public static final Opcode OP_VUPH = new Opcode(DatatypeConverter.parseHexBinary("e700000000d7"),"VUPH",OpcodeType.VRR_VV0U,"vector unpack high","z13","zarch");
    public static final Opcode OP_VUPHB = new Opcode(DatatypeConverter.parseHexBinary("e700000000d7"),"VUPHB",OpcodeType.VRR_VV,"vector unpack high byte","z13","zarch");
    public static final Opcode OP_VUPHH = new Opcode(DatatypeConverter.parseHexBinary("e700000010d7"),"VUPHH",OpcodeType.VRR_VV,"vector unpack high halfword","z13","zarch");
    public static final Opcode OP_VUPHF = new Opcode(DatatypeConverter.parseHexBinary("e700000020d7"),"VUPHF",OpcodeType.VRR_VV,"vector unpack high word","z13","zarch");
    public static final Opcode OP_VUPLH = new Opcode(DatatypeConverter.parseHexBinary("e700000000d5"),"VUPLH",OpcodeType.VRR_VV0U,"vector unpack logical high","z13","zarch");
    public static final Opcode OP_VUPLHB = new Opcode(DatatypeConverter.parseHexBinary("e700000000d5"),"VUPLHB",OpcodeType.VRR_VV,"vector unpack logical high byte","z13","zarch");
    public static final Opcode OP_VUPLHH = new Opcode(DatatypeConverter.parseHexBinary("e700000010d5"),"VUPLHH",OpcodeType.VRR_VV,"vector unpack logical high halfword","z13","zarch");
    public static final Opcode OP_VUPLHF = new Opcode(DatatypeConverter.parseHexBinary("e700000020d5"),"VUPLHF",OpcodeType.VRR_VV,"vector unpack logical high word","z13","zarch");
    public static final Opcode OP_VUPL = new Opcode(DatatypeConverter.parseHexBinary("e700000000d6"),"VUPL",OpcodeType.VRR_VV0U,"vector unpack low","z13","zarch");
    public static final Opcode OP_VUPLB = new Opcode(DatatypeConverter.parseHexBinary("e700000000d6"),"VUPLB",OpcodeType.VRR_VV,"vector unpack low byte","z13","zarch");
    public static final Opcode OP_VUPLHW = new Opcode(DatatypeConverter.parseHexBinary("e700000010d6"),"VUPLHW",OpcodeType.VRR_VV,"vector unpack low halfword","z13","zarch");
    public static final Opcode OP_VUPLF = new Opcode(DatatypeConverter.parseHexBinary("e700000020d6"),"VUPLF",OpcodeType.VRR_VV,"vector unpack low word","z13","zarch");
    public static final Opcode OP_VUPLL = new Opcode(DatatypeConverter.parseHexBinary("e700000000d4"),"VUPLL",OpcodeType.VRR_VV0U,"vector unpack logical low","z13","zarch");
    public static final Opcode OP_VUPLLB = new Opcode(DatatypeConverter.parseHexBinary("e700000000d4"),"VUPLLB",OpcodeType.VRR_VV,"vector unpack logical low byte","z13","zarch");
    public static final Opcode OP_VUPLLH = new Opcode(DatatypeConverter.parseHexBinary("e700000010d4"),"VUPLLH",OpcodeType.VRR_VV,"vector unpack logical low halfword","z13","zarch");
    public static final Opcode OP_VUPLLF = new Opcode(DatatypeConverter.parseHexBinary("e700000020d4"),"VUPLLF",OpcodeType.VRR_VV,"vector unpack logical low word","z13","zarch");
    public static final Opcode OP_VA = new Opcode(DatatypeConverter.parseHexBinary("e700000000f3"),"VA",OpcodeType.VRR_VVV0U,"vector add","z13","zarch");
    public static final Opcode OP_VAB = new Opcode(DatatypeConverter.parseHexBinary("e700000000f3"),"VAB",OpcodeType.VRR_VVV,"vector add byte","z13","zarch");
    public static final Opcode OP_VAH = new Opcode(DatatypeConverter.parseHexBinary("e700000010f3"),"VAH",OpcodeType.VRR_VVV,"vector add halfword","z13","zarch");
    public static final Opcode OP_VAF = new Opcode(DatatypeConverter.parseHexBinary("e700000020f3"),"VAF",OpcodeType.VRR_VVV,"vector add word","z13","zarch");
    public static final Opcode OP_VAG = new Opcode(DatatypeConverter.parseHexBinary("e700000030f3"),"VAG",OpcodeType.VRR_VVV,"vector add double word","z13","zarch");
    public static final Opcode OP_VAQ = new Opcode(DatatypeConverter.parseHexBinary("e700000040f3"),"VAQ",OpcodeType.VRR_VVV,"vector add quad word","z13","zarch");
    public static final Opcode OP_VACC = new Opcode(DatatypeConverter.parseHexBinary("e700000000f1"),"VACC",OpcodeType.VRR_VVV0U,"vector add compute carry","z13","zarch");
    public static final Opcode OP_VACCB = new Opcode(DatatypeConverter.parseHexBinary("e700000000f1"),"VACCB",OpcodeType.VRR_VVV,"vector add compute carry byte","z13","zarch");
    public static final Opcode OP_VACCH = new Opcode(DatatypeConverter.parseHexBinary("e700000010f1"),"VACCH",OpcodeType.VRR_VVV,"vector add compute carry halfword","z13","zarch");
    public static final Opcode OP_VACCF = new Opcode(DatatypeConverter.parseHexBinary("e700000020f1"),"VACCF",OpcodeType.VRR_VVV,"vector add compute carry word","z13","zarch");
    public static final Opcode OP_VACCG = new Opcode(DatatypeConverter.parseHexBinary("e700000030f1"),"VACCG",OpcodeType.VRR_VVV,"vector add compute carry doubleword","z13","zarch");
    public static final Opcode OP_VACCQ = new Opcode(DatatypeConverter.parseHexBinary("e700000040f1"),"VACCQ",OpcodeType.VRR_VVV,"vector add compute carry quadword","z13","zarch");
    public static final Opcode OP_VAC = new Opcode(DatatypeConverter.parseHexBinary("e700000000bb"),"VAC",OpcodeType.VRR_VVVU0V,"vector add with carry","z13","zarch");
    public static final Opcode OP_VACQ = new Opcode(DatatypeConverter.parseHexBinary("e700040000bb"),"VACQ",OpcodeType.VRR_VVV0V,"vector add with carry quadword","z13","zarch");
    public static final Opcode OP_VACCC = new Opcode(DatatypeConverter.parseHexBinary("e700000000b9"),"VACCC",OpcodeType.VRR_VVVU0V,"vector add with carry compute carry","z13","zarch");
    public static final Opcode OP_VACCCQ = new Opcode(DatatypeConverter.parseHexBinary("e700040000b9"),"VACCCQ",OpcodeType.VRR_VVV0V,"vector add with carry compute carry quadword","z13","zarch");
    public static final Opcode OP_VN = new Opcode(DatatypeConverter.parseHexBinary("e70000000068"),"VN",OpcodeType.VRR_VVV,"vector and","z13","zarch");
    public static final Opcode OP_VNC = new Opcode(DatatypeConverter.parseHexBinary("e70000000069"),"VNC",OpcodeType.VRR_VVV,"vector and with complement","z13","zarch");
    public static final Opcode OP_VAVG = new Opcode(DatatypeConverter.parseHexBinary("e700000000f2"),"VAVG",OpcodeType.VRR_VVV0U,"vector average","z13","zarch");
    public static final Opcode OP_VAVGB = new Opcode(DatatypeConverter.parseHexBinary("e700000000f2"),"VAVGB",OpcodeType.VRR_VVV,"vector average byte","z13","zarch");
    public static final Opcode OP_VAVGH = new Opcode(DatatypeConverter.parseHexBinary("e700000010f2"),"VAVGH",OpcodeType.VRR_VVV,"vector average half word","z13","zarch");
    public static final Opcode OP_VAVGF = new Opcode(DatatypeConverter.parseHexBinary("e700000020f2"),"VAVGF",OpcodeType.VRR_VVV,"vector average word","z13","zarch");
    public static final Opcode OP_VAVGG = new Opcode(DatatypeConverter.parseHexBinary("e700000030f2"),"VAVGG",OpcodeType.VRR_VVV,"vector average double word","z13","zarch");
    public static final Opcode OP_VAVGL = new Opcode(DatatypeConverter.parseHexBinary("e700000000f0"),"VAVGL",OpcodeType.VRR_VVV0U,"vector average logical","z13","zarch");
    public static final Opcode OP_VAVGLB = new Opcode(DatatypeConverter.parseHexBinary("e700000000f0"),"VAVGLB",OpcodeType.VRR_VVV,"vector average logical byte","z13","zarch");
    public static final Opcode OP_VAVGLH = new Opcode(DatatypeConverter.parseHexBinary("e700000010f0"),"VAVGLH",OpcodeType.VRR_VVV,"vector average logical half word","z13","zarch");
    public static final Opcode OP_VAVGLF = new Opcode(DatatypeConverter.parseHexBinary("e700000020f0"),"VAVGLF",OpcodeType.VRR_VVV,"vector average logical word","z13","zarch");
    public static final Opcode OP_VAVGLG = new Opcode(DatatypeConverter.parseHexBinary("e700000030f0"),"VAVGLG",OpcodeType.VRR_VVV,"vector average logical double word","z13","zarch");
    public static final Opcode OP_VCKSM = new Opcode(DatatypeConverter.parseHexBinary("e70000000066"),"VCKSM",OpcodeType.VRR_VVV,"vector checksum","z13","zarch");
    public static final Opcode OP_VEC = new Opcode(DatatypeConverter.parseHexBinary("e700000000db"),"VEC",OpcodeType.VRR_VV0U,"vector element compare","z13","zarch");
    public static final Opcode OP_VECB = new Opcode(DatatypeConverter.parseHexBinary("e700000000db"),"VECB",OpcodeType.VRR_VV,"vector element compare byte","z13","zarch");
    public static final Opcode OP_VECH = new Opcode(DatatypeConverter.parseHexBinary("e700000010db"),"VECH",OpcodeType.VRR_VV,"vector element compare half word","z13","zarch");
    public static final Opcode OP_VECF = new Opcode(DatatypeConverter.parseHexBinary("e700000020db"),"VECF",OpcodeType.VRR_VV,"vector element compare word","z13","zarch");
    public static final Opcode OP_VECG = new Opcode(DatatypeConverter.parseHexBinary("e700000030db"),"VECG",OpcodeType.VRR_VV,"vector element compare double word","z13","zarch");
    public static final Opcode OP_VECL = new Opcode(DatatypeConverter.parseHexBinary("e700000000d9"),"VECL",OpcodeType.VRR_VV0U,"vector element compare logical","z13","zarch");
    public static final Opcode OP_VECLB = new Opcode(DatatypeConverter.parseHexBinary("e700000000d9"),"VECLB",OpcodeType.VRR_VV,"vector element compare logical byte","z13","zarch");
    public static final Opcode OP_VECLH = new Opcode(DatatypeConverter.parseHexBinary("e700000010d9"),"VECLH",OpcodeType.VRR_VV,"vector element compare logical half word","z13","zarch");
    public static final Opcode OP_VECLF = new Opcode(DatatypeConverter.parseHexBinary("e700000020d9"),"VECLF",OpcodeType.VRR_VV,"vector element compare logical word","z13","zarch");
    public static final Opcode OP_VECLG = new Opcode(DatatypeConverter.parseHexBinary("e700000030d9"),"VECLG",OpcodeType.VRR_VV,"vector element compare logical double word","z13","zarch");
    public static final Opcode OP_VCEQ = new Opcode(DatatypeConverter.parseHexBinary("e700000000f8"),"VCEQ",OpcodeType.VRR_VVV0U0U,"vector compare equal","z13","zarch");
    public static final Opcode OP_VCEQB = new Opcode(DatatypeConverter.parseHexBinary("e700000000f8"),"VCEQB",OpcodeType.VRR_VVV,"vector compare equal byte","z13","zarch");
    public static final Opcode OP_VCEQH = new Opcode(DatatypeConverter.parseHexBinary("e700000010f8"),"VCEQH",OpcodeType.VRR_VVV,"vector compare equal half word","z13","zarch");
    public static final Opcode OP_VCEQF = new Opcode(DatatypeConverter.parseHexBinary("e700000020f8"),"VCEQF",OpcodeType.VRR_VVV,"vector compare equal word","z13","zarch");
    public static final Opcode OP_VCEQG = new Opcode(DatatypeConverter.parseHexBinary("e700000030f8"),"VCEQG",OpcodeType.VRR_VVV,"vector compare equal double word","z13","zarch");
    public static final Opcode OP_VCEQBS = new Opcode(DatatypeConverter.parseHexBinary("e700001000f8"),"VCEQBS",OpcodeType.VRR_VVV,"vector compare equal byte","z13","zarch");
    public static final Opcode OP_VCEQHS = new Opcode(DatatypeConverter.parseHexBinary("e700001010f8"),"VCEQHS",OpcodeType.VRR_VVV,"vector compare equal half word","z13","zarch");
    public static final Opcode OP_VCEQFS = new Opcode(DatatypeConverter.parseHexBinary("e700001020f8"),"VCEQFS",OpcodeType.VRR_VVV,"vector compare equal word","z13","zarch");
    public static final Opcode OP_VCEQGS = new Opcode(DatatypeConverter.parseHexBinary("e700001030f8"),"VCEQGS",OpcodeType.VRR_VVV,"vector compare equal double word","z13","zarch");
    public static final Opcode OP_VCH = new Opcode(DatatypeConverter.parseHexBinary("e700000000fb"),"VCH",OpcodeType.VRR_VVV0U0U,"vector compare high","z13","zarch");
    public static final Opcode OP_VCHB = new Opcode(DatatypeConverter.parseHexBinary("e700000000fb"),"VCHB",OpcodeType.VRR_VVV,"vector compare high byte","z13","zarch");
    public static final Opcode OP_VCHH = new Opcode(DatatypeConverter.parseHexBinary("e700000010fb"),"VCHH",OpcodeType.VRR_VVV,"vector compare high half word","z13","zarch");
    public static final Opcode OP_VCHF = new Opcode(DatatypeConverter.parseHexBinary("e700000020fb"),"VCHF",OpcodeType.VRR_VVV,"vector compare high word","z13","zarch");
    public static final Opcode OP_VCHG = new Opcode(DatatypeConverter.parseHexBinary("e700000030fb"),"VCHG",OpcodeType.VRR_VVV,"vector compare high double word","z13","zarch");
    public static final Opcode OP_VCHBS = new Opcode(DatatypeConverter.parseHexBinary("e700001000fb"),"VCHBS",OpcodeType.VRR_VVV,"vector compare high byte","z13","zarch");
    public static final Opcode OP_VCHHS = new Opcode(DatatypeConverter.parseHexBinary("e700001010fb"),"VCHHS",OpcodeType.VRR_VVV,"vector compare high half word","z13","zarch");
    public static final Opcode OP_VCHFS = new Opcode(DatatypeConverter.parseHexBinary("e700001020fb"),"VCHFS",OpcodeType.VRR_VVV,"vector compare high word","z13","zarch");
    public static final Opcode OP_VCHGS = new Opcode(DatatypeConverter.parseHexBinary("e700001030fb"),"VCHGS",OpcodeType.VRR_VVV,"vector compare high double word","z13","zarch");
    public static final Opcode OP_VCHL = new Opcode(DatatypeConverter.parseHexBinary("e700000000f9"),"VCHL",OpcodeType.VRR_VVV0U0U,"vector compare high logical","z13","zarch");
    public static final Opcode OP_VCHLB = new Opcode(DatatypeConverter.parseHexBinary("e700000000f9"),"VCHLB",OpcodeType.VRR_VVV,"vector compare high logical byte","z13","zarch");
    public static final Opcode OP_VCHLH = new Opcode(DatatypeConverter.parseHexBinary("e700000010f9"),"VCHLH",OpcodeType.VRR_VVV,"vector compare high logical half word","z13","zarch");
    public static final Opcode OP_VCHLF = new Opcode(DatatypeConverter.parseHexBinary("e700000020f9"),"VCHLF",OpcodeType.VRR_VVV,"vector compare high logical word","z13","zarch");
    public static final Opcode OP_VCHLG = new Opcode(DatatypeConverter.parseHexBinary("e700000030f9"),"VCHLG",OpcodeType.VRR_VVV,"vector compare high logical double word","z13","zarch");
    public static final Opcode OP_VCHLBS = new Opcode(DatatypeConverter.parseHexBinary("e700001000f9"),"VCHLBS",OpcodeType.VRR_VVV,"vector compare high logical byte","z13","zarch");
    public static final Opcode OP_VCHLHS = new Opcode(DatatypeConverter.parseHexBinary("e700001010f9"),"VCHLHS",OpcodeType.VRR_VVV,"vector compare high logical half word","z13","zarch");
    public static final Opcode OP_VCHLFS = new Opcode(DatatypeConverter.parseHexBinary("e700001020f9"),"VCHLFS",OpcodeType.VRR_VVV,"vector compare high logical word","z13","zarch");
    public static final Opcode OP_VCHLGS = new Opcode(DatatypeConverter.parseHexBinary("e700001030f9"),"VCHLGS",OpcodeType.VRR_VVV,"vector compare high logical double word","z13","zarch");
    public static final Opcode OP_VCLZ = new Opcode(DatatypeConverter.parseHexBinary("e70000000053"),"VCLZ",OpcodeType.VRR_VV0U,"vector count leading zeros","z13","zarch");
    public static final Opcode OP_VCLZB = new Opcode(DatatypeConverter.parseHexBinary("e70000000053"),"VCLZB",OpcodeType.VRR_VV,"vector count leading zeros byte","z13","zarch");
    public static final Opcode OP_VCLZH = new Opcode(DatatypeConverter.parseHexBinary("e70000001053"),"VCLZH",OpcodeType.VRR_VV,"vector count leading zeros halfword","z13","zarch");
    public static final Opcode OP_VCLZF = new Opcode(DatatypeConverter.parseHexBinary("e70000002053"),"VCLZF",OpcodeType.VRR_VV,"vector count leading zeros word","z13","zarch");
    public static final Opcode OP_VCLZG = new Opcode(DatatypeConverter.parseHexBinary("e70000003053"),"VCLZG",OpcodeType.VRR_VV,"vector count leading zeros doubleword","z13","zarch");
    public static final Opcode OP_VCTZ = new Opcode(DatatypeConverter.parseHexBinary("e70000000052"),"VCTZ",OpcodeType.VRR_VV0U,"vector count trailing zeros","z13","zarch");
    public static final Opcode OP_VCTZB = new Opcode(DatatypeConverter.parseHexBinary("e70000000052"),"VCTZB",OpcodeType.VRR_VV,"vector count trailing zeros byte","z13","zarch");
    public static final Opcode OP_VCTZH = new Opcode(DatatypeConverter.parseHexBinary("e70000001052"),"VCTZH",OpcodeType.VRR_VV,"vector count trailing zeros halfword","z13","zarch");
    public static final Opcode OP_VCTZF = new Opcode(DatatypeConverter.parseHexBinary("e70000002052"),"VCTZF",OpcodeType.VRR_VV,"vector count trailing zeros word","z13","zarch");
    public static final Opcode OP_VCTZG = new Opcode(DatatypeConverter.parseHexBinary("e70000003052"),"VCTZG",OpcodeType.VRR_VV,"vector count trailing zeros doubleword","z13","zarch");
    public static final Opcode OP_VX = new Opcode(DatatypeConverter.parseHexBinary("e7000000006d"),"VX",OpcodeType.VRR_VVV,"vector exclusive or","z13","zarch");
    public static final Opcode OP_VGFM = new Opcode(DatatypeConverter.parseHexBinary("e700000000b4"),"VGFM",OpcodeType.VRR_VVV0U,"vector galois field multiply sum","z13","zarch");
    public static final Opcode OP_VGFMB = new Opcode(DatatypeConverter.parseHexBinary("e700000000b4"),"VGFMB",OpcodeType.VRR_VVV,"vector galois field multiply sum byte","z13","zarch");
    public static final Opcode OP_VGFMH = new Opcode(DatatypeConverter.parseHexBinary("e700000010b4"),"VGFMH",OpcodeType.VRR_VVV,"vector galois field multiply sum halfword","z13","zarch");
    public static final Opcode OP_VGFMF = new Opcode(DatatypeConverter.parseHexBinary("e700000020b4"),"VGFMF",OpcodeType.VRR_VVV,"vector galois field multiply sum word","z13","zarch");
    public static final Opcode OP_VGFMG = new Opcode(DatatypeConverter.parseHexBinary("e700000030b4"),"VGFMG",OpcodeType.VRR_VVV,"vector galois field multiply sum doubleword","z13","zarch");
    public static final Opcode OP_VGFMA = new Opcode(DatatypeConverter.parseHexBinary("e700000000bc"),"VGFMA",OpcodeType.VRR_VVVU0V,"vector galois field multiply sum and accumulate","z13","zarch");
    public static final Opcode OP_VGFMAB = new Opcode(DatatypeConverter.parseHexBinary("e700000000bc"),"VGFMAB",OpcodeType.VRR_VVV0V,"vector galois field multiply sum and accumulate byte","z13","zarch");
    public static final Opcode OP_VGFMAH = new Opcode(DatatypeConverter.parseHexBinary("e700010000bc"),"VGFMAH",OpcodeType.VRR_VVV0V,"vector galois field multiply sum and accumulate halfword","z13","zarch");
    public static final Opcode OP_VGFMAF = new Opcode(DatatypeConverter.parseHexBinary("e700020000bc"),"VGFMAF",OpcodeType.VRR_VVV0V,"vector galois field multiply sum and accumulate word","z13","zarch");
    public static final Opcode OP_VGFMAG = new Opcode(DatatypeConverter.parseHexBinary("e700030000bc"),"VGFMAG",OpcodeType.VRR_VVV0V,"vector galois field multiply sum and accumulate doubleword","z13","zarch");
    public static final Opcode OP_VLC = new Opcode(DatatypeConverter.parseHexBinary("e700000000de"),"VLC",OpcodeType.VRR_VV0U,"vector load complement","z13","zarch");
    public static final Opcode OP_VLCB = new Opcode(DatatypeConverter.parseHexBinary("e700000000de"),"VLCB",OpcodeType.VRR_VV,"vector load complement byte","z13","zarch");
    public static final Opcode OP_VLCH = new Opcode(DatatypeConverter.parseHexBinary("e700000010de"),"VLCH",OpcodeType.VRR_VV,"vector load complement halfword","z13","zarch");
    public static final Opcode OP_VLCF = new Opcode(DatatypeConverter.parseHexBinary("e700000020de"),"VLCF",OpcodeType.VRR_VV,"vector load complement word","z13","zarch");
    public static final Opcode OP_VLCG = new Opcode(DatatypeConverter.parseHexBinary("e700000030de"),"VLCG",OpcodeType.VRR_VV,"vector load complement doubleword","z13","zarch");
    public static final Opcode OP_VLP = new Opcode(DatatypeConverter.parseHexBinary("e700000000df"),"VLP",OpcodeType.VRR_VV0U,"vector load positive","z13","zarch");
    public static final Opcode OP_VLPB = new Opcode(DatatypeConverter.parseHexBinary("e700000000df"),"VLPB",OpcodeType.VRR_VV,"vector load positive byte","z13","zarch");
    public static final Opcode OP_VLPH = new Opcode(DatatypeConverter.parseHexBinary("e700000010df"),"VLPH",OpcodeType.VRR_VV,"vector load positive halfword","z13","zarch");
    public static final Opcode OP_VLPF = new Opcode(DatatypeConverter.parseHexBinary("e700000020df"),"VLPF",OpcodeType.VRR_VV,"vector load positive word","z13","zarch");
    public static final Opcode OP_VLPG = new Opcode(DatatypeConverter.parseHexBinary("e700000030df"),"VLPG",OpcodeType.VRR_VV,"vector load positive doubleword","z13","zarch");
    public static final Opcode OP_VMX = new Opcode(DatatypeConverter.parseHexBinary("e700000000ff"),"VMX",OpcodeType.VRR_VVV0U,"vector maximum","z13","zarch");
    public static final Opcode OP_VMXB = new Opcode(DatatypeConverter.parseHexBinary("e700000000ff"),"VMXB",OpcodeType.VRR_VVV,"vector maximum byte","z13","zarch");
    public static final Opcode OP_VMXH = new Opcode(DatatypeConverter.parseHexBinary("e700000010ff"),"VMXH",OpcodeType.VRR_VVV,"vector maximum halfword","z13","zarch");
    public static final Opcode OP_VMXF = new Opcode(DatatypeConverter.parseHexBinary("e700000020ff"),"VMXF",OpcodeType.VRR_VVV,"vector maximum word","z13","zarch");
    public static final Opcode OP_VMXG = new Opcode(DatatypeConverter.parseHexBinary("e700000030ff"),"VMXG",OpcodeType.VRR_VVV,"vector maximum doubleword","z13","zarch");
    public static final Opcode OP_VMXL = new Opcode(DatatypeConverter.parseHexBinary("e700000000fd"),"VMXL",OpcodeType.VRR_VVV0U,"vector maximum logical","z13","zarch");
    public static final Opcode OP_VMXLB = new Opcode(DatatypeConverter.parseHexBinary("e700000000fd"),"VMXLB",OpcodeType.VRR_VVV,"vector maximum logical byte","z13","zarch");
    public static final Opcode OP_VMXLH = new Opcode(DatatypeConverter.parseHexBinary("e700000010fd"),"VMXLH",OpcodeType.VRR_VVV,"vector maximum logical halfword","z13","zarch");
    public static final Opcode OP_VMXLF = new Opcode(DatatypeConverter.parseHexBinary("e700000020fd"),"VMXLF",OpcodeType.VRR_VVV,"vector maximum logical word","z13","zarch");
    public static final Opcode OP_VMXLG = new Opcode(DatatypeConverter.parseHexBinary("e700000030fd"),"VMXLG",OpcodeType.VRR_VVV,"vector maximum logical doubleword","z13","zarch");
    public static final Opcode OP_VMN = new Opcode(DatatypeConverter.parseHexBinary("e700000000fe"),"VMN",OpcodeType.VRR_VVV0U,"vector minimum","z13","zarch");
    public static final Opcode OP_VMNB = new Opcode(DatatypeConverter.parseHexBinary("e700000000fe"),"VMNB",OpcodeType.VRR_VVV,"vector minimum byte","z13","zarch");
    public static final Opcode OP_VMNH = new Opcode(DatatypeConverter.parseHexBinary("e700000010fe"),"VMNH",OpcodeType.VRR_VVV,"vector minimum halfword","z13","zarch");
    public static final Opcode OP_VMNF = new Opcode(DatatypeConverter.parseHexBinary("e700000020fe"),"VMNF",OpcodeType.VRR_VVV,"vector minimum word","z13","zarch");
    public static final Opcode OP_VMNG = new Opcode(DatatypeConverter.parseHexBinary("e700000030fe"),"VMNG",OpcodeType.VRR_VVV,"vector minimum doubleword","z13","zarch");
    public static final Opcode OP_VMNL = new Opcode(DatatypeConverter.parseHexBinary("e700000000fc"),"VMNL",OpcodeType.VRR_VVV0U,"vector minimum logical","z13","zarch");
    public static final Opcode OP_VMNLB = new Opcode(DatatypeConverter.parseHexBinary("e700000000fc"),"VMNLB",OpcodeType.VRR_VVV,"vector minimum logical byte","z13","zarch");
    public static final Opcode OP_VMNLH = new Opcode(DatatypeConverter.parseHexBinary("e700000010fc"),"VMNLH",OpcodeType.VRR_VVV,"vector minimum logical halfword","z13","zarch");
    public static final Opcode OP_VMNLF = new Opcode(DatatypeConverter.parseHexBinary("e700000020fc"),"VMNLF",OpcodeType.VRR_VVV,"vector minimum logical word","z13","zarch");
    public static final Opcode OP_VMNLG = new Opcode(DatatypeConverter.parseHexBinary("e700000030fc"),"VMNLG",OpcodeType.VRR_VVV,"vector minimum logical doubleword","z13","zarch");
    public static final Opcode OP_VMAL = new Opcode(DatatypeConverter.parseHexBinary("e700000000aa"),"VMAL",OpcodeType.VRR_VVVU0V,"vector multiply and add low","z13","zarch");
    public static final Opcode OP_VMALB = new Opcode(DatatypeConverter.parseHexBinary("e700000000aa"),"VMALB",OpcodeType.VRR_VVV0V,"vector multiply and add low byte","z13","zarch");
    public static final Opcode OP_VMALHW = new Opcode(DatatypeConverter.parseHexBinary("e700010000aa"),"VMALHW",OpcodeType.VRR_VVV0V,"vector multiply and add low halfword","z13","zarch");
    public static final Opcode OP_VMALF = new Opcode(DatatypeConverter.parseHexBinary("e700020000aa"),"VMALF",OpcodeType.VRR_VVV0V,"vector multiply and add low word","z13","zarch");
    public static final Opcode OP_VMAH = new Opcode(DatatypeConverter.parseHexBinary("e700000000ab"),"VMAH",OpcodeType.VRR_VVVU0V,"vector multiply and add high","z13","zarch");
    public static final Opcode OP_VMAHB = new Opcode(DatatypeConverter.parseHexBinary("e700000000ab"),"VMAHB",OpcodeType.VRR_VVV0V,"vector multiply and add high byte","z13","zarch");
    public static final Opcode OP_VMAHH = new Opcode(DatatypeConverter.parseHexBinary("e700010000ab"),"VMAHH",OpcodeType.VRR_VVV0V,"vector multiply and add high halfword","z13","zarch");
    public static final Opcode OP_VMAHF = new Opcode(DatatypeConverter.parseHexBinary("e700020000ab"),"VMAHF",OpcodeType.VRR_VVV0V,"vector multiply and add high word","z13","zarch");
    public static final Opcode OP_VMALH = new Opcode(DatatypeConverter.parseHexBinary("e700000000a9"),"VMALH",OpcodeType.VRR_VVVU0V,"vector multiply and add logical high","z13","zarch");
    public static final Opcode OP_VMALHB = new Opcode(DatatypeConverter.parseHexBinary("e700000000a9"),"VMALHB",OpcodeType.VRR_VVV0V,"vector multiply and add logical high byte","z13","zarch");
    public static final Opcode OP_VMALHH = new Opcode(DatatypeConverter.parseHexBinary("e700010000a9"),"VMALHH",OpcodeType.VRR_VVV0V,"vector multiply and add logical high halfword","z13","zarch");
    public static final Opcode OP_VMALHF = new Opcode(DatatypeConverter.parseHexBinary("e700020000a9"),"VMALHF",OpcodeType.VRR_VVV0V,"vector multiply and add logical high word","z13","zarch");
    public static final Opcode OP_VMAE = new Opcode(DatatypeConverter.parseHexBinary("e700000000ae"),"VMAE",OpcodeType.VRR_VVVU0V,"vector multiply and add even","z13","zarch");
    public static final Opcode OP_VMAEB = new Opcode(DatatypeConverter.parseHexBinary("e700000000ae"),"VMAEB",OpcodeType.VRR_VVV0V,"vector multiply and add even byte","z13","zarch");
    public static final Opcode OP_VMAEH = new Opcode(DatatypeConverter.parseHexBinary("e700010000ae"),"VMAEH",OpcodeType.VRR_VVV0V,"vector multiply and add even halfword","z13","zarch");
    public static final Opcode OP_VMAEF = new Opcode(DatatypeConverter.parseHexBinary("e700020000ae"),"VMAEF",OpcodeType.VRR_VVV0V,"vector multiply and add even word","z13","zarch");
    public static final Opcode OP_VMALE = new Opcode(DatatypeConverter.parseHexBinary("e700000000ac"),"VMALE",OpcodeType.VRR_VVVU0V,"vector multiply and add logical even","z13","zarch");
    public static final Opcode OP_VMALEB = new Opcode(DatatypeConverter.parseHexBinary("e700000000ac"),"VMALEB",OpcodeType.VRR_VVV0V,"vector multiply and add logical even byte","z13","zarch");
    public static final Opcode OP_VMALEH = new Opcode(DatatypeConverter.parseHexBinary("e700010000ac"),"VMALEH",OpcodeType.VRR_VVV0V,"vector multiply and add logical even halfword","z13","zarch");
    public static final Opcode OP_VMALEF = new Opcode(DatatypeConverter.parseHexBinary("e700020000ac"),"VMALEF",OpcodeType.VRR_VVV0V,"vector multiply and add logical even word","z13","zarch");
    public static final Opcode OP_VMAO = new Opcode(DatatypeConverter.parseHexBinary("e700000000af"),"VMAO",OpcodeType.VRR_VVVU0V,"vector multiply and add odd","z13","zarch");
    public static final Opcode OP_VMAOB = new Opcode(DatatypeConverter.parseHexBinary("e700000000af"),"VMAOB",OpcodeType.VRR_VVV0V,"vector multiply and add odd byte","z13","zarch");
    public static final Opcode OP_VMAOH = new Opcode(DatatypeConverter.parseHexBinary("e700010000af"),"VMAOH",OpcodeType.VRR_VVV0V,"vector multiply and add odd halfword","z13","zarch");
    public static final Opcode OP_VMAOF = new Opcode(DatatypeConverter.parseHexBinary("e700020000af"),"VMAOF",OpcodeType.VRR_VVV0V,"vector multiply and add odd word","z13","zarch");
    public static final Opcode OP_VMALO = new Opcode(DatatypeConverter.parseHexBinary("e700000000ad"),"VMALO",OpcodeType.VRR_VVVU0V,"vector multiply and add logical odd","z13","zarch");
    public static final Opcode OP_VMALOB = new Opcode(DatatypeConverter.parseHexBinary("e700000000ad"),"VMALOB",OpcodeType.VRR_VVV0V,"vector multiply and add logical odd byte","z13","zarch");
    public static final Opcode OP_VMALOH = new Opcode(DatatypeConverter.parseHexBinary("e700010000ad"),"VMALOH",OpcodeType.VRR_VVV0V,"vector multiply and add logical odd halfword","z13","zarch");
    public static final Opcode OP_VMALOF = new Opcode(DatatypeConverter.parseHexBinary("e700020000ad"),"VMALOF",OpcodeType.VRR_VVV0V,"vector multiply and add logical odd word","z13","zarch");
    public static final Opcode OP_VMH = new Opcode(DatatypeConverter.parseHexBinary("e700000000a3"),"VMH",OpcodeType.VRR_VVV0U,"vector multiply high","z13","zarch");
    public static final Opcode OP_VMHB = new Opcode(DatatypeConverter.parseHexBinary("e700000000a3"),"VMHB",OpcodeType.VRR_VVV,"vector multiply high byte","z13","zarch");
    public static final Opcode OP_VMHH = new Opcode(DatatypeConverter.parseHexBinary("e700000010a3"),"VMHH",OpcodeType.VRR_VVV,"vector multiply high halfword","z13","zarch");
    public static final Opcode OP_VMHF = new Opcode(DatatypeConverter.parseHexBinary("e700000020a3"),"VMHF",OpcodeType.VRR_VVV,"vector multiply high word","z13","zarch");
    public static final Opcode OP_VMLH = new Opcode(DatatypeConverter.parseHexBinary("e700000000a1"),"VMLH",OpcodeType.VRR_VVV0U,"vector multiply logical high","z13","zarch");
    public static final Opcode OP_VMLHB = new Opcode(DatatypeConverter.parseHexBinary("e700000000a1"),"VMLHB",OpcodeType.VRR_VVV,"vector multiply logical high byte","z13","zarch");
    public static final Opcode OP_VMLHH = new Opcode(DatatypeConverter.parseHexBinary("e700000010a1"),"VMLHH",OpcodeType.VRR_VVV,"vector multiply logical high halfword","z13","zarch");
    public static final Opcode OP_VMLHF = new Opcode(DatatypeConverter.parseHexBinary("e700000020a1"),"VMLHF",OpcodeType.VRR_VVV,"vector multiply logical high word","z13","zarch");
    public static final Opcode OP_VML = new Opcode(DatatypeConverter.parseHexBinary("e700000000a2"),"VML",OpcodeType.VRR_VVV0U,"vector multiply low","z13","zarch");
    public static final Opcode OP_VMLB = new Opcode(DatatypeConverter.parseHexBinary("e700000000a2"),"VMLB",OpcodeType.VRR_VVV,"vector multiply low byte","z13","zarch");
    public static final Opcode OP_VMLHW = new Opcode(DatatypeConverter.parseHexBinary("e700000010a2"),"VMLHW",OpcodeType.VRR_VVV,"vector multiply low halfword","z13","zarch");
    public static final Opcode OP_VMLF = new Opcode(DatatypeConverter.parseHexBinary("e700000020a2"),"VMLF",OpcodeType.VRR_VVV,"vector multiply low word","z13","zarch");
    public static final Opcode OP_VME = new Opcode(DatatypeConverter.parseHexBinary("e700000000a6"),"VME",OpcodeType.VRR_VVV0U,"vector multiply even","z13","zarch");
    public static final Opcode OP_VMEB = new Opcode(DatatypeConverter.parseHexBinary("e700000000a6"),"VMEB",OpcodeType.VRR_VVV,"vector multiply even byte","z13","zarch");
    public static final Opcode OP_VMEH = new Opcode(DatatypeConverter.parseHexBinary("e700000010a6"),"VMEH",OpcodeType.VRR_VVV,"vector multiply even halfword","z13","zarch");
    public static final Opcode OP_VMEF = new Opcode(DatatypeConverter.parseHexBinary("e700000020a6"),"VMEF",OpcodeType.VRR_VVV,"vector multiply even word","z13","zarch");
    public static final Opcode OP_VMLE = new Opcode(DatatypeConverter.parseHexBinary("e700000000a4"),"VMLE",OpcodeType.VRR_VVV0U,"vector multiply logical even","z13","zarch");
    public static final Opcode OP_VMLEB = new Opcode(DatatypeConverter.parseHexBinary("e700000000a4"),"VMLEB",OpcodeType.VRR_VVV,"vector multiply logical even byte","z13","zarch");
    public static final Opcode OP_VMLEH = new Opcode(DatatypeConverter.parseHexBinary("e700000010a4"),"VMLEH",OpcodeType.VRR_VVV,"vector multiply logical even halfword","z13","zarch");
    public static final Opcode OP_VMLEF = new Opcode(DatatypeConverter.parseHexBinary("e700000020a4"),"VMLEF",OpcodeType.VRR_VVV,"vector multiply logical even word","z13","zarch");
    public static final Opcode OP_VMO = new Opcode(DatatypeConverter.parseHexBinary("e700000000a7"),"VMO",OpcodeType.VRR_VVV0U,"vector multiply odd","z13","zarch");
    public static final Opcode OP_VMOB = new Opcode(DatatypeConverter.parseHexBinary("e700000000a7"),"VMOB",OpcodeType.VRR_VVV,"vector multiply odd byte","z13","zarch");
    public static final Opcode OP_VMOH = new Opcode(DatatypeConverter.parseHexBinary("e700000010a7"),"VMOH",OpcodeType.VRR_VVV,"vector multiply odd halfword","z13","zarch");
    public static final Opcode OP_VMOF = new Opcode(DatatypeConverter.parseHexBinary("e700000020a7"),"VMOF",OpcodeType.VRR_VVV,"vector multiply odd word","z13","zarch");
    public static final Opcode OP_VMLO = new Opcode(DatatypeConverter.parseHexBinary("e700000000a5"),"VMLO",OpcodeType.VRR_VVV0U,"vector multiply logical odd","z13","zarch");
    public static final Opcode OP_VMLOB = new Opcode(DatatypeConverter.parseHexBinary("e700000000a5"),"VMLOB",OpcodeType.VRR_VVV,"vector multiply logical odd byte","z13","zarch");
    public static final Opcode OP_VMLOH = new Opcode(DatatypeConverter.parseHexBinary("e700000010a5"),"VMLOH",OpcodeType.VRR_VVV,"vector multiply logical odd halfword","z13","zarch");
    public static final Opcode OP_VMLOF = new Opcode(DatatypeConverter.parseHexBinary("e700000020a5"),"VMLOF",OpcodeType.VRR_VVV,"vector multiply logical odd word","z13","zarch");
    public static final Opcode OP_VNO = new Opcode(DatatypeConverter.parseHexBinary("e7000000006b"),"VNO",OpcodeType.VRR_VVV,"vector nor","z13","zarch");
    public static final Opcode OP_VNOT = new Opcode(DatatypeConverter.parseHexBinary("e7000000006b"),"VNOT",OpcodeType.VRR_VVV2,"vector not","z13","zarch");
    public static final Opcode OP_VO = new Opcode(DatatypeConverter.parseHexBinary("e7000000006a"),"VO",OpcodeType.VRR_VVV,"vector or","z13","zarch");
    public static final Opcode OP_VPOPCT = new Opcode(DatatypeConverter.parseHexBinary("e70000000050"),"VPOPCT",OpcodeType.VRR_VV0U,"vector population count","z13","zarch");
    public static final Opcode OP_VERLLV = new Opcode(DatatypeConverter.parseHexBinary("e70000000073"),"VERLLV",OpcodeType.VRR_VVV0U,"vector element rotate left logical reg","z13","zarch");
    public static final Opcode OP_VERLLVB = new Opcode(DatatypeConverter.parseHexBinary("e70000000073"),"VERLLVB",OpcodeType.VRR_VVV,"vector element rotate left logical reg byte","z13","zarch");
    public static final Opcode OP_VERLLVH = new Opcode(DatatypeConverter.parseHexBinary("e70000001073"),"VERLLVH",OpcodeType.VRR_VVV,"vector element rotate left logical reg halfword","z13","zarch");
    public static final Opcode OP_VERLLVF = new Opcode(DatatypeConverter.parseHexBinary("e70000002073"),"VERLLVF",OpcodeType.VRR_VVV,"vector element rotate left logical reg word","z13","zarch");
    public static final Opcode OP_VERLLVG = new Opcode(DatatypeConverter.parseHexBinary("e70000003073"),"VERLLVG",OpcodeType.VRR_VVV,"vector element rotate left logical reg doubleword","z13","zarch");
    public static final Opcode OP_VERLL = new Opcode(DatatypeConverter.parseHexBinary("e70000000033"),"VERLL",OpcodeType.VRS_VVRDU,"vector element rotate left logical mem","z13","zarch");
    public static final Opcode OP_VERLLB = new Opcode(DatatypeConverter.parseHexBinary("e70000000033"),"VERLLB",OpcodeType.VRS_VVRD,"vector element rotate left logical mem byte","z13","zarch");
    public static final Opcode OP_VERLLH = new Opcode(DatatypeConverter.parseHexBinary("e70000001033"),"VERLLH",OpcodeType.VRS_VVRD,"vector element rotate left logical mem halfword","z13","zarch");
    public static final Opcode OP_VERLLF = new Opcode(DatatypeConverter.parseHexBinary("e70000002033"),"VERLLF",OpcodeType.VRS_VVRD,"vector element rotate left logical mem word","z13","zarch");
    public static final Opcode OP_VERLLG = new Opcode(DatatypeConverter.parseHexBinary("e70000003033"),"VERLLG",OpcodeType.VRS_VVRD,"vector element rotate left logical mem doubleword","z13","zarch");
    public static final Opcode OP_VERIM = new Opcode(DatatypeConverter.parseHexBinary("e70000000072"),"VERIM",OpcodeType.VRI_VVV0UU,"vector element rotate and insert under mask","z13","zarch");
    public static final Opcode OP_VERIMB = new Opcode(DatatypeConverter.parseHexBinary("e70000000072"),"VERIMB",OpcodeType.VRI_VVV0U,"vector element rotate and insert under mask byte","z13","zarch");
    public static final Opcode OP_VERIMH = new Opcode(DatatypeConverter.parseHexBinary("e70000001072"),"VERIMH",OpcodeType.VRI_VVV0U,"vector element rotate and insert under mask halfword","z13","zarch");
    public static final Opcode OP_VERIMF = new Opcode(DatatypeConverter.parseHexBinary("e70000002072"),"VERIMF",OpcodeType.VRI_VVV0U,"vector element rotate and insert under mask word","z13","zarch");
    public static final Opcode OP_VERIMG = new Opcode(DatatypeConverter.parseHexBinary("e70000003072"),"VERIMG",OpcodeType.VRI_VVV0U,"vector element rotate and insert under mask doubleword","z13","zarch");
    public static final Opcode OP_VESLV = new Opcode(DatatypeConverter.parseHexBinary("e70000000070"),"VESLV",OpcodeType.VRR_VVV0U,"vector element shift left reg","z13","zarch");
    public static final Opcode OP_VESLVB = new Opcode(DatatypeConverter.parseHexBinary("e70000000070"),"VESLVB",OpcodeType.VRR_VVV,"vector element shift left reg byte","z13","zarch");
    public static final Opcode OP_VESLVH = new Opcode(DatatypeConverter.parseHexBinary("e70000001070"),"VESLVH",OpcodeType.VRR_VVV,"vector element shift left reg halfword","z13","zarch");
    public static final Opcode OP_VESLVF = new Opcode(DatatypeConverter.parseHexBinary("e70000002070"),"VESLVF",OpcodeType.VRR_VVV,"vector element shift left reg word","z13","zarch");
    public static final Opcode OP_VESLVG = new Opcode(DatatypeConverter.parseHexBinary("e70000003070"),"VESLVG",OpcodeType.VRR_VVV,"vector element shift left reg doubleword","z13","zarch");
    public static final Opcode OP_VESL = new Opcode(DatatypeConverter.parseHexBinary("e70000000030"),"VESL",OpcodeType.VRS_VVRDU,"vector element shift left mem","z13","zarch");
    public static final Opcode OP_VESLB = new Opcode(DatatypeConverter.parseHexBinary("e70000000030"),"VESLB",OpcodeType.VRS_VVRD,"vector element shift left mem byte","z13","zarch");
    public static final Opcode OP_VESLH = new Opcode(DatatypeConverter.parseHexBinary("e70000001030"),"VESLH",OpcodeType.VRS_VVRD,"vector element shift left mem halfword","z13","zarch");
    public static final Opcode OP_VESLF = new Opcode(DatatypeConverter.parseHexBinary("e70000002030"),"VESLF",OpcodeType.VRS_VVRD,"vector element shift left mem word","z13","zarch");
    public static final Opcode OP_VESLG = new Opcode(DatatypeConverter.parseHexBinary("e70000003030"),"VESLG",OpcodeType.VRS_VVRD,"vector element shift left mem doubleword","z13","zarch");
    public static final Opcode OP_VESRAV = new Opcode(DatatypeConverter.parseHexBinary("e7000000007a"),"VESRAV",OpcodeType.VRR_VVV0U,"vector element shift right arithmetic reg","z13","zarch");
    public static final Opcode OP_VESRAVB = new Opcode(DatatypeConverter.parseHexBinary("e7000000007a"),"VESRAVB",OpcodeType.VRR_VVV,"vector element shift right arithmetic reg byte","z13","zarch");
    public static final Opcode OP_VESRAVH = new Opcode(DatatypeConverter.parseHexBinary("e7000000107a"),"VESRAVH",OpcodeType.VRR_VVV,"vector element shift right arithmetic reg halfword","z13","zarch");
    public static final Opcode OP_VESRAVF = new Opcode(DatatypeConverter.parseHexBinary("e7000000207a"),"VESRAVF",OpcodeType.VRR_VVV,"vector element shift right arithmetic reg word","z13","zarch");
    public static final Opcode OP_VESRAVG = new Opcode(DatatypeConverter.parseHexBinary("e7000000307a"),"VESRAVG",OpcodeType.VRR_VVV,"vector element shift right arithmetic reg doubleword","z13","zarch");
    public static final Opcode OP_VESRA = new Opcode(DatatypeConverter.parseHexBinary("e7000000003a"),"VESRA",OpcodeType.VRS_VVRDU,"vector element shift right arithmetic mem","z13","zarch");
    public static final Opcode OP_VESRAB = new Opcode(DatatypeConverter.parseHexBinary("e7000000003a"),"VESRAB",OpcodeType.VRS_VVRD,"vector element shift right arithmetic mem byte","z13","zarch");
    public static final Opcode OP_VESRAH = new Opcode(DatatypeConverter.parseHexBinary("e7000000103a"),"VESRAH",OpcodeType.VRS_VVRD,"vector element shift right arithmetic mem halfword","z13","zarch");
    public static final Opcode OP_VESRAF = new Opcode(DatatypeConverter.parseHexBinary("e7000000203a"),"VESRAF",OpcodeType.VRS_VVRD,"vector element shift right arithmetic mem word","z13","zarch");
    public static final Opcode OP_VESRAG = new Opcode(DatatypeConverter.parseHexBinary("e7000000303a"),"VESRAG",OpcodeType.VRS_VVRD,"vector element shift right arithmetic mem doubleword","z13","zarch");
    public static final Opcode OP_VESRLV = new Opcode(DatatypeConverter.parseHexBinary("e70000000078"),"VESRLV",OpcodeType.VRR_VVV0U,"vector element shift right logical reg","z13","zarch");
    public static final Opcode OP_VESRLVB = new Opcode(DatatypeConverter.parseHexBinary("e70000000078"),"VESRLVB",OpcodeType.VRR_VVV,"vector element shift right logical reg byte","z13","zarch");
    public static final Opcode OP_VESRLVH = new Opcode(DatatypeConverter.parseHexBinary("e70000001078"),"VESRLVH",OpcodeType.VRR_VVV,"vector element shift right logical reg halfword","z13","zarch");
    public static final Opcode OP_VESRLVF = new Opcode(DatatypeConverter.parseHexBinary("e70000002078"),"VESRLVF",OpcodeType.VRR_VVV,"vector element shift right logical reg word","z13","zarch");
    public static final Opcode OP_VESRLVG = new Opcode(DatatypeConverter.parseHexBinary("e70000003078"),"VESRLVG",OpcodeType.VRR_VVV,"vector element shift right logical reg doubleword","z13","zarch");
    public static final Opcode OP_VESRL = new Opcode(DatatypeConverter.parseHexBinary("e70000000038"),"VESRL",OpcodeType.VRS_VVRDU,"vector element shift right logical mem","z13","zarch");
    public static final Opcode OP_VESRLB = new Opcode(DatatypeConverter.parseHexBinary("e70000000038"),"VESRLB",OpcodeType.VRS_VVRD,"vector element shift right logical mem byte","z13","zarch");
    public static final Opcode OP_VESRLH = new Opcode(DatatypeConverter.parseHexBinary("e70000001038"),"VESRLH",OpcodeType.VRS_VVRD,"vector element shift right logical mem halfword","z13","zarch");
    public static final Opcode OP_VESRLF = new Opcode(DatatypeConverter.parseHexBinary("e70000002038"),"VESRLF",OpcodeType.VRS_VVRD,"vector element shift right logical mem word","z13","zarch");
    public static final Opcode OP_VESRLG = new Opcode(DatatypeConverter.parseHexBinary("e70000003038"),"VESRLG",OpcodeType.VRS_VVRD,"vector element shift right logical mem doubleword","z13","zarch");
    public static final Opcode OP_VSL = new Opcode(DatatypeConverter.parseHexBinary("e70000000074"),"VSL",OpcodeType.VRR_VVV,"vector shift left","z13","zarch");
    public static final Opcode OP_VSLB = new Opcode(DatatypeConverter.parseHexBinary("e70000000075"),"VSLB",OpcodeType.VRR_VVV,"vector shift left by byte","z13","zarch");
    public static final Opcode OP_VSLDB = new Opcode(DatatypeConverter.parseHexBinary("e70000000077"),"VSLDB",OpcodeType.VRI_VVV0U,"vector shift left double by byte","z13","zarch");
    public static final Opcode OP_VSRA = new Opcode(DatatypeConverter.parseHexBinary("e7000000007e"),"VSRA",OpcodeType.VRR_VVV,"vector shift right arithmetic","z13","zarch");
    public static final Opcode OP_VSRAB = new Opcode(DatatypeConverter.parseHexBinary("e7000000007f"),"VSRAB",OpcodeType.VRR_VVV,"vector shift right arithmetic by byte","z13","zarch");
    public static final Opcode OP_VSRL = new Opcode(DatatypeConverter.parseHexBinary("e7000000007c"),"VSRL",OpcodeType.VRR_VVV,"vector shift right logical","z13","zarch");
    public static final Opcode OP_VSRLB = new Opcode(DatatypeConverter.parseHexBinary("e7000000007d"),"VSRLB",OpcodeType.VRR_VVV,"vector shift right logical by byte","z13","zarch");
    public static final Opcode OP_VS = new Opcode(DatatypeConverter.parseHexBinary("e700000000f7"),"VS",OpcodeType.VRR_VVV0U,"vector subtract","z13","zarch");
    public static final Opcode OP_VSB = new Opcode(DatatypeConverter.parseHexBinary("e700000000f7"),"VSB",OpcodeType.VRR_VVV,"vector subtract byte","z13","zarch");
    public static final Opcode OP_VSH = new Opcode(DatatypeConverter.parseHexBinary("e700000010f7"),"VSH",OpcodeType.VRR_VVV,"vector subtract halfword","z13","zarch");
    public static final Opcode OP_VSF = new Opcode(DatatypeConverter.parseHexBinary("e700000020f7"),"VSF",OpcodeType.VRR_VVV,"vector subtract word","z13","zarch");
    public static final Opcode OP_VSG = new Opcode(DatatypeConverter.parseHexBinary("e700000030f7"),"VSG",OpcodeType.VRR_VVV,"vector subtract doubleword","z13","zarch");
    public static final Opcode OP_VSQ = new Opcode(DatatypeConverter.parseHexBinary("e700000040f7"),"VSQ",OpcodeType.VRR_VVV,"vector subtract quadword","z13","zarch");
    public static final Opcode OP_VSCBI = new Opcode(DatatypeConverter.parseHexBinary("e700000000f5"),"VSCBI",OpcodeType.VRR_VVV0U,"vector subtract compute borrow indication","z13","zarch");
    public static final Opcode OP_VSCBIB = new Opcode(DatatypeConverter.parseHexBinary("e700000000f5"),"VSCBIB",OpcodeType.VRR_VVV,"vector subtract compute borrow indication byte","z13","zarch");
    public static final Opcode OP_VSCBIH = new Opcode(DatatypeConverter.parseHexBinary("e700000010f5"),"VSCBIH",OpcodeType.VRR_VVV,"vector subtract compute borrow indication halfword","z13","zarch");
    public static final Opcode OP_VSCBIF = new Opcode(DatatypeConverter.parseHexBinary("e700000020f5"),"VSCBIF",OpcodeType.VRR_VVV,"vector subtract compute borrow indication word","z13","zarch");
    public static final Opcode OP_VSCBIG = new Opcode(DatatypeConverter.parseHexBinary("e700000030f5"),"VSCBIG",OpcodeType.VRR_VVV,"vector subtract compute borrow indication doubleword","z13","zarch");
    public static final Opcode OP_VSCBIQ = new Opcode(DatatypeConverter.parseHexBinary("e700000040f5"),"VSCBIQ",OpcodeType.VRR_VVV,"vector subtract compute borrow indication quadword","z13","zarch");
    public static final Opcode OP_VSBI = new Opcode(DatatypeConverter.parseHexBinary("e700000000bf"),"VSBI",OpcodeType.VRR_VVVU0V,"vector subtract with borrow indication","z13","zarch");
    public static final Opcode OP_VSBIQ = new Opcode(DatatypeConverter.parseHexBinary("e700040000bf"),"VSBIQ",OpcodeType.VRR_VVV0V,"vector subtract with borrow indication quadword","z13","zarch");
    public static final Opcode OP_VSBCBI = new Opcode(DatatypeConverter.parseHexBinary("e700000000bd"),"VSBCBI",OpcodeType.VRR_VVVU0V,"vector subtract with borrow compute borrow indication","z13","zarch");
    public static final Opcode OP_VSBCBIQ = new Opcode(DatatypeConverter.parseHexBinary("e700040000bd"),"VSBCBIQ",OpcodeType.VRR_VVV0V,"vector subtract with borrow compute borrow indication quadword","z13","zarch");
    public static final Opcode OP_VSUMG = new Opcode(DatatypeConverter.parseHexBinary("e70000000065"),"VSUMG",OpcodeType.VRR_VVV0U,"vector sum across doubleword","z13","zarch");
    public static final Opcode OP_VSUMGH = new Opcode(DatatypeConverter.parseHexBinary("e70000001065"),"VSUMGH",OpcodeType.VRR_VVV,"vector sum across doubleword - halfword","z13","zarch");
    public static final Opcode OP_VSUMGF = new Opcode(DatatypeConverter.parseHexBinary("e70000002065"),"VSUMGF",OpcodeType.VRR_VVV,"vector sum across doubleword - word","z13","zarch");
    public static final Opcode OP_VSUMQ = new Opcode(DatatypeConverter.parseHexBinary("e70000000067"),"VSUMQ",OpcodeType.VRR_VVV0U,"vector sum across quadword","z13","zarch");
    public static final Opcode OP_VSUMQF = new Opcode(DatatypeConverter.parseHexBinary("e70000002067"),"VSUMQF",OpcodeType.VRR_VVV,"vector sum across quadword - word elements","z13","zarch");
    public static final Opcode OP_VSUMQG = new Opcode(DatatypeConverter.parseHexBinary("e70000003067"),"VSUMQG",OpcodeType.VRR_VVV,"vector sum across quadword - doubleword elements","z13","zarch");
    public static final Opcode OP_VSUM = new Opcode(DatatypeConverter.parseHexBinary("e70000000064"),"VSUM",OpcodeType.VRR_VVV0U,"vector sum across word","z13","zarch");
    public static final Opcode OP_VSUMB = new Opcode(DatatypeConverter.parseHexBinary("e70000000064"),"VSUMB",OpcodeType.VRR_VVV,"vector sum across word - byte elements","z13","zarch");
    public static final Opcode OP_VSUMH = new Opcode(DatatypeConverter.parseHexBinary("e70000001064"),"VSUMH",OpcodeType.VRR_VVV,"vector sum across word - halfword elements","z13","zarch");
    public static final Opcode OP_VTM = new Opcode(DatatypeConverter.parseHexBinary("e700000000d8"),"VTM",OpcodeType.VRR_VV,"vector test under mask","z13","zarch");
    public static final Opcode OP_VFAE = new Opcode(DatatypeConverter.parseHexBinary("e70000000082"),"VFAE",OpcodeType.VRR_VVV0U0U,"vector find any element equal","z13","zarch");
    public static final Opcode OP_VFAEB = new Opcode(DatatypeConverter.parseHexBinary("e70000000082"),"VFAEB",OpcodeType.VRR_VVV0U0,"vector find any element equal byte","z13","zarch");
    public static final Opcode OP_VFAEH = new Opcode(DatatypeConverter.parseHexBinary("e70000001082"),"VFAEH",OpcodeType.VRR_VVV0U0,"vector find any element equal halfword","z13","zarch");
    public static final Opcode OP_VFAEF = new Opcode(DatatypeConverter.parseHexBinary("e70000002082"),"VFAEF",OpcodeType.VRR_VVV0U0,"vector find any element equal word","z13","zarch");
    public static final Opcode OP_VFAEBS = new Opcode(DatatypeConverter.parseHexBinary("e70000100082"),"VFAEBS",OpcodeType.VRR_VVV0U1,"vector find any element equal","z13","zarch");
    public static final Opcode OP_VFAEHS = new Opcode(DatatypeConverter.parseHexBinary("e70000101082"),"VFAEHS",OpcodeType.VRR_VVV0U1,"vector find any element equal","z13","zarch");
    public static final Opcode OP_VFAEFS = new Opcode(DatatypeConverter.parseHexBinary("e70000102082"),"VFAEFS",OpcodeType.VRR_VVV0U1,"vector find any element equal","z13","zarch");
    public static final Opcode OP_VFAEZB = new Opcode(DatatypeConverter.parseHexBinary("e70000200082"),"VFAEZB",OpcodeType.VRR_VVV0U2,"vector find any element equal","z13","zarch");
    public static final Opcode OP_VFAEZH = new Opcode(DatatypeConverter.parseHexBinary("e70000201082"),"VFAEZH",OpcodeType.VRR_VVV0U2,"vector find any element equal","z13","zarch");
    public static final Opcode OP_VFAEZF = new Opcode(DatatypeConverter.parseHexBinary("e70000202082"),"VFAEZF",OpcodeType.VRR_VVV0U2,"vector find any element equal","z13","zarch");
    public static final Opcode OP_VFAEZBS = new Opcode(DatatypeConverter.parseHexBinary("e70000300082"),"VFAEZBS",OpcodeType.VRR_VVV0U3,"vector find any element equal","z13","zarch");
    public static final Opcode OP_VFAEZHS = new Opcode(DatatypeConverter.parseHexBinary("e70000301082"),"VFAEZHS",OpcodeType.VRR_VVV0U3,"vector find any element equal","z13","zarch");
    public static final Opcode OP_VFAEZFS = new Opcode(DatatypeConverter.parseHexBinary("e70000302082"),"VFAEZFS",OpcodeType.VRR_VVV0U3,"vector find any element equal","z13","zarch");
    public static final Opcode OP_VFEE = new Opcode(DatatypeConverter.parseHexBinary("e70000000080"),"VFEE",OpcodeType.VRR_VVV0U0U,"vector find element equal","z13","zarch");
    public static final Opcode OP_VFEEB = new Opcode(DatatypeConverter.parseHexBinary("e70000000080"),"VFEEB",OpcodeType.VRR_VVV0U0,"vector find element equal byte","z13","zarch");
    public static final Opcode OP_VFEEH = new Opcode(DatatypeConverter.parseHexBinary("e70000001080"),"VFEEH",OpcodeType.VRR_VVV0U0,"vector find element equal halfword","z13","zarch");
    public static final Opcode OP_VFEEF = new Opcode(DatatypeConverter.parseHexBinary("e70000002080"),"VFEEF",OpcodeType.VRR_VVV0U0,"vector find element equal word","z13","zarch");
    public static final Opcode OP_VFEEBS = new Opcode(DatatypeConverter.parseHexBinary("e70000100080"),"VFEEBS",OpcodeType.VRR_VVV,"vector find element equal byte","z13","zarch");
    public static final Opcode OP_VFEEHS = new Opcode(DatatypeConverter.parseHexBinary("e70000101080"),"VFEEHS",OpcodeType.VRR_VVV,"vector find element equal halfword","z13","zarch");
    public static final Opcode OP_VFEEFS = new Opcode(DatatypeConverter.parseHexBinary("e70000102080"),"VFEEFS",OpcodeType.VRR_VVV,"vector find element equal word","z13","zarch");
    public static final Opcode OP_VFEEZB = new Opcode(DatatypeConverter.parseHexBinary("e70000200080"),"VFEEZB",OpcodeType.VRR_VVV,"vector find element equal byte","z13","zarch");
    public static final Opcode OP_VFEEZH = new Opcode(DatatypeConverter.parseHexBinary("e70000201080"),"VFEEZH",OpcodeType.VRR_VVV,"vector find element equal halfword","z13","zarch");
    public static final Opcode OP_VFEEZF = new Opcode(DatatypeConverter.parseHexBinary("e70000202080"),"VFEEZF",OpcodeType.VRR_VVV,"vector find element equal word","z13","zarch");
    public static final Opcode OP_VFEEZBS = new Opcode(DatatypeConverter.parseHexBinary("e70000300080"),"VFEEZBS",OpcodeType.VRR_VVV,"vector find element equal byte","z13","zarch");
    public static final Opcode OP_VFEEZHS = new Opcode(DatatypeConverter.parseHexBinary("e70000301080"),"VFEEZHS",OpcodeType.VRR_VVV,"vector find element equal halfword","z13","zarch");
    public static final Opcode OP_VFEEZFS = new Opcode(DatatypeConverter.parseHexBinary("e70000302080"),"VFEEZFS",OpcodeType.VRR_VVV,"vector find element equal word","z13","zarch");
    public static final Opcode OP_VFENE = new Opcode(DatatypeConverter.parseHexBinary("e70000000081"),"VFENE",OpcodeType.VRR_VVV0U0U,"vector find element not equal","z13","zarch");
    public static final Opcode OP_VFENEB = new Opcode(DatatypeConverter.parseHexBinary("e70000000081"),"VFENEB",OpcodeType.VRR_VVV0U0,"vector find element not equal byte","z13","zarch");
    public static final Opcode OP_VFENEH = new Opcode(DatatypeConverter.parseHexBinary("e70000001081"),"VFENEH",OpcodeType.VRR_VVV0U0,"vector find element not equal halfword","z13","zarch");
    public static final Opcode OP_VFENEF = new Opcode(DatatypeConverter.parseHexBinary("e70000002081"),"VFENEF",OpcodeType.VRR_VVV0U0,"vector find element not equal word","z13","zarch");
    public static final Opcode OP_VFENEBS = new Opcode(DatatypeConverter.parseHexBinary("e70000100081"),"VFENEBS",OpcodeType.VRR_VVV,"vector find element not equal byte","z13","zarch");
    public static final Opcode OP_VFENEHS = new Opcode(DatatypeConverter.parseHexBinary("e70000101081"),"VFENEHS",OpcodeType.VRR_VVV,"vector find element not equal halfword","z13","zarch");
    public static final Opcode OP_VFENEFS = new Opcode(DatatypeConverter.parseHexBinary("e70000102081"),"VFENEFS",OpcodeType.VRR_VVV,"vector find element not equal word","z13","zarch");
    public static final Opcode OP_VFENEZB = new Opcode(DatatypeConverter.parseHexBinary("e70000200081"),"VFENEZB",OpcodeType.VRR_VVV,"vector find element not equal byte","z13","zarch");
    public static final Opcode OP_VFENEZH = new Opcode(DatatypeConverter.parseHexBinary("e70000201081"),"VFENEZH",OpcodeType.VRR_VVV,"vector find element not equal halfword","z13","zarch");
    public static final Opcode OP_VFENEZF = new Opcode(DatatypeConverter.parseHexBinary("e70000202081"),"VFENEZF",OpcodeType.VRR_VVV,"vector find element not equal word","z13","zarch");
    public static final Opcode OP_VFENEZBS = new Opcode(DatatypeConverter.parseHexBinary("e70000300081"),"VFENEZBS",OpcodeType.VRR_VVV,"vector find element not equal byte","z13","zarch");
    public static final Opcode OP_VFENEZHS = new Opcode(DatatypeConverter.parseHexBinary("e70000301081"),"VFENEZHS",OpcodeType.VRR_VVV,"vector find element not equal halfword","z13","zarch");
    public static final Opcode OP_VFENEZFS = new Opcode(DatatypeConverter.parseHexBinary("e70000302081"),"VFENEZFS",OpcodeType.VRR_VVV,"vector find element not equal word","z13","zarch");
    public static final Opcode OP_VISTR = new Opcode(DatatypeConverter.parseHexBinary("e7000000005c"),"VISTR",OpcodeType.VRR_VV0U0U,"vector isolate string","z13","zarch");
    public static final Opcode OP_VISTRB = new Opcode(DatatypeConverter.parseHexBinary("e7000000005c"),"VISTRB",OpcodeType.VRR_VV0U2,"vector isolate string byte","z13","zarch");
    public static final Opcode OP_VISTRH = new Opcode(DatatypeConverter.parseHexBinary("e7000000105c"),"VISTRH",OpcodeType.VRR_VV0U2,"vector isolate string halfword","z13","zarch");
    public static final Opcode OP_VISTRF = new Opcode(DatatypeConverter.parseHexBinary("e7000000205c"),"VISTRF",OpcodeType.VRR_VV0U2,"vector isolate string word","z13","zarch");
    public static final Opcode OP_VISTRBS = new Opcode(DatatypeConverter.parseHexBinary("e7000010005c"),"VISTRBS",OpcodeType.VRR_VV,"vector isolate string byte","z13","zarch");
    public static final Opcode OP_VISTRHS = new Opcode(DatatypeConverter.parseHexBinary("e7000010105c"),"VISTRHS",OpcodeType.VRR_VV,"vector isolate string halfword","z13","zarch");
    public static final Opcode OP_VISTRFS = new Opcode(DatatypeConverter.parseHexBinary("e7000010205c"),"VISTRFS",OpcodeType.VRR_VV,"vector isolate string word","z13","zarch");
    public static final Opcode OP_VSTRC = new Opcode(DatatypeConverter.parseHexBinary("e7000000008a"),"VSTRC",OpcodeType.VRR_VVVUU0V,"vector string range compare","z13","zarch");
    public static final Opcode OP_VSTRCB = new Opcode(DatatypeConverter.parseHexBinary("e7000000008a"),"VSTRCB",OpcodeType.VRR_VVVU0VB,"vector string range compare byte","z13","zarch");
    public static final Opcode OP_VSTRCH = new Opcode(DatatypeConverter.parseHexBinary("e7000100008a"),"VSTRCH",OpcodeType.VRR_VVVU0VB,"vector string range compare halfword","z13","zarch");
    public static final Opcode OP_VSTRCF = new Opcode(DatatypeConverter.parseHexBinary("e7000200008a"),"VSTRCF",OpcodeType.VRR_VVVU0VB,"vector string range compare word","z13","zarch");
    public static final Opcode OP_VSTRCBS = new Opcode(DatatypeConverter.parseHexBinary("e7000010008a"),"VSTRCBS",OpcodeType.VRR_VVVU0VB1,"vector string range compare byte","z13","zarch");
    public static final Opcode OP_VSTRCHS = new Opcode(DatatypeConverter.parseHexBinary("e7000110008a"),"VSTRCHS",OpcodeType.VRR_VVVU0VB1,"vector string range compare halfword","z13","zarch");
    public static final Opcode OP_VSTRCFS = new Opcode(DatatypeConverter.parseHexBinary("e7000210008a"),"VSTRCFS",OpcodeType.VRR_VVVU0VB1,"vector string range compare word","z13","zarch");
    public static final Opcode OP_VSTRCZB = new Opcode(DatatypeConverter.parseHexBinary("e7000020008a"),"VSTRCZB",OpcodeType.VRR_VVVU0VB2,"vector string range compare byte","z13","zarch");
    public static final Opcode OP_VSTRCZH = new Opcode(DatatypeConverter.parseHexBinary("e7000120008a"),"VSTRCZH",OpcodeType.VRR_VVVU0VB2,"vector string range compare halfword","z13","zarch");
    public static final Opcode OP_VSTRCZF = new Opcode(DatatypeConverter.parseHexBinary("e7000220008a"),"VSTRCZF",OpcodeType.VRR_VVVU0VB2,"vector string range compare word","z13","zarch");
    public static final Opcode OP_VSTRCZBS = new Opcode(DatatypeConverter.parseHexBinary("e7000030008a"),"VSTRCZBS",OpcodeType.VRR_VVVU0VB3,"vector string range compare byte","z13","zarch");
    public static final Opcode OP_VSTRCZHS = new Opcode(DatatypeConverter.parseHexBinary("e7000130008a"),"VSTRCZHS",OpcodeType.VRR_VVVU0VB3,"vector string range compare halfword","z13","zarch");
    public static final Opcode OP_VSTRCZFS = new Opcode(DatatypeConverter.parseHexBinary("e7000230008a"),"VSTRCZFS",OpcodeType.VRR_VVVU0VB3,"vector string range compare word","z13","zarch");
    public static final Opcode OP_VFA = new Opcode(DatatypeConverter.parseHexBinary("e700000000e3"),"VFA",OpcodeType.VRR_VVV0UU,"vector fp add","z13","zarch");
    public static final Opcode OP_VFADB = new Opcode(DatatypeConverter.parseHexBinary("e700000030e3"),"VFADB",OpcodeType.VRR_VVV,"vector fp add","z13","zarch");
    public static final Opcode OP_WFADB = new Opcode(DatatypeConverter.parseHexBinary("e700000830e3"),"WFADB",OpcodeType.VRR_VVV,"vector fp add","z13","zarch");
    public static final Opcode OP_WFC = new Opcode(DatatypeConverter.parseHexBinary("e700000000cb"),"WFC",OpcodeType.VRR_VV0UU2,"vector fp compare scalar","z13","zarch");
    public static final Opcode OP_WFCDB = new Opcode(DatatypeConverter.parseHexBinary("e700000030cb"),"WFCDB",OpcodeType.VRR_VV,"vector fp compare scalar","z13","zarch");
    public static final Opcode OP_WFK = new Opcode(DatatypeConverter.parseHexBinary("e700000000ca"),"WFK",OpcodeType.VRR_VV0UU2,"vector fp compare and signal scalar","z13","zarch");
    public static final Opcode OP_WFKDB = new Opcode(DatatypeConverter.parseHexBinary("e700000030ca"),"WFKDB",OpcodeType.VRR_VV,"vector fp compare and signal scalar","z13","zarch");
    public static final Opcode OP_VFCE = new Opcode(DatatypeConverter.parseHexBinary("e700000000e8"),"VFCE",OpcodeType.VRR_VVV0UUU,"vector fp compare equal","z13","zarch");
    public static final Opcode OP_VFCEDB = new Opcode(DatatypeConverter.parseHexBinary("e700000030e8"),"VFCEDB",OpcodeType.VRR_VVV,"vector fp compare equal","z13","zarch");
    public static final Opcode OP_VFCEDBS = new Opcode(DatatypeConverter.parseHexBinary("e700001030e8"),"VFCEDBS",OpcodeType.VRR_VVV,"vector fp compare equal","z13","zarch");
    public static final Opcode OP_WFCEDB = new Opcode(DatatypeConverter.parseHexBinary("e700000830e8"),"WFCEDB",OpcodeType.VRR_VVV,"vector fp compare equal","z13","zarch");
    public static final Opcode OP_WFCEDBS = new Opcode(DatatypeConverter.parseHexBinary("e700001830e8"),"WFCEDBS",OpcodeType.VRR_VVV,"vector fp compare equal","z13","zarch");
    public static final Opcode OP_VFCH = new Opcode(DatatypeConverter.parseHexBinary("e700000000eb"),"VFCH",OpcodeType.VRR_VVV0UUU,"vector fp compare high","z13","zarch");
    public static final Opcode OP_VFCHDB = new Opcode(DatatypeConverter.parseHexBinary("e700000030eb"),"VFCHDB",OpcodeType.VRR_VVV,"vector fp compare high","z13","zarch");
    public static final Opcode OP_VFCHDBS = new Opcode(DatatypeConverter.parseHexBinary("e700001030eb"),"VFCHDBS",OpcodeType.VRR_VVV,"vector fp compare high","z13","zarch");
    public static final Opcode OP_WFCHDB = new Opcode(DatatypeConverter.parseHexBinary("e700000830eb"),"WFCHDB",OpcodeType.VRR_VVV,"vector fp compare high","z13","zarch");
    public static final Opcode OP_WFCHDBS = new Opcode(DatatypeConverter.parseHexBinary("e700001830eb"),"WFCHDBS",OpcodeType.VRR_VVV,"vector fp compare high","z13","zarch");
    public static final Opcode OP_VFCHE = new Opcode(DatatypeConverter.parseHexBinary("e700000000ea"),"VFCHE",OpcodeType.VRR_VVV0UUU,"vector fp compare high or equal","z13","zarch");
    public static final Opcode OP_VFCHEDB = new Opcode(DatatypeConverter.parseHexBinary("e700000030ea"),"VFCHEDB",OpcodeType.VRR_VVV,"vector fp compare high or equal","z13","zarch");
    public static final Opcode OP_VFCHEDBS = new Opcode(DatatypeConverter.parseHexBinary("e700001030ea"),"VFCHEDBS",OpcodeType.VRR_VVV,"vector fp compare high or equal","z13","zarch");
    public static final Opcode OP_WFCHEDB = new Opcode(DatatypeConverter.parseHexBinary("e700000830ea"),"WFCHEDB",OpcodeType.VRR_VVV,"vector fp compare high or equal","z13","zarch");
    public static final Opcode OP_WFCHEDBS = new Opcode(DatatypeConverter.parseHexBinary("e700001830ea"),"WFCHEDBS",OpcodeType.VRR_VVV,"vector fp compare high or equal","z13","zarch");
    public static final Opcode OP_VCDG = new Opcode(DatatypeConverter.parseHexBinary("e700000000c3"),"VCDG",OpcodeType.VRR_VV0UUU,"vector fp convert from fixed 64 bit","z13","zarch");
    public static final Opcode OP_VCDGB = new Opcode(DatatypeConverter.parseHexBinary("e700000030c3"),"VCDGB",OpcodeType.VRR_VV0UU,"vector fp convert from fixed 64 bit","z13","zarch");
    public static final Opcode OP_WCDGB = new Opcode(DatatypeConverter.parseHexBinary("e700000830c3"),"WCDGB",OpcodeType.VRR_VV0UU8,"vector fp convert from fixed 64 bit","z13","zarch");
    public static final Opcode OP_VCDLG = new Opcode(DatatypeConverter.parseHexBinary("e700000000c1"),"VCDLG",OpcodeType.VRR_VV0UUU,"vector fp convert from logical 64 bit","z13","zarch");
    public static final Opcode OP_VCDLGB = new Opcode(DatatypeConverter.parseHexBinary("e700000030c1"),"VCDLGB",OpcodeType.VRR_VV0UU,"vector fp convert from logical 64 bit","z13","zarch");
    public static final Opcode OP_WCDLGB = new Opcode(DatatypeConverter.parseHexBinary("e700000830c1"),"WCDLGB",OpcodeType.VRR_VV0UU8,"vector fp convert from logical 64 bit","z13","zarch");
    public static final Opcode OP_VCGD = new Opcode(DatatypeConverter.parseHexBinary("e700000000c2"),"VCGD",OpcodeType.VRR_VV0UUU,"vector fp convert to fixed 64 bit","z13","zarch");
    public static final Opcode OP_VCGDB = new Opcode(DatatypeConverter.parseHexBinary("e700000030c2"),"VCGDB",OpcodeType.VRR_VV0UU,"vector fp convert to fixed 64 bit","z13","zarch");
    public static final Opcode OP_WCGDB = new Opcode(DatatypeConverter.parseHexBinary("e700000830c2"),"WCGDB",OpcodeType.VRR_VV0UU8,"vector fp convert to fixed 64 bit","z13","zarch");
    public static final Opcode OP_VCLGD = new Opcode(DatatypeConverter.parseHexBinary("e700000000c0"),"VCLGD",OpcodeType.VRR_VV0UUU,"vector fp convert to logical 64 bit","z13","zarch");
    public static final Opcode OP_VCLGDB = new Opcode(DatatypeConverter.parseHexBinary("e700000030c0"),"VCLGDB",OpcodeType.VRR_VV0UU,"vector fp convert to logical 64 bit","z13","zarch");
    public static final Opcode OP_WCLGDB = new Opcode(DatatypeConverter.parseHexBinary("e700000830c0"),"WCLGDB",OpcodeType.VRR_VV0UU8,"vector fp convert to logical 64 bit","z13","zarch");
    public static final Opcode OP_VFD = new Opcode(DatatypeConverter.parseHexBinary("e700000000e5"),"VFD",OpcodeType.VRR_VVV0UU,"vector fp divide","z13","zarch");
    public static final Opcode OP_VFDDB = new Opcode(DatatypeConverter.parseHexBinary("e700000030e5"),"VFDDB",OpcodeType.VRR_VVV,"vector fp divide","z13","zarch");
    public static final Opcode OP_WFDDB = new Opcode(DatatypeConverter.parseHexBinary("e700000830e5"),"WFDDB",OpcodeType.VRR_VVV,"vector fp divide","z13","zarch");
    public static final Opcode OP_VFI = new Opcode(DatatypeConverter.parseHexBinary("e700000000c7"),"VFI",OpcodeType.VRR_VV0UUU,"vector load fp integer","z13","zarch");
    public static final Opcode OP_VFIDB = new Opcode(DatatypeConverter.parseHexBinary("e700000030c7"),"VFIDB",OpcodeType.VRR_VV0UU,"vector load fp integer","z13","zarch");
    public static final Opcode OP_WFIDB = new Opcode(DatatypeConverter.parseHexBinary("e700000830c7"),"WFIDB",OpcodeType.VRR_VV0UU8,"vector load fp integer","z13","zarch");
    public static final Opcode OP_VLDE = new Opcode(DatatypeConverter.parseHexBinary("e700000000c4"),"VLDE",OpcodeType.VRR_VV0UU2,"vector fp load lengthened","z13","zarch");
    public static final Opcode OP_VLDEB = new Opcode(DatatypeConverter.parseHexBinary("e700000020c4"),"VLDEB",OpcodeType.VRR_VV,"vector fp load lengthened","z13","zarch");
    public static final Opcode OP_WLDEB = new Opcode(DatatypeConverter.parseHexBinary("e700000820c4"),"WLDEB",OpcodeType.VRR_VV,"vector fp load lengthened","z13","zarch");
    public static final Opcode OP_VLED = new Opcode(DatatypeConverter.parseHexBinary("e700000000c5"),"VLED",OpcodeType.VRR_VV0UUU,"vector fp load rounded","z13","zarch");
    public static final Opcode OP_VLEDB = new Opcode(DatatypeConverter.parseHexBinary("e700000030c5"),"VLEDB",OpcodeType.VRR_VV0UU,"vector fp load rounded","z13","zarch");
    public static final Opcode OP_WLEDB = new Opcode(DatatypeConverter.parseHexBinary("e700000830c5"),"WLEDB",OpcodeType.VRR_VV0UU8,"vector fp load rounded","z13","zarch");
    public static final Opcode OP_VFM = new Opcode(DatatypeConverter.parseHexBinary("e700000000e7"),"VFM",OpcodeType.VRR_VVV0UU,"vector fp multiply","z13","zarch");
    public static final Opcode OP_VFMDB = new Opcode(DatatypeConverter.parseHexBinary("e700000030e7"),"VFMDB",OpcodeType.VRR_VVV,"vector fp multiply","z13","zarch");
    public static final Opcode OP_WFMDB = new Opcode(DatatypeConverter.parseHexBinary("e700000830e7"),"WFMDB",OpcodeType.VRR_VVV,"vector fp multiply","z13","zarch");
    public static final Opcode OP_VFMA = new Opcode(DatatypeConverter.parseHexBinary("e7000000008f"),"VFMA",OpcodeType.VRR_VVVU0UV,"vector fp multiply and add","z13","zarch");
    public static final Opcode OP_VFMADB = new Opcode(DatatypeConverter.parseHexBinary("e7000300008f"),"VFMADB",OpcodeType.VRR_VVVV,"vector fp multiply and add","z13","zarch");
    public static final Opcode OP_WFMADB = new Opcode(DatatypeConverter.parseHexBinary("e7000308008f"),"WFMADB",OpcodeType.VRR_VVVV,"vector fp multiply and add","z13","zarch");
    public static final Opcode OP_VFMS = new Opcode(DatatypeConverter.parseHexBinary("e7000000008e"),"VFMS",OpcodeType.VRR_VVVU0UV,"vector fp multiply and subtract","z13","zarch");
    public static final Opcode OP_VFMSDB = new Opcode(DatatypeConverter.parseHexBinary("e7000300008e"),"VFMSDB",OpcodeType.VRR_VVVV,"vector fp multiply and subtract","z13","zarch");
    public static final Opcode OP_WFMSDB = new Opcode(DatatypeConverter.parseHexBinary("e7000308008e"),"WFMSDB",OpcodeType.VRR_VVVV,"vector fp multiply and subtract","z13","zarch");
    public static final Opcode OP_VFPSO = new Opcode(DatatypeConverter.parseHexBinary("e700000000cc"),"VFPSO",OpcodeType.VRR_VV0UUU,"vector fp perform sign operation","z13","zarch");
    public static final Opcode OP_VFPSODB = new Opcode(DatatypeConverter.parseHexBinary("e700000030cc"),"VFPSODB",OpcodeType.VRR_VV0U2,"vector fp perform sign operation","z13","zarch");
    public static final Opcode OP_WFPSODB = new Opcode(DatatypeConverter.parseHexBinary("e700000830cc"),"WFPSODB",OpcodeType.VRR_VV0U2,"vector fp perform sign operation","z13","zarch");
    public static final Opcode OP_VFLCDB = new Opcode(DatatypeConverter.parseHexBinary("e700000030cc"),"VFLCDB",OpcodeType.VRR_VV,"vector fp perform sign operation","z13","zarch");
    public static final Opcode OP_WFLCDB = new Opcode(DatatypeConverter.parseHexBinary("e700000830cc"),"WFLCDB",OpcodeType.VRR_VV,"vector fp perform sign operation","z13","zarch");
    public static final Opcode OP_VFLNDB = new Opcode(DatatypeConverter.parseHexBinary("e700001030cc"),"VFLNDB",OpcodeType.VRR_VV,"vector fp perform sign operation","z13","zarch");
    public static final Opcode OP_WFLNDB = new Opcode(DatatypeConverter.parseHexBinary("e700001830cc"),"WFLNDB",OpcodeType.VRR_VV,"vector fp perform sign operation","z13","zarch");
    public static final Opcode OP_VFLPDB = new Opcode(DatatypeConverter.parseHexBinary("e700002030cc"),"VFLPDB",OpcodeType.VRR_VV,"vector fp perform sign operation","z13","zarch");
    public static final Opcode OP_WFLPDB = new Opcode(DatatypeConverter.parseHexBinary("e700002830cc"),"WFLPDB",OpcodeType.VRR_VV,"vector fp perform sign operation","z13","zarch");
    public static final Opcode OP_VFSQ = new Opcode(DatatypeConverter.parseHexBinary("e700000000ce"),"VFSQ",OpcodeType.VRR_VV0UU2,"vector fp square root","z13","zarch");
    public static final Opcode OP_VFSQDB = new Opcode(DatatypeConverter.parseHexBinary("e700000030ce"),"VFSQDB",OpcodeType.VRR_VV,"vector fp square root","z13","zarch");
    public static final Opcode OP_WFSQDB = new Opcode(DatatypeConverter.parseHexBinary("e700000830ce"),"WFSQDB",OpcodeType.VRR_VV,"vector fp square root","z13","zarch");
    public static final Opcode OP_VFS = new Opcode(DatatypeConverter.parseHexBinary("e700000000e2"),"VFS",OpcodeType.VRR_VVV0UU,"vector fp subtract","z13","zarch");
    public static final Opcode OP_VFSDB = new Opcode(DatatypeConverter.parseHexBinary("e700000030e2"),"VFSDB",OpcodeType.VRR_VVV,"vector fp subtract","z13","zarch");
    public static final Opcode OP_WFSDB = new Opcode(DatatypeConverter.parseHexBinary("e700000830e2"),"WFSDB",OpcodeType.VRR_VVV,"vector fp subtract","z13","zarch");
    public static final Opcode OP_VFTCI = new Opcode(DatatypeConverter.parseHexBinary("e7000000004a"),"VFTCI",OpcodeType.VRI_VVUUU,"vector fp test data class immediate","z13","zarch");
    public static final Opcode OP_VFTCIDB = new Opcode(DatatypeConverter.parseHexBinary("e7000000304a"),"VFTCIDB",OpcodeType.VRI_VVU2,"vector fp test data class immediate","z13","zarch");
    public static final Opcode OP_WFTCIDB = new Opcode(DatatypeConverter.parseHexBinary("e7000008304a"),"WFTCIDB",OpcodeType.VRI_VVU2,"vector fp test data class immediate","z13","zarch");
    public static final Opcode OP_CDPT = new Opcode(DatatypeConverter.parseHexBinary("ed00000000ae"),"CDPT",OpcodeType.RSL_LRDFU,"convert from packed to long dfp","z13","zarch");
    public static final Opcode OP_CXPT = new Opcode(DatatypeConverter.parseHexBinary("ed00000000af"),"CXPT",OpcodeType.RSL_LRDFEU,"convert from packed to extended dfp","z13","zarch");
    public static final Opcode OP_CPDT = new Opcode(DatatypeConverter.parseHexBinary("ed00000000ac"),"CPDT",OpcodeType.RSL_LRDFU,"convert from long dfp to packed","z13","zarch");
    public static final Opcode OP_CPXT = new Opcode(DatatypeConverter.parseHexBinary("ed00000000ad"),"CPXT",OpcodeType.RSL_LRDFEU,"convert from extended dfp to packed","z13","zarch");
    public static final Opcode OP_LOCFHR = new Opcode(DatatypeConverter.parseHexBinary("b9e0"),"LOCFHR",OpcodeType.RRF_U0RR,"load high on condition from gpr","z13","zarch");
    public static final Opcode OP_LOCFH = new Opcode(DatatypeConverter.parseHexBinary("eb00000000e0"),"LOCFH",OpcodeType.RSY_RURD2,"load high on condition from memory","z13","zarch");
    public static final Opcode OP_LOCHI = new Opcode(DatatypeConverter.parseHexBinary("ec0000000042"),"LOCHI",OpcodeType.RIE_RUI0,"load halfword immediate on condition into 32 bit gpr","z13","zarch");
    public static final Opcode OP_LOCGHI = new Opcode(DatatypeConverter.parseHexBinary("ec0000000046"),"LOCGHI",OpcodeType.RIE_RUI0,"load halfword immediate on condition into 64 bit gpr","z13","zarch");
    public static final Opcode OP_LOCHHI = new Opcode(DatatypeConverter.parseHexBinary("ec000000004e"),"LOCHHI",OpcodeType.RIE_RUI0,"load halfword high immediate on condition","z13","zarch");
    public static final Opcode OP_STOCFH = new Opcode(DatatypeConverter.parseHexBinary("eb00000000e1"),"STOCFH",OpcodeType.RSY_RURD2,"store high on condition","z13","zarch");
    public static final Opcode OP_LLZRGF = new Opcode(DatatypeConverter.parseHexBinary("e3000000003a"),"LLZRGF",OpcodeType.RXY_RRRD,"load logical and zero rightmost bytes 32->64","z13","zarch");
    public static final Opcode OP_LZRF = new Opcode(DatatypeConverter.parseHexBinary("e3000000003b"),"LZRF",OpcodeType.RXY_RRRD,"load and zero rightmost byte 32->32","z13","zarch");
    public static final Opcode OP_LZRG = new Opcode(DatatypeConverter.parseHexBinary("e3000000002a"),"LZRG",OpcodeType.RXY_RRRD,"load and zero rightmost byte 64->64","z13","zarch");
    public static final Opcode OP_PPNO = new Opcode(DatatypeConverter.parseHexBinary("b9ec"),"PPNO",OpcodeType.RRE_RR,"perform pseudorandom number operation","z13","zarch");

public static class Opcode{
    public byte[] opcode;
    public String mnemonic;
    public OpcodeType type;
    public String description;
    public String mf_since;
    public String arch;
    public Opcode(byte[] opcode,String mnemonic,OpcodeType type,String description,String mf_since,String arch){
        this.opcode = opcode;
        this.mnemonic = mnemonic;
        this.type = type;
        this.description = description;
        this.mf_since = mf_since;
        this.arch = arch;
        Opcodes.opcodes.put(mnemonic,this);    }
}
public enum OpcodeType{
    VRR_VVV2,
    VRR_VV0UU2,
    RRE_AR,
    RIL_UP,
    RRS_RRRDU,
    VRR_VV0UUU,
    RRF_0UFF,
    VRR_VVVU0VB,
    RIL_RI,
    RRF_UUFF,
    VRI_V0IU,
    VRI_VVU2,
    RRE_FFE,
    RIE_RRUUU,
    SS_RRRDRD2,
    RRF_FEUFEFE,
    VRR_VV0U2,
    S_RD,
    RS_AARD,
    VRR_VV0U,
    RRF_UUFEFE,
    VRI_V0UUU,
    RXF_FRRDFE,
    RS_R0RD,
    RXY_FRRD,
    SMI_U0RDP,
    RSE_RURD,
    RIE_R0IU,
    MII_UPP,
    RI_UP,
    RR_UR,
    VRR_VVVU0VB3,
    RX_RERRD,
    RS_CCRD,
    VRI_V,
    RRF_R0RR,
    RRF_RURR2,
    RRF_FEUFEFE2,
    VRR_VVVUU0V,
    RRE_F0,
    SIY_URD,
    VRR_VVVU0VB1,
    RRE_R0,
    RSI_RRP,
    RR_RR,
    VRI_V0I,
    RXY_RRRD,
    RRE_RF,
    VRI_V0UU,
    RXF_FRRDF,
    RRF_U0FF,
    RRE_RER,
    RIS_RURDU,
    RX_URRD,
    RIE_RRPU,
    RX_FRRD,
    VRR_VVV0U2,
    VRS_VRRDU,
    RRF_U0RER,
    RSY_RRRD,
    SSE_RDRD,
    RSY_AARD,
    VRR_VVV0V,
    RRF_F0FR,
    RSY_RERERD,
    RIE_RRP,
    RRF_UUFFE,
    RRE_RA,
    RXE_RRRDU,
    RS_RERERD,
    RRE_RFE,
    VRR_VVV0U1,
    RRE_AA,
    VRR_VVVV,
    RIE_RUPU,
    SS_L0RDRD,
    RIL_RP,
    RX_RRRD,
    RRF_FUFF,
    RRF_R0RR2,
    RR_FEF,
    RSL_LRDFU,
    VRR_VV0UU8,
    RXE_RERRD,
    RIE_RUPI,
    VRR_VVV0U,
    RI_RI,
    RIL_0P,
    RRF_0UFEF,
    SS_L2RDRD,
    RSY_RURD2,
    SS_RRRDRD,
    RSE_CCRD,
    RRF_FE0FF,
    VRR_VVV0U0U,
    RIL_RU,
    RRR_FE0FEFE,
    VRR_VV0U0U,
    SS_LLRDRD,
    RR_FEFE,
    RRR_F0FF,
    VRR_VVV0UUU,
    RRE_FF,
    RRF_UURF,
    RXE_RRRD,
    E,
    VRI_VVUUU,
    RRE_FEFE,
    VRI_VVU,
    VRI_VVUU,
    VRS_VVRDU,
    RRE_FER,
    RI_RP,
    RS_RRRD,
    RRF_UUFR,
    RRF_U0RF,
    RRE_FEF,
    RRF_F0FF,
    IE_UU,
    RR_FF,
    RIS_RURDI,
    VRX_VRRDU,
    RSE_RERERD,
    RR_U0,
    SSF_RERDRD2,
    RRE_FR,
    RSY_RURD,
    SIL_RDU,
    VRI_V0U,
    RRF_FUFF2,
    VRR_VV,
    RRE_RERE,
    SS_RRRDRD3,
    RRF_U0FEFE,
    RXE_FERRD,
    VRI_VVV0U,
    SIL_RDI,
    RS_RE0RD,
    RSE_RRRD,
    RX_FERRD,
    SIY_IRD,
    VRR_VVV0UU,
    VRS_RVRDU,
    RIE_RUI0,
    RXE_FRRD,
    SI_URD,
    RIE_RRI0,
    RRF_U0RFE,
    RSL_LRDFEU,
    RRE_00,
    RRF_F0FF2,
    RRF_FFRU,
    RRF_U0RERE,
    VRR_VVV0U0,
    RSL_R0RD,
    S_00,
    RS_RURD,
    RRF_FE0FER,
    RRF_FEFERU,
    VRS_VVRD,
    SSF_RRDRD,
    RRF_UURFE,
    RRE_RR,
    VRV_VVXRDU,
    RRE_0R,
    RXY_URRD,
    RR_R0,
    RXF_FERRDFE,
    RR_0R,
    VRR_VRR,
    RI_0P,
    VRR_VVV,
    VRR_VVV0U3,
    RRF_U0RR,
    SS_LIRDRD,
    RRE_FE0,
    VRR_VVVU0UV,
    VRX_VV,
    VRR_VVVU0VB2,
    VRR_VVVU0V,
    RR_RER,
    RI_RU,
    VRS_VRRD,
    RXY_RERRD,
    RRF_UUFER,
    RX_0RRD,
    RIE_R0UU,
    VRX_VRRD,
    RR_FFE,
    VRS_RVRD,
    VRI_VVV0UU,
    VRR_VV0UU,
}}