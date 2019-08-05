package objectOriented.carRental.model;

import java.util.Date;

public class CarRental {
    private Date start;
    private Date finish;

    private Vehicle vehicle;
    private Invoice invoice;

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public Date getFinish() {
        return finish;
    }

    public void setFinish(Date finish) {
        this.finish = finish;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public Invoice getInvoice() {
        return invoice;
    }

    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
    }

    public CarRental() {
        //adicionado pois alguns framework exigem os construtores padrões nos modelos
    }

    public CarRental(Date start, Date finish, Vehicle vehicle) {
        this.start = start;
        this.finish = finish;
        this.vehicle = vehicle;
        this.invoice = invoice;
    }
}
