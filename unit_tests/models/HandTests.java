package unit_tests.models;

import unit_tests.*;
import models.*;

public class HandTests extends UnitTests {
  public static void run() {
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

    testHand.remove(2);
    test((testHand.getCard(2) == null), "Hand.remove() with valid index");

    testHand.add(2, card3);
    testHand.add(3, card1);
    testHand.add(4, card1);
    test(testHand.isPresent(5, Card.SPADE), "Hand.isPresent() when card is present");
    test(!testHand.isPresent(5, Card.CLUB), "Hand.isPresent() when card is not present");

    card2.toggleHighlighted();
    testHand.replaceHighlighted();
    test(!testHand.getCard(1).equals(card2), "Hand.replaceHighlighted()");
  }
}
