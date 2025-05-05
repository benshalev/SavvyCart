package com.savvycart;

import java.time.LocalDate;
import java.util.List;

public class App {
    public static void main(String[] args) {
        // אתחול מסד הנתונים
        DatabaseManager.initializeDatabase();

        // יצירת מוצרים לבדיקה
        Product milk = new Product(
            "p001", "Milk 3%", "Tnuva", "Dairy", "Shufersal",
            6.90, true, true,
            1, "liter", 1.0, "https://example.com/milk.jpg",
            0.0, LocalDate.of(2025, 5, 20), List.of("kosher", "no preservatives")
        );

        Product cheese = new Product(
            "p002", "Yellow Cheese", "Tnuva", "Dairy", "Victory",
            1.20, true, false,
            10, "grams", 1.0, "https://example.com/cheese.jpg",
            10.0, LocalDate.of(2025, 5, 18), List.of("kosher", "vegetarian")
        );

        // הכנסת מוצרים למסד הנתונים
        DatabaseManager.insertProduct(milk);
        DatabaseManager.insertProduct(cheese);

        // הרצת תפריט קונסול אינטראקטיבי
        ConsoleMenu.start();
    }
}
