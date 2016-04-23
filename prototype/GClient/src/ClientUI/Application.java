package ClientUI;

import Client.Client;
import Client.Config;

public class Application {

	public static Client client;

	public static void main(String[] args) {
		Config cfg = Config.getConfig();
		client = new Client(cfg.getHost(), cfg.getPort());
		client.open();
		Login login = new Login();

	}
}
