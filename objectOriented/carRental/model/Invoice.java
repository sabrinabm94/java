package objectOriented.carRental.model;

public class Invoice {
    //Double classe: compatilidade com o banco de dados
    private Double basicPayment;
    private Double tax;

    public Double getBasicPayment() {
        return basicPayment;
    }

    public void setBasicPayment(Double basicPayment) {
        this.basicPayment = basicPayment;
    }

    public Double getTax() {
        return tax;
    }

    public void setTax(Double tax) {
        this.tax = tax;
    }

    public Double getTotalPayment() {
        return getBasicPayment() + getTax();
    }

    public Invoice(Double basicPayment, Double tax) {
        this.basicPayment = basicPayment;
        this.tax = tax;
    }
}
