package controllers;

import models.*;
import views.*;

public class PokerGame {

	ViewController viewController;
	Player player = new Player(100);
	Deck deck;
	Hand hand;

	PokerGame () {
		// Set vars
		viewController = new ViewController(this);
	}

	public void placeBet (int amount) {

		// Deduct balance
		player.setBalance(player.getBalance() - amount);

		// Update balance view
		viewController.updateBalanceViewAmount(player.getBalance());

		// Update console
		viewController.updateOutputConsole(OutputConsole.BET_PLACED,amount);

		// Generate new deck for round
		deck = new Deck();

		// Generate hand from deck
		hand = new Hand();

		// Add cards to hand
		for (int index = 0; index < 5; index++) {
			hand.add(index,deck.dealCard());
		}

		// Clear any previous cards off play area
		viewController.clearPlayArea();

		// Load hand into playArea
		viewController.loadHandInPlayArea(hand);

		// Notify viewController of new mode
		viewController.setMode(ViewController.MODE_DISCARD);
		
	}

	public void discardSelected () {
		// Replace highlighted
		hand.replaceHighlighted(deck);

		// Clear playArea
		viewController.clearPlayArea();

		// Load hand into play area
		viewController.loadHandInPlayArea(hand);

		// Notify viewController of new mode
		// We'll move this once we fully flesh out the loop
		viewController.setMode(ViewController.MODE_BET);

	}

	public static void main (String[] args) {

		PokerGame game = new PokerGame();

	}

}
