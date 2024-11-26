import java.io.*;
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

    public void displayStock() {
        System.out.println("Saldo disponível: R$" + availableMoney);
        for (Product item : products) {
            System.out.println(item.getName() + " - " + item.getCategory() + " - Quantidade em estoque: " + item.getQuantity() +
                    " - Preço unitário: R$" + item.getPrice());
        }
    }

    private void saveStockInFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write("money:" + availableMoney + "\n");
            for (Product item : products) {
                writer.write(item.getName() + "," + item.getCategory() + "," + item.getQuantity() + "," + item.getPrice() + "\n");
            }
        } catch (IOException e) {
            System.out.println("Erro ao escrever item no arquivo: " + e.getMessage());
        }
    }

    private void getProductsStock() {
        File file = new File(fileName);
        if (!file.exists()) return;

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line = reader.readLine();
            if (line.startsWith("money:")) {
                availableMoney = Double.parseDouble(line.split(":")[1]);
            }
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                String id = parts[0];
                String name = parts[1];
                double price = Double.parseDouble(parts[2]);
                String category = parts[3];
                int quantity = Integer.parseInt(parts[4]);

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

    public void buyItem(Product item, int quantity) {
        double cost = item.getPrice() * quantity;
        if (availableMoney >= cost) {
            availableMoney -= cost;
            Product existingItem = findItem(item.getName());
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

    public void sellItem(String name, int quantity) {
        Product item = findItem(name);

        if (item != null && item.getQuantity() >= quantity) {
            double newMoney = item.getPrice() * quantity;
            item.removeQuantity(quantity);
            availableMoney += newMoney;

            if (item.getQuantity() == 0) {
                products.remove(item);
            }
            saveStockInFile();
        } else {
            System.out.println("Estoque insuficiente para vender " + quantity + " " + name);
        }
    }

    public Product findItem(String name) {
        for (Product item : products) {
            if (item.getName().equals(name)) {
                return item;
            }
        }
        return null;
    }

}