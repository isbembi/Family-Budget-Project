package view;

import javax.swing.*;

public class LoginFrame extends JFrame {
    public LoginFrame() {
        setTitle("Family Budget - Login");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.add(new JLabel("Username:"));
        panel.add(new JTextField(15));
        panel.add(new JLabel("Password:"));
        panel.add(new JPasswordField(15));
        JButton loginButton = new JButton("Login");
        panel.add(loginButton);

        add(panel);
        setVisible(true);
    }

    public static void main(String[] args) {
        new LoginFrame();
    }
}
