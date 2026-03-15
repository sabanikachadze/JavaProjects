package MiniECommercePlatform.Users;

import MiniECommercePlatform.Exceptions.EcommerceExceptions;
import MiniECommercePlatform.Exceptions.UnauthorizedActionException;
import MiniECommercePlatform.Interfaces.AuthenticAble;
import MiniECommercePlatform.Products.Product;
import MiniECommercePlatform.Shop.Store;

public class Admin extends User implements AuthenticAble {

    public Admin(String name, String email, String password) {
        super( name, email, password);
    }

    public void addProduct(Store store, Product p) throws EcommerceExceptions {
        if (!isLoggedIn())
            throw new UnauthorizedActionException("Login first");
        store.addProduct(p);
        System.out.println("Product added: " + p.getName());
    }

    public void removeProduct(Store store, Product p) throws EcommerceExceptions {
        if (!isLoggedIn())
            throw new UnauthorizedActionException("Login first");
        store.removeProduct(p);
        System.out.println("Product removed: " + p.getName());
    }


    public void banUser(UserStorage storage, User u) throws EcommerceExceptions {
        if (!isLoggedIn())
            throw new UnauthorizedActionException("Login first");
        storage.removeUser(u);
        System.out.println("User banned: " + u.getName());
    }

    public void addUser(UserStorage storage, User u) throws EcommerceExceptions {
        if (!isLoggedIn())
            throw new UnauthorizedActionException("Login first");
        storage.addUser(u);
        System.out.println("User added: " + u.getName());
    }
}
