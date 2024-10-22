package exercicioAbstract;

public class Cachorro extends Mamifero {

  public Cachorro(String nome, double vida) {
    super(nome, vida);
  }

  @Override
  public void EmitirSom() {
    System.out.println("Au au!");
  }
}
