package models;

public class LivroModel implements Emprestavel{
    private String nome;
    private boolean emprestado;
    private int id;

    public LivroModel(String titulo, int id) {
        this.nome = titulo;
        this.id = id;
        this.emprestado = false;
    }
    @Override
    public void emprestar() {
        this.emprestado = true;
    }
    public String getNome() {
        return nome;
    }

    public boolean isEmprestado() {
        return emprestado;
    }

    public void setEmprestado(boolean emprestado) {
        this.emprestado = emprestado;
    }

    public int getId() {
        return id;
    }



}
