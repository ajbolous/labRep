package Database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Server.Config;
import Users.Doctor;


public class DoctorsHandler {

	private Connection connection;

	public DoctorsHandler(Connection con) {
		connection = con;
	}

	public ArrayList<Doctor> getAllDoctors() {
		try {
			ArrayList<Doctor> doctors = new ArrayList<Doctor>();
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("select * from physician");
			while (rs.next()) {
				Doctor d = new Doctor();
				doctors.add(d);
			}
			rs.close();
			return doctors;
		} catch (SQLException e) {
			Config.getConfig().getLogger().exception(e);
			return null;
		}
	} 

	public Doctor getDoctorById(String id) {
		try {
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("select * from physician where id=" + id);
			rs.next();
			Doctor d = new Doctor();
			return d;
		} catch (SQLException e) {
			Config.getConfig().getLogger().exception(e);
			return null;
		}
	}

	
	

	public void addDoctor(String name, String password) {
		try {
			Statement stmt = connection.createStatement();
			stmt.executeUpdate("insert into physician values(id,'" + name + "','" + password + "')");
		} catch (SQLException e) {
			Config.getConfig().getLogger().exception(e);
		}

	}
	public void addSpecialization(String Specialization) {
		try {
			Statement stmt = connection.createStatement();
			stmt.executeUpdate("insert into physician values(Specialization,'" + Specialization );
		} catch (SQLException e) {
			Config.getConfig().getLogger().exception(e);
		}

	}
}
