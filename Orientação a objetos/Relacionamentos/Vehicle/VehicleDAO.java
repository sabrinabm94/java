//package Vehicle;

public class VehicleDAO {

	public Vehicle setData () {
		Vehicle vehicle = new Vehicle();
		vehicle.setLicenseNumber(105);
		vehicle.setName("Fusca");
		vehicle.setBrand("Volkswagen");
		vehicle.setManufactureYear(1938);
		vehicle.setCity("Joinville");
		vehicle.setColor("Black");
		vehicle.setMileage(50.45);
		vehicle.setValue(1835.00);
		return vehicle;
	}
}
