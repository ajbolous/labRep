package Client;

import java.io.IOException;

import ClientUI.ClientUI;
import Utils.Logger;
import ocsf.client.*;

public class Client extends AbstractClient {
	ClientUI ui;

	public Client(String host, int port, ClientUI ui) {
		super(host, port);
		try {
			this.ui = ui;
			openConnection();
		} catch (IOException e) {

		}
	}

	public void handleMessageFromServer(Object msg) {
		if (msg == null) {
			ui.display("ERROR_BAD RESPONSE");
			return;
		}
		// ui.display(msg.getClass().getName());
		// ui.display(msg);

	}

	public void handleMessageFromClientUI(String message) {
		try {
			Object response = sendToServer(message);
			ui.display(response);
		} catch (IOException | ClassNotFoundException e) {

		}
	}

	public void quit() {
		try {
			closeConnection();
		} catch (IOException e) {
		}
		System.exit(0);
	}
}