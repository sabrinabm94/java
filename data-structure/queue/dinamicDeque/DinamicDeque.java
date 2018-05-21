package deque;

public class DinamicDeque {
	private Element head;
	private Element tail; 
	public DinamicDeque() {
		head = tail = null;
	}
	public boolean isEmpty() {
		return head == null && tail == null;
	}
	public boolean isFull() {
		return false;
	}
	public void addLast(Object o) throws Exception {
		System.out.println("Addited: " + o);
		Element e = new Element(o);
		e.setPrev(tail); //vou adicionar depois da atual cauda, se tornando a nova cauda.
		
		if(tail != null) {
			tail.setNext(e);
		}
		tail = e;
		if(head == null) {
			head = e;
		}
	}
	public void addFirst(Object o) {
		System.out.println("Addited: " + o);
		Element e = new Element(o);
		e.setNext(head); //adicionar antes da atual cabeça, se tornando a nova cabeça.
		
		if(head != null) {
			head.setPrev(e); //mudo o ponteiro do anterior 
		}
		head = e; //atualizo a cabeça com o novo elemento
		if(tail == null) {
			tail = e; //quando a fila estiver vazia, a cauda e cabeça estão null, assim garante que tenham o mesmo valor.
		}
	}
	public Object removeFirst() throws Exception {
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
	public Object removeLast() throws Exception {
		if(this.isEmpty()) {
			throw new Exception ("The Queue is empty!");
		}
		Object o = tail.getValue();
		tail = tail.getNext();
		if(tail == null) {
			head = null;
		}
		System.out.println("Removed: " + o);
		return o;
	}
	public void clear() {
		while (!this.isEmpty()) {
			try {
				this.removeFirst();
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
