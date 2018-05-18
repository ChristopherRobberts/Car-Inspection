package se.kth.ict.carinspection.integration;

import se.kth.ict.carinspection.model.InspectionResults;
import se.kth.ict.carinspection.util.ExternalSystemLogger;

import java.util.HashMap;

// The design of this class only permits one result per registration number -- this should maybe be changed later.

/**
 * This is a representation of a database where inspection results are stored.
 */
public class InspectionResultsDatabase {
    private HashMap<RegistrationNoDTO, InspectionResults> allResults;

    /**
     * Creates a new instance representing the database.
     */
    public InspectionResultsDatabase() {
        allResults = new HashMap<>();
    }

    /**
     * Adds the results from a inspection to this instance.
     *
     * @param inspectionResults The results for a specific inspection.
     */
    public void addInspectionResults(InspectionResults inspectionResults) {
        RegistrationNoDTO registrationNo = inspectionResults.getRegistrationNoDTO();
        allResults.put(registrationNo, inspectionResults);
    }

    /**
     *
     * @param registrationNo The registration number for the inspected vehicle.
     * @return The results for a specific inspection.
     */
    public InspectionResults getResult(RegistrationNoDTO registrationNo) {
        return allResults.get(registrationNo);
    }
}
