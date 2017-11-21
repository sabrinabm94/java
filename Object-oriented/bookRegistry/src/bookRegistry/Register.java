package bookRegistry;

import java.util.ArrayList;

public interface Register {
	void addDataClient(Client client);
	void addDataCollection(Collection collection);
	void addDataBook(Book book);
	void addDataAuthor(Author author);
	void addDataPublisher(Publisher publisher);
}
