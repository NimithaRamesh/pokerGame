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
    if ( invalidIndex(index) ) { return null; }
    return this.cards[index];
  }

  public void add(int index, Card card) {
    if ( invalidIndex(index) ) { return; }
    this.cards[index] = card;
  }

  public void remove(int index) {
    if ( invalidIndex(index) ) { return; }
    this.cards[index] = null;
  }

  public void replaceSelected() {
    Deck cardDeck = new Deck();
    for( int x = 0; x < MAX_SIZE; x++ ) {
      if( cards[x].isHighlighted() ) { cards[0] = cardDeck.dealCard(); }
    }
  }

  private boolean invalidIndex(int index) {
    return (index < 0 || index >= MAX_SIZE);
  }

}
