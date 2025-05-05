package com.savvycart;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ProductRepository {

    public static List<Product> getAllProducts() {
        List<Product> products = new ArrayList<>();

        String query = "SELECT * FROM products";
        try (Connection conn = DatabaseManager.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                products.add(mapResultSetToProduct(rs));
            }

        } catch (SQLException e) {
            System.out.println("Failed to load products: " + e.getMessage());
        }

        return products;
    }

    public static Product getProductById(String id) {
        String query = "SELECT * FROM products WHERE id = ?";
        try (Connection conn = DatabaseManager.connect();
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setString(1, id);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return mapResultSetToProduct(rs);
                }
            }

        } catch (SQLException e) {
            System.out.println("Failed to find product: " + e.getMessage());
        }

        return null;
    }

    private static Product mapResultSetToProduct(ResultSet rs) throws SQLException {
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
}
