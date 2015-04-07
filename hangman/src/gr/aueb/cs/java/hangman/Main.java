package gr.aueb.cs.java.hangman;

import java.io.IOException;

import gr.aueb.cs.java.hangman.core.*;
import gr.aueb.cs.java.hangman.data.WordPool;
import gr.aueb.cs.java.hangman.stdio.HangmanInputValidationException;
import gr.aueb.cs.java.hangman.stdio.HangmanInputValidator;
import gr.aueb.cs.java.hangman.stdio.HangmanVisualizer;
import gr.aueb.cs.java.hangman.stdio.StdioUtil;

public class Main
{
    public static void main(String[] args)
        throws IOException
    {
        HangmanGame gameController = new HangmanGame(WordPool.instance.getRandomWord());
        HangmanVisualizer.instance.visualize(gameController);
        
        while (!gameController.isGameFinished())
        {
            char c = readNextLetter();
            HangmanInputResult attemptResult = gameController.tryCharacter(c);
            
            if (attemptResult == HangmanInputResult.NONE)
                continue;
            
            HangmanVisualizer.instance.visualize(gameController);
        }
        
        System.out.println();
        
        if (gameController.isFailed())
        {
            System.out.println("You lost...");
        }
        else
        {
            System.out.println("You win!");
        }
    }

    private static char readNextLetter() 
            throws IOException
    {
        System.out.print("Choose a letter [a-z]: ");
        String input = StdioUtil.readLine();
        boolean validated = false;
        
        while (!validated)
        {
            try
            {
                HangmanInputValidator.instance.validate(input);
                validated = true;
            }
            catch (HangmanInputValidationException ex) 
            { 
                System.out.print(ex.getMessage() + " Try again: ");
                input = StdioUtil.readLine();
            }
        }
        
        return input.charAt(0);
    }
}
