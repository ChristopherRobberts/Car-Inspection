package se.kth.ict.carinspection.model;


/**
 * Contains information about one specific payment by cash.
 */
public class CashPayment {
    private final double paidAmount;
    private final double totalCost;

    /**
     * Creates a new instance representing a payment made by cash.
     *
     * @param paidAmount How much cash that was paid by the customer.
     * @param totalCost The total cost that should be paid.
     */
    public CashPayment(double paidAmount, double totalCost) {
        this.paidAmount = paidAmount;
        this.totalCost = totalCost;
    }

    /**
     *
     * @return How much cash that was paid by the customer.
     */
    public double getPaidAmount() {
        return paidAmount;
    }

    /**
     *
     * @return The total cost that should be paid.
     */
    public double getTotalCost() {
        return totalCost;
    }
}
