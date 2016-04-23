package Views;

import java.sql.SQLException;

import Database.DbHandler;
import Server.Config;
import Model.Report;

public class Reports extends View {

	public Object all(String[] params) {
		DbHandler db = Config.getConfig().getHandler();
		return db.getReports().getAllReports();
	}

	public Object weekly(String[] params) {
		DbHandler db = Config.getConfig().getHandler();
		return db.getReports().getWeeklyReport(params[0]);
	}

	public Object monthly(String[] params) {
		DbHandler db = Config.getConfig().getHandler();
		return db.getReports().getMonthlyReport(params[0]);
	}
}
