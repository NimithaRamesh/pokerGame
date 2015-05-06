package controllers;

import models.*;
import views.*;

public class PokerGame {

	ViewController viewController;
	Player player = new Player(100);
	Deck deck;
	Hand hand;
	int currentBet;

	PokerGame () {
		// Set vars
		viewController = new ViewController(this, player);
	}

	public void placeBet (int amount) {
		// Set current bet
		currentBet = amount;

		// Deduct balance and update balance view
		incrementAndUpdatePlayerBalance(-amount);

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

		int scoreMultiplier;

		Score score = new Score(hand);

		// Replace highlighted
		hand.replaceHighlighted(deck);

		// Clear playArea
		viewController.clearPlayArea();

		// Load hand into play area
		viewController.loadHandInPlayArea(hand);

		// Apply score multiplier
		scoreMultiplier = score.scoreMultiplier();
		incrementAndUpdatePlayerBalance(currentBet * scoreMultiplier);

		viewController.updateOutputConsole(score.toString());

		// Notify viewController of new mode
		viewController.setMode(ViewController.MODE_SCORE);


		// need check method for balance > 0
		if (player.getBalance() <= 0) {
			viewController.gameOver();
		}

	}

	public void nextRoundStart () {

		// Clear play area
		viewController.clearPlayArea();

		// Load hand into playArea
		viewController.loadEmptyHandInPlayArea();
		
		// Notify viewController of new mode
		viewController.setMode(ViewController.MODE_BET);

		viewController.updateOutputConsole(OutputConsole.PROMPT_PLACE_BET);

	}

	private void incrementAndUpdatePlayerBalance(int increment) {
		// Increment player balance
		player.setBalance(player.getBalance() + increment);
		// Update balance view
		viewController.updateBalanceViewAmount(player.getBalance());
	}

	public static void main (String[] args) {

		PokerGame game = new PokerGame();

	}

}
