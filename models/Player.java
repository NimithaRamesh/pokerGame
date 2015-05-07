package models;

public class Player {

	private int balance;

  public Player() {
    this(100);
  }

	public Player(int balance) {
		this.balance = balance;
	}

  public int getBalance() {
    return balance;
  }

  public void setBalance(int balance) {
    this.balance = balance;
  }

}
