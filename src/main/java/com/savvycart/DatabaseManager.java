package com.savvycart;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseManager {

    private static final String DB_URL = "jdbc:sqlite:products.db";

    public static Connection connect() throws SQLException {
        return DriverManager.getConnection(DB_URL);
    }

    public static void initializeDatabase() {
        String createTableSQL =
            "CREATE TABLE IF NOT EXISTS products (" +
            "id TEXT PRIMARY KEY, " +
            "name TEXT NOT NULL, " +
            "brand TEXT, " +
            "category TEXT, " +
            "storeName TEXT, " +
            "pricePerUnit REAL, " +
            "isInStock INTEGER, " +
            "deliveryAvailable INTEGER, " +
            "quantity INTEGER, " +
            "unit TEXT, " +
            "volume REAL, " +
            "imageUrl TEXT, " +
            "discount REAL, " +
            "expirationDate TEXT, " +
            "tags TEXT" +
            ");";
    
        try (Connection conn = connect(); Statement stmt = conn.createStatement()) {
            stmt.execute(createTableSQL);
            System.out.println(" Database initialized successfully.");
        } catch (SQLException e) {
            System.out.println(" Database initialization failed: " + e.getMessage());
        }
    }

    public static void insertProduct(Product product) {
        String insertSQL = "INSERT INTO products (id, name, brand, category, storeName, pricePerUnit, isInStock, deliveryAvailable, quantity, unit, volume, imageUrl, discount, expirationDate, tags) " +
                        "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = connect(); PreparedStatement pstmt = conn.prepareStatement(insertSQL)) {
            pstmt.setString(1, product.getId());
            pstmt.setString(2, product.getName());
            pstmt.setString(3, product.getBrand());
            pstmt.setString(4, product.getCategory());
            pstmt.setString(5, product.getStoreName());
            pstmt.setDouble(6, product.getPricePerUnit());
            pstmt.setInt(7, product.isInStock() ? 1 : 0);
            pstmt.setInt(8, product.isDeliveryAvailable() ? 1 : 0);
            pstmt.setInt(9, product.getQuantity());
            pstmt.setString(10, product.getUnit());
            pstmt.setDouble(11, product.getVolume());
            pstmt.setString(12, product.getImageUrl());
            pstmt.setDouble(13, product.getDiscount());
            pstmt.setString(14, product.getExpirationDate().toString());
            pstmt.setString(15, String.join(",", product.getTags()));

            pstmt.executeUpdate();
            System.out.println("Product inserted: " + product.getName());
        } catch (SQLException e) {
            System.out.println("Failed to insert product: " + e.getMessage());
        }
    }
}
