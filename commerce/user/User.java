package commerce.user;

import commerce.manager.AuthenticationManager;

public class User {
	private int id;
	private double balance = 100000;
	
	public User(int id) {
		this.id = id;
	}

	public int getId() {
        return id;
    }
	
	public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
