package controllers;

import models.AtendenteModel;
import models.ClienteModel;

import models.LivroModel;
import views.BibliotecaView;

import java.util.ArrayList;
import java.util.List;

public class BibliotecaController {
    private List<ClienteModel> clienteModels;
    private List<AtendenteModel> funcionarioModels;
    private List<LivroModel> livros;
    private List<ClienteModel> clientesComLivrosEmprestados;
    private BibliotecaView view;

    public BibliotecaController() {
        this.clienteModels = new ArrayList<>();
        this.livros = new ArrayList<>();
        this.clientesComLivrosEmprestados = new ArrayList<>();
        this.view = new BibliotecaView();
        this.funcionarioModels = new ArrayList<>();
    }


    public void adicionarCliente(String nome) {
        int novoId = clienteModels.size() +1;
        ClienteModel novoClienteModel = new ClienteModel(nome, novoId);
        clienteModels.add(novoClienteModel);
    }

    public void adicionarFuncionario(int idade, int cpf, String nome) {
        int novoId = funcionarioModels.size() +1;
        AtendenteModel novoFuncionarioModel = new AtendenteModel(idade, cpf, nome, novoId);
        funcionarioModels.add(novoFuncionarioModel);
    }

    public void adicionarLivro(String titulo) {
        int novoId = livros.size() + 1;
        LivroModel novoLivro = new LivroModel(titulo, novoId);
        livros.add(novoLivro);
    }

    public void emprestarLivro(int idLivro, int idCliente) {
        LivroModel livro = procurarLivroPorId(idLivro);
        ClienteModel clienteModel = procurarClientePorId(idCliente);

        if (livro != null && clienteModel != null && !livro.isEmprestado()) {
            livro.emprestar();
            clientesComLivrosEmprestados.add(clienteModel);
        }
    }

    public List<LivroModel> getLivros() {
        return this.livros;
    }

    public List<ClienteModel> getClientesComLivrosEmprestados() {
        return this.clientesComLivrosEmprestados;
    }

    public List<ClienteModel> getClientes(){return this.clienteModels;}

    public List<AtendenteModel> getAtendentes(){return this.funcionarioModels;}

    private LivroModel procurarLivroPorId(int id) {
        return livros.stream().filter(livro -> livro.getId() == id).findFirst().orElse(null);
    }

    private ClienteModel procurarClientePorId(int id) {
        return clienteModels.stream().filter(clienteModel -> clienteModel.getId() == id).findFirst().orElse(null);
    }

    private AtendenteModel procurarFuncionarioPorId(int id) {
        return funcionarioModels.stream().filter(funcionarioModel -> funcionarioModel.getId() == id).findFirst().orElse(null);
    }
}
