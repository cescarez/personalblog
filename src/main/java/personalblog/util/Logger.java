package personalblog.util;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Logger {

    private static Logger instance = new Logger();
    private static File logFile;

    public static Logger getInstance() {
        return instance;
    }

    // Method to log a message
    public void log(String message) {
        // Logging logic, e.g., writing to a file or console
        try{
			FileWriter out = new FileWriter(Logger.logFile, true);
			out.write(message.toCharArray());
			out.close();
		} catch (IOException e){
			System.err.println("Error occurred during write to log file: " + e.getMessage());
		}
    }
}
