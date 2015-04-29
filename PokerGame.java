import models.*;
import views.*;

public class PokerGame {

	private Player player;
	private MainGameFrame frame;
	private Deck cardDeck;

	PokerGame() {
		player = new Player(100, new Hand());
		// dealCards();
		frame = new MainGameFrame(player);
	}

	public MainGameFrame getFrame() {
		return frame;
	}

	// deals 5 cards to the player's hand
	public void dealCards() {
		Deck cardDeck = new Deck();
		for (int x = 0; x < 5; x++) {
			player.getHand().add(x, cardDeck.dealCard());
		}
	}

	// replaces selected cards with new ones
	public void reDealCards() {
		player.getHand().replaceSelected();
	}

	public static void main (String[] args) {
		PokerGame game = new PokerGame();
		game.getFrame().setSize(800,600);
		game.getFrame().setResizable(false);
		game.getFrame().setTitle("TestFrame");
		game.getFrame().setLocationRelativeTo(null);
		game.getFrame().setVisible(true);
	}

}
