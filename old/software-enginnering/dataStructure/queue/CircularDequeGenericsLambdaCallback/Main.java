package dataStructure.queue.CircularDequeGenericsLambdaCallback;

import java.util.Scanner;
import dataStructure.queue.Deque;
import dataStructure.queue.EmptyListException;
import javaRepositories.Print;

public class Main {
    public static void main(String[] args) throws EmptyListException {
        Deque<Integer> deque = new Deque<Integer>(); //declaração do tipo para filtar as entradas e evitar a necessitade de excessivas tratativas de erros
        Scanner keyboard = new Scanner(System.in);
        int option = 0;

        while (option != 7) {
            Print.print("\n1- Add Fist\n2- Add Last\n3- Remove First\n4- Remove Last\n5- Listing\n6- clear\n7- Exit");
            Print.print("\nEnter with the option: \n");
            option = keyboard.nextInt();

            if (option == 1) {
                if(!deque.isFull()) {
                    Print.print("Enter with one integer number: \n");
                    int value = keyboard.nextInt();
                    deque.addFirst(value);
                } else {
                    Print.print("The deque is full!");
                }
            } else if (option == 2) {
                if(!deque.isFull()) {
                    Print.print("Enter with the value: \n");
                    int value = keyboard.nextInt();
                    deque.addLast(value);
                } else {
                    Print.print("The deque is full!");
                }
            } else if (option == 3) {
                deque.removeFirst();
            } else if (option == 4) {
                deque.removeLast();
            } else if (option == 5) {
                deque.listing((e)-> Print.println(e + ""));
            } else if (option == 6) {
                deque.clear();
            } else if (option == 7) {
                option = 7;
                Print.print("Exiting aplication.\n");
                break;
            } else {
                Print.print("Invalid option");
            }
        }
    }
}
