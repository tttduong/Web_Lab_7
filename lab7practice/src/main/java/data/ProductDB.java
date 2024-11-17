package data;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.Product;

public class ProductDB {
    private static final String URL = "jdbc:mysql://localhost:3306/lab7practice"; // Database URL
    private static final String USERNAME = "root"; // Database username
    private static final String PASSWORD = "Shinichi@0"; // Database password
    public static List<Product> getAllProducts() {
        List<Product> products = new ArrayList<>();
        try {
            Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            String query = "SELECT productId, name, manufacturer, country, price FROM product";
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                int id = rs.getInt("productId");
                String name = rs.getString("name");
                String manufacturer = rs.getString("manufacturer");
                String country = rs.getString("country");
                String price = rs.getString("price");
               
                products.add(new Product(id, name, manufacturer, country, price ));
            }
            
            rs.close();
            ps.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }
}
