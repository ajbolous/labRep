package Utils;

import java.util.Date;

public class Logger {

	public static boolean isDebug = false;
	public Date date = new Date();
	public Object source;
	public String prefix = "";

	public Logger(Object source, String prefix) {
		this.source = source;
		this.prefix = prefix;
	}

	public Logger(Object source) {
		this.source = source;
		prefix = "";
	}

	public Logger() {
	}

	public void log(String message) {
		System.out.println(message);
	}

	public void error(String message) {
		log("-ERROR: " + message);
	}

	public void info(String message) {
		log("-" + message);
	}

	public void warning(String message) {
		log("Warn: " + message);
	}

	public void exception(Exception e) {
		error(e.getMessage());
		if (isDebug)
			e.printStackTrace();
	}

	public void debug(String message) {
		if (!isDebug)
			return;

		log("-DEBUG: " + message);
	}
}
