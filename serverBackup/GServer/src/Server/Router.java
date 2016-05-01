package Server;

import Utils.Request;
import Views.*;

public class Router {
	public Users users;

	public Router() {
		users = new Users();
	}

	public Object resolve(Request request) {
		switch (request.getView()) {
		case "users":
			return users.resolve(request);
		}
		return null;
	}
}