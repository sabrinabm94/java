import java.util.Scanner;

public class SmallerNumber {
	public static float number1;
	public static float number2;
	public static float number3;
	public static float larger;
	
	public static void main(String[] args) {
		Scanner enter = new Scanner(System.in);
		System.out.println("Enter a number: ");
		number1 = enter.nextFloat();

		System.out.println("Enter another number: ");
		number2 = enter.nextFloat();

		System.out.println("Enter another more number: ");
		number3 = enter.nextFloat();

		if(number1 > number2){
			larger = number1;
		}

		else {
			larger = number2;
		}

		if(number2 > number1){
			larger = number2;
		}

		else {
			larger = number1;
		}

		if(number1 > number3){
			larger = number1;
		}

		else {
			larger = number3;
		}

		if(number2 > number3){
			larger = number2;
		}

		else {
			larger = number3;
		}
		
		System.out.println("The biggest is:" + larger);
	}

}
