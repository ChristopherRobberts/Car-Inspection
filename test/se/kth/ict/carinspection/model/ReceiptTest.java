package se.kth.ict.carinspection.model;

import org.junit.jupiter.api.Test;
import se.kth.ict.carinspection.integration.InspectionPartDTO;
import se.kth.ict.carinspection.integration.RegistrationNoDTO;
import se.kth.ict.carinspection.integration.VehicleRegistry;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;


class ReceiptTest {

    @Test
    void createReceiptString() {
        VehicleRegistry vehicleRegistry = new VehicleRegistry();

        RegistrationNoDTO vehicle = new RegistrationNoDTO("CAR993");
        ArrayList<InspectionPartDTO> inspectionList = new ArrayList<>();

        InspectionPartDTO engine = new InspectionPartDTO("engine", 50);
        InspectionPartDTO wheels = new InspectionPartDTO("wheels", 35);

        inspectionList.add(engine);
        inspectionList.add(wheels);

        vehicleRegistry.addVehicle(vehicle, inspectionList);

        Inspection inspection = new Inspection(vehicle, vehicleRegistry);

        Receipt receipt = new Receipt(inspection);

        ArrayList<String> expReceiptContains = new ArrayList<>();
        expReceiptContains.add("Vehicle registration number: CAR993");
        expReceiptContains.add("engine            50,0");
        expReceiptContains.add("wheels            35,0");
        expReceiptContains.add("Total amount      85,0");

        String result = receipt.createReceiptString();

        for (String expContains : expReceiptContains) {
            assertTrue(result.contains(expContains));
        }
    }

}