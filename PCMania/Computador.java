public class Computador {
  String marca;
  float preco;

  HardwareBasico[] hardwareBasico;
  MemoriaUSB memoriaUSB;
  SistemaOperacional sistemaOperacional;

  public Computador(
      String marca,
      float preco,
      HardwareBasico[] hardwareBasico,
      SistemaOperacional sistemaOperacional) {
    this.marca = marca;
    this.preco = preco;
    this.hardwareBasico = hardwareBasico;
    this.sistemaOperacional = sistemaOperacional;
  }

  void mostraPCConfigs() {
    System.out.println("Marca: " + marca);
    System.out.println("Preço: " + preco);
    for (HardwareBasico hardware : hardwareBasico) {
      System.out.println(hardware.nome + " (" + hardware.capacidade + " Mhz)");
    }
    System.out.println("Sistema Operacional: " + sistemaOperacional.nome);
    System.out.println(memoriaUSB.nome + " de " + memoriaUSB.capacidade + "Gb");
  }

  void addMemoriaUSB(MemoriaUSB musb) {
    memoriaUSB = musb;
  }
}