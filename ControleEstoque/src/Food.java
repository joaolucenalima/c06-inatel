public class Food extends Product {
    public Food(int id, String name, double price, int quantity) {
        super(id, name, price, quantity);
    }

    public String getCategory() {
        return "Alimento";
    }
}
