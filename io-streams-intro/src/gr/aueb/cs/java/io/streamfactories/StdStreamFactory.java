package gr.aueb.cs.java.io.streamfactories;


import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

final class StdStreamFactory
    implements IStreamFactory
{
    @Override
    public StreamSource getStreamSource()
    {
        return StreamSource.Std;
    }
    
    @Override
    public InputStream getInputStream()
            throws IOException
    {
        return System.in;
    }

    @Override
    public boolean streamDisposalRequired() 
    {
        return false;
    }
    
    @Override
    public OutputStream getOutputStream() 
            throws IOException
    {
        return System.out;
    } 
}
