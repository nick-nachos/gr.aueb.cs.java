package gr.aueb.cs.java.io;

public final class Helpers
{
    private Helpers() {}
    
    public static void exit()
    {
        System.exit(0);
    }

    public static void print(String s)
    {
        System.out.print(s);
    }

    public static void println(String s)
    {
        System.out.println(s);
    }

    public static String readLine()
    {
        return readLine(null);
    }

    public static String readLine(String message)
    {
        if (!isNullOrEmpty(message))
        {
            System.out.format("%s: ", message);
        }

        String line = null;
        java.io.BufferedReader br = null;

        try
        {
            br = new java.io.BufferedReader(new java.io.InputStreamReader(System.in));
            line = br.readLine();
        }
        catch (java.io.IOException ioe)
        {
            ioe.printStackTrace();
            System.exit(1);
        }

        return line;
    }

    public static int readInt()
    {
        return readInt(null);
    }

    public static int readInt(String message)
    {
        String line = readLine(message);
        return Integer.parseInt(line.trim());
    }

    public static double readDouble()
    {
        return readDouble(null);
    }

    public static double readDouble(String message)
    {
        String line = readLine(message);
        return Double.parseDouble(line.trim());
    }

    public static boolean isNullOrEmpty(String s)
    {
        return s == null || s.equals("");
    }
}
