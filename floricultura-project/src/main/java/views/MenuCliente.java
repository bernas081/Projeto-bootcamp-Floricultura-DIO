package views;

import controllers.ClienteController;
import java.util.Scanner;

public class MenuCliente {
    public void mostrarMenuCliente(Scanner scanner, ClienteController clienteController) {
        int clienteOption;
        do {
            System.out.println("===== Menu Cliente =====");
            System.out.println("1. Criar Cliente");
            System.out.println("2. Buscar Cliente por Id");
            System.out.println("3. Alterar Cliente");
            System.out.println("4. Ver Clientes Cadastrados");
            System.out.println("5. Deletar Cliente");
            System.out.println("6. Voltar ao menu principal");
            System.out.print("Escolha uma opção: ");

            clienteOption = scanner.nextInt();

            switch (clienteOption) {
                case 1:
                    clienteController.criarCliente();
                    break;
                case 2:
                    clienteController.buscarClientePorId();
                    break;
                case 3:
                    clienteController.alterarCliente();
                    break;
                case 4:
                    clienteController.listarTodosClientes();
                    break;
                case 5:
                    clienteController.removerCliente();
                    break;
                case 6:
                    System.out.println("Voltando ao menu principal...");
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        } while (clienteOption != 6);
    }
}
