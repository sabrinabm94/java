import java.util.ArrayList;
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
	public ArrayList<String> List() throws EmptyListException { //generics
		ArrayList<String> list = new ArrayList<String>();		
		if(first == null)
			throw new EmptyListException("The queue is empty!");		
		else{
			Element aux = getFirst();			
			while(aux != null){
				String vl = aux.getValue(); 
				list.add(vl);
				aux = aux.getNext();
			}
			return list;
		}		
	}
	public void addFirst(String o) throws Exception {		
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
	public void addLast(String value) throws Exception {
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
		while (!this.isEmpty()) { //callback
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
		System.out.println("Start list... ");
		while (e != null) {
			System.out.println("Value: " + e.getValue());
			e = e.getNext();
		}
		System.out.println("End list");
		System.out.println("");
	}
}
