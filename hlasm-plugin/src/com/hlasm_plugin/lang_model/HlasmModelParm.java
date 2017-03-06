package com.hlasm_plugin.lang_model;

import org.antlr.jetbrains.adaptor.psi.ANTLRPsiNode;

/**
 * Created by anisik on 15.02.2017.
 */
public class HlasmModelParm {
    public String name; // for macro calls if nessesary, null otherwise
    public ANTLRPsiNode parsedParm; // parsed parm
}
