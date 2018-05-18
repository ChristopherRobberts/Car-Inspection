package se.kth.ict.carinspection.util;


import static se.kth.ict.carinspection.util.StringBuilderHelper.*;

/**
 * Class that helps logging to <code>System.out</code>, to better follow the program flow.
 */
public class ExternalSystemLogger {

    /**
     * Logs a message to <code>System.out</code>.
     *
     * @param sender The sender of the message that should be logged.
     * @param message The message itself.
     */
    public static void logMessage(String sender, String message) {
        final StringBuilder builder = new StringBuilder();
        String separator = "---------------";

        stylizeLine(builder, sender + ": " + message + "...", separator);
        endSection(builder);

        System.out.print(builder.toString());
    }
}
