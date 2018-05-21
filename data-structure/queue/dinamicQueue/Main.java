package fila;

public class Main {
	public static void main(String[] args) throws Exception { //concentrar os exceptions
		DinamicQueue dinamicQueue = new DinamicQueue();
		dinamicQueue.isFull();
		dinamicQueue.add(1);
		dinamicQueue.add(2);
		dinamicQueue.add(3);
		dinamicQueue.isEmpty();
		dinamicQueue.remove();
		dinamicQueue.list();
		dinamicQueue.clear();
		dinamicQueue.list();
	}
}
