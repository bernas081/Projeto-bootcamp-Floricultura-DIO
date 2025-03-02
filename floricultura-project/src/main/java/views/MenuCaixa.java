package views;

import controllers.CaixaController;
import java.util.Scanner;

public class MenuCaixa {
    public void mostrarMenuCaixa(Scanner scanner, CaixaController caixaController) {
        int caixaOption;
        do {
            System.out.println("===== Menu Caixa =====");
            System.out.println("1. Registrar Entrada");
            System.out.println("2. Registrar Saída");
            System.out.println("3. Ver Fatura");
            System.out.println("4. Voltar ao menu principal");
            System.out.print("Escolha uma opção: ");

            caixaOption = scanner.nextInt();

            switch (caixaOption) {
                case 1:
                    System.out.print("Digite o valor da entrada (pagamento): R$ ");
                    double valorEntrada = scanner.nextDouble();
                    scanner.nextLine();

                    System.out.print("Digite a descrição da entrada: ");
                    String descricaoEntrada = scanner.nextLine();

                    System.out.print("Digite a forma de pagamento (ex: Dinheiro, Cartão): ");
                    String formaPagamentoEntrada = scanner.nextLine();

                    caixaController.entradaDeSaldo(valorEntrada, descricaoEntrada, formaPagamentoEntrada);
                    break;

                case 2:
                    System.out.print("Digite o valor da saída (despesa): R$ ");
                    double valorSaida = scanner.nextDouble();
                    scanner.nextLine();

                    System.out.print("Digite a descrição da saída: ");
                    String descricaoSaida = scanner.nextLine();

                    System.out.print("Digite a forma de pagamento (ex: Dinheiro, Cartão): ");
                    String formaPagamentoSaida = scanner.nextLine();

                    caixaController.saidaDeSaldo(valorSaida, descricaoSaida, formaPagamentoSaida);
                    break;

                case 3:
                    caixaController.exibirFaturamento();
                    break;

                case 4:
                    System.out.println("Voltando ao menu principal...");
                    break;

                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        } while (caixaOption != 4);
    }
}
