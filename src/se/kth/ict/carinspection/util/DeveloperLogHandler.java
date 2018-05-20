package se.kth.ict.carinspection.util;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

/**
 * This class is meant to write error messages to an external file for developers.
 */
public class DeveloperLogHandler {
    private static final String DEV_ERROR_LOG = "c:/users/chris/desktop/car-inspection-log.txt";
    private PrintWriter log;

    public DeveloperLogHandler() {
        try {
            log = new PrintWriter(new FileWriter(DEV_ERROR_LOG), true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Writes to an external file describing the exception at a given time.
     *
     * @param exception The exception that has been thrown
     */
    public void writeToFile(Exception exception) {
        StringBuilder logMessageBuilder = new StringBuilder();
        logMessageBuilder.append(this.createTime());
        logMessageBuilder.append(" Exception: ");
        logMessageBuilder.append(exception.getMessage());
        log.println(logMessageBuilder);
        exception.printStackTrace(log);
    }

    public String createTime() {
        LocalDateTime current = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM);
        return current.format(formatter);
    }
}
