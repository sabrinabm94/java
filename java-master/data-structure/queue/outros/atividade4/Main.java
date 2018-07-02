package atividade4;
import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		Atendimentos list = new Atendimentos(10); //passando capacidade
		Scanner keyboard = new Scanner(System.in); 
		System.out.println("Enter with the option: ");
		int quantity = 0; //limite de 10 atendimentos diários, para evitar que ao ser removido um atendimento este libere um novo lugar para atendimentos
		int option = 0;
		while (true) {
			option = keyboard.nextInt();
			System.out.println("1- New Patient\n2- Removing medical care\n3- Show list of medical care\n4- Exit");
            if (option == 1) {
            	if (quantity < 10) {
            		System.out.println("Enter the patient's name: ");
                    String name = keyboard.next();
                    list.push(name);
            	} else {
            		System.out.println("Limit of medical care exceeded.");
            	}
            } else if (option == 2) {
            	if(!list.isEmpty()) {
            		System.out.println("Removing medical care...");
            		list.pop();
            	}
            } else if (option == 3) {
            	System.out.println("Listing medical care: ");
            	list.list();
            }  else {
           	 	System.out.println("Invalid option");
           }
        }
	}
}
