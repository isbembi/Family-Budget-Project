package controller;

import model.User;
import model.DatabaseConnector;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserController {

    public boolean authenticateUser(String email, String password) {
        try (Connection conn = DatabaseConnector.getConnection()) {
            String query = "SELECT * FROM user WHERE email = ? AND password = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, email);
            stmt.setString(2, password);
            ResultSet rs = stmt.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            System.err.println("❌ Ошибка аутентификации: " + e.getMessage());
        }
        return false;
    }

    public int getUserIdByEmail(String email) {
        try (Connection conn = DatabaseConnector.getConnection()) {
            String query = "SELECT id FROM user WHERE email = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, email);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getInt("id");
            }
        } catch (SQLException e) {
            System.err.println("❌ Ошибка при получении ID пользователя: " + e.getMessage());
        }
        return -1;
    }

    public static String getUserNameById(int userId) {
        String userName = "";
        try (Connection conn = DatabaseConnector.getConnection()) {
            String query = "SELECT name FROM user WHERE id = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, userId);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                userName = rs.getString("name");
            }
        } catch (SQLException e) {
            System.err.println("❌ Ошибка получения имени пользователя: " + e.getMessage());
        }
        return userName;
    }

    public void addUser(User user) {
        try (Connection conn = DatabaseConnector.getConnection()) {
            String query = "INSERT INTO user (name, email, password, user_type, salary) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, user.getName());
            stmt.setString(2, user.getEmail());
            stmt.setString(3, user.getPassword());
            stmt.setString(4, user.getUserType());
            stmt.setDouble(5, user.getSalary());
            stmt.executeUpdate();
            System.out.println("✅ Пользователь успешно добавлен.");
        } catch (SQLException e) {
            System.err.println("❌ Ошибка добавления пользователя: " + e.getMessage());
        }
    }

    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        try (Connection conn = DatabaseConnector.getConnection()) {
            String query = "SELECT * FROM user";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                users.add(new User(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("email"),
                        rs.getString("password"),
                        rs.getString("user_type"),
                        rs.getDouble("salary")
                ));
            }
        } catch (SQLException e) {
            System.err.println("❌ Ошибка получения списка пользователей: " + e.getMessage());
        }
        return users;
    }

    public User getUserById(int userId) {
        try (Connection conn = DatabaseConnector.getConnection()) {
            String query = "SELECT * FROM user WHERE id = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, userId);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new User(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("email"),
                        rs.getString("password"),
                        rs.getString("user_type"),
                        rs.getDouble("salary")
                );
            }
        } catch (SQLException e) {
            System.err.println("❌ Ошибка получения пользователя по ID: " + e.getMessage());
        }
        return null;
    }

    public void updateUser(User user) {
        try (Connection conn = DatabaseConnector.getConnection()) {
            String query = "UPDATE user SET name = ?, email = ?, password = ?, user_type = ?, salary = ? WHERE id = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, user.getName());
            stmt.setString(2, user.getEmail());
            stmt.setString(3, user.getPassword());
            stmt.setString(4, user.getUserType());
            stmt.setDouble(5, user.getSalary());
            stmt.setInt(6, user.getId());
            stmt.executeUpdate();
            System.out.println("✅ Данные пользователя успешно обновлены.");
        } catch (SQLException e) {
            System.err.println("❌ Ошибка обновления данных пользователя: " + e.getMessage());
        }
    }

    public void deleteUser(int userId) {
        try (Connection conn = DatabaseConnector.getConnection()) {
            String query = "DELETE FROM user WHERE id = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, userId);
            stmt.executeUpdate();
            System.out.println("✅ Пользователь успешно удален.");
        } catch (SQLException e) {
            System.err.println("❌ Ошибка удаления пользователя: " + e.getMessage());
        }
    }

    public boolean isUserManager(int userId) {
        try (Connection conn = DatabaseConnector.getConnection()) {
            String query = "SELECT user_type FROM user WHERE id = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, userId);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getString("user_type").equalsIgnoreCase("MANAGER");
            }
        } catch (SQLException e) {
            System.err.println("❌ Ошибка при проверке роли пользователя: " + e.getMessage());
        }
        return false;
    }
}
