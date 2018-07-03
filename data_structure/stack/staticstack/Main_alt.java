public class Main_alt {
	public static void main(String[] args) {
		StaticStack staticStack = new StaticStack(5); //instance the stack
		for(int i = 0; i <= 6; i++) {
			staticStack.push(i); //add items in stack
		}
		staticStack.pop(); //remove one item from stack
		staticStack.clear(); //remove one per one items in stack
	}
}