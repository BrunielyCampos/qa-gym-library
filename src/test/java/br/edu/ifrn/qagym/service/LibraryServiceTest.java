package br.edu.ifrn.qagym.service;

import br.edu.ifrn.qagym.model.Book;
import br.edu.ifrn.qagym.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LibraryServiceTest {

    private LibraryService service;

    @BeforeEach
    void setUp() {
        service = new LibraryService();
    }

    @Test
    void deveAdicionarLivroNaBiblioteca() {
        Book book = new Book("978-0-13-468599-1", "Clean Code", "Robert C. Martin", 2008);
        service.addBook(book);
        assertThat(service.getAllBooks()).contains(book);
    }

    @Test
    void deveBuscarLivroPorIsbn() {
        Book book = new Book("978-0-13-468599-1", "Clean Code", "Robert C. Martin", 2008);
        service.addBook(book);
        Book found = service.findBookByIsbn("978-0-13-468599-1");
        assertThat(found).isEqualTo(book);
    }

    @Test
    void deveRetornarNullParaIsbnInexistente() {
        Book found = service.findBookByIsbn("000-0-00-000000-0");
        assertThat(found).isNull();
    }

    @Test
    void deveBuscarLivrosPorTituloExato() {
        Book book = new Book("978-0-13-468599-1", "Clean Code", "Robert C. Martin", 2008);
        service.addBook(book);
        List<Book> found = service.findBooksByTitle("Clean Code");
        assertThat(found).contains(book);
    }

    @Test
    void deveBuscarLivrosPorAutor() {
        Book book = new Book("978-0-13-468599-1", "Clean Code", "Robert C. Martin", 2008);
        service.addBook(book);
        List<Book> found = service.findBooksByAuthor("robert c. martin");
        assertThat(found).contains(book);
    }

    @Test
    void deveRetornarListaVaziaParaTituloInexistente() {
        List<Book> found = service.findBooksByTitle("Titulo Inexistente");
        assertThat(found).isEmpty();
    }

    @Test
    void deveListarTodosOsLivros() {
        Book b1 = new Book("ISBN-1", "Livro A", "Autor A", 2000);
        Book b2 = new Book("ISBN-2", "Livro B", "Autor B", 2001);
        service.addBook(b1);
        service.addBook(b2);
        assertThat(service.getAllBooks()).hasSize(2);
    }

    @Test
    void deveAdicionarEListarUsuarios() {
        User user = new User("20241001", "Maria Silva");
        service.addUser(user);
        assertThat(service.getAllUsers()).hasSize(1).contains(user);
    }

    @Test
    void deveRetornarApenasLivrosDisponiveis() {
        Book b1 = new Book("ISBN-1", "Livro A", "Autor A", 2000);
        Book b2 = new Book("ISBN-2", "Livro B", "Autor B", 2001);
        b2.setAvailable(false);

        service.addBook(b1);
        service.addBook(b2);

        List<Book> available = service.getBooks("available");
        assertThat(available).hasSize(1).contains(b1);
    }

    @Test
    void deveRetornarApenasLivrosIndisponiveis() {
        Book b1 = new Book("ISBN-1", "Livro A", "Autor A", 2000);
        Book b2 = new Book("ISBN-2", "Livro B", "Autor B", 2001);
        b2.setAvailable(false);

        service.addBook(b1);
        service.addBook(b2);

        List<Book> unavailable = service.getBooks("unavailable");
        assertThat(unavailable).hasSize(1).contains(b2);
    }

    @Test
    void deveRetornarTodosOsLivrosQuandoTipoInvalido() {
        Book b1 = new Book("ISBN-1", "Livro A", "Autor A", 2000);
        service.addBook(b1);

        List<Book> all = service.getBooks("todos");
        assertThat(all).hasSize(1).contains(b1);
    }

    @Test
    void deveOrdenarLivrosPorAutorEmOrdemAlfabetica() {
        // Arrange (Configuração do cenário)
        Book b1 = new Book("ISBN-1", "Livro Um", "Clarice Lispector", 1977);
        Book b2 = new Book("ISBN-2", "Livro Dois", "Agatha Christie", 1930);
        Book b3 = new Book("ISBN-3", "Livro Três", "Machado de Assis", 1899);

        service.addBook(b1);
        service.addBook(b2);
        service.addBook(b3);

        // Act (Ação que estamos testando)
        List<Book> livrosOrdenados = service.sortBooksByAuthor();

        // Assert (Verificação do resultado usando AssertJ)
        assertThat(livrosOrdenados)
                .hasSize(3)
                .containsExactly(b2, b3, b1);
        // containsExactly valida o conteúdo E a ordem exata: Agatha (b2) -> Machado (b3) -> Clarice (b1)
    }
}
