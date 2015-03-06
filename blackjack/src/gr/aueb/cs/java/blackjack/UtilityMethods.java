package gr.aueb.cs.java.blackjack;

public class UtilityMethods
{
	public static int random(int lowerBound, int upperBound)
	{
		int range = upperBound - lowerBound;
		int randomNum = lowerBound + (int) Math.round(Math.random() * range);
		
		return randomNum;
	}
}
