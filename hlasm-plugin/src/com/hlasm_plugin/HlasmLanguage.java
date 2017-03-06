package com.hlasm_plugin;

import com.intellij.lang.Language;

/**
 * Created by anisik on 01.06.2016.
 */
public class HlasmLanguage extends Language {
    public static final HlasmLanguage INSTANCE = new HlasmLanguage();

    private HlasmLanguage(){
        super("Hlasm");
    }
}
