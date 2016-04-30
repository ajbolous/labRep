package Views;

import Database.DbHandler;
import Server.Config;
import Utils.Request;

public class Doctors extends View {

	public Object all(Request request) {
		DbHandler db = Config.getConfig().getHandler();
		return db.getDoctors().getAllDoctors();
	}

	
	public Object byId(Request request) {
		DbHandler db = Config.getConfig().getHandler();
		return db.getUsers().getUserById((String)request.getParam("id"));
	}
	






}
