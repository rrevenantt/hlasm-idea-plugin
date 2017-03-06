package org.antlr.jetbrains.adaptor.lexer;

import com.intellij.lang.Language;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by anisik on 17.10.2016.
 */
public class DefaultIElementTypesFactory {
    @NotNull
    public List<TokenIElementType> createTokenIElementTypes(Language language, String[] tokenNames) {
        List<TokenIElementType> result;
        TokenDefaultIElementType[] elementTypes = new TokenDefaultIElementType[tokenNames.length];
        for (int i = 0; i < tokenNames.length; i++) {
            if ( tokenNames[i]!=null ) {
                elementTypes[i] = new TokenDefaultIElementType(i, tokenNames[i], language);
            }
        }

        result = new LinkedList<>(Arrays.asList(elementTypes));
        return result;
    }

    @NotNull
    public List<RuleIElementType> createRuleIElementTypes(Language language, String[] ruleNames) {
        List<RuleIElementType> result;
        RuleIElementType[] elementTypes = new RuleIElementType[ruleNames.length];
        for (int i = 0; i < ruleNames.length; i++) {
            elementTypes[i] = new RuleDefaultIElementType(i, ruleNames[i], language);
        }

        result =  new LinkedList<>(Arrays.asList(elementTypes));//Arrays.asList(elementTypes);
        //result = Collections.unmodifiableList(Arrays.asList(elementTypes));
        return result;
    }


}
