package gr.aueb.cs.java.io.demos;

import gr.aueb.cs.java.io.streamfactories.IStreamFactory;
import gr.aueb.cs.java.io.streamfactories.StreamFactories;

import java.io.IOException;
import java.io.InputStream;

final class NaiveStringInputDemo
    implements IIODemo
{
    private static final String DESCRIPTION = "Read string input from some source and print to std out (naive version).";
    
    @Override
    public String getDescription()
    {
        return DESCRIPTION;
    }

    @Override
    public void execute(IStreamFactory sf) throws IOException
    {
        InputStream in = null;
        
        try
        {
            in = sf.getInputStream();
            char[] chars = new char[10];
            
            for (int i = 0; i < chars.length; i++)
            {
                int b = in.read();
                
                if (b < 0)
                    break;
                
                chars[i] = (char) b;
            }
            
            for (int i = 0; i < chars.length; i++)
            {
                char c = chars[i];
                
                if (c == 0)
                    break;
                
                System.out.print(chars[i]);
            }
        }
        finally 
        {
            StreamFactories.tryCloseStream(sf, in);
        }
    }

}
