package atividade5;
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
        if (head != null) {
            head.setPrev(e); 
        }
        e.setNext(head);
        head = e;
        if (tail == null) {
            tail = head;
        }
        tail.setNext(head);
        head.setPrev(tail);
        System.out.println("New head: " + head.getValue());
        System.out.println("New tail: " + tail.getValue());
    }
    public void addLast(T o) {
    	System.out.println("");
        System.out.println("Addited in last: " + o);
        Element<T> e = new Element<T>(o);
        if (tail != null) {
        	tail.setNext(e);
        }
        e.setPrev(tail);
        tail = e; 
        if(head == null) {
        	head = tail;
        }
        tail.setNext(head);
        head.setPrev(tail);
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
            if(e == head) {
            	break;
            }
        }
        System.out.println("End listing");
        System.out.println("");
    }
    public void split(T lambda, Deque d1, Deque d2) {
    	Element<T> e = head;
        System.out.println("");
        System.out.println("Searching for " + lambda);
        while (e != null) {
        	if(e.getValue().equals(lambda)) { //se o elemento da lista for igual ao elemento passado como parametro
        		System.out.println("Found!");
        		Element<T> el = head; 
        		while(el != e) { 
        			d1.addLast(el.getValue()); //adiciona no d1 os valores próximos do elemento
        			el = el.getNext();
        		}
        		
        		d1.addLast(e.getValue());
        		el = e.getNext(); 
        		
        		while(el != null) {
        			d2.addLast(el.getValue());
        			el = el.getNext();
        			if(el == head) {
        				break;
        			}
        		}
        		
        		break;
        	}
        	
        	e = e.getNext();
        }
        System.out.println("New deques create");
        System.out.println("");
    }
    
}
