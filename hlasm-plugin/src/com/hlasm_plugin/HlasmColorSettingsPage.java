package com.hlasm_plugin;

import com.intellij.openapi.editor.actions.CutAction;
import com.intellij.openapi.editor.colors.ColorKey;
import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.fileTypes.SyntaxHighlighter;
import com.intellij.openapi.options.colors.AttributesDescriptor;
import com.intellij.openapi.options.colors.ColorDescriptor;
import com.intellij.openapi.options.colors.ColorSettingsPage;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import java.util.Map;

/**
 * Created by anisik on 02.06.2016.
 */
public class HlasmColorSettingsPage implements ColorSettingsPage {
    public static final AttributesDescriptor[] DESCRIPTORS = new AttributesDescriptor[]{
        new AttributesDescriptor("LABEL",HlasmSyntaxHighlighter.ID),
        new AttributesDescriptor("COMMAND",HlasmSyntaxHighlighter.KEYWORD),
        new AttributesDescriptor("LABEL_DEF", HlasmSyntaxHighlighter.LABEL_DEF),
        new AttributesDescriptor("COMMENT",HlasmSyntaxHighlighter.LINE_COMMENT),
        new AttributesDescriptor("NUMBERS",HlasmSyntaxHighlighter.NUMBERS),
        new AttributesDescriptor("STRINGS",HlasmSyntaxHighlighter.STRING),
        new AttributesDescriptor("COMMA",HlasmSyntaxHighlighter.COMMA),
        new AttributesDescriptor("Asm Keyword",HlasmSyntaxHighlighter.ASM_KWD),
    };

    public HlasmColorSettingsPage() {
        super();
    }

    @Nullable
    @Override
    public Icon getIcon() {
        return HlasmIcons.HLASM;
    }

    @NotNull
    @Override
    public SyntaxHighlighter getHighlighter() {
        return new HlasmSyntaxHighlighter();
    }

    @NotNull
    @Override
    public String getDemoText(){
        return "label1 csect     comment                  \n"+
                "       macro   parm1=(parm2,'parm3',4)   \n"+
                "      end                                \n";
    }

    @Nullable
    @Override
    public Map<String, TextAttributesKey> getAdditionalHighlightingTagToDescriptorMap() {
        return null;
    }

    @NotNull
    @Override
    public AttributesDescriptor[] getAttributeDescriptors() {
        return DESCRIPTORS;
    }

    @NotNull
    @Override
    public ColorDescriptor[] getColorDescriptors() { return ColorDescriptor.EMPTY_ARRAY; }

    @NotNull
    @Override
    public String getDisplayName() {
        return "Hlasm";
    }
}
