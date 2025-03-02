package models;

import jakarta.persistence.*;

@Table(name = "cliente")
@Entity
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "idade")
    private String idade;

    @Column(name = "cpf")
    private String cpf;

    @Column(name = "telefone")
    private String telefone;

    @Column(name = "cnpj")
    private String cnpj;

    @Column(name = "razao_social")
    private String razaoSocial;

    public Cliente(String nome, String idade, String cpf, String telefone) {
        this.nome = nome;
        this.idade = idade;
        this.cpf = cpf;
    }

    public Cliente(String nome, String cnpj, String razaoSocial) {
        this.nome = nome;
        this.cnpj = cnpj;
        this.razaoSocial = razaoSocial;
    }

    public Cliente() {
    }

    // Getters e Setters
    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getIdade() {
        return idade;
    }

    public void setIdade(String idade) {
        this.idade = idade;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void exibirCliente() {
        System.out.println("ID: " + this.Id);
        System.out.println("Nome: " + this.nome);

        if (cpf != null) {
            System.out.println("Idade: " + this.idade);
            System.out.println("CPF: " + this.cpf);
        } else if (cnpj != null) {
            System.out.println("CNPJ: " + this.cnpj);
            System.out.println("Razão Social: " + this.razaoSocial);
        }

        System.out.println("-----------------------------");
    }
}
