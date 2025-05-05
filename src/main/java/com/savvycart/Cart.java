package com.savvycart;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private List<Product> products;

    public Cart() {
        this.products = new ArrayList<>();
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public boolean removeProductById(String productId) {
        return products.removeIf(p -> p.getId().equals(productId));
    }

    public double getTotalPrice() {
        return products.stream()
                .mapToDouble(Product::getFinalPrice)
                .sum();
    }

    public void displayCart() {
        if (products.isEmpty()) {
            System.out.println(" The cart is empty.");
        } else {
            System.out.println(" Cart contents:");
            for (Product product : products) {
                System.out.println(" - " + product);
            }
            System.out.printf("Total price: %.2f₪\n", getTotalPrice());
        }
    }

    public List<Product> getProducts() {
        return products;
    }
}
