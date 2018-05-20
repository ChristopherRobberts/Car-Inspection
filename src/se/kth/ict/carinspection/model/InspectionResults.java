package se.kth.ict.carinspection.model;

import se.kth.ict.carinspection.integration.InspectionPartDTO;
import se.kth.ict.carinspection.integration.RegistrationNoDTO;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import static se.kth.ict.carinspection.util.StringBuilderHelper.appendLine;
import static se.kth.ict.carinspection.util.StringBuilderHelper.endSection;

/**
 * Contains information about the results produced by an inspection.
 */
public class InspectionResults {
    private static final int WIDTH_OF_RESULTS_PRINTOUT = 40;
    private final HashMap<InspectionPartDTO, Boolean> partResults;
    private final RegistrationNoDTO registrationNo;
    private ArrayList<VehicleInspectionResultsObserver> inspectionResultsObservers = new ArrayList<>();

    /**
     * Creates an instance of the results of an inspection.
     *
     * @param registrationNo The inspected vehicles registration number.
     */
    public InspectionResults(RegistrationNoDTO registrationNo) {
        this.registrationNo = registrationNo;
        this.partResults = new HashMap<>();
    }

    /**
     * Adds the result of one inspected part to this instance.
     *
     * @param partInspected The part that was inspected.
     * @param result The result of the inspected part. <code>true</code> if it was a pass, <code>false</code> if it
     * was a fail.
     */
    public void addPartResult(InspectionPartDTO partInspected, boolean result) {
        partResults.put(partInspected, result);
        notifyObservers(result);
    }

    /**
     * Creates a text representation of the complete result of all the inspected parts.
     *
     * @return A text representation of the result.
     */
    public String createResultsString() {
        final String separator = String.join("", Collections.nCopies(WIDTH_OF_RESULTS_PRINTOUT, "#"));
        final StringBuilder builder = new StringBuilder();

        appendLine(builder, separator);
        appendLine(builder, "Car Inspection Results");
        endSection(builder);

        for (Map.Entry<InspectionPartDTO, Boolean> entry : partResults.entrySet()) {
            String partName = entry.getKey().getName();
            boolean result = entry.getValue();

            appendLine(builder, partName + ": " + (result ? "Pass" : "Fail"));
            endSection(builder);
        }

        appendLine(builder, separator);

        return builder.toString();
    }

    /**
     *
     * @return The result of the inspected parts.
     */
    public HashMap<InspectionPartDTO, Boolean> getPartResults() {
        return partResults;
    }

    /**
     *
     * @return The registration number of the inspected vehicle.
     */
    public RegistrationNoDTO getRegistrationNoDTO() {
        return registrationNo;
    }

    public void addInspectionResultsObserver(VehicleInspectionResultsObserver obs) {
        this.inspectionResultsObservers.add(obs);
    }

    private void notifyObservers(boolean result) {
        for (VehicleInspectionResultsObserver obs : inspectionResultsObservers) {
            obs.passedInspection(result);
        }
    }
}
