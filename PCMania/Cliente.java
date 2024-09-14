public class Cliente {
  String nome;
  long cpf;
  int totalCompra = 0;

  public Cliente(String nome, long cpf) {
    this.nome = nome;
    this.cpf = cpf;
  }

  void compraComputador(Computador computador) {
    totalCompra += computador.preco;
  }

  void mostraTotalCompra() {
    System.out.println("O valor final de sua compra é de R$" + totalCompra);
  }

  void mostraClienteInfo() {
    System.out.println("Cliente: " + nome + " do CPF: " + cpf);
  }
}
