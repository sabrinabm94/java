package objectOriented.MVC.vehicle.controller;

import objectOriented.MVC.vehicle.Main;
import objectOriented.MVC.vehicle.model.Vehicle;
import objectOriented.MVC.vehicle.model.dao.DAO;
import objectOriented.MVC.vehicle.view.View;
import java.util.Scanner;

public class Controller {
    private DAO dao;
    private View view;

    public Controller(){
        dao = new DAO();
        view = new View();
    }

    public void init() {
        Vehicle vehicle = dao.createDefaultVehicle();

        int licenseNumber;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Inform the licence number from Vehicle to search: ");
        licenseNumber = scanner.nextInt();

        if(licenseNumber == vehicle.getByLicenseNumber()) {
            view.show(vehicle);
            String message = "Do you want do another search ?";
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
            System.out.println("1- search again \nOr any other key for exit program: ");

            Scanner scanner = new Scanner(System.in);
            option = scanner.nextInt();

            if(option == 1) {
                Main main = new Main();
                main.main(null);
            }
            else {
                System.out.println("Bye bye");
                option = 2;
                break;
            }
        } while(option == 1);
    }
}
