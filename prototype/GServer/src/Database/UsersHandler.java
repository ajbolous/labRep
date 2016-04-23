package Database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Model.User;
import Server.Config;

public class UsersHandler {

	private Connection connection;

	public UsersHandler(Connection con) {
		connection = con;
	}

	public ArrayList<User> getAllUsers() {
		try {
			ArrayList<User> users = new ArrayList<User>();
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("select * from users");
			while (rs.next()) {
				User u = new User(rs.getInt(1), rs.getString(2), rs.getString(3));
				users.add(u);
			}
			rs.close();
			return users;
		} catch (SQLException e) {
			Config.getConfig().getLogger().exception(e);
			return null;
		}
	}

	public User getUserById(String id) {
		try {
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("select * from users where id=" + id);
			rs.next();
			User u = new User(rs.getInt(1), rs.getString(2), rs.getString(3));
			return u;
		} catch (SQLException e) {
			Config.getConfig().getLogger().exception(e);
			return null;
		}
	}

	public User getUserByName(String name) {
		try {
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("select * from users where user=" + name);
			rs.next();
			User u = new User(rs.getInt(1), rs.getString(2), rs.getString(3));
			return u;
		} catch (SQLException e) {
			Config.getConfig().getLogger().exception(e);
			return null;
		}

	}

	public void addUser(String name, String password) {
		try {
			Statement stmt = connection.createStatement();
			stmt.executeUpdate("insert into users values(id,'" + name + "','" + password + "')");
		} catch (SQLException e) {
			Config.getConfig().getLogger().exception(e);
		}

	}
}
