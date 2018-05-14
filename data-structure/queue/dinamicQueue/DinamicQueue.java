package fila;

public class DinamicQueue {
	private Element head;
	private Element tail; //elementos encadeados
	public DinamicQueue() {
		head = tail = null;
		int length = 0;
	}
	public void add(Object value) {
		Element element = new Element();
		element.setValue(value);
		element.setNext(tail);
		head = element;
		lenght++;
		System.out.println("Additing value " + value);
		if(!this.isFull()) {
			tail = (tail + 1) % queue.length; 
			queue[tail] = o; 
			if(head == null) {
				head = tail; 
			}
		}
	}
	public Object remove() {
		if(!isEmpty()) {
			Object o = head;
			if(head == tail) { 
				head = tail = null;
			} else {
				head = (head + 1) % queue.length; 
			}
			System.out.println("Removing the element: " + o);
			return o;
		} else {
			return null;
		}
	}
	public void runThrough(){ 
		Element element = head;
		while(element != null){
			System.out.println("Value of node: " + element.getValue());
			element = element.getNext();
		}
	}
	public void list() {
		if(!this.isEmpty()) {
			int i = head;
			for(i = head; i!= tail; i = (i+1) % queue.length) {
				System.out.println("Value " + queue[i]);
			}
			System.out.println("Value " + queue[i]);
		}
	}
	public boolean isFull() { 
		if((tail + 1) % queue.length == head) {
			return true;
		} else {
			return false;
		}   
	}
	public boolean isEmpty() { 
		if(head == null && tail == null) { 
			return true;
		} else {
			return false;
		}
	}
	public void clear() {
		while(!isEmpty()) { 
			remove();
		}
	}
}
