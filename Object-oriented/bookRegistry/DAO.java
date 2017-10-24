package bookRegistry;

import java.util.ArrayList;

public class DAO implements Register {	
	@Override
	public void addDataClient(ArrayList <Client> clients, Client client) {
		client = new Client();
		client.setName("Katerina Silva");
		client.setUser("katerina123");
		client.setDescription("Uma menina apaixonada por livros");
		clients.add(client);
		//pensar em como agrupar por cliente os livros e as listas, separando de cara um.
	}
	
	@Override
	public void addDataList(ArrayList <Collection> collections, Collection collection) {
		collection = new Collection();
		collection.setName("Livros lidos");
		collection.setDescription("Minha lista de livros lidos");
		collections.add(collection);
		
		collection = new Collection();
		collection.setName("Lista de desejos");
		collection.setDescription("Minha lista de livros desejados");
		collections.add(collection);
	}
	
	@Override
	public void addDataBook(ArrayList <Book> books, Book book) {
		book = new Book();
		book.setName("A lagoa azul");
		book.setAuthor("Fulano Ciclano");
		book.setYear(1990);
		book.setDescription("Sobre sobre o filme que passava todas as tardes na sessão da tarde");
		book.setStartsRanking(5);
		books.add(book);
		selectListWishList(); //adicionar no banco um id da lista no qual esse livro irá ser cadastrado
		
		book = new Book();
		book.setName("A menina que roubava livros");
		book.setAuthor("Fulano Beltrano");
		book.setYear(2010);
		book.setDescription("Uma história muito chata");
		book.setStartsRanking(1);
		books.add(book);
		selectListBooksRead(); //adicionar no banco um id da lista no qual esse livro será cadastrado
	}

	public void selectListWishList() {
		//implementar adicionar na tabela do livro a id da lista de desejos
	}

	public void selectListBooksRead() {
		//implementar adicionar na tabela do livro a id da lista de livros lidos
	}
}
