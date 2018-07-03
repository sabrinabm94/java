package atividade4;
public class StaticStack {
	private int top;
	private int capacity;
	private Object stack[];
	public StaticStack(int capacity){
		System.out.println("Static Stack was created.");
		stack = new Object[capacity];
		top = 0;		
	}
	public void push(Object o) {
		if(isFull() == false) {
			stack[top] = o;
			top = top + 1;
			System.out.println("Added element " + o + " to stack in the position " + top);
			System.out.println("The top value now is: " + top);
		} else {
			System.out.println("The stack is full!");
		}
	}
	public Object pop() {
		if(isEmpty() == false) {
			top = top - 1;
			if(top == 0) {
				System.out.println("The stack is empty!");
			} else {
				System.out.println("Removed element " + stack[top] + " from stack in the position " + top);
			}
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
	public void list() {
		System.out.println("Starting listing... ");
		for (int i = top - 1; i >= 0; i--) {
			System.out.println("Value in " + i + " " + stack[i]);
		}
		System.out.println("Endend.\n");
	}
	public void clear() {
		System.out.println("");
		while(isEmpty() == false) {
			System.out.println(stack[top]);
			pop();
		}
		System.out.println("The stack is clean!");
	}
}
