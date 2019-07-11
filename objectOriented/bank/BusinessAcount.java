package objectOriented.bank;

public final class BusinessAcount extends Account {
    private double loadLimit;

    public double getLoadLimit() {
        return loadLimit;
    }

    public void setLoadLimit(double loadLimit) {
        this.loadLimit = loadLimit;
    }

    public BusinessAcount(int number, String holder, double loadLimit) {
        super(number, holder);
        this.loadLimit = loadLimit;
    }

    public BusinessAcount(int number, String holder, double initialDeposit, double loadLimit) {
        super(number, holder, initialDeposit);
        this.loadLimit = loadLimit;
    }

    @Override
    public void deposit(double amount) {
        if(amount <= loadLimit) {
            deposit(amount);
        }
    }
}
