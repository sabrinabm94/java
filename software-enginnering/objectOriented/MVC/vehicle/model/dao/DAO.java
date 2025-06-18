package objectOriented.MVC.vehicle.model.dao;

import objectOriented.MVC.vehicle.model.Vehicle;

public class DAO {
    public Vehicle createDefaultVehicle() {
        Vehicle vehicle = new Vehicle();
        vehicle.setLicenseNumber(1);
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
