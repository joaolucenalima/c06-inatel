package br.inatel.cdg;

public class Main {
  public static void main(String[] args) {
    Cliente cliente1 = new Cliente();
    cliente1.setNome("João");
    cliente1.setCpf(12345678901L);

    Cliente cliente2 = new Cliente();
    cliente2.setNome("Maria");
    cliente2.setCpf(10987654321L);

    Conta conta = new Conta();
    conta.setNumero(123);
    conta.setClientes(new Cliente[] { cliente1, cliente2 });
    conta.setSaldo(1000);
    conta.setLimite(500);

    conta.Sacar(1500);
    conta.Sacar(500);
    conta.Depositar(200);

    System.out.println("Saldo: " + conta.getSaldo());
  }
}
