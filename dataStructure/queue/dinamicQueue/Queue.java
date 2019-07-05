package queue.dinamicQueue;

import queue.Element;
import javaRepositories.Print;

public class Queue {
	private Element head;
	private Element tail;

	public Queue() {
		head = tail = null;
	}
	public boolean isEmpty() {
		return head == null && tail == null;
	}
	public boolean isFull() {
		return false;
	}
	public void add(Object value) throws Exception {
		Element e = new Element(value);
		Print.print(("Addited: " + value);

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

		Print.print(("Removed: " + o);
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
			Print.print("Value: " + e.getValue());
			e = e.getNext();
		}
	}
}
