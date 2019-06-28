import bookRegistry.Author;
import bookRegistry.Book;
import bookRegistry.Client;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Controller {
	private String userClientLogin;
	private String passwordClientLogin;
	
	//cadastro author
	private String nameAuthorRegistry;
	
	//cadastro book
	private int isbnBookRegistry;
	private String nameBookRegistry;
	private int yearBookRegistry;
	private String descriptonBookRegistry;
	private int idAuthorBookRegistry;
	private int startsRankingBookRegistry;
	private Date releaseDataBookRegistry;
	private int editionBookRegistry;
	private int idCollectionBookRegistry;
	
	// cadastro client
	private String nameClientRegistry;
	private String userClientRegistry;
	private String descriptionClientRegistry;
	private String passwordClientRegistry;
	private Date birtDateRegistry;
	
	//cadastro collection
	private String nameCollectionRegistry;
	private String descriptionCollectionRegistry;
	private int sizeCollectionRegistry;
	
	//cadastro publisher
	private String namePublisherRegistry;
	
	private View view;
	private DAO dao;
	private bookRegistry.Author author;
	private bookRegistry.Book book;
	private bookRegistry.Client client;
	private bookRegistry.Collection collection;
	private bookRegistry.Publisher publisher;
	
	public Controller() {
		view = new View();
		dao = new DAO();
		author = new Author();
		book = new Book();
		client = new Client();
		collection = new bookRegistry.Collection();
		publisher = new bookRegistry.Publisher();
	}
	public void initController(){
		view.getLoginButton().addActionListener(e -> doLogin()); //t� estorando um erro aqui
		//adicionar os bot�es relacionados as outras a��es como doRegistryClient
	}
	
	private void doLogin(){
		userClientLogin = view.getUserClientLogin();
		passwordClientLogin = view.getPasswordClientLogin();
		
		if(userClientLogin.length() < 1){
			view.setErrorMessage("Favor informar o usuário.");
		} else if(passwordClientLogin.length() < 1){
			view.setErrorMessage("Favor informar a senha.");
		} else if(passwordClientLogin.length() < 8){
			view.setErrorMessage("A senha deve conter no mínimo 8 caracteres.");
		} else if ("usuario".equals(userClientLogin)
		   && "senha123".equals(passwordClientLogin)){
			view.setSuccessMessage("Seja bem vindos!");
		} else{
			view.setErrorMessage("O usuário ou a senha está incorreto");
		}
	}
	
	//CADASTRO DAS INFORMA��ES NO BANCO
	
	private void doRegisterAuthor(){
		nameAuthorRegistry = view.getNameAuthorRegistry();
		
		author = new Author();
		author.setName(nameAuthorRegistry); 
		dao.addDataAuthor(author);
	}
	
	private void doRegisterBook(){
		/*
		isbnBookRegistry = view.getIsbnBookRegistry();
		nameBookRegistry = view.getNameBookRegistry();
		yearBookRegistry = view.getYearBookRegistry();
		descriptonBookRegistry = view.getDescriptionBookRegistry();
		idAuthorBookRegistry = view.getIdAuthorBookRegistry();
		startsRankingBookRegistry = view.getStartsRankingBookRegistry();
		//releaseDataBookRegistry = view.getReleaseDateBookRegistry();
		editionBookRegistry = view.getEditionBookRegistry();
		idCollectionBookRegistry = view.getIdCollectionBookRegistry();
		 */
		
		book = new Book();
		book.setIsbn(isbnBookRegistry);
		book.setName(nameBookRegistry);
		book.setYear(yearBookRegistry);
		book.setDescription(descriptonBookRegistry);
		book.setAuthor(idAuthorBookRegistry);
		book.setStartsRanking(startsRankingBookRegistry);
		book.setReleaseDate(releaseDataBookRegistry);
		book.setEdition(editionBookRegistry);
		book.setCollection(idCollectionBookRegistry);
		dao.addDataBook(book);
	}
	
	private void doRegisterClient(){
		userClientRegistry = view.getUserClientRegistry();
		passwordClientRegistry = view.getPasswordClientRegistry();
		nameClientRegistry = view.getNameClientRegistry();
		descriptionClientRegistry = view.getDescriptionClientRegistry();
		//birtDateRegistry = view.getBirtDateRegistry();
		
		//valida��o para cadastro de senha e user		
		if(userClientRegistry.length() < 1){
			view.setErrorMessage("Favor informar o usuário.");
		} else if(passwordClientRegistry.length() < 1){
			view.setErrorMessage("Favor informar a senha.");
		} else if(passwordClientRegistry.length() < 8){
			view.setErrorMessage("A senha deve conter no mínimo 8 caracteres.");
		} else if ("usuario".equals(userClientRegistry)
		   && "senha123".equals(passwordClientRegistry)){
			view.setSuccessMessage("Seja bem vindos!");
		} else{
			view.setErrorMessage("O usuário ou a senha está incorreto");
		}
		
		client = new Client();
		client.setUser(userClientRegistry);
		client.setPassword(passwordClientRegistry);
		client.setName(nameClientRegistry);
		client.setDescription(descriptionClientRegistry);
		client.setBirtDate(birtDateRegistry); //VER O ERRO DO DATE
		dao.addDataClient(client);
	}
	
	private void doRegisterCollection(){
		nameCollectionRegistry = view.getNameCollectionRegistry();
		descriptionCollectionRegistry = view.getDescriptionCollectionRegistry();
		//sizeCollectionRegistry = view.getSizeCollectionRegistry();
		
		collection = new bookRegistry.Collection();
		collection.setName(nameCollectionRegistry);
		collection.setDescription(descriptionCollectionRegistry);
		collection.setSize(sizeCollectionRegistry);
		dao.addDataCollection(collection);
	}
	
	private void doRegisterPublisher(){
		namePublisherRegistry = view.getnamePublisherRegistry();
		
		publisher = new bookRegistry.Publisher();
		publisher.setName(namePublisherRegistry);
		dao.addDataPublisher(publisher);
	}
	
	
	
	//SELECTS DAS INFORMA��ES CADASTRADAS

	public void returInfoClient(String userClient) {
		
		Connection mConn = (new bookRegistry.ConnectionFactory()).getConnection();

		String sql = "SELECT nameClient, userClient, descriptionClient, passwordClient, birtDate FROM Client WHERE userClient LIKE '" + userClient + "%';";

		//VER SE UM SELECT TRAZ TUDO OU PRECISA FAZER VARIOS SEPARADOS
		
		
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
			stmt.execute();
			stmt.close();
			System.out.println("retornando informações author");
			System.out.println(sql);
			mConn.close();

			//addClientInfoTela(nameClient, userClient, descriptionClient, passwordClient, birDate);
			addClientInfoTela(stmt);

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private void addClientInfoTela(PreparedStatement stmt) {
		//pegar as info do select e jogar na tela
		
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
