package br.edu.ifrn.qagym.service;

import br.edu.ifrn.qagym.model.Book;
import br.edu.ifrn.qagym.model.User;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class LibraryService {

    private final List<Book> books = new ArrayList<>();
    private final List<User> users = new ArrayList<>();
    private Book book;

    public void addBook(Book book) {
        if (isBookRegistered(book.getIsbn())){
            throw new IllegalArgumentException("Livro já cadastrado");
        }
        books.add(book);
    }

    public void addUser(User user) {
        users.add(user);
    }

    public List<Book> getAllBooks() {
        return new ArrayList<>(books);
    }

    public List<User> getAllUsers() {
        return new ArrayList<>(users);
    }

    public Book findBookByIsbn(String isbn) {
        for (Book book : books) {
            if (book.getIsbn().equals(isbn)) {
                return book;
            }
        }
        return null;
    }

    public List<Book> findBooksByTitle(String title) {
        List<Book> result = new ArrayList<>();
        for (Book book : books) {
            if (book.getTitle().equals(title)) {
                result.add(book);
            }
        }
        return result;
    }

    public List<Book> findBooksByAuthor(String author){
        if (author == null) {
            return List.of();
        }

        List<Book> result = new ArrayList<>();

        for (Book book : books) {
            if (book.getAuthor().equalsIgnoreCase(author)) {
                result.add(book);
            }
        }

        return result;
    }

    public int countBooks() {
        // TODO: implementar contagem total de livros
        return 0;
    }

  public int countAvailableBooks() {
       
        if (books.isEmpty()) {
            return 0;
        }

        return (int) books.stream()
                          .filter(Book::isAvailable)
                          .count();
    }

    public int countUnavailableBooks() {
          int qtdlivro = 0;
            for (Book book : books){
                if(!book.isAvailable()){
                  qtdlivro++;
                }
            }

    public List<Book> sortBooksByTitle() {
        List<Book> sorted = new ArrayList<>(books);
        sorted.sort(Comparator.comparing(Book::getTitle));
        return sorted;
    }

    public List<Book> sortBooksByYear() {
        // TODO: implementar ordenação por ano
        return List.of();
    }
    public boolean isBookRegistered(String isbn){
        
        if (findBookByIsbn(isbn) != null){
            return true;
        }
        return false;
    }

    public List<Book> getBooks(String type) {
        if (type.equals("available")) {
            List<Book> result = new ArrayList<>();
            for (Book book : books) {
                if (book.isAvailable() == true) {
                    result.add(book);
                }
            }
            return result;
        } else if (type.equals("unavailable")) {
            List<Book> result = new ArrayList<>();
            for (Book book : books) {
                if (book.isAvailable() == false) {
                    result.add(book);
                }
            }
            return result;
        } else {
            return getAllBooks();
        }
    }
}
