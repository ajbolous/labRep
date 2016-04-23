package Views;

import Database.DbHandler;

public abstract class View {
	
	private DbHandler db;
	public View(DbHandler db){
		this.db = db;
	}
	
	public abstract Object resolve(String view, String[] params);

	public DbHandler getDb() {
		return db;
	}
}
