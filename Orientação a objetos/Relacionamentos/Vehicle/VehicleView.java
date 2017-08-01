import java.util.Scanner;

//package Vehicle;

public class VehicleView {	
	public void show(Vehicle vehicle) {
		System.out.println("--------------------------");
		System.out.println("LicenseNumber: "  + licenceNumber);
		System.out.println("Name: "  + vehicle.getName());
		System.out.println("Brand: " + vehicle.getBrand());
		System.out.println("Manufacture year: " + vehicle.getManufactureYear());
		System.out.println("City: " + vehicle.getCity());
		System.out.println("Color: " + vehicle.getColor());
		System.out.println("Mileage: " + vehicle.getMileage());
		System.out.println("Value: " + vehicle.getValue());
		System.out.println("--------------------------");
	}
}
