package views;

import java.awt.*;
import javax.swing.*;

public class OutputConsole extends JLabel {

	// Event definitions
	public static final int BET_PLACED = 1;
	public static final int ROUND_WIN = 2;
	public static final int ROUND_LOSE = 3;
	public static final int GAME_LOSE = 4;
	
	OutputConsole () {
		super("You sit down at the table.");
	}

	public void updateConsole (int event) {

		switch (event) {

			case 3:
				setText("Your cards weren't worth anything.");
				break;
			case 4:
				setText("You're out of money. You lose.");
				break;
			default:
				setText("Unknown event.");
				break;
		}
	}

	public void updateConsole (int event, int amount) {

		switch (event) {

			case 1:
				setText("You place a " + amount + " credit bet.");
				break;
			case 2:
				setText("You win " + amount + " credits. Play another round.");
				break;
			default:
				setText("Unknown event.");
				break;
		}

	}

}