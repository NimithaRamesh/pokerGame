package models;

public class Hand {
  private final static int MAX_SIZE = 5;
  private Card[] cards;

  public Hand() {
    this.cards = new Card[MAX_SIZE];
  }

	public Hand(Card[] cards) {
		this.cards = cards;
	}

  public Card[] getCards() {
    return cards;
  }

  public Card getCard(int index) {
    if ( index < 0 || index >= MAX_SIZE ) { return null; }
    return this.cards[index];
  }

  public void add(int index, Card card) {
    if ( index < 0 || index >= MAX_SIZE ) { return; }
    this.cards[index] = card;
  }
}
