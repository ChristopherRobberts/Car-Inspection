package se.kth.ict.carinspection.view;

import se.kth.ict.carinspection.model.VehicleInspectionResultsObserver;

/**
 * Prints to the view how many vehicle inspections have passed.
 */
public class VehiclePartResultsDisplay implements VehicleInspectionResultsObserver{

    private int passedInspections = 0;

    public void passedInspection(boolean hasPassed) {
        if (hasPassed) {
            this.passedInspections++;
        }
        System.out.println("Amount of inspection results that have passed: " + passedInspections);
    }
}
