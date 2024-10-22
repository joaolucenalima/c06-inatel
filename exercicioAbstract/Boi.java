package exercicioAbstract;

public class Boi extends Mamifero {

  public Boi(String nome, double vida) {
    super(nome, vida);
  }

  @Override
  public void EmitirSom() {
    System.out.println("Muuuu!");
  }
  
}
