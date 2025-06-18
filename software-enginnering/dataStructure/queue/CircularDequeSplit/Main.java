package dataStructure.queue.CircularDequeSplit;

import dataStructure.queue.Deque;
import javaRepositories.Print;

public class Main {
	 public static void main(String[] args) {
	 	Deque<Integer> d1 = new Deque<Integer>();
	 	Deque<Integer> d2 = new Deque<Integer>();
	 	Deque<Integer> d3 = new Deque<Integer>();

		d1.addFirst(1);
		d1.addFirst(2);
		d1.addFirst(3);
		d2.addFirst(4);
		d2.addFirst(5);
		d3.addLast(6);

		d1.listing((e)-> Print.println(e + ""));
		//d1.split(3, d1, d2, d3);

		Print.println("\nListing d1");
		d1.listing((e)-> Print.println(e + ""));

		Print.println("\nListing d2");
		d2.listing((e)-> Print.println(e + ""));

		Print.println("\nListing d3");
		d3.listing((e)-> Print.println(e + ""));
	 }
}
