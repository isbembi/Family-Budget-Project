package view;

import controller.UserController;
import javax.swing.*;

public class LoginFramePanel extends JPanel {
    private final AppFrame appFrame;

    public LoginFramePanel(AppFrame appFrame) {
        this.appFrame = appFrame;
        setLayout(null);

        JLabel emailLabel = new JLabel("Email:");
        emailLabel.setBounds(50, 50, 80, 25);
        add(emailLabel);

        JTextField emailField = new JTextField(20);
        emailField.setBounds(140, 50, 200, 25);
        add(emailField);

        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(50, 100, 80, 25);
        add(passwordLabel);

        JPasswordField passwordField = new JPasswordField(20);
        passwordField.setBounds(140, 100, 200, 25);
        add(passwordField);

        JButton loginButton = new JButton("Login");
        loginButton.setBounds(140, 150, 100, 30);
        add(loginButton);

        loginButton.addActionListener(e -> {
            String email = emailField.getText();
            String password = new String(passwordField.getPassword());
            UserController userController = new UserController();

            if (userController.authenticateUser(email, password)) {
                if (email.equals("admin@example.com")) {
                    appFrame.switchTo("ManagerDashboard");
                } else {
                    appFrame.switchTo("PersonalDashboard");
                }
            } else {
                JOptionPane.showMessageDialog(this, "Invalid credentials!");
            }
        });
    }
}
