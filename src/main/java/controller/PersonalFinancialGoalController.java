package controller;

import model.PersonalFinancialGoal;
import model.DatabaseConnector;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PersonalFinancialGoalController {

    public void addFinancialGoal(PersonalFinancialGoal goal) {
        try (Connection conn = DatabaseConnector.getConnection()) {
            String query = "INSERT INTO personal_financial_goal (user_id, total_amount, save_frequency, one_save_amount, achieved) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, goal.getUserId());
            stmt.setDouble(2, goal.getTotalAmount());
            stmt.setString(3, goal.getSaveFrequency());
            stmt.setDouble(4, goal.getOneSaveAmount());
            stmt.setBoolean(5, goal.isAchieved());
            stmt.executeUpdate();
            System.out.println("✅ Личная финансовая цель добавлена.");
        } catch (SQLException e) {
            System.err.println("❌ Ошибка добавления финансовой цели: " + e.getMessage());
        }
    }

    public List<PersonalFinancialGoal> getUserGoals(int userId) {
        List<PersonalFinancialGoal> goals = new ArrayList<>();
        try (Connection conn = DatabaseConnector.getConnection()) {
            String query = "SELECT * FROM personal_financial_goal WHERE user_id = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, userId);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                goals.add(new PersonalFinancialGoal(
                        rs.getInt("id"),
                        rs.getInt("user_id"),
                        rs.getDouble("total_amount"),
                        rs.getString("save_frequency"),
                        rs.getDouble("one_save_amount"),
                        rs.getBoolean("achieved")
                ));
            }
        } catch (SQLException e) {
            System.err.println("❌ Ошибка получения целей: " + e.getMessage());
        }
        return goals;
    }
}
