package br.edu.ifrn.qagym.model;

import java.time.LocalDate;

public class Book {

    private String isbn;
    private String title;
    private String author;
    private int publicationYear;
    private boolean available;

    public Book(String isbn, String title, String author, int publicationYear) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
        this.available = true;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public boolean isClassic() {

        int currentYear = LocalDate.now().getYear();
        return (currentYear - this.publicationYear) >= 50;

    }

    @Override
    public String toString() {
        return title + " - " + author + " (" + publicationYear + ") [ISBN: " + isbn + "]";
    }
}
