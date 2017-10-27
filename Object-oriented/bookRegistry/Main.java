//package bookRegistry;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Client client = new Client(); 
		Book book = new Book(); 
		Collection collection = new Collection(); 
		Author author = new Author();
		Publisher publisher = new Publisher();
		ArrayList <Client> clients = new ArrayList();
		ArrayList <Book> books = new ArrayList();
		ArrayList <Collection> collections = new ArrayList();
		ArrayList <Author> authors = new ArrayList();
		ArrayList <Publisher> publishers = new ArrayList();

		DAO dao = new DAO();
		dao.addDataClient(clients, client);
		dao.addDataCollection(collections, collection);
		dao.addDataBook(books, book);
		dao.addDataAuthor(authors, author);
		dao.addDataPublisher(publishers, publisher);
		
		//fazer um menu para mostrar as views de acordo com as op��es, fazer por �ltimo antes garantir que tudo est� funcionando okay
		View view = new View();
		view.showClientData(client);
		view.showBookData(book);
		view.showListData(collection);
		view.showAllBooksData(books);
		view.showAllListsData(collections);
		view.showBooksOnList(collections);
		view.showDataAuthor(author);
		view.showAllDataAuthor(authors);
		view.showDataPublisher(publisher);
		view.showAllDataPublisher(publishers);
		
		//teste das telas
		UI ui = new UI();
		ui.setVisible(true);
	}
}
