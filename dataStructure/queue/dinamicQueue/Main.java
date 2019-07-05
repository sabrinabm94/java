package queue.dinamicQueue;

public class Main {
	public static void main(String[] args) throws Exception { //concentrar os exceptions
		Queue queue = new Queue();
		queue.isFull();
		queue.add(1);
		queue.add(2);
		queue.add(3);
		queue.isEmpty();
		queue.remove();
		queue.list();
		queue.clear();
		queue.list();
	}
}
