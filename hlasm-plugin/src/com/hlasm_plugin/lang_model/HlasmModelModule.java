package com.hlasm_plugin.lang_model;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by anisik on 15.02.2017.
 */
public class HlasmModelModule {
    public List<HlasmModelMacro>    macros  = new LinkedList<>();
    public List<HlasmModelModule>   subparts= new LinkedList<>();
    public List<HlasmModelLine>     lines   = new LinkedList<>();
}
