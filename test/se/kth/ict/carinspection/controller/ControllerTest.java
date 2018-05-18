package se.kth.ict.carinspection.controller;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import se.kth.ict.carinspection.integration.*;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by Chris on 2017-05-01.
 */
class ControllerTest {
    private Controller contr;

    @BeforeEach
    void setUp() {
        Printer printer = new Printer();
        Garage garage = new Garage();
        PaymentAuthorizationSystem paymentAuthorizationSystem = new PaymentAuthorizationSystem();
        InspectionResultsDatabase inspectionResultsDatabase = new InspectionResultsDatabase();
        VehicleRegistry vehicleRegistry = new VehicleRegistry();

        RegistrationNoDTO vehicle = new RegistrationNoDTO("CAR993");
        ArrayList<InspectionPartDTO> inspectionList = new ArrayList<>();

        InspectionPartDTO part1 = new InspectionPartDTO("engine", 50);
        InspectionPartDTO part2 = new InspectionPartDTO("wheels", 35);

        inspectionList.add(part1);
        inspectionList.add(part2);

        vehicleRegistry.addVehicle(vehicle, inspectionList);
        contr = new Controller(garage, vehicleRegistry, paymentAuthorizationSystem, inspectionResultsDatabase, printer);
    }

    @AfterEach
    void tearDown() {
        contr = null;
    }

    @Test
    void calculateCost() {
        RegistrationNoDTO registrationNoDTO = new RegistrationNoDTO("CAR993");
        double expResult = 85;
        double result = contr.calculateCost(registrationNoDTO);
        assertEquals(expResult, result);
    }

    @Test
    void payByCash() {
        RegistrationNoDTO registrationNoDTO = new RegistrationNoDTO("CAR993");
        contr.calculateCost(registrationNoDTO);
        double paidAmount = 90;
        double expResult = 5;
        double result = contr.payByCash(paidAmount);
        assertEquals(expResult, result);
    }

    @Test
    void getPartToInspect() {
        RegistrationNoDTO registrationNoDTO = new RegistrationNoDTO("CAR993");
        contr.calculateCost(registrationNoDTO);
        InspectionPartDTO expResult = new InspectionPartDTO("engine", 50);
        InspectionPartDTO result = contr.getPartToInspect();
        assertEquals(expResult, result);

        expResult = new InspectionPartDTO("wheels", 35);
        result = contr.getPartToInspect();
        assertEquals(expResult, result);

        result = contr.getPartToInspect();
        assertNull(result);
    }
}