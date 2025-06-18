package trees.tree;

import stack.Node;
import javaRepositories.Print;

public class Stack {
	Node top = null;
	int lenght = 0;
	public Stack() {
		Print.print("Queue Stack was created!");
	}

	public void push(Object value) {
		Node newNode = new Node();
		newNode.setValue(value);
		newNode.setPrevious(top);
		top = newNode;
		lenght++;
		Print.print("Additing value " + value);
	
	}

	public Object pop() {
		if(isEmpty() == false) {
			if(top == null) {
				throw new RuntimeException("The stack is empty!");
			}

			Object value = top.getValue();
			top = top.getPrevious();
			lenght--;

			Print.print("Removing value: " + value);
			return value;
		} else {
			return null;
		}
	}

	public void runThrough(){
		Node node = top;
		while(node != null){
			Print.print("Value of node: " + node.getValue());
			node = node.getPrevious();
		}
	}

	public boolean isEmpty() {
		if(top == null){
			return true;
		} else {
			return false;
		}
	}

	public void clear() {
		Print.print("Starting stack clean...");
		while(isEmpty() == false){
			pop();
		}
		if(isEmpty() != false) {
			Print.print("The stack is empty.");
		}
	}
}