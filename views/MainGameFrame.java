package views;

import controllers.*;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;


public class MainGameFrame extends JFrame {

	ViewController viewController;

	public JLabel balanceView = new JLabel("Player Balance: 100");
	public JPanel playAreaView = new JPanel();
	public InputView inputView;

	public MainGameFrame (ViewController vc) {


		setSize(800,600);
		setResizable(false);
		setTitle("Pokerface");
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Assign vars
		this.viewController = vc;
		inputView = new InputView(vc,100);

		// Configure frame
		setLayout(new BorderLayout());


		// Configure balanceView;
		balanceView.setPreferredSize(new Dimension(800,50));
		balanceView.setHorizontalAlignment(SwingConstants.CENTER);

		// Configure playAreaView
		playAreaView.setLayout(new GridLayout(1,0,0,0));
		playAreaView.setPreferredSize(new Dimension(800,450));
		playAreaView.setBorder(new EmptyBorder(100,0,100,0));
		playAreaView.setBackground(new Color(50,150,200));

		// Add elements to frame
		add(balanceView, BorderLayout.NORTH);
		add(playAreaView, BorderLayout.CENTER);
		add(inputView, BorderLayout.SOUTH);

		setVisible(true);

	}

}