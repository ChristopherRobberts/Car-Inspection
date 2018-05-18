package se.kth.ict.carinspection.integration;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;


class VehicleRegistryTest {
    private VehicleRegistry vehicleRegistry;

    @BeforeEach
    void setUp() {
        vehicleRegistry = new VehicleRegistry();

        RegistrationNoDTO vehicle = new RegistrationNoDTO("CAR993");
        ArrayList<InspectionPartDTO> inspectionList = new ArrayList<>();

        InspectionPartDTO part1 = new InspectionPartDTO("engine", 50);
        InspectionPartDTO part2 = new InspectionPartDTO("wheels", 35);

        inspectionList.add(part1);
        inspectionList.add(part2);

        vehicleRegistry.addVehicle(vehicle, inspectionList);
    }

    @AfterEach
    void tearDown() {
        vehicleRegistry = null;
    }

    @Test
    void getAvailableVehicle() {
        RegistrationNoDTO vehicle = new RegistrationNoDTO("CAR993");
        ArrayList<InspectionPartDTO> inspectionList = new ArrayList<>();

        InspectionPartDTO part1 = new InspectionPartDTO("engine", 50);
        InspectionPartDTO part2 = new InspectionPartDTO("wheels", 35);

        inspectionList.add(part1);
        inspectionList.add(part2);

        assertEquals(vehicleRegistry.getInspections(vehicle), inspectionList);
    }

    @Test
    void getUnavailableVehicle() {
        RegistrationNoDTO vehicle = new RegistrationNoDTO("CRE535");
        assertNull(vehicleRegistry.getInspections(vehicle));
    }
}