package com.savvycart;

import java.util.List;
import java.util.Scanner;

public class ConsoleMenu {

    public static void start() {
        Scanner scanner = new Scanner(System.in);
        int choice = -1;

        do {
            System.out.println("1. Show all products");
            System.out.println("2. Find product by ID");
            System.out.println("3. Add a new product");
            System.out.println("4. Exit");
            System.out.print("Select an option: ");
            String input = scanner.nextLine();
            try {
                choice = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
                continue;
            }
            
            
            switch (choice) {
                case 1:
                    showAllProducts();
                    break;
                case 2:
                    findProductById(scanner);
                    break;
                case 3:
                    addNewProduct(scanner);
                    break;
                case 4:
                    System.out.println("Exiting... Bye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
            
        } while (choice != 4);

        scanner.close();
    }

    private static void showAllProducts() {
        List<Product> products = ProductRepository.getAllProducts();
        if (products.isEmpty()) {
            System.out.println("No products found.");
        } else {
            System.out.println("Products:");
            for (Product p : products) {
                System.out.println(" - " + p);
            }
        }
    }

    private static void findProductById(Scanner scanner) {
        System.out.print("Enter product ID: ");
        String id = scanner.nextLine();
        Product product = ProductRepository.getProductById(id);
        if (product != null) {
            System.out.println("Found: " + product);
        } else {
            System.out.println("Product not found.");
        }
    }

    private static void addNewProduct(Scanner scanner) {
        System.out.print("Enter product ID: ");
        String id = scanner.nextLine();
    
        if (ProductRepository.getProductById(id) != null) {
            System.out.println("A product with this ID already exists.");
            return;
        }
    
        System.out.print("Name: ");
        String name = scanner.nextLine();
    
        System.out.print("Brand: ");
        String brand = scanner.nextLine();
    
        System.out.print("Category: ");
        String category = scanner.nextLine();
    
        System.out.print("Store name: ");
        String store = scanner.nextLine();
    
        System.out.print("Price per unit: ");
        double price = scanner.nextDouble();
    
        System.out.print("Is in stock? (true/false): ");
        boolean inStock = scanner.nextBoolean();
    
        System.out.print("Is delivery available? (true/false): ");
        boolean delivery = scanner.nextBoolean();
    
        System.out.print("Quantity: ");
        int quantity = scanner.nextInt();
        scanner.nextLine(); // Consume newline
    
        System.out.print("Unit (e.g. gram/liter): ");
        String unit = scanner.nextLine();
    
        System.out.print("Volume: ");
        double volume = scanner.nextDouble();
        scanner.nextLine();
    
        System.out.print("Image URL: ");
        String imageUrl = scanner.nextLine();
    
        System.out.print("Discount (%): ");
        double discount = scanner.nextDouble();
        scanner.nextLine();
    
        System.out.print("Expiration date (YYYY-MM-DD): ");
        String dateStr = scanner.nextLine();
    
        System.out.print("Tags (comma-separated): ");
        List<String> tags = List.of(scanner.nextLine().split(","));
    
        Product newProduct = new Product(
            id, name, brand, category, store, price, inStock, delivery,
            quantity, unit, volume, imageUrl, discount, 
            java.time.LocalDate.parse(dateStr), tags
        );
    
        DatabaseManager.insertProduct(newProduct);
        System.out.println("Product added successfully.");
    }
    
}
