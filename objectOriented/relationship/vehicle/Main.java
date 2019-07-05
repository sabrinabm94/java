package objectOriented.relationship.vehicle;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int licenseNumber;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please inform the license number of the vehicle: ");
        licenseNumber = scanner.nextInt();

        DAO vehicleDAO = new DAO();
        Vehicle vehicle = vehicleDAO.getByLicenseNumber(licenseNumber);
        View view = new View();

        int licenceNumberTrue = vehicle.getByLicenseNumber();
        if (licenseNumber == licenceNumberTrue) {
            view.show(vehicle);
            String message = "Want you do another search ?";
            retrySearch(message);
        } else {
            String message = "Vehicle not found !";
            retrySearch(message);
        }
    }

    public static void retrySearch(String message) {
        int option;
        do {
            System.out.println(message);
            System.out.println("Use '1' for search vehicle or any other key for exit program: ");

            Scanner scanner = new Scanner(System.in);
            option = scanner.nextInt();

            if(option == 1) {
                Main main = new Main();
                main.main(null);
            }
            else {
                System.out.println("end program...");
                option = 2;
                break;
            }
        } while(option == 1);
    }
}
