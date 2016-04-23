package Server;

import java.io.IOException;
import Utils.Logger;

import Database.DbHandler;
import Model.*;
import ocsf.server.*;

public class Server extends AbstractServer {
	private DbHandler db;
	private Logger logger;
	private Router router;
	
	public Server(int port, DbHandler db) {
		super(port);
		this.logger = new Logger(this);
		this.db = db;
		this.router = new Router(db);
		logger.info("Starting local TCP server at " + port);
	}

	protected void printStatus() {
		logger.info("------------------------------------------------");
		logger.info("Server status is " + (this.isListening() == true ? "online" : "offline"));
		logger.info("Server is running at port " + this.getPort());
		logger.info("Number of clients connected " + this.getNumberOfClients());
		logger.info("-----------------------------------------------");
	}

	protected void serverStarted() {
		printStatus();
	}

	protected void clientConnected(ConnectionToClient client) {
		logger.info("New client connected: " + client.getInetAddress());
		printStatus();
	}

	protected void serverStopped() {
	}
	

	public void Response(ConnectionToClient client, Object obj){
		try {
			client.sendToClient(obj);
		} catch (IOException e) {
			logger.error("SORRY");
		}
	}
	

	protected void handleMessageFromClient(Object request, ConnectionToClient client) {
		logger.info("REQUEST (" + client.getInetAddress() + ") : " + request.toString());
		Response(client, router.resolve(request.toString()));
	}

	public static void main(String[] args) {
		int port;
		String url, user, pass;
		Logger log = new Logger();
		port = Integer.parseInt(args[0]);
		url = args[1];
		user = args[2];
		pass = args[3];

		log.debug("Recieved number of parameters: " + args.length);
		log.debug("URL : " + url);
		log.debug("PORT : " + port);
		log.debug("USER : " + user);
		log.debug("PASSWORD : " + pass);

		DbHandler db = new DbHandler(url, user, pass);
		Server server = new Server(port, db);

		try {
			server.listen();
		} catch (IOException e) {
			log.exception(e);
		}
	}
}
