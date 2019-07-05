package queue.CircularDequeSplit;

import queue.Deque;
import javaRepositories.Print;

public class Main {
	 public static void main(String[] args) {
	 	Deque<Integer> d1 = new Deque<Integer>();
	 	Deque<Integer> d2 = new Deque<Integer>();
	 	Deque<Integer> d3 = new Deque<Integer>();

		d1.addFirst(1);
		d1.addFirst(2);
		d1.addFirst(3);
		d1.addFirst(4);
		d1.addFirst(5);
		d1.addLast(6);

		d1.listing((e)-> System.out.println(e));
		//d1.split(3, d1, d2, d3);

		Print.print("Listing d1");
		d1.listing((e)-> System.out.println(e));

		Print.print("Listing d2");
		d2.listing((e)-> System.out.println(e));

		Print.print("Listing d3");
		d3.listing((e)-> System.out.println(e));
	 }
}
