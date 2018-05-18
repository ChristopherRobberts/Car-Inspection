package se.kth.ict.carinspection.integration;

public class NoInspectionException extends Exception{

    private RegistrationNoDTO regNoWithoutInspections;

    public NoInspectionException(RegistrationNoDTO regNoWithoutInspections) {
        super("There are currently no available inspections pending for vehichle with registration number " +
        regNoWithoutInspections.getRegistrationNo());
        this.regNoWithoutInspections = regNoWithoutInspections;
    }
}
