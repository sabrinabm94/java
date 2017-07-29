import java.util.Scanner;

public class DayOfWeek {
	public static int day;
	public static String [] days = {"Monday," "Tuesday," "Wednesday," "Thursday," "Friday," "Saturday," "Sunday"};

	public static void main(String[] args) {
		Scanner enter = new Scanner(System.in);
		System.out.print("Enter a number of the day you want to see: ");
		day = enter.nextInt();
		System.out.print(days [day - 1]);
	}
}