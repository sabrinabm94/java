package objectOriented.carRental;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import javaRepositories.Print;
import objectOriented.carRental.model.CarRental;
import objectOriented.carRental.model.Vehicle;
import objectOriented.carRental.service.BrazilTaxService;
import objectOriented.carRental.service.RentalService;

public class Main {
    /*
    Interfaces clássicas: não tem implementação de métodos
    carRental java 8+: podem ter implementação de métodos

    É um tipo que define um conjunto de operações que uma classe deverá implementar.
    Estabelecando um contrato que a classe deve cumprir.
    É utilizado para criar sistemas com baixo acoplamento de flexíveis.
    */

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
