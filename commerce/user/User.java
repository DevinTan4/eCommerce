package commerce.user;

import commerce.manager.AuthenticationManager;

public class User {
	private int id;
	
	public User(int id) {
		this.id = id;
	}

	public int getId() {
        return id;
    }
}
