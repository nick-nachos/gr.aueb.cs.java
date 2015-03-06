package gr.aueb.cs.java.io.demos;

public final class IODemos
{
    private IODemos() {}
    
    public static IIODemo[] getDemos()
    {
        return new IIODemo[] {
                new HelloWorld(),
                new NaiveStringInputDemo(),
                new StringInputDemo()
                };
    }
}
