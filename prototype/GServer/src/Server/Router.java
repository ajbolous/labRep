package Server;

import Database.DbHandler;
import Views.*;

public class Router {
	DbHandler db;
	public Users users;
	
	public Router(DbHandler db) {
		this.db = db;
		users = new Users(db);
	}

	public Object resolve(String request) {
		String[] req = request.split("\\?");
		String[] url = req[0].split("/");
		String[] params = {};
		if(req.length>1)
			params = req[1].split(",");
		
		switch (url[0]) {
		case "users":
			return users.resolve(url[1],params);
		}
		
		return null;
 
	}


	


}
