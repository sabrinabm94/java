package deque;

public class Main {
	public static void main(String[] args) throws Exception { //concentrar os exceptions
		DinamicDeque deque = new DinamicDeque(); 
		deque.addFirst(3); 
		deque.addFirst(2);
		deque.addFirst(1);
		deque.addLast(4);
		
		deque.list();
		deque.removeFirst(); //remove 1
		deque.removeLast(); //remove 4
		deque.list();
		deque.clear();
	}
}
