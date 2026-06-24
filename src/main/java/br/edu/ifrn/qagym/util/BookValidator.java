package br.edu.ifrn.qagym.util;

import br.edu.ifrn.qagym.model.Book;

public class BookValidator {

    public boolean isValid(Book book) {
        if (book == null) {
            return false;
        }
        if (book.getIsbn() == null || book.getIsbn().isBlank()) {
            return false;
        }
        if (book.getTitle() == null || book.getTitle().isBlank()) {
            return false;
        }
        // TODO: validar autor vazio
        if (book.getAuthor() == null || book.getAuthor().isBlank()) {
            return false;
        }
        // TODO: validar ano de publicação inválido (ex: ano futuro ou negativo)
        return true;
    }
}
