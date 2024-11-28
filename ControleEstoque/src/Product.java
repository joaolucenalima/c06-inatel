public abstract class Product {
    private int id;
    private String name;
    private double price;
    private int quantity;

    public Product(int id, String name, double price, int quantity) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public abstract String getCategory();

    public void applyDiscount(int percentage) {
        price -= price * percentage / 100;

        System.out.println("Desconto aplicado com sucesso! Novo preço: R$" + price);
    }

    public void addQuantity(int quantity) {
        this.quantity += quantity;
    }

    public void removeQuantity(int quantity) {
        if (this.quantity >= quantity) {
            this.quantity -= quantity;
        } else {
            System.out.println("Quantidade em estoque insuficiente para remover " + quantity + " produtos.");
        }
    }
}
