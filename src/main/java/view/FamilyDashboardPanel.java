package view;

import javax.swing.*;

public class FamilyDashboardPanel extends JPanel {
    public FamilyDashboardPanel(AppFrame appFrame) {
        setLayout(null);
        JLabel label = new JLabel("Welcome to Family Dashboard!");
        label.setBounds(50, 50, 300, 30);
        add(label);

        JButton chatButton = new JButton("Family Chat");
        chatButton.setBounds(50, 100, 150, 30);
        add(chatButton);

        chatButton.addActionListener(e -> appFrame.switchTo("ChatPanel"));

    }

}
