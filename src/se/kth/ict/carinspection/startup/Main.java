package se.kth.ict.carinspection.startup;

import se.kth.ict.carinspection.controller.Controller;
import se.kth.ict.carinspection.integration.*;
import se.kth.ict.carinspection.view.View;

import java.util.ArrayList;

/**
 * Performs all startup of the application.
 */
public class Main {

    /**
     * Starts the application.
     *
     * @param args This application does not take any command line parameters.
     */
    public static void main(String[] args) {
        Printer printer = new Printer();
        Garage garage = new Garage();
        PaymentAuthorizationSystem paymentAuthorizationSystem = new PaymentAuthorizationSystem();
        InspectionResultsDatabase inspectionResultsDatabase = new InspectionResultsDatabase();
        VehicleRegistry vehicleRegistry = new VehicleRegistry();

        Controller contr = new Controller(garage, vehicleRegistry, paymentAuthorizationSystem,
                inspectionResultsDatabase, printer);

        new View(contr);
    }
}
