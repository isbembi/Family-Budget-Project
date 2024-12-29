package view;

import controller.FamilyChatController;
import model.FamilyChat;

import javax.swing.*;
import java.awt.*;
import java.util.Date;
import java.util.List;

/**
 * Панель семейного чата для общения пользователей.
 */
public class ChatPanelPanel extends JPanel {
    private final AppFrame appFrame;
    private final FamilyChatController chatController;
    private JTextArea chatArea;
    private JTextField messageField;
    private final int userId;

    public ChatPanelPanel(AppFrame appFrame, int userId) {
        this.appFrame = appFrame;
        this.userId = userId; // Получаем ID пользователя из AppFrame
        this.chatController = new FamilyChatController();

        setLayout(new BorderLayout());

        chatArea = new JTextArea();
        chatArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(chatArea);
        add(scrollPane, BorderLayout.CENTER);

        JPanel bottomPanel = new JPanel(new BorderLayout());
        messageField = new JTextField();
        JButton sendButton = new JButton("Send");

        bottomPanel.add(messageField, BorderLayout.CENTER);
        bottomPanel.add(sendButton, BorderLayout.EAST);
        add(bottomPanel, BorderLayout.SOUTH);

        sendButton.addActionListener(e -> {
            String message = messageField.getText();
            if (!message.isEmpty()) {
                chatController.sendMessage(new FamilyChat(0, userId, message, new Date()));
                messageField.setText("");
                loadChatMessages();
            }
        });

        loadChatMessages();
    }

    private void loadChatMessages() {
        chatArea.setText("");
        List<FamilyChat> messages = chatController.getAllMessages();
        for (FamilyChat msg : messages) {
            chatArea.append("User " + msg.getUserId() + ": " + msg.getMessage() + "\n");
        }
    }
}
