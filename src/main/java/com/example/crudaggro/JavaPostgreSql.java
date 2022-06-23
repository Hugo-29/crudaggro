package com.example.crudaggro;



import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class JavaPostgreSql {
    public static void main(String[] args) {
        try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/aggro", "kroutok", "pouet")) {

            System.out.println("Java JDBC PostgreSQL Example");
            // When this class first attempts to establish a connection, it automatically loads any JDBC 4.0 drivers found within
            // the class path. Note that your application must manually load any JDBC drivers prior to version 4.0.
//          Class.forName("org.postgresql.Driver");

            System.out.println("Connected to PostgreSQL database!");
            Statement statement = connection.createStatement();
            System.out.println("Reading salarie records...");
            System.out.printf("%-30.30s  %-30.30s%n", "nom", "prenom");
            ResultSet resultSet = statement.executeQuery("SELECT * FROM salarie");

            while (resultSet.next()) {
                System.out.printf("%-30.30s  %-30.30s%n", resultSet.getString("nom"), resultSet.getString("prenom"));
            }

        } /*catch (ClassNotFoundException e) {
            System.out.println("PostgreSQL JDBC driver not found.");
            e.printStackTrace();
        }*/ catch (SQLException e) {
            System.out.println("Connection failure.");
            e.printStackTrace();
        }
    }
}