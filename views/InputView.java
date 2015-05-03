package views;

import models.*;
import controllers.*;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*;


public class InputView extends JPanel {

	ViewController viewController;

	// Betting Controls and Readout
	JButton decrementButton = new JButton("-1");
	JButton incrementButton = new JButton("+1");
	JLabel betAmount = new JLabel("1");

	// Listeners
	MouseListener decrementListener = new DecrementBetOnClick();
	MouseListener incrementListener = new IncrementBetOnClick();
	MouseListener betListener = new PlaceBetOnClick();
	MouseListener discardListener = new DiscardCardsOnClick();

	//PlaceBet Button
	JButton userActionButton = new JButton();

	int currentBetAmount = 1;
	int currentPlayerBalance;


	public InputView (ViewController vc, int initPlayerBalance) {

		// Assign variables
		this.viewController = vc;
		this.currentPlayerBalance = initPlayerBalance;

		//	Configure frame layout along x-axis
		setLayout(new BoxLayout(this,BoxLayout.X_AXIS));
		setPreferredSize(new Dimension(800,100));

		// Intial Configuration for ActionButton
		// Note: this also sets up the betting buttons
		setUserActionButtonBetMode();

		// add elements to frame
		add(decrementButton);
		add(betAmount);
		add(incrementButton);
		add(userActionButton);

	}

	public void setUserActionButtonBetMode () {

		// Swap discardListener for betListener
		userActionButton.removeMouseListener(discardListener);
		userActionButton.addMouseListener(betListener);

		enableBettingButtons();

		userActionButton.setText("Place Bet");

	}

	public void setUserActionButtonDiscardMode () {

		// Swap betListener for discardListener
		userActionButton.removeMouseListener(betListener);
		userActionButton.addMouseListener(discardListener);

		disableBettingButtons();

		userActionButton.setText("Discard Cards");

	}

	public void disableBettingButtons() {
		/* Nota bene - disabling a button does NOT disable the
			underlying mouse or event listeners. Gotta pull
			those separately. */

		decrementButton.removeMouseListener(decrementListener);
		incrementButton.removeMouseListener(incrementListener);

		decrementButton.setEnabled(false);
		incrementButton.setEnabled(false);
	}

	public void enableBettingButtons() {
		decrementButton.addMouseListener(decrementListener);
		incrementButton.addMouseListener(incrementListener);

		decrementButton.setEnabled(true);
		incrementButton.setEnabled(true);
	}


	class IncrementBetOnClick extends MouseInputAdapter {
		/* Increments currentBetAmount by 1 up to
			a maximum of the player's current balance */

		@Override
		public void mouseClicked (MouseEvent e) {

			if (currentBetAmount < currentPlayerBalance) {
				currentBetAmount+= 1;
				betAmount.setText(String.valueOf(currentBetAmount));
			}
		}
	}

	class DecrementBetOnClick extends MouseInputAdapter {
		/* Decrements currenBetAmount by 1 down to
			a minimum of 1 */

		@Override
		public void mouseClicked (MouseEvent e) {

			if (currentBetAmount >= 2) {
				currentBetAmount-= 1;
				betAmount.setText(String.valueOf(currentBetAmount));
			}
		}
	}

	class PlaceBetOnClick extends MouseInputAdapter {
		/* Sends currentBetAmount to Controller and changes
			this frame's layout to Discard mode */

		@Override
		public void mouseClicked (MouseEvent e) {
			setUserActionButtonDiscardMode();
			viewController.relayBetToGameController(currentBetAmount);
		}

	}

	class DiscardCardsOnClick extends MouseInputAdapter {
		/* this class signals PokerGame by way of MainGameFrame
		that the user is done with selecting discards */

		@Override
		public void mouseClicked (MouseEvent e) {
			setUserActionButtonBetMode();
			// holding pattern for now
			viewController.relayDiscardCommandToGameController();
		}
	}


}
