package com.hlasm_plugin;

import com.hlasm_plugin.stubs.HlasmPsiFileStub;
import com.intellij.lang.Language;
import com.intellij.openapi.fileTypes.LanguageFileType;
import com.intellij.psi.tree.IStubFileElementType;

import javax.swing.*;

/**
 * Created by anisik on 01.06.2016.
 */
public class HlasmFileType extends LanguageFileType  {
    public static final HlasmFileType INSTANCE = new HlasmFileType();

    private HlasmFileType(){
        super(HlasmLanguage.INSTANCE);
    }

    @Override
    public String getName(){
        return "HLASM file";
    }

    @Override
    public String getDefaultExtension(){
        return "asm";
    }

    @Override
    public String getDescription(){
        return "HLASM language file";
    }

    @Override
    public Icon getIcon(){
        return HlasmIcons.HLASM;
    }

}
