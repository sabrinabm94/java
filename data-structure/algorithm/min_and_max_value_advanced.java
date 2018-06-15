package algoritmos;

import java.util.Scanner;

public class min_and_max_value_advanced {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter with a capacity number: ");
		int capacity = scanner.nextInt();
		System.out.println("The capacity is: ");
		int number = 0;
		int[] list = new int[capacity];
		enterList(list, number, scanner);
		returnMaxMin(list);
	}	
	public static void enterList(int list[], int number, Scanner scanner) {
		for(int j = 0; j < list.length; j++) {
			System.out.println("Enter with a number: ");
			number = scanner.nextInt();
			list[j] = number;
		}
	}
	public static int[] returnMaxMin(int list[]) {
		int i;
		int a; //the lowest value in the comparation
		int b; //the high value in the comparation
		int maxNumber = Integer.MIN_VALUE;
		int minNumber = Integer.MAX_VALUE;
		for (i = 0; i < list.length; i += 2) {
			if (list[i] < list[i + 1]) { 
				a = i; //the lowest value is i;
				b = i + 1; //the high value is next value;
			}                
			else {
				a = i + 1; //the lowest value is next value; 
				b = i; //the high value is i;
			}
			if(list[a] < minNumber) { //if the low value of comparation is lower than the minNumber
				minNumber = list[a]; //this number will be the new minNumber				
			}
			if(list[b] > maxNumber) { //if the high number of comparation is biggest than maxNumber
				maxNumber = list[b]; //this number will be the new maxNumber
			}
		}
		System.out.println("The max number is: " + maxNumber + " the min number is: " + minNumber);
		return new int[]{maxNumber, minNumber};
	}
}
