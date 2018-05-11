package fila;

public class Queue {
	private int inicio;
	private int fim;
	private int head;
	private int tail;
	private Object queue[];
	public Queue(int capacity) {
		queue = new Object[capacity];
		head = tail = -1; //fora do intervalo de índices
	}
	//cabeça e cauda igual indica somente um elemento na fila
	public void add(Object o) {
		if(!this.isFull()) {
			tail = (tail + 1) % queue.length; //incremento circular
			queue[tail] = o; //adiciona valor na fila
			if(head == -1) {
				head = tail; //para a primeira adição da fila, pois a cauda andou um, e a cabeça continuo fora dos índices da fila, assim a gente deixa a cabeça como o primeiro indice da lista, que atualmente é a cauda, e a cauda continua andando e a cabeça não será mais mexida, continuará na primeira posição.
			}
		}
	}
	public Object remove() {
		if(!isEmpty()) {
			Object o = queue[head];
			if(head == tail) { //tratamento para filas com somente um elemento que será removido e a fila ficará vazia
				head = tail = -1; //retorna para fora do índice
			} else {
				head = (head + 1) % queue.length; //incremento normal
			}
			System.out.println("Removing the element: " + o);
			return o;
		} else {
			return null;
		}
	}
	public void show() {
		if(!this.isEmpty()) {
			int i = head;
			for(i = head; i!= tail; i = (i+1) % queue.length) {
				System.out.println("Value " + queue[i]);
			}
			System.out.println("Value " + queue[i]);
		}
	}
	public boolean isFull() { //se o proximo elemento em relação a cabeça for cauda
		if((tail + 1) % queue.length == head) {
			return true;
		} else {
			return false;
		}   
	}
	public boolean isEmpty() { 
		if(head == -1 && tail == -1) { //se a cabeça e a cauda tiverem o valor de -1, está vazio
			return true;
		} else {
			return false;
		}
	}
	public void clear() {
		while(!isEmpty()) { //se a cabeça e a cauda tiverem o valor de -1, está vazio
			remove();
		}
	}
}
