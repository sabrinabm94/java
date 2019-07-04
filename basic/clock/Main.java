package clock;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		int option = 0;
		Clock clock = new Clock();
		Scanner keyboard = new Scanner(System.in);

		while (option != 3) {
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

            if (option == 1) {
				Print.print("Digite a hora: \n");
                int hours = keyboard.nextInt();
				Print.print("Digite os minutos: \n");
                int minuts = keyboard.nextInt();
            	clock.returnAngleByHoursAndMinuts(hours, minuts);
			} else if (option == 2) {
				Print.print("Digite a hora: \n");
				int hours = keyboard.nextInt();
				clock.returnAngleByHours(hours);
			} else if (option == 3) {
				Print.print("Digite o minuto: \n");
				int minuts = keyboard.nextInt();
				clock.returnAngleByMinuts(minuts);
            } else if (option == 4) {
				Print.print("Digite o angulo: \n");
                int angle = keyboard.nextInt();
            	clock.returnMinutesByAngle(angle);
			} else if (option == 5) {
				Print.print("Digite o angulo: \n");
				int angle = keyboard.nextInt();
				clock.returnHoursByAngle(angle);
            } else {
				Print.print("Opção inválida! \n");
            }
		}
	}
}
