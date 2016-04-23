package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Model.User;
import Utils.Logger;

public class DbHandler {

	private Connection connection;
	public Logger logger;
	
	public DbHandler(String url, String username, String password) {
		this.logger = new Logger(this);
		try {
			logger.info("Starting Database driver..");
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			logger.info("Connecting to Database " + url + " as user: " + username);
			connection = DriverManager.getConnection("jdbc:mysql://" + url, username, password);
			logger.info("Connected to database.");

		} catch (Exception ex) {
			logger.exception(ex);
		} 
	}

	public ArrayList<User> getAllUsers() {
		ArrayList<User> users = new ArrayList<User>();
		try {
			ResultSet rs = query("select * from users");
			while(rs.next()){
				User u = new User(rs.getInt(1),rs.getString(2),rs.getString(3));
				users.add(u);
			}
			rs.close();
			return users;
		} catch (SQLException e) {
			logger.exception(e);
			return null;
		}
	}

	public User getUserById(String id) {
		try {
			ResultSet rs = query("select * from users where id=" + id);
			rs.next();
			User u = new User(rs.getInt(1),rs.getString(2),rs.getString(3));
			return u;
		} catch (SQLException e) {
			logger.exception(e);
			return null;
		}
	}

	public User getUserByName(String name) {
		try {
			ResultSet rs = query("select * from users where username=" + name);
			rs.next();
			User u = new User(rs.getInt(1),rs.getString(2),rs.getString(3));
			return u;
		} catch (SQLException e) {
			logger.exception(e);
			return null;
		}
	}
	
	public void addUser(String name, String password){
		try {
			insert("insert into users values(id,'" + name + "','" + password + "');");
		} catch (SQLException e) {
		e.printStackTrace();
		}
	}
	
	public int insert(String sql) throws SQLException{
		logger.debug(sql);
		Statement stmt = connection.createStatement();
		return stmt.executeUpdate(sql);
	}
	
	public ResultSet query(String sql) throws SQLException {
		logger.debug(sql);
		Statement stmt = connection.createStatement();
		return stmt.executeQuery(sql);
	}
}
