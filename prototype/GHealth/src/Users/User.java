package Users;

import java.io.Serializable;

public class User extends Person implements Serializable {
	
	private String password;

		
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String toString() {
		return String.format("<User %d,%s,%s>", id, username, password);
	}

}
