package br.edu.ifrn.qagym.service;

import br.edu.ifrn.qagym.model.Book;
import br.edu.ifrn.qagym.model.User;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LibraryService {

    private final List<Book> books = new ArrayList<>();
    private final List<User> users = new ArrayList<>();

    public void addBook(Book book) {
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

    public List<Book> findBooksByAuthor(String author) {
        // TODO: implementar busca por autor
        return List.of();
    }

    public int countBooks() {
        // TODO: implementar contagem total de livros
        return 0;
    }

    public int countAvailableBooks() {
        // TODO: implementar contagem de livros disponíveis
        return 0;
    }

    public int countUnavailableBooks() {
        // TODO: implementar contagem de livros indisponíveis
        return 0;
    }

    public List<Book> sortBooksByTitle() {
        // TODO: implementar ordenação por título
        return List.of();
    }

    public List<Book> sortBooksByYear() {
        // TODO: implementar ordenação por ano
        return List.of();
    }

    public List<Book> sortBooksByAuthor() {
        List <Book> sortAuthor = new ArrayList<>(books);

        sortAuthor.sort(Comparator.comparing(Book::getAuthor));

        return sortAuthor;
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
