package objectOriented.interfaceP.carRental.model;

public class Vehicle {
    String model;

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Vehicle(String model) {
        this.model = model;
    }
}
