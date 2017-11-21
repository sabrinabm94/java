package bookRegistry;

import java.util.ArrayList;
import java.util.Date;

public class Controller {
	private Client client;
	private Collection collection;
	private Book book;
	private Author author;
	private Publisher publisher;

	private DAO dao;
	private View view;

	// private String nameClient;
	// private String userClient;
	// private String descriptionClient;
	// private String passwordClient;
	// private Date birDate;
	
	
	public void initController(){
		client = new Client();
		collection = new Collection();
		book = new Book();
		author = new Author();
		publisher = new Publisher();

		view = new View();
		dao = new DAO();

		view.getLoginButton().addActionListener(e -> doLogin());
	}
	
	private void doLogin(){
		if(view.getUser().length() < 1){
			view.setErrorMessage("Favor informar o usuário.");
		}else if(view.getPassword().length() < 1){
			view.setErrorMessage("Favor informar a senha.");
		}else if(view.getPassword().length() < 8){
			view.setErrorMessage("A senha deve conter no mínimo 8 caracteres.");
		}else if ("usuario".equals(view.getUser())
		   && "senha123".equals(view.getPassword())){
			view.setSuccessMessage("Seja bem vindos!");
		}else{
			view.setErrorMessage("O usuário ou a senha está incorreto");
		}
	}

	//CODIGOS ANTIGOS
	// client = new Client();
	// client.setName("Katerina Silva");
	// client.setUser("katerina123");
	// client.setDescription("Uma menina apaixonada por livros");
	// client.setPassword("12345");
	
	// client = new Client();
	// client.setName("Rebeca da Costa");
	// client.setUser("rebecaLindinha");
	// client.setDescription("Viciada em livros");
	// client.setPassword("12345");

	// book = new Book();
	// book.setIsbn(11111);
	// book.setName("A lagoa azul");
	// book.setYear(1990);
	// book.setDescription("Sobre sobre o filme que passava todas as tardes na sessï¿½o da tarde");
	// book.setAuthor("Fulano Ciclano");
	// book.setStartsRanking(5);
	// book.setReleaseDate(new Date (1990, 05, 20));
	// book.setEdition(3);
	// book.setCollection(1);
	
	// book = new Book();
	// book.setIsbn(22222);
	// book.setName("A menina que roubava livros");
	// book.setYear(2010);
	// book.setDescription("Uma histï¿½ria muito chata");
	// book.setAuthor("Fulano Beltrano");
	// book.setStartsRanking(1);
	// book.setReleaseDate(new Date (1995, 03, 12));
	// book.setEdition(8);
	// book.setCollection(2);

	// collection = new Collection();
	// collection.setName("Livros lidos");
	// collection.setDescription("Minha lista de livros lidos");
	
	// collection = new Collection();
	// collection.setName("Lista de desejos");
	// collection.setDescription("Minha lista de livros desejados");

	// author = new Author();
	// author.setName("Carmem Miranda");
	
	// author = new Author();
	// author.setName("Zezé Di Camargo e Luciano");

	// publisher = new Publisher();
	// publisher.setName("Editora Brasil");
	// publishers.add(publisher);
	
	// publisher = new Publisher();
	// publisher.setName("Editora Palmeiras");
	// publishers.add(publisher);


	// public void showClientData(Client client) { //mostrar informa��es de um cliente espec�fico
	// 	System.out.println("Name : " + client.getName());
	// 	System.out.println("User : " + client.getUser());
	// 	System.out.println("Password : " + client.getPassword());
	// 	System.out.println("Description : " + client.getDescription());
	// 	System.out.println("                    "); 
	// }
	
	// public void showBookData(Book book) { //mostrar informa��o de um livro espec�fico
	// 	System.out.println("Name : " + book.getName());
	// 	System.out.println("Author : " + book.getAuthor());
	// 	System.out.println("Year : " + book.getYear());
	// 	System.out.println("Description : " + book.getDescription());
	// 	System.out.println("Stars Ranking : " + book.getStartsRanking());
	// 	System.out.println("Release Date : " + book.getReleaseDate());
	// 	System.out.println("Edition : " + book.getEdition());
	// 	System.out.println("Isbn : " + book.getIsbn());
	// 	System.out.println("                    "); 
	// }
	
	// public void showListData(Collection collection) { //mostrar informa��o de uma lista espec�fica
	// 	System.out.println("Name : " + collection.getName());
	// 	System.out.println("Description : " + collection.getDescription());
	// 	System.out.println("                    "); 
	// }
	
	// public void showAllBooksData(ArrayList <Book> books) { //listar todos os livros cadastrados
	// 	for(int i = 0; i < books.size(); i++){
	// 		System.out.println("Book number: " + i);
	// 		System.out.println("Name : " + books.get(i).getName());
	// 		System.out.println("Author : " + books.get(i).getAuthor());
	// 		System.out.println("Year : " + books.get(i).getYear());
	// 		System.out.println("Description : " + books.get(i).getDescription());
	// 		System.out.println("Stars Ranking : " + books.get(i).getStartsRanking());
	// 		System.out.println("Release Date : " + books.get(i).getReleaseDate());
	// 		System.out.println("Edition : " + books.get(i).getEdition());
	// 		System.out.println("Isbn : " + books.get(i).getIsbn());
	// 		System.out.println("                    "); 
	// 	} 
	// }
	
	// public void showAllListsData(ArrayList <Collection> collections) { //listar todas as listas cadastradas
	// 	for(int i = 0; i < collections.size(); i++){
	// 		System.out.println("Collection number: " + i);
	// 		System.out.println("Name : " + collections.get(i).getName());
	// 		System.out.println("Description : " + collections.get(i).getDescription());
	// 		System.out.println("                    "); 
	// 	} 
	// }
	
	// public void showBooksOnList(ArrayList <Collection> collections) { //listar os livros por lista: lista[0/1]> book[0/n]		
	// 	for(Collection c: collections){
	// 		System.out.println("Collection number: ");
	// 		System.out.println("Name : " + c.getName());
	// 		System.out.println("Description : " + c.getDescription());
			
	// 		for(Book b: c.getBooks()){
	// 			System.out.println("Book number: ");
	// 			System.out.println("Name : " +b.getName());
	// 			System.out.println("Author : " + b.getAuthor());
	// 			System.out.println("Year : " + b.getYear());
	// 			System.out.println("Description : " + b.getDescription());
	// 			System.out.println("Stars Ranking : " + b.getStartsRanking());
	// 			System.out.println("Release Date : " + b.getReleaseDate());
	// 			System.out.println("Edition : " + b.getEdition());
	// 			System.out.println("Isbn : " + b.getIsbn());
	// 			System.out.println("                    "); 
	// 		}
	// 	}
	// } 
	
	// public void showDataAuthor(Author author) { 
	// 	System.out.println("Name : " + author.getName());
	// 	System.out.println("                    "); 
	// }
	
	// public void showAllDataAuthor(ArrayList <Author> authors) { 
	// 	for(int i = 0; i < authors.size(); i++){
	// 		System.out.println("Name : " + authors.get(i).getName());
	// 		System.out.println("                    "); 
	// 	} 
	// }
	
	// public void showDataPublisher(Publisher publisher) { 
	// 	System.out.println("Name : " + publisher.getName());
	// 	System.out.println("                    "); 
	// }
	
	// public void showAllDataPublisher(ArrayList <Publisher> publishers) {
	// 	for(int i = 0; i < publishers.size(); i++){
	// 		System.out.println("Name : " + publishers.get(i).getName());
	// 		System.out.println("                    "); 
	// 	} 
	// }










	//vir os dados dos inputs da tela do view
	//CODIGO NOVO

	//metodo size collection

	//select informações clients
	// pegar o valor do userCLient da tela de login
	public void returInfoClient(view) {
		
		Connection mConn = (new ConnectionFactory()).getConnection();

		String sql = "SELECT nameClient, userClient, descriptionClient, passwordClient, birtDate 
					  FROM Client WHERE userClient LIKE '"
					  +userClient+"%';"

		// nameClient = "SELECT nameClient FROM Client WHERE userClient LIKE 'userClient%';";
		// userClient = "SELECT userClient FROM Client WHERE userClient LIKE 'userClient%';";
		// descriptionClient = "SELECT descriptionClient FROM Client WHERE userClient LIKE 'userClient%';";
		// passwordClient = "SELECT passwordClient FROM Client WHERE userClient LIKE 'userClient%';";
		// birDate = "SELECT birDate FROM Client WHERE userClient LIKE 'userClient%';";

		try {
			PreparedStatement stmt = mConn.prepareStatement(sql);
			// PreparedStatement stmt = mConn.prepareStatement(nameClient);
			// PreparedStatement stmt = mConn.prepareStatement(userClient);
			// PreparedStatement stmt = mConn.prepareStatement(passwordClient);
			// PreparedStatement stmt = mConn.prepareStatement(birDate);
			stmt.setString(1, view.userClient);
			stmt.execute();
			stmt.close();
			System.out.println("retornando informações author");
			System.out.println(sql);
			connection.close();

			//addClientInfoTela(nameClient, userClient, descriptionClient, passwordClient, birDate);
			addClientInfoTela(stmt);

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	//select informações livro

	//select informações listas

	//select informações author

	//select informações editora

	//select livros por cliente

	//select livros por lista

	//select livros por author

	//select livros por editora
}
