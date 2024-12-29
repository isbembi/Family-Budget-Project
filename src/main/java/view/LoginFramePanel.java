package view;

import controller.UserController;
import utils.NotificationUtils;

import javax.swing.*;

/**
 * Панель для входа в систему.
 */
public class LoginFramePanel extends JPanel {
    private final AppFrame appFrame;
    private final UserController userController;

    public LoginFramePanel(AppFrame appFrame) {
        this.appFrame = appFrame;
        this.userController = new UserController(); // Создаем один раз

        setLayout(null);

        // Email Label и TextField
        JLabel emailLabel = new JLabel("Email:");
        emailLabel.setBounds(50, 50, 80, 25);
        add(emailLabel);

        JTextField emailField = new JTextField(20);
        emailField.setBounds(140, 50, 200, 25);
        add(emailField);

        // Password Label и PasswordField
        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(50, 100, 80, 25);
        add(passwordLabel);

        JPasswordField passwordField = new JPasswordField(20);
        passwordField.setBounds(140, 100, 200, 25);
        add(passwordField);

        // Login Button
        JButton loginButton = new JButton("Login");
        loginButton.setBounds(140, 150, 100, 30);
        add(loginButton);

        loginButton.addActionListener(e -> {
            String email = emailField.getText().trim();
            String password = new String(passwordField.getPassword()).trim();

            // Валидация пустых полей
            if (email.isEmpty() || password.isEmpty()) {
                NotificationUtils.showWarningMessage("Validation Error", "Email and Password cannot be empty!");
                return;
            }

            try {
                if (userController.authenticateUser(email, password)) {
                    int userId = userController.getUserIdByEmail(email);

                    if (userId == -1) {
                        NotificationUtils.showErrorMessage("Login Failed", "User ID not found.");
                        return;
                    }

                    appFrame.setCurrentUserId(userId);
                    boolean isManager = userController.isUserManager(userId);

                    if (isManager) {
                        NotificationUtils.showInfoMessage("Login Successful", "Welcome, Manager!");
                        if (appFrame != null) {
                            appFrame.switchTo("ManagerDashboard");
                        } else {
                            System.err.println("❌ AppFrame is null!");
                        }
                    } else {
                        NotificationUtils.showInfoMessage("Login Successful", "Welcome, User!");
                        if (appFrame != null) {
                            appFrame.switchTo("PersonalDashboard");
                        } else {
                            System.err.println("❌ AppFrame is null!");
                        }
                    }
                } else {
                    NotificationUtils.showErrorMessage("Login Failed", "Invalid email or password.");
                }
            } catch (Exception ex) {
                NotificationUtils.showErrorMessage("Login Error", "An error occurred during login: " + ex.getMessage());
                ex.printStackTrace();
            }
        });
    }
}
