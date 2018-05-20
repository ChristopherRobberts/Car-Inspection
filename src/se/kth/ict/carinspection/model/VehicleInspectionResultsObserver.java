package se.kth.ict.carinspection.model;

/**
 * A listener interface for receiving notifications about inspection results for parts of a vehicle.
 */
public interface VehicleInspectionResultsObserver {

    /**
     *Invoked when an inspection result has been reported.
     *
     * @param passed The value of the inspected parts result, either pass <code>true</code> or fail <code>false</code>.
     */

    void passedInspection(boolean passed);
}
