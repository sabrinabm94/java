package bookRegistry;

public class Book {
	private String name;
	private String author;
	private int year;
	private String description;
	private int startsRanking;
	
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
}
