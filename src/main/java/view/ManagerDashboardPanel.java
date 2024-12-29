package view;

import controller.UserController;
import model.User;

import javax.swing.*;
import java.awt.*;
import java.util.List;

/**
 * Панель менеджера с уникальными функциями: управление пользователями, лимиты.
 */
public class ManagerDashboardPanel extends JPanel {
    private final AppFrame appFrame;
    private final UserController userController;

    public ManagerDashboardPanel(AppFrame appFrame) {
        this.appFrame = appFrame;
        this.userController = new UserController();

        setLayout(null);

        JLabel titleLabel = new JLabel("Manager Dashboard");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
        titleLabel.setBounds(250, 20, 300, 30);
        add(titleLabel);

        // Добавление пользователя
        JButton addUserButton = new JButton("Add User");
        addUserButton.setBounds(50, 70, 200, 30);
        add(addUserButton);

        addUserButton.addActionListener(e -> {
            String name = JOptionPane.showInputDialog("Enter user name:");
            String email = JOptionPane.showInputDialog("Enter user email:");
            String password = JOptionPane.showInputDialog("Enter user password:");
            String role = JOptionPane.showInputDialog("Enter user role (MEMBER/MANAGER):");
            if (name != null && email != null && password != null && role != null) {
                userController.addUser(new User(0, name, email, password, role, 0.0));
                JOptionPane.showMessageDialog(this, "User added successfully!");
            }
        });

        // Удаление пользователя
        JButton deleteUserButton = new JButton("Delete User");
        deleteUserButton.setBounds(50, 120, 200, 30);
        add(deleteUserButton);

        deleteUserButton.addActionListener(e -> {
            String userId = JOptionPane.showInputDialog("Enter user ID to delete:");
            if (userId != null && !userId.isEmpty()) {
                userController.deleteUser(Integer.parseInt(userId));
                JOptionPane.showMessageDialog(this, "User deleted successfully!");
            }
        });

        // Просмотр пользователей
        JButton viewUsersButton = new JButton("View All Users");
        viewUsersButton.setBounds(50, 170, 200, 30);
        add(viewUsersButton);

        viewUsersButton.addActionListener(e -> {
            List<User> users = userController.getAllUsers();
            StringBuilder userList = new StringBuilder("User List:\n");
            for (User user : users) {
                userList.append("ID: ").append(user.getId())
                        .append(", Name: ").append(user.getName())
                        .append(", Role: ").append(user.getUserType())
                        .append("\n");
            }
            JOptionPane.showMessageDialog(this, userList.toString());
        });

        // Установка финансовых лимитов
        JButton setLimitsButton = new JButton("Set Financial Limits");
        setLimitsButton.setBounds(50, 220, 200, 30);
        add(setLimitsButton);

        setLimitsButton.addActionListener(e -> {
            String limit = JOptionPane.showInputDialog("Enter financial limit:");
            if (limit != null && !limit.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Financial limit set to: " + limit);
            }
        });

        // Просмотр отчётов
        JButton reportsButton = new JButton("View Reports");
        reportsButton.setBounds(50, 270, 200, 30);
        add(reportsButton);

        reportsButton.addActionListener(e -> appFrame.switchTo("ReportsPanel"));

        // Кнопка выхода
        JButton logoutButton = new JButton("Logout");
        logoutButton.setBounds(50, 320, 200, 30);
        add(logoutButton);

        logoutButton.addActionListener(e -> appFrame.switchTo("Login"));
    }
}
