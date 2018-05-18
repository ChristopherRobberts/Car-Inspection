package se.kth.ict.carinspection.model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by Chris on 2017-05-01.
 */
class CashRegisterTest {

    @Test
    void addPayment() {
        CashRegister cashRegister = new CashRegister();
        CashPayment cashPayment = new CashPayment(50, 45);

        cashRegister.addPayment(cashPayment);
        double expResult = 45;
        double result = cashRegister.getBalance();

        assertEquals(expResult, result);
    }
}