package objectOriented.interfaceP.carRental;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import javaRepositories.Print;
import objectOriented.interfaceP.carRental.model.CarRental;
import objectOriented.interfaceP.carRental.model.Vehicle;
import objectOriented.interfaceP.carRental.service.BrazilTaxService;
import objectOriented.interfaceP.carRental.service.RentalService;

public class Main {
    public static void main(String[] args) throws ParseException {
        Locale.setDefault(Locale.US);

        Scanner scanner = new Scanner(System.in);
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:ss");

        CarRental carRental = getRentalDate(scanner, dateFormat);
        RentalService rentalService = getInvoiceDate(scanner, carRental);
    }

    public static CarRental getRentalDate(Scanner scanner, SimpleDateFormat dateFormat) throws ParseException {
        Print.println("\nCar rental data");

        Print.println("Enter car model: ");
        String carModel = scanner.nextLine();

        Print.println("Pickup (dd/MM/yyyy hh:ss): ");
        Date startData = dateFormat.parse(scanner.nextLine());

        Print.println("Return (dd/MM/yyyy hh:ss): ");
        Date finishData = dateFormat.parse(scanner.nextLine());

        CarRental carRental = new CarRental(startData, finishData, new Vehicle(carModel));

        return carRental;
    }

    public static RentalService getInvoiceDate(Scanner scanner, CarRental carRental) {
        Print.println("Enter price per hour: ");
        double pricePerHour = scanner.nextDouble();

        Print.println("Enter price per day: ");
        double pricePerDay = scanner.nextDouble();

        //a responsabilidade de instanciar a classe espefícia fica somente no programa principal
        RentalService rentalService = new RentalService(pricePerHour, pricePerDay, new BrazilTaxService());
        rentalService.processInvoice(carRental);

        printInvoiceData(carRental);

        return rentalService;
    }

    public static void printInvoiceData(CarRental carRental) {
        Print.println("\nInvoice result");
        Print.println("Basic payment: " + String.format("%.2f", carRental.getInvoice().getBasicPayment()));
        Print.println("Tax: " + String.format("%.2f", carRental.getInvoice().getTax()));
        Print.println("Total payment: " + String.format("%.2f", carRental.getInvoice().getTotalPayment()));
    }
}
