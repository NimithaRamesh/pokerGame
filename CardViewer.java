import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*;

class CardViewer extends JLabel {

	boolean isSelectable = true;
	boolean selected = false;
	
	CardViewer (Card card) {

		super(new ImageIcon("images/" + card.toString() + ".png")); 

		// Add action listener
		addMouseListener(new HighlightCardOnClick());
		setBorder(BorderFactory.createLineBorder(new Color(185,236,146),4));

	}

	// plus some eventlistener stuff
    class HighlightCardOnClick extends MouseInputAdapter {
  
        // on click, sends task data to TaskDisplay
        @Override
        public void mouseClicked (MouseEvent e) {
            if (!selected) {
            	selected = true;
            	setBorder(BorderFactory.createLineBorder(new Color(255,0,0),4));
            } else {
            	selected = false;
            	setBorder(BorderFactory.createLineBorder(new Color(185,236,146),4));
            }
        }

    }

    public boolean isSelected () {
    	return selected;
    }


}