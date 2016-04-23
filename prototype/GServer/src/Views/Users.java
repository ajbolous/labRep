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
		Config cfg = Config.getConfig();
		DbHandler db = new DbHandler(cfg.getDbUrl(), cfg.getDbUser(), cfg.getDbPassword());
		return db.getUsers().getAllUsers();
	}

	public Object byName(String[] params) {
		Config cfg = Config.getConfig();
		DbHandler db = new DbHandler(cfg.getDbUrl(), cfg.getDbUser(), cfg.getDbPassword());
		return db.getUsers().getUserByName(params[0]);
	}

	public Object byId(String[] params) {
		Config cfg = Config.getConfig();
		DbHandler db = new DbHandler(cfg.getDbUrl(), cfg.getDbUser(), cfg.getDbPassword());
		return db.getUsers().getUserById(params[0]);
	}

	public Object add(String[] params) {
		Config cfg = Config.getConfig();
		DbHandler db = new DbHandler(cfg.getDbUrl(), cfg.getDbUser(), cfg.getDbPassword());
		return "User added succesfully";
	}

}