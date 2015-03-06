package gr.aueb.cs.java.blackjack;

public class CardShapes 
{
	public static final byte HEART = 1;
	public static final byte SPADE = 2;
	public static final byte DIAMOND = 3;
	public static final byte CLUB = 4;
	
	public static byte[] getValues()
	{
		return new byte[] {HEART, SPADE, DIAMOND, CLUB};
	}
	
	public static String toString(byte shape)
	{
		switch (shape)
		{
			case HEART:
				return "\u2665";
			case SPADE:
				return "\u2660";
			case DIAMOND:
				return "\u2666";
			case CLUB:
				return "\u2663";
			default:
				return "";
		}
	}
}
