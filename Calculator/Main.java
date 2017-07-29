import java.util.Scanner;

public class Main {
	public static float numberA;
	public static float numberB;
	
	public static void main(String[] args) {
		int option = 0;
		showMenu(option);
	}
	
	public static void showMenu(int option){
		System.out.println("|======================|");
		System.out.println("|   Math operations    |");
		System.out.println("|======================|");
		System.out.println("| 1 --> Summation      |");
		System.out.println("| 2 --> Subtraction    |");
		System.out.println("| 3 --> Multiplication |");
		System.out.println("| 4 --> Division       |");
		System.out.println("| 5 --> Cubed          |");
		System.out.println("| 6 --> Exit           |");
		System.out.println("|======================|");
		System.out.print("Choose the desired option: ");
		Scanner enter = new Scanner(System.in);
		option = enter.nextInt();
		menuOption(option);
	}
	
	public static void menuOption(int option){
		switch(option){
			case 1: 
			useSummation(numberA, numberB);
			break;
			case 2: 
			useSubtraction(numberA, numberB);
			break;
			case 3: 
			userMultiplication(numberA, numberB);
			break;
			case 4: 
			useDivision(numberA, numberB);
			break;
			case 5: 
			useCubed(numberA, numberB);
			break;
			case 6: 
			System.out.println("End of the game");
			break;
		}
		
		if (option != 1 && option !=2 && option !=3 && option != 4 && option != 5 && option != 6) {
			System.out.println("Invalid option, try again");
			showMenu(0);
		}
	}

	public static void useSummation(float numberA, float numberB){
		System.out.println("Summation");
		somar Soma = new somar();
		Scanner entrada = new Scanner(System.in); 
		System.out.print("Enter the number A: ");
		numberA = entrada.nextInt();
		System.out.print("Enter the number B: ");
		numberB = entrada.nextInt();
		System.out.print("Result: " + Sum.summation(numberA, numberB));
		showMenu(0);
	}
	
	public static void useSubtraction(float numberA, float numberB){
		System.out.println("Subtraction");
		subtrair Subtracao = new subtrair();
		Scanner entrada2 = new Scanner(System.in);
		System.out.print("Enter the number A: ");
		numberA = entrada2.nextInt();
		System.out.print("Enter the number B: ");
		numberB = entrada2.nextInt();
		System.out.print("Result: " + Subtract.subtraction(numberA, numberB));
		showMenu(0);
	}
	
	public static void userMultiplication(float numberA, float numberB){
		System.out.println("Multiplication");
		multiplicar Multiplicacao = new multiplicar();
		Scanner entrada3 = new Scanner(System.in); 
		System.out.print("Enter the number A: ");
		numberA = entrada3.nextInt();
		System.out.print("Enter the number B: ");
		numberB = entrada3.nextInt();
		System.out.print("Result: " + Multiply.multiplication(numberA, numberB));
		showMenu(0);
	}
	
	public static void useDivision(float numberA, float numberB){
		System.out.println("Division");
		dividir Divisao = new dividir();
		Scanner entrada4 = new Scanner(System.in); 
		System.out.print("Enter the number A: ");
		numberA = entrada4.nextInt();
		System.out.print("Enter the number B: ");
		numberB = entrada4.nextInt();
		System.out.print("Result: " + Divide.division(numberA, numberB));
		showMenu(0);
	}
	
	public static void useCubed(float numberA, float numberB){
		System.out.println("Cubed");
		potencia Potencia = new potencia();
		Scanner entrada5 = new Scanner(System.in); 
		System.out.print("Enter the number A: ");
		numberA = entrada5.nextInt();
		System.out.print("Enter the number B: ");
		numberB = entrada5.nextInt();
		System.out.print("Result: " + Cube.cubed(numberA, numberB));
		showMenu(0);
	}
}
