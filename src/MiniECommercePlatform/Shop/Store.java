package MiniECommercePlatform.Shop;

import MiniECommercePlatform.Exceptions.DuplicateProductException;
import MiniECommercePlatform.Exceptions.EcommerceExceptions;
import MiniECommercePlatform.Exceptions.ExpiredFoodException;
import MiniECommercePlatform.Exceptions.OutOfStockException;
import MiniECommercePlatform.Products.Food;
import MiniECommercePlatform.Products.Product;

import java.util.ArrayList;

public class Store {
    private final ArrayList<Product> products = new ArrayList<>();

    public void addProduct(Product p) throws EcommerceExceptions {
        if (p == null) throw new EcommerceExceptions("Product cannot be null");
        if (p instanceof Food && ((Food) p).isExpired()) throw new ExpiredFoodException(p.getName());

        for (Product item : products) {
            if (item.getId().equals(p.getId())) {
                throw new DuplicateProductException("Product already exists in store!");
            }
        }
        products.add(p);
    }


    public Product getProduct(Product p, int quantity) throws EcommerceExceptions {
        if (p == null) throw new EcommerceExceptions("Product cannot be null");
        for (Product item : products) {
            if (item.getId().equals(p.getId())) {
                checkStock(item, quantity);
                return item;
            }
        }
        return null;
    }


    private void checkStock(Product product, int quantity) throws EcommerceExceptions {
        if (product.getStock() == 0) {
            removeOutOfStockProduct(product);
            throw new OutOfStockException("No more: " + product.getName());
        }
        if (product.getStock() - quantity < 0) throw new EcommerceExceptions("Not enough " + product.getName());
    }

    public void removeExpiredProduct(Product food) {
        for (Product item : products) {
            if (item.getId().equals(food.getId()) && ((Food) item).isExpired()) {
                products.remove(item);
                return;
            }
        }
    }

    public void removeOutOfStockProduct(Product p) {
        for (Product item : products) {
            if (item.getId().equals(p.getId()) && item.getStock() <= 0) {
                products.remove(item);
                return;
            }
        }
    }

    public void printProducts() {
        for (Product product : products) {
            System.out.printf("Product Id: %s ; Product Name: %s ; products Price : %.1f ; Product Quantity: %d%n"
                    , product.getId(), product.getName(), product.getPrice(), product.getStock());
        }
    }

    public void removeProduct(Product p) {
        for (Product item : products) {
            if (item.getId().equals(p.getId())) {
                products.remove(item);
                return;
            }

        }

    }
}
