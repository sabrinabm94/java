package objectOriented.bank;

import javaRepositories.Print;
import objectOriented.products.Product;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner scanner = new Scanner(System.in);

        //criação de conta
        Account account = createAccount(scanner);
        print(account);

        //depósito
        deposit(scanner, account);
        print(account);

        //saque
        withdraw(scanner, account);
        print(account);
    }

    public static Account createAccount(Scanner scanner) {
        Account account;
        Print.print("\nEnter with the account number: ");
        int number = scanner.nextInt();

        scanner.nextLine(); //fix para não pular a entrada da string
        Print.print("\nEnter with the account holder: ");
        String holder = scanner.nextLine();

        Print.print("\nIs there an initial deposit? y/n ");
        char initialDeposit = scanner.next().charAt(0);

        if(initialDeposit == 'y' || initialDeposit == 'Y') {
            Print.print("\nEnter with the initial deposit value: ");
            double initialDepositValue = scanner.nextDouble();
            account = new Account(number, holder, initialDepositValue);

            return account;
        } else {
            account = new Account(number, holder);

            return account;
        }
    }

    public static void deposit(Scanner scanner, Account account) {
        Print.print("\nDeposit ");
        Print.print("Enter with the value: ");
        double amount = scanner.nextDouble();
        account.deposit(amount);
    }

    public static void withdraw(Scanner scanner, Account account) {
        Print.print("\nWithdraw ");
        Print.print("Enter with the value: ");
        double amount = scanner.nextDouble();
        account.withdraw(amount);
    }

    public static void print(Account account) {
        Print.print("\nAccount \nNumber: " + account.getNumber() + "\nHolder: " + account.getHolder() + "\nBalance: $ " + account.getBalance());
    }
}
