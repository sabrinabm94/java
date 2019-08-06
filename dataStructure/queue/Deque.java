package dataStructure.queue;

import javaRepositories.Print;

public class Deque {
    private ElementGenerics<T> head;
    private ElementGenerics<T> tail;

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
        Print.print("Added in first: " + o);
        DequeCircularElement<T> e = new DequeCircularElement<T>(o);
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
        Print.print("New head: " + head.getValue());
        Print.print("New tail: " + tail.getValue());
    }

    public void addLast(T o) {
        Print.print("Added in last: " + o);
        DequeCircularElement<T> e = new DequeCircularElement<T>(o);
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
        Print.print("New head: " + head.getValue());
        Print.print("New tail: " + tail.getValue());
    }

    public T removeFirst() throws EmptyListException {
        if (this.isEmpty()) {
            throw new EmptyListException("The deque is empty!");
        } else {
            T o = head.getValue();
            head = head.getNext();
            if (head == null) {
                tail = null;
            } else {
                head.setPrev(null);
            }
            Print.print("\nRemoved in first: " + o);
            Print.print("New head: " + head.getValue());
            Print.print("New tail: " + tail.getValue());
            return o;
            //evitar o loop remove do circular
        }
    }

    public T removeLast() throws EmptyListException {
        if (this.isEmpty()) {
            throw new EmptyListException("The deque is empty!");
        } else {
            T o = tail.getValue();
            tail = tail.getPrev();
            if (tail == null) {
                head = null;
            } else {
                tail.setNext(null);
            }
            Print.print("");
            Print.print("Removed in last: " + o);
            Print.print("New head: " + head.getValue());
            Print.print("New tail: " + tail.getValue());
            return o;
            //evitar o loop remove do circular
        }
    }

    public void remove(T value) throws Exception {
        DequeCircularElement<T> element = head;
        while (element != null) {
            if (element.getValue().equals(value)) {
                if (element == head) {
                    this.remove(value);
                } else if (element == tail) {
                    this.removeLast();
                } else {
                    DequeCircularElement<T> prev = element.getPrev();
                    DequeCircularElement<T> next  = element.getNext();
                    prev.setNext(next);
                    next.setPrev(prev);
                }
                return;
            }
            element = element.getNext();
        }
        throw new Exception("value not found!");
    }

    public void clear() {
        while (!this.isEmpty()) {
            try {
                this.removeFirst();
            } catch (EmptyListException e) {
                e.printStackTrace();
            }
        }
        Print.print("The deque is clean!");
    }

    public void listing(Consumer<T> lambda) {
        DequeCircularElement<T> e = head;
        Print.print("Starting listing... ");
        while (e != null) {
            lambda.accept(e.getValue());
            e = e.getNext();
            if(e == head) {
                break;
            }
        }
        Print.print("Endend.\n");
    }

    public void split(T lambda, Deque<?> d1, Deque<T> d2, Deque<T> d3) {
        Deque<T> e = head;
        Print.print("Searching for " + lambda);

        while (e != null) {
            if(e.getValue().equals(lambda)) { //se o elemento da lista for igual ao elemento passado como parametro
                System.out.println("Found!\n");
                ElementGenerics<T> el = head;
                while(el != e) {
                    d3.addLast(el.getValue()); //adiciona no d1 os valores pr�ximos do elemento
                    el = el.getNext();
                }
                d2.addLast(e.getValue());
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

        Print.print("Endend.");
        Print.print("New deques with splited elements created\n");
    }
}
