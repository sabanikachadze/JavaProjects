package MiniECommercePlatform.Users;

import MiniECommercePlatform.Exceptions.EcommerceExceptions;
import MiniECommercePlatform.Exceptions.UnauthorizedActionException;
import MiniECommercePlatform.Interfaces.AuthenticAble;
import MiniECommercePlatform.Products.Product;
import MiniECommercePlatform.Interfaces.ReviewAble;
import MiniECommercePlatform.Products.Review;
import MiniECommercePlatform.Shop.Cart;
import MiniECommercePlatform.Shop.Order;
import MiniECommercePlatform.Shop.Store;

import java.util.ArrayList;

public class Customer extends User implements AuthenticAble, ReviewAble {
    private final Cart cart;
    private final ArrayList<Review> reviews = new ArrayList<>();
    private final ArrayList<Order> orders = new ArrayList<>();

    public Customer(String name, String email, String password) {
        super(name, email, password);
        this.cart = new Cart(this);
    }

    public void addToCart(Store store, Product p, int quantity) throws EcommerceExceptions {
        if (!isLoggedIn())
            throw new UnauthorizedActionException("Login first");

        cart.addProduct(store, p, quantity);
    }

    public void removeFromCart(Store store, Product product) throws EcommerceExceptions {
        if (!isLoggedIn())
            throw new UnauthorizedActionException("Login first");

        cart.removeProduct(store, product);
    }

    public void checkout() throws EcommerceExceptions {
        if (!isLoggedIn())
            throw new UnauthorizedActionException("Login first");
        Order order = cart.checkout(this);
        orders.add(order);
        System.out.println("Order placed! Total: $" + order.getTotal());
    }

    @Override
    public void leaveReview(Product p, String text, int rating) throws UnauthorizedActionException {
        if (!isLoggedIn())
            throw new UnauthorizedActionException("Login first");
        Review review = new Review(p, text, rating);
        p.addReview(review);
        reviews.add(review);
        System.out.println(getName() + " reviewed " + p.getName());
    }

    public void showOrderHistory() throws UnauthorizedActionException {
        if (!isLoggedIn())
            throw new UnauthorizedActionException("Login first");
        if (orders.isEmpty()) {
            System.out.println("No orders yet");
            return;
        }
        for (Order order : orders) {
            System.out.println(order);
        }
    }

    public Cart getCart() {
        return cart;
    }
}
