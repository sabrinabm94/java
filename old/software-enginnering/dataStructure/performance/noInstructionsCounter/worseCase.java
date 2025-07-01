package performance.noInstructionsCounter;

import java.util.Scanner;
import javaRepositories.Print;

public class worseCase {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Print.print("Enter with a capacity number: ");
        int capacity = scanner.nextInt();
        Print.print("The capacity is: " + capacity);
        int number = 0;
        int[] list = new int[capacity];

        enterList(list, number, scanner);
        returnMaxMin(list);
    }

    public static void enterList(int list[], int number, Scanner scanner) {
        for(int j = 0; j < list.length; j++) {
            Print.print("Enter with a number: ");
            number = scanner.nextInt();
            list[j] = number;
        }
    }

    public static int[] returnMaxMin(int list[]) {
        int maxNumber = list[0];
        int minNumber = list[0];

        for (int i = 1; i < list.length; i++) { //A: elements n - 1: x times that one value enter in this if
            if (list[i] > maxNumber) {
                maxNumber = list[i]; //A < n - 1 elements going to enter n - 1 times in this if
            }
            if(list[i] < minNumber) {
                minNumber = list[i]; //2(n-1) exist 2 ifs, so it is 2x n-1
            }
            //complexity: the most frequent number in the operation (is not a constant)
            //worse case: the vector is sorted increasingly ex. 0,1,2,3,4,5
            //2(n-1)
        }

        Print.print("The max number is: " + maxNumber + " the min number is: " + minNumber);
        return new int[]{maxNumber, minNumber};
    }
}
