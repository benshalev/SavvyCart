<p align="center">
  <img src="assets/logo.png" alt="SavvyCart Logo" width="200"/>
</p>
# 🛒 SavvyCart

SavvyCart is a console-based product management system that allows users to view, search, and add grocery products using a local SQLite database.

## 💡 Features

- View all available products
- Search product by ID
- Add new products through an interactive menu
- Persistent storage with SQLite
- Modular structure with clean separation (App, Menu, Repository, DB)

## 🧱 Tech Stack

- Java 11
- SQLite
- Maven

## 🚀 How to Run

```bash
mvn compile exec:java -Dexec.mainClass="com.savvycart.App"
