package gr.aueb.cs.java.hangman.stdio;

public final class HangmanInputValidationException
    extends Exception
{
    private static final long serialVersionUID = -8090657180004369520L;

    public HangmanInputValidationException()
    {
        super();
    }
    
    public HangmanInputValidationException(String message)
    {
        super(message);
    }
}
