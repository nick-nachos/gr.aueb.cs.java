package gr.aueb.cs.java.io.streamfactories;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.File;

final class FileStreamFactory
    implements IStreamFactory
{
    private static final String FILE_SOURCE;
    
    static 
    {
    	String destination = System.getProperty("user.home");
        FILE_SOURCE = destination + "/java_io_sample_01.txt";
    }
    
    @Override
    public StreamSource getStreamSource()
    {
        return StreamSource.File;
    }
    
    @Override
    public boolean streamDisposalRequired() 
    {
        return true;
    }
    
    @Override
    public InputStream getInputStream() 
            throws IOException
    {
        File f = new File(FILE_SOURCE);
        
        if (!f.exists())
            f.createNewFile();
        
        return new FileInputStream(FILE_SOURCE);
    }

    @Override
    public OutputStream getOutputStream() 
            throws IOException
    {
        return new FileOutputStream(FILE_SOURCE);
    }
}
