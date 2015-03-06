package gr.aueb.cs.java.io.streamfactories;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public final class StreamFactories
{
    private StreamFactories() {}

    public static IStreamFactory createInstance(StreamSource sourceType)
    {
        switch (sourceType)
        {
            case Std:
                return new StdStreamFactory();
            case File:
                return new FileStreamFactory();
            default:
                throw new IllegalArgumentException();
        }
    }
    
    public static void tryCloseStream(IStreamFactory sourceFactory, InputStream in) 
            throws IOException
    {
        if (in != null && sourceFactory.streamDisposalRequired())
            in.close();
    }
    
    public static void tryCloseStream(IStreamFactory sourceFactory, OutputStream out) 
            throws IOException
    {
        if (out != null && sourceFactory.streamDisposalRequired())
            out.close();
    }
}
