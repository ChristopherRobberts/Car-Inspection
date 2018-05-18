package se.kth.ict.carinspection.model;

import se.kth.ict.carinspection.integration.InspectionPartDTO;
import se.kth.ict.carinspection.integration.Printer;

import java.util.Collections;

import static se.kth.ict.carinspection.util.StringBuilderHelper.appendLine;
import static se.kth.ict.carinspection.util.StringBuilderHelper.endSection;

/**
 * A representation of a receipt for a payment.
 */
public class Receipt {
    private static final int WIDTH_OF_RECEIPT = 40;
    private final Inspection inspection;
    private final boolean paymentSuccessful;

    /**
     * Creates a receipt instance for a cash payment.
     *
     * @param inspection The inspection that the receipt should specify.
     */
    public Receipt(Inspection inspection) {
        this.inspection = inspection;
        this.paymentSuccessful = true;
    }

    /**
     * Creates a receipt instance for a card payment.
     *
     * @param inspection The inspection that the receipt should specify.
     * @param paymentSuccessful An indication whether the payment was successful or not.
     */
    public Receipt(Inspection inspection, boolean paymentSuccessful) {
        this.inspection = inspection;
        this.paymentSuccessful = paymentSuccessful;
    }

    /**
     * Prints this receipt instance.
     *
     * @param printer The printer that should be used for the printing.
     */
    public void print(Printer printer) {
        printer.printReceipt(this);
    }

    /**
     * Creates a text representation of this receipt.
     *
     * @return A text representation of this receipt with relevant information.
     */
    public String createReceiptString() {
        final String separator = String.join("", Collections.nCopies(WIDTH_OF_RECEIPT, "#"));
        final StringBuilder builder = new StringBuilder();
        String registrationNo = inspection.getVehicleRegistrationNoDTO().getRegistrationNo();

        appendLine(builder, separator);
        appendLine(builder, "Car Inspection");
        endSection(builder);

        appendLine(builder, "Vehicle registration number: " + registrationNo);
        endSection(builder);

        String headers = String.format("%-15s   %-6s", "Inspected part", "Cost");
        appendLine(builder, headers);
        for (InspectionPartDTO inspectionPart : inspection.getInspections()) {
            String newLine = String.format("%-15s   %-6.1f", inspectionPart.getName(), inspectionPart.getCost());
            appendLine(builder, newLine);
        }
        endSection(builder);

        String totalCost = String.format("%-15s   %-6.1f", "Total amount", inspection.calculateCost());
        appendLine(builder, totalCost);

        appendLine(builder, separator);

        return builder.toString();
    }

}
