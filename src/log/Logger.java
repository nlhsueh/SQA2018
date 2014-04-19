package log;

import java.io.IOException;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Logger {

	// Obtain a suitable logger.
	private static Logger logger = Logger.getLogger("log.logger");

	private static FileHandler fh;

	public Logger() {

		try {
			fh = new FileHandler("mylog.txt");
		} catch (IOException e) {
			e.printStackTrace();
		}

		// Log a FINE tracing message
		logger.info("doing stuff");

		// Add two handler
		logger.addHandler(new ConsoleHandler());
		logger.addHandler(fh);
		try {
			div(100, 0);
		} catch (Exception ex) {
			// Log the exception
			logger.log(Level.WARNING, "", ex);
		}
		logger.fine("done");
	}

	public static double div(int x, int y) throws Exception {
		if (y == 0)
			throw new Exception("divid by zero");
		return x / y;
	}

}
