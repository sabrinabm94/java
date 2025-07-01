package scanner;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String data;
        data = receiveData(scanner);
        print(data);
    }

    public static String receiveData(Scanner scanner) {
        print("Enter with data: \n");
        String setence = scanner.nextLine();
        scanner.close();
        return setence;
    }

    public static void print(String data) {
        System.out.println(data);
    }
}
