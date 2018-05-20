package se.kth.ict.carinspection.integration;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * The registry that contains all inspections that should be made by registration number.
 */
public class VehicleRegistry {
    private final HashMap<RegistrationNoDTO, ArrayList<InspectionPartDTO>> vehicleList;
    private boolean hasParts;

    /**
     * Creates a new instance of a vehicle registry.
     *
     * @param hasParts a way to check if the exception handling is implemented correctly by only having available parts
     *                 for the inspection is if this <code>boolean</code> parameter is <code>true</code>.
     */
    public VehicleRegistry(boolean hasParts) {
        this.hasParts = hasParts;
        vehicleList = new HashMap<>();
        ArrayList<InspectionPartDTO> partList = new ArrayList<>();
        if (hasParts){
            partList.add(new InspectionPartDTO("motor", 150));
            partList.add(new InspectionPartDTO("bakruta", 150));
            partList.add(new InspectionPartDTO("handfack", 150));
            partList.add(new InspectionPartDTO("framruta", 150));
            partList.add(new InspectionPartDTO("bagagelucka", 150));
        }
        addVehicle(new RegistrationNoDTO("KOS839"), partList);
    }

    /**
     * Adds a vehicle and the inspections that should be made for that vehicle to the database.
     *
     * @param registrationNo     The registration number of the specific vehicle.
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
