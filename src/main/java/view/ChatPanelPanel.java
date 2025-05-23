package view;

import controller.FamilyChatController;
import model.FamilyChat;

import javax.swing.*;
import java.awt.*;
import java.util.List;

/**
 * Панель семейного чата для общения пользователей.
 */
public class ChatPanelPanel extends JPanel {
    private final AppFrame appFrame;
    private final FamilyChatController chatController;
    private JTextArea chatArea;
    private JTextField messageField;



    public ChatPanelPanel(AppFrame appFrame) {
        this.appFrame = appFrame;
        this.chatController = new FamilyChatController();

        setLayout(new BorderLayout());

        chatArea = new JTextArea();
        chatArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(chatArea);
        add(scrollPane, BorderLayout.CENTER);

        JPanel bottomPanel = new JPanel(new BorderLayout());
        messageField = new JTextField();
        JButton sendButton = new JButton("Send");
        JButton backButton = new JButton("Back");

        bottomPanel.add(messageField, BorderLayout.CENTER);
        bottomPanel.add(sendButton, BorderLayout.EAST);
        bottomPanel.add(backButton, BorderLayout.WEST);
        add(bottomPanel, BorderLayout.SOUTH);



        sendButton.addActionListener(e -> {
            String message = messageField.getText().trim();
            if (!message.isEmpty()) {
                chatController.sendMessage( message);
                messageField.setText("");
                loadChatMessages();
            } else {
                JOptionPane.showMessageDialog(this, "Message cannot be empty!", "Warning", JOptionPane.WARNING_MESSAGE);
            }
        });

        backButton.addActionListener(e -> appFrame.switchTo("PersonalDashboard"));

        loadChatMessages();
    }

    private void loadChatMessages() {
        chatArea.setText("");
        List<FamilyChat> messages = chatController.getAllMessagesWithUserNames();
        for (FamilyChat msg : messages) {
            chatArea.append(msg.getUserName() + ": " + msg.getMessage() + "\n");
        }
    }
}
