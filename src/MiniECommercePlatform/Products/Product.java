package MiniECommercePlatform.Products;

import java.util.ArrayList;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class Product {
    private final ArrayList<Review> reviews = new ArrayList<>();
    private static final AtomicInteger counter = new AtomicInteger(0);
    private final String id;
    private final String name;
    private double price;
    private int quantity;

    public Product(String name, double price, int Quantity) {
        this.id = String.format("PRD-%04d", counter.incrementAndGet());
        this.name = name;
        this.price = price;
        this.quantity = Quantity;
    }


    public void addReview(Review review) {
        reviews.add(review);
    }

    public void showReviews() {
        if (reviews.isEmpty()) {
            System.out.println("No reviews yet");
            return;
        }
        for (Review r : reviews) {
            System.out.println(r);
        }
    }

    public Product(Product other) {
        this.id = other.id;
        this.name = other.name;
        this.price = other.price;
        this.quantity = 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }


    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getStock() {
        return quantity;
    }


    abstract public String getCategory();

    public abstract Product copy();


    public void setPrice(double price) {
        this.price = price;
    }

    public void reduceStock(int amount) {
        this.quantity -= amount;
    }

    public void incrementStock(int amount) {
        this.quantity += amount;
    }


    @Override
    public String toString() {
        return "Product{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                '}';
    }
}
