package views;

import controllers.ClienteController;
import controllers.CaixaController;
import controllers.FloresController;

import java.util.Scanner;

public class Menu {
    public void mostrarMenu() {
        Scanner scanner = new Scanner(System.in);
        int option;

        CaixaController caixaController = new CaixaController();
        MenuCaixa menuCaixa = new MenuCaixa();

        ClienteController clienteController = new ClienteController();
        MenuCliente menuCliente = new MenuCliente();

        FloresController floresController = new FloresController();
        MenuFlores menuFlores = new MenuFlores();

        do {
            System.out.println("===== MENU =====");
            System.out.println("1. Cliente");
            System.out.println("2. Flores");
            System.out.println("3. Caixa");
            System.out.println("4. Sair");
            System.out.print("Escolha uma opção: ");

            option = scanner.nextInt();

            switch (option) {
                case 1:
                    menuCliente.mostrarMenuCliente(scanner, clienteController);
                    break;

                case 2:
                    menuFlores.mostrarMenuFlores(scanner, floresController);
                    break;

                case 3:
                    menuCaixa.mostrarMenuCaixa(scanner, caixaController);
                    break;

                case 4:
                    System.out.println("Saindo...");
                    break;

                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }

        } while (option != 4);

        scanner.close();
    }
}
