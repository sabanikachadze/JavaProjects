package Generics;

import java.util.ArrayList;
import java.util.List;

interface Entity {
    int getId();
}

public class Repository<T extends Entity> {
    private List<T> storage = new ArrayList<>();

    void save(T item) {
        storage.add(item);
    }

    T findById(int id) {
        for (T item : storage) {
            if (item.getId() == id) {
                return item;
            }
        }
        return null;
    }

    List<T> findAll() {
        return storage;
    }

    void delete(int id) {
        storage.removeIf(item -> item.getId() == id);
    }


    static void printAll(Repository<?> repo) {
        for (Object item : repo.findAll()) {
            System.out.println(item);
        }
    }

    public static void main(String[] args) {
        Repository<User> users = new Repository<>();
        Repository<Product> products = new Repository<>();

        users.save(new User(1, "Saba"));
        users.save(new User(2, "Giorgi"));
        products.save(new Product(1, 9.99));
        products.save(new Product(2, 49.99));

        System.out.println(users.findById(1));   // User{id=1, name='Saba'}
        users.delete(1);
        System.out.println(users.findAll());     // only Giorgi remains

        Repository.printAll(users);    // works
        Repository.printAll(products); // also works
    }

}


class User implements Entity {
    int id;
    String name;

    public User(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "User{id=" + id + ", name=" + name + "}";
    }
}


class Product implements Entity {
    int id;
    double price;

    public Product(int id, double price) {
        this.id = id;
        this.price = price;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Product{id=" + id + ", price=" + price + "}";
    }
}


