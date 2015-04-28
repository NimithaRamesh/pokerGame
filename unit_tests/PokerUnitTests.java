package unit_tests;

import models.*;

class PokerUnitTests {

	private static int errorCount = 0;

	public static void test(boolean assertion, String subject) {
		if (!assertion) {
			System.out.println("Test Failed: " + subject);
			errorCount++;
		}
	}

	public static void main (String[] args) {

		// ---- Card assertions ----
		Card aCard = new Card(5,Card.SPADE);

		test(aCard.toString().equals("5s"), "Card.toString()");

		// ---- Player assertions ----
		Hand aHand = new Hand();
		Player tester = new Player(150, aHand);

		test((tester.getBalance() == 150), "Player.getBalance()");

		tester.setBalance(250);
		test((tester.getBalance() == 250), "Player.setBalance()");

		test(tester.getHand().equals(aHand), "Player.getHand()");

		Hand anotherHand = new Hand();
		tester.setHand(anotherHand);
		test((tester.getHand() == anotherHand), "Player.setHand()");

		// ---- Hand assertions ----
		Card card1 = new Card(5,Card.SPADE);
		Card card2 = new Card(9,Card.CLUB);
		Card card3 = new Card(Card.QUEEN,Card.SPADE);
		Card[] cards = new Card[5];
		Hand testHand = new Hand(cards);
		testHand.add(0, card1);
		testHand.add(1, card2);

		test((testHand.getCards().equals(cards)), "Hand.getCards()");

		test((testHand.getCard(0).equals(card1)), "Hand.getCard() with valid index");
		test((testHand.getCard(200) == null), "Hand.getCard() with invalid index");

		testHand.add(2, card3);
		test((testHand.getCard(2).equals(card3)), "Hand.add() with valid index");

		if ( errorCount == 0 ) { System.out.println("All test passed."); }
	}


}
