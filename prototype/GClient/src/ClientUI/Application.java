package ClientUI;

import Client.Client;
import Client.Config;

public class Application {

	public static Client client = null;

	public static void connect() {
		Config cfg = Config.getConfig();
		if (client != null) {
			client.close();
			client = null;
		}
		client = new Client(cfg.getHost(), cfg.getPort());
		client.open();
	}

	public static void main(String[] args) {
		connect();
		ClientUI ui = new ClientUI();

	}
}
