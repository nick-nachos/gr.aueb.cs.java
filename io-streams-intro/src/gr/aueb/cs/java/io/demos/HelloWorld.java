package gr.aueb.cs.java.io.demos;

import java.io.IOException;
import java.io.OutputStream;

import gr.aueb.cs.java.io.streamfactories.IStreamFactory;
import gr.aueb.cs.java.io.streamfactories.StreamFactories;

final class HelloWorld
    implements IIODemo
{
    private static final String DESCRIPTION = "An old time classic hello world demo.";

    @Override
    public String getDescription()
    {
        return DESCRIPTION;
    }

    @Override
    public void execute(IStreamFactory sf)
        throws IOException
    {
        OutputStream out = null;

        try
        {
            out = sf.getOutputStream();
            byte[] hello = "Hello world".getBytes();
            out.write(hello);
        }
        finally
        {
            StreamFactories.tryCloseStream(sf, out);
        }
    }  
}
