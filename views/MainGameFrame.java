package views;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import models.*;
import controllers.*;

public class MainGameFrame extends JFrame {

	PokerGame controller;
	Player player;

	// These are temporary, we'll replace them with fully fleshed out classes later
	JLabel panelBalanceView;
	JPanel panelHandView;
	InputView inputView;
	HandViewer handView;

	public MainGameFrame (PokerGame controller, Player player) {
		// assign vars
		this.controller = controller;
		this.player = player;

		setLayout(new BorderLayout());
		handView = new HandViewer(player.getHand());
		// panelBalanceView
		panelBalanceView = new JLabel("Player Balance: " + player.getBalance());
		panelBalanceView.setPreferredSize(new Dimension(800,50));
		panelBalanceView.setHorizontalAlignment(SwingConstants.CENTER);

		// panelHandView
		panelHandView = new JPanel();
		panelHandView.setPreferredSize(new Dimension(800,450));
		panelHandView.setBorder(new EmptyBorder(100, 0, 0, 0));
		panelHandView.setBackground(new Color(185,238,146));
		panelHandView.add(handView);

		// inputView
		inputView = new InputView(this, player);

		// Add elements to JFrame
		add(panelBalanceView, BorderLayout.NORTH);
		add(panelHandView, BorderLayout.CENTER);
		add(inputView, BorderLayout.SOUTH);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void relayBetAmountToController (int betAmount) {
		controller.placeBet(betAmount);
	}

	public void updateBalanceDisplay (int playerBalance) {
		panelBalanceView.setText("Player Balance: " + playerBalance);
	}
}
