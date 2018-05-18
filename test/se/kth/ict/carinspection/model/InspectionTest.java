package se.kth.ict.carinspection.model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import se.kth.ict.carinspection.integration.InspectionPartDTO;
import se.kth.ict.carinspection.integration.RegistrationNoDTO;
import se.kth.ict.carinspection.integration.VehicleRegistry;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;


class InspectionTest {
    private Inspection inspection;

    @BeforeEach
    void setUp() {
        VehicleRegistry vehicleRegistry = new VehicleRegistry();

        RegistrationNoDTO vehicle = new RegistrationNoDTO("CAR993");
        ArrayList<InspectionPartDTO> inspectionList = new ArrayList<>();

        InspectionPartDTO part1 = new InspectionPartDTO("engine", 50);
        InspectionPartDTO part2 = new InspectionPartDTO("wheels", 35);

        inspectionList.add(part1);
        inspectionList.add(part2);

        vehicleRegistry.addVehicle(vehicle, inspectionList);

        inspection = new Inspection(vehicle, vehicleRegistry);
    }

    @AfterEach
    void tearDown() {
        inspection = null;
    }

    @Test
    void calculateCost() {
        double result = inspection.calculateCost();
        double expResult = 85;
        assertEquals(result, expResult);
    }

    @Test
    void calculateCostEmptyInspection() {
        VehicleRegistry vehicleRegistry = new VehicleRegistry();
        Inspection emptyInspection = new Inspection(new RegistrationNoDTO("CAR993"), vehicleRegistry);

        double expResult = -1;
        double result = emptyInspection.calculateCost();

        assertEquals(expResult, result);
    }

    @Test
    void getNextPart() {
        InspectionPartDTO expResult = new InspectionPartDTO("engine", 50);
        InspectionPartDTO result = inspection.getNextPart();

        assertEquals(expResult, result);

        expResult = new InspectionPartDTO("wheels", 35);
        result = inspection.getNextPart();

        assertEquals(expResult, result);

        result = inspection.getNextPart();
        assertNull(result);
    }
}