package se.kth.ict.carinspection.controller;

import se.kth.ict.carinspection.integration.*;
import se.kth.ict.carinspection.model.*;

/**
 * The controller class of the application. Handles all calls from the view.
 */
public class Controller {
    private final Garage garage;
    private final VehicleRegistry vehicleRegistry;
    private final PaymentAuthorizationSystem paymentAuthorizationSystem;
    private final InspectionResultsDatabase inspectionResultsDatabase;
    private final Printer printer;
    private final CashRegister cashRegister;

    private InspectionResults inspectionResults;
    private Inspection currentInspection;
    private InspectionPartDTO currentInspectionPart;

    /**
     * Creates a new instance.
     *
     * @param garage The garage that should be used.
     * @param vehicleRegistry The vehicle registry that should be used.
     * @param paymentAuthorizationSystem The payment authorization system that should be used.
     * @param inspectionResultsDatabase The database that results should be stored in.
     * @param printer The printer that the program should send printouts to.
     */
    public Controller(Garage garage, VehicleRegistry vehicleRegistry,
                      PaymentAuthorizationSystem paymentAuthorizationSystem,
                      InspectionResultsDatabase inspectionResultsDatabase, Printer printer) {

        this.garage = garage;
        this.vehicleRegistry = vehicleRegistry;
        this.paymentAuthorizationSystem = paymentAuthorizationSystem;
        this.inspectionResultsDatabase = inspectionResultsDatabase;
        this.printer = printer;
        this.cashRegister = new CashRegister();
    }

    /**
     * Displays the next customer number on the garage display, and opens the garage door.
     */
    public void initializeInspection() {
        garage.nextCustomer();
    }

    /**
     * Closes the garage door.
     */
    public void closeGarageDoor() {
        garage.closeDoor();
    }

    /**
     * Calculates the total cost of the inspection for a particular vehicle.
     *
     * @param registrationNo The registration number of the vehicle.
     * @return The cost of the inspection. Returns <code>-1</code> if there are no valid inspections for the specified
     * registration number.
     */
    public double calculateCost(RegistrationNoDTO registrationNo) {
        currentInspection = new Inspection(registrationNo, vehicleRegistry);
        inspectionResults = new InspectionResults(registrationNo);
        return currentInspection.calculateCost();
    }

    /**
     * Authorizes a payment by card.
     *
     * @param CCInformation The full credit card information of the card that should be used for the payment.
     * @param amount The total amount of the payment.
     * @return An indicator whether the payment was successful.
     */
    public boolean authorizePayment(CCInformationDTO CCInformation, double amount) {
        boolean paymentSuccessful = paymentAuthorizationSystem.authorizePayment(CCInformation, amount);

        Receipt receipt = new Receipt(currentInspection, paymentSuccessful);
        receipt.print(printer);
        return paymentSuccessful;
    }

    /**
     * Makes a payment by cash.
     *
     * @param paidAmount The amount paid in cash.
     * @return The change that should be returned to the payer.
     */
    public double payByCash(double paidAmount) {
        double totalCost = currentInspection.calculateCost();
        CashPayment payment = new CashPayment(paidAmount, totalCost);

        cashRegister.addPayment(payment);
        Receipt receipt = new Receipt(currentInspection);
        receipt.print(printer);
        return paidAmount - totalCost;
    }

    /**
     * Get the vehicle part that should be inspected next.
     *
     * @return The vehicle part that should be inspected next, if there is no next part, return <code>null</code>.
     */
    public InspectionPartDTO getPartToInspect() {
        currentInspectionPart = currentInspection.getNextPart();
        return currentInspectionPart;
    }

    /**
     * Used to enter the result (pass or fail) of an inspected vehicle part.
     *
     * @param partResult <code>true</code> if the inspection passed, <code>false</code> if it failed.
     */
    public void enterPartResult(boolean partResult) {
        inspectionResults.addPartResult(currentInspectionPart, partResult);
    }

    /**
     * Stores the current inspection results in the database and then prints them out.
     */
    public void finishInspection() {
        inspectionResultsDatabase.addInspectionResults(inspectionResults);
        printer.printInspectionResults(inspectionResults);
    }
}
