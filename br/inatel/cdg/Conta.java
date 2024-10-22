package br.inatel.cdg;

public class Conta {
  private int numero;
  private float saldo;
  private float limite;

  private Cliente[] clientes;

  public Conta() {
    setClientes(new Cliente[5]);
  }

  public void Sacar(float quantia) {
    if (quantia <= this.saldo + this.limite) {
      this.saldo -= quantia;
    } else {
      System.out.println("Saldo insuficiente");
    }
  }

  public void Depositar(float quantia) {
    this.saldo += quantia;
  }

  public void setClientes(Cliente[] clientes) {
    this.clientes = clientes;
  }

  public Cliente[] getClientes() {
    return clientes;
  }

  public void setNumero(int numero) {
    this.numero = numero;
  }

  public int getNumero() {
    return numero;
  }

  public float getSaldo() {
    return saldo;
  }

  public void setSaldo(float saldo) {
    this.saldo = saldo;
  }

  public void setLimite(float limite) {
    this.limite = limite;
  }
}