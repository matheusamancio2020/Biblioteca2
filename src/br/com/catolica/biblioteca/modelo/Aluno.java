package br.com.catolica.biblioteca.modelo;

public class Aluno extends Usuario {
    private String curso;

    public Aluno(String nome, String id, String email, String curso) {
        super(nome, id, email);
        this.curso = curso;
    }

    @Override
    public void exibirInfo() {
        super.exibirInfo();
        System.out.println("Curso: " + curso);
    }
}
