package interfaces;

public interface ICaixaController {
    void entradaDeSaldo(double valor, String descricao, String formaPagamento);
    void saidaDeSaldo(double valor, String descricao, String formaPagamento);
    void exibirFaturamento();


}
