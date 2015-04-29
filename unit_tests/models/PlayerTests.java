package unit_tests.models;

import unit_tests.*;
import models.*;

public class PlayerTests extends UnitTests {
  public static void run() {
		Hand aHand = new Hand();
		Player tester = new Player(150, aHand);

		test((tester.getBalance() == 150), "Player.getBalance()");

		tester.setBalance(250);
		test((tester.getBalance() == 250), "Player.setBalance()");

		test(tester.getHand().equals(aHand), "Player.getHand()");

		Hand anotherHand = new Hand();
		tester.setHand(anotherHand);
		test((tester.getHand() == anotherHand), "Player.setHand()");
  }
}
