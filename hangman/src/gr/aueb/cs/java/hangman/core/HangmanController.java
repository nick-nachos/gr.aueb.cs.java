package gr.aueb.cs.java.hangman.core;

import gr.aueb.cs.java.hangman.util.StringUtil;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

public final class HangmanController
{
    private String word;
    private HashMap<Character, CharacterResolver> charMap;
    private HashSet<Character> usedChars;
    private LinkedList<Character> usedCharsHistory;
    private HangmanState state;
    private char[] wordProgress;

    public HangmanController(String word)
    {
        if (StringUtil.isNullOrWhitespace(word))
            throw new IllegalArgumentException("Blank strings are invalid for hangman game.");

        this.word = word;
        this.state = HangmanState.CLEAR;
        this.charMap = new HashMap<Character, CharacterResolver>();
        this.usedChars = new HashSet<Character>();
        this.usedCharsHistory = new LinkedList<Character>();
        this.wordProgress = new char[word.length()];
        this.initCharMap();
    }

    public String getWord()
    {
        return this.word;
    }
    
    public HangmanState getHangState()
    {
        return this.state;
    }

    public char[] getWordProgress()
    {
        return Arrays.copyOf(this.wordProgress, this.wordProgress.length);
    }

    public char[] getUsedChars()
    {
        char[] used = new char[this.usedCharsHistory.size()];
        int i = 0;
        
        for (Character ch : this.usedCharsHistory)
        {
            used[i++] = ch;
        }
        
        return used;
    }
    
    public boolean isGameFinished()
    {
        return this.isFailed() || this.isDone();
    }
    
    public boolean isDone()
    {
        for (CharacterResolver charResolver : this.charMap.values())
        {
            if (!charResolver.isFound())
                return false;
        }

        return true;
    }
    
    public boolean isFailed()
    {
        return !this.getHangState().hasNext();
    }

    public HangmanInputResult tryCharacter(char c)
    {
        if (this.isGameFinished())
            throw new IllegalStateException("Game is finished. No more characters can be accepted.");
        
        Character ch = Character.toLowerCase(c);
        
        if (this.usedChars.contains(ch))
            return HangmanInputResult.NONE;
        
        this.usedChars.add(ch);
        this.usedCharsHistory.addLast(ch);
        
        if (this.charMap.containsKey(ch))
        {
            this.onValidCharacter(ch);
            return HangmanInputResult.SUCCESS;
        }
        else
        {
            this.onInvalidCharacter(ch);
            return HangmanInputResult.FAILURE;
        }
    }

    private void initCharMap()
    {
        this.charMap.clear();
        String word = this.getWord().toLowerCase();

        for (int i = 0; i < word.length(); i++)
        {
            char c = word.charAt(i);
            CharacterResolver charResolver;

            if (this.charMap.containsKey(c))
            {
                charResolver = this.charMap.get(c);
            }
            else
            {
                charResolver = new CharacterResolver();
                this.charMap.put(c, charResolver);
            }

            charResolver.addIndex(i);
        }

        this.tryCharacter(word.charAt(0));
        this.tryCharacter(word.charAt(this.word.length() - 1));
    }
    
    private void onValidCharacter(Character ch)
    {
        CharacterResolver charResolver = this.charMap.get(ch);
        charResolver.setFound(true);
        
        for (int index : charResolver.getIndices())
        {
            this.wordProgress[index] = this.getWord().charAt(index);
        }
    }
    
    private void onInvalidCharacter(Character ch)
    {
        this.state = this.state.getNext();
    }
}
