import java.util.*;

// Class to represent a Product
class Product {
    private String name;
    private double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    // Getter methods
    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}

// Class to represent a ShoppingCart
class ShoppingCart {
    private List<Product> items;

    public ShoppingCart() {
        this.items = new ArrayList<>();
    }

    // Method to add a product to the shopping cart
    public void addItem(Product product) {
        items.add(product);
    }

    // Method to remove a product from the shopping cart
    public void removeItem(Product product) {
        items.remove(product);
    }

    // Method to calculate total price of items in the shopping cart
    public double calculateTotal() {
        double total = 0;
        for (Product item : items) {
            total += item.getPrice();
        }
        return total;
    }

    // Method to display items in the shopping cart
    public void displayItems() {
        if (items.isEmpty()) {
            System.out.println("Your shopping cart is empty.");
        } else {
            System.out.println("Items in your shopping cart:");
            for (Product item : items) {
                System.out.println(item.getName() + " - $" + item.getPrice());
            }
        }
    }
}

// Class to represent a Customer
class Customer {
    private String name;
    private String email;
    private ShoppingCart cart;

    public Customer(String name, String email) {
        this.name = name;
        this.email = email;
        this.cart = new ShoppingCart();
    }

    // Method to add a product to the shopping cart
    public void addToCart(Product product) {
        cart.addItem(product);
        System.out.println(product.getName() + " added to your shopping cart.");
    }

    // Method to remove a product from the shopping cart
    public void removeFromCart(Product product) {
        cart.removeItem(product);
        System.out.println(product.getName() + " removed from your shopping cart.");
    }

    // Method to view items in the shopping cart
    public void viewCart() {
        cart.displayItems();
        System.out.println("Total: $" + cart.calculateTotal());
    }

    // Method to checkout
    public void checkout() {
        System.out.println("Thank you for shopping with us, " + name + "!");
        System.out.println("Your total amount is: $" + cart.calculateTotal());
        cart = new ShoppingCart(); // Clearing the cart after checkout
    }
}

public class Main {
    public static void main(String[] args) {
        // Creating products
        Product product1 = new Product("Laptop", 999.99);
        Product product2 = new Product("Headphones", 49.99);
        Product product3 = new Product("Mouse", 19.99);

        // Creating a customer
        Customer customer = new Customer("Ankit Vishwakarma", "ankit@example.com");

        // Adding items to the cart
        customer.addToCart(product1);
        customer.addToCart(product2);
        customer.addToCart(product3);

        // Viewing the cart
        customer.viewCart();

        // Removing an item from the cart
        customer.removeFromCart(product2);

        // Viewing the updated cart
        customer.viewCart();

        // Checking out
        customer.checkout();
    }
}
