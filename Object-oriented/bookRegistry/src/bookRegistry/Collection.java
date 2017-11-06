package bookRegistry;

import java.util.ArrayList;

public class Collection {
	private String name;
	private String description; 
	private int size;
	private ArrayList <Book> books;
	
	public ArrayList<Book> getBooks() {
		return books;
	}

	public void setBooks(ArrayList<Book> books) {
		this.books = books;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setSize() {
		this.size = size;
	}
	
	public int getSize() {
		return size;
	}
}
