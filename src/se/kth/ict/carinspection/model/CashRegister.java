package se.kth.ict.carinspection.model;

/**
 * A representation of a cash register.
 */
public class CashRegister {
    private double balance;

    /**
     * Creates a new instance of a cash register.
     */
    public CashRegister() {
        balance = 0;
    }

    /**
     * Updates the cash balance of the cash register with the specified payment.
     *
     * @param payment The payment that should be added to the register.
     */
    public void addPayment(CashPayment payment) {
        balance += payment.getTotalCost();
    }

    /**
     *
     * @return The balance of the cash register.
     */
    public double getBalance() {
        return balance;
    }
}

