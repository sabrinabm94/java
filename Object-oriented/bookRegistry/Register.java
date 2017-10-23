package bookRegistry;

import java.util.ArrayList;

public interface Register {
	void addDataClient(ArrayList<Client> clients, Client client);
	void addDataList(ArrayList<Collection> collections, Collection collection);
	void addDataBook(ArrayList<Book> books, Book book);
}
