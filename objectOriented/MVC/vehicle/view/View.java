package objectOriented.MVC.vehicle.view;

import javaRepositories.Print;
import objectOriented.MVC.vehicle.model.Vehicle;

public class View {
    public void show(Vehicle vehicle) {
        Print.println("\n================================");
        Print.println("LicenseNumber: "  + vehicle.getByLicenseNumber());
        Print.println("Name: "  + vehicle.getName());
        Print.println("Brand: " + vehicle.getBrand());
        Print.println("Manufacture year: " + vehicle.getManufactureYear());
        Print.println("City: " + vehicle.getCity());
        Print.println("Color: " + vehicle.getColor());
        Print.println("Mileage: " + vehicle.getMileage());
        Print.println("Value: " + vehicle.getValue());
        Print.println("================================\n");
    }
}
