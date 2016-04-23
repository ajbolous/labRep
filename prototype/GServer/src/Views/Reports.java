package Views;
import java.sql.SQLException;

import Database.DbHandler;
import Server.Config;
import Model.Report;
public class Reports extends View 
{
	public Reports() {
		super();
	}

	@Override
	public Object resolve(String view, String[] params) throws SQLException 
	{
		switch (view) {
		case "all":
			return all(params);
		case "weekly":
			return weekly(params,date);
		case "monthly":
			return monthly(params);
		case "n-months":
			
			return nMonths(params);
		case "periodic":
			return periodic(params);
		}
		return null;
	}
	public Object all(String[] params) {
		Config cfg = Config.getConfig();
		DbHandler db = new DbHandler(cfg.getDbUrl(), cfg.getDbUser(), cfg.getDbPassword());
		return db.getReports().getAllReports();
	}
	public Object weekly(String[] params,String date) {
		Config cfg = Config.getConfig();
		DbHandler db = new DbHandler(cfg.getDbUrl(), cfg.getDbUser(), cfg.getDbPassword());
		return db.getReports().getWeeklyReport(date);
	
	}
	public Object monthly(String[] params) {
		Config cfg = Config.getConfig();
		DbHandler db = new DbHandler(cfg.getDbUrl(), cfg.getDbUser(), cfg.getDbPassword());
		return db.getReports().getMonthlyReport(params.toString());
	
	}
}
