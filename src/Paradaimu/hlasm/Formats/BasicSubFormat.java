package Paradaimu.hlasm.Formats;

import Paradaimu.hlasm.Operands.BasicOperand;

/**
 * @author Paradaimu
 * 21.10.2017
 * 
 * Interface for any sub form of any format
 * 
 * Name: RRRD
 * Size: 32
 * Mnemonic form:  OP  R1,D2(X2,B2)
 * Memory form: OP|R1|X2|B2|D2
 */
public interface BasicSubFormat {

    /**
     * @return name of sub form in principle of operation
     */
    String getName();

    /**
     * @return name of sub form in s390-opc.txt
     */
    String getCodeName();
    
    /**
     * @return bit size
     */
    int getSize();

    /**
     * @return Mnemonic construction
     */
    BasicOperand[] getMnemonicForm();

    /**
     * @return Mainframe (in memory) data construction
     */
    BasicOperand[] getDataForm();
}
