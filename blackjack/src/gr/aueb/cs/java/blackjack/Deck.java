package gr.aueb.cs.java.blackjack;

public class Deck
{
	private Card[] cards;
	private int next;
	
	public Deck()
	{
		this.cards = Card.createCardDeck();
	}
	
	public void shuffle()
	{
		int swaps = (int) Math.pow(this.cards.length, 2);
		
		for (int i = 0; i < swaps; i++)
		{
			int split = this.cards.length / 2;
			int c1 = UtilityMethods.random(0, split - 1);
			int c2 = UtilityMethods.random(split, this.cards.length - 1);
			Card temp = this.cards[c1];
			this.cards[c1] = this.cards[c2];
			this.cards[c2] = temp;
		}
	}
	
	public Card pullCard()
	{
		if (this.next >= this.cards.length)
			return null;
		
		Card c = this.cards[this.next];
		this.cards[this.next] = null;
		this.next++;
		
		return c;
	}
}
