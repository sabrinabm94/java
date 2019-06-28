public class InverseStackMain {
	private int top;
	private Object stack[];
	public InverseStackMain(int capacity){
		System.out.println("The stack was created!");
		stack = new Object[capacity];
		top = 0;		
	}
	public void push(Object o) {
		if(isFull() == false) {
			System.out.println("Added element " + o + " in stack...");
			stack[top] = o;
			top = top + 1;
			System.out.println("The top is " + top);
		} else {
			System.out.println("The stack is full!");
		}
	}
	public Object pop() {
		if(isEmpty() == false) {
			top = top - 1;
			if(top == 0) {
				System.out.println("The stack is empty!");
			}
			System.out.println("Removing the last element of stack...");
			System.out.println("The top is " + top);
			return stack[top];
		} else {
			return null;
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
	public void clear() {
		while(isEmpty() == false){
			pop();
		}
	}
	public void list() {
		
	}
}
