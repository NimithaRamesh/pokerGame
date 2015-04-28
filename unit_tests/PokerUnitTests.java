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

		// Card.toString()
		Card aCard = new Card(5,Card.SPADE);

		test(aCard.toString().equals("5s"), "Card.toString()");

		if ( errorCount == 0 ) { System.out.println("All test passed."); }
	}


}
