package controllers;

import interfaces.iClienteController;
import models.Cliente;
import repositories.ClienteRepository;

import java.util.List;
import java.util.Scanner;

public class ClienteController implements iClienteController {

    private final ClienteRepository clienteRepository = new ClienteRepository();
    private final Scanner input = new Scanner(System.in);
    private List<Cliente> clientesCache;

    public ClienteController() {
        this.clientesCache = clienteRepository.findAll();
    }

    @Override
    public void criarCliente() {
        System.out.println("Digite o tipo de cliente: ");
        System.out.println("1 - Pessoa Física");
        System.out.println("2 - Pessoa Jurídica");
        int tipo = input.nextInt();

        if (tipo == 1) {
            System.out.print("Digite o nome do cliente: ");
            input.nextLine();
            String nome = input.nextLine();

            System.out.print("Digite a idade do cliente: ");
            String idade = input.nextLine();

            System.out.print("Digite o CPF do cliente: ");
            String cpf = input.nextLine();

            System.out.print("Digite o telefone do cliente: ");
            String telefone = input.nextLine();

            Cliente cliente = new Cliente(nome, idade, cpf, telefone);
            clienteRepository.save(cliente);
            clientesCache.add(cliente);
            System.out.println("Cliente (Pessoa Física) criado com sucesso!");

        } else if (tipo == 2) {
            System.out.print("Digite o nome do cliente: ");
            input.nextLine();
            String nome = input.nextLine();

            System.out.print("Digite o CNPJ do cliente: ");
            String cnpj = input.nextLine();

            System.out.print("Digite a razão social do cliente: ");
            String razaoSocial = input.nextLine();

            Cliente cliente = new Cliente(nome, cnpj, razaoSocial);
            clienteRepository.save(cliente);
            clientesCache.add(cliente);
            System.out.println("Cliente (Pessoa Jurídica) criado com sucesso!");
        } else {
            System.out.println("Opção inválida.");
        }
    }

    @Override
    public void alterarCliente() {
        System.out.print("Digite o ID do cliente a ser alterado: ");
        int id = input.nextInt();

        Cliente cliente = clienteRepository.findById(id);

        if (cliente != null) {
            System.out.println("Cliente encontrado: ");
            cliente.exibirCliente();

            System.out.print("Digite o novo nome (ou pressione Enter para manter o atual): ");
            input.nextLine();
            String novoNome = input.nextLine();
            if (!novoNome.isEmpty()) {
                cliente.setNome(novoNome);
            }

            if (cliente.getCpf() != null) {
                System.out.print("Digite a nova idade (ou pressione Enter para manter a atual): ");
                String novaIdade = input.nextLine();
                if (!novaIdade.isEmpty()) {
                    cliente.setIdade(novaIdade);
                }

                System.out.print("Digite o novo CPF (ou pressione Enter para manter o atual): ");
                String novoCpf = input.nextLine();
                if (!novoCpf.isEmpty()) {
                    cliente.setCpf(novoCpf);
                }

                System.out.print("Digite o novo telefone (ou pressione Enter para manter o atual): ");
                String novoTelefone = input.nextLine();
                if (!novoTelefone.isEmpty()) {
                    cliente.setTelefone(novoTelefone);
                }
            } else if (cliente.getCnpj() != null) {
                System.out.print("Digite o novo CNPJ (ou pressione Enter para manter o atual): ");
                String novoCnpj = input.nextLine();
                if (!novoCnpj.isEmpty()) {
                    cliente.setCnpj(novoCnpj);
                }

                System.out.print("Digite a nova razão social (ou pressione Enter para manter a atual): ");
                String novaRazaoSocial = input.nextLine();
                if (!novaRazaoSocial.isEmpty()) {
                    cliente.setRazaoSocial(novaRazaoSocial);
                }
            }

            clienteRepository.save(cliente);
            clientesCache = clienteRepository.findAll();
            System.out.println("Cliente atualizado com sucesso!");
        } else {
            System.out.println("Cliente não encontrado.");
        }
    }

    @Override
    public void removerCliente() {
        System.out.print("Digite o ID do cliente a remover: ");
        int id = input.nextInt();

        Cliente cliente = clienteRepository.findById(id);
        if (cliente != null) {
            clienteRepository.remove(cliente);
            clientesCache.remove(cliente);
            System.out.println("Cliente removido com sucesso!");
        } else {
            System.out.println("Cliente não encontrado.");
        }
    }

    @Override
    public List<Cliente> listarTodosClientes() {
        clientesCache = clienteRepository.findAll();
        for (Cliente cliente : clientesCache) {
            cliente.exibirCliente();
        }
        return clientesCache;
    }

    public void buscarClientePorId() {
        System.out.print("Digite o ID do cliente: ");
        int id = input.nextInt();
        Cliente cliente = clienteRepository.findById(id);
        if (cliente != null) {
            cliente.exibirCliente();
        } else {
            System.out.println("Cliente não encontrado.");
        }
    }

    public List<Cliente> getClientes() {
        if (clientesCache.isEmpty()) {
            clientesCache = clienteRepository.findAll();
        }
        return clientesCache;
    }
}
