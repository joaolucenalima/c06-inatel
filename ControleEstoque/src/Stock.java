import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Stock {
    private List<Product> products;
    private double availableMoney;
    private final String fileName = "stock-products.txt";

    public Stock(double availableMoney) {
        this.products = new ArrayList<>();
        this.availableMoney = availableMoney;
        getProductsStock();
    }

    public List<Product> getProducts() {
        return products;
    }

    private void saveStockInFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write("money:" + availableMoney + "\n");
            for (Product item : products) {
                writer.write(
                        item.getId() + "," + item.getName() + "," + item.getCategory() + "," + item.getQuantity() + ","
                                + item.getPrice() + "\n");
            }
        } catch (IOException e) {
            System.out.println("Erro ao escrever item no arquivo: " + e.getMessage());
        }
    }

    private void getProductsStock() {
        File file = new File(fileName);
        if (!file.exists())
            return;

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line = reader.readLine();
            if (line.startsWith("money:")) {
                availableMoney = Double.parseDouble(line.split(":")[1]);
            }
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                int id = Integer.parseInt(parts[0]);
                String name = parts[1];
                String category = parts[2];
                int quantity = Integer.parseInt(parts[3]);
                double price = Double.parseDouble(parts[4]);

                if (category.equals("Electronics")) {
                    products.add(new Electronics(id, name, price, quantity));
                }

                if (category.equals("Food")) {
                    products.add(new Food(id, name, price, quantity));
                }
            }
        } catch (IOException e) {
            System.out.println("Erro ao ler dados de estoque do arquivo 'stock-products.txt': " + e.getMessage());
        }
    }

    public void displayStock() {
        System.out.println("Saldo disponível: R$" + availableMoney);
        for (Product item : products) {
            System.out.println(
                    item.getId() + " - " +
                            item.getName() + " - " +
                            item.getCategory() +
                            " - Quantidade em estoque: " + item.getQuantity() +
                            " - Preço unitário: R$" + item.getPrice());
        }
    }

    public Product findItem(int id) {
        for (Product item : products) {
            if (item.getId() == id) {
                return item;
            }
        }
        return null;
    }

    public void apllyDiscount(int id, int percentage) {
        Product item = findItem(id);
        if (item != null) {
            item.applyDiscount(percentage);
            saveStockInFile();
        } else {
            System.out.println("Produto não encontrado.");
        }
    }

    public void addItem(Product item) {
        int quantity = item.getQuantity();
        double cost = item.getPrice() * quantity;
        if (availableMoney >= cost) {
            availableMoney -= cost;
            Product existingItem = findItem(item.getId());
            if (existingItem != null) {
                existingItem.addQuantity(quantity);
            } else {
                products.add(item);
            }
            saveStockInFile();
        } else {
            System.out.println("Saldo insuficiente para comprar " + quantity + " " + item.getName());
        }
    }

    public void sellItem(int id, int quantity) {
        Product item = findItem(id);

        if (item != null && item.getQuantity() >= quantity) {
            double newMoney = item.getPrice() * quantity;
            item.removeQuantity(quantity);
            availableMoney += newMoney;

            if (item.getQuantity() == 0) {
                products.remove(item);
            }
            saveStockInFile();
        } else {
            System.out.println("Estoque insuficiente para vender " + quantity + " produtos.");
        }
    }
}