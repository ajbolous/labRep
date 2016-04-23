package Server;

import Utils.Logger;

public class Config {
	private String dbUrl = "localhost/test";
	private String dbUser = "root";
	private String dbPassword = "123123";
	private Logger logger = new Logger();
	private int port = 5000;

	private static Config instance = new Config();

	private Config() {
	}

	public static Config getConfig() {
		return instance;
	}

	public String getDbUrl() {
		return dbUrl;
	}

	public void setDbUrl(String dbUrl) {
		this.dbUrl = dbUrl;
	}

	public String getDbUser() {
		return dbUser;
	}

	public void setDbUser(String dbUser) {
		this.dbUser = dbUser;
	}

	public String getDbPassword() {
		return dbPassword;
	}

	public void setDbPassword(String dbPassword) {
		this.dbPassword = dbPassword;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public Logger getLogger() {
		return logger;
	}

	public void setLogger(Logger logger) {
		this.logger = logger;
	}

}
