package view;

import javax.swing.*;

public class ChatPanelPanel extends JPanel {
    public ChatPanelPanel(AppFrame appFrame) {
        setLayout(null);
        JLabel label = new JLabel("Family Chat");
        label.setBounds(50, 50, 200, 30);
        add(label);

        JButton backButton = new JButton("Back");
        backButton.setBounds(50, 100, 100, 30);
        add(backButton);

        backButton.addActionListener(e -> appFrame.switchTo("PersonalDashboard"));
    }
}
