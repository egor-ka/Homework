package tasks.task4;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Egor on 09.09.2016.
 */
public class KeyWords {

    public static final ArrayList<String> JAVA_KEYWORD_LIST = new ArrayList<>(
            Arrays.asList("abstract", "assert", "boolean", "break", "byte", "case", "catch", "char", "class", "const",
            "continue", "default", "do", "double", "else", "enum", "extends", "final", "finally", "float",
            "for", "goto", "if", "implements", "import", "instanceof", "int", "interface", "long", "native",
            "new", "package", "private", "protected", "public", "return", "short", "static", "strictfp", "super",
            "switch", "synchronized", "this", "throw", "throws", "transient", "try", "void", "volatile", "while"));


    public static boolean isKeyWord(String word) {
        return JAVA_KEYWORD_LIST.contains(word)? true: false;
    }
}
