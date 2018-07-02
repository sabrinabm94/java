package atividade6;
public class TestDeque {
	 public static void main(String[] args) { 
		 Deque<Integer> deque = new Deque<Integer>(); 
		 //declaração do tipo para filtar as entradas e evitar a necessitade de excessivas tratativas de erros
		 deque.addFirst(1);
		 deque.addFirst(2);
		 deque.addFirst(3);
		 deque.addFirst(4);
		 deque.addLast(5);
		 try {
			deque.removeLast();
		} catch (EmptyListException e) {
			e.printStackTrace();
		}
		 try {
			deque.removeFirst();
		} catch (EmptyListException e) {
			e.printStackTrace();
		}
	 }
}
