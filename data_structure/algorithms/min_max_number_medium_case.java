package algoritmos;
import java.util.Scanner;
public class min_max_number_medium_case {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter with a capacity number: ");
		int capacity = scanner.nextInt();
		System.out.println("The capacity is: " + capacity);
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
		int maxNumber = list[0]; //1
		int minNumber = list[0]; //1
		for (int i = 1; i < list.length; i++) { //n - 1
			if (list[i] > maxNumber) { //n - 1
				maxNumber = list[i]; //A < n - 1
			}
			else { //if the low value of comparation is lower than the minNumber
				if(list[i] < minNumber) { //this number will be the new minNumber
					minNumber = list[i]; //B<(n-1)-A				
				}
			}
			//medium case: the vector have both ex. 0,1,2,5,4,3
			//3(n-1)/2
		}
		System.out.println("The max number is: " + maxNumber + " the min number is: " + minNumber);
		return new int[]{maxNumber, minNumber};
	}
}
