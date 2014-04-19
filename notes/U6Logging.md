Unit 6x: Using Logging
===

Use logging to improve the testability

> Logging 是專業程式的表現

### Overview of Control Flow

Application make logging calls on **Logger** object.

Logger allocates LogRecord Object

Logger pass LogRecord to Handler

### LEVEL
From Level.FINEST to Level.SEVERE

* SEVERE (highest value)
* WARNING
* INFO
* CONFIG
* FINE
* FINER
* FINEST (lowest value)

### Formatters
Java SE also includes two standard Formatters:

- **SimpleFormatter**: Writes brief "human-readable" summaries of log records.
- **XMLFormatter**: Writes detailed XML-structured information.

### Handlers
Java SE provides the following Handlers:

- **StreamHandler**: A simple handler for writing formatted records to an OutputStream.
- ConsoleHandler: A simple handler for writing formatted records to System.err
- **FileHandler**: A handler that writes formatted log records either to a single file, or to a set of rotating log files.
- **SocketHandler**: A handler that writes formatted log records to remote TCP ports.
- **MemoryHandler**: A handler that buffers log records in memory.

### Example

```
public class LoggerDemo {

	// Obtain a suitable logger.
	private static Logger logger = Logger.getLogger("debug.LoggerDemo");

	private static FileHandler fh;

	public static void main(String argv[]) {

		try {
			fh = new FileHandler("mylog.txt");
		} catch (IOException e) {
			e.printStackTrace();
		}

		// Log a FINE tracing message
		logger.fine("doing stuff");

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
}
```	
	

