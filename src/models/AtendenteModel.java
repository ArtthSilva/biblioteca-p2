package models;

 abstract class Funcionario {
    private String nome;
    private int id;

    public Funcionario(String nome, int id) {
        this.nome = nome;
        this.id = id;
    }

     public String getNome() {
         return nome;
     }
     public int getId() {
         return id;
     }

 }

public class AtendenteModel extends Funcionario{
     private int idade;
     private int cpf;

    public AtendenteModel(int idade, int cpf, String nome, int id) {
        super(nome, id);
    }

}