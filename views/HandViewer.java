package views;

import java.awt.*;
import javax.swing.*;
import models.*;

public class HandViewer extends JPanel {

	CardViewer[] currentHand = new CardViewer[5];
	private Hand hand;

	public HandViewer (Hand hand) {
		this.hand = hand;
		setLayout(new GridLayout(1,0,5,0));
		setBackground(new Color(185,236,146));
		populateCardViews();
	}

	public void populateCardViews() {
		this.removeAll();
		for (int x = 0; x < 5; x++) {
			currentHand[x] = new CardViewer(hand.getCard(x));
			add(currentHand[x]);
		}
	}

	public CardViewer[] getCurrentHand() {
		return currentHand;
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
