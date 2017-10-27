//package bookRegistry;

import java.util.Date;

public class Book {
	private String name;
	private String author;
	private int year;
	private String description;
	private int startsRanking;
<<<<<<< HEAD
	private Date releaseDate;
=======
	private int releaseDate;
>>>>>>> b175442ccc05a5cfb9ed7d0c0879b556fd78e85f
	private int edition;
	private int isbn;
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public void setAuthor(String author) {
		this.author = author;
	}
	
	public String getAuthor() {
		return author;
	}
	
	public void setYear(int year) {
		this.year = year;
	}
	
	public int getYear() {
		return year;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setStartsRanking(int startsRanking) {
		this.startsRanking = startsRanking;
	}
	
	public int getStartsRanking() {
		return startsRanking;
	}
	
<<<<<<< HEAD
=======
	public void setReleaseDate(int releaseDate) {
		this.releaseDate = releaseDate;
	}
	
	public int getReleaseDate() {
		return releaseDate;
	}
>>>>>>> b175442ccc05a5cfb9ed7d0c0879b556fd78e85f
	
	public void setEdition(int edition) {
		this.edition = edition;
	}
	
	public int getEdition() {
<<<<<<< HEAD
		return edition;
	}
	
	public Date getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}

=======
		return releaseDate;
	}
	
>>>>>>> b175442ccc05a5cfb9ed7d0c0879b556fd78e85f
	public void setIsbn(int isbn) {
		this.isbn = isbn;
	}
	
	public int getIsbn() {
		return isbn;
	}
}
