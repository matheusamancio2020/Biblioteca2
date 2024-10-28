package br.com.catolica.biblioteca.modelo;

public class Professor extends Usuario {
    private String departamento;

    public Professor(String nome, String id, String email, String departamento) {
        super(nome, id, email);
        this.departamento = departamento;
    }

    @Override
    public void exibirInfo() {
        super.exibirInfo();
        System.out.println("Departamento: " + departamento);
    }
}
