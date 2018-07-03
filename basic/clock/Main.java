package clock;
import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		Clock clock = new Clock();
		Scanner keyboard = new Scanner(System.in); 
		int option = 0;
		while (option != 3) {	
			System.out.println("\n1- Calcular ângulo informando horas \n2- Calcular Minutos informando ângulo\n3- Sair");
			System.out.println("Digite a opção desejada: \n");
			option = keyboard.nextInt();
            if (option == 1) {
            	System.out.println("Digite a hora: \n");
                int hours = keyboard.nextInt();
                System.out.println("Agora digite os minutos: \n");
                int minuts = keyboard.nextInt();
            	clock.returnAngle(hours, minuts); /* não adicionei o GregorianCalendar pois tive dúvidas: isso seria um tipo? não seria válido somente para datas? */
            } else if (option == 2) {
            	System.out.println("Digite o ângulo: \n");
                int angle = keyboard.nextInt();
            	clock.returnMinuts(angle);
            } else {
            	System.out.println("Opção inválida! \n");
            }
		}
	}
}
