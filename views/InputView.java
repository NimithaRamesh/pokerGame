package views;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*;

public class InputView extends JPanel {

	JButton decrementButton, incrementButton, placeBetButton, discardCardsButton;
	JLabel betAmount;

	int currentBetAmount = 1;
	int currentPlayerBalance;

	Boolean betPlaced;


	public InputView (int initialPlayerBalance) {

		// configure frame layout
		setLayout(new BoxLayout(this,BoxLayout.X_AXIS));
		setPreferredSize(new Dimension(800,100));

		// retrieve initial player balance
		currentPlayerBalance = initialPlayerBalance;

		// configure decrement button
		decrementButton = new JButton("-1");
		decrementButton.addMouseListener(new DecrementBetOnClick());

		// configure betAmount label
		betAmount = new JLabel(String.valueOf(currentBetAmount));

		// configure increment button
		incrementButton = new JButton("+1");
		incrementButton.addMouseListener(new IncrementBetOnClick());

		// configure place bet button
		placeBetButton = new JButton("Place Bet");
		placeBetButton.addMouseListener(new PlaceBetOnClick());

		// add elements to frame
		add(decrementButton);
		add(betAmount);
		add(incrementButton);
		add(placeBetButton);


	}

	public int getBet (int currentPlayerBalance) {

		// store new player balance
		this.currentPlayerBalance = currentPlayerBalance;

		betPlaced = false;

		while (!betPlaced)
		{
			// betPlaced will toggle to true upon click of placeBetButton
			// until then just chill out
		}

		System.out.println("Bet amount of " + currentBetAmount + " was placed.");

		return currentBetAmount;

	}

	class IncrementBetOnClick extends MouseInputAdapter {
		/* this class will increment the bet amount and update
			the relevant display, if permissable, upon every click
			of incrementButton */

		@Override
		public void mouseClicked (MouseEvent e) {

			if (currentBetAmount < currentPlayerBalance)
			{
				currentBetAmount+= 1;
				betAmount.setText(String.valueOf(currentBetAmount));
			}
		}
	}

	class DecrementBetOnClick extends MouseInputAdapter {
		/* this class will decrement the bet amount and update
			the relevant display, if permissable, upon every click
			of decrementButton */

		@Override
		public void mouseClicked (MouseEvent e) {

			if (currentBetAmount >= 2)
			{
				currentBetAmount-= 1;
				betAmount.setText(String.valueOf(currentBetAmount));
			}
		}
	}

	class PlaceBetOnClick extends MouseInputAdapter {
		/* this class will close out the getBet loop and return a bet
			to the controller when placeBetButton is clicked */

		@Override
		public void mouseClicked (MouseEvent e) {
			betPlaced = true;
		}

	}


}