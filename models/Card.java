package models;

public class Card {

	public final static int ACE = 1;
	public final static int JACK = 11;
	public final static int QUEEN = 12;
	public final static int KING = 13;

	public final static int CLUB = 100;
	public final static int DIAMOND = 101;
	public final static int HEART = 102;
	public final static int SPADE = 103;

	private final int rank;
	private final int suit;

	public boolean highlighted = false;

	public Card (int rank, int suit) {
		this.rank = rank;
		this.suit = suit;
	}

	public String toString () {

		String suitAsString = null;

		switch (suit) {
			case CLUB:
				suitAsString = "c";
				break;

			case DIAMOND:
				suitAsString = "d";
				break;

			case HEART:
				suitAsString = "h";
				break;

			case SPADE:
				suitAsString = "s";
				break;
		}

		return rank + suitAsString;

	}

	public int getRank() {
		return rank;
	}

	public int getSuit() {
		return suit;
	}

	public void toggleHighlighted () {
		/* toggled by clicking the CardView representation of this card */
		highlighted = highlighted ? false : true;
		// System.out.println("card set to: " + highlighted);
	}

	public boolean isHighlighted () {
		return highlighted;
	}


}
