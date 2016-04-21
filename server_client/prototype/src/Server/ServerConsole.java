package Server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ServerConsole {

	private static Server server;
	private static int port;
	private static BufferedReader console = new BufferedReader(
			new InputStreamReader(System.in));
	private static DbHandler dbhandler;

	public static DbHandler getDbhandler() {
		return dbhandler;
	}

	public static void startServer() throws IOException {
		print("Please enter a port: ");
		//try {
	//		port = console.read();
	//	} catch (IOException e) {
			port = 5555;
	//	}
		server = new Server(port);
		String i = console.readLine();
		String ip, dbName, user, password;
		//try {
		//	print("Please enter the database ip: ");
		//	ip = console.readLine();
		//	print("Please enter database name: ");
		//	dbName = console.readLine();
		//	print("Please enter user name: ");
		//	user = console.readLine();
		//	print("Please enter a password : ");
		//	password = console.readLine();
		//} catch (IOException e) {
			ip = "localhost";
			dbName = "prototype";
			user = "root";
			password = "1111";
		//}

		dbhandler = new DbHandler(ip, dbName, user, password);
		try {
			server.listen();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			ServerConsole.print("error");
		}
	}

	public static void print(String str) {
		System.out.println(str);
	}

	public static void printUsers() {
		try {
			ResultSet users = dbhandler.execute("select * from users");
			while (users.next()) {
				print("id: " + users.getInt(1) + " UserName: "
						+ users.getString(2) + " Password: "
						+ users.getString(3));
			}
			users.close();
		} catch (SQLException e) {

		}

	}

	public static void loopServer() {
		while (true) {
			String s;
			try {
				s = console.readLine();
				switch (s) {
				case "start":
					startServer();
					break;
				case "print":
					print("Clients: " + server.getNumberOfClients());
					break;
				case "users":
					printUsers();
					break;
				case "server?":
					print("Server is : " + server.isListening());
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {

		loopServer();
	}

}
