package Views;

import Database.DbHandler;

public class Users extends View {
	
	public Users(DbHandler db){
		super(db);
	}
	public Object resolve(String view, String[] params){
		switch(view){
			case "all":return all(params);
			case "name":return byName(params);
			case "id": return byId(params);
			case "add": return add(params);
		}
		return null;
	}
	
	
	public Object all(String[] params) {
		return getDb().getAllUsers();
	}

	public Object byName(String[] params) {
		return getDb().getUserByName(params[0]);
	}

	public Object byId(String[] params) {
		return getDb().getUserById(params[0]);
	}
	
	public Object add(String[] params){
		getDb().addUser(params[0],params[1]);
		return "User added succesfully";
	}

}