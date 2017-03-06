package com.hlasm_plugin;

import com.hlasm_plugin.psi.HlasmIElementTypesFactory;
import com.intellij.lexer.Lexer;
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors;
import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.editor.markup.TextAttributes;
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase;
import com.intellij.psi.tree.IElementType;
import com.intellij.ui.JBColor;
import hlasm.HlasmLexer;
import hlasm.HlasmParser;
import org.antlr.jetbrains.adaptor.lexer.ANTLRLexerAdaptor;
import org.antlr.jetbrains.adaptor.lexer.PSIElementTypeFactory;
import org.antlr.jetbrains.adaptor.lexer.TokenIElementType;
import org.jetbrains.annotations.NotNull;


import static com.intellij.openapi.editor.colors.TextAttributesKey.createTextAttributesKey;

/**
 * Created by anisik on 01.06.2016.
 */
public class HlasmSyntaxHighlighter extends SyntaxHighlighterBase {

    private static final TextAttributesKey[] EMPTY_KEYS = new TextAttributesKey[0];
    public static final TextAttributesKey ID =
            createTextAttributesKey("SAMPLE_ID", DefaultLanguageHighlighterColors.IDENTIFIER);
    public static final TextAttributesKey KEYWORD =
            createTextAttributesKey("SAMPLE_KEYWORD", DefaultLanguageHighlighterColors.KEYWORD);
    public static final TextAttributesKey STRING =
            createTextAttributesKey("SAMPLE_STRING", DefaultLanguageHighlighterColors.STRING);
    public static final TextAttributesKey LINE_COMMENT =
            createTextAttributesKey("SAMPLE_LINE_COMMENT", DefaultLanguageHighlighterColors.LINE_COMMENT);
    public static final TextAttributesKey NUMBERS =
            createTextAttributesKey("SAMPLE_NUMBERS", DefaultLanguageHighlighterColors.NUMBER);
    public static final TextAttributesKey LABEL_DEF =
            createTextAttributesKey("SAMPLE_LABEL_DEF", new TextAttributes(new JBColor(0x00ff00,0x00cc00),
                    null, null, null,0));
    public static final TextAttributesKey ASM_KWD =
            createTextAttributesKey("SAMPLE_ASM_KWD", new TextAttributes(JBColor.BLUE,
                    null, null, null,0));
    public static final TextAttributesKey COMMA =
            createTextAttributesKey("SAMPLE_COMMA", new TextAttributes(JBColor.YELLOW,
                    null, null, null,0));

    static {
        PSIElementTypeFactory.iElementTypesFactory = HlasmIElementTypesFactory.INSTANCE;
        PSIElementTypeFactory.defineLanguageIElementTypes(HlasmLanguage.INSTANCE,
                HlasmParser.tokenNames,
                HlasmParser.ruleNames);
    }

    @NotNull
    @Override
    public Lexer getHighlightingLexer() {
        HlasmLexer lexer = new HlasmLexer(null);
        return new ANTLRLexerAdaptor(HlasmLanguage.INSTANCE,lexer);
    }

    @NotNull
    @Override
    public TextAttributesKey[] getTokenHighlights(IElementType tokenType) {
        if (!(tokenType instanceof TokenIElementType)) return EMPTY_KEYS;
        TokenIElementType myType = (TokenIElementType) tokenType;
        int ttype = myType.getANTLRTokenType();
        TextAttributesKey attrKey;
        switch (ttype){
            case HlasmLexer.COMMENT:
            case HlasmLexer.ARG_SEPARATOR:
            case HlasmLexer.ENDLINE:
            case HlasmLexer.ENDLINE_COMM:
                attrKey = LINE_COMMENT;
                break;
            case HlasmLexer.LABEL:
                attrKey = ID;
                break;
            case HlasmLexer.STRING:
                attrKey = STRING;
                break;
            case  HlasmLexer.NUMBER:
                attrKey = NUMBERS;
                break;
            case HlasmLexer.LABEL_DEF:
                attrKey = LABEL_DEF;
                break;
            case HlasmLexer.COMMA:
            case HlasmLexer.EQUALS:
            case HlasmLexer.PLUS:
            case HlasmLexer.MINUS:
            case HlasmLexer.MUL:
                attrKey = COMMA;
                break;
            case  HlasmLexer.COMMAND:
                attrKey = KEYWORD;
                break;
            case HlasmLexer.ALIAS:
            case HlasmLexer.AMODE:
            case HlasmLexer.COPY:
            case HlasmLexer.DC:
            case HlasmLexer.DS:
            case HlasmLexer.DROP:
            case HlasmLexer.EJECT:
            case HlasmLexer.EQU:
            case HlasmLexer.CCW:
            case HlasmLexer.LOCTR:
            case HlasmLexer.LTORG:
            case HlasmLexer.USING:
            case HlasmLexer.SPACE:
            case HlasmLexer.DSECT:
            case HlasmLexer.CSECT:
            case HlasmLexer.RSECT:
            case HlasmLexer.ORG:
                attrKey = ASM_KWD;
                break;
            default:
                return EMPTY_KEYS;
        }
        return new TextAttributesKey[] {attrKey};
    }
}
