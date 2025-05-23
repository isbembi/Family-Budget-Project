package controller;

import model.FamilyChat;
import model.DatabaseConnector;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FamilyChatController {
    public void sendMessage(String message) {
        try (Connection conn = DatabaseConnector.getConnection()) {
            String query = "INSERT INTO family_chat VALUES (message)  VALUES (?)";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, message);
            stmt.executeUpdate();
            System.out.println("✅ Сообщение успешно отправлено.");
        } catch (SQLException e) {
            System.err.println("❌ Ошибка отправки сообщения: " + e.getMessage());
        }
    }

    public List<FamilyChat> getAllMessagesWithUserNames() {
        List<FamilyChat> messages = new ArrayList<>();
        try (Connection conn = DatabaseConnector.getConnection()) {
            String query = "SELECT message, created_at FROM family_chat ORDER BY created_at DESC";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                messages.add(new FamilyChat(
                        rs.getString("message"),
                        rs.getDate("created_at")
                ));
            }
        } catch (SQLException e) {
            System.err.println("❌ Ошибка получения сообщений: " + e.getMessage());
        }
        return messages;
    }
}
