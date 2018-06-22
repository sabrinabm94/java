package trabalho;
public class TestDeque {
	 public static void main(String[] args) { 
		 Deque<String> deque = new Deque<String>(); 
		 //declaração do tipo para filtar as entradas e evitar a necessitade de excessivas tratativas de erros
		 deque.addFirst("zero");
		 deque.addFirst("first");
		 deque.addFirst("secound");
		 deque.addFirst("third");
		 deque.addLast("fifth");
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
