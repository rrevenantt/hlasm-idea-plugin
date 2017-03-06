package com.hlasm_plugin.lang_model;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by anisik on 15.02.2017.
 */
public class HlasmModelLine {
    public List<HlasmModelParm> parms = new LinkedList<>();
    public String command;
    public String label;
}
