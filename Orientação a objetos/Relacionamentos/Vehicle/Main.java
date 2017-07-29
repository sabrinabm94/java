import java.util.Scanner;
//package Vehicle;

	public class Main {
		public static void main(String[] args) {
			int licenceNumberSearch;
			Scanner scanner = new Scanner(System.in);
			System.out.print("Please inform the license number of the vehicle: ");
			licenceNumberSearch = scanner.nextInt();
			
			VehicleDAO vehicleDAO = new VehicleDAO();
			Vehicle vehicle = vehicleDAO.setData();
			VehicleView view = new VehicleView();
			view.show(vehicle, licenceNumberSearch); 	
		}
	} 


