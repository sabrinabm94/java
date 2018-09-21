package dinamicstack;
public class Main {
	public static void main(String[] args) {
		DinamicStack dinamicStack = new DinamicStack();
		dinamicStack.push(Math.random()*3); //add a random number in stack
		dinamicStack.push(2); //add items in stack
		dinamicStack.push(3); //add items in stack
		dinamicStack.runThrough(); //method to show one per one elements in the stack
		dinamicStack.isEmpty(); //verify if the stack is empty
		dinamicStack.pop(); //remove items in stack
		dinamicStack.clear(); //remove all items in stack
	}
}
