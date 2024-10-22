package exercicioAbstract;

public class Main {

  public static void main(String args[]) {
    Mamifero cachorro = new Cachorro("Dobby", 100);
    Mamifero lontra = new Lontra("Lontrinha", 100);
    Mamifero boi = new Boi("Ben", 100);

    cachorro.EmitirSom();
    lontra.EmitirSom();
    boi.EmitirSom();

    cachorro.MostraInfo();
    lontra.MostraInfo();
    boi.MostraInfo();

  }

}
