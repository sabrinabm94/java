package fila;

public class DinamicQueue {
	private Element head;
	private Element tail; //elementos encadeados
	public DinamicQueue() {
		head = tail = null;
	}
	public boolean isEmpty() {
		return head == null && tail == null;
	}
	public boolean isFull() {
		return false;
	}
	public void add(Object value) throws Exception {
		Element o = new Element(value);
		System.out.println("Addited: " + value);
		Element e = new Element(value);
		if(tail != null) {
			tail.setNext(e);
		}
		tail = e;
		if(head == null) {
			head = e;
		}
	}
	public Object remove() throws Exception {
		if(this.isEmpty()) {
			throw new Exception ("The Queue is empty!");
		}
		Object o = head.getValue();
		head = head.getNext();
		if(head == null) {
			tail = null;
		}
		System.out.println("Removed: " + o);
		return o;
	}
	public void clear() {
		while (!this.isEmpty()) {
			try {
				this.remove();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	public void list() {
		Element e = head;
		while (e != null) {
			System.out.println("Value: " + e.getValue());
			e = e.getNext();
		}
	}
}
