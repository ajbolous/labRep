package Views;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import Database.DbHandler;
import Server.Config;

public class Users extends View {

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