package com.jcl_plugin;

import com.hlasm_plugin.HlasmIcons;
import com.intellij.openapi.fileTypes.LanguageFileType;
import com.intellij.openapi.util.IconLoader;

import javax.swing.*;

/**
 * Created by anisik on 20.07.2016.
 */
public class JclFileType extends LanguageFileType {
    public static final JclFileType INSTANCE = new JclFileType();

    private JclFileType(){
        super(JclLanguage.INSTANCE);
    }

    @Override
    public String getName(){
        return "JCL file";
    }

    @Override
    public String getDefaultExtension(){
        return "jcl";
    }

    @Override
    public String getDescription(){
        return "JCL file";
    }

    @Override
    public Icon getIcon(){
        return HlasmIcons.HLASM;
    }

}
