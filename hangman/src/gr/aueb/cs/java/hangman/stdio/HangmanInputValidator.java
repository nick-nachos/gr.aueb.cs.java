package gr.aueb.cs.java.hangman.stdio;

import gr.aueb.cs.java.hangman.util.StringUtil;

public final class HangmanInputValidator
{
    public static final HangmanInputValidator instance;
    
    static
    {
        instance = new HangmanInputValidator();
    }
    
    private HangmanInputValidator() { }
    
    public void validate(String input)
        throws HangmanInputValidationException
    {
        if (StringUtil.isNullOrEmpty(input) || input.length() > 1)
            throw new HangmanInputValidationException("You must enter exactly one (1) character.");
        
        char c = input.charAt(0);
        
        if (Character.isUpperCase(c))
            c = Character.toLowerCase(c);
        
        if (c < 'a' || c > 'z')
            throw new HangmanInputValidationException("Characters must be in the range [a-z].");
    }
}
