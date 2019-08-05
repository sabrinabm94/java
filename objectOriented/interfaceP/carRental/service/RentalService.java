package objectOriented.interfaceP.carRental.service;

import objectOriented.interfaceP.carRental.model.CarRental;
import objectOriented.interfaceP.carRental.model.Invoice;

public class RentalService {
    private Double pricePerDay;
    private Double pricePerHour;

    //Não é uma boa prática chamar direto o BrazilTaxService, pelo alto acoplamento, por isso usamos a interface
    //É instanciado uma classe generalista que implementará a interface
    private TaxService taxService;

    public Double getPricePerDay() {
        return pricePerDay;
    }

    public void setPricePerDay(Double pricePerDay) {
        this.pricePerDay = pricePerDay;
    }

    public Double getPricePerHour() {
        return pricePerHour;
    }

    public void setPricePerHour(Double pricePerHour) {
        this.pricePerHour = pricePerHour;
    }

    public TaxService getTaxService() {
        return taxService;
    }

    public void setTaxService(TaxService taxService) {
        this.taxService = taxService;
    }

    public RentalService(Double pricePerHour, Double pricePerDay, TaxService taxService) {
        super();
        this.pricePerDay = pricePerDay;
        this.pricePerHour = pricePerHour;
        this.taxService = taxService;
    }

    public void processInvoice(CarRental carRental) {
        long startDataInMilliseconds = carRental.getStart().getTime();
        long finishDataInMilliseconds = carRental.getFinish().getTime();
        double dataInHours = (double)((((finishDataInMilliseconds - startDataInMilliseconds) / 1000) / 60) / 60);
        double basicPayment;

        if(dataInHours <= 12) {
            basicPayment = Math.ceil(dataInHours) * pricePerHour;
        } else {
            basicPayment = Math.ceil(dataInHours / 24) * pricePerDay;
        }

        double tax = taxService.tax(basicPayment);
        carRental.setInvoice(new Invoice(basicPayment, tax));
        //criado novo objeto de nota de pagamento associado ao aluguel
    }
}
