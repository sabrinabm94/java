package dataStructure.queue.staticQueue;

import javaRepositories.Print;

public class Queue {
	private int head;
	private int tail;
	private Object queue[];

	public Queue(int capacity) {
		queue = new Object[capacity];
		head = tail = -1; //fora do intervalo de �ndices
	}

	//cabe�a e cauda igual indica somente um elemento na fila
	public void add(Object o) {
		if(!this.isFull()) {
			tail = (tail + 1) % queue.length; //incremento circular
			queue[tail] = o; //adiciona valor na fila
			if(head == -1) {
				head = tail; //para a primeira adi��o da fila, pois a cauda andou um, e a cabe�a continuo fora dos �ndices da fila, assim a gente deixa a cabe�a como o primeiro indice da lista, que atualmente � a cauda, e a cauda continua andando e a cabe�a n�o ser� mais mexida, continuar� na primeira posi��o.
			}
		}
	}

	public Object remove() {
		if(!isEmpty()) {
			Object o = queue[head];
			if(head == tail) { //tratamento para filas com somente um elemento que ser� removido e a fila ficar� vazia
				head = tail = -1; //retorna para fora do �ndice
			} else {
				head = (head + 1) % queue.length; //incremento normal
			}
			Print.println("Removing the element: " + o);
			return o;
		} else {
			return null;
		}
	}

	public void list() {
		if(!this.isEmpty()) {
			int i = head;
			for(i = head; i!= tail; i = (i+1) % queue.length) {
				Print.println("Value " + queue[i]);
			}
			Print.println("Value " + queue[i]);
		}
	}

	public boolean isFull() { //se o proximo elemento em rela��o a cabe�a for cauda
		if((tail + 1) % queue.length == head) {
			return true;
		} else {
			return false;
		}   
	}

	public boolean isEmpty() { 
		if(head == -1 && tail == -1) { //se a cabe�a e a cauda tiverem o valor de -1, est� vazio
			return true;
		} else {
			return false;
		}
	}

	public void clear() {
		while(!isEmpty()) { //se a cabe�a e a cauda tiverem o valor de -1, est� vazio
			remove();
		}
	}
}
