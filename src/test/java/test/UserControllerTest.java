package test;

import controller.UserController;
import model.User;
import org.junit.jupiter.api.*;

import java.util.List;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class UserControllerTest {
    private UserController userController;

    @BeforeAll
    void setup() {
        userController = new UserController();
    }

    @Test
    @DisplayName("Удаление пользователя")
    void testDeleteUser() {
        // Шаг 1: Создаем пользователя
        User user = new User(0, "Delete Test User", "delete_test@example.com", "password", "MEMBER", 3000.00);
        userController.addUser(user);

        // Шаг 2: Получаем ID добавленного пользователя
        List<User> users = userController.getAllUsers();
        int userId = users.stream()
                .filter(u -> u.getEmail().equals("delete_test@example.com"))
                .findFirst()
                .map(User::getId)
                .orElseThrow(() -> new AssertionError("Пользователь не был добавлен"));

        // Шаг 3: Удаляем пользователя
        userController.deleteUser(userId);

        // Шаг 4: Проверяем, что пользователь удалён
        List<User> updatedUsers = userController.getAllUsers();
        boolean userExists = updatedUsers.stream().anyMatch(u -> u.getId() == userId);

        Assertions.assertFalse(userExists, "Пользователь должен быть удален из базы данных");
    }
}
