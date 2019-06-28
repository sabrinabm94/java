package tree;
import java.util.EmptyStackException;

public class DinamicStack {
	Node2 top = null;
	int lenght = 0;
	public DinamicStack() {
		System.out.println("Dinamic Stack was created!");
	}
	public void push(Object value) {
		Node2 newNode = new Node2();
		newNode.setValue(value);
		newNode.setPrevious(top);
		top = newNode;
		lenght++;
		System.out.println("Additing value " + value);
	
	}
	public Object pop() {
		if(isEmpty() == false) {
			if(top == null) {
				throw new RuntimeException("The stack is empty!");
			}
			Object value = top.getValue();
			top = top.getPrevious();
			lenght--;
			System.out.println("Removing value: " + value);
			return value;
		} else {
			return null;
		}
	}
	public void runThrough(){ 
		Node2 node = top;
		while(node != null){
			System.out.println("Value of node: " + node.getValue());
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
		System.out.println("Starting stack clean...");
		while(isEmpty() == false){
			pop();
		}
		if(isEmpty() != false) {
			System.out.println("The stack is empty.");
		}
	}
}