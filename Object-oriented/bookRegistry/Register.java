//package bookRegistry;

import java.util.ArrayList;

public interface Register {
	void addDataClient(ArrayList<Client> clients, Client client);
	void addDataCollection(ArrayList<Collection> collections, Collection collection);
	void addDataBook(ArrayList<Book> books, Book book);
	void addDataAuthor(ArrayList<Author> authors, Author author);
	void addDataPublisher(ArrayList<Publisher> publishers, Publisher publisher);
}
