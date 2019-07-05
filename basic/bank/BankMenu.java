package bank;

import javaRepositories.Print;
import java.util.Scanner;

public class BankMenu {
    public static float balance;
    public static int option;

    public static void menu(){
    	Scanner enter = new Scanner(System.in);
        Print.print("Choose one of the options below: ");
        Print.print("1. Deposit");
        Print.print("2. Cash withdrawal");
        Print.print("3. Balance consulte");
        Print.print("0. End");
        Print.print("Option:");
    }

    public static void deposit(){
        Print.print("You entered the deposit method");
        float depositValue;
        Scanner enter = new Scanner(System.in);
        Print.print("Enter the amount to deposit: ");
        depositValue = enter.nextFloat();
        Print.print("The deposit value was: " + depositValue);
        balance = balance + depositValue;
    }

    public static void cashWithdrawal(){
        Print.print("You entered the serve method");
        float cashWithdrawalValue;
        Scanner enter = new Scanner(System.in);
        Print.print("Enter the value to cash withdrawal: ");
        cashWithdrawalValue = enter.nextFloat();
        Print.print("The value of the cash withdrawal was: " + cashWithdrawalValue);
        balance = balance - cashWithdrawalValue;
    }

    public static void consultation(){
        Print.print("You entered the consultation method");
        Print.print("Balance " + balance);
    }

    public static void main(String[] args) {
      Scanner enter = new Scanner(System.in);

      do {
        menu();
        option = enter.nextInt();

        switch(option){
            case 0:
                Print.print("Bye bye");
                break;

            case 1:
                deposit();
            break;

            case 2:
                cashWithdrawal();
                break;

            case 3:
                consultation();
                break;
        }
    } while(option != 0);
    }
}
