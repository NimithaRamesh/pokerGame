import java.util.Stack;
import java.util.Collections;

class Deck {

	Stack<Card> deck  = new Stack<>();

	Deck () {

		for (int rank = Card.ACE; rank <= Card.KING; rank++) {
			for (int suit = Card.CLUB; suit <= Card.SPADE; suit++) {
				deck.push(new Card(rank,suit));
			}
		}

	Collections.shuffle(deck);

	}

	public Card dealCard () {

		return deck.pop();

	}

}



