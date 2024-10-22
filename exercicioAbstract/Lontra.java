package exercicioAbstract;

public class Lontra extends Mamifero {

  public Lontra(String nome, double vida) {
    super(nome, vida);
  }

  @Override
  public void EmitirSom() {
    System.out.println("Som de lontra!");
  }
}
