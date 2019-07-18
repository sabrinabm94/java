package stringFunctions;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String string = "Hello";
        int option = 1;

        while(option != 0) {
            formateString(scanner, option, string);
        }

        scanner.close();
        print("Bye bye");
    }

    public static void formateString(Scanner scanner, int option, String string) {
        if(option != 0) {
            option = receiveInt(scanner, option);
            string = receiveString(scanner, string);
            string = formateStringByOption(option, string);
            print(string);
        }
    }

    public static String receiveString(Scanner scanner, String string) {
        print("Enter with a string: ");
        string = scanner.nextLine();

        return string;
    }

    public static int receiveInt(Scanner scanner, int option) {
        print("Select one option number to formate a string:\n" +
                "1- to lower case\n" +
                "2- to upper case\n" +
                "3- remove white spaces\n" +
                "4- get the first world\n" +
                "0- exit\n"
                );
        print("Enter with a option number:\n");
        option = Integer.parseInt(scanner.nextLine());

        return option;
    }

    public static String formateStringByOption(int option, String string) {
        switch(option){
            case 1:
                return toLowerCase(string);
            case 2:
                return toUperCase(string);
            case 3:
                return removeWhiteSpaces(string);
            case 4:
                //return String.join(" ", splitBySpaces(string));
                return splitBySpaces(string)[0];
        }

        return string;
    }

    public static String toLowerCase(String string) {
        return string.toLowerCase();
    }

    public static String toUperCase(String string) {
        return string.toUpperCase();
    }

    public static String removeWhiteSpaces(String string) {
        return string.trim();
    }

    public static String[] splitBySpaces(String string) {
        return string.split(" ");
    }

    public static void print(String string) {
        System.out.println(string);
    }
}

