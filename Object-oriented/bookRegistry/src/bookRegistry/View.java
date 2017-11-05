package bookRegistry;

import java.util.ArrayList;

public class View {
	public void showClientData(Client client) { //mostrar informações de um cliente específico
		System.out.println("Name : " + client.getName());
		System.out.println("User : " + client.getUser());
		System.out.println("Description : " + client.getDescription());
		System.out.println("                    "); 
	}
	
	public void showBookData(Book book) { //mostrar informação de um livro específico
		System.out.println("Name : " + book.getName());
		System.out.println("Author : " + book.getAuthor());
		System.out.println("Year : " + book.getYear());
		System.out.println("Description : " + book.getDescription());
		System.out.println("Stars Ranking : " + book.getStartsRanking());
		System.out.println("                    "); 
	}
	
	public void showListData(List list) { //mostrar informação de uma lista específica
		System.out.println("Name : " + list.getName());
		System.out.println("Description : " + list.getDescription());
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
	
	public void showAllListsData(ArrayList <List> lists) { //listar todas as listas cadastradas
		for(int i = 0; i < lists.size(); i++){
			System.out.println("List number: " + i);
			System.out.println("Name : " + lists.get(i).getName());
			System.out.println("Description : " + lists.get(i).getDescription());
			System.out.println("                    "); 
		} 
	}
	
	public void showBooksOnList(List list) { //rodará a lista de livros lidos ou wishlist e mostrará todos os livros cadastrados
		for(int i = 0; i < list.size(); i++){
			System.out.println("Book number: " + i);
			System.out.println("Name : " + list.get(i).getName());
			System.out.println("Author : " + list.get(i).getAuthor());
			System.out.println("Year : " + list.get(i).getYear());
			System.out.println("Description : " + list.get(i).getDescription());
			System.out.println("Stars Ranking : " + list.get(i).getStartsRanking());
			System.out.println("                    "); 
		} 
	}
}
