package unit_tests.models;

import unit_tests.*;
import models.*;

public class CardTests extends UnitTests {
  public static void run() {
    Card aCard = new Card(5,Card.SPADE);

    test(aCard.toString().equals("5s"), "Card.toString()");
  }
}
