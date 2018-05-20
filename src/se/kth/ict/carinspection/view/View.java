package se.kth.ict.carinspection.view;

import se.kth.ict.carinspection.controller.Controller;
import se.kth.ict.carinspection.integration.CCInformationDTO;
import se.kth.ict.carinspection.integration.IllegalLicenseNumberException;
import se.kth.ict.carinspection.integration.InspectionPartDTO;
import se.kth.ict.carinspection.integration.RegistrationNoDTO;
import se.kth.ict.carinspection.util.DeveloperLogHandler;
import se.kth.ict.carinspection.util.ErrorMessageHandler;

import java.time.YearMonth;

/**
 * A placeholder for the entire view of the application.
 */
public class View {
    private Controller contr;
    private ErrorMessageHandler errorMessageHandler;
    private DeveloperLogHandler developerLogHandler;

    /**
     * Creates a new instance
     *
     * @param contr The controller that should be used.
     */
    public View(Controller contr) {
        this.contr = contr;
        errorMessageHandler = new ErrorMessageHandler();
        developerLogHandler = new DeveloperLogHandler();
        this.contr.addVehicleInspectionResultsObserver(new InspectionStatsView());
        this.sampleExecution();
    }

    /**
     * Simulates user input.
     */
    private void sampleExecution() {
        System.out.println("Showing next customer number and opening door...\n");
        contr.initializeInspection();
        System.out.println("Closing door...\n");
        contr.closeGarageDoor();

        RegistrationNoDTO registrationNo = new RegistrationNoDTO("KOS839");
        System.out.println("Looking up inspections for registration number KOS839 and calculating cost...");
        try {
            double totalCost = contr.calculateCost(registrationNo);
            System.out.println("Cost: " + totalCost + "\n");

            System.out.println("Entering customer credit card information...\n");
            String name = "Jens";
            String CCNumber = "3195-2364-9495-1362";
            String CVCNumber = "536";
            YearMonth expirationDate = YearMonth.parse("2018-05");

            CCInformationDTO CCInformation = new CCInformationDTO(name, CCNumber, CVCNumber, expirationDate);

            System.out.println("Authorizing payment and printing receipt...\n\n");
            String paymentResult = contr.authorizePayment(CCInformation, totalCost) ? "Successful" : "Failed";
            System.out.println("\n");
            System.out.println("Payment status: " + paymentResult + "\n");


            System.out.println("Getting parts to inspect...\n");
            InspectionPartDTO nextPart = contr.getPartToInspect();

            while (nextPart != null) {
                System.out.println("Part to inspect next: " + nextPart.getName());
                System.out.println("Entering part result: Pass...\n");
                contr.enterPartResult(true);
                nextPart = contr.getPartToInspect();
            }

            System.out.println("Finishing inspection -- storing results in database and printing results...\n\n");
            contr.finishInspection();
        } catch (IllegalLicenseNumberException e) {
            errorMessageHandler.showErrorMessage("The given license number \'" + e.getIllegalRegistrationNumber() + "\' is illegal.");
            developerLogHandler.writeToFile(e);
        }
    }
}
