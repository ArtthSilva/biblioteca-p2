package models;

public class ClienteModel implements Pessoa{
    private final String nome;
    private final int id;

    public ClienteModel(String nome, int id) {
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
