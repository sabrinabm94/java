package deque;

public class Main {
	public static void main(String[] args) throws Exception { 
		Deque deque = new Deque(); 

		do{			
			System.out.println("Select the option\n 1->Add first:\n 2->Add last:\n3->List:\n 4->Remove first:\n 5->Remove last:\n 6->Clear:\n 7->Exit:\n");		
			option = scanner.next();			
			if(option == 1){
				System.out.println("Enter with the value: ");
				value = scanner.next();
				deque.addFirst(value);
			}				
			else if(option == 2){
				System.out.println("Enter with the value: ");
				value = scanner.next();
				deque.addLast(value);		
			}					
			else if(option == 3){
				ArrayList<String> myList = new ArrayList<String>();
				try {
					myList = deque.List();
					//deque.listing();
				} 
				catch (EmptyListException e) {
					e.printStackTrace();					
				}
			}
			else if(option == 4){
				deque.removeFirst();		
			}
			else if(option == 5){
				deque.removeLast();	
			}
			else if(option == 6){
				deque.clear();
			}
			else {
				System.out.println("Invalid option");
			}
		}
		while(option != "7");
	}
}
