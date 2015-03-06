package gr.aueb.cs.java.io.streamfactories;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public interface IStreamFactory
{
    StreamSource getStreamSource();
    
    boolean streamDisposalRequired();
    
    InputStream getInputStream()
        throws IOException;
    
    OutputStream getOutputStream()
        throws IOException;
}
