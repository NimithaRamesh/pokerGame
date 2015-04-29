package unit_tests.views;

import unit_tests.*;
import views.*;
import models.*;

public class HandViewerTests extends UnitTests {
  public static void run() {
    Card card1 = new Card(5,Card.SPADE);
    Card card2 = new Card(9,Card.CLUB);
    Card card3 = new Card(Card.QUEEN,Card.SPADE);
    Card[] cards = { card1, card2, card3, card1, card1 };
    Hand testHand = new Hand(cards);

    HandViewer handView = new HandViewer(testHand);
    test(handView.getCurrentHand()[0].getCard() == card1, "Constructor assigns cards correctly.");
    test(handView.getCurrentHand()[1].getCard() == card2, "Constructor assigns cards correctly.");
    test(handView.getCurrentHand()[2].getCard() == card3, "Constructor assigns cards correctly.");
  }
}
