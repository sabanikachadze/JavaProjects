package MiniECommercePlatform.Products;

import java.time.LocalDate;

public class Food extends Product {
    private final LocalDate expiryDate;

    public Food(String name, double price, int stock, LocalDate expiryDate) {
        super(name, price, stock);
        this.expiryDate = expiryDate;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    public boolean isExpired() {
        return LocalDate.now().isAfter(expiryDate);
    }

    public Food(Food other) {
        super(other);
        this.expiryDate = other.expiryDate;
    }

    @Override
    public Product copy() {
        return new Food(this); // ✅ this is Food, matches Food(Food other)
    }

    @Override
    public String getCategory() {
        return "Food";
    }
}
