package gr.aueb.cs.java.blackjack;

public class Card 
{
	private byte shape;
	private byte figure;
	
	private Card(byte shape, byte figure)
	{
		this.shape = shape;
		this.figure = figure;
	}
	
	public byte getFigure()
	{
		return this.figure;
	}
	
	public byte getShape()
	{
		return this.shape;
	}
	
	public byte getValue()
	{
		return CardFigures.getValue(this.figure);
	}
	
	@Override
	public String toString()
	{
		return CardFigures.toString(this.figure) + CardShapes.toString(this.shape);
	}
	
	public static Card[] createCardDeck()
	{
		byte[] shapes = CardShapes.getValues();
		byte[] figures = CardFigures.getValues();
		Card[] deck = new Card[shapes.length * figures.length];
		int current = 0;
		
		for (int i = 0; i < shapes.length; i++)
		{
			for (int j = 0; j < figures.length; j++)
			{
				deck[current++] = new Card(shapes[i], figures[j]);
			}
		}
		
		return deck;
	}
}
