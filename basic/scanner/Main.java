package scanner;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String data;
        data = receiveData();
        printData(data);
    }

    public static String receiveData() {
        Scanner scanner = new Scanner(System.in);
        String setence = scanner.nextLine();
        scanner.close();
        return setence;
    }

    public static void printData(String data) {
        System.out.println(data);
    }
}
