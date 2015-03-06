package gr.aueb.cs.java.hangman.data;

public final class WordPool
{
    public static final WordPool instance;
    
    static
    {
        instance = new WordPool();
    }
    
    private String[] pool;
    
    private WordPool() 
    { 
        this.pool = new String[] {
                "hangman", "watermellon", "orange", "cellphone", "science", "programming", "java", "summer", "beach"
        };
    }
    
    public String getRandomWord()
    {
        int index = (int) Math.round((this.pool.length - 1) * Math.random());
        return this.pool[index];
    }
}
