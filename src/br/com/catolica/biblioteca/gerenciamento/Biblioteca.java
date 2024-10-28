package br.com.catolica.biblioteca.gerenciamento;

import br.com.catolica.biblioteca.modelo.Livro;
import br.com.catolica.biblioteca.modelo.Usuario;

public class Biblioteca {
    private String nome;
    private String endereco;
    private Livro[] livros;
    private int quantidadeLivros;

    public Biblioteca(String nome, String endereco) {
        this.nome = nome;
        this.endereco = endereco;
        this.livros = new Livro[100];
        this.quantidadeLivros = 0;
    }

    public void cadastrarLivro(Livro livro) {
        if (quantidadeLivros < livros.length) {
            livros[quantidadeLivros++] = livro;
            System.out.println("Livro cadastrado: " + livro.getTitulo());
        } else {
            System.out.println("Capacidade máxima de livros atingida.");
        }
    }

    public void verificarDisponibilidade(String titulo) {
        for (Livro livro : livros) {
            if (livro != null && livro.getTitulo().equals(titulo)) {
                System.out.println("Disponibilidade: " + livro.getQuantidadeEmEstoque());
                return;
            }
        }
        System.out.println("Livro não encontrado.");
    }

    public void localizarLivroPorTitulo(String titulo) {
        for (Livro livro : livros) {
            if (livro != null && livro.getTitulo().equalsIgnoreCase(titulo)) {
                livro.exibirInfo();
                return;
            }
        }
        System.out.println("Livro não encontrado.");
    }

    public void localizarLivroPorAutor(String autor) {
        for (Livro livro : livros) {
            if (livro != null && livro.getAutor().equalsIgnoreCase(autor)) {
                livro.exibirInfo();
            }
        }
    }

    public void emprestar(String titulo, Usuario usuario) {
        for (Livro livro : livros) {
            if (livro != null && livro.getTitulo().equals(titulo) && livro.getQuantidadeEmEstoque() > 0) {
                if (usuario.adicionarLivro(livro)) {
                    livro.emprestar();
                    System.out.println("Livro emprestado para " + usuario.getClass().getSimpleName() + ": " + usuario.getNome());
                }
                return;
            }
        }
        System.out.println("Livro não disponível para empréstimo: " + titulo);
    }

    public void devolver(String titulo, Usuario usuario) {
        for (Livro livro : livros) {
            if (livro != null && livro.getTitulo().equals(titulo) && usuario.removerLivro(livro)) {
                livro.devolver();
                System.out.println("Livro devolvido: " + titulo);
                return;
            }
        }
        System.out.println("Livro não encontrado para devolução: " + titulo);
    }

    public void exibirInfo() {
        System.out.println("Biblioteca: " + nome + ", Endereço: " + endereco);
        System.out.println("Livros disponíveis:");
        for (int i = 0; i < quantidadeLivros; i++) {
            livros[i].exibirInfo();
        }
    }
}
