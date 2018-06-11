import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
public class Main {	
	public static void main(String[] args) throws Exception {		
		Scanner scanner = new Scanner(System.in);		
		Queue queue = new Queue();		
		String value = null;
		String respost = null;		
		do{			
			System.out.println("Select the option\n 1->Insert First:\n 2->Insert Last:\n3->List:\n 4->Remove first:\n 5->Remove last:\n 6->Clear:\n 7->Listing:\n 8->Exit:\n");		
			respost = scanner.next();			
			if(respost.equals("1")){
				System.out.println("Enter with the value: ");
				value = scanner.next();
				queue.addFirst(value);
			}				
			else if(respost.equals("2")){
				System.out.println("Enter with the value: ");
				value = scanner.next();
				queue.addLast(value);		
			}					
			else if(respost.equals("3")){
				ArrayList<String> myList = new ArrayList<String>();
				try {
					myList = queue.List();
				} 
				catch (EmptyListException e) {
					e.printStackTrace();					
				}
				
				for(String element : myList){
					System.out.print(element + " ");
				}
				System.out.println();
			}
			else if(respost.equals("4")){
				queue.removeFirst();		
			}
			else if(respost.equals("5")){
				queue.removeLast();	
			}
			else if(respost.equals("6")){
				queue.clear();
			}
			else if(respost.equals("7")){
				queue.listing();		
			}
			else {
				System.out.println("Invalid option");
			}
		}
		while(respost != "8");		
	}

}
