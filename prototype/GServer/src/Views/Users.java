package Views;

import Database.DbHandler;
import Server.Config;

public class Users extends View {

	public Users() {
		super();
	}

	public Object resolve(String view, String[] params) {
		switch (view) {
		case "all":
			return all(params);
		case "name":
			return byName(params);
		case "id":
			return byId(params);
		case "add":
			return add(params);
		}
		return null;
	}

	public Object all(String[] params) {
		DbHandler db = Config.getConfig().getHandler();
		return db.getUsers().getAllUsers();
	}

	public Object byName(String[] params) {
		DbHandler db = Config.getConfig().getHandler();
		return db.getUsers().getUserByName(params[0]);
	}

	public Object byId(String[] params) {
		DbHandler db = Config.getConfig().getHandler();
		return db.getUsers().getUserById(params[0]);
	}

	public Object add(String[] params) {
		DbHandler db = Config.getConfig().getHandler();
		return "User added succesfully";
	}

}