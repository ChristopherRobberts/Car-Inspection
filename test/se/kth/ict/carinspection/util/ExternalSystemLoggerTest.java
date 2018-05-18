package se.kth.ict.carinspection.util;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;


class ExternalSystemLoggerTest {
    private ByteArrayOutputStream outContent;

    @BeforeEach
    void setUp() {
        outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    void tearDown() {
        outContent = null;
        System.setOut(null);
    }

    @Test
    void logMessage() {
        ExternalSystemLogger.logMessage("Door", "opening door");

        String expResult = "---------------\nDoor: opening door...\n---------------\n\n";
        String result = outContent.toString();

        assertEquals(expResult, result);
    }

}