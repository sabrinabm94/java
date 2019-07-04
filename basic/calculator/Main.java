package calculator;

import java.util.Scanner;

public class Main {
	public static float numberA;
	public static float numberB;
	
	public static void main(String[] args) {
		showMenu();
	}
	
	public static void showMenu(){
		Scanner enter = new Scanner(System.in);
		int option = 0;

		Print.print("|======================|");
		Print.print("|   Math operations    |");
		Print.print("|======================|");
		Print.print("| 1 --> Summation      |");
		Print.print("| 2 --> Subtraction    |");
		Print.print("| 3 --> Multiplication |");
		Print.print("| 4 --> Division       |");
		Print.print("| 5 --> Cubed          |");
		Print.print("| 0 --> Exit           |");
		Print.print("|======================|");
		Print.print("Choose the desired option: ");

		option = enter.nextInt();
		selectMenuOption(option);
	}
	
	public static void selectMenuOption(int option){
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
			case 0:
				Print.print("Bye bye");
				option = 0;
			break;
		}
	}

	public static void useSummation(float numberA, float numberB){
		Print.print("Summation");
		Sum sum = new Sum();
		Scanner entrada = new Scanner(System.in);
		Print.print("Enter the number A: ");
		numberA = entrada.nextInt();
		Print.print("Enter the number B: ");
		numberB = entrada.nextInt();
		Print.print("Result: " + sum.summation(numberA, numberB));
		showMenu();
	}
	
	public static void useSubtraction(float numberA, float numberB){
		Print.print("Subtraction");
		Subtract subtract = new Subtract();
		Scanner entrada2 = new Scanner(System.in);
		Print.print("Enter the number A: ");
		numberA = entrada2.nextInt();
		Print.print("Enter the number B: ");
		numberB = entrada2.nextInt();
		Print.print("Result: " + subtract.subtraction(numberA, numberB));
		showMenu();
	}
	
	public static void userMultiplication(float numberA, float numberB){
		Print.print("Multiplication");
		Multiply multiply = new Multiply();
		Scanner entrada3 = new Scanner(System.in);
		Print.print("Enter the number A: ");
		numberA = entrada3.nextInt();
		Print.print("Enter the number B: ");
		numberB = entrada3.nextInt();
		Print.print("Result: " + multiply.multiplication(numberA, numberB));
		showMenu();
	}
	
	public static void useDivision(float numberA, float numberB){
		Print.print("Division");
		Divide divide = new Divide();
		Scanner entrada4 = new Scanner(System.in);
		Print.print("Enter the number A: ");
		numberA = entrada4.nextInt();
		Print.print("Enter the number B: ");
		numberB = entrada4.nextInt();
		Print.print("Result: " + divide.division(numberA, numberB));
		showMenu();
	}
	
	public static void useCubed(float numberA, float numberB){
		Print.print("Cubed");
		Cube cube = new Cube();
		Scanner entrada5 = new Scanner(System.in);
		Print.print("Enter the number A: ");
		numberA = entrada5.nextInt();
		Print.print("Enter the number B: ");
		numberB = entrada5.nextInt();
		Print.print("Result: " + cube.cubed(numberA, numberB));
		showMenu();
	}
}
