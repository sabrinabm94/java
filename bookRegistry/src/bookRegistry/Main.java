package bookRegistry;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	Client client = new Client(); 
	Book book = new Book(); 
	List list = new List(); 
	ArrayList <Client> clients = new ArrayList();
	ArrayList <Book> books = new ArrayList();
	ArrayList <List> lists = new ArrayList();

	DAO dao = new DAO();
	dao.addDataClient(clients, client);
	dao.addDataList(list, list);
	dao.addDataBook(books, book);
	dao.dbConnection();

	//adicionar nas telas	
	View view = new View();
	view.showClientData(client);
	view.showBookData(book);
	view.showListData(list);
	view.showAllBooksData(books);
	view.showAllListsData(lists);
	view.showBooksOnList(list);
}
