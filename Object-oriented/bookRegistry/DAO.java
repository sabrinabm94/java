package bookRegistry;

import java.util.ArrayList;
import java.util.Date;

public class DAO implements Register {	
	@Override
	public void addDataClient(ArrayList <Client> clients, Client client) {
		client = new Client();
		client.setName("Katerina Silva");
		client.setUser("katerina123");
		client.setDescription("Uma menina apaixonada por livros");
		client.setPassword("12345");
		clients.add(client);
		
		client = new Client();
		client.setName("Rebeca da Costa");
		client.setUser("rebecaLindinha");
		client.setDescription("Viciada em livros");
		client.setPassword("12345");
		clients.add(client);
		//pensar em como agrupar por cliente os livros e as listas, separando de cara um.
	}
	
	@Override
	public void addDataCollection(ArrayList <Collection> collections, Collection collection) {
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
		book.setDescription("Sobre sobre o filme que passava todas as tardes na sessï¿½o da tarde");
		book.setStartsRanking(5);
		book.setReleaseDate(new Date (1990, 05, 20));
		book.setEdition(3);
		book.setIsbn(11111);
		books.add(book);
		selectListWishList(); //adicionar no banco um id da lista no qual esse livro irï¿½ ser cadastrado
		
		book = new Book();
		book.setName("A menina que roubava livros");
		book.setAuthor("Fulano Beltrano");
		book.setYear(2010);
		book.setDescription("Uma histï¿½ria muito chata");
		book.setStartsRanking(1);
		book.setReleaseDate(new Date (1995, 03, 12));
		book.setEdition(8);
		book.setIsbn(22222);
		books.add(book);
		selectListBooksRead(); //adicionar no banco um id da lista no qual esse livro serï¿½ cadastrado
	}

	public void selectListWishList() {
		//implementar adicionar na tabela do livro a id da lista de desejos
	}

	public void selectListBooksRead() {
		//implementar adicionar na tabela do livro a id da lista de livros lidos
	}

	@Override
	public void addDataAuthor(ArrayList<Author> authors, Author author) {
		author = new Author();
		author.setName("Carmem Miranda");
		authors.add(author);
		
		author = new Author();
		author.setName("Zezé Di Camargo e Luciano");
		authors.add(author);
	}

	@Override
	public void addDataPublisher(ArrayList<Publisher> publishers, Publisher publisher) {
		publisher = new Publisher();
		publisher.setName("Editora Brasil");
		publishers.add(publisher);
		
		publisher = new Publisher();
		publisher.setName("Editora Palmeiras");
		publishers.add(publisher);
	}
}
