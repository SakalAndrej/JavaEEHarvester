package utils;

public final class StringUtils {

    public StringUtils(){

    }

    public static String replace(String str, String oldChar, String
            newChar)
    {
        return str.replace(oldChar.charAt(0), newChar.charAt(0));
    }
}