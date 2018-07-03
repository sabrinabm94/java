package algoritmos;

import java.util.Scanner;

public class min_and_max_value {
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
		int maxNumber = list[0];
		int minNumber = list[0];
		for (int i = 1; i < list.length; i++) {
			if (list[i] > maxNumber) { //worse case: the vector is sorted increasingly ex. 0,1,2,3,4,5
				maxNumber = list[i]; //better case: the vector is sorted decreasingly  ex. 5,4,3,2,10
			}                 //medium case: the vector have both ex. 0,1,2,5,4,3
			else {
				minNumber = list[i];
			}
		}
		System.out.println("The max number is: " + maxNumber + " the min number is: " + minNumber);
		return new int[]{maxNumber, minNumber};
	}
	//complexity: the most frequent number in the operation (is not a constant)
	//f(n) = n - 1
}

