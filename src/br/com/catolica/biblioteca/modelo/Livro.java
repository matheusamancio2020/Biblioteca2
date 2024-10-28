package br.com.catolica.biblioteca.modelo;

public class Livro {
    private String titulo;
    private String autor;
    private String isbn;
    private int anoPublicacao;
    private int quantidadeEmEstoque;

    public Livro(String titulo, String autor, String isbn, int anoPublicacao, int quantidadeEmEstoque) {
        this.titulo = titulo;
        this.autor = autor;
        this.isbn = isbn;
        this.anoPublicacao = anoPublicacao;
        this.quantidadeEmEstoque = quantidadeEmEstoque;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public int getQuantidadeEmEstoque() {
        return quantidadeEmEstoque;
    }

    public void emprestar() {
        if (quantidadeEmEstoque > 0) {
            quantidadeEmEstoque--;
        }
    }

    public void devolver() {
        quantidadeEmEstoque++;
    }

    public void exibirInfo() {
        System.out.println("Título: " + titulo + ", Autor: " + autor + ", ISBN: " + isbn +
                ", Ano: " + anoPublicacao + ", Quantidade em Estoque: " + quantidadeEmEstoque);
    }
}
