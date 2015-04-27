class PokerUnitTests {

	public static void main (String[] args) {
	
		// Card.toString()
		Card testCard = new Card(5,Card.SPADE);

		if (!testCard.toString().equals("5s")) {
			System.out.println("Test Failed: Card.toString()");
		}

	}


}