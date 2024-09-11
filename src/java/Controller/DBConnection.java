/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import Tan.Product;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DBConnection {

    // Database credentials
    private static final String DB_URL = "jdbc:mysql://localhost:3306/yourdatabase";
    private static final String USER = "username";
    private static final String PASS = "password";

    /**
     * Inserts a new product into the database.
     *
     * @param product The product to be inserted.
     * @return true if the product was inserted successfully, false otherwise.
     */
    public boolean insertNewProduct(Product product) {
        String sql = "INSERT INTO products (productname, productcount, productdate, productpayment) VALUES (?, ?, ?, ?)";
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, product.getProductname());
            pstmt.setString(2, product.getProductcount());
            pstmt.setString(3, product.getProductdate());
            pstmt.setString(4, product.getProductPayment());

            int rowsAffected = pstmt.executeUpdate();
            return rowsAffected > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
