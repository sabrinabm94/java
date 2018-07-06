package algoritmos;
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
		int maxNumber = Integer.MIN_VALUE; //this number can go to infinit positive number
		int minNumber = Integer.MAX_VALUE; //this number can go to infinit negative number
		for (i = 0; i < list.length; i += 2) { // n / 2 becase it is comparing 2 number per time
			if(list[i + 1] <= list[list.length]) {
				if (list[i] < list[i + 1]) { //compare the first number with the next to one
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
				//better case: the vector is sorted decreasingly  ex. 5,4,3,2,10
				//(n-1)
			} else {
				System.out.println("End");
				break;
			}
		}
		System.out.println("The max number is: " + maxNumber + " the min number is: " + minNumber);
		return new int[]{maxNumber, minNumber};
	}
}
