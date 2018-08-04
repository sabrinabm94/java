import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		Deque<Integer> deque = new Deque<Integer>(); //declaração do tipo para filtar as entradas e evitar a necessitade de excessivas tratativas de erros
		Scanner keyboard = new Scanner(System.in); 
		int option = 0;
		while (option != 7) {	
			System.out.println("\n1- Add Fist\n2- Add Last\n3- Remove First\n4- Remove Last\n5 - Listing\n6 - clear\n7 - Exit");
			System.out.println("Enter with the option: \n");
			option = keyboard.nextInt();
            if (option == 1) {
            	if(!deque.isFull()) {
            		System.out.println("Enter with one integer number: \n");
                    int value = keyboard.nextInt();
                    deque.addFirst(value);
                } else {
                	System.out.println("The deque is full!");
                }
            } else if (option == 2) {
            	if(!deque.isFull()) {
            		System.out.println("Enter with the value: \n");
                    int value = keyboard.nextInt();
                    deque.addLast(value);
                } else {
                	System.out.println("The deque is full!");
                }
            } else if (option == 3) {
            	try {
                	deque.removeFirst();
            	} catch (EmptyListException e) {
                	System.out.println(e.getMessage());
            	}
            } else if (option == 4) {
            	try {
                	deque.removeLast();
            	} catch (EmptyListException e) {
                	System.out.println(e.getMessage());
            	}
            } else if (option == 5) {
            	deque.listing((e)-> System.out.println(e));
            } else if (option == 6) {
            	deque.clear();
            } else if (option == 7) {
            	option = 7;
            	System.out.println("Exiting aplication.");
            	break;
            } else {
           	 	System.out.println("Invalid option");
            }
        }
	}
}