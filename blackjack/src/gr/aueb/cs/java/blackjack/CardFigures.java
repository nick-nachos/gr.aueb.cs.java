package gr.aueb.cs.java.blackjack;

public class CardFigures 
{
	public static final byte ACE = 1;
	public static final byte TWO = 2;
	public static final byte THREE = 3;
	public static final byte FOUR = 4;
	public static final byte FIVE = 5;
	public static final byte SIX = 6;
	public static final byte SEVEN = 7;
	public static final byte EIGHT = 8;
	public static final byte NINE = 9;
	public static final byte TEN = 10;
	public static final byte JACK = 11;
	public static final byte QUEEN = 12;
	public static final byte KING = 13;
	
	public static byte[] getValues()
	{
		return new byte[] {ACE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING};
	}
	
	public static String toString(byte figure)
	{
		switch (figure)
		{
			case ACE:
				return "A";
			case JACK:
				return "J";
			case QUEEN:
				return "Q";
			case KING:
				return "K";
			default:
				return figure > ACE && figure < JACK ? Byte.toString(figure) : "";
		}
	}
	
	public static byte getValue(byte figure)
	{
		if (figure == ACE)
		{
			return 11;
		}
		else if (figure > ACE && figure < JACK)
		{
			return figure;
		}
		else if (figure > TEN && figure <= KING)
		{
			return 10;
		}
		else
		{
			return 0;
		}
	}
}
