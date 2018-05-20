package se.kth.ict.carinspection.integration;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * The registry that contains all inspections that should be made by registration number.
 */
public class VehicleRegistry {
    private final HashMap<RegistrationNoDTO, ArrayList<InspectionPartDTO>> vehicleList;

    /**
     * Creates a new instance of a vehicle registry.
     */
    public VehicleRegistry() {
        vehicleList = new HashMap<>();
        ArrayList<InspectionPartDTO> partList = new ArrayList<>();
        addVehicle(new RegistrationNoDTO("KOS839"), partList);
    }

    /**
     * Adds a vehicle and the inspections that should be made for that vehicle to the database.
     *
     * @param registrationNo The registration number of the specific vehicle.
     * @param inspectionPartList A list of the parts that should be inspected.
     */
    public void addVehicle(RegistrationNoDTO registrationNo, ArrayList<InspectionPartDTO> inspectionPartList) {
        vehicleList.put(registrationNo, inspectionPartList);
    }

    /**
     * Checks the database if the specified registration number is present, and if it is, returns a list of all
     * the inspections that should be made for that vehicle. If there is no match, return <code>null</code>.
     *
     * @param registrationNo The registration number of the vehicle.
     * @return A list of the inspections that should be made for the vehicle.
     */
    public ArrayList<InspectionPartDTO> getInspections(RegistrationNoDTO registrationNo) throws NoPartsForInspectionException {
        ArrayList<InspectionPartDTO> partsToInspect = this.vehicleList.get(registrationNo);
        if (partsToInspect.isEmpty()) {
            throw new NoPartsForInspectionException(registrationNo);
        } else {
            return vehicleList.get(registrationNo);
        }
    }
}
