//package bookRegistry;

import java.util.ArrayList;

public class View {
	public void showClientData(Client client) { //mostrar informa��es de um cliente espec�fico
		System.out.println("Name : " + client.getName());
		System.out.println("User : " + client.getUser());
		System.out.println("Description : " + client.getDescription());
		System.out.println("                    "); 
	}
	
	public void showBookData(Book book) { //mostrar informa��o de um livro espec�fico
		System.out.println("Name : " + book.getName());
		System.out.println("Author : " + book.getAuthor());
		System.out.println("Year : " + book.getYear());
		System.out.println("Description : " + book.getDescription());
		System.out.println("Stars Ranking : " + book.getStartsRanking());
		System.out.println("                    "); 
	}
	
	public void showListData(Collection collection) { //mostrar informa��o de uma lista espec�fica
		System.out.println("Name : " + collection.getName());
		System.out.println("Description : " + collection.getDescription());
		System.out.println("                    "); 
	}
	
	public void showAllBooksData(ArrayList <Book> books) { //listar todos os livros cadastrados
		for(int i = 0; i < books.size(); i++){
			System.out.println("Book number: " + i);
			System.out.println("Name : " + books.get(i).getName());
			System.out.println("Author : " + books.get(i).getAuthor());
			System.out.println("Year : " + books.get(i).getYear());
			System.out.println("Description : " + books.get(i).getDescription());
			System.out.println("Stars Ranking : " + books.get(i).getStartsRanking());
			System.out.println("                    "); 
		} 
	}
	
	public void showAllListsData(ArrayList <Collection> collections) { //listar todas as listas cadastradas
		for(int i = 0; i < collections.size(); i++){
			System.out.println("Collection number: " + i);
			System.out.println("Name : " + collections.get(i).getName());
			System.out.println("Description : " + collections.get(i).getDescription());
			System.out.println("                    "); 
		} 
	}
	
	public void showBooksOnList(ArrayList <Collection> collections) { //listar os livros por lista: lista[0/1]> book[0/n]		
		for(Collection c: collections){
			System.out.println("Collection number: ");
			System.out.println("Name : " + c.getName());
			System.out.println("Description : " + c.getDescription());
			
			for(Book b: c.getBooks()){
				System.out.println("Book number: ");
				System.out.println("Name : " +b.getName());
				System.out.println("Author : " + b.getAuthor());
				System.out.println("Year : " + b.getYear());
				System.out.println("Description : " + b.getDescription());
				System.out.println("Stars Ranking : " + b.getStartsRanking());
				System.out.println("                    "); 
			}
		}
	} 
}
