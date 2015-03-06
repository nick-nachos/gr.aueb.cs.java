package gr.aueb.cs.java.io;

import gr.aueb.cs.java.io.demos.IIODemo;
import gr.aueb.cs.java.io.demos.IODemos;
import gr.aueb.cs.java.io.streamfactories.IStreamFactory;
import gr.aueb.cs.java.io.streamfactories.StreamFactories;
import gr.aueb.cs.java.io.streamfactories.StreamSource;

import java.io.*;

public class Main 
{
    public static void main(String[] args) 
    {
        StreamSource[] sources = StreamSource.values();
        IIODemo[] demos = IODemos.getDemos();
        System.out.println("Choose I/O source:");
        printList(sources);
        System.out.print("Enter source index: ");
        int sourceIndex = getNumericChoice(1, sources.length) - 1;
        System.out.println("Choose demo:");
        printList(demos);
        System.out.print("Enter demo index: ");
        int demoIndex = getNumericChoice(1, demos.length) - 1;
        IStreamFactory sf = StreamFactories.createInstance(sources[sourceIndex]);
        
        try
        {
            demos[demoIndex].execute(sf);
        }
        catch (IOException ioe)
        {
            System.out.println(ioe.toString());
        }
    }
    
    private static void printList(StreamSource[] items)
    {
        for (int i = 0; i < items.length; i++)
        {
            System.out.format("%d. %s\n", i + 1, items[i].toString());
        }
    }
    
    private static void printList(IIODemo[] items)
    {
        for (int i = 0; i < items.length; i++)
        {
            System.out.format("%d. %s\n", i + 1, items[i].getDescription());
        }
    }
    
    private static int getNumericChoice(int low, int high)
    {
        int choice = Helpers.readInt();
        
        while (choice < 1 || choice > high)
        {
            System.out.print("Invalid choice, try again: ");
            choice = Helpers.readInt();
        }
        
        return choice;
    }
}
