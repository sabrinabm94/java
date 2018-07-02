package atividade6;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) { 
        Deque<Integer> deque = new Deque<>();
        deque.addFirst(1); 
        deque.addFirst(2); 
        deque.listing(deque.listing((e)-> System.out.println(e)));
        deque.removeFirst();
        deque.listing(deque.listing((e)-> System.out.println(e)));
    }
}