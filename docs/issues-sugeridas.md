# Issues sugeridas para o qa-gym-library

Este documento lista as issues disponíveis para implementação. Escolha uma, abra a issue correspondente no GitHub e crie uma branch para trabalhar.

---

## Nivel 1 — Issues fáceis

| # | Título | Classe principal |
|---|--------|-----------------|
| 1 | Implementar contagem total de livros | `LibraryService` |
| 2 | Implementar contagem de livros disponíveis | `LibraryService` / `ReportService` |
| 3 | Implementar contagem de livros indisponíveis | `LibraryService` / `ReportService` |
| 4 | Implementar ordenação de livros por título | `LibraryService` |
| 5 | Validar título vazio no cadastro de livro | `BookValidator` |
| 6 | Validar autor vazio no cadastro de livro | `BookValidator` |
| 7 | Validar nome vazio no cadastro de usuário | `UserValidator` (a criar) |
| 8 | Implementar método que verifica se um livro é clássico | `Book` |
| 9 | Implementar listagem de livros por autor | `LibraryService` | //concluído

---

## Nível 2 — Issues médias

| # | Título | Classe principal |
|---|--------|-----------------|
| 10 | Impedir cadastro de livro com ISBN duplicado | `LibraryService` |
| 11 | Melhorar busca por título ignorando maiúsculas e minúsculas | `LibraryService` / `TextNormalizer` |
| 12 | Implementar busca parcial por título | `LibraryService` / `TextNormalizer` |
| 13 | Impedir empréstimo de livro indisponível | `LoanService` |
| 14 | Impedir empréstimo para usuário inativo | `LoanService` |
| 15 | Calcular atraso de devolução | `Loan` |
| 16 | Calcular multa por atraso | `Loan` |
| 17 | Criar relatório de livros por autor | `ReportService` |
| 18 | Validar ISBN no formato correto | `BookValidator` |
| 19 | Implementar ordenação por ano de publicação | `LibraryService` |
| 20 | Implementar ordenação por autor | `LibraryService` |

---

## Nível 3 — Issues de qualidade

| # | Título | Foco |
|---|--------|------|
| 21 | Aumentar cobertura de testes de `Book` | Testes |
| 22 | Adicionar testes para `BookValidator` | Testes |
| 23 | Refatorar condicionais redundantes em `LibraryService` | Refatoração |
| 24 | Melhorar nomes de métodos em `ReportService` | Legibilidade |
| 25 | Melhorar mensagens de exceção | Legibilidade |
| 26 | Adicionar exemplos de uso no README | Documentação |
| 27 | Separar método `getBooks(String)` em métodos específicos | Refatoração |
| 28 | Adicionar testes de regressão para `LoanService` | Testes |

---

## Convenção de branches

Use o padrão:

```
feature/issue-<numero>-<descricao-curta>
bugfix/issue-<numero>-<descricao-curta>
refactor/issue-<numero>-<descricao-curta>
```

Exemplos:
- `feature/issue-1-contagem-livros`
- `refactor/issue-27-separar-getbooks`
- `bugfix/issue-13-impedir-emprestimo-indisponivel`
