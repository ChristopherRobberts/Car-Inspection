package se.kth.ict.carinspection.view;

import se.kth.ict.carinspection.model.VehicleInspectionResultsObserver;

/**
 * Prints to the view how many vehicle inspections have passed and how many that have failed.
 */
public class InspectionStatsView implements VehicleInspectionResultsObserver{

    private int passedInspections = 0;
    private int failedInspections = 0;
    public void passedInspection(boolean hasPassed) {
        if (hasPassed) {
            this.passedInspections++;
        } else {
            failedInspections++;
        }
        System.out.println("Amount of inspection results that have passed: " + passedInspections + "\n" +
                "Amount of inspection results that have failed: " + failedInspections);
    }
}
