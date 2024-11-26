public class Electronics extends Product {
    public Electronics(String id, String name, double price, int quantity) {
        super(id, name, price, quantity);
    }

    @Override
    public String getCategory() {
        return "Eletrônicos";
    }
}
