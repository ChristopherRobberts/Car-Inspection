package se.kth.ict.carinspection.integration;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class RegistrationNoDTOTest {
    private RegistrationNoDTO firstReg;
    private RegistrationNoDTO equalToFirstReg;
    private RegistrationNoDTO otherReg;

    @BeforeEach
    void setUp() {
        firstReg = new RegistrationNoDTO("KOS883");
        equalToFirstReg = new RegistrationNoDTO("KOS883");
        otherReg = new RegistrationNoDTO("CHR883");
    }

    @AfterEach
    void tearDown() {
        firstReg = null;
        equalToFirstReg = null;
        otherReg = null;
    }

    @Test
    void equals() {
        assertEquals(firstReg, equalToFirstReg);
    }

    @Test
    void notEquals() {
        assertNotEquals(firstReg, otherReg);
    }

}