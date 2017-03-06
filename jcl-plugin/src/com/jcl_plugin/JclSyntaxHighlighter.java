package com.jcl_plugin;

import com.hlasm_plugin.psi.HlasmIElementTypesFactory;
import com.intellij.lexer.Lexer;
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors;
import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.editor.markup.TextAttributes;
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase;
import com.intellij.psi.tree.IElementType;
import com.intellij.ui.JBColor;
import hlasm.JclLexer;
import hlasm.JclParser;
import org.antlr.jetbrains.adaptor.lexer.ANTLRLexerAdaptor;
import org.antlr.jetbrains.adaptor.lexer.PSIElementTypeFactory;
import org.antlr.jetbrains.adaptor.lexer.TokenIElementType;
import org.jetbrains.annotations.NotNull;

import static com.intellij.openapi.editor.colors.TextAttributesKey.createTextAttributesKey;

/**
 * Created by anisik on 20.07.2016.
 */
public class JclSyntaxHighlighter extends SyntaxHighlighterBase {
    private static final TextAttributesKey[] EMPTY_KEYS = new TextAttributesKey[0];
    public static final TextAttributesKey KEYWORD =
            createTextAttributesKey("SAMPLE_KEYWORD", DefaultLanguageHighlighterColors.KEYWORD);
    public static final TextAttributesKey LINE_COMMENT =
            createTextAttributesKey("SAMPLE_LINE_COMMENT", DefaultLanguageHighlighterColors.LINE_COMMENT);
    public static final TextAttributesKey STRING =
            createTextAttributesKey("SAMPLE_STRING", DefaultLanguageHighlighterColors.STRING);
    public static final TextAttributesKey JCL_OPTION =
            createTextAttributesKey("SAMPLE_JCL_OPTION", new TextAttributes(new JBColor(0x55ccee,0x55ccee),
                    null, null, null,0));
    public static final TextAttributesKey LABEL_DEF =
            createTextAttributesKey("SAMPLE_LABEL_DEF", new TextAttributes(new JBColor(0x00ff00,0x00cc00),
                    null, null, null,0));
    public static final TextAttributesKey COMMA =
            createTextAttributesKey("SAMPLE_COMMA", new TextAttributes(JBColor.YELLOW,
                    null, null, null,0));
    public static final TextAttributesKey SYSIN =
            createTextAttributesKey("SAMPLE_ASM_KWD", new TextAttributes(JBColor.BLUE,
                    null, null, null,0));


    static {
        PSIElementTypeFactory.iElementTypesFactory = HlasmIElementTypesFactory.INSTANCE;
        PSIElementTypeFactory.defineLanguageIElementTypes(JclLanguage.INSTANCE,
                JclLexer.tokenNames,
                JclParser.ruleNames);
    }

    @NotNull
    @Override
    public Lexer getHighlightingLexer() {
        return new ANTLRLexerAdaptor(JclLanguage.INSTANCE,new JclLexer(null));
    }

    @NotNull
    @Override
    public TextAttributesKey[] getTokenHighlights(IElementType tokenType) {
        if (!(tokenType instanceof TokenIElementType)) return EMPTY_KEYS;
        TokenIElementType myType = (TokenIElementType) tokenType;
        int ttype = myType.getANTLRTokenType();
        TextAttributesKey attrKey;
        switch (ttype) {
            case JclLexer.LINE_START:
            case JclLexer.LINE_START1:
                attrKey = LABEL_DEF;
                break;
            case JclLexer.LINE_COMMENT:
            case JclLexer.ENDLINE1:
                attrKey = LINE_COMMENT;
                break;
            case JclLexer.DD:
            case JclLexer.EXEC:
            case JclLexer.JOB:
            case JclLexer.SET:
            case JclLexer.ANY_COMMAND:
                attrKey = KEYWORD;
                break;
            case JclLexer.COMMA:
            case JclLexer.EQUALS:
            case JclLexer.EQUAL_FOR_TAPE:  // TODO: Temp solution for UNIT=/2101
            case JclLexer.MUL:
                attrKey = COMMA;
                break;
            case JclLexer.STRING:
                attrKey = STRING;
                break;
            case JclLexer.JOB_OPTION:
                attrKey = JCL_OPTION;
                break;
            case JclLexer.SYSIN:
                attrKey = SYSIN;
                break;
            default:
                return EMPTY_KEYS;
        }
        return new TextAttributesKey[] {attrKey};
    }
}
