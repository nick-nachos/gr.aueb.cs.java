package gr.aueb.cs.java.hangman.util;

public final class StringUtil
{
    private StringUtil() {}
    
    public static final String EMPTY = "";
    
    public static boolean isNullOrEmpty(String s)
    {
        return s == null || s.equals(EMPTY);
    }
    
    public static boolean isNullOrWhitespace(String s)
    {
        return isNullOrEmpty(s) || isNullOrEmpty(s.trim());
    }
}
