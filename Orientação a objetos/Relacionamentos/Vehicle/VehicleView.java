import java.util.Scanner;

//package Vehicle;

public class VehicleView {	
	public void show(Vehicle vehicle,  int licenceNumberSearch) {
		int licenceNumber = vehicle.getLicenseNumber();
		if (licenceNumberSearch == licenceNumber) {
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
			
			String message = "Want you do another search ?";
			retrySearch(message);
		} else {
			String message = "Vehicle not found !";
			retrySearch(message);
		}
	}
		
	public void retrySearch(String message) {
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
			}
		} while(option == 1);
	} 
}
