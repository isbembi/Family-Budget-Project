package controller;

import model.FamilyChat;
import model.DatabaseConnector;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FamilyChatController {

    public void sendMessage(FamilyChat chat) {
        try (Connection conn = DatabaseConnector.getConnection()) {
            String query = "INSERT INTO family_chat (user_id, message, created_at) VALUES (?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, chat.getUserId());
            stmt.setString(2, chat.getMessage());
            stmt.setTimestamp(3, new Timestamp(new Date().getTime()));
            stmt.executeUpdate();
            System.out.println("✅ Сообщение отправлено.");
        } catch (SQLException e) {
            System.err.println("❌ Ошибка отправки сообщения: " + e.getMessage());
        }
    }

    public List<FamilyChat> getAllMessages() {
        List<FamilyChat> messages = new ArrayList<>();
        try (Connection conn = DatabaseConnector.getConnection()) {
            String query = "SELECT * FROM family_chat ORDER BY created_at DESC";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                messages.add(new FamilyChat(
                        rs.getInt("id"),
                        rs.getInt("user_id"),
                        rs.getString("message"),
                        rs.getTimestamp("created_at")
                ));
            }
        } catch (SQLException e) {
            System.err.println("❌ Ошибка получения сообщений: " + e.getMessage());
        }
        return messages;
    }
}
