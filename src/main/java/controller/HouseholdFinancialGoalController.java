package controller;

import model.HouseholdFinancialGoal;
import model.DatabaseConnector;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class HouseholdFinancialGoalController {

    public void addHouseholdGoal(HouseholdFinancialGoal goal) {
        try (Connection conn = DatabaseConnector.getConnection()) {
            String query = "INSERT INTO household_financial_goal (title, total_amount, achieved) VALUES (?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, goal.getTitle());
            stmt.setDouble(2, goal.getTotalAmount());
            stmt.setBoolean(3, goal.isAchieved());
            stmt.executeUpdate();
            System.out.println("✅ Семейная финансовая цель добавлена.");
        } catch (SQLException e) {
            System.err.println("❌ Ошибка добавления семейной цели: " + e.getMessage());
        }
    }

    public List<HouseholdFinancialGoal> getAllGoals() {
        List<HouseholdFinancialGoal> goals = new ArrayList<>();
        try (Connection conn = DatabaseConnector.getConnection()) {
            String query = "SELECT * FROM household_financial_goal";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                goals.add(new HouseholdFinancialGoal(
                        rs.getInt("id"),
                        rs.getString("title"),
                        rs.getDouble("total_amount"),
                        rs.getBoolean("achieved")
                ));
            }
        } catch (SQLException e) {
            System.err.println("❌ Ошибка получения семейных целей: " + e.getMessage());
        }
        return goals;
    }
}
