package algoritmos;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter with a capacity number: ");
		int capacity = scanner.nextInt();
		System.out.println("The capacity is: ");
		int number = 0;
		int[] list = new int[capacity];
		enterList(list, number, scanner);
		returnMax(list);
	}	
	public static void enterList(int list[], int number, Scanner scanner) {
		for(int j = 0; j < list.length; j++) {
			System.out.println("Enter with a number: ");
			number = scanner.nextInt();
			list[j] = number;
		}
	}
	public static int returnMax(int list[]) {
		int max = list[0];
		for (int i = 1; i < list.length; i++) {
			if (list[i] > max) { //worse situation: the vector is sorted decreasingly
				max = list[i]; //better situation: the vector is sorted increasingly
			}
		}
		System.out.println("The max number is: " + max);
		return max;
	}
	//complexity: the most frequent number in the operation (is not a constant)
	//f(n) = n - 1
}

