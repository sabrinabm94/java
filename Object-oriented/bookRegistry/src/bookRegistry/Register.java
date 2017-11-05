package bookRegistry;

import java.util.ArrayList;

public interface Register {
	void addDataClient(ArrayList<Client> clients, Client client);
	void addDataList(ArrayList<List> lists, List list);
	void addDataBook(ArrayList<Book> books, Book book);
}
