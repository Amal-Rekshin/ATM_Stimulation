# Student Management System (Java + JDBC + MySQL)

A simple **console‑based CRUD application** built using **Core Java**, **JDBC**, and **MySQL**. This project demonstrates how to manage student records (Add, Update, Delete, Search, View All) in a database.

---

## 🚀 Features

* Add new student
* Update existing student
* Delete a student
* Search a student by ID
* View all students
* MySQL database connectivity using JDBC
* Clean folder structure with DAO and Model layers

---

## 🗂 Folder Structure

```
StudentManagementSystem/
│
├── lib/
│   └── mysql-connector-j-9.6.0.jar
│
├── sql/
│   └── studentdb.sql
│
├── src/
│   ├── dao/
│   │   └── StudentDAO.java
│   │
│   ├── db/
│   │   └── DBConnection.java
│   │
│   ├── model/
│   │   └── Student.java
│   │
│   └── Main.java
```

---

## 🛢 MySQL Database Setup

Run the following SQL script:

```
CREATE DATABASE studentdb;

USE studentdb;

CREATE TABLE students (
    id INT PRIMARY KEY,
    name VARCHAR(100),
    age INT,
    course VARCHAR(100)
);
```

---

## 🔧 Configure DBConnection.java

Update your MySQL password:

```
private static final String URL = "jdbc:mysql://localhost:3306/studentdb";
private static final String USER = "root";
private static final String PASSWORD = "your_mysql_password";
```

---

## 🧩 Required Software

* Java JDK (17 or later)
* MySQL Server + Workbench
* MySQL Connector/J (JAR file)
* VS Code / IntelliJ / Terminal

---

## ▶️ How to Compile and Run (Mac / Linux)

### **Compile**

```
javac -cp lib/mysql-connector-j-9.6.0.jar src/**/*.java
```

### **Run**

```
java -cp "lib/mysql-connector-j-9.6.0.jar:src" Main
```

---

## ▶️ How to Compile and Run (Windows)

### **Compile**

```
javac -cp lib/mysql-connector-j-9.6.0.jar src\**\*.java
```

### **Run**

```
java -cp "lib/mysql-connector-j-9.6.0.jar;src" Main
```

---

## 🧱 Technologies Used

* **Java (Core Java)**
* **JDBC**
* **MySQL**
* **OOP Concepts**

---

## 📌 Future Enhancements

* GUI using JavaFX or Swing
* Login authentication
* Export student data to CSV or PDF
* Convert to Spring Boot version

---

## 📄 License

This project is free to use for learning and academic purposes.

---

## ✨ Author

Developed by **Spark (Antony)** with ❤️ for learning Java + MySQL.
