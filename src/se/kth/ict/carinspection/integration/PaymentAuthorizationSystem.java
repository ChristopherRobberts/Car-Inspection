package se.kth.ict.carinspection.integration;


/**
 * An interface for a payment authorization system.
 */
public class PaymentAuthorizationSystem {

    /**
     * A dummy method that should authorize a payment.
     *
     * @param CCInformation The credit card information of the paying customer.
     * @param amount The total amount of the payment to be made with the card.
     * @return A boolean indicating whether the payment was successful or not.
     */
    public boolean authorizePayment(CCInformationDTO CCInformation, double amount) {
        return true;
    }
}
