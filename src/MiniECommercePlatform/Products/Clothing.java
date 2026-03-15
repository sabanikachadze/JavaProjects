package MiniECommercePlatform.Products;

public class Clothing extends Product {

    public Clothing(String name, double price, int stock) {
        super(name, price, stock);
    }

    public Clothing(Clothing other) {
        super(other);
    }

    @Override
    public Product copy() {
        return new Clothing(this);
    }

    @Override
    public String getCategory() {
        return "Clothing";
    }
}
