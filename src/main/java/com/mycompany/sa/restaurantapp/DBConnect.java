/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sa.restaurantapp;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnect {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/myprojectdb"; // Replace with your DB name
        String user = "root"; // Or your MySQL username
        String password = "4Me2pass_"; // Your MySQL password

        try {
            Connection conn = DriverManager.getConnection(url, user, password);
            System.out.println("connected successfully");
        } catch (SQLException e) {
            System.out.println("test failed" + e.getMessage());
        }
    }
}