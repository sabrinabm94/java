import java.util.ArrayList;
public class Deque {
	private Element head;
	private Element tail; 
	public Deque() {
		head = tail = null;
	}
	public boolean isEmpty() {
		return head == null && tail == null;
	}
	public boolean isFull() {
		return false;
	}
	public ArrayList<Integer> List() throws EmptyListException { //generics and exception
		ArrayList<Integer> list = new ArrayList<Integer>();		
		if(head == null)
			throw new EmptyListException("The list is empty!");		
		else{
			Element elementFirst = getFirst();			
			while(elementFirst != null){
				int value = elementFirst.getValue(); 
				list.add(value);
				elementFirst = elementFirst.getNext();
			}
			return list;
		}		
	}
	public void addFirst(Object o) {
		System.out.println("Addited in first: " + o);
		Element e = new Element(o);
		e.setNext(head); 
		
		if(head != null) {
			head.setPrev(e);  
		}
		head = e; 
		if(tail == null) {
			tail = e; 
		}
	}
	public void addLast(Object o) throws Exception {
		System.out.println("Addited in last: " + o);
		Element e = new Element(o);
		e.setPrev(tail); 
		
		if(tail != null) {
			tail.setNext(e);
		}
		tail = e;
		if(head == null) {
			head = e;
		}
	}
	public Object removeFirst() throws Exception {
		if(this.isEmpty()) {
			throw new Exception ("The Queue is empty!");
		} else {
			Object o = head.getValue();
			head = head.getNext(); 
			if(head == null) { 
				tail = null;
			} else {
				head.setPrev(null); 
			}
			System.out.println("Removed in first: " + o);
			System.out.println("New head: " + head.getValue());
			return o;
		}
	}
	public Object removeLast() throws Exception {
		if(this.isEmpty()) {
			throw new Exception ("The Queue is empty!");
		} else {
			Object o = tail.getValue();
			tail = tail.getPrev(); 
			if(tail == null) {
				head = null;
			} else {
				tail.setNext(null); 
			}
			System.out.println("Removed in last: " + o);
			System.out.println("New tail: " + tail.getValue());
			return o;
		}
	}
	public void clear() {
		System.out.println("");
		System.out.println("Start clear... ");
		while (!this.isEmpty()) {
			try {
				this.removeFirst();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		System.out.println("End clear");
		System.out.println("");
	}
	public void listing() {
		Element e = head;
		System.out.println("");
		System.out.println("Start listing... ");
		while (e != null) {
			System.out.println("Value: " + e.getValue());
			e = e.getNext();
		}
		System.out.println("End listing");
		System.out.println("");
	}
}
