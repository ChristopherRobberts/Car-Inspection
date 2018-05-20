package se.kth.ict.carinspection.model;

import se.kth.ict.carinspection.integration.*;

import java.util.ArrayList;

/**
 * Represents one particular inspection regarding one particular vehicle.
 */
public class Inspection {
    private final ArrayList<InspectionPartDTO> inspections;
    private final RegistrationNoDTO vehicleRegistrationNo;
    private int currentPartIdx;

    /**
     * Creates a new instance of an inspection as long as the vehicle to be inspected has available parts to inspect.
     *
     * @param vehicleRegistrationNo The registration number of the vehicle that should be inspected.
     * @param vehicleRegistry       The registry containing all information about available inspections.
     * @throws IllegalLicenseNumberException if the license number is illegal, this being if there is no available parts to inspect
     *                              for the given license number.
     */
    public Inspection(RegistrationNoDTO vehicleRegistrationNo, VehicleRegistry vehicleRegistry) throws IllegalLicenseNumberException {
        try {
            this.inspections = vehicleRegistry.getInspections(vehicleRegistrationNo);
        } catch (NoPartsForInspectionException e) {
            throw new IllegalLicenseNumberException(e.getRegistrationNumber());
        }
        this.vehicleRegistrationNo = vehicleRegistrationNo;
        currentPartIdx = 0;
    }

    /**
     * Calculates the total cost of the inspection.
     *
     * @return The total cost of the current inspection. If there are no current inspections, return <code>-1</code>.
     */
    public double calculateCost() {
        double totalCost = 0;
        for (InspectionPartDTO inspectionPart : inspections) {
            totalCost += inspectionPart.getCost();
        }
        return totalCost;
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
     * @return A list of all the parts included in the inspection.
     */
    public ArrayList<InspectionPartDTO> getInspections() {
        return inspections;
    }

    /**
     * @return The registration number of the vehicle belonging to the inspection.
     */
    public RegistrationNoDTO getVehicleRegistrationNoDTO() {
        return vehicleRegistrationNo;
    }
}
