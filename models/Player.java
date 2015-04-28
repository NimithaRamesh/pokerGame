package models;

public class Player {

	private int balance;
	private Hand hand;

  public Player() {
    this(100, new Hand());
  }

	public Player(int balance, Hand hand) {
		this.balance = balance;
		this.hand = hand;
	}

  public int getBalance() {
    return balance;
  }

  public void setBalance(int balance) {
    this.balance = balance;
  }

  public Hand getHand() {
    return hand;
  }

  public void setHand(Hand hand) {
    this.hand = hand;
  }
}
