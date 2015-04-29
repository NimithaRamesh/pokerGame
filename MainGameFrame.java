import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import models.*;
import views.*;

public class MainGameFrame extends JFrame {

	// These are temporary, we'll replace them with fully fleshed out classes later
	JLabel panelBalanceView;
	JPanel panelHandView, panelBettingView;

	HandViewer hand = new HandViewer();

	MainGameFrame (Player player) {
		setLayout(new BorderLayout());

		// panelBalanceView
		panelBalanceView = new JLabel("Player Balance: " + player.getBalance());
		panelBalanceView.setPreferredSize(new Dimension(800,50));
		panelBalanceView.setHorizontalAlignment(SwingConstants.CENTER);

		// panelHandView
		panelHandView = new JPanel();
		panelHandView.setPreferredSize(new Dimension(800,450));
		panelHandView.setBorder(new EmptyBorder(100, 0, 0, 0));
		panelHandView.setBackground(new Color(185,238,146));
		panelHandView.add(hand);


		// panelBettingView
		panelBettingView = new JPanel();
		panelBettingView.setPreferredSize(new Dimension(800,100));
		panelBettingView.setBackground(new Color(50,150,200));

		// Add elements to JFrame
		add(panelBalanceView, BorderLayout.NORTH);
		add(panelHandView, BorderLayout.CENTER);
		add(panelBettingView, BorderLayout.SOUTH);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
