package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnector {
    private static final String URL = "jdbc:mysql://localhost:3306/family_budget";
    private static final String USER = "root"; // Укажи своего пользователя MySQL
    private static final String PASSWORD = "12345"; // Укажи пароль MySQL
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";

    public static Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName(DRIVER); // Загрузка драйвера MySQL
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("✅ Успешное соединение с базой данных!");
        } catch (ClassNotFoundException e) {
            System.err.println("❌ Драйвер MySQL не найден: " + e.getMessage());
        } catch (SQLException e) {
            System.err.println("❌ Ошибка при соединении с базой данных: " + e.getMessage());
        }
        return connection;
    }

    public static void main(String[] args) {
        Connection conn = getConnection();
        if (conn != null) {
            try {
                conn.close();
                System.out.println("✅ Соединение успешно закрыто.");
            } catch (SQLException e) {
                System.err.println("❌ Ошибка при закрытии соединения: " + e.getMessage());
            }
        }
    }
}
