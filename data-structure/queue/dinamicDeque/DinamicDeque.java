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
		System.out.println("Addited in last: " + o);
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
		System.out.println("Addited in first: " + o);
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
		} else {
			Object o = head.getValue();
			head = head.getNext(); //a cabeça foi removida, a nova cabeça será o elemento que era o próximo dela, no caso o 2.
			if(head == null) { //se houver somente um elemento na fila
				tail = null;
			} else {
				head.setPrev(null); //se houver mais de um elemento na fila, o anterior dele se tornará null, pois a cabeça é o primeiro
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
			tail = tail.getPrev(); //a cauda foi removida, a nova cauda será o antigo elemento anterior a cauda, no caso o 3.
			if(tail == null) { //se houver somente um elemento na fila
				head = null;
			} else {
				tail.setNext(null); //se houver mais de um elemento na fila, o próximo dele se tornará null, pois a cauda é o último
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
	public void list() {
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
