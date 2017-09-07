package com.hlasm_plugin.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by anisik on 27.07.2016.
 */
public class HlasmRegexLibrary { //                      0   1                23                                                                  4
    private static final String comment_pattern = "^(?:\\*[^\\n]{0,70} *\\n)|(?:\\.\\*[^\\n]{0,69} *\\n)|(?: *\\n)|(?:(?:\\*[^\\n]{0,70}[^ ]\\n)(?: [^\\n]{0,70}[^ ]\\n)*)(?: [^\\n]{0,70})$";
    private static final String line_pattern = "^(?! *\\n)((?:[^*][^\\n]{70}[^ ]\\n)*(?:(?:[^*][^\\n]{0,70} *)\\n))";
    public static final Pattern asmline = Pattern.compile("\\A(?! *\\n)((?:[^*][^\\n]{70}[^ \\n]\\n)*(?:(?:[^*][^\\n]{0,70} *)\\n))\\z");
    public static final Pattern comline = Pattern.compile(comment_pattern);
    public static final Pattern ds_statement = Pattern.compile("\\A([0-9]*)([CGXBFHEDLPZAYSVJQR])([LSE]([0-9]+))?\\z");
    public static final Pattern macro = Pattern.compile("\\A.* (MACRO|MEND)[ \\n].*\\z",Pattern.DOTALL);

    //public static final Pattern code_block = Pattern.compile("\\A(" + line_pattern + ")*");
    public static boolean match_statement(CharSequence buffer){
        return find_statement(buffer) == buffer.length();
    }

//    returns offset of end of matched group
    public static int find_statement(CharSequence buffer){
        Matcher matcher = comline.matcher(buffer);
        int offset = 0;
        while (matcher.find()) {
            offset = matcher.end(0);
        }

        Matcher nextmatcher = asmline.matcher(buffer.subSequence(offset,buffer.length())) ;
        if (nextmatcher.find())
            return offset + nextmatcher.end();
        return -1;
    }

    public static boolean match_code_block(CharSequence buffer){
//        int curr_offset = 0;
//        while (curr_offset < buffer.length()){
//            int result = find_statement(buffer.subSequence(curr_offset,buffer.length()));
//            if (result == -1) return false;
//            curr_offset = curr_offset + result;
//        }
        return true;
    }
}
