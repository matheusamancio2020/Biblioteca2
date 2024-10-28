package br.com.catolica.biblioteca.modelo;

public abstract class Usuario {
    protected String nome;
    protected String id;
    protected String email;
    protected Livro[] livrosEmPosse;
    protected int quantidadeLivrosEmPosse;

    public Usuario(String nome, String id, String email) {
        this.nome = nome;
        this.id = id;
        this.email = email;
        this.livrosEmPosse = new Livro[5];
        this.quantidadeLivrosEmPosse = 0;
    }


    public String getNome() {
        return nome;
    }

    public boolean adicionarLivro(Livro livro) {
        if (quantidadeLivrosEmPosse < livrosEmPosse.length) {
            livrosEmPosse[quantidadeLivrosEmPosse++] = livro;
            return true;
        } else {
            System.out.println("Limite de livros em posse atingido.");
            return false;
        }
    }

    public boolean removerLivro(Livro livro) {
        for (int i = 0; i < quantidadeLivrosEmPosse; i++) {
            if (livrosEmPosse[i].equals(livro)) {
                livrosEmPosse[i] = livrosEmPosse[--quantidadeLivrosEmPosse];
                livrosEmPosse[quantidadeLivrosEmPosse] = null;
                return true;
            }
        }
        return false;
    }

    public void exibirInfo() {
        System.out.println("Nome: " + nome + ", ID: " + id + ", Email: " + email);
    }
}
