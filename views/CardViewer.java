package views;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*;
import models.*;

public class CardViewer extends JLabel {

	public Card card;

	public CardViewer (Card card) {
		super(new ImageIcon("images/" + card.toString() + ".png"));
		this.card = card;

		// Add action listener
		addMouseListener(new HighlightCardOnClick());
		setBorder(BorderFactory.createLineBorder(new Color(185,236,146),4));

	}

	public Card getCard() {
		return card;
	}

    class HighlightCardOnClick extends MouseInputAdapter {

        @Override
        public void mouseClicked (MouseEvent e) {
            if (!card.isHighlighted()) {
            	card.toggleHighlighted();
            	setBorder(BorderFactory.createLineBorder(new Color(255,0,0),4));
            } else {
            	card.toggleHighlighted();
            	setBorder(BorderFactory.createLineBorder(new Color(185,236,146),4));
            }

        }

    }
    
}
