package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.User;

public class UserDB {

    private static final String URL = "jdbc:mysql://localhost:3306/lab7practice"; // Database URL
    private static final String USERNAME = "root"; // Database username
    private static final String PASSWORD = "Shinichi@0"; // Database password

    public static boolean signin(User user) {
        String sql = "SELECT * FROM customer WHERE name = ? AND visaNumber = ? AND address = ?";

        try {
            // Load MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
                 PreparedStatement statement = connection.prepareStatement(sql)) {

                // Gán giá trị cho các tham số trong câu lệnh SQL
                statement.setString(1, user.getName());
                statement.setString(2, user.getVisa());
                statement.setString(3, user.getAddress());

                // Thực thi truy vấn
                try (ResultSet rs = statement.executeQuery()) {
                    // Kiểm tra nếu có kết quả (nghĩa là thông tin khớp)
                    return rs.next();
                }
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false; // Trả về false nếu có lỗi hoặc không tìm thấy
    }

    public static List<User> getAll() {
        List<User> users = new ArrayList<>();
        String sql = "SELECT name, visaNumber, address FROM users";

        try {
            // Load MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD); PreparedStatement statement = connection.prepareStatement(sql); ResultSet rs = statement.executeQuery()) {
                while (rs.next()) {
                    String name = rs.getString("name");
                    String visa = rs.getString("visa");
                    String address = rs.getString("address");
                    User user = new User(name, visa, address);
                    users.add(user);
                }
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

}
