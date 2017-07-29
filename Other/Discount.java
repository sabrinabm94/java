import java.util.Scanner;

public class Discount {
	public static int option;
	public static float value;
	public static float discont;
	public static float valueDiscont;
	public static float valueDiscontFinaly;
	
	public static float [] discontList = {0, 5, 10, 20, 40};
	
	public static void main(String[] args) {
		System.out.println("Enter white discont value: ");
		Scanner enter = new Scanner(System.in);
		value = enter.nextFloat();
		
		System.out.println("Choose the discont: 1 for 5%, 2 for 10%, 3 for 20%, e 4 for 50%");
		option = enter.nextInt();
		System.out.println("You have chosen: " + option);
		
		discont = (discontList[option]) * 100;
		valueDiscont = (value * 100) - discont;
		valueDiscontFinaly = valueDiscont / 100;
		System.out.println("The final value of the product is: " + valueDiscontFinaly);
	}

}
