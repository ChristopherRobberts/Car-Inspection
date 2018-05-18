package se.kth.ict.carinspection.integration;

import se.kth.ict.carinspection.model.InspectionResults;
import se.kth.ict.carinspection.model.Receipt;
import se.kth.ict.carinspection.util.ExternalSystemLogger;

/**
 * An interface for a printer. This dummy implementation writes to System.out.
 */
public class Printer {

    /**
     * Prints the specified receipt.
     *
     * @param receipt The receipt that should be printed.
     */
    public void printReceipt(Receipt receipt) {
        System.out.print(receipt.createReceiptString());
    }

    /**
     * Prints the specified inspection results.
     *
     * @param inspectionResults The inspection results that should be printed.
     */
    public void printInspectionResults(InspectionResults inspectionResults) {
        System.out.print(inspectionResults.createResultsString());
    }
}
