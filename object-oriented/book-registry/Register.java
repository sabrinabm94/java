public interface Register {
	void addDataClient(bookRegistry.Client client);
	void addDataCollection(bookRegistry.Collection collection);
	void addDataBook(bookRegistry.Book book);
	void addDataAuthor(bookRegistry.Author author);
	void addDataPublisher(bookRegistry.Publisher publisher);
}
