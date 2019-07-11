package daysOfWeek;

import java.util.Scanner;

public class Main {
	public static int dayNumber;
	public static String dayName;
	public static String [] days = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};

	public static void main(String[] args) {
		dayNumber = getData();
		dayName = getDayName(dayNumber);
		print(dayName);
	}

	public static int getData() {
		Scanner scanner = new Scanner(System.in);
		print("Enter with the number of the day of week that you want to see: ");
		return scanner.nextInt();
	}

	public static String getDayName(int dayNumber) {
		return days [dayNumber - 1];
	}

	public static void print(String data) {
		System.out.println(data);
	}
}