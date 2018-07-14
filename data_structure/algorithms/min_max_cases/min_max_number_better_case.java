package algorithm;
import java.util.Scanner;
public class min_max_number_better_case {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter with a capacity number: ");
		int capacity = scanner.nextInt();
		System.out.println("The capacity is: " + capacity);
		int number = 0;
		int[] list = new int[capacity];
		enterList(list, number, scanner);
		verifyCapacity(capacity, list);
	}	
	public static void enterList(int list[], int number, Scanner scanner) {
		for(int j = 0; j < list.length; j++) {
			System.out.println("Enter with a number: ");
			number = scanner.nextInt();
			list[j] = number;
		}
	}
	public static void verifyCapacity(float capacity, int list[]) {
		int i = 0;
		int a = 0; //the lowest value in the comparation
		int b = 0; //the high value in the comparation
		int maxNumber = Integer.MIN_VALUE; //this number can go to infinity positive number
		int minNumber = Integer.MAX_VALUE; //this number can go to infinity negative number
		if(capacity % 2 == 0) {
			System.out.println("The capacity is Even");
			returnMaxMinForEven(i, list, maxNumber, minNumber, a, b);
		} else {
			System.out.println("The capacity is Odd");
			ReturnMaxMinForOdd(i, list, maxNumber, minNumber, a, b);
		}
	}
	public static int[] returnMaxMinForEven(int i, int list[], Integer maxNumber, Integer minNumber, int a, int b) {
		for (i = 0; i < list.length; i += 2) {
			if (list[i] < list[i + 1]) { //compare the first number with the next to one
				a = i; //the lowest value is i;
				b = i + 1; //the high value is next value;
			} else {
				a = i + 1; //the lowest value is next value; 
				b = i; //the high value is i;
			}
			if(list[a] < minNumber) { //if the low value of comparation is lower than the minNumber
				minNumber = list[a]; //this number will be the new minNumber				
			}
			if(list[b] > maxNumber) { //if the high number of comparation is biggest than maxNumber
				maxNumber = list[b]; //this number will be the new maxNumber
			}//-1 ou não
			//better case: the vector is sorted decreasingly  ex. 5,4,3,2,10
			//(n-1)
		}
		System.out.println("The high number is: " + maxNumber + " and the minimum number is: " + minNumber);
		return new int[]{maxNumber, minNumber};
	}
	public static int[] ReturnMaxMinForOdd(int i, int list[], Integer maxNumber, Integer minNumber, int a, int b) {
		for (i = 0; i < list.length - 1; i += 2) { // n / 2 because it is comparing 2 number per time
			if (list[i] < list[i + 1]) {
				a = i; 
				b = i + 1; 
			} else {
				a = i + 1; 
				b = i;
			}
			if(list[a] < minNumber) { 
				minNumber = list[a];		
			}
			if(list[b] > maxNumber) {
				maxNumber = list[b]; 
			} 
			if(list[list.length-1] < minNumber) { 
				minNumber = list[list.length-1];		
			}
			if(list[list.length-1] > maxNumber) {
				maxNumber = list[list.length-1]; 
			}
		}
		System.out.println("The high number is: " + maxNumber + " and the minimum number is: " + minNumber);
		return new int[]{maxNumber, minNumber};
	}
}
