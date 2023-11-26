import controllers.BibliotecaController;
import views.BibliotecaView;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        BibliotecaController controller = new BibliotecaController();
        BibliotecaView view = new BibliotecaView();
        Scanner scanner = new Scanner(System.in);
        Scanner scanner2 = new Scanner(System.in);


        int opcao;
        do {
            System.out.println("Escolha uma opção:");
            System.out.println("1 - Adicionar cliente");
            System.out.println("2 - Adicionar livro");
            System.out.println("3 - Adicionar funcionário");
            System.out.println("4 - Emprestar livro");
            System.out.println("5 - Sair");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.println("Digite o nome do cliente:");
                    String nomeCliente = scanner2.nextLine();
                    controller.adicionarCliente(nomeCliente);
                    break;
                case 2:
                    System.out.println("Digite o título do livro:");
                    String tituloLivro = scanner2.nextLine();
                    controller.adicionarLivro(tituloLivro);
                    break;
                case 3:
                    int idadeFuncionario;
                    do {
                        System.out.println("Digite a idade do funcionário:");
                        idadeFuncionario = scanner.nextInt();
                        if (idadeFuncionario < 18) {
                            System.out.println("A idade mínima é 18 anos. Por favor, insira a idade novamente.");
                        }
                    } while (idadeFuncionario < 18);

                    System.out.println("Digite o CPF do funcionário (apenas números):");
                    int cpfFuncionario = scanner.nextInt();
                    System.out.println("Digite o nome do funcionário:");
                    String nomeFuncionario = scanner2.nextLine(); // Use nextLine aqui
                    controller.adicionarFuncionario(idadeFuncionario, cpfFuncionario, nomeFuncionario);
                    break;
                case 4:
                    System.out.println("Digite o ID do livro:");
                    int idLivro = scanner.nextInt();
                    System.out.println("Digite o ID do cliente:");
                    int idCliente = scanner.nextInt();
                    controller.emprestarLivro(idLivro, idCliente);
                    break;
                case 5:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }


        } while (opcao != 5);
        view.mostrarClientesComLivrosEmprestados(controller.getClientes());
        view.mostrarLivros(controller.getLivros());
        view.mostrarFuncionarios(controller.getAtendentes());
    }
}