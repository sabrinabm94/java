import java.util.Scanner;
//package Vehicle;

public class Main {
	public static void main(String[] args) {
		int licenceNumberSearch;
		Scanner scanner = new Scanner(System.in);
		System.out.print("Please inform the license number of the vehicle: ");
		licenceNumberSearch = scanner.nextInt();

		VehicleDAO vehicleDAO = new VehicleDAO();
		Vehicle vehicle = vehicleDAO.getByLicenseNumber(licenseNumber);
		VehicleView view = new VehicleView();

		int licenceNumber = vehicle.getLicenseNumber();
		if (licenceNumberSearch == licenceNumber) {
			view.show(vehicle); 	
		String message = "Want you do another search ?";
			retrySearch(message);
		} else {
			String message = "Vehicle not found !";
			retrySearch(message);
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
} 


