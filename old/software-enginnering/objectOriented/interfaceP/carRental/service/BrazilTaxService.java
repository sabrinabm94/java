package objectOriented.interfaceP.carRental.service;

public class BrazilTaxService implements TaxService{
    //double primitivo
    public double tax(double amount) {
        if(amount <= 100.0) {
            return amount * 0.2;
        } else {
            return amount * 0.15;
        }
    }
}
