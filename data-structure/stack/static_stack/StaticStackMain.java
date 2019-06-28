import atividade4.StaticStack;

import java.util.Scanner;

public class StaticStackMain {
	public static void main(String[] args) {
		atividade4.StaticStack stack = new StaticStack(10); //passando capacidade
		Scanner keyboard = new Scanner(System.in); 
		int quantity = 0; //limite de 10 atendimentos di�rios, para evitar que ao ser removido um atendimento este libere um novo lugar para atendimentos
		int option = 0;

		while (option != 4) {	
			System.out.println("\n1- New Patient\n2- Removing Patient\n3- Show list of patients\n4- Exit\n");
			System.out.println("Enter with the option: \n");
			option = keyboard.nextInt();
            if (option == 1) {
            	if (quantity < 10) {
            		System.out.println("Enter the patient's name: \n");
                    String name = keyboard.next();
                    stack.push(name);
                    quantity += 1;
            	} else {
            		System.out.println("Limit of medical care exceeded.");
            	}
            } else if (option == 2) {
            	if(!stack.isEmpty()) {
            		System.out.println("Removing Patient...");
            		stack.pop();
            	}
            } else if (option == 3) {
            	System.out.println("Listing patients: ");
            	stack.list();
            } else if (option == 4) {
            	System.out.println("Exiting aplication.");
            } else {
           	 	System.out.println("Invalid option");
           }
        }
	}
}
