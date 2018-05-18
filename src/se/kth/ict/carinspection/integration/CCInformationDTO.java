package se.kth.ict.carinspection.integration;

import java.time.YearMonth;

/**
 * Contains information about one particular credit card.
 */
public class CCInformationDTO {
    private final String name;
    private final String CCNumber;
    private final String CVCNumber;
    private final YearMonth expirationDate;

    /**
     * Creates a new instance representing the information of a credit card.
     *
     * @param name The name of the credit card holder.
     * @param CCNumber The credit card number.
     * @param CVCNumber The CVC number of the card.
     * @param expirationDate The expiration date of the card (year and month).
     */
    public CCInformationDTO(String name, String CCNumber, String CVCNumber, YearMonth expirationDate) {
        this.name = name;
        this.CCNumber = CCNumber;
        this.CVCNumber = CVCNumber;
        this.expirationDate = expirationDate;
    }

    /**
     *
     * @return The name of the credit card holder.
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @return The credit card number.
     */
    public String getCCNumber() {
        return CCNumber;
    }

    /**
     *
     * @return The CVC number of the card.
     */
    public String getCVCNumber() {
        return CVCNumber;
    }

    /**
     *
     * @return The expiration date of the card (year and month).
     */
    public YearMonth getExpirationDate() {
        return expirationDate;
    }
}
