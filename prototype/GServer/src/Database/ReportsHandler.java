package Database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import Model.User;
import Server.Config;
import Model.Report;

public class ReportsHandler {
	private Connection connection;

	public ReportsHandler(Connection con) {
		connection = con;
	}

	public ArrayList<Report> getAllReports() {
		try {
			ArrayList<Report> reports = new ArrayList<Report>();
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("select * from reports");
			while (rs.next()) {
				Report r = new Report(rs.getInt(1), rs.getString(2));
				reports.add(r);
			}
			rs.close();
			return reports;
		} catch (SQLException e) {
			Config.getConfig().getLogger().exception(e);
			return null;
		}
	}

	public Report getWeeklyReport(String date) {

		try {
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("select * from reports where date=" + date);
			rs.next();
			Report r = new Report(rs.getInt(1), rs.getString(2));
			return r;
		} catch (SQLException e) {
			Config.getConfig().getLogger().exception(e);
			return null;
		}
	}

	public Report getMonthlyReport(String date) {

		try {
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("select * from reports where date=" + date);
			rs.next();
			Report r = new Report(rs.getInt(1), rs.getString(2));
			return r;
		} catch (SQLException e) {
			Config.getConfig().getLogger().exception(e);
			return null;
		}
	}

	public Report getNmonthsReport(int n) {
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
		Date cdate = new Date();

		Calendar cal = Calendar.getInstance();
		cdate = cal.getTime();
		try {
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("select * from reports where date=cdate-n*30" + n);
			rs.next();
			Report r = new Report(rs.getInt(1), rs.getString(2));
			return r;
		} catch (SQLException e) {
			Config.getConfig().getLogger().exception(e);
			return null;
		}
	}

}