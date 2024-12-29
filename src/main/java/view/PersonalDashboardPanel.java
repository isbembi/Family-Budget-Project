package view;

import javax.swing.*;

public class PersonalDashboardPanel extends JPanel {
    private final AppFrame appFrame;

    public PersonalDashboardPanel(AppFrame appFrame) {
        this.appFrame = appFrame;
        setLayout(null);


        JButton chatButton = new JButton("Go to Chat");
        chatButton.setBounds(50, 100, 150, 30);
        add(chatButton);

        chatButton.addActionListener(e -> appFrame.switchTo("ChatPanel"));

        JButton reportsButton = new JButton("View Reports");
        reportsButton.setBounds(50, 150, 150, 30);
        add(reportsButton);

        reportsButton.addActionListener(e -> appFrame.switchTo("ReportsPanel"));

        JButton logoutButton = new JButton("Logout");
        logoutButton.setBounds(50, 200, 150, 30);
        add(logoutButton);

        logoutButton.addActionListener(e -> appFrame.switchTo("Login"));
    }
}
