package MiniECommercePlatform.Products;

public class Electronics extends Product{

    public Electronics(String name, double price, int stock) {
        super(name , price, stock);
    }

    public Electronics(Electronics other) {
        super(other);
    }
    @Override
    public Product copy() {
        return new Electronics(this);
    }

    @Override
    public String getCategory() {
        return "Electronics";
    }
}
