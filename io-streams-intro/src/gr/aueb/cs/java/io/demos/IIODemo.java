package gr.aueb.cs.java.io.demos;

import java.io.IOException;

import gr.aueb.cs.java.io.streamfactories.IStreamFactory;

public interface IIODemo
{
    String getDescription();
    
    void execute(IStreamFactory sf) 
            throws IOException;
}
