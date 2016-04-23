package Client;

import java.io.IOException;

import ClientUI.ClientUI;
import Utils.Logger;
import ocsf.client.*;

public class Client extends AbstractClient {
	public Client(String host, int port) {
		super(host, port);
		try {
			openConnection();
		} catch (IOException e) {

		}
	}

	public void handleMessageFromServer(Object msg) {
	}

	public Object Request(String request) {
			try {
				return this.sendToServer(request);
			} catch (ClassNotFoundException | IOException e) {
				e.printStackTrace();
				return null;
			}
	}
	
	protected void finalize(){
		close();
	}
	public void close() {
		try {
			closeConnection();
		} catch (IOException e) {
		}
	}
}