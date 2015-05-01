package controllers;

import models.*;
import views.*;

public class PokerGame {

	private Player player;
	private MainGameFrame frame;
	private Deck cardDeck;

	PokerGame() {
		player = new Player(100, new Hand());
		dealCards();
		frame = new MainGameFrame(this, player);
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
		player.getHand().replaceHighlighted();
	}

	public void placeBet(int betAmount) {
		// deduct amount from player
		player.setBalance(player.getBalance() - betAmount);

		// update Balance Display
		frame.updateBalanceDisplay(player.getBalance());

	}

	public static void main (String[] args) {
		// some random comment to test merging
		PokerGame game = new PokerGame();
		game.getFrame().setSize(800,600);
		game.getFrame().setResizable(false);
		game.getFrame().setTitle("TestFrame");
		game.getFrame().setLocationRelativeTo(null);
		game.getFrame().setVisible(true);
	}

}
