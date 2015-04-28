package views;

import java.awt.*;
import javax.swing.*;
import models.*;

public class HandViewer extends JPanel {

	CardViewer[] currentHand = new CardViewer[5];

	public HandViewer () {

		setLayout(new GridLayout(1,0,5,0));
		setBackground(new Color(185,236,146));

		Deck cardDeck = new Deck();

		for (int x = 0; x < 5; x++)
		{
			currentHand[x] = new CardViewer(cardDeck.dealCard());
			add(currentHand[x]);

		}

	}
	/*
	public void discardSelected () {

		for (int x = 0; x < 5; x++) {

			if (currentHand[x].isSelected()) {
				currentHand[x] = new CardViewer(cardDeck.dealCard());
			}

		}	// end for loop


		removeAll();

		for (int x = 0; x < 5; x++) {
			add(currentHand[x]);
		}

	}
	*/

}
