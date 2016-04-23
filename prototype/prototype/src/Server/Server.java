package Server;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import ocsf.server.*;

public class Server extends AbstractServer {

	public Server(int port) {
		super(port);
	}

	protected void serverStarted() {
		ServerConsole.print("Started");

	}

	protected void serverStopped() {
	}

	@Override
	protected void handleMessageFromClient(Object msg, ConnectionToClient client) {
		DbHandler dbhandler = ServerConsole.getDbhandler();
		String response = "";
		ServerConsole.print(msg.toString());
		if(msg.equals("user")){
			try {
				User user = dbhandler.getUser(1);
				
				client.sendToClient(user);
			} catch (IOException e) {
				ServerConsole.print("error " + e);
			}
		}
	}
}
