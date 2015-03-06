package gr.aueb.cs.java.hangman.core;

import java.util.List;
import java.util.LinkedList;

final class CharacterResolver
{
    private boolean found;
    private List<Integer> charIndices;
    
    public CharacterResolver()
    {
        this.charIndices = new LinkedList<Integer>();
    }
    
    public void addIndex(int index)
    {
        this.charIndices.add(index);
    }
    
    public Iterable<Integer> getIndices()
    {
        return this.charIndices;
    }

    public boolean isFound()
    {
        return found;
    }

    public void setFound(boolean found)
    {
        this.found = found;
    }
}
