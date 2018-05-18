package se.kth.ict.carinspection.util;


/**
 * Utility class which contains methods that make string building easier.
 */
public class StringBuilderHelper {

    /**
     * Appends a newline.
     *
     * @param builder The <code>StringBuilder</code> that the newline should be appended to.
     */
    public static void endSection(StringBuilder builder) {
        builder.append("\n");
    }

    /**
     * Appends the specified line and a newline.
     *
     * @param builder The <code>StringBuilder</code> that should be appended to.
     * @param line The line that should be appended.
     */
    public static void appendLine(StringBuilder builder, String line) {
        builder.append(line);
        builder.append("\n");
    }

    /**
     *
     * @param builder The <code>StringBuilder</code> that should be appended to.
     * @param line The line that should be stylized and appended.
     */
    public static void stylizeLine(StringBuilder builder, String line, String separator) {
        final StringBuilder stylizedLineBuilder = new StringBuilder();

        appendLine(stylizedLineBuilder, separator);
        appendLine(stylizedLineBuilder, line);
        appendLine(stylizedLineBuilder, separator);

        builder.append(stylizedLineBuilder);
    }
}
