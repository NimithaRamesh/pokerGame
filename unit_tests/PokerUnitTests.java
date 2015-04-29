package unit_tests;

import models.*;
import unit_tests.models.*;

class PokerUnitTests {
	public static void main (String[] args) {
		// Model tests
		CardTests.run();
		PlayerTests.run();
		HandTests.run();

		UnitTests.report();
	}
}
