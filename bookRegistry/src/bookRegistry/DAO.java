package bookRegistry;

import java.util.ArrayList;

public class DAO implements Register {	
	@Override
	public void addDataClient(ArrayList <Client> clients, Client client) {
		client = new client();
		client.setName("Katerina Silva");
		client.setUser("katerina123");
		client.setDescription("Uma menina apaixonada por livros");
		clients.add(client);
		//pensar em como agrupar por cliente os livros e as listas, separando de cara um.
	}
	
	@Override
	public void addDataList(ArrayList <List> lists, List list) {
		list = new list();
		list.setName("Livros lidos");
		list.setDescription("Minha lista de livros lidos");
		lists.add(list);
		createListBooksRead(); //criada a lista de livros para essa lista
		
		list = new list();
		list.setName("Lista de desejos");
		list.setDescription("Minha lista de livros desejados");
		lists.add(list);
		createWishList(); //criada a lista de livros para essa lista
	}
	
	@Override
	public void addDataBook(ArrayList <Book> books, Book book) {
		book = new book();
		book.setName("A lagoa azul");
		book.setAuthor("Fulano Ciclano");
		book.setYear(1990);
		book.setDescription("Sobre sobre o filme que passava todas as tardes na sessão da tarde");
		book.setStartsRanking(5);
		books.add(book);
		selectListWishList(wishList, book); //esse livro irá para a lista de livros desejados
		
		book = new book();
		book.setName("A menina que roubava livros");
		book.setAuthor("Fulano Beltrano");
		book.setYear(2010);
		book.setDescription("Uma história muito chata");
		book.setStartsRanking(1);
		books.add(book);
		selectListBooksRead(listBooksRead, book); //este livro irá para os livros lidos
	}
	
	public void createListBooksRead() { 
		private List<listBooksRead> listBooksRead; 
		// Cria a coleção de tarefas.
		//list = new ArrayList<>();
	}
	
	public void createWishList() { 
		private List<wishList> wishList; 
	}
	
	public void selectListBooksRead(ArrayList <listBooksRead> listBooksRead, Book book) {
		listBooksRead.add(book);
	}
	
	public void selectListWishList(ArrayList <wishList> wishList, Book book) {
		wishList.add(book);
	}

	public dbConnection(){
		daConnection = (new ConnectionFactory()).getConnection();
	}
}
