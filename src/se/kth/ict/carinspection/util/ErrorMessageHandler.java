package se.kth.ict.carinspection.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

/**
 * This class is for outputting error messages in the view.
 */
public class ErrorMessageHandler {

    public void showErrorMessage(String message) {
        StringBuilder errorMessageBuilder = new StringBuilder();
        errorMessageBuilder.append(createTime());
        errorMessageBuilder.append(" ERROR: ");
        errorMessageBuilder.append(message);
        System.out.println(errorMessageBuilder);
    }

    private String createTime() {
        LocalDateTime current = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM);
        return current.format(formatter);
    }
}
