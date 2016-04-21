package Server;

import com.mysql.jdbc.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.Map;

public class DbHandler {

	private Connection connection;

	public DbHandler(String ip, String db_name, String username, String password) {
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
		} catch (Exception ex) {/* handle the error */
		}

		try {
			connection = DriverManager.getConnection("jdbc:mysql://" + ip + "/"
					+ db_name, username, password);
		} catch (SQLException ex) {/* handle any errors */
		}
	}
	
	
	public ResultSet getAllUsers(){
		try {
			return execute("select * from users");
		} catch (SQLException e) {
			return null;
		}
	}
	public void addUser(User u){
	
	}
	public void changeUser(User u){
		
	}
	public User getUser(int id){
		try {
			ResultSet rs = execute("select * from users where id=" + id);
			rs.next();
			
			User u = new User();
			u.setId(rs.getInt(1));
			u.setUsername(rs.getString(2));
			u.setPassword(rs.getString(3));
			
			return u;
		} catch (SQLException e) {
			return null;
		}
	}
	
	
	public ResultSet execute(String sql) throws SQLException{
		Statement stmt = connection.createStatement();
		return stmt.executeQuery(sql);
	}
}
