public class Food extends Product {
    public Food(String id, String name, double price, int quantity) {
        super(id, name, price, quantity);
    }

    public String getCategory() {
        return "Alimento";
    }
}
