package gr.aueb.cs.java.blackjack;

public class BlackJackGame
{
	public static final byte MIN_DEALER_HAND = 17;
	public static final String DEALER_NAME = "DEALER";
	public static final String PLAYER_NAME = "Player";
	
	private Deck deck;
	
	public BlackJackGame()
	{
		this.deck = new Deck();
	}
	
	public void play()
	{
		this.deck.shuffle();
		HandOfCards dealerHand = new HandOfCards();
		HandOfCards playerHand = new HandOfCards();
		this.playFor(dealerHand, DEALER_NAME, MIN_DEALER_HAND);
		
		if (dealerHand.isBust())
		{
			System.out.format("%s is bust! %s won!\n", DEALER_NAME, PLAYER_NAME);
			return;
		}
		
		this.playFor(playerHand, PLAYER_NAME, dealerHand.getHandValue());
		
		if (playerHand.isBust())
		{
			System.out.format("%s is bust! %s won!\n", PLAYER_NAME, DEALER_NAME);
			return;
		}
		
		String winner;
		
		if (playerHand.getHandValue() > dealerHand.getHandValue())
		{
			winner = PLAYER_NAME;
		}
		else if (playerHand.getHandValue() < dealerHand.getHandValue())
		{
			winner = DEALER_NAME;
		}
		else
		{
			System.out.println("It's a draw!");
			return;
		}
		
		System.out.format("%s won!\n", winner);
	}
	
	private void playFor(HandOfCards playerHand, String playerName, byte minHand)
	{
		while (playerHand.getHandValue() < minHand)
		{
			this.dealNextCard(playerHand);
			System.out.format("%s: %s\n", playerName, playerHand.toString());
		}
	}
	
	private void dealNextCard(HandOfCards player)
	{
		Card c = this.deck.pullCard();
		player.addCard(c);
	}
}
