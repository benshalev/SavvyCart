package com.savvycart;

import java.time.LocalDate;
import java.util.Arrays;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ){
        Product milk = new Product(
            "p001",
            "חלב 3%",
            "תנובה",
            "מוצרי חלב",
            "שופרסל",
            6.90,
            6.90,
            true,
            true,
            1,
            "ליטר",
            1.0,
            "https://example.com/milk.jpg",
            0.0,
            LocalDate.of(2025, 5, 20),
            Arrays.asList("כשר", "ללא חומרים משמרים")
        );

        System.out.println("🛒 מוצר לדוגמה:");
        System.out.println(milk);
    }
}
