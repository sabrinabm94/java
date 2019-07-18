package stack.staticStack;

import javaRepositories.Print;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Stack stack = new Stack(5); //instance the stack

        for(int i = 0; i <= 6; i++) {
            stack.push(i); //add items in stack
        }

        stack.pop(); //remove one item from stack
        stack.clear(); //remove one per one items in stack
    }
}
