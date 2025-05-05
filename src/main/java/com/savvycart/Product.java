package com.savvycart;

import java.time.LocalDate;
import java.util.List;
import java.util.Arrays;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Product {
    private String id;
    private String name;
    private String brand;
    private String category;
    private String storeName;
    private double pricePerUnit;
    private boolean isInStock;
    private boolean deliveryAvailable;
    private int quantity;
    private String unit;
    private double volume;
    private String imageUrl;
    private double discount; // באחוזים
    private LocalDate expirationDate;
    private List<String> tags;

    // ✅ קונסטרקטור תואם לקריאה שלך בקובץ App.java
    public Product(String id, String name, String brand, String category, String storeName,
                   double pricePerUnit, boolean isInStock, boolean deliveryAvailable,
                   int quantity, String unit, double volume, String imageUrl,
                   double discount, LocalDate expirationDate, List<String> tags) {
        this.id = id;
        this.name = name;
        this.brand = brand;
        this.category = category;
        this.storeName = storeName;
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

    // 🔁 בניית אובייקט Product מתוך שורת תוצאה בבסיס הנתונים
    public static Product fromResultSet(ResultSet rs) throws SQLException {
        return new Product(
            rs.getString("id"),
            rs.getString("name"),
            rs.getString("brand"),
            rs.getString("category"),
            rs.getString("storeName"),
            rs.getDouble("pricePerUnit"),
            rs.getInt("isInStock") == 1,
            rs.getInt("deliveryAvailable") == 1,
            rs.getInt("quantity"),
            rs.getString("unit"),
            rs.getDouble("volume"),
            rs.getString("imageUrl"),
            rs.getDouble("discount"),
            LocalDate.parse(rs.getString("expirationDate")),
            Arrays.asList(rs.getString("tags").split(","))
        );
    }

    // 💰 חישוב מחיר סופי כולל הנחה וכמות
    public double getFinalPrice() {
        return pricePerUnit * quantity * (1 - discount / 100.0);
    }

    // 🧾 Getters
    public String getId() { return id; }
    public String getName() { return name; }
    public String getBrand() { return brand; }
    public String getCategory() { return category; }
    public String getStoreName() { return storeName; }
    public double getPricePerUnit() { return pricePerUnit; }
    public boolean isInStock() { return isInStock; }
    public boolean isDeliveryAvailable() { return deliveryAvailable; }
    public int getQuantity() { return quantity; }
    public String getUnit() { return unit; }
    public double getVolume() { return volume; }
    public String getImageUrl() { return imageUrl; }
    public double getDiscount() { return discount; }
    public LocalDate getExpirationDate() { return expirationDate; }
    public List<String> getTags() { return tags; }

    // 🖨️ תיאור ידידותי להדפסה
    @Override
    public String toString() {
        return name + " (" + brand + ") - " + getFinalPrice() + "₪ at " + storeName;
    }
}
