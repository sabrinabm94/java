import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
public class Test {	
	public static void main(String[] args) {		
		Scanner scanner = new Scanner(System.in);		
		List list = new List();		
		String value = null;
		String respost = null;		
		do{			
			System.out.println("Select the option\n
				1->Insert First:\n
				2->Insert Last:\n
				3->List:\n
				4->Remove first:\n
				5->Remove last:\n
				6->Clear:\n
				7->Listing:\n
				8->Exit:\n"
			);		
			respost = scanner.next();			
			if(respost.equals("1")){
				System.out.println("Enter with the value: ");
				value = scanner.next();
				try {
					list.addFirst(value);
				} 
				catch (ExistentValueException e) {					
					e.printStackTrace();
				}
			}				
			else if(respost.equals("2")){
				System.out.println("Enter with the value: ");
				value = scanner.next();
				try {
					list.addLast(value);
				} 
				catch (ExistentValueException e) {					
					e.printStackTrace();
				}			
			}					
			else if(respost.equals("3")){
				ArrayList<String> myList = new ArrayList<String>();
				try {
					myList = list.myList();
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
				list.removeFirst();		
			}
			else if(respost.equals("5")){
				list.removeLast();	
			}
			else if(respost.equals("6")){
				list.clear();
			}
			else if(respost.equals("7")){
				list.listing();		
			}
			else {
				System.out.println("Invalid option");
			}
		}
		while(respost != "8");		
	}

}
