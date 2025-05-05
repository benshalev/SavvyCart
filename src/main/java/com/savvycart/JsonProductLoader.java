package com.savvycart;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.time.LocalDate;
import java.util.List;

public class JsonProductLoader {

    public static void loadProductsFromJson(String filePath) {
        try (FileReader reader = new FileReader(filePath)) {
        Gson gson = new GsonBuilder()
            .registerTypeAdapter(LocalDate.class, new LocalDateAdapter())
            .create();
        Type productListType = new TypeToken<List<Product>>() {}.getType();
            List<Product> products = gson.fromJson(reader, productListType);
            if (products == null) {
                System.out.println("⚠️ No products found or failed to parse JSON.");
                return;
            }


            for (Product product : products) {
                // הכנסה למסד הנתונים רק אם המוצר לא קיים כבר
                if (ProductRepository.getProductById(product.getId()) == null) {
                    DatabaseManager.insertProduct(product);
                    System.out.println("Inserted: " + product.getName());
                } else {
                    System.out.println("Already exists: " + product.getName());
                }
            }
        } catch (IOException e) {
            System.out.println("Failed to read JSON file: " + e.getMessage());
        }
    }
}
