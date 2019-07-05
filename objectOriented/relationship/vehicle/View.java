package objectOriented.relationship.vehicle;

import javaRepositories.Print;

public class View {
    public void show(Vehicle vehicle) {
        Print.print("================================");
        Print.print("LicenseNumber: "  + vehicle.getByLicenseNumber());
        Print.print("Name: "  + vehicle.getName());
        Print.print("Brand: " + vehicle.getBrand());
        Print.print("Manufacture year: " + vehicle.getManufactureYear());
        Print.print("City: " + vehicle.getCity());
        Print.print("Color: " + vehicle.getColor());
        Print.print("Mileage: " + vehicle.getMileage());
        Print.print("Value: " + vehicle.getValue());
        Print.print("================================");
    }
}
