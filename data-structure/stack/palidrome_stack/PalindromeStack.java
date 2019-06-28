import java.util.Scanner;

public class PalindromeStack {
	public static void main(String[] args) {
		boolean palindrome = true;
		Scanner keybord = new Scanner(System.in);
		System.out.print("Enter with one string: ");
		String text = keybord.nextLine();
		InverseStackMain inverseStackMain = new InverseStackMain(text.length());

		for(int i = 0; i < text.length(); i++) {
			System.out.println("Character: " + (i + 1) + ": " + text.charAt(i));
			inverseStackMain.push(text.charAt(i));
		}

		for(int i = 0; i < text.length(); i++) {
			if(text.charAt(i) != (char) inverseStackMain.pop()) {
				palindrome = false;
				break;
			}
		}

		System.out.println("This text is a palindrome?: " + palindrome);
	}
}
