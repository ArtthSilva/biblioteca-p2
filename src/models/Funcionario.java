package models;

abstract class Funcionario implements Pessoa {
    private String nome;
    private int id;

    public Funcionario(String nome, int id) {
        this.nome = nome;
        this.id = id;
    }
    @Override
    public String getNome() {
        return nome;
    }

    @Override
    public int getId() {
        return id;
    }

}