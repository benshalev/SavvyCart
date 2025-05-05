package com.savvycart;

import java.time.LocalDate;
import java.util.List;

public class Product {
    private String id; // מזהה ייחודי (אפשר להשתמש ב-UUID)
    private String name;
    private String brand;
    private String category;
    private String storeName;
    private double price;
    private double pricePerUnit; // מחיר ליחידה / 100 גרם / ליטר
    private boolean isInStock;
    private boolean deliveryAvailable;
    private int quantity; // כמות במארז
    private String unit; // לדוגמה: "יחידה", "גרם", "ליטר"
    private double volume; // נפח ליחידה (אם יש)
    private String imageUrl;
    private double discount; // באחוזים
    private LocalDate expirationDate;
    private List<String> tags; // לדוגמה: טבעוני, כשר, ללא גלוטן

    // Constructor
    public Product(String id, String name, String brand, String category, String storeName,
                   double price, double pricePerUnit, boolean isInStock, boolean deliveryAvailable,
                   int quantity, String unit, double volume, String imageUrl,
                   double discount, LocalDate expirationDate, List<String> tags) {
        this.id = id;
        this.name = name;
        this.brand = brand;
        this.category = category;
        this.storeName = storeName;
        this.price = price;
        this.pricePerUnit = pricePerUnit;
        this.isInStock = isInStock;
        this.deliveryAvailable = deliveryAvailable;
        this.quantity = quantity;
        this.unit = unit;
        this.volume = volume;
        this.imageUrl = imageUrl;
        this.discount = discount;
        this.expirationDate = expirationDate;
        this.tags = tags;
    }

    // Getters and Setters (אפשר גם להשתמש ב־Lombok אם נרצה בעתיד)

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getBrand() { return brand; }
    public void setBrand(String brand) { this.brand = brand; }

    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }

    public String getStoreName() { return storeName; }
    public void setStoreName(String storeName) { this.storeName = storeName; }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }

    public double getPricePerUnit() { return pricePerUnit; }
    public void setPricePerUnit(double pricePerUnit) { this.pricePerUnit = pricePerUnit; }

    public boolean isInStock() { return isInStock; }
    public void setInStock(boolean inStock) { isInStock = inStock; }

    public boolean isDeliveryAvailable() { return deliveryAvailable; }
    public void setDeliveryAvailable(boolean deliveryAvailable) { this.deliveryAvailable = deliveryAvailable; }

    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }

    public String getUnit() { return unit; }
    public void setUnit(String unit) { this.unit = unit; }

    public double getVolume() { return volume; }
    public void setVolume(double volume) { this.volume = volume; }

    public String getImageUrl() { return imageUrl; }
    public void setImageUrl(String imageUrl) { this.imageUrl = imageUrl; }

    public double getDiscount() { return discount; }
    public void setDiscount(double discount) { this.discount = discount; }

    public LocalDate getExpirationDate() { return expirationDate; }
    public void setExpirationDate(LocalDate expirationDate) { this.expirationDate = expirationDate; }

    public List<String> getTags() { return tags; }
    public void setTags(List<String> tags) { this.tags = tags; }

    // ToString
    @Override
    public String toString() {
        return name + " (" + brand + ") - " + price + "₪ at " + storeName;
    }
}
