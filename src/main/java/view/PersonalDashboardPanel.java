package view;

import javax.swing.*;

public class PersonalDashboardPanel extends JPanel {
    public PersonalDashboardPanel(AppFrame appFrame) {
        setLayout(null);
        JLabel label = new JLabel("Welcome to Personal Dashboard!");
        label.setBounds(50, 50, 300, 30);
        add(label);

        JButton chatButton = new JButton("Go to Chat");
        chatButton.setBounds(50, 100, 150, 30);
        add(chatButton);

        chatButton.addActionListener(e -> appFrame.switchTo("ChatPanel"));

        JButton reportsButton = new JButton("View Reports");
        reportsButton.setBounds(50, 150, 150, 30);
        add(reportsButton);

        reportsButton.addActionListener(e -> appFrame.switchTo("ReportsPanel"));
    }
}
