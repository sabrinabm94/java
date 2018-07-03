public class PalindromeStack {
	public static void main(String[] args) {
		Scanner keybord = new Scanner(System.in);
		System.out.print("Enter with one string: ");
		String text = keybord.nextLine();
		Stack stack = new Stack(text.lenght());
		for(int i = 0; i < text.lenght(); i++) {
			System.out.println("Character: " + (il + 1) + ": " + text.charAT(i));
			stack.push(text.charAt(i));
		}
		boolean palindrome = true
		for(int i = 0; i < text.lenght(); i++) {
			if(text.charAt(i) !== (char).pilha.pop()) {
				palidromo = false;
				break;
			}
		}
	}
	System.out.println("This text is a palindrome?: " + palindrome);
}
