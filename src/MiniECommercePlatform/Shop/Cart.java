package MiniECommercePlatform.Shop;

import MiniECommercePlatform.Exceptions.EcommerceExceptions;
import MiniECommercePlatform.Exceptions.ExpiredFoodException;
import MiniECommercePlatform.Exceptions.InvalidDiscountException;
import MiniECommercePlatform.Products.Food;
import MiniECommercePlatform.Products.Product;
import MiniECommercePlatform.Users.Customer;

import java.util.ArrayList;

public class Cart {
    private final Customer owner;
    private final ArrayList<Product> products = new ArrayList<>();
    private double discountPercent = 0.0;

    public Cart(Customer customer) {
        this.owner = customer;
    }

    public void addProduct(Store store, Product p, int quantity) throws EcommerceExceptions {
        Product product = store.getProduct(p, quantity);
        if (product == null) throw new EcommerceExceptions("Product doesn't exist inside store");
        if (product instanceof Food && ((Food) product).isExpired()) {
            store.removeExpiredProduct(product);
            throw new ExpiredFoodException(p.getName());
        }

        for (Product item : products) {
            if (item.getId().equals(p.getId())) {
                product.reduceStock(quantity);
                item.incrementStock(quantity);
                if (product.getStock() == 0) store.removeOutOfStockProduct(product);
                return;
            }
        }

        product.reduceStock(quantity);
        Product newProduct = product.copy();
        newProduct.incrementStock(quantity);
        products.add(newProduct);
    }

    public void removeProduct(Store store, Product product) throws EcommerceExceptions {
        Product p = store.getProduct(product, 0);
        if (p == null) {
            for (Product item : products) {
                if (item.getId().equals(product.getId())) {
                    store.addProduct(item);
                    products.remove(item);
                    return;
                }
            }
        }

        for (Product item : products) {
            if (item.getId().equals(product.getId())) {
                store.getProduct(item, 0).incrementStock(item.getStock());
                products.remove(item);
                return;
            }
        }
        throw new EcommerceExceptions("Product doesn't exist in Cart!");
    }

    public double calculateTotal() {
        double total = 0;

        for (Product product : products) {
            total += (product.getPrice() * product.getStock());
        }

        return total * (1 - discountPercent / 100);
    }

    public void applyDiscount(double percent) throws EcommerceExceptions {
        if (percent < 0 || percent > 100)
            throw new InvalidDiscountException("Discount must be between 0 and 100");
        this.discountPercent = percent;
    }

    public Order checkout(Customer customer) throws EcommerceExceptions {
        if (products.isEmpty())
            throw new EcommerceExceptions("Cart is empty");

        double total = calculateTotal();
        Order order = new Order(customer, new ArrayList<>(products), total);
        products.clear();
        discountPercent = 0.0;
        return order;
    }


    public void printProducts() {
        for (Product product : products) {
            System.out.printf("Product Id: %s ; Product Name: %s ; products Price : %.1f ; Product Quantity: %d%n"
                    , product.getId(), product.getName(), product.getPrice(), product.getStock());
        }
    }

}
