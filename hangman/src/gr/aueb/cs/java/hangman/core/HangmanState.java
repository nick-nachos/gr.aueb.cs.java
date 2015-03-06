package gr.aueb.cs.java.hangman.core;

public enum HangmanState
{
    CLEAR((byte)0),
    HEAD((byte)1),
    RIGHT_ARM((byte)2),
    LEFT_ARM((byte)3),
    RIGHT_FOOT((byte)4),
    LEFT_FOOT((byte)5);
    
    private byte errorLevel;
    
    private HangmanState(byte errorLevel)
    {
        this.errorLevel = errorLevel;
    }
    
    public int getErrorLevel()
    {
        return this.errorLevel;
    }
    
    public boolean hasNext()
    {
        return this.errorLevel < LEFT_FOOT.getErrorLevel();
    }
    
    public HangmanState getNext()
    {
        switch (this)
        {
            case CLEAR:
                return HEAD;
            case HEAD:
                return RIGHT_ARM;
            case RIGHT_ARM:
                return LEFT_ARM;
            case LEFT_ARM:
                return RIGHT_FOOT;
            case RIGHT_FOOT:
                return LEFT_FOOT;
            default:
                throw new IllegalStateException();
        }
    }
}
