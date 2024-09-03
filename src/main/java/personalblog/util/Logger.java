package personalblog.util;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Logger {

    private static Logger instance = new Logger();
    private static File logsFolder = new File(System.getProperty("user.dir") + '/' + "logs");
    private static File logFile;

    public static Logger getInstance() {
        try {
            instance.createLogFile();
        } catch (IOException e) {
            System.err.println("Error occurred during log file creation: " + e.getMessage());
        }
        return instance;
    }
	public void createLogFile() throws IOException {
		if(!logsFolder.exists()){
			logsFolder.mkdir();
		}

		//Get the current date and time
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	   	Calendar cal = Calendar.getInstance();

	   	//Create the name of the file from the current time
		String logName = dateFormat.format(cal.getTime()) + ".log";
		Logger.logFile = new File(logsFolder.getName(), logName);
        logFile.createNewFile();
	}

    public void log(String message) {
        try{
			FileWriter out = new FileWriter(Logger.logFile, true);
			out.write(message.toCharArray());
			out.close();
		} catch (IOException e){
			System.err.println("Error occurred during write to log file: " + e.getMessage());
		}
    }
}
