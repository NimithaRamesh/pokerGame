package views;

import controllers.*;
import models.*;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*;

public class CardView extends JLabel {

	ViewController viewController;
	Card card;
	

	public CardView (ViewController viewController, Card card) {
		// Place image
		super(new ImageIcon("images/" + card.toString() + ".png"));

		// Assign vars
		this.viewController = viewController;
		this.card = card;
		
		// Build border
		setBorder(BorderFactory.createLineBorder(new Color(0,0,0),4));

		// Listener class for requesting highlight/unhighlight
		addMouseListener(new ToggleHighlightListener());

	}

	private class ToggleHighlightListener extends MouseInputAdapter {

		@Override
		public void mouseClicked (MouseEvent e) {

			// Need clearance from ViewController to effect highlight
			if (!card.isHighlighted() && viewController.canHighlight()) {
				card.toggleHighlighted();
				setBorder(BorderFactory.createLineBorder(new Color(255,255,255),4));
				return;
			}

			if (card.isHighlighted()) {
				card.toggleHighlighted();
				viewController.cardUnhilighted();
				setBorder(BorderFactory.createLineBorder(new Color(0,0,0),4));
				return;
			}

		}

	}	// end ToggleHighlightListener

}