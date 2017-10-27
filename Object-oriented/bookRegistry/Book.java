//package bookRegistry;

import java.util.Date;

public class Book {
	private String name;
	private String author;
	private int year;
	private String description;
	private int startsRanking;
	private Date releaseDate;
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
	
	public void setReleaseDate(int releaseDate) {
		this.releaseDate = releaseDate;
	}
	
	public int getReleaseDate() {
		return releaseDate;
	}
	
	public void setEdition(int edition) {
		this.edition = edition;
	}
	
	public int getEdition() {
		return edition;
	}
	
	public Date getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}
	
	public void setIsbn(int isbn) {
		this.isbn = isbn;
	}
	
	public int getIsbn() {
		return isbn;
	}
}
