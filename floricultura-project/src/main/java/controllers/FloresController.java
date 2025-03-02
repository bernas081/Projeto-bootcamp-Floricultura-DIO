package controllers;

import models.Flores;
import repositories.FloresRepository;
import interfaces.IFloresController;
import java.util.List;
import java.util.Scanner;

public class FloresController implements IFloresController {

    private final FloresRepository floresRepository = new FloresRepository();
    private final Scanner input = new Scanner(System.in);
    private List<Flores> floresCache;

    public FloresController() {
        this.floresCache = floresRepository.findAll();
    }

    public void criarFlores() {
        System.out.print("Digite o nome da flor: ");
        String nome = input.nextLine();

        System.out.print("Digite o preço da flor: ");
        double preco = input.nextDouble();

        System.out.print("Digite a quantidade da flor: ");
        int quantidade = input.nextInt();
        input.nextLine();

        Flores flores = new Flores();
        flores.setNome(nome);
        flores.setPreco(preco);
        flores.setQuantidade(quantidade);

        floresRepository.save(flores);
        floresCache.add(flores);
        System.out.println("Flor criada com sucesso!");
    }

    public void alterarFlores() {
        System.out.print("Digite o ID da flor a ser alterada: ");
        int id = input.nextInt();
        input.nextLine();

        Flores flores = floresRepository.findById(id);

        if (flores != null) {
            System.out.println("Flor encontrada: ");
            System.out.println("Nome: " + flores.getNome());
            System.out.println("Preço: " + flores.getPreco());
            System.out.println("Quantidade: " + flores.getQuantidade());

            System.out.print("Digite o novo nome (ou pressione Enter para manter o atual): ");
            String novoNome = input.nextLine();
            if (!novoNome.isEmpty()) {
                flores.setNome(novoNome);
            }

            System.out.print("Digite o novo preço (ou pressione Enter para manter o atual): ");
            String novoPreco = input.nextLine();
            if (!novoPreco.isEmpty()) {
                flores.setPreco(Double.parseDouble(novoPreco));
            }

            System.out.print("Digite a nova quantidade (ou pressione Enter para manter a atual): ");
            String novaQuantidade = input.nextLine();
            if (!novaQuantidade.isEmpty()) {
                flores.setQuantidade(Integer.parseInt(novaQuantidade));
            }

            floresRepository.save(flores);
            floresCache = floresRepository.findAll();
            System.out.println("Flor atualizada com sucesso!");
        } else {
            System.out.println("Flor não encontrada.");
        }
    }

    public void removerFlores() {
        System.out.print("Digite o ID da flor a remover: ");
        int id = input.nextInt();
        input.nextLine();

        Flores flores = floresRepository.findById(id);
        if (flores != null) {
            floresRepository.remove(flores);
            floresCache.remove(flores);
            System.out.println("Flor removida com sucesso!");
        } else {
            System.out.println("Flor não encontrada.");
        }
    }

    public List<Flores> listarTodasFlores() {
        floresCache = floresRepository.findAll();
        for (Flores flores : floresCache) {
            System.out.println("ID: " + flores.getId());
            System.out.println("Nome: " + flores.getNome());
            System.out.println("Preço: " + flores.getPreco());
            System.out.println("Quantidade: " + flores.getQuantidade());
            System.out.println("----------------------");
        }
        return floresCache;
    }

    public void buscarFloresPorId() {
        System.out.print("Digite o ID da flor: ");
        int id = input.nextInt();
        input.nextLine(); // Consumir a linha de quebra
        Flores flores = floresRepository.findById(id);
        if (flores != null) {
            System.out.println("Flor encontrada: ");
            System.out.println("Nome: " + flores.getNome());
            System.out.println("Preço: " + flores.getPreco());
            System.out.println("Quantidade: " + flores.getQuantidade());
        } else {
            System.out.println("Flor não encontrada.");
        }
    }


    public void buscarFloresPorNome() {
        System.out.print("Digite o nome da flor: ");
        String nome = input.nextLine();

        floresCache = floresRepository.findByName(nome);

        if (floresCache.isEmpty()) {
            System.out.println("Nenhuma flor encontrada com o nome: " + nome);
        } else {
            System.out.println("Flores encontradas com o nome " + nome + ":");
            for (Flores flores : floresCache) {
                System.out.println("ID: " + flores.getId());
                System.out.println("Nome: " + flores.getNome());
                System.out.println("Preço: " + flores.getPreco());
                System.out.println("Quantidade: " + flores.getQuantidade());
                System.out.println("----------------------");
            }
        }
    }

    public List<Flores> getFlores() {
        if (floresCache.isEmpty()) {
            floresCache = floresRepository.findAll();
        }
        return floresCache;
    }
}
