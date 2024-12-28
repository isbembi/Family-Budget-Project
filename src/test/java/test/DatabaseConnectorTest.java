package test;

import model.DatabaseConnector;
import org.junit.jupiter.api.*;

import java.sql.Connection;
import java.sql.SQLException;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class DatabaseConnectorTest {

    @Test
    @DisplayName("Тест соединения с базой данных")
    void testDatabaseConnection() {
        try (Connection connection = DatabaseConnector.getConnection()) {
            Assertions.assertNotNull(connection, "Соединение с базой данных должно быть успешно установлено");
        } catch (SQLException e) {
            Assertions.fail("Ошибка соединения с базой данных: " + e.getMessage());
        }
    }
}
