package br.edu.ifrn.qagym.service;

import br.edu.ifrn.qagym.model.Book;
import br.edu.ifrn.qagym.model.Loan;
import br.edu.ifrn.qagym.model.User;
import br.edu.ifrn.qagym.exception.LoanNotAllowedException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LoanServiceTest {

    private LoanService loanService;
    private Book book;
    private User user;

    @BeforeEach
    void setUp() {
        loanService = new LoanService();
        book = new Book("978-0-13-468599-1", "Clean Code", "Robert C. Martin", 2008);
        user = new User("20241001", "Maria Silva");
    }

    @Test
    void deveMarcarLivroComoIndisponivelAposEmprestimo() {
        loanService.borrowBook(book, user, LocalDate.now());
        assertThat(book.isAvailable()).isFalse();
    }

    @Test
    void deveMarcarLivroComoDisponivelAposDevolucao() {
        Loan loan = loanService.borrowBook(book, user, LocalDate.now());
        loanService.returnBook(loan, LocalDate.now());
        assertThat(book.isAvailable()).isTrue();
    }

    @Test
    void deveRegistrarDevolucao() {
        Loan loan = loanService.borrowBook(book, user, LocalDate.now());
        loanService.returnBook(loan, LocalDate.now());
        assertThat(loan.isReturned()).isTrue();
    }

    @Test
    void deveListarEmprestimosAtivos() {
        loanService.borrowBook(book, user, LocalDate.now());
        assertThat(loanService.getActiveLoans()).hasSize(1);
    }

    @Test
    void naoDeveListarEmprestimoDevolvido() {
        Loan loan = loanService.borrowBook(book, user, LocalDate.now());
        loanService.returnBook(loan, LocalDate.now());
        assertThat(loanService.getActiveLoans()).isEmpty();
    }

    @Test
    void naoDevePermitirEmprestimoDeLivroIndisponivel() {

        book.setAvailable(false);


        assertThatThrownBy(() -> loanService.borrowBook(book, user, LocalDate.now()))
                .isInstanceOf(LoanNotAllowedException.class)
                .hasMessageContaining("O livro não está disponível para empréstimo.");
    }
}