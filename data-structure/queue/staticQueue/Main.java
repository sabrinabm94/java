package fila;

public class Main {
	public static void main(String[] args) {
		Queue queue = new Queue(6); //instance the stack
		queue.add(20.0); //add items in stack
		queue.add(20.8);
		queue.add(20.3);
		queue.add(44.5);
		queue.add(33.33);
		queue.add(20.9);
		queue.list();
		queue.remove();
		queue.remove();
		queue.list();
		queue.clear(); //remove one per one items in stack
	}
}
