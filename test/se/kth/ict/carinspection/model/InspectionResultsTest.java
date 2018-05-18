package se.kth.ict.carinspection.model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import se.kth.ict.carinspection.integration.InspectionPartDTO;
import se.kth.ict.carinspection.integration.RegistrationNoDTO;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by Chris on 2017-05-01.
 */
class InspectionResultsTest {
    private InspectionResults inspectionResults;

    @BeforeEach
    void setUp() {
        inspectionResults = new InspectionResults(new RegistrationNoDTO("ABC123"));
    }

    @AfterEach
    void tearDown() {
        inspectionResults = null;
    }

    @Test
    void addPartResult() {
        InspectionPartDTO engine = new InspectionPartDTO("engine", 20);
        InspectionPartDTO wheels = new InspectionPartDTO("wheels", 25);

        inspectionResults.addPartResult(engine, true);
        inspectionResults.addPartResult(wheels, false);

        HashMap<InspectionPartDTO, Boolean> expResult = new HashMap<>();
        expResult.put(engine, true);
        expResult.put(wheels, false);
        HashMap<InspectionPartDTO, Boolean> result = inspectionResults.getPartResults();

        assertEquals(expResult, result);
    }

    @Test
    void createResultsString() {
        InspectionPartDTO engine = new InspectionPartDTO("engine", 20);
        InspectionPartDTO wheels = new InspectionPartDTO("wheels", 25);

        inspectionResults.addPartResult(engine, true);
        inspectionResults.addPartResult(wheels, false);

        ArrayList<String> expResultsContains = new ArrayList<>();
        expResultsContains.add("Car Inspection Results");
        expResultsContains.add("wheels: Fail");
        expResultsContains.add("engine: Pass");

        String result = inspectionResults.createResultsString();

        for (String expPartContains : expResultsContains) {
            assertTrue(result.contains(expPartContains));
        }

        }
}