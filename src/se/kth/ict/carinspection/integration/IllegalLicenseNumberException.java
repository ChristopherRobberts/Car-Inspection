package se.kth.ict.carinspection.integration;

/**
 * An exception class that is thrown when trying to start an inspection with an illegal registration number.
 */

public class IllegalLicenseNumberException extends Exception {
    private RegistrationNoDTO illegalRegistrationNumber;

    /**
     * Creates a new instance of the class sending a message notifying information about the illegal registration number
     * in question.
     *
     * @param illegalRegistrationNumber The given registration number which is illegal.
     */
    public IllegalLicenseNumberException(RegistrationNoDTO illegalRegistrationNumber) {
        super("the registration number is illegal. License number in question: " + illegalRegistrationNumber.getRegistrationNo());
        this.illegalRegistrationNumber = illegalRegistrationNumber;
    }

    /**
     * Makes the current illegal license number accessible.
     *
     * @return The illegal license number
     */
    public RegistrationNoDTO getIllegalRegistrationNumber() {
        return this.illegalRegistrationNumber;
    }
}
