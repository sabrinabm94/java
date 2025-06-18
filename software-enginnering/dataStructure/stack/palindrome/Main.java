package stack.palindrome;

import javaRepositories.Print;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        boolean palindrome = true;
        Scanner keybord = new Scanner(System.in);

        Print.print("Enter with one string: ");
        String text = keybord.nextLine();
        Stack stack = new Stack(text.length());

        for (int i = 0; i < text.length(); i++) {
            Print.print("Character: " + (i + 1) + ": " + text.charAt(i));
            stack.push(text.charAt(i));
        }

        for(int i = 0; i < text.length(); i++) {
            if(text.charAt(i) != (char) stack.pop()) {
                palindrome = false;
                break;
            }

            Print.print("This text is a palindrome?: " + palindrome);
        }
    }
}
