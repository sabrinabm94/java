import java.util.Scanner;
public class Main {
    public static void main(String[] args) { 
        Deque<Integer> deque = new Deque<>();
        Integer value;
        Scanner scanner = new Scanner(System.in);
        while (true) {         
            System.out.println("Select the option\n 1->Add first:\n 2->Add last:\n3->List:\n 4->Remove first:\n 5->Remove last:\n 6->Clear:\n 7->Exit:\n");
            String option = scanner.next();
            if ("1".equals(option)) {
                System.out.println("Enter with the value: ");
                value = scanner.nextInt();
                deque.addFirst(value);
            } else if ("2".equals(option)) {
                System.out.println("Enter with the value: ");
                value = scanner.nextInt();
                deque.addLast(value);
            } else if ("3".equals(option)) {
            	deque.listing((e)-> System.out.println(e*e)); //lambda para elementos os métodos fora do método listing
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
            	 System.out.println("Invalid option");
            }
        }
    }
}