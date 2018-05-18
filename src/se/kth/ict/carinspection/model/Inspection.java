package se.kth.ict.carinspection.model;

import se.kth.ict.carinspection.integration.InspectionPartDTO;
import se.kth.ict.carinspection.integration.RegistrationNoDTO;
import se.kth.ict.carinspection.integration.VehicleRegistry;

import java.util.ArrayList;

/**
 * Represents one particular inspection regarding one particular vehicle.
 */
public class Inspection {
    private final ArrayList<InspectionPartDTO> inspections;
    private final RegistrationNoDTO vehicleRegistrationNo;
    private int currentPartIdx;

    /**
     * Creates a new instance of an inspection.
     *
     * @param vehicleRegistrationNo The registration number of the vehicle that should be inspected.
     * @param vehicleRegistry The registry containing all information about available inspections.
     */
    public Inspection(RegistrationNoDTO vehicleRegistrationNo, VehicleRegistry vehicleRegistry) {
        this.inspections = vehicleRegistry.getInspections(vehicleRegistrationNo);
        this.vehicleRegistrationNo = vehicleRegistrationNo;

        currentPartIdx = 0;
    }

    /**
     * Calculates the total cost of the inspection.
     *
     * @return The total cost of the current inspection. If there are no current inspections, return <code>-1</code>.
     */
    public double calculateCost() {

        if (inspections == null) {
            return -1;
        } else {
            double totalCost = 0;
            for (InspectionPartDTO inspectionPart : inspections) {
                totalCost += inspectionPart.getCost();
            }
            return totalCost;
        }
    }

    /**
     * This function is used to get the next part that should be inspected.
     *
     * @return The next part that should be inspected. If there is no next part, return <code>null</code>.
     */
    public InspectionPartDTO getNextPart() {
        if (currentPartIdx < inspections.size()) {
            return inspections.get(currentPartIdx++);
        } else {
            return null;
        }
    }

    /**
     *
     * @return A list of all the parts included in the inspection.
     */
    public ArrayList<InspectionPartDTO> getInspections() {
        return inspections;
    }

    /**
     *
     * @return The registration number of the vehicle belonging to the inspection.
     */
    public RegistrationNoDTO getVehicleRegistrationNoDTO() {
        return vehicleRegistrationNo;
    }
}
