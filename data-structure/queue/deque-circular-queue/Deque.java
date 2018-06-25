import java.util.function.Consumer;

public class Deque<T> {
    private Element<T> head;
    private Element<T> tail;
	public Deque() {
		head = tail = null;
	}
	public boolean isEmpty() {
		return head == null && tail == null;
	}
	public boolean isFull() {
		return false;
	}
	public void addFirst(T o) {
		System.out.println("");
        System.out.println("Addited in first: " + o);
        Element<T> e = new Element<T>(o);
        e.setNext(head); 

        if (head != null) {
            head.setPrev(e);  
        }
        head = e; 
        if (tail == null) {
            tail = e; 
        }
        System.out.println("New head: " + head.getValue());
        System.out.println("New tail: " + tail.getValue());
    }
    public void addLast(T o) {
    	System.out.println("");
        System.out.println("Addited in last: " + o);
        Element<T> e = new Element<T>(o);
        e.setPrev(tail); 

        if (tail != null) {
            tail.setNext(e);
        }
        tail = e;
        if (head == null) {
            head = e;
        }
        System.out.println("New head: " + head.getValue());
        System.out.println("New tail: " + tail.getValue());
    }
	public T removeFirst() throws EmptyListException {
        if (this.isEmpty()) {
            throw new EmptyListException("The deque is empty!");
        }
        T o = head.getValue();
        head = head.getNext(); 
        if (head == null) { 
            tail = null;
        } else {
            head.setPrev(null); 
        }
        System.out.println("");
        System.out.println("Removed in first: " + o);
        System.out.println("New head: " + head.getValue());
        System.out.println("New tail: " + tail.getValue());
        return o;
    }
    public T removeLast() throws EmptyListException {
        if (this.isEmpty()) {
            throw new EmptyListException("The deque is empty!");
        }
        T o = tail.getValue();
        tail = tail.getPrev(); 
        if (tail == null) {
            head = null;
        } else {
            tail.setNext(null); 
        }
        System.out.println("");
        System.out.println("Removed in last: " + o);
        System.out.println("New head: " + head.getValue());
        System.out.println("New tail: " + tail.getValue());
        return o;
    }
    public void clear() {
        System.out.println("");
        System.out.println("Start clear... ");
        while (!this.isEmpty()) {
            try {
				this.removeFirst();
			} catch (EmptyListException e) {
				e.printStackTrace();
			}
        }
        System.out.println("End clear");
        System.out.println("");
    }
    public void listing(Consumer<T> lambda) {
        Element<T> e = head;
        System.out.println("");
        System.out.println("Start listing... ");
        while (e != null) {
            lambda.accept(e.getValue());
            e = e.getNext();
        }
        System.out.println("End listing");
        System.out.println("");
    }
}
