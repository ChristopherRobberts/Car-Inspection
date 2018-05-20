package se.kth.ict.carinspection.integration;

/**
 * An exception class for handling the error of having no available vehicle parts to be inspected.
 */
public class NoPartsForInspectionException extends Exception{

    private RegistrationNoDTO regNoWithoutInspections;

    /**
     * Creates an instance of the exception with a message notifying that there are no inspections available for given
     * registration number.
     * @param regNoWithoutInspections The given registration number which is illegal.
     */
    public NoPartsForInspectionException(RegistrationNoDTO regNoWithoutInspections) {
        super("There are currently no available inspections pending for vehicle with registration number " +
        regNoWithoutInspections.getRegistrationNo());
        this.regNoWithoutInspections = regNoWithoutInspections;
    }

    /**
     * Makes the current license number without parts to inspect accessible.
     *
     * @return The current license number without parts to inspect.
     */
    public RegistrationNoDTO getRegistrationNumber() {
        return this.regNoWithoutInspections;
    }
}
