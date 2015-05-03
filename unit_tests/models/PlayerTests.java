package unit_tests.models;

import unit_tests.*;
import models.*;

public class PlayerTests extends UnitTests {
  public static void run() {
		Hand aHand = new Hand();
		Player tester = new Player(150);

		test((tester.getBalance() == 150), "Player.getBalance()");

		tester.setBalance(250);
		test((tester.getBalance() == 250), "Player.setBalance()");

  }
}
