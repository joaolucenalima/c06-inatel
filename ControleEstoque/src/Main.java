import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Stock stock = new Stock(10000);

        Scanner scanner = new Scanner(System.in);
        stock.displayStock();

        int option = 0;

        System.out.println("Olá, seja bem vindo ao sistema de gerenciamento de estoque!");

        while (option != 5) {
            System.out.println("\nQue operação deseja realizar?");

            System.out.println("1 - Adicionar produto");
            System.out.println("2 - Registrar uma venda");
            System.out.println("3 - Aplicar desconto");
            System.out.println("4 - Exibir estoque");
            System.out.println("5 - Sair");

            option = scanner.nextInt();

            switch (option) {
                case 1:
                    System.out.println("Digite o id do produto:");
                    int id = scanner.nextInt();

                    System.out.println("Digite o nome do produto:");
                    String name = scanner.next();

                    System.out.println("Digite o preço do produto:");
                    double price = scanner.nextDouble();

                    System.out.println("Escolha a categoria do produto:");
                    System.out.println("1 - Eletrônicos");
                    System.out.println("2 - Alimentos");
                    int categoryNumber = scanner.nextInt();

                    String category = categoryNumber == 1 ? "Electronics" : "Food";

                    System.out.println("Digite a quantidade que vai adicionar ao estoque:");
                    int quantity = scanner.nextInt();

                    if (category.equals("Electronics")) {
                        stock.addItem(new Electronics(id, name, price, quantity));
                    }

                    if (category.equals("Food")) {
                        stock.addItem(new Food(id, name, price, quantity));
                    }

                    break;
                case 2:
                    System.out.println("Digite o id do produto:");
                    id = scanner.nextInt();

                    System.out.println("Digite a quantidade que deseja vender:");
                    int quantityToSell = scanner.nextInt();

                    stock.sellItem(id, quantityToSell);
                    break;
                case 3:
                    System.out.println("Digite o id do produto:");
                    id = scanner.nextInt();

                    System.out.println("Digite o desconto a ser aplicado:");
                    int discount = scanner.nextInt();

                    stock.apllyDiscount(id, discount);
                    break;
                case 4:
                    stock.displayStock();
                    break;
                case 5:
                    System.out.println("Obrigado por utilizar o sistema de gerenciamento de estoque!");
                    break;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        }
        scanner.close();
    }

}