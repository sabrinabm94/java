public class DequeRemoveMain {
     public static void main(String[] args) { 
        DequeRemove<Integer> dequeRemove = new DequeRemove<Integer>();
        dequeRemove.addFirst(1);
        dequeRemove.addFirst(2);
        dequeRemove.addFirst(3);
        dequeRemove.addFirst(4);
        dequeRemove.addFirst(5);
        dequeRemove.addLast(6);
         try {
             dequeRemove.remove(2);
         } catch (Exception e) {
             e.printStackTrace();
         }
     }
}
