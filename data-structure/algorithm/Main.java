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
		returnMin(list);
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
			if (list[i] > max) { //worse case: the vector is sorted increasingly ex. 0,1,2,3,4,5
				max = list[i]; //better case: the vector is sorted decreasingly  ex. 5,4,3,2,10
			}                 //medium case: the vector have both ex. 0,1,2,5,4,3
		}
		System.out.println("The max number is: " + max);
		return max;
	}
	public static int returnMin(int list[]) {
		int min = list[0];
		for (int i = 1; i < list.length; i++) {
			if (list[i] < min) {
				min = list[i];
			}
		}
		System.out.println("The min number is: " + min);
		return min;
	}
	//complexity: the most frequent number in the operation (is not a constant)
	//f(n) = n - 1
}

