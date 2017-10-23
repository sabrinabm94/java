package bookRegistry;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	Client client = new Client(); 
	Book book = new Book(); 
	Collection collection = new Collection(); 
	ArrayList <Client> clients = new ArrayList();
	ArrayList <Book> books = new ArrayList();
	ArrayList <Collection> collections = new ArrayList();

	DAO dao = new DAO();
	dao.addDataClient(clients, client);
	dao.addDataList(collections, collection);
	dao.addDataBook(books, book);
	
	//fazer um menu para mostrar as views de acordo com as opções, fazer por último antes garantir que tudo está funcionando okay
	View view = new View();
	view.showClientData(client);
	view.showBookData(book);
	view.showListData(list);
	view.showAllBooksData(books);
	view.showAllListsData(lists);
	view.showBooksOnList(list);
}
