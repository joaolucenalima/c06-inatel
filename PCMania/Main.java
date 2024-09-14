import java.util.Scanner;

public class Main {

  public static void main(String[] args) {

    Cliente cliente = new Cliente("João", 1112223339);
    int[] pcsComprados = new int[3];

    Scanner entrada = new Scanner(System.in);

    Computador[] computadores = new Computador[3];

    HardwareBasico[] hardwareComputador1 = new HardwareBasico[3];
    hardwareComputador1[0] = new HardwareBasico("Pentium Core i3", 2200);
    hardwareComputador1[1] = new HardwareBasico("Memória RAM", 8);
    hardwareComputador1[2] = new HardwareBasico("HD", 500);

    Computador computador1 = new Computador(
        "Positivo",
        386,
        hardwareComputador1,
        new SistemaOperacional("Linux Ubuntu", 32));
    computador1.addMemoriaUSB(new MemoriaUSB("Pen-drive", 16));

    HardwareBasico[] hardwareComputador2 = new HardwareBasico[3];
    hardwareComputador2[0] = new HardwareBasico("Pentium Core i5", 3370);
    hardwareComputador2[1] = new HardwareBasico("Memória RAM", 16);
    hardwareComputador2[2] = new HardwareBasico("HD", 1000);

    Computador computador2 = new Computador(
        "Acer",
        386 + 1234,
        hardwareComputador2,
        new SistemaOperacional("Windows 8", 64));
    computador2.addMemoriaUSB(new MemoriaUSB("Pen-drive", 32));

    HardwareBasico[] hardwareComputador3 = new HardwareBasico[3];
    hardwareComputador3[0] = new HardwareBasico("Pentium Core i7", 4500);
    hardwareComputador3[1] = new HardwareBasico("Memória RAM", 32);
    hardwareComputador3[2] = new HardwareBasico("HD", 2000);

    Computador computador3 = new Computador(
        "Vaio",
        386 + 5678,
        hardwareComputador3,
        new SistemaOperacional("Windows 10", 64));
    computador3.addMemoriaUSB(new MemoriaUSB("HD Externo", 1000));

    computadores[0] = computador1;
    computadores[1] = computador2;
    computadores[2] = computador3;

    for (Computador computador : computadores) {
      computador.mostraPCConfigs();
      System.out.println();
    }

    while (true) {
      System.out.println("Escolha o computador que deseja comprar:");
      System.out.println("Digite 1 para selecionar o computador da Promoção 1");
      System.out.println("Digite 2 para selecionar o computador da Promoção 2");
      System.out.println("Digite 3 para selecionar o computador da Promoção 3");
      System.out.println("Digite 0 para sair do menu de compras");

      int escolha = entrada.nextInt();

      switch (escolha) {
        case 0:
          System.out.println("Saindo do Menu de compras...");
          System.out.println();
          entrada.close();

          int qtdPc = 0;

          for (int i = 0; i < pcsComprados.length; i++) {
            if (pcsComprados[i] > 0) {
              System.out.println("Você comprou " + pcsComprados[i] + " computador(es) da Promoção " + (i + 1));
              qtdPc += pcsComprados[i];
            }
          }

          if (qtdPc == 0) {
            System.out.println("Você não comprou nenhum computador.");
          }

          cliente.mostraTotalCompra();
          cliente.mostraClienteInfo();
          return;

        case 1:
          System.out.println("Você escolheu a promoção 1");
          cliente.compraComputador(computador1);
          pcsComprados[0]++;
          break;

        case 2:
          System.out.println("Você escolheu a promoção 2");
          cliente.compraComputador(computador2);
          pcsComprados[1]++;
          break;

        case 3:
          System.out.println("Você escolheu a promoção 3");
          cliente.compraComputador(computador3);
          pcsComprados[2]++;
          break;

        default:
          System.out.println("Escolha uma opção válida");
      }
    }
  }
}
