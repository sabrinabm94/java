package performance.noInstructionsCounter;

import java.util.Scanner;
import javaRepositories.Print;

public class mediumCase {
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

        Print.print("The max number is: " + maxNumber + " the min number is: " + minNumber);
        return new int[]{maxNumber, minNumber};
    }
}
