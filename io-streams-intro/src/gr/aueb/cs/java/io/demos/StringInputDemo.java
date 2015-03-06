package gr.aueb.cs.java.io.demos;

import gr.aueb.cs.java.io.streamfactories.IStreamFactory;
import gr.aueb.cs.java.io.streamfactories.StreamFactories;

import java.io.IOException;
import java.io.InputStream;

final class StringInputDemo 
    implements IIODemo
{
    private static final String DESCRIPTION = "Read string input from some source and print to std out.";
    
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
            byte[] input = new byte[10];
            in.read(input);
            System.out.write(input);
        }
        finally 
        {
            StreamFactories.tryCloseStream(sf, in);
        }
    }

}
