package se.kth.ict.carinspection.integration;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import se.kth.ict.carinspection.model.Inspection;
import se.kth.ict.carinspection.model.InspectionResults;
import se.kth.ict.carinspection.model.Receipt;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;


class PrinterTest {
    private ByteArrayOutputStream outContent;
    private Printer printer;

    @BeforeEach
    void setUp() {
        printer = new Printer();
        outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    void tearDown() {
        printer = null;
        outContent = null;
        System.setOut(null);
    }

    @Test
    void printReceipt() {
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

        printer.printReceipt(receipt);

        String expResult = receipt.createReceiptString();
        String result = outContent.toString();

        assertEquals(expResult, result);
    }

    @Test
    void printInspectionResults() {
        RegistrationNoDTO registrationNo = new RegistrationNoDTO("KOJ395");
        InspectionResults inspectionResults = new InspectionResults(registrationNo);

        inspectionResults.addPartResult(new InspectionPartDTO("engine", 52), true);
        inspectionResults.addPartResult(new InspectionPartDTO("roof", 25), false);

        printer.printInspectionResults(inspectionResults);

        String expResult = inspectionResults.createResultsString();
        String result = outContent.toString();

        assertEquals(expResult, result);
    }
}