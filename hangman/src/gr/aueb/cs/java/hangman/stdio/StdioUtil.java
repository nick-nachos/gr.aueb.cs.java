package gr.aueb.cs.java.hangman.stdio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public final class StdioUtil
{
    private static final BufferedReader STDIN;
    
    static
    {
        STDIN = new BufferedReader(new InputStreamReader(System.in));
    }
    
    private StdioUtil() { }
    
    public static String readLine() 
            throws IOException
    {
        return STDIN.readLine();
    }
}
