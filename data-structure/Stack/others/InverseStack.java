package Pilha;
public class InverseStack {
	public static void main(String[] args) {
		Scanner keybord = new Scanner(System.in);
		System.out.print("Informe o número de elementos: ");
		
		int capacity = keybord.nextInt();
		
		Stack stack = new Stack(capacity);
		
		for(int i = 0; i < capacity; i++) {
			double value = keybord.nextDouble();
			
			stack.push(value);
		}
		
		stack.list();
	}
}
