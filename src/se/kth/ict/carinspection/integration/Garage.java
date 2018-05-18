package se.kth.ict.carinspection.integration;

import se.kth.ict.carinspection.util.ExternalSystemLogger;

/**
 * This represents the interface for the garage. This dummy implementation has no real effects.
 */
public class Garage {

    /**
     * This is a dummy method that should display a customer number and open the garage door.
     */
    public void nextCustomer() {
        ExternalSystemLogger.logMessage("Garage", "displaying next customer number and opening door");
    }

    /**
     * This is a dummy method that should close the garage door.
     */
    public void closeDoor() {
        ExternalSystemLogger.logMessage("Garage", "closing door");
    }
}
