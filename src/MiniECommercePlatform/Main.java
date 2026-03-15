package MiniECommercePlatform;

import MiniECommercePlatform.Exceptions.EcommerceExceptions;
import MiniECommercePlatform.Products.Clothing;
import MiniECommercePlatform.Products.Electronics;
import MiniECommercePlatform.Products.Food;
import MiniECommercePlatform.Shop.Cart;
import MiniECommercePlatform.Shop.Store;
import MiniECommercePlatform.Users.Customer;
import MiniECommercePlatform.Users.Seller;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        try {
            Clothing clothe1 = new Clothing("Maika",24.99 , 40);
            Clothing clothe2 = new Clothing("Fexsacmeli",74.99 , 30);
            Clothing clothe3 = new Clothing("Sharvali",49.99 , 50);
            Clothing clothe4 = new Clothing("Qurtuki",94.99 , 10);
            Clothing clothe5 = new Clothing("Qudi",4.99 , 70);

            Seller seller1 = new Seller("saba", "nikachadze@gmail.com", "qazwsx");
            Store store1 = new Store();
            Customer customer1 = new Customer("genadi","gegeshidze@mail.ru","526000");

            seller1.login("nikachadze@gmail.com", "qazwsx");
            seller1.listProduct(store1, clothe1);
            seller1.listProduct(store1, clothe2);
            seller1.listProduct(store1, clothe3);
            seller1.listProduct(store1, clothe4);
            seller1.listProduct(store1, clothe5);
            seller1.showListedProducts();
            System.out.println();
            customer1.login("gegeshidze@mail.ru","526000");
            customer1.addToCart(store1, clothe5,15);
            customer1.addToCart(store1, clothe1, 10);
            customer1.addToCart(store1, clothe3, 20);
            customer1.addToCart(store1, clothe4, 5);
            customer1.addToCart(store1, clothe2, 25);
            customer1.removeFromCart(store1,clothe1);
            customer1.checkout();
            customer1.showOrderHistory();
            customer1.leaveReview(clothe1,"nametani dzviria",5);
            seller1.showListedProducts();



        } catch (EcommerceExceptions e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
