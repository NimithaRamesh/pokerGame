import models.*;
import views.*;

public class PokerGame {

	private Player player;
	private MainGameFrame frame;

	PokerGame() {
		player = new Player(100, new Hand());
		frame = new MainGameFrame(player);
	}

	public MainGameFrame getFrame() {
		return frame;
	}

	public static void main (String[] args) {
		PokerGame game = new PokerGame();
		game.getFrame().setSize(800,600);
		game.getFrame().setResizable(false);
		game.getFrame().setTitle("TestFrame");
		game.getFrame().setLocationRelativeTo(null);
		game.getFrame().setVisible(true);
	}

}
