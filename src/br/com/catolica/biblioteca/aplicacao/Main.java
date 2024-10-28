package br.com.catolica.biblioteca.aplicacao;

import br.com.catolica.biblioteca.modelo.*;
import br.com.catolica.biblioteca.gerenciamento.Biblioteca;

public class Main {
    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca("Biblioteca Central", "Rua das Flores, 123");

        Livro livro1 = new Livro("O Senhor dos Anéis", "J.R.R. Tolkien", "1234567890", 1954, 5);
        Livro livro2 = new Livro("1984", "George Orwell", "9876543210", 1949, 3);

        biblioteca.cadastrarLivro(livro1);
        biblioteca.cadastrarLivro(livro2);

        Aluno aluno = new Aluno("Alice", "A01", "alice@example.com", "Engenharia");
        Professor professor = new Professor("Dr. Bruno", "P01", "bruno@example.com", "História");

        biblioteca.exibirInfo();
        biblioteca.emprestar("O Senhor dos Anéis", aluno);
        biblioteca.emprestar("1984", professor);
        biblioteca.verificarDisponibilidade("O Senhor dos Anéis");
        biblioteca.devolver("O Senhor dos Anéis", aluno);
        biblioteca.exibirInfo();
    }
}
