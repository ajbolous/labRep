package Views;

import Database.DbHandler;
import Server.Config;
import Utils.Request;

public class Users extends View {

	public Object all(Request request) {
		DbHandler db = Config.getConfig().getHandler();
		return db.getUsers().getAllUsers();
	}

	public Object byName(Request request) {
		DbHandler db = Config.getConfig().getHandler();
		return db.getUsers().getUserByName((String)request.getParam("name"));
	}

	public Object byId(Request request) {
		DbHandler db = Config.getConfig().getHandler();
		return db.getUsers().getUserById((String)request.getParam("id"));
	}

	public Object add(Request request) {
		DbHandler db = Config.getConfig().getHandler();
		return "User added succesfully";
	}

}