package gr.aueb.cs.java.hangman.util;

public final class GenericUtil
{
    private GenericUtil() { }
    
    public static void EnsureNotNull(Object arg, String argName)
    {
        if (arg == null)
            throw new IllegalArgumentException(String.format("Argument \'%s\' cannot be null.", argName));
    }
}
