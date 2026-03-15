package MiniECommercePlatform.Shop;

import MiniECommercePlatform.Products.Product;
import MiniECommercePlatform.Users.Customer;

import java.util.ArrayList;

public class Order {
    private final Customer customer;
    private final ArrayList<Product> products;
    private final double total;
    private String status = "Pending";

    public Order(Customer customer, ArrayList<Product> products, double total) {
        this.customer = customer;
        this.products = products;
        this.total = total;
    }


    public void advanceStatus() {
        if (status.equals("Pending"))        status = "Shipped";
        else if (status.equals("Shipped"))   status = "Delivered";
        else System.out.println("Order already delivered");
    }


    public String getStatus()              { return status; }
    public double getTotal()               { return total; }
    public Customer getCustomer()          { return customer; }
    public ArrayList<Product> getProducts(){ return products; }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("================================\n");
        sb.append(String.format("Customer : %s%n", customer.getName()));
        sb.append(String.format("Status   : %s%n", status));
        sb.append(String.format("Total    : $%.2f%n", total));
        sb.append("--------------------------------\n");
        for (Product p : products) {
            sb.append(String.format("  - %-20s $%.2f%n",
                    p.getName(), p.getPrice() * p.getStock()));
        }
        sb.append("================================");
        return sb.toString();
    }
}