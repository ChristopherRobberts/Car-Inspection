package se.kth.ict.carinspection.integration;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.YearMonth;

import static org.junit.jupiter.api.Assertions.*;


class CCInformationDTOTest {
    private CCInformationDTO testCCObj;

    @BeforeEach
    void setUp() {
        String name = "Jacob Hall";
        String CCNumber = "384275";
        String CVCNumber = "829";
        YearMonth expirationDate = YearMonth.parse("2018-01");

        testCCObj = new CCInformationDTO(name, CCNumber, CVCNumber, expirationDate);

    }

    @AfterEach
    void tearDown() {
        testCCObj = null;
    }

    @Test
    void getName() {
        String result = testCCObj.getName();
        String expResult = "Jacob Hall";
        assertTrue(result.equals(expResult));
    }

    @Test
    void getCCNumber() {
        String result = testCCObj.getCCNumber();
        String expResult = "384275";
        assertTrue(result.equals(expResult));
    }

    @Test
    void getCVCNumber() {
        String result = testCCObj.getCVCNumber();
        String expResult = "829";
        assertTrue(result.equals(expResult));
    }

    @Test
    void getExpirationDate() {
        YearMonth result = testCCObj.getExpirationDate();
        YearMonth expResult = YearMonth.parse("2018-01");
        assertTrue(result.equals(expResult));
    }

}