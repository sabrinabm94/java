package trabalho;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) { 
        Deque<String> deque = new Deque<>();
        String value;
        Scanner scanner = new Scanner(System.in);
        while (true) {         
            System.out.println("Select the option\n 1->Add first:\n 2->Add last:\n3->List:\n 4->Remove first:\n 5->Remove last:\n 6->Clear:\n 7->Exit:\n");
            String option = scanner.next();
            if ("1".equals(option)) {
                System.out.println("Enter with the value: ");
                value = scanner.next();
                deque.addFirst(value);
            } else if ("2".equals(option)) {
                System.out.println("Enter with the value: ");
                value = scanner.next();
                deque.addLast(value);
            } else if ("3".equals(option)) {
                deque.listing();
            } else if ("4".equals(option)) {
                try {
                    deque.removeFirst();
                } catch (EmptyListException e) {
                    System.out.println(e.getMessage());
                }
            } else if ("5".equals(option)) {
                try {
                    deque.removeLast();
                } catch (EmptyListException e) {
                    System.out.println(e.getMessage());
                }
            } else if ("6".equals(option)) {
                deque.clear();
            } else if ("7".equals(option)) {
                break;
            } else {
            	Interface i = System.out::println;
            	Interface.sendMessage("Invalid option");
            }
        }
    }
}