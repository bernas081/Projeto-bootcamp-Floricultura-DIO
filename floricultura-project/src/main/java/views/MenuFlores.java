package views;

import controllers.FloresController;
import java.util.Scanner;

public class MenuFlores {
    public void mostrarMenuFlores(Scanner scanner, FloresController floresController) {
        int floresOption;
        do {
            System.out.println("===== Menu Flores =====");
            System.out.println("1. Criar Flor");
            System.out.println("2. Buscar Flor por Id");
            System.out.println("3. Buscar Flor por Nome");
            System.out.println("4. Alterar Flor");
            System.out.println("5. Ver Flores Cadastradas");
            System.out.println("6. Deletar Flor");
            System.out.println("7. Voltar ao menu principal");
            System.out.print("Escolha uma opção: ");

            floresOption = scanner.nextInt();
            scanner.nextLine();

            switch (floresOption) {
                case 1:
                    floresController.criarFlores();
                    break;
                case 2:
                    floresController.buscarFloresPorId();
                    break;
                case 3:
                    floresController.buscarFloresPorNome();
                    break;
                case 4:
                    floresController.alterarFlores();
                    break;
                case 5:
                    floresController.listarTodasFlores();
                    break;
                case 6:
                    floresController.removerFlores();
                    break;
                case 7:
                    System.out.println("Voltando ao menu principal...");
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        } while (floresOption != 7);
    }
}
