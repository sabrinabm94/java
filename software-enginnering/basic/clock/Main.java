package clock;

import javaRepositories.Print;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		int option = 1, hours = 0, minuts = 0, angle = 0;
		Clock clock = new Clock();
		Scanner keyboard = new Scanner(System.in);

		while (option != 0) {
			Print.print("\n" +
					"1- Calcular angulo por horas e minutos \n" +
					"2- Calcular angulo por horas \n" +
					"3- Calcular angulo por minutos \n" +
					"4- Calcular minutos por angulo \n" +
					"5- Calcular horas por angulo \n" +
					"0- Sair \n"
			);

			Print.print("Digite a opção desejada: \n");
			option = keyboard.nextInt();

			switch(option) {
				case 1:
					Print.print("Digite a hora: \n");
					hours = keyboard.nextInt();
					Print.print("Digite os minutos: \n");
					minuts = keyboard.nextInt();
					clock.returnAngleByHoursAndMinuts(hours, minuts);
					break;
				case 2:
					Print.print("Digite a hora: \n");
					hours = keyboard.nextInt();
					clock.returnAngleByHours(hours);
					break;
				case 3:
					Print.print("Digite o minuto: \n");
					minuts = keyboard.nextInt();
					clock.returnAngleByMinuts(minuts);
					break;
				case 4:
					Print.print("Digite o angulo: \n");
					angle = keyboard.nextInt();
					clock.returnMinutesByAngle(angle);
					break;
				case 5:
					Print.print("Digite o angulo: \n");
					angle = keyboard.nextInt();
					clock.returnHoursByAngle(angle);
					break;
				case 0:
					Print.print("Bye bye");
					break;
			}
		}
	}
}
