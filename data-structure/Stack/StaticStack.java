package stack;
public class StaticStack {
	private int top;
	private Object stack[];
	public StaticStack(int capacity) {
		stack = new Object[capacity];
		top = 0;		
	}
	public void push(Object o) {
		if(isFull() == false) {
			System.out.println("Adding element to stack...");
			stack[top] = o;
			top = top + 1;
		} else {
			System.out.println("No exist spaces for new elements, the stack has reached its capacity!");
		}
	}
	public Object pop() {
		if(isEmpty() == false) {
			System.out.println("Removing element from stack...");
			top = top - 1;
			if(top == 0) {
				System.out.println("The stack is empty!");
			}
			return stack[top];
		} else {
			return null;
		}
	}
	public void clear() {
		while(isEmpty() == false){
			pop();
		}
	}
	public boolean isFull() {
		if(top == stack.length){
			return true;
		} else {
			return false;
		}   
		
	}
	public boolean isEmpty() {
		if(top == 0){
			return true;
		} else {
			return false;
		}
	}
}
