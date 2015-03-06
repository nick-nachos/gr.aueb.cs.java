package gr.aueb.cs.java.hangman.stdio;

import gr.aueb.cs.java.hangman.core.HangmanController;
import gr.aueb.cs.java.hangman.core.HangmanState;
import gr.aueb.cs.java.hangman.util.StringUtil;

public final class HangmanVisualizer
{
    public static final HangmanVisualizer instance;
    
    static
    {
        instance = new HangmanVisualizer();
    }
    
    private HangmanVisualizer() { }
    
    public void visualize(HangmanController controller)
    {
        this.printHangman(controller.getHangState());
        this.printWord(controller.getWordProgress());
        this.println();
        this.printUsedChars(controller.getUsedChars());
    }
    
    private void printHangman(HangmanState state)
    {
        this.printHangTop();
        this.printHeadSection(state);
        this.printUpperBodySection(state);
        this.printLowerBodySection(state);
        this.printFeetSection(state);
        this.printHangBottom();
    }
    
    private void printUsedChars(char[] usedChars)
    {
        System.out.format("Used so far: %s", usedChars[0]);
        
        for (int i = 1; i < usedChars.length; i++)
        {
            char c = usedChars[i];
            System.out.format(", %s", c);
        }
        
        this.println();
    }
    
    private void printWord(char[] word)
    {
        for (char c : word)
        {
            char toPrint = c == 0 ? '_' : c;
            System.out.print(toPrint + " ");
        }
        
        this.println();
    }
    
    private void printHangTop()
    {
        this.println("_______");
        this.println("|/    |");
    }
    
    private void printHangBottom()
    {
        this.println("|");
        this.print("|________\t");
    }
    
    private void printHeadSection(HangmanState state)
    {
        String toPrint = "|";
        
        if (isAtLeast(state, HangmanState.HEAD))
            toPrint += "    (_)";
        
        println(toPrint);
    }
    
    private void printUpperBodySection(HangmanState state)
    {
        String toPrint = "|";

        if (isAtLeast(state, HangmanState.RIGHT_ARM))
        {
            toPrint += "    \\|";
            
            if (isAtLeast(state, HangmanState.LEFT_ARM))
                toPrint += "/";
        }

        this.println(toPrint);
    }
    
    private void printLowerBodySection(HangmanState state)
    {
        String toPrint = "|";
        
        if (isAtLeast(state, HangmanState.RIGHT_ARM))
            toPrint += "     |";
        
        this.println(toPrint);
    }
    
    private void printFeetSection(HangmanState state)
    {
        String toPrint = "|";

        if (isAtLeast(state, HangmanState.RIGHT_FOOT))
        {
            toPrint += "    /";
            
            if (isAtLeast(state, HangmanState.LEFT_FOOT))
                toPrint += " \\";
        }

        this.println(toPrint);
    }
    
    private void println()
    {
        this.println(StringUtil.EMPTY);
    }
    
    private void println(String s)
    {
        System.out.println(s);
    }
    
    private void print(String s)
    {
        System.out.print(s);
    }
    
    private static boolean isAtLeast(HangmanState state, HangmanState threshold)
    {
        return state.getErrorLevel() >= threshold.getErrorLevel();
    }
}
