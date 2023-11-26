package models;
public class AtendenteModel extends Funcionario{
     private final int idade;
     private final int cpf;

    public AtendenteModel(int idade, int cpf, String nome, int id) {
        super(nome, id);
        this.idade = idade;
        this.cpf = cpf;
    }

}