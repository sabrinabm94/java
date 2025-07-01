package cashMachine;

public class Main {
    public static void main(String[] args) {
        //double[] notas = {100, 50, 20, 10, 5, 2}; //lista organizada
        double[] moneyBill = { 2, 5, 10, 20, 50, 100 }; //lista desorganizada

        CashMachine cashMachine = new CashMachine();
        cashMachine.sortMoneyBill(moneyBill);
        cashMachine.bankDraft(moneyBill, 150); //testando notas de maior valor
        cashMachine.bankDraft(moneyBill, 12.5); //testando decimais
        cashMachine.bankDraft(moneyBill, 1); //testando BankDraft impossível
    }
}
