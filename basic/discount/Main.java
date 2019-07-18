package discount;

import javaRepositories.Print;
import java.util.Scanner;

public class Main {
	public static int option;
	public static float value;
	public static float discount;
	public static float valueDiscount;
	public static float valueDiscountFinaly;
	
	public static float [] discountList = {0, 5, 10, 20, 40};
	
	public static void main(String[] args) {
		Print.print("Enter with the product value: ");
		Scanner scanner = new Scanner(System.in);
		value = scanner.nextFloat();

		Print.print("Choose the discount: 1 for 5%, 2 for 10%, 3 for 20%, e 4 for 50%");
		option = scanner.nextInt();
		Print.print("You have chosen: " + option);

		discount = (discountList[option]) * 100;
		valueDiscount = (value * 100) - discount;
		valueDiscountFinaly = valueDiscount / 100;

		if(valueDiscountFinaly > value || valueDiscountFinaly <= 0) {
			Print.print("The discount can't be highter than product value, try again.");
		} else {
			Print.print("The final value of the product is: " + valueDiscountFinaly);
		}
	}
}
