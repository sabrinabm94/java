package dataStructure.queue.DequeRemovePerIndice;

import dataStructure.queue.Deque;

public class Main {
     public static void main(String[] args) { 
        Deque<Integer> deque = new Deque<Integer>();
         deque.addFirst(1);
         deque.addFirst(2);
         deque.addFirst(3);
         deque.addFirst(4);
         deque.addFirst(5);
         deque.addLast(6);

         try {
             deque.remove(2);
         } catch (Exception e) {
             e.printStackTrace();
         }
     }
}
