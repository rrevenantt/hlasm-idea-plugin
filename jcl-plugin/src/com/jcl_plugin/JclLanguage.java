package com.jcl_plugin;

import com.intellij.lang.Language;

/**
 * Created by anisik on 20.07.2016.
 */
public class JclLanguage extends Language {
    public static final JclLanguage INSTANCE = new JclLanguage();

    private JclLanguage(){
        super("JCL");
    }
}
