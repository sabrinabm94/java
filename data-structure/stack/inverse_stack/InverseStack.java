import java.util.Scanner;

public class InverseStack {
	public static void main(String[] args) {
		Scanner keybord = new Scanner(System.in);
		System.out.print("Set a number for the stack capacity: ");

		int capacity = keybord.nextInt();
		InverseStackMain stack = new InverseStackMain(capacity);

		for(int i = 0; i < capacity; i++) {
			double value = keybord.nextDouble();
			stack.push(value);
		}

		stack.list();
	}
}
