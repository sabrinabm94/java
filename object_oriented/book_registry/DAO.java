package bookRegistry;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DAO implements Register {	
	private Connection connection;

	@Override
	public void addDataAuthor(Author author) {
		
		Connection mConn = (new ConnectionFactory()).getConnection();

		String sql = "insert into Author(nameAuthor) "
			    + "values(?);";

		try {
			PreparedStatement stmt = mConn.prepareStatement(sql);
			stmt.setString(1, author.getName()); 
			stmt.execute();
			stmt.close();
			System.out.println("Gravado author");
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void addDataBook(Book book) {
		
		Connection mConn = (new ConnectionFactory()).getConnection();

		String sql = "insert into Book(isbn, nameBook, yearBook, descriptonBook, idAuthorBook, startsRanking, releaseDataBook, editionBook, idCollection) "
			    + "values(?,?,?,?,?,?,?);";

		try {
			PreparedStatement stmt = mConn.prepareStatement(sql);
			stmt.setInt(1, book.getIsbn());
			stmt.setString(2, book.getName()); 
			stmt.setInt(3, book.getYear()); 		
			stmt.setString(4, book.getDescription());
			stmt.setInt(5, book.getAuthor());
			stmt.setInt(6, book.getStartsRanking());
			stmt.setDate(7, book.getReleaseDate());  //erro
			stmt.setInt(8, book.getEdition());
			stmt.setInt(9, book.getCollection());
			System.out.println("Gravado book");
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void addDataClient(Client client) {

		Connection mConn = (new ConnectionFactory()).getConnection();
		
		String sql = "insert into Client(nameClient, userClient, descriptionClient, passwordClient, birtDate) "
			    + "values(?,?,?,?,?);";
		
		try { //pegar as info da tela e jogar no banco
			PreparedStatement stmt = mConn.prepareStatement(sql);
			stmt.setString(1, client.getName()); 
			stmt.setString(2, client.getUser());
			stmt.setString(3, client.getDescription()); 
			stmt.setString(4, client.getPassword());
			stmt.setDate(5, client.getBirtDate());
			stmt.execute();
			stmt.close();
			System.out.println("Gravado client");
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void addDataCollection(Collection collection) {
		
		Connection mConn = (new ConnectionFactory()).getConnection();
		
		String sql = "insert into Collection(nameCollection, descriptionCollection, sizeCollection) "
			    + "values(?,?,?);";
		
		try {
			PreparedStatement stmt = mConn.prepareStatement(sql);
			stmt.setString(1, collection.getName()); 
			stmt.setString(2, collection.getDescription());
			stmt.setInt(3, collection.getSize()); 
			stmt.execute();
			stmt.close();
			System.out.println("Gravado collection");
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void addDataPublisher(Publisher publisher) {
		
		Connection mConn = (new ConnectionFactory()).getConnection();

		String sql = "insert into Publisher(namePublisher) "
			    + "values(?);";

		try {
			PreparedStatement stmt = mConn.prepareStatement(sql);
			stmt.setString(1, publisher.getName()); 
			stmt.execute();
			stmt.close();
			System.out.println("Gravado publisher");
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
