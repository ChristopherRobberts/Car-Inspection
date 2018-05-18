package se.kth.ict.carinspection.integration;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import se.kth.ict.carinspection.model.InspectionResults;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by chris on 2017-05-02.
 */
class InspectionResultsDatabaseTest {
    private HashMap<RegistrationNoDTO, InspectionResults> expResult;
    private InspectionResultsDatabase inspectionResultsDatabase = new InspectionResultsDatabase();

    @BeforeEach
    void setUp() {
        expResult = new HashMap<>();
    }

    @AfterEach
    void tearDown() {
        expResult = null;
        inspectionResultsDatabase = null;
    }

    //Jtoft, check this!
    @Test
    void addInspectionResults() {
        RegistrationNoDTO registrationNoDTO = new RegistrationNoDTO("ABC123");
        InspectionResults inspectionResults = new InspectionResults(registrationNoDTO);

        expResult.put(registrationNoDTO, inspectionResults);
        inspectionResultsDatabase.addInspectionResults(inspectionResults);

        InspectionResults inspectionResultsTest = inspectionResultsDatabase.getResult(registrationNoDTO);
        HashMap <RegistrationNoDTO, InspectionResults> result = new HashMap<>();
        result.put(registrationNoDTO, inspectionResultsTest);

        assertEquals(expResult, result);
    }
}