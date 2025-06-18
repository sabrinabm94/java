package objectOriented.heritage.bookDatabase;

import java.util.Date;

public class Book {
    private String name;
    private int year;
    private String description;
    private int startsRanking;
    private Date releaseDate;
    private int edition;
    private int isbn;
    private int collection;
    private int idAuthor;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setAuthor(int idAuthor) {
        this.idAuthor = idAuthor;
    }

    public int getAuthor() {
        return idAuthor;
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

    public void setCollection(int collection) {
        this.collection = collection;
    }

    public int getCollection() {
        return collection;
    }
}
