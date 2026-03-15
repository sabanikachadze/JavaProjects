package MiniECommercePlatform.Users;

import MiniECommercePlatform.Exceptions.EcommerceExceptions;
import MiniECommercePlatform.Exceptions.UnauthorizedActionException;
import MiniECommercePlatform.Interfaces.AuthenticAble;
import MiniECommercePlatform.Products.Product;
import MiniECommercePlatform.Shop.Store;

import java.util.ArrayList;

public class Seller extends User implements AuthenticAble {
    private final ArrayList<Product> listedProducts = new ArrayList<>();

    public Seller(String name, String email, String password) {
        super(name, email, password);
    }


    public void listProduct(Store store, Product product) throws EcommerceExceptions {
        if (!isLoggedIn())
            throw new UnauthorizedActionException("Login first");

        store.addProduct(product);
        this.listedProducts.add(product);
        System.out.println(getName() + " listed: " + product.getName());
    }

    public void unlistProduct(Store store, Product product) throws EcommerceExceptions {
        if (!isLoggedIn())
            throw new UnauthorizedActionException("Login first");

        store.removeProduct(product);
        listedProducts.remove(product);
        System.out.println(getName() + " unlisted: " + product.getName());
    }

    public void showListedProducts() throws UnauthorizedActionException {
        if (!isLoggedIn())
            throw new UnauthorizedActionException("Login first");
        if (listedProducts.isEmpty()) {
            System.out.println("No products listed");
            return;
        }
        for (Product p : listedProducts) {
            System.out.println(p.toString());
        }
    }

}
