package Server;

import java.io.IOException;
import Utils.Logger;

import Database.DbHandler;
import Model.*;
import ocsf.server.*;

public class Server extends AbstractServer {
	private Logger logger;
	private Router router;

	public Server(int port) {
		super(port);
		this.logger = Config.getConfig().getLogger();
		this.router = new Router();
		logger.info("Starting local TCP server at " + port);
	}

	protected void printStatus() {
		logger.info("-------------------------------------");
		logger.info("Server status is " + (this.isListening() == true ? "online" : "offline"));
		logger.info("Server is running at port " + this.getPort());
		logger.info("Number of clients connected " + this.getNumberOfClients());
		logger.info("-------------------------------------");
	}

	protected void serverStarted() {
		printStatus();
	}

	protected void clientConnected(ConnectionToClient client) {
		logger.info("New client connected: " + client.getInetAddress() + ", total : " + this.getNumberOfClients());
	}
	
	protected void clientDisconnected(ConnectionToClient client){
		logger.info("client disconnected: " + client.getInetAddress() + ", total : " + this.getNumberOfClients());
	}

	protected void serverStopped() {
		logger.error("SERVER STOPPED..");
		printStatus();
	}

	public void Response(ConnectionToClient client, Object obj) {
		try {
			client.sendToClient(obj);
		} catch (IOException e) {
			logger.error("Response not sent");
		}
	}

	protected void handleMessageFromClient(Object request, ConnectionToClient client) {
		logger.info("REQUEST (" + client.getInetAddress() + ") : " + request.toString());
		Response(client, router.resolve(request.toString()));
	}

	public static void main(String[] args) {
		int port;
		
		String url, user, pass;
		Config cfg = Config.getConfig();//ba5od instatnce ta3 al config
		Logger log = cfg.getLogger();
		
		port = Integer.parseInt(args[0]);
		url = args[1];
		user = args[2];
		pass = args[3];

		log.debug("Number of parameters: " + args.length);
		log.debug("URL : " + url);
		log.debug("PORT : " + port);
		log.debug("USER : " + user);
		log.debug("PASSWORD : " + pass);

		Server server = new Server(cfg.getPort());

		try {
			server.listen();
		} catch (IOException e) {
			log.exception(e);
		}
	}
}
