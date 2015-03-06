package gr.aueb.cs.java.blackjack;

public class HandOfCards
{	
	public static final byte MAX_HAND_VALUE = 21;
	
	private Card[] cards;
	private int size;
	private byte handValue;
	private boolean handChanged;
	
	public HandOfCards()
	{
		this.cards = new Card[10];
	}
	
	public int getSize()
	{
		return this.size;
	}
	
	public boolean addCard(Card c)
	{
		if (c == null)
			return false;
		
		this.cards[this.size++] = c;
		this.handChanged = true;
		
		return true;
	}
	
	public byte getHandValue()
	{
		if (this.handChanged)
		{
			this.calculateHandValue();
			this.handChanged = false;
		}
		
		return this.handValue;
	}
	
	public boolean isBust()
	{
		return isBust(this.handValue);
	}
	
	@Override
	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < this.getSize() - 1; i++)
		{
			sb.append(this.cards[i].toString());
			sb.append(", ");
		}
		
		sb.append(this.cards[this.getSize() - 1]);
		
		return sb.toString();
	}
	
	private static boolean isBust(byte handValue)
	{
		return handValue > MAX_HAND_VALUE;
	}
	
	private void calculateHandValue()
	{
		byte handValue = 0;
		boolean aceExists = false;
		
		for (int i = 0; i < this.getSize(); i++)
		{
			Card c = this.cards[i];
			
			if (c.getFigure() == CardFigures.ACE)
				aceExists = true;
			
			handValue += c.getValue();
		}
		
		if (isBust(handValue) && aceExists)
			handValue -= 10;
		
		this.handValue = handValue;
	}
}
